package ch.hearc.ig.odi.injection;

import ch.hearc.ig.odi.service.MockPersistence;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

/**
 * Performs the singleton binding for the RestService mockup persistence object.
 */
public class ServiceBinder extends AbstractBinder{

  @Override
  protected void configure() {
    bind(new MockPersistence()).to(MockPersistence.class);
  }
}
