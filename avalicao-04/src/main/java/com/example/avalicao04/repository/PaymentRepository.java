package com.example.avalicao04.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.avalicao04.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long>{}
