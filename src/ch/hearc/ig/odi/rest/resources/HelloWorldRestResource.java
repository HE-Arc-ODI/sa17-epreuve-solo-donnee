package ch.hearc.ig.odi.rest.resources;

import ch.hearc.ig.odi.service.MockPersistence;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Example REST resource using injection of the mock persistence service
 */
@Named
@Path("/helloworld")
public class HelloWorldRestResource {

  @Inject
  private MockPersistence service;

  @GET
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Response sayHello() {
    Response response = Response.ok(service.getQuestions(), MediaType.APPLICATION_JSON).build();
    return response;
  }

}