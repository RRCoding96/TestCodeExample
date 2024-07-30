package com.example.unittestexample;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
    title = "UnitTestExample Project",
    version = "v1",
    description = "테스트 코드(단위 테스트)를 추가하기 위한 연습에 사용되는 토이프로젝트"
))
public class UnitTestExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(UnitTestExampleApplication.class, args);
    }

}
