package com.example.avalicao04.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.avalicao04.dto.PaymentDto;
import com.example.avalicao04.form.OrderForm;
import com.example.avalicao04.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@PostMapping
	public ResponseEntity<?> receberPedido(@RequestBody @Valid OrderForm orderForm){
		return ResponseEntity.ok(orderForm);
	}
	
	@GetMapping
	public ResponseEntity<List<PaymentDto>> listarPedidos(){
		List<PaymentDto> paymentsDto = paymentService.showAllPayments();
		return ResponseEntity.ok(paymentsDto);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<PaymentDto> listarPedidoId(@PathVariable Long id){
		return paymentService.showOnePayment(id);
	}
}
