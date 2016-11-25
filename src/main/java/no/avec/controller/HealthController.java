package no.avec.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by avec on 25/11/2016.
 */
@Controller
@Path("/health")
public class HealthController {
    @GET
    @Produces("application/json")
    public Health health() {
        return Health.up().build();
    }
}
