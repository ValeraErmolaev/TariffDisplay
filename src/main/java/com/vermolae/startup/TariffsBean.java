package com.vermolae.startup;

import com.vermolae.network.RecieverConfigBean;
import com.vermolae.dto.TariffViewForm;
import com.vermolae.service.TariffService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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
        loadTariffs();
    }

    public void loadTariffs() {
        System.out.println("Load tariffs storage");
        tariffs = tariffService.getAll().stream()
                .sorted(Comparator.comparing(TariffViewForm::getNumberOfContracts)
                .reversed()).limit(5)
                .collect(Collectors.toList());
    }
}
