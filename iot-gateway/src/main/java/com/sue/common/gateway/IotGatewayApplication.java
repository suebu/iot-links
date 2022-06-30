package com.sue.common.gateway;

import com.sue.common.gateway.annotion.EnableIotDynamicRoute;
import com.sue.common.swagger.annotation.EnableIotSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableIotSwagger2
@EnableIotDynamicRoute
@EnableDiscoveryClient
@SpringBootApplication
public class IotGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotGatewayApplication.class, args);
	}
}
