package local.tszolny.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Employee {
	@Id
	@TableGenerator(
			name = "mojGenerator",
			table = "generatory",
			pkColumnName = "nazwa_gen",
			pkColumnValue = "Pracownicy",
			valueColumnName = "licznik",
			initialValue = 10,
			allocationSize = 15)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "mojGenerator")
	private long id;
	private String firstName;
	private String lastName;
	private double salary;

	public Employee() {
	}

	public Employee(String firstName, String lastName, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public long getId() {
		return id;
	}
}
