package com.example.avalicao04.form;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ItemForm {
	@NotNull @JsonProperty("item")
	private String item;
	
	@NotNull @JsonProperty("value")
	private Double price;
	
	@NotNull @JsonProperty("qty")
	private int qty;
}
