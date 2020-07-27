package com.xiongchun.openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PaymentOpenFeignMain80 {
  public static void main(String[] args) {
    SpringApplication.run(PaymentOpenFeignMain80.class,args);
  }
}
