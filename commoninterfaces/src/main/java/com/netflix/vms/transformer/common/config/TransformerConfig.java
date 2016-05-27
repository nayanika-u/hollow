package com.netflix.vms.transformer.common.config;

import com.netflix.archaius.api.annotations.Configuration;
import com.netflix.archaius.api.annotations.DefaultValue;
import com.netflix.archaius.api.annotations.PropertyName;

/**
 * This is the root config of the service. Simply inject it to constructors of any objects you
 * need to configure. To benefit from dynamic properties simply call the method to retrieve the
 * property value in your "hot path" code. No need to store it in a local or class variable.
 *
 * Check out the application.properties file to see how they can be set as properties.
 *
 * @author This file is auto-generated by runtime@netflix.com. Feel free to modify.
 */
@Configuration(prefix = "vms")
public interface TransformerConfig {

    @DefaultValue("defaultConverterVip")
    String getConverterVip();


    @DefaultValue("defaultTransformerVip")
    String getTransformerVip();

    String getAwsInstanceId();
    
    
    //////////////// PUBLISH WORKFLOW ///////////////////
    
    @DefaultValue("false")
    public boolean isCircuitBreakersEnabled();

    @DefaultValue("true")
    @PropertyName(name="vms.circuitBreakerEnabled.${0}")
    public boolean isCircuitBreakerEnabled(String ruleName);

    @PropertyName(name="vms.circuitBreakerEnabled.${0}.${1}")
    public Boolean isCircuitBreakerEnabled(String ruleName, String country);

    @DefaultValue("0.05")
    @PropertyName(name="vms.circuitBreakerThreshold.${0}")
    public double getCircuitBreakerThreshold(String ruleName);

    @PropertyName(name="vms.circuitBreakerThreshold.${0}.${1}")
    public Double getCircuitBreakerThreshold(String ruleName, String country);

    @DefaultValue("false")
    public boolean isPlaybackMonkeyEnabled();

    @DefaultValue("US,JP,MX")
    public String getPlaybackMonkeyTestForCountries();

    @DefaultValue("20000")
    public int getPlaybackMonkeyMaxTestVideosSize();

    @DefaultValue("true")
    public boolean shouldFailCycleOnPlaybackMonkeyFailure();

    @DefaultValue("5")
    public int getPlaybackMonkeyMaxRetriesPerTest();

    @DefaultValue("0.01")
    public float getPlaybackMonkeyNoiseTolerance();
    

    /////////////// VMS IOPS (ElasticSearch) ///////////////

    @DefaultValue("true")
    boolean isElasticSearchLoggingEnabled();

    @DefaultValue("es_vmsops")
    String getElasticSearchClusterName();

    @DefaultValue("7102")
    String getElasticSearchDataPort();

    @DefaultValue("7104")
    String getElasticSearchHttpPort();

    @DefaultValue("50s")
    String getElasticSearchNodesSamplerIntervalInSeconds();

    @DefaultValue("true")
    String getElasticSearchTcpCompress();

    @DefaultValue("50s")
    String getElasticSearchTimeoutInSeconds();

    @DefaultValue("50s")
    String getElasticSearchSamplerIntervalInSeconds();

    @DefaultValue("25000")
    int getElasticSearchMaxQueueSize();

    @DefaultValue("6")
    int getElasticSearchMaxTransportThreads();

    @DefaultValue("30000")
    int getElasticSearchQueueTimeoutMillis();

    @DefaultValue("true")
    boolean isElasticSearchNoWaitingEnabled();



}
