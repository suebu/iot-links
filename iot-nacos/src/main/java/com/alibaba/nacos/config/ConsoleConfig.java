package com.alibaba.nacos.config;

import com.alibaba.nacos.core.code.ControllerMethodsCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.PostConstruct;
import java.time.ZoneId;

/**
 * 是非单机模式启动 默认使用mysql作为外置数据库，
 * 此时需要到conf/application.properties内添加mysql的相关配置参数。
 * 否则就会去找jdbc.properties，两者都没有，那相当于依赖没有启动成功，自然就启动不起来。
 *
 * @author sue
 */
@Component
@EnableScheduling
@PropertySource("/application.properties")
public class ConsoleConfig {

	@Autowired
	private ControllerMethodsCache methodsCache;

	/**
	 * Init.
	 */
	@PostConstruct
	public void init() {
		methodsCache.initClassMethod("com.alibaba.nacos.core.controller");
		methodsCache.initClassMethod("com.alibaba.nacos.naming.controllers");
		methodsCache.initClassMethod("com.alibaba.nacos.config.server.controller");
		methodsCache.initClassMethod("com.alibaba.nacos.controller");
	}

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.setMaxAge(18000L);
		config.addAllowedMethod("*");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

	@Bean
	public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperCustomization() {
		return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.timeZone(ZoneId.systemDefault().toString());
	}
}
