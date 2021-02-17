package com.example.demo;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class TariffDeserializer extends JsonDeserializer<TariffViewForm> {
    @Override
    public TariffViewForm deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        TariffViewForm tariffViewForm = new TariffViewForm();
        tariffViewForm.setId(node.get("id").asInt());
        tariffViewForm.setName(node.get("name").asText());
        tariffViewForm.setNumberOfContracts(node.get("numberOfContracts").asLong());
//        tariffViewForm.setDescription(node.get("description").asText());
//        tariffViewForm.setPrice(node.get("price").asDouble());

        return tariffViewForm;
    }

}
