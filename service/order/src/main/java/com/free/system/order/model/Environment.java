package com.free.system.order.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * env
 * @author suwenguang
 * @version 1.0.0
 **/
@ConfigurationProperties(prefix = "env")
@Data
public class Environment {
	private String version;
	private String author;
}
