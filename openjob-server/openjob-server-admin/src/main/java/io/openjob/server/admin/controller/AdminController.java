package io.openjob.server.admin.controller;

import io.openjob.common.response.Result;
import io.openjob.server.admin.constant.AdminConstant;
import io.openjob.server.admin.request.user.AdminUserLoginRequest;
import io.openjob.server.admin.request.user.AdminUserLogoutRequest;
import io.openjob.server.admin.service.AdminLoginService;
import io.openjob.server.admin.vo.user.AdminUserLoginVO;
import io.openjob.server.admin.vo.user.AdminUserLogoutVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author inhere
 * @since 1.0.0
 */
@Api(value = "AdminLogInOut", tags = "LogInOut")
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminLoginService adminLoginService;

    @Autowired
    public AdminController(AdminLoginService adminLoginService) {
        this.adminLoginService = adminLoginService;
    }

    @ApiOperation("admin user login")
    @PostMapping("/login")
    public Result<AdminUserLoginVO> login(@Valid @RequestBody AdminUserLoginRequest request) {
        return Result.success(this.adminLoginService.login(request));
    }

    @ApiOperation("admin user logout")
    @PostMapping("/logout")
    public Result<AdminUserLogoutVO> logout(
            @RequestBody AdminUserLogoutRequest request,
            @RequestHeader(name = AdminConstant.HEADER_SESSION_KEY) String sessKey
    ) {
        return Result.success(this.adminLoginService.logout(request, sessKey));
    }

}

