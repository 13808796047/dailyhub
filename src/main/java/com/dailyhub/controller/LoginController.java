package com.dailyhub.controller;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class LoginController extends BaseController {

    @GetMapping("/login")
    public String login() {
        String code = "DY" + RandomUtil.randomNumbers(4);
        while (redis.hasKey(code)) {
            code = "DY" + RandomUtil.randomNumbers(4);
        }
        String ticket = RandomUtil.randomString(32);
        redis.set("ticket" + code, ticket);
        request.setAttribute("code", code);
        request.setAttribute("ticket", ticket);
        return "login";
    }

//    @GetMapping("/login-check")
//    @ResponseBody
//    public Response loginCheck() {
//        return Response.success()
//    }
}
