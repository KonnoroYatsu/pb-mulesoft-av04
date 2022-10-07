package com.example.avalicao04.autentication;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Token {
    @NotNull @JsonProperty("access_token")
	private String accessToken;
    
    @NotNull @JsonProperty("token_type")
	private String tokenType;
    
    @NotNull @JsonProperty("expires_in")
	private String expiresIn;
}
