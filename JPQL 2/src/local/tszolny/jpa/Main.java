package local.tszolny.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import local.tszolny.jpa.domain.Employee;

public class Main {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
    
	public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        entityManager = entityManagerFactory.createEntityManager();
        
        addEmployees();

//        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.salary > :minSalary", Employee.class);
//        query.setParameter("minSalary", 4000.0);
        
//        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.salary > ?1 and e.salary < ?2", Employee.class);
//        query.setParameter(1, 3000.0);
//        query.setParameter(2, 5500.0);

        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.lastName in :names", Employee.class);
        List<String> names = new ArrayList<>();
        names.add("Rodzynek");
        names.add("Nowak");
        query.setParameter("names", names); 
        
        List<Employee> result = query.getResultList();
        for (Employee e : result) {
			e.printData();
		}
        
        
        entityManager.close();
        entityManagerFactory.close();
    }
	
	public static void addEmployees() {
		addEmployee("Jan", "Nowak", 4533);
		addEmployee("Anna", "Nowak", 2300);
		addEmployee("Janina", "Wójcik", 4500);
		addEmployee("Karol", "Dybek", 8540);
		addEmployee("Wiktor", "Rodzynek", 4700);
		addEmployee("Alicja", "Lepsza", 3800);
		addEmployee("Zuzanna", "Nielepsza", 2690);
		addEmployee("Teodor", "Lutczyn", 5000);
	}
	
	public static void addEmployee(String firstName, String lastName, double salary) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary(salary);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
	}

}
