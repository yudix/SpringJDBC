package jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
public class StudentJDBCTemplate implements StudentDAO {
	
	private JdbcTemplate jdbcT;
	
	@Override
	public void setDataSource(DataSource dataSource) {
		this.jdbcT = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(String name, Integer id) {
		String sql = "insert into Student (name, age) values (?, ?)";
		jdbcT.update(sql, name, id);
		return;
	}

	@Override
	public Student getStudent(Integer id) {
		String SQL = "select * from Student where id = ?";
		return jdbcT.queryForObject(SQL, new Object[] {id}, new StudentMapper());
	}

	@Override
	public List<Student> listStudents() {
		String SQL = "select * from Student";
		return jdbcT.query(SQL, new StudentMapper());
	}

	@Override
	public void delete(Integer id) {
		String SQL = "delete from Student where id = ?";
		jdbcT.update(SQL, id);
		return;
	}

	@Override
	public void update(Integer id, Integer age) {
		String SQL = "update Student set age = ? where id = ?";
		jdbcT.update(SQL,age,id);
		return;
	}

}
