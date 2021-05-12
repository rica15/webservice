package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.field.field;
import com.example.demo.process.fieldProcessor;

@Configuration
@EnableBatchProcessing
public class configuration {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory builderFactory;
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public JdbcCursorItemReader<field> reader() {
		JdbcCursorItemReader<field> cursorItemReader = new JdbcCursorItemReader<>();
		cursorItemReader.setDataSource(dataSource);
		cursorItemReader.setSql("SELECT Id,ORDER_ID,PRODUCT_ID,CUSTOMER_ID");
		cursorItemReader.setRowMapper(new fieldRowMapper());
		return cursorItemReader;
	}
	
	@Bean
	public fieldProcessor processor () {
		return new fieldProcessor();
	}
	

}
