package com.example.avalicao04.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentStatus {
	APPROVED("approved"),
	REPROVED("reproved");
    
    private final String name;
}
