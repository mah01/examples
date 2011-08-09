package dk.sorokin.maksim.dosgiRemote.internal.service;

import dk.sorokin.maksim.dosgiRemote.service.api.Greeter;

public class GreeterImpl implements Greeter {

  public String sayHello(String name) {
    return "Hello, " + name;
  }
}