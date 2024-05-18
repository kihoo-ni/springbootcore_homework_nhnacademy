package com.nhnacademy.demo.service;

import com.nhnacademy.demo.Account;
import com.nhnacademy.demo.dataparser.DataParser;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthenticationService {

    private final List<Account> accounts;
    private static Account account;


    public AuthenticationService(DataParser dataparser) {
        this.accounts = dataparser.accounts();
    }

    public Account login(Long id, String password) {
        for (Account account : accounts) {
            if (account.getId().equals(id) && account.getPassword().equals(password)) {
                this.account=account;
                return account;
            }
        }
        return null; // 인증 실패 시 null 반환
    }

    public void logout() {
        this.account=null;
    }

    public Account getCurrentAccount() {

        return account;
    }



}
