package com.example.avalicao04.dto;

import javax.validation.constraints.NotNull;

import com.example.avalicao04.constant.DocumentType;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CustomerDto {
    @NotNull @JsonProperty("document_type")
    private DocumentType documentType;
    
    @NotNull @JsonProperty("document_number")
    private String documentNumber;
}
