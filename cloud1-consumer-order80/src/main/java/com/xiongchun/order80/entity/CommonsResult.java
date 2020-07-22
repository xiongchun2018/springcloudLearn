package com.xiongchun.order80.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonsResult<T> {
  private Integer code;
  private String message;
  private T data;

  public CommonsResult(Integer code, String message) {
    this(code, message, null);
  }
}
