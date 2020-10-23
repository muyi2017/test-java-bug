package com.company.project.scan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WishListController {

    @PostMapping(path = "/saveForLater")
    public String saveForLater(Wish wish) {
        List<Wish> x = new ArrayList<>();
        x.add(wish);
        return "saveForLater";
    }

    @RequestMapping(path = "/saveForLaterx", method = RequestMethod.POST)
    public String saveForLaterx(Wish wish) {
        List<Wish> x = new ArrayList<>();
        x.add(wish);
        return "saveForLater";
    }

    public User getUser(Connection con, String user) throws SQLException {

        Statement stmt1 = null;
        Statement stmt2 = null;
        PreparedStatement pstmt;
        try {
            stmt1 = con.createStatement();
            ResultSet rs1 = stmt1.executeQuery("GETDATE()"); // No issue; hardcoded query

            stmt2 = con.createStatement();
            ResultSet rs2 = stmt2.executeQuery("select FNAME, LNAME, SSN " +
                    "from USERS where UNAME=" + user);  // Sensitive

            pstmt = con.prepareStatement("select FNAME, LNAME, SSN " +
                    "from USERS where UNAME=" + user);  // Sensitive
            ResultSet rs3 = pstmt.executeQuery();

            //...
        } catch (Exception e) {

        }
        return null;
    }

    public User getUserHibernate(org.hibernate.Session session, String data) {

        org.hibernate.Query query = session.createQuery("from xx where fname " + data);
        return null;
    }
}
