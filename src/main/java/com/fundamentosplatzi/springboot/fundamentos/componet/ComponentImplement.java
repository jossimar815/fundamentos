package com.fundamentosplatzi.springboot.fundamentos.componet;


import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency {
    @Override
    public void saludar() {
        System.out.println("Prueba desde mi componente");
    }
}
