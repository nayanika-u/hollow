package com.netflix.sunjeetsonboardingroot.config;

import com.netflix.archaius.api.annotations.Configuration;
import com.netflix.archaius.api.annotations.DefaultValue;

/**
 * This is the root config of the service. Simply inject it to constructors of any objects you
 * need to configure. To benefit from dynamic properties simply call the method to retrieve the
 * property value in your "hot path" code. No need to store it in a local or class variable.
 *
 * Check out the application.properties file to see how they can be set as properties.
 *
 * @author This file is auto-generated by runtime@netflix.com. Feel free to modify.
 */
@Configuration(prefix = "sunjeetsonboardingroot.config")
public interface SunjeetsOnboardingRootConfig {
    /**
     * @return The default name if we don't have a real user first name.
     */
    @DefaultValue("Netflix Fan")
    String getDefaultAnonymousName();

    /**
     * @return The default greeting for everyone.
     */
    @DefaultValue("Welcome to the Matrix")
    String getDefaultGreeting();

    /**
     * If we want to send a loud greeting we turn
     * "Hello, Bob" to "HELLO, BOB" using this flag.
     *
     * @return Whether greetings should be loud
     */
    @DefaultValue("false")
    boolean isLoudGreeting();
}
