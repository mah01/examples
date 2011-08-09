package dk.sorokin.maksim.dosgiRemote.service.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("greeter")
public interface Greeter {

  @GET
  @Path("sayHello/{name}")
  @Produces(MediaType.TEXT_PLAIN)
  String sayHello(@PathParam("name") String name);
}