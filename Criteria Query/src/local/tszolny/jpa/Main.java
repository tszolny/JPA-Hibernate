package local.tszolny.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import local.tszolny.jpa.domain.Employee;

public class Main {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        entityManager = entityManagerFactory.createEntityManager();

        addEmployees();
        
        // select e from Employee e where e.salary > 5000 and e.salary < 8000
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);
        Root<Employee> employee = criteriaQuery.from(Employee.class);
        
        Path<Double> salary = employee.get("salary");
        criteriaQuery.select(employee).where(builder.and(builder.greaterThan(salary, 5000.0), builder.lessThan(salary, 8000.0)));
        
        TypedQuery<Employee> query = entityManager.createQuery(criteriaQuery);
        List<Employee> employees = query.getResultList();
        
        for (Employee e : employees) {
			System.out.println(e.getFirstName());
			System.out.println(e.getLastName());
			System.out.println(e.getSalary());
			System.out.println();
		}
                
        entityManager.close();
        entityManagerFactory.close();    
    }
    
    public static void addEmployees() {
    	addEmployee("Janina", "Krzywousta", 5600);
    	addEmployee("Józef", "Bzyk", 4500);
    	addEmployee("Zenon", "Kosztowny", 4000);
    	addEmployee("Ryszard", "Zbych", 4300);
    	addEmployee("Ewelina", "Zawadzka", 3800);
    	addEmployee("Tomasz", "Trybik", 6780);
    	addEmployee("Waldemar", "Cichy", 4350);
    	addEmployee("Agata", "Zawadzka", 8700);
    }
    
    public static void addEmployee(String firstName, String lastName, double salary) {
    	Employee e = new Employee();
    	e.setFirstName(firstName);
    	e.setLastName(lastName);
    	e.setSalary(salary);
    	
    	entityManager.getTransaction().begin();
    	entityManager.persist(e);
    	entityManager.getTransaction().commit();
    }
    
}
