package com.example.demo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Startup
@Named
@ApplicationScoped
@Data
public class TariffsBean {
    @Inject
    RecieverConfigBean recieverConfigBean;
    @EJB
    private TariffService tariffService;
    @Getter
    @Setter
    private List<TariffViewForm> tariffs = new ArrayList<>();

    @PostConstruct
    public void init() {
        recieverConfigBean.openConnection();
//        System.out.println("OPENED!!!!!!!!!!!!");
        loadTariffs();
//        for (TariffViewForm tariffViewForm:tariffs){
//            System.out.println(tariffViewForm.getName());
//        }
    }

    public void loadTariffs() {
        System.out.println("Load tariffs storage");
        tariffs = tariffService.getAll().stream()
                .sorted(Comparator.comparing(TariffViewForm::getNumberOfContracts)
                .reversed()).limit(3)
                .collect(Collectors.toList());
    }
}
