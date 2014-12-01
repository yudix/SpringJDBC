package objects.only;

import java.sql.Driver;

public class MySQLDS {
	private Class<? extends Driver> driverClass;
	public Class<? extends Driver> getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(Class<? extends Driver> driverClass) {
		this.driverClass = driverClass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private String userName;
	private String password;
	private String url;

	public MySQLDS() {
		this.driverClass = driver();
		this.url = "jdbc:mysql://localhost:3306/yuda_test";
		this.userName = "root";
		this.password = "venezia";
	}

	private Class<? extends Driver> driver() {
		try {
			return (Class<? extends Driver>) Class
					.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

}
