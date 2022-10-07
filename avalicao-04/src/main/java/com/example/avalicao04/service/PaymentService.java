package com.example.avalicao04.service;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.avalicao04.autentication.Token;
import com.example.avalicao04.dto.PaymentDto;
import com.example.avalicao04.entity.PaymentEntity;
import com.example.avalicao04.form.OrderForm;
import com.example.avalicao04.pbBank.PaymentResponseForm;
import com.example.avalicao04.repository.PaymentRepository;
import com.example.avalicao04.util.MappersUtil;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	private Token token;
	private LocalDateTime tokenExpirationTime;
		
	public List<PaymentDto> showAllPayments() {
		List<PaymentEntity> paymentsEntity = paymentRepository.findAll();
		List<PaymentDto> paymentsDto = new ArrayList<>();
		for(int i = 0; i < paymentsEntity.size(); i++) {
			paymentsDto.add(MappersUtil.convertPaymentEntityToDto(paymentsEntity.get(i)));
		}
		return paymentsDto;
	}

	public ResponseEntity<PaymentDto> showOnePayment(Long id) {
		Optional<PaymentEntity> paymentEntity = paymentRepository.findById(id);
		if(paymentEntity.isPresent()) {
			PaymentDto paymentDto = MappersUtil.convertPaymentEntityToDto(paymentEntity.get());
			return ResponseEntity.ok(paymentDto);
		}
		return ResponseEntity.notFound().build();
	}
	
	public ResponseEntity<PaymentEntity> makePayment(OrderForm orderForm, UriComponentsBuilder uriBuilder) {	
		if(token == null || tokenExpirationTime.compareTo(LocalDateTime.now()) < 0) {
		    token = MappersUtil.authenticate();
	        tokenExpirationTime = LocalDateTime.now().plusMinutes(3);
		}
		String paymentRequestBodyJSON = MappersUtil.createPaymentRequestBody(orderForm);
		HttpHeaders paymentRequestHeader = MappersUtil.createPaymentRequestHeader(token);
		PaymentResponseForm paymentResponseForm = MappersUtil.sendPaymentRequest(paymentRequestBodyJSON, paymentRequestHeader);
		PaymentEntity paymentEntity = MappersUtil.convertPaymentResponseFormToPaymentEntity(paymentResponseForm);
		paymentRepository.save(paymentEntity);
		
		URI uri = uriBuilder.path("/{id}").buildAndExpand(paymentEntity.getOrderId()).toUri();
		return ResponseEntity.created(uri).body(paymentEntity);    
	}
}
