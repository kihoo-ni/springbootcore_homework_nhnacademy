package com.nhnacademy.demo.formatter;

import com.nhnacademy.demo.Price;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("eng")
public class EnglishOutputFormatter implements OutputFormatter {
    @Override
    public String format(Price price, int usage) {
        return "City=" + price.getCity() + ", Sector=" + price.getSector() + ", Unit Price= " + price.getUnitPrice() + ", Total Bill (won): " + (usage * price.getUnitPrice());
    }
}