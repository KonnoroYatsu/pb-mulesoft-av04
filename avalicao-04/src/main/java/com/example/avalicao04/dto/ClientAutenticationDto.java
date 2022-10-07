package com.example.avalicao04.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ClientAutenticationDto {
    @NotNull @JsonProperty("client_id")
	private String clientId;
    
    @NotNull @JsonProperty("api_key")
	private String apiKey;
}
