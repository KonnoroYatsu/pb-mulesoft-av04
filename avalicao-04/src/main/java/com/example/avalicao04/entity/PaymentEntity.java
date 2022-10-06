package com.example.avalicao04.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.avalicao04.constant.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name = "payment")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class PaymentEntity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long OrderId;
	
	@NotNull
	private Double total;
	
	@NotNull
	private String paymentId;
	
	@NotNull @Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	
	@NotNull
	private String message;
}
