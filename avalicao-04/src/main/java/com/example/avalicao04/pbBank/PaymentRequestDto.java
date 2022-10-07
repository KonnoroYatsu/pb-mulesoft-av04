package com.example.avalicao04.pbBank;

import com.example.avalicao04.dto.CardDto;
import com.example.avalicao04.dto.CustomerDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class PaymentRequestDto {
    @JsonProperty("seller_id")
    private String sellerId;
    
    @JsonProperty("customer")
    private CustomerDto customer;
    
    @JsonProperty("payment_type")
    private String paymentType;
    
    @JsonProperty("currency")
    private String currency;
    
    @JsonProperty("transaction_amount")
    private Double transactionAmount;
    
    @JsonProperty("card")
    private CardDto payment;
}
