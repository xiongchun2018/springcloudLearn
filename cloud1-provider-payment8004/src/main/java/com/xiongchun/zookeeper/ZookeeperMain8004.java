package com.xiongchun.zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperMain8004 {
  public static void main(String[] args) {
    SpringApplication.run(ZookeeperMain8004.class,args);
  }
}
