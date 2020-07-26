package com.xiongchun.consul.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
  private static  final String PAYMENT_URL = "http://consul-provider-payment";

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping(value = "/consumer/consul")
  public String paymentInfo() {
    String result = restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
    result += "<-----前面的属于从8006获取到=================这些都是80自己拼接的！";
    return result;
  }
}
