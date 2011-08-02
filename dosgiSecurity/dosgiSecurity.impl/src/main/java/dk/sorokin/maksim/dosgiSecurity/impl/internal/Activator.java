package dk.sorokin.maksim.dosgiSecurity.impl.internal;

import java.util.Dictionary;
import java.util.Hashtable;

import javax.servlet.Filter;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import dk.sorokin.maksim.dosgiSecurity.api.HelloService;
import dk.sorokin.maksim.dosgiSecurity.impl.internal.service.HelloServiceImpl;
import dk.sorokin.maksim.dosgiSecurity.security.SecurityFilter;

public class Activator implements BundleActivator {

  public void start(BundleContext context) throws Exception {
    Dictionary<String, String> restProps = new Hashtable<String, String>();

    restProps.put("service.exported.interfaces", "*");
    restProps.put("service.exported.configs", "org.apache.cxf.rs");
    restProps.put("service.exported.intents", "HTTP");
    restProps.put("org.apache.cxf.rs.httpservice.context", "/secured");
    restProps.put("org.apache.cxf.rs.address", "http://localhost:8080/");
    context.registerService(HelloService.class.getName(), new HelloServiceImpl(), restProps);

    Dictionary<String, String> filterProps = new Hashtable<String, String>();
    filterProps.put("org.apache.cxf.httpservice.filter", Boolean.TRUE.toString());
    filterProps.put("servletNames", "none");
    context.registerService(Filter.class.getName(), new SecurityFilter(), filterProps);
  }

  public void stop(BundleContext context) throws Exception {
    //
  }
}