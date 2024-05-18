package com.nhnacademy.demo.formatter;

import com.nhnacademy.demo.Price;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


    @Component
    @Profile("kor")
    public class KoreanOutputFormatter implements OutputFormatter {
        @Override
        public String format(Price price, int usage) {
            return "지자체명=" + price.getCity() + ", 업종=" + price.getSector() + ", 구간금액(원)= " + price.getUnitPrice() + ", 총 요금(원): " + (usage * price.getUnitPrice());
        }
    }
