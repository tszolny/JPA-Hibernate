package local.tszolny.jpa.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	@ManyToMany
	@JoinTable(
			name = "Pracownicy_w_projektach",
			joinColumns = {@JoinColumn(name = "id_projektu")},
			inverseJoinColumns = {@JoinColumn(name = "id_pracownika")})
	private List<Employee> employees;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public long getId() {
		return id;
	}
}
