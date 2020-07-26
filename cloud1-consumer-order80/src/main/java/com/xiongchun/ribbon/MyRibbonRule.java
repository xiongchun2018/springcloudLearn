package com.xiongchun.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 该类不能再@ComponentScan所扫描的包下  也就是不能与Main的那个启动类 的包下，必须独立出来
 */
@Configuration
public class MyRibbonRule {
  @Bean
  public IRule getIRule(){
//    随机 路由
    return new RandomRule();
  }
}
