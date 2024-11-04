package com.honeywell.intelligrated.wes.annotation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
@EnableAspectJAutoProxy(exposeProxy=true)
public class AopConfig {
    // Enables AOP for internal calls in the dev environment only
}

