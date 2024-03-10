package com.aliboo.security.Controller.Response;

import lombok.*;

import java.io.Serializable;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorResponse {
  private TipoError error;
}