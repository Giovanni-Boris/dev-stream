package com.aliboo.security.Controller;

import com.aliboo.security.Controller.Request.AuthenticationRequest;
import com.aliboo.security.Controller.Request.UserRequest;
import com.aliboo.security.Controller.Response.AuthenticationResponse;
import com.aliboo.security.Controller.Response.UserResponse;
import com.aliboo.security.Controller.Wrapper.WrapperGenericoObject;
import com.aliboo.security.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
  private final AuthenticationService authenticationService;
  @PostMapping("/register")
  public ResponseEntity<WrapperGenericoObject<AuthenticationResponse>> register(
    @RequestBody WrapperGenericoObject<UserRequest> request
    ){
    return ResponseEntity.ok(WrapperGenericoObject.<AuthenticationResponse>builder()
      .data(authenticationService.register(request.getData()))
      .build());
  }
  @PostMapping("/authenticate")
  public  ResponseEntity<WrapperGenericoObject<AuthenticationResponse>> authenticate(
    @RequestBody WrapperGenericoObject<AuthenticationRequest> request
  ){
    return ResponseEntity.ok(WrapperGenericoObject.<AuthenticationResponse>builder()
      .data(authenticationService.authenticate(request.getData()))
      .build());
  }
}
