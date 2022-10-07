package com.example.avalicao04.pbBank;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor @NoArgsConstructor
public class Authorization {
    @NotNull @JsonProperty("authorization_code")
    private Long authorizationCode;
    
    @NotNull @JsonProperty("authorized_at")
    private String authorizationnAt;
    
    @NotNull @JsonProperty("reason_code")
    private Long reasonCode;
    
    @NotNull @JsonProperty("reason_message")
    private String reasonMessage;
}
