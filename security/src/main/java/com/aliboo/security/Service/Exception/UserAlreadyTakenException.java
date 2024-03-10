package com.aliboo.security.Service.Exception;


public class UserAlreadyTakenException extends RuntimeException {

  public UserAlreadyTakenException(String message) {
    super("User Name alreafy taken " + message);
  }
}
