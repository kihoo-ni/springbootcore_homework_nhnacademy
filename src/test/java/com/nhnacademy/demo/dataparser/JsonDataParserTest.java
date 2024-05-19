package com.nhnacademy.demo.dataparser;

public class JsonDataParserTest {
//
//    @Mock
//    private Resource jsonFileResource;
//
//    @Mock
//    private ObjectMapper objectMapper;
//
//    @InjectMocks
//    JsonDataParser jsonDataParser;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this); // Mockito 모의 객체 초기화
//    }
//
//    @Test
//    @DisplayName("Json 파일에서 계정 목록을 올바르게 파싱하는지 확인")
//    void testAccounts() throws IOException {
//        String jsonContent = "[{\"id\":1,\"password\":\"1234\",\"name\":\"kihoon\"}," +
//                "{\"id\":2,\"password\":\"1234\",\"name\":\"suseon\"}]";
//
//        InputStream inputStream = new ByteArrayInputStream(jsonContent.getBytes(StandardCharsets.UTF_8));
//        when(jsonFileResource.getInputStream()).thenReturn(inputStream);
//
//        List<Account> expectedAccounts = List.of(
//                new Account(1L, "1234", "kihoon"),
//                new Account(2L, "1234", "suseon")
//        );
//
//        when(objectMapper.readValue(inputStream, new TypeReference<List<Account>>() {}))
//                .thenReturn(expectedAccounts);
//
//        List<Account> accounts = jsonDataParser.accounts();
//
//        assertEquals(expectedAccounts.size(), accounts.size());
//        assertEquals(expectedAccounts.get(0).getName(), accounts.get(0).getName());
//        assertEquals(expectedAccounts.get(1).getName(), accounts.get(1).getName());
//    }

}
