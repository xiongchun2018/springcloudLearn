package com.xiongchun.order80.controller;

import com.xiongchun.commoons.entity.CommonsResult;
import com.xiongchun.commoons.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order80")
@Slf4j
public class OrderController {

//  static final String PAYMENT_URL = "http://localhost:8001";
  //provider集群后
  private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/create")
  @ResponseBody
  public CommonsResult<Integer> createPayment(@RequestBody Payment payment) {
    log.info("order80->PaymentController -> createPayment接受到的参数是{}",payment);
//    Map<String,Payment> map = new HashMap<>();
//    map.put("payment",payment);
    CommonsResult commonsResult = restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonsResult.class);

    log.info("order80->PaymentController -> createPayment返回的结果是{}",commonsResult);
    return commonsResult;

  }

  @GetMapping("/findbyId/{id}")
  public @ResponseBody CommonsResult<Payment> findPaymentById(@PathVariable("id") Long id) {
    log.info("order80->PaymentController -> findPaymentById需要查询的id是{}",id);
    String url = PAYMENT_URL+"/payment/findbyId/"+id.toString();
    CommonsResult payment = restTemplate.getForObject(url, CommonsResult.class);
    log.info("order80->PaymentController -> findPaymentById根据id查到的结果{}",payment);
    return payment;
  }


}
