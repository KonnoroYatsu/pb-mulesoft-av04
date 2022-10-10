package com.example.avalicao04.dto;

import javax.validation.constraints.NotNull;

import com.example.avalicao04.constant.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class PaymentDto {
    @NotNull @JsonProperty("order_id")
	private Long OrderId;
    
    @NotNull @JsonProperty("total")
	private Double total;
    
    @NotNull @JsonProperty("payment_id")
	private String paymentId;
    
    @NotNull @JsonProperty("payment_status")
	private PaymentStatus paymentStatus;
    
    @NotNull @JsonProperty("message")
	private String message;
}
