package com.sue.common.gateway.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.cloud.gateway.route.RouteDefinition;

import java.io.Serializable;

/**
 * 扩展此类支持序列化a See RouteDefinition.class
 * @author sue
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class RouteDefinitionVo extends RouteDefinition implements Serializable {
	/**
	 * 路由名称
	 */
	private String routeName;
}
