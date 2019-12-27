package com.free.system.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * env
 * @author suwenguang
 * @version 1.0.0
 **/
@ConfigurationProperties(prefix = "env")
@Data
public class EnvironmentProperties {
	private String version;
	private String author;
}
