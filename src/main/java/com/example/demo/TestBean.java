package com.example.demo;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Startup
@Named
@ApplicationScoped
@Data
public class TestBean {
    @Inject
    RecieverConfigBean recieverConfigBean;
    @PostConstruct
    public void init(){
        recieverConfigBean.openConnection();
        System.out.println("OPENED!!!!!!!!!!!!");
    }
}
