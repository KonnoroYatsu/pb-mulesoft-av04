package com.example.avalicao04.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.avalicao04.autentication.SellerAutentication;
import com.example.avalicao04.autentication.Token;
import com.example.avalicao04.dto.CardDto;
import com.example.avalicao04.dto.ClientAutenticationDto;
import com.example.avalicao04.dto.CustomerDto;
import com.example.avalicao04.dto.PaymentDto;
import com.example.avalicao04.entity.PaymentEntity;
import com.example.avalicao04.form.CardForm;
import com.example.avalicao04.form.OrderForm;
import com.example.avalicao04.pbBank.PaymentRequestDto;
import com.example.avalicao04.pbBank.PaymentResponseForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MappersUtil {

    public static PaymentDto convertPaymentEntityToDto(PaymentEntity paymentEntity) {
        PaymentDto paymentDto = new PaymentDto(
                paymentEntity.getOrderId(),
                paymentEntity.getTotal(),
                paymentEntity.getPaymentId(),
                paymentEntity.getPaymentStatus(),
                paymentEntity.getMessage());
        return paymentDto;
    }

    public static String createPaymentRequestBody(OrderForm orderForm) {
        SellerAutentication sellerAutentication = new SellerAutentication();
        CustomerDto costumerDto = new CustomerDto("CPF", orderForm.getCpf());
        Double total = (double) 0;

        for (int i = 0; i < orderForm.getItems().size(); i++) {
            total += (orderForm.getItems().get(i).getPrice()) * (orderForm.getItems().get(i).getQty());
        }
        total += orderForm.getShipping();
        total -= orderForm.getDiscount();
        total = BigDecimal.valueOf(total).setScale(3, RoundingMode.HALF_UP).doubleValue();

        PaymentRequestDto paymentRequestBody = new PaymentRequestDto(
                sellerAutentication.getSellerId(),
                costumerDto,
                orderForm.getPaymentType(),
                orderForm.getCurrency(),
                total,
                MappersUtil.convertCardFormToDto(orderForm.getCard()));

        ObjectMapper mapper = new ObjectMapper();
        String paymentRequestBodyToJSON = new String();
        try {
            paymentRequestBodyToJSON = mapper.writeValueAsString(paymentRequestBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return paymentRequestBodyToJSON;
    }

    public static HttpHeaders createPaymentRequestHeader(Token token) {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.add("Authorization", "Bearer " + token.getAccessToken());
        return header;
    }

    public static PaymentResponseForm sendPaymentRequest(String paymentRequestBodyJSON,
            HttpHeaders paymentRequestHeader) {
        RestTemplate rest = new RestTemplate();
        String url = "https://pb-getway-payment.herokuapp.com/v1/payments/credit-card";

        HttpEntity<String> httpEntity = new HttpEntity<String>(paymentRequestBodyJSON, paymentRequestHeader);
        ResponseEntity<PaymentResponseForm> response = rest.exchange(url, HttpMethod.POST, httpEntity,
                PaymentResponseForm.class);
        return response.getBody();
    }

    public static PaymentEntity convertPaymentResponseFormToPaymentEntity(PaymentResponseForm paymentResponseForm) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setTotal(paymentResponseForm.getTransactionAmount());
        paymentEntity.setPaymentId(paymentResponseForm.getPaymentId());
        paymentEntity.setPaymentStatus(paymentResponseForm.getStatus());
        paymentEntity.setMessage(paymentResponseForm.getAuthorization().getReasonMessage());
        return paymentEntity;
    }

    public static CardDto convertCardFormToDto(CardForm cardForm) {
        CardDto cardDto = new CardDto(
                cardForm.getCardNumber(),
                cardForm.getCardholderName(),
                cardForm.getSecurityCode(),
                cardForm.getExpirationMonth(),
                cardForm.getExpirationYear(),
                cardForm.getBrand());
        return cardDto;
    }

    public static Token authenticate() {
        String url = "https://pb-getway-payment.herokuapp.com/v1/auth";
        RestTemplate restTemplate = new RestTemplate();
        SellerAutentication sellerAutentication = new SellerAutentication();

        ClientAutenticationDto clientAutenticationDto = new ClientAutenticationDto(
                sellerAutentication.getSellerClientId(),
                sellerAutentication.getSellerApiKey());

        ResponseEntity<Token> auth = restTemplate.postForEntity(url, clientAutenticationDto, Token.class);
        Token token = auth.getBody();

        return token;
    }
}
