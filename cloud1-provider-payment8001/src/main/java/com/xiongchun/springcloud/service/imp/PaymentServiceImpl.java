package com.xiongchun.springcloud.service.imp;

import com.xiongchun.springcloud.dao.PaymentDao;
import com.xiongchun.springcloud.entity.Payment;
import com.xiongchun.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

  @Resource
  private PaymentDao paymentDao;

  @Override
  public Integer createPayment(Payment payment) {
    return paymentDao.createPayment(payment);
  }

  @Override
  public List<Payment> findAllPayment() {
    return paymentDao.findAllPayment();
  }

  @Override
  public Payment findPaymentById(Long id) {
    return paymentDao.findPaymentById(id);
  }
}
