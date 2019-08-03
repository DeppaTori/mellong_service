package com.deppatori.mellong.controller;

import com.deppatori.mellong.model.Role;
import com.deppatori.mellong.service.IRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController extends ABaseController<Role, IRoleService>{
}
