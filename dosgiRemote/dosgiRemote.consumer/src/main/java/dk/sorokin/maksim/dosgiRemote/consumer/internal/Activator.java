package dk.sorokin.maksim.dosgiRemote.consumer.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import dk.sorokin.maksim.dosgiRemote.service.api.Greeter;

public class Activator implements BundleActivator {

  @Override
  public void start(BundleContext context) throws Exception {
    ServiceTracker serviceTracker = new ServiceTracker(context, Greeter.class.getName(), null) {
      @Override
      public Object addingService(ServiceReference reference) {
        Object result = super.addingService(reference);

        Object svc = context.getService(reference);
        if (svc instanceof Greeter) {
          final Greeter greeter = (Greeter) svc;
          System.out.println(greeter.sayHello("Max"));
        }

        return result;
      }
    };
    serviceTracker.open();
  }

  public void stop(BundleContext context) throws Exception {
    //
  }
}