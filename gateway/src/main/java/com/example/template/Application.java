package com.example.template;

import java.util.ArrayList;
import java.util.List;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// 2팀 테스트으으 &&&&&&&& 여기 수정
@SpringBootApplication
public class Application {

    public static ApplicationContext applicationContext;
    public static void main(String[] args) throws Exception{
       applicationContext = SpringApplication.run(Application.class, args);
    }


}


