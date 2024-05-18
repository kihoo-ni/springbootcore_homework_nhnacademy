package com.nhnacademy.demo.dataparser;

import com.nhnacademy.demo.Account;
import com.nhnacademy.demo.Price;

import java.util.List;

public interface DataParser {
    List<Account> accounts();
    List<Price> prices();
}

