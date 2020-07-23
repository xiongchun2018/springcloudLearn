package com.xiongchun.springcloud.controller;

import com.xiongchun.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import com.xiongchun.commoons.entity.Payment ;
import com.xiongchun.commoons.entity.CommonsResult ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
  @Resource
  private PaymentService paymentService;

  @Autowired
  private DiscoveryClient discoveryClient;

  @PostMapping("/create")
  @ResponseBody
  public CommonsResult<Integer> createPayment( @RequestBody Payment payment) {//必须加上RequestBody否则restTemplate传来的参数，接收不到
    log.info("payment8001--> PaymentController -> createPayment接受到的参数是{}",payment);
    Integer integer = paymentService.createPayment(payment);
    log.info("payment8001--> PaymentController -> createPayment返回的结果是{}",integer);
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
    log.info("payment8001--> PaymentController -> findAllPayment查询所有的结果集{}",allPayment);
    if (allPayment != null && allPayment.size()>0) {
      int i = 10/0;
      return new CommonsResult(200,"查询成功",allPayment);
    } else {
      return new CommonsResult(401,"查询失败");
    }

  }

  @GetMapping("/findbyId/{id}")
  public @ResponseBody CommonsResult<Payment> findPaymentById(@PathVariable("id") Long id) {
    log.info("payment8001--> PaymentController -> findPaymentById需要查询的id是{}",id);
    Payment payment = paymentService.findPaymentById(id);
    log.info("payment8001--> PaymentController -> findPaymentById根据id查到的结果{}",payment);
    if (payment != null) {
      return new CommonsResult(200,"查询成功",payment);
    } else {
      return new CommonsResult(401,"查询失败");
    }
  }

  @GetMapping("/getDiscoveryClientMsg")
  public @ResponseBody CommonsResult getDiscoveryClientMsg(){

    Map<String,Object> discoveryClientMsg = new HashMap<>();
    List<String> sericesLisist = new ArrayList<>();
    //获取所有 服务节点 信息
    List<String> services = discoveryClient.getServices();
    discoveryClientMsg.put("services",services);
    for (String service : services) {
      //获取每个服务 下的 所有实例
      List<ServiceInstance> instances = discoveryClient.getInstances(service);
      discoveryClientMsg.put(service,instances);
    }
    if (discoveryClientMsg .size() > 0) {
        return new CommonsResult(200,"payment8001-发现如下服务信息---->",discoveryClientMsg);
    } else {
      return new CommonsResult(400,"payment8001-无服务信息发现" );
    }
  }
}
