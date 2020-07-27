package com.xiongchun.order80.mylb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface MyLoadBalancerInterface {
  ServiceInstance instances();
}
