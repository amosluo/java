package com.amos.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.amos.bean.TblUserRecord;
import com.amos.returnJson.Permission;
import com.amos.returnJson.Permissions;
import com.amos.returnJson.ReturnObject;
import com.amos.returnJson.UserInfo;
import com.amos.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", methods = {})
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/auth/2step-code")
    public boolean step_code2() {
        System.out.println("此请求是前端框架带的默认请求，可以不做任何处理，也可以在前端将其删除");
        System.out.println("step_code2");
        return true;
    }

    @RequestMapping("/auth/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        System.out.println("login");
        TblUserRecord tblUserRecord = loginService.login(username, password);
        tblUserRecord.setToken(tblUserRecord.getUserName());
        session.setAttribute("userInfo", tblUserRecord);
        ReturnObject returnObject = new ReturnObject(tblUserRecord);
//        System.out.println(username + ": " + password);
        return JSONObject.toJSONString(returnObject);
    }

    @RequestMapping("/user/info")
    public String info(HttpSession session) {
        TblUserRecord tblUserRecord = (TblUserRecord) session.getAttribute("userInfo");
        //获取模块信息
        String[] modules = tblUserRecord.getUserRole().getRolePrivileges().split("-");
        Permissions permissions = new Permissions();
        List<Permission> permissionList = new ArrayList<Permission>();
        for (String module : modules) {
            permissionList.add(new Permission(module));
        }
        permissions.setPermissions(permissionList);

        UserInfo userInfo = new UserInfo();
        userInfo.setName(tblUserRecord.getUserName());
        userInfo.setRole(permissions);

        return JSONObject.toJSONString(new ReturnObject(userInfo));
    }

    @RequestMapping("/auth/logout")
    public String logOut(HttpSession session){
        session.invalidate();
        return "退出成功!";
    }
}
