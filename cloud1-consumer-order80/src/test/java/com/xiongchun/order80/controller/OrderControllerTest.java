package com.xiongchun.order80.controller;

import com.xiongchun.order80.entity.CommonsResult;
import com.xiongchun.order80.entity.Payment;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderControllerTest {

  @Autowired
  private OrderController orderController;

  @Test
  public void createPayment() {
    Payment payment = new Payment("10014");

    CommonsResult<Integer> payment1 = orderController.createPayment(payment);
    Assert.assertNotNull(payment1);
  }

  @Test
  public void findPaymentById() {
    CommonsResult<Payment> paymentById = orderController.findPaymentById(3l);
    Assert.assertNotNull(paymentById);
  }
}