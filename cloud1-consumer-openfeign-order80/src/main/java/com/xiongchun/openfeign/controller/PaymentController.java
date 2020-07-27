package com.xiongchun.openfeign.controller;

import com.xiongchun.commoons.entity.CommonsResult;
import com.xiongchun.commoons.entity.Payment;
import com.xiongchun.openfeign.service.PaymentServiceOpenFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.annotations.Instantiator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/openfeign")
public class PaymentController {

  @Autowired
  private PaymentServiceOpenFeign serviceOpenFeign;

  @GetMapping("/findbyId/{id}")
  public CommonsResult<Payment> findPaymentById(@PathVariable("id") Long id){
    CommonsResult<Payment> paymentById = serviceOpenFeign.findPaymentById(id);
    return paymentById;
  };
}
