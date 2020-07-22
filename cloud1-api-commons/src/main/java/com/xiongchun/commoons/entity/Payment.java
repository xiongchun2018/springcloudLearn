package com.xiongchun.commoons.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {
  private static final long serialVersionUID = -2845330293504632174L;
  private Long id;
  private String serial;

  public Payment(String serial) {
    this.serial = serial;
  }
}
