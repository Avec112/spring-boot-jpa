package no.avec.config;

import no.avec.controller.HealthController;
import no.avec.controller.PersonJerseyController;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by avec on 25/11/2016.
 */
//@Configuration
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(PersonJerseyController.class);
        register(HealthController.class);

    }
}
