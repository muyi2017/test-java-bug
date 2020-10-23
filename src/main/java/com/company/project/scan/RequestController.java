package com.company.project.scan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RequestController {

    @RequestMapping(path= "/greet", method = RequestMethod.GET)
    private String greet(String greetee) {
        return "";
    }

    @RequestMapping(path = "/saveForLaterx", method = RequestMethod.POST)
    public String saveForLaterx(Wish wish) {
        List<Wish> x = new ArrayList<>();
        x.add(wish);
        return "saveForLater";
    }

    @RequestMapping("/efqwd")  // Noncompliant
    public String efqwd(String greetee) {
        return "sdd";
    }

}
