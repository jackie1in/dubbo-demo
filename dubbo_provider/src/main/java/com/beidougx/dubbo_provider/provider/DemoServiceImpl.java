package com.beidougx.dubbo_provider.provider;

import java.util.Date;

import com.beidougx.dubbo_api.DemoService;

import com.alibaba.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class DemoServiceImpl implements DemoService {

	@Override
    public String sayHello(String name) {
        return "Hello, " + name + ", " + new Date();
    }

}