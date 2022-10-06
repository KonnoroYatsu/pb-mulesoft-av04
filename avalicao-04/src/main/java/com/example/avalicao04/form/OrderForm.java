package com.example.avalicao04.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.example.avalicao04.model.Item;
import com.example.avalicao04.model.Payment;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class OrderForm {
	@NotNull
	private Long cpf;
	@NotNull
	private List<Item> items = new ArrayList<>();
	@NotNull
	private Float shipping;
	@NotNull
	private Float discount;
	@NotNull @JsonProperty("payment_type")
	private String paymentType;
	@NotNull @JsonProperty("currency_type")
	private String currency;
	@NotNull
	private Payment payment;
}
