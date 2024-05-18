package com.nhnacademy.demo;

import com.nhnacademy.demo.exception.LoginFailedException;
import com.nhnacademy.demo.formatter.OutputFormatter;
import com.nhnacademy.demo.service.AuthenticationService;
import com.nhnacademy.demo.service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;


@Slf4j
@ShellComponent
public class MyCommands {


    private final PriceService priceService;
    private final AuthenticationService authenticationService;
    private final OutputFormatter outputFormatter;


    public MyCommands(PriceService priceService, AuthenticationService authenticationService, OutputFormatter outputFormatter) {
        this.priceService = priceService;
        this.authenticationService = authenticationService;
        this.outputFormatter = outputFormatter;
    }



    @ShellMethod(key = "login", value = "login")
    public String login(Long id, String password) {
        Account account = authenticationService.login(id, password);

        if (account != null) {
            log.info("login  "+id+" "+password);
            return "Login successful! Account(id=" + account.getId() + ", password=" + account.getPassword() + ", name=" + account.getName() + ")";
        } else {
            throw new LoginFailedException("\033[31mLogin failed!\033[0m");
        }


    }


    @ShellMethod(key = "logout", value = "logout")
    public String logout() {
        authenticationService.logout();
        log.info("logout");
        return "Logout successful! Goodbye!";
    }

    @ShellMethod(key = "current-user", value = "current your status")
    public String currentUser() {
        Account account = authenticationService.getCurrentAccount();
        if (account != null) {
            log.info("current-user");
            return "회원정보입니다. Account(id=" + account.getId() + ", password=" + account.getPassword() + ", name=" + account.getName() + ")";
        } else {
            return "\033[31m회원 정보를 찾을 수 없습니다.\033[0m";
        }
    }

    @ShellMethod(key = "price", value = "show your city, sector, unitPrice")
    public String getPrice(String city, String sector) {
        Price price = priceService.getPrice(city, sector);
        Account account = authenticationService.getCurrentAccount();
        if (price != null) {
            return "Price (id="+account.getId()+", city=" + city + ", sector=" + sector + ", unitPrice= " + price.getUnitPrice()+")";
        } else {
            return "\033[31mPrice not found for specified city and sector.\033[0m";
        }
    }

    @ShellMethod(key = "city", value = "list our cities")
    public List<String> listCities() {
      authenticationService.getCurrentAccount();
        return priceService.getCities();
    }

    @ShellMethod(key = "sector", value = "list our sectors")
    public List<String> listSectors(String city) {
        authenticationService.getCurrentAccount();
        return priceService.getSectors(city);
    }

    @ShellMethod(key = "bill-total", value = "show your bill-total")
    public String bill(String city, String sector, int usage) {
        authenticationService.getCurrentAccount();
        Price price = priceService.getPrice(city, sector);
        if (price != null) {
            return outputFormatter.format(price, usage);
        } else {
            return "\033[31mPrice not found for specified city and sector.\033[0m";
        }
    }


    }


//@ShellMethod(key = "bill-total", value = "show your bill-total")
//public String bill(String city, String sector, int usage) {
//    authenticationService.getCurrentAccount();
//    Price price=priceService.getPrice(city, sector);
//    if (price != null) {
//
//        return "city=" + city + ", sector=" + sector + ", unitPrice= " + price.getUnitPrice()+", bill total(won): "+usage*price.getUnitPrice();
//    } else {
//        return "\033[31mPrice not found for specified city and sector.\033[0m";
//    }
//
//
//
//}



