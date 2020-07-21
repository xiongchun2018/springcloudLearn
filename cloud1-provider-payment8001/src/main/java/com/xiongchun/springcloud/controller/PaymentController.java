package com.xiongchun.springcloud.controller;

import com.xiongchun.springcloud.entity.CommonsResult;
import com.xiongchun.springcloud.entity.Payment;
import com.xiongchun.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
  @Resource
  private PaymentService paymentService;

  @PostMapping("/create")
  @ResponseBody
  public CommonsResult<Integer> createPayment(Payment payment) {
    log.info("PaymentController -> createPayment接受到的参数是{}",payment);
    Integer integer = paymentService.createPayment(payment);
    log.info("PaymentController -> createPayment返回的结果是{}",integer);
    if(integer > 0){
      return new CommonsResult(401,"新增成功",integer);
    }else {
      return new CommonsResult(401,"新增失败");
    }

  }

  @GetMapping("/findall")
  @ResponseBody
  public CommonsResult<List<Payment>> findAllPayment() {
    List<Payment> allPayment = paymentService.findAllPayment();
    log.info("PaymentController -> findAllPayment查询所有的结果集{}",allPayment);
    if (allPayment != null && allPayment.size()>0) {
      int i = 10/0;
      return new CommonsResult(200,"查询成功",allPayment);
    } else {
      return new CommonsResult(401,"查询失败");
    }

  }

  @GetMapping("/findbyId/{id}")
  public @ResponseBody CommonsResult<Payment> findPaymentById(@PathVariable("id") Long id) {
    log.info("PaymentController -> findPaymentById需要查询的id是{}",id);
    Payment payment = paymentService.findPaymentById(id);
    log.info("PaymentController -> findPaymentById根据id查到的结果{}",payment);
    if (payment != null) {
      return new CommonsResult(200,"查询成功",payment);
    } else {
      return new CommonsResult(401,"查询失败");
    }
  }
}
