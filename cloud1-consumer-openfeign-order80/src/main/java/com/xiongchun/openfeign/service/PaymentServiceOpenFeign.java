package com.xiongchun.openfeign.service;

import com.xiongchun.commoons.entity.CommonsResult;
import com.xiongchun.commoons.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentServiceOpenFeign {
//  特别注意  这里需要的是 服务器接口访问的 全部路径 也就相当于与上面服务名拼接成  CLOUD-PAYMENT-SERVICE/payment/findbyId/{id}
//  所以下面这个路径不是乱写的  是服务器 那边 已经写好了的路径
  @GetMapping("/payment/findbyId/{id}")
  CommonsResult<Payment> findPaymentById(@PathVariable("id") Long id);
}
