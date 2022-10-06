package com.example.avalicao04.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.avalicao04.dto.PaymentDto;
import com.example.avalicao04.entity.PaymentEntity;
import com.example.avalicao04.repository.PaymentRepository;
import com.example.avalicao04.util.MappersUtil;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
		
	public List<PaymentDto> showAllPayments() {
		List<PaymentEntity> paymentsEntity = paymentRepository.findAll();
		List<PaymentDto> paymentsDto = new ArrayList<>();
		for(int i = 0; i < paymentsEntity.size(); i++) {
			paymentsDto.add(MappersUtil.convertPaymentEntityToDto(paymentsEntity.get(i)));
		}
		return paymentsDto;
	}

	public ResponseEntity<PaymentDto> showOnePayment(Long id) {
		Optional<PaymentEntity> paymentEntity = paymentRepository.findById(id);
		if(paymentEntity.isPresent()) {
			PaymentDto paymentDto = MappersUtil.convertPaymentEntityToDto(paymentEntity.get());
			return ResponseEntity.ok(paymentDto);
		}
		return ResponseEntity.notFound().build();
	}
}
