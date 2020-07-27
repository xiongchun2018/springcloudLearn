package com.xiongchun.order80.mylb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class MyLoadBalancerImpl implements MyLoadBalancerInterface {

  @Autowired
  private DiscoveryClient discoveryClient;

  //定义一个全局的计数器
  private AtomicInteger atomicInteger = new AtomicInteger(0);

  /**
   * 获取服务器
   * @return 返回 经过 计算后 确定需要访问的 服务器
   */
  @Override
  public ServiceInstance instances() {
    //所有服务器对象
    List<ServiceInstance> serviceInstance = getServiceInstance();
    //当前访问次数 % 总服务器数量 = 实际需要访问的服务器下标
    //核心 算法
    int instaceIndex = getInstaceIndex() % serviceInstance.size();
    log.info("经过自己算法，决定去--->  {}  <---号index的服务器，名称是--->  {}",instaceIndex,serviceInstance.get(instaceIndex).getScheme());
    log.info("经过自己算法，决定去 serviceInstance-URI --->  {}", serviceInstance.get(instaceIndex).getUri());
    return serviceInstance.get(instaceIndex);
  }

  /**
   * 核心思想
   * 计算 到底如何 负载均衡
   * @return 最终需要服务器的下标
   */
  private  int getInstaceIndex(){
    int current, next;
    do {
      //获取 已经访问了多少次了
      current = atomicInteger.get();
      //设值下次访问的次数
      next = current >= Integer.MAX_VALUE ? 0 : current+1;
      //compareAndSet  当前值 预期值---如果设值成功就返回true  这里 取反 则表示 设值成功 就 断掉 循环
    }while (!this.atomicInteger.compareAndSet(current,next));
    return next;
  }

  /**
   * 理当传来 服务名---或者根据 业务 找到对应服务名
   * @return 根据服务名 获取当前服务名 下的所有 服务器
   */
  private List<ServiceInstance> getServiceInstance(){
//    List<String> services = discoveryClient.getServices();
    return discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
  }
}
