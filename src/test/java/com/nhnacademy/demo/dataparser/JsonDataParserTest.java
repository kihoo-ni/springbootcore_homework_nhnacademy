package com.nhnacademy.demo.dataparser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.demo.Account;
import com.nhnacademy.demo.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.Resource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class JsonDataParserTest {

    @Mock
    private Resource jsonFileResource;

    @Mock
    private Resource jsonFileResource2;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private JsonDataParser jsonDataParser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("jsonFileResource 값을 제대로 가져오는지 확인")
    void testAccounts() throws IOException {
        String jsonContent = "[{\"id\":1,\"password\":\"1234\",\"name\":\"kihoon\"}," +
                "{\"id\":2,\"password\":\"1234\",\"name\":\"suseon\"}]";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(jsonContent.getBytes(StandardCharsets.UTF_8));

        // 어떤 Resource 객체가 호출되더라도 inputStream을 반환하도록 설정
        when(jsonFileResource.getInputStream()).thenReturn(inputStream);

        List<Account> expectedAccounts = List.of(
                new Account(1L, "1234", "kihoon"),
                new Account(2L, "1234", "suseon")
        );

        // 어떤 InputStream 객체가 전달되더라도 expectedAccounts를 반환하도록 설정
        when(objectMapper.readValue(inputStream,new TypeReference<List<Account>>() {}))
                .thenReturn(expectedAccounts);

        List<Account> accounts = jsonDataParser.accounts();

        assertEquals(expectedAccounts.size(), accounts.size());
        assertEquals(expectedAccounts.get(0).getName(), accounts.get(0).getName());
        assertEquals(expectedAccounts.get(1).getName(), accounts.get(1).getName());
    }

    @Test
    @DisplayName("jsonFileResource2 값을 제대로 가져오는지 확인")
    void testPrices() throws IOException {
        String jsonContent = "[{\"id\":1,\"num\":1,\"city\":\"Seoul\",\"sector\":\"Industry\",\"unitPrice\":1000}," +
                "{\"id\":2,\"num\":2,\"city\":\"Busan\",\"sector\":\"Commerce\",\"unitPrice\":2000}]";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(jsonContent.getBytes(StandardCharsets.UTF_8));
        when(jsonFileResource2.getInputStream()).thenReturn(inputStream);
        List<Price> expectedPrices = List.of(
                new Price(1L, 1L, "Seoul", "Industry", 1000L),
                new Price(2L, 2L, "Busan", "Commerce", 2000L)
        );
        when(objectMapper.readValue(inputStream, new TypeReference<List<Price>>() {})).thenReturn(expectedPrices);

        List<Price> prices = jsonDataParser.prices();

        assertEquals(expectedPrices.size(), prices.size());
        assertEquals(expectedPrices.get(0).getCity(), prices.get(0).getCity());
        assertEquals(expectedPrices.get(1).getCity(), prices.get(1).getCity());
    }
}