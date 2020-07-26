package com.xiongchun.consul.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author EiletXie
 * @Since 2020/3/10 20:04
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @RequestMapping(value = "/consul")
    public String paymentConsul() {
        return "springcloud with consul: 8006" ;
    }
}
