package com.example.avalicao04.dto;

import com.example.avalicao04.constant.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class PaymentDto {
	private Long OrderId;
	private Double total;
	private String paymenteId;
	private PaymentStatus paymentStatus;
	private String message;
}
