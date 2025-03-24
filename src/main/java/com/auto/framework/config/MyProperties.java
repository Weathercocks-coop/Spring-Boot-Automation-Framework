package com.auto.framework.config;

import java.time.Duration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ConfigurationProperties("my.properties")
@Component
public class MyProperties {
	private String browser;
	private Duration explicitTimeout;
	private String gridUrl;
	private String gridToken;
	private String username;
	private String password;
	private String grid;
	private String demoUrl;	
}
