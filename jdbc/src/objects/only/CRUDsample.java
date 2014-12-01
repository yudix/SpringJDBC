package objects.only;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import sample.Customer;

public class CRUDsample {
	
	public static void main(String args[]) {
		SimpleDriverDataSource dataSource = declaringDataSource(new MySQLDS());

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		System.out.println("Creating tables");
		jdbcTemplate.execute("drop table customers if exists");
		jdbcTemplate
				.execute("create table customers("
						+ "id serial, first_name varchar(255), last_name varchar(255))");

		String[] names = "John Woo;Jeff Dean;Josh Bloch;Josh Long".split(";");
		for (String fullname : names) {
			String[] name = fullname.split(" ");
			System.out.printf("Inserting customer record for %s %s\n", name[0],
					name[1]);
			jdbcTemplate.update(
					"INSERT INTO customers(first_name,last_name) values(?,?)",
					name[0], name[1]);
		}

		System.out
				.println("Querying for customer records where first_name = 'Josh':");
		List<Customer> results = jdbcTemplate.query(
				"select * from customers where first_name = ?",
				new Object[] { "Josh" }, new RowMapper<Customer>() {
					@Override
					public Customer mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						return new Customer(rs.getLong("id"), rs
								.getString("first_name"), rs
								.getString("last_name"));
					}
				});

		for (Customer customer : results) {
			System.out.println(customer);
		}
	}
	
	private static SimpleDriverDataSource declaringDataSource(MySQLDS sqlds) {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(sqlds.getDriverClass());//com.mysql.jdbc.Driver
		dataSource.setUrl(sqlds.getUrl());//jdbc:mysql://localhost:3306/yuda_test
		dataSource.setUsername(sqlds.getUserName());//root
		dataSource.setPassword(sqlds.getPassword());//venezia
		return dataSource;
	}
}