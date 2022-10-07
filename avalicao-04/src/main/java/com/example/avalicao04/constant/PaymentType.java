package com.example.avalicao04.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentType {
	CREDIT_CARD("credit_card");
    
    private final String name;
}
