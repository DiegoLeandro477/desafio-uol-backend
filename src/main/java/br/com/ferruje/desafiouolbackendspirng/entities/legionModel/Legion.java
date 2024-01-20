package br.com.ferruje.desafiouolbackendspirng.entities.legionModel;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Legion {
    @JsonProperty("vingadores")
    @JacksonXmlElementWrapper(localName = "codinomes")
    @JacksonXmlProperty(localName = "codinome")
    List<Codename> codename = new ArrayList<>();

    
    // List<String> justiceLeague = new ArrayList<>();
}
