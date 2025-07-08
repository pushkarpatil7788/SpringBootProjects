import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.infosys.bean.student;

public class Proj2Application{
	public static void main(String[] args) {

		// Creating reference of ApplicationContext (Spring container)
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);

		// Uncommenting the below code would cause NoUniqueBeanDefinitionException
		// because multiple beans of Student type exist
		// Student s = context.getBean(Student.class);
		// System.out.println("Student Roll no is " + s.getStudentId());
		// System.out.println("Student Name is " + s.getStudentName());

		// Get bean with name "student103"
		Student s1 = context.getBean("student103", Student.class);
		System.out.println("Student Roll no is " + s1.getStudentId());
		System.out.println("Student Name is " + s1.getStudentName());

		// Get bean with name "student104"
		Student s2 = context.getBean("student104", Student.class);
		System.out.println("Student Roll no is " + s2.getStudentId());
		System.out.println("Student Name is " + s2.getStudentName());

		// This will throw an error if "student105" bean does not exist
		Student s3 = context.getBean("student105", Student.class);
		System.out.println("Student Roll no is " + s3.getStudentId());
		System.out.println("Student Name is " + s3.getStudentName());
	}
}
