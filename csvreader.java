package code;

import java.sql.DriverManager;
import java.sql.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;

public class csvreader {

	public static void main(String[] args) {

		String jdbcURL = "jdbc:mysql://localhost:3306/sales";
		String username = "root";
		String password = "";
		String line = "";
		String splitBy = ",";
		try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
			System.out.println("Datababse Connected:");
			try {

				// parsing a CSV file into BufferedReader class constructor
				BufferedReader br = new BufferedReader(new FileReader("C:\\sales.csv"));
				int count = 0;
				while ((line = br.readLine()) != null) {
					String[] row = line.split(splitBy); // use comma as separator
					if (count != 0) {
						String sql = "INSERT INTO `store_order` (`ORDER_ID`, `ORDER_DATE`, `SHIP_DATE`, `SHIP_MODE`, `QUANTITY`,`DISCOUNT`,`PROFIT`, `PRODUCT_ID`, `CUSTOMER_NAME`,`CATEGORY`,"
								+ " `CUSTOMER_ID`," + "`PRODUCT_NAME`)" + " VALUES (`" + row[1] + "`,`" + row[2] + "`,`"
								+ row[3] + "`,`" + row[4] + "`,`" + row[18] + "`,`" + row[19] + "`,`" + row[20] + "`,`"
								+ row[13] + "`,`" + row[6] + "`,`" + row[14] + "`,`" + row[5] + "`,`" + row[16] + "`)";

						System.out.println(sql.toString());
						Statement stmt = connection.createStatement();
						System.out.println("Inserting records into the table...");
						stmt.executeUpdate(sql);
						System.out.println("Successfully added data");
					}
					count++;
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("Datababse error:");
			e.printStackTrace();
		}
	}
}