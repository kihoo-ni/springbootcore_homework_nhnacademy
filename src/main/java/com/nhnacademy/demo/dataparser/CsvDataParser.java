package com.nhnacademy.demo.dataparser;

import com.nhnacademy.demo.Account;
import com.nhnacademy.demo.Price;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
@ConditionalOnProperty(prefix = "data", name = "parser", havingValue = "csv")
public class CsvDataParser implements DataParser {
    @Value("${csv.file.path}")
    private Resource csvFilePath;

    @Value("${csv.file.path2}")
    private Resource csvFilePath2;

    @Override
    public List<Account> accounts() {
        try {
            List<Account> accounts = new ArrayList<>();
            CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(csvFilePath.getInputStream())).withSkipLines(1).build();
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                accounts.add(new Account(Long.parseLong(nextRecord[0]), nextRecord[1].trim(), nextRecord[2].trim()));
            }
            return accounts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Price> prices() {
        try {
            List<Price> prices = new ArrayList<>();
            CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(csvFilePath2.getInputStream())).withSkipLines(1).build();
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                prices.add(new Price(
                        Long.parseLong(nextRecord[0]),
                        Long.parseLong(nextRecord[3]),
                        nextRecord[1].trim(),
                        nextRecord[2].trim(),
                        Long.parseLong(nextRecord[6])
                ));
            }
            return prices;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}



