package com.example.avalicao04.form;

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
public class ItemForm {
    @NotNull (message = "item must not be null")
    @NotEmpty (message = "item must not be empty")
	@JsonProperty("item")
	private String item;
	
	@NotNull (message = "value must not be null")
	@Positive(message = "value must be greater than 0")
	@JsonProperty("value")
	private Double price;
	
	@NotNull (message = "qty must not be null")
	@Positive(message = "qty must be greater than 0")
	@JsonProperty("qty")
	private int qty;
}
