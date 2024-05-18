package com.nhnacademy.demo.service;


import com.nhnacademy.demo.Price;
import com.nhnacademy.demo.dataparser.DataParser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {


    private final List<Price> prices;

    public PriceService(DataParser dataParser) {
        this.prices = dataParser.prices();
    }

    public Price getPrice(String city, String sector) {
        for (Price price : prices) {
            if (price.getCity().equals(city) && price.getSector().equals(sector)) {
                return price;
            }
        }
        return null; // 가격 정보가 없을 경우 null 반환
    }

    public List<String> getCities() {
        return prices.stream()
                .map(Price::getCity)
                .distinct()
                .toList();
    }

    public List<String> getSectors(String city) {
        return prices.stream()
                .filter(price -> price.getCity().equals(city))
                .map(Price::getSector)
                .distinct()
                .toList();
    }
}
