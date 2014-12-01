package jdbc;

import java.util.List;

import javax.sql.DataSource;

public interface StudentDAO {

	public void setDataSource(DataSource dataSource);

	public void create(String name, Integer id);

	public Student getStudent(Integer id);

	public List<Student> listStudents();

	public void delete(Integer id);

	public void update(Integer id, Integer age);
}
