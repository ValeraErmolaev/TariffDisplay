package com.vermolae.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vermolae.json.TariffDeserializer;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder=true)
@JsonDeserialize(using = TariffDeserializer.class)
public class TariffViewForm {
    private int id;
    private String name;
    private String description;
    private Long numberOfContracts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getNumberOfContracts() {
        return numberOfContracts;
    }

    public void setNumberOfContracts(Long numberOfContracts) {
        this.numberOfContracts = numberOfContracts;
    }
}
