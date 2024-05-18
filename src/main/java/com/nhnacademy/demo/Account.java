package com.nhnacademy.demo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @JsonProperty("아이디")
    private Long id;

    @JsonProperty("비밀번호")
    private String password;

    @JsonProperty("이름")
    private String name;


}