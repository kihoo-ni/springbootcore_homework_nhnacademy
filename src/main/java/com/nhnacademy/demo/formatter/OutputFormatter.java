package com.nhnacademy.demo.formatter;

import com.nhnacademy.demo.Price;



public interface OutputFormatter {
    String format(Price price, int usage);
}
