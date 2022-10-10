package com.example.avalicao04.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Brand {
	MASTERCARD("mastercard"),
	VISA("visa"),
	ELO("elo"),
	AMERICAN_EXPRESS("american-express");
    
    private final String name;
}
