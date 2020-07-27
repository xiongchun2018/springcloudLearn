package com.xiongchun.order80.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
  @Bean
//  为了测试自定义 BoadBalance注释掉 默认的 负载均衡策略
//  @LoadBalanced
  public RestTemplate getRestTemplate(){
    return new RestTemplate();
  }
}
