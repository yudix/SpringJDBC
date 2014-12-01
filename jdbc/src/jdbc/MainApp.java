package jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {

		ApplicationContext context = new FileSystemXmlApplicationContext(
				"Beans.xml");
		System.out.println("get Context");
		
		StudentJDBCTemplate template = (StudentJDBCTemplate) context
				.getBean("studentJDBCTemplate");
		System.out.println("get StudentJDBCTemplate");
		
		//Create
		System.out.println("Inserting to table");
		template.create("dani", 20);
		template.create("yossi", 30);
		template.create("benni", 40);
		//Read (one Object)
//		Student student = template.getStudent(1);
//		System.out.println(student);
		//Read (List)
		System.out.println("List students");
		List<Student> students = template.listStudents();
		for (Student s : students) {
			System.out.println(s);
		}
		//Update
//		template.update(student.getId(), 12);
//		System.out.println("Update\n"+template.getStudent(30));		
		//Delete
		System.out.println("Delete");
		template.delete(40);
		System.out.println("List after delete");
		for (Student s : students) {
			System.out.println(s.getName());
		}

	}
}
