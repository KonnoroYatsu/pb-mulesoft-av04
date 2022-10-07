package com.example.avalicao04.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DocumentType {
	CPF("cpf"),
	CNPJ("cnpj");
    
    private final String name;
}
