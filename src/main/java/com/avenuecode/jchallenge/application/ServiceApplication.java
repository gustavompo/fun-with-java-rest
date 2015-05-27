package com.avenuecode.jchallenge.application;

import org.glassfish.jersey.server.ResourceConfig;

public class ServiceApplication  extends ResourceConfig {

	public ServiceApplication(){
		packages("com.avenuecode.jchallenge");
	}
}
