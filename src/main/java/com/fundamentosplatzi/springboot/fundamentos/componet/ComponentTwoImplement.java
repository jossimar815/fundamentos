package com.fundamentosplatzi.springboot.fundamentos.componet;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("prueba desde mi componente 2");
    }
}