package com.netflix.sunjeetsonboardingroot.startup;

import com.google.inject.AbstractModule;
// Common module dependencies
import com.google.inject.Provides;
import com.netflix.archaius.ConfigProxyFactory;
import javax.inject.Singleton;
import javax.inject.Named;

// Server dependencies
import com.netflix.runtime.health.guice.HealthModule;
import com.netflix.runtime.lifecycle.RuntimeCoreModule;
import javax.inject.Named;

import com.netflix.sunjeetsonboardingroot.config.SunjeetsOnboardingRootConfig;
import com.netflix.sunjeetsonboardingroot.health.CustomHealthIndicator;
import com.netflix.sunjeetsonboardingroot.model.SunjeetsOnboardingRootInMemoryDao;
import com.netflix.sunjeetsonboardingroot.model.SunjeetsOnboardingRootDao;


import com.netflix.runtime.swagger.jaxrs.JaxrsSwaggerModule;
import com.netflix.runtime.swagger.servlets.GuiceServletSwaggerModule;
import com.netflix.runtime.swagger.lifecycle.SwaggerServletModule;

/**
 * This is the "main" module where we wire everything up. If you see this module getting overly
 * complex, it's a good idea to break things off into separate ones and install them here instead.
 *
 * @author This file is auto-generated by runtime@netflix.com. Feel free to modify.
 */

public final class SunjeetsOnboardingRootModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new RuntimeCoreModule());
        install(new HealthModule() {
            @Override
            protected void configureHealth() {
                bindAdditionalHealthIndicator().to(CustomHealthIndicator.class);
            }
        });
        install(new JerseyModule());
        
        install(new SwaggerServletModule());
        install(new JaxrsSwaggerModule());
        install(new GuiceServletSwaggerModule());
        
        // Uncomment to load the Cassandra client
        // install(new CassandraModule());

        bind(SunjeetsOnboardingRootDao.class).to(SunjeetsOnboardingRootInMemoryDao.class);
        // Swap this for the InMemoryDao bind above to use the Cassandra client instead
        // bind(SunjeetsOnboardingRootDao.class).to(SunjeetsOnboardingRootCassandraDao.class);
    }

    @Provides
    @Singleton
    SunjeetsOnboardingRootConfig getSunjeetsOnboardingRootConfig(ConfigProxyFactory factory) {
        // Here we turn the config interface into an implementation that can load dynamic properties.
        return factory.newProxy(SunjeetsOnboardingRootConfig.class);
    }
}
