package com.example.avalicao04.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Payment {
	@NotNull @JsonProperty("card_number")
	private Long cardNumber;
	@NotNull @JsonProperty("cardholder_name")
	private String cardholderName;
	@NotNull @JsonProperty("security_code")
	private int securityCode;
	@NotNull @JsonProperty("expiration_month")
	private int expirationMonth;
	@NotNull @JsonProperty("expiration_year")
	private int expirationYear;
	@NotNull
	private String brand;
}
