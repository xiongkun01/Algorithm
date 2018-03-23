import java.util.Date;


class Employee implements Cloneable {

	public String name;
	public Date hireDay;

	public Employee(String name, Date hireDay) {
		this.name = name;
		this.hireDay = hireDay;
	}

	public Employee clone() throws CloneNotSupportedException { 
	
		return (Employee) super.clone();
	}

	/*
	public Employee clone() throws CloneNotSupportedException {
		Employee cloned = (Employee) super.clone();
		cloned.hireDay = (Date) hireDay.clone();

		return cloned;
	} */

}

public class TestDemo {
	public static void main(String[] args) throws Exception {

		Employee employee = new Employee("A", new Date());

		Employee employee2 = (Employee) employee.clone();

		Thread.sleep(5000);

		employee.hireDay = new Date();

		System.out.println(employee.hireDay + "  " + employee2.hireDay);
	}
}
