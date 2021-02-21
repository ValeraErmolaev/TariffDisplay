package com.example.demo;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@ViewScoped
@Setter
@Getter
public class EventBean implements Serializable {

    private List<TariffViewForm> tariffs;
    private TariffViewForm item;
    private int count;
    @Inject
    private TariffsBean tariffsBean;
    @PostConstruct
    public void namesInterval() {
        tariffs = tariffsBean.getTariffs();
        count = 0;
    }


    public void pollListener(){
        //you can use an iterator too
        if (count >= tariffs.size())
        {
            count = 0;
        }
        item = tariffs.get(count);
        count++;
    }
}