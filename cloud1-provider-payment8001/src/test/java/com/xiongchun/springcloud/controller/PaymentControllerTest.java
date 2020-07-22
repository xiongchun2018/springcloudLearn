package com.xiongchun.springcloud.controller;

import com.xiongchun.commoons.entity.CommonsResult;
import com.xiongchun.commoons.entity.Payment;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentControllerTest {

  @Autowired
  private PaymentController paymentController;
  @Test
  public void createPayment() {
//    Payment payment = new Payment("1003");
    Payment payment = new Payment("1005");
    CommonsResult commonsResult = paymentController.createPayment(payment);
  }

  @Test
  public void findAllPayment() {
    CommonsResult<List<Payment>> allPayment = paymentController.findAllPayment();
    Assert.assertNotNull(allPayment);
  }

  @Test
  public void findPaymentById() {
    CommonsResult<Payment> paymentById = paymentController.findPaymentById(3L);
    Assert.assertNotNull(paymentById);
  }
}