package com.xiongchun.zookeeper.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/zkp")
@Slf4j
public class ZookeeperController {

  @RequestMapping(value = "/zkport")
  public String paymentzk() {
    return "springcloud with zookeeper:8004";
  }
}
