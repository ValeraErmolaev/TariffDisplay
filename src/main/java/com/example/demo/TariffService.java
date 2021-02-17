package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.List;
@Stateless
public class TariffService {
    private RestTemplate restTemplate = new RestTemplate();
    private TariffDeserializer tariffDeserializer = new TariffDeserializer();

    public List<TariffViewForm> getAll() {
        final String url = "http://localhost:8099/allTariffs";
        ResponseEntity<TariffViewForm[]> response = restTemplate.getForEntity(url, TariffViewForm[].class);
//        System.out.println("response.getBODY()!:"+response.getBody());
        return Arrays.asList(response.getBody());
    }
}
