package com.nhnacademy.demo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"구간시작(세제곱미터)", "구간끝(세제곱미터)", "단계별 기본요금(원)"})
public class Price {
    @JsonProperty("순번")
    private Long id;

    @JsonProperty("단계")
    private Long num;

    @JsonProperty("지자체명")
    private String city;

    @JsonProperty("업종")
    private String sector;

    @JsonProperty("구간금액(원)")
    private Long unitPrice;



}
