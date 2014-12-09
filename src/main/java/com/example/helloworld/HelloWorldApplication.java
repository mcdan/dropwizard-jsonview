package com.example.helloworld;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.example.helloworld.resources.HelloWorldResource;
import com.example.helloworld.health.TemplateHealthCheck;
import io.dropwizard.views.ViewBundle;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle());
    }

    @Override
    public void run(HelloWorldConfiguration configuration,
                    Environment environment) {
	    final HelloWorldResource resource = new HelloWorldResource(
            configuration.getTemplate(),
    		configuration.getDefaultName());
    	environment.jersey().register(resource);
    
    	final TemplateHealthCheck healthCheck =
    	    new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
    }

}