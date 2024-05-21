package com.nhnacademy.demo.dataparser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.demo.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.Resource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class JsonDataParserTest {

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private Resource jsonFileResource;

    @InjectMocks
    JsonDataParser jsonDataParser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Json 파일에서 계정 목록을 올바르게 파싱하는지 확인")
    void testAccounts() throws IOException {
        String jsonContent = "[{\"id\":1,\"password\":\"1234\",\"name\":\"kihoon\"}," +
                "{\"id\":2,\"password\":\"1234\",\"name\":\"suseon\"}]";

        InputStream inputStream = new ByteArrayInputStream(jsonContent.getBytes(StandardCharsets.UTF_8));

        when(jsonFileResource.getInputStream()).thenReturn(inputStream);

        List<Account> expectedAccounts = List.of(
                new Account(1L, "1234", "kihoon"),
                new Account(2L, "1234", "suseon")
        );

        // objectMapper.readValue()가 호출될 때 expectedAccounts를 반환하도록 설정
        when(objectMapper.readValue(any(InputStream.class), any(TypeReference.class)))
                .thenReturn(expectedAccounts);

        // jsonDataParser.accounts() 메소드 호출
        List<Account> accounts = jsonDataParser.accounts();

        // 예상 계정 수와 실제 계정 수가 일치하는지 확인
        assertEquals(expectedAccounts.size(), accounts.size());
        // 각 계정의 이름이 일치하는지 확인
        assertEquals(expectedAccounts.get(0).getName(), accounts.get(0).getName());
        assertEquals(expectedAccounts.get(1).getName(), accounts.get(1).getName());
    }
}

