package com.dailyhub.controller;

import com.dailyhub.utils.redis.Redis;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

public class BaseController {
    @Resource
    HttpServletRequest request;
    @Autowired
    Redis redis;
}
