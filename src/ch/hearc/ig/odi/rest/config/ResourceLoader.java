package ch.hearc.ig.odi.rest.config;

import ch.hearc.ig.odi.injection.ServiceBinder;
import ch.hearc.ig.odi.injection.ServiceFeature;
import ch.hearc.ig.odi.rest.resources.HelloWorldRestResource;
import ch.hearc.ig.odi.service.MockPersistence;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Registers all resources with Jersey
 */
public class ResourceLoader extends ResourceConfig {

  public ResourceLoader() {
    register(HelloWorldRestResource.class);
    register(MockPersistence.class);
    register(ServiceFeature.class);
    registerInstances(new ServiceBinder());
  }

}