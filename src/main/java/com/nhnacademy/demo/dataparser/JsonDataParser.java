package com.nhnacademy.demo.dataparser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.demo.Account;
import com.nhnacademy.demo.Price;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
@ConditionalOnProperty(prefix = "data", name = "parser", havingValue = "json")
public class JsonDataParser implements DataParser {

    @Value("${json.file.path}")
    private Resource jsonFileResource;

    @Value("${json.file.path2}")
    private Resource jsonFileResource2;

    private final ObjectMapper objectMapper;

    public JsonDataParser(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public JsonDataParser() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public List<Price> prices() {
        try {
            return objectMapper.readValue(jsonFileResource2.getInputStream(), new TypeReference<List<Price>>() {});
        } catch (IOException e) {
            log.error("Error reading prices from JSON file", e);
        }
        return null;
    }

    @Override
    public List<Account> accounts() {
        try {
            return objectMapper.readValue(jsonFileResource.getInputStream(), new TypeReference<List<Account>>() {});
        } catch (IOException e) {
            log.error("Error reading accounts from JSON file", e);
        }
        return null;
    }

}

