package com.fundamentosplatzi.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    private final Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printBeanWithDependency() {
        LOGGER.info("ingreso a printBeanWithDependency");
        LOGGER.debug("el numero es 5");
        System.out.println(myOperation.suma(5));

        System.out.println("prueba with dependency ");
    }
}
