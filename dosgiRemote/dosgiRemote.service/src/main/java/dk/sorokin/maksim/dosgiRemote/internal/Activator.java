package dk.sorokin.maksim.dosgiRemote.internal;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import dk.sorokin.maksim.dosgiRemote.internal.service.GreeterImpl;
import dk.sorokin.maksim.dosgiRemote.service.api.Greeter;

public class Activator implements BundleActivator {

  public void start(BundleContext context) throws Exception {
    Dictionary<String, String> restProps = new Hashtable<String, String>();

    restProps.put("service.exported.interfaces", "*");
    restProps.put("service.exported.configs", "org.apache.cxf.rs");
    restProps.put("service.exported.intents", "HTTP");
    restProps.put("org.apache.cxf.rs.address", "http://localhost:8080/");
    context.registerService(Greeter.class.getName(), new GreeterImpl(), restProps);
  }

  public void stop(BundleContext context) throws Exception {
    //
  }
}