package com.beidougx.dubbo_provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.logging.slf4j.SLF4JLoggerContext;
import org.apache.logging.slf4j.SLF4JLoggerContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.concurrent.CountDownLatch;


import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class Application implements CommandLineRunner {
	private static final Logger LOGGER =  LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws InterruptedException{

		SpringApplication.run(Application.class, args);

		new CountDownLatch(1).await(); //hold住应用，防止provider退出
	}

	@Value("${spring.datasource.url}")
	private String jdbcUrl;

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("jdbUrl:[{}]",jdbcUrl);
	}
}
