package com.estore.application;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;


@Component
@ApplicationPath("/jersey")
public class JerseyAppConfig extends ResourceConfig {
	
	public JerseyAppConfig() {
//		register(PrimaryEndpoint.class);
		packages("com.estore.endpoint");
	}
}