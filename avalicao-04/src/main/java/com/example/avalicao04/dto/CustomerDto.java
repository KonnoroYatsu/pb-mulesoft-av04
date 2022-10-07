package com.example.avalicao04.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CustomerDto {
    @NotNull @JsonProperty("document_type")
    private String documentType;
    
    @NotNull @JsonProperty("document_number")
    private Long documentNumber;
}
