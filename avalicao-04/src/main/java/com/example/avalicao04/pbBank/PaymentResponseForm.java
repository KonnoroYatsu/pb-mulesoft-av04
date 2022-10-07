package com.example.avalicao04.pbBank;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor @NoArgsConstructor
public class PaymentResponseForm {
    @NotNull @JsonProperty("payment_id")
    private String paymentId;
    
    @NotNull @JsonProperty("seller_id")
    private String sellerId;
    
    @NotNull @JsonProperty("transaction_amount")
    private Double transactionAmount;
    
    @NotNull @JsonProperty("currency")
    private String currency;
    
    @NotNull @JsonProperty("status")
    private String status;
    
    @NotNull @JsonProperty("received_at")
    private String receivedAt;
    
    @NotNull @JsonProperty("authorization")
    private Authorization authorization;
}
