package com.example.avalicao04.util;

import org.springframework.stereotype.Service;

import com.example.avalicao04.dto.PaymentDto;
import com.example.avalicao04.entity.PaymentEntity;

@Service
public class MappersUtil {
	
	public static PaymentDto convertPaymentEntityToDto(PaymentEntity paymentEntity) {
		PaymentDto paymentDto = new PaymentDto(
				paymentEntity.getOrderId(),
				paymentEntity.getTotal(),
				paymentEntity.getPaymentId(),
				paymentEntity.getPaymentStatus(),
				paymentEntity.getMessage());
		return paymentDto;
	}
}
