package info.sayederfanarefin.hellostream.impl;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;

import info.sayederfanarefin.hello.api.HelloService;
import info.sayederfanarefin.hellostream.api.HelloStreamService;

/**
 * The module that binds the HelloStreamService so that it can be served.
 */
public class HelloStreamModule extends AbstractModule implements ServiceGuiceSupport {
    @Override
    protected void configure() {
        // Bind the HelloStreamService service
        bindService(HelloStreamService.class, HelloStreamServiceImpl.class);
        // Bind the HelloService client
        bindClient(HelloService.class);
        // Bind the subscriber eagerly to ensure it starts up
        bind(HelloStreamSubscriber.class).asEagerSingleton();
    }
}
