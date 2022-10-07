package com.example.avalicao04.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class OrderForm {
	@NotNull (message = "cpf must not be null")
	@NotEmpty (message = "cpf must not be empty")
	@JsonProperty("cpf")
	private String cpf;
	
	@NotNull (message = "items must not be null")
	@NotEmpty (message = "items must not be empty")
	@Valid
	@JsonProperty("items")
	private List<ItemForm> items = new ArrayList<>();
	
	@NotNull (message = "shipping must not be null")
	@Positive(message = "shipping must be greater than 0")
	@JsonProperty("shipping")
	private Double shipping;
	
	@NotNull (message = "discount must not be null")
	@Positive(message = "discount must be greater than 0")
	@JsonProperty("discount")
	private Double discount;
	
	@NotNull (message = "payment_type must not be null")
	@NotEmpty (message = "payment_type must not be empty")
	@JsonProperty("payment_type")
	private String paymentType;
	
	@NotNull (message = "currency_type must not be null")
	@NotEmpty (message = "currency_type must not be empty")
	@JsonProperty("currency_type")
	private String currency;
	
	@NotNull (message = "payment must not be null")
	@Valid
	@JsonProperty("payment")
	private CardForm card;
}
