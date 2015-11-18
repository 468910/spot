package ica.han.Domain.REST;

/**
 * Created by apple on 05/10/15.
 */

import com.google.inject.Guice;

// NIET GOOGLE FFS
import javax.inject.Inject;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/rest")
class RestResourceConfig extends ResourceConfig {
    public static final String JSON_SERIALIZER = "jersey.config.server.provider.packages";
    public static final String JACKSON_JSON_SERIALIZER = "com.fasterxml.jackson.jaxrs.json;service";

        @Inject
        public RestResourceConfig(
                ServiceLocator serviceLocator) {

            packages("ica.han.Domain.REST");
            GuiceBridge.getGuiceBridge().
                    initializeGuiceBridge(serviceLocator);
            GuiceIntoHK2Bridge guiceBridge =
                    serviceLocator.getService(
                            GuiceIntoHK2Bridge.class);
            guiceBridge.bridgeGuiceInjector(
                    Guice.createInjector(
                            new MyServletModule()));

        }




    /*
    public RestResourceConfig(
        ){
        packages(true, "ica.han.Domain.REST");
        property(JSON_SERIALIZER, JACKSON_JSON_SERIALIZER);

    }*/


}

