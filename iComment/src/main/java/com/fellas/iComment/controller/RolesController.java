package com.fellas.iComment.controller;

import com.fellas.iComment.model.Role;
import com.fellas.iComment.service.FeedbackService;
import com.fellas.iComment.service.RoleService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
public class RolesController {
    private final RoleService roleService;

    public RolesController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("{id}")
    public Role getCompanyById(@PathVariable("id") long id) {
        return roleService.getRoleById(id);
    }
}
