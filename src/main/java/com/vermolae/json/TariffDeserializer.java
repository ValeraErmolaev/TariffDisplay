package com.vermolae.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.vermolae.dto.TariffViewForm;

import java.io.IOException;

public class TariffDeserializer extends JsonDeserializer<TariffViewForm> {
    @Override
    public TariffViewForm deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        System.out.println(node);
        TariffViewForm tariffViewForm = new TariffViewForm();
        tariffViewForm.setId(node.get("id").asInt());
        tariffViewForm.setName(node.get("name").asText());
        tariffViewForm.setNumberOfContracts(node.get("numberOfContracts").asLong());
        return tariffViewForm;
    }

}
