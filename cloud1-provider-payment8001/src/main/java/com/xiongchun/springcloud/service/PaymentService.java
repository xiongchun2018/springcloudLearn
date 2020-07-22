package com.xiongchun.springcloud.service;

import com.xiongchun.commoons.entity.Payment;

import java.util.List;

public interface PaymentService {
  /**
   * 插入一条数据
   * @param payment 需要插入的数据
   * @return 插入是否成功
   */
  public Integer createPayment(Payment payment);

  /**
   * 查询 所有 Payment列表
   * @return 返回所有payment
   */
  public List<Payment> findAllPayment();
  /**
   * @param id 需要查询的ID
   * @return 根据ID查询的Payment
   */
  public Payment findPaymentById(Long id);
}
