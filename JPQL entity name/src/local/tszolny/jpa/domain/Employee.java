package local.tszolny.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Pracownik")
@Table(name = "Pracownicy")
public class Employee {
	@Id
	@GeneratedValue
	private long id;
	private String firstName;
	private String lastName;
	private double salary;

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
	
	public void printData() {
		System.out.println("Employee data:");
		System.out.println("First name: " + getFirstName());
		System.out.println("Last name: " + getLastName());
		System.out.println("Salary: " + getSalary());
		System.out.println();
	}
}
