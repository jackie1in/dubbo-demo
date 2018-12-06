package com.beidougx.dubbo_consumer.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.beidougx.dubbo_api.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dubbo")
public class DubboConsumerController {
  @Reference
  private DemoService demoService;
  @GetMapping("/test")
  public String dubboTest(@RequestParam(defaultValue = "海哥") String name){
    return demoService.sayHello(name);
  }
}
