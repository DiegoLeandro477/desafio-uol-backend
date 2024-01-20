package br.com.ferruje.desafiouolbackendspirng.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import br.com.ferruje.desafiouolbackendspirng.entities.UserLegion;
import br.com.ferruje.desafiouolbackendspirng.entities.legionModel.Codename;
import br.com.ferruje.desafiouolbackendspirng.entities.legionModel.Legion;

@Service
public class LegionService {

    public List<Codename> getCodenames(UserLegion userLegion) throws Exception {
        String apiUrl = null;

        if (userLegion.equals(UserLegion.VINGADORES)) {
            apiUrl = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json";
        } else if (userLegion.equals(UserLegion.LIGADAJUSTICA)) {
            apiUrl = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml";
        } else {
            throw new Exception("O grupo não foi identificado");
        }

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String responseBody = responseEntity.getBody();

            try {
                Legion legion = mapToLegion(userLegion, responseBody);
                return legion.getCodename();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        throw new Exception(" Algo deu errado ");
    }

    private Legion mapToLegion(UserLegion userLegion, String response) throws Exception {
        ObjectMapper objectMapper = null;

        if (userLegion.equals(UserLegion.VINGADORES)) {
            objectMapper = new ObjectMapper();
        } else if (userLegion.equals(UserLegion.LIGADAJUSTICA)) {
            objectMapper = new XmlMapper();
        }

        if (objectMapper != null) {
            return objectMapper.readValue(response, Legion.class);
        }
        
        throw new Exception("Legiao nao identificada");
    }
}
    
   
