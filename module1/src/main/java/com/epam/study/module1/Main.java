package com.epam.study.module1;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("spring-db.xml");
        DataSource source = (DataSource) context.getBean("dataSource");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(source);
    }

}
