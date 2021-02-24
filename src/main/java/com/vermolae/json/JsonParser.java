package com.vermolae.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vermolae.dto.TariffViewForm;
import lombok.extern.slf4j.Slf4j;

import javax.ejb.Singleton;
import java.io.IOException;

@Singleton
@Slf4j
public class JsonParser {

    ObjectMapper objectMapper = new ObjectMapper();

    public TariffViewForm readTariffDtoJSON(String text) {
        TariffViewForm tariffViewForm = new TariffViewForm();
        try {
            tariffViewForm = objectMapper.readValue(text, TariffViewForm.class);
        } catch (JsonProcessingException e) {
            log.error("Error reading JSON", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tariffViewForm;
    }

}