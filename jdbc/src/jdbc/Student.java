package jdbc;

public class Student {
	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + ", id=" + id + "]";
	}

	private Integer age;
	public Student(Integer age, String name, Integer id) {
		super();
		this.age = age;
		this.name = name;
		this.id = id;
	}

	private String name;
	private Integer id;

	public Integer getAge() {
		return age;
	}

	public Student(Integer age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public Student() {
		super();
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
