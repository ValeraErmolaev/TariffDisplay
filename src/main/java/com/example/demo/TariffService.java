package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Stateless
public class TariffService {
    @Inject
    private TariffsBean tariffsBean;
    private RestTemplate restTemplate = new RestTemplate();
    private TariffDeserializer tariffDeserializer = new TariffDeserializer();

    public List<TariffViewForm> getAll() {
        final String url = "http://localhost:8099/allTariffs";
        ResponseEntity<TariffViewForm[]> response = restTemplate.getForEntity(url, TariffViewForm[].class);
//        System.out.println("response.getBODY()!:"+response.getBody());
        return Arrays.asList(response.getBody());
    }
    public void updateTariff(TariffViewForm tariffViewForm){
        List<TariffViewForm> tariffs = tariffsBean.getTariffs();
        for (TariffViewForm tariff:tariffs){
            if (tariff.getId() == tariffViewForm.getId()){
                tariff.setNumberOfContracts(tariffViewForm.getNumberOfContracts());
                tariff.setName(tariffViewForm.getName());
                tariffsBean.loadTariffs();
            }
        }
    }
}
