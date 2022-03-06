package com.fundamentosplatzi.springboot.fundamentos.controller;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    private MyBeanWithProperties myBeanWithProperties;

    public TestController(MyBeanWithProperties myBeanWithProperties) {
        this.myBeanWithProperties = myBeanWithProperties;
    }

    @RequestMapping
    @ResponseBody
    public ResponseEntity<String> prueba(){
        return new ResponseEntity<>(myBeanWithProperties.function(), HttpStatus.OK);
    }
}
