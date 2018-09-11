package com.example.myFirstProject;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.thymeleaf")
public class ThymeleafProperties {
	
	public static final String DEFAUTL_PREFIX = "classpath:/templates";
	public static final String DEFAUTL_SUFFIX = ".html";
	
	private String prefix = DEFAUTL_PREFIX;
	private String suffix = DEFAUTL_SUFFIX;
	
	private String mode = "HTML5";
	private String encoding = "UTF-8";
	private String contentType = "text/html";
	private boolean cache = false;
	
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getEncoding() {
		return encoding;
	}
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public boolean isCache() {
		return cache;
	}
	public void setCache(boolean cache) {
		this.cache = cache;
	}
	
	
	
}