package com.alibaba.nacos.controller;

import com.alibaba.nacos.auth.annotation.Secured;
import com.alibaba.nacos.auth.common.ActionTypes;
import com.alibaba.nacos.common.model.RestResultUtils;
import com.alibaba.nacos.common.utils.StringUtils;
import com.alibaba.nacos.security.nacos.NacosAuthConfig;
import com.alibaba.nacos.security.nacos.role.NacosRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth/permissions")
public class PermissionController {

	@Autowired
	private NacosRoleServiceImpl nacosRoleService;

	/**
	 * Query permissions of a role.
	 * @param role the role
	 * @param pageNo page index
	 * @param pageSize page size
	 * @return permission of a role
	 */
	@GetMapping
	@Secured(resource = NacosAuthConfig.CONSOLE_RESOURCE_NAME_PREFIX + "permissions", action = ActionTypes.READ)
	public Object getPermissions(@RequestParam int pageNo, @RequestParam int pageSize,
								 @RequestParam(name = "role", defaultValue = StringUtils.EMPTY) String role) {
		return nacosRoleService.getPermissionsFromDatabase(role, pageNo, pageSize);
	}

	/**
	 * Add a permission to a role.
	 * @param role the role
	 * @param resource the related resource
	 * @param action the related action
	 * @return ok if succeed
	 */
	@PostMapping
	@Secured(resource = NacosAuthConfig.CONSOLE_RESOURCE_NAME_PREFIX + "permissions", action = ActionTypes.WRITE)
	public Object addPermission(@RequestParam String role, @RequestParam String resource, @RequestParam String action) {
		nacosRoleService.addPermission(role, resource, action);
		return RestResultUtils.success("add permission ok!");
	}

	/**
	 * Delete a permission from a role.
	 * @param role the role
	 * @param resource the related resource
	 * @param action the related action
	 * @return ok if succeed
	 */
	@DeleteMapping
	@Secured(resource = NacosAuthConfig.CONSOLE_RESOURCE_NAME_PREFIX + "permissions", action = ActionTypes.WRITE)
	public Object deletePermission(@RequestParam String role, @RequestParam String resource,
								   @RequestParam String action) {
		nacosRoleService.deletePermission(role, resource, action);
		return RestResultUtils.success("delete permission ok!");
	}
}
