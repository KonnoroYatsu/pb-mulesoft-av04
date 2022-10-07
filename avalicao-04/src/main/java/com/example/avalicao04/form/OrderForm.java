package com.example.avalicao04.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class OrderForm {
	@NotNull @JsonProperty("cpf")
	private Long cpf;
	
	@NotNull @JsonProperty("items")
	private List<ItemForm> items = new ArrayList<>();
	
	@NotNull @JsonProperty("shipping")
	private Double shipping;
	
	@NotNull @JsonProperty("discount")
	private Double discount;
	
	@NotNull @JsonProperty("payment_type")
	private String paymentType;
	
	@NotNull @JsonProperty("currency_type")
	private String currency;
	
	@NotNull @JsonProperty("payment")
	private CardForm card;
}
