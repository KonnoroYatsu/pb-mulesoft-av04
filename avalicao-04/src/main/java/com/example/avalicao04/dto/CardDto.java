package com.example.avalicao04.dto;

import com.example.avalicao04.constant.Brand;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CardDto {
    @JsonProperty("number_token")
    private String cardNumber;
    
    @JsonProperty("cardholder_name")
    private String cardholderName;

    @JsonProperty("security_code")
    private String securityCode;
    
    @JsonProperty("expiration_month")
    private int expirationMonth;

    @JsonProperty("expiration_year")
    private String expirationYear;

    @JsonProperty("brand")
    private Brand brand;
}
