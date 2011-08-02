package dk.sorokin.maksim.dosgiSecurity.impl.internal.service;

import dk.sorokin.maksim.dosgiSecurity.api.HelloService;

public class HelloServiceImpl implements HelloService {

  public String sayHello(String name) {
    return "Hello " + name;
  }
}