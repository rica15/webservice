package com.example.demo.config;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.field.field;

public class fieldRowMapper implements RowMapper<field> {

	@Override
	public field mapRow(ResultSet rs, int rowNum) throws SQLException {
		field fld = new field();
		fld.setId(0);
		fld.setORDER_ID("order_id");
		fld.setPRODUCT_ID("product_id");
		fld.setCUSTOMER_ID("customer_id");

		return null;
	}

}
