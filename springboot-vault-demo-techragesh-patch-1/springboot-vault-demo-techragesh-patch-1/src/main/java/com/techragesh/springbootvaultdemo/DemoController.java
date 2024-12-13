package com.techragesh.springbootvaultdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;

@RestController
public class DemoController {

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${vaultDeneme}")
    private String vaultDeneme;

    @Value("${kafka.user}")
    private String kafkUser;

    @Value("${kafka.pass}")
    private String kafkPass;


    @Autowired
    private DataSource dataSource;

    @GetMapping("/demo")
    public String getConnection() throws SQLException {
        return  kafkUser + " and " + kafkPass + " and " + vaultDeneme +  " and " + username + " and " + password + " from vault and connected to  database " +  dataSource.getConnection();

    }

}
