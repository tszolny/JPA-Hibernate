package local.tszolny.jpa;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import local.tszolny.jpa.domain.Employee;

public class Main {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
    
	public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        entityManager = entityManagerFactory.createEntityManager();
        
        addEmployees();
        
//        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.lastName = 'Lepsza'", Employee.class);
//        Employee result = query.getSingleResult();
//        result.printData();
        
        
//        TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.salary between 4000 and 6000 order by e.salary", Employee.class);
//        List<Employee> result = query.getResultList();
//        for (Employee e : result) {
//			e.printData();
//		}
        
        Query query = entityManager.createQuery("select concat(e.firstName, ' ', e.lastName), e.salary * 0.2 from Employee e order by e.salary");
        List result = query.getResultList();
        Iterator iterator = result.iterator();
        while (iterator.hasNext()) {
        	Object[] employeeData = (Object[]) iterator.next();
        	String name = (String) employeeData[0];
        	double tax = (double) employeeData[1];
        	
        	System.out.println(name + " has to pay tax " + tax);
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
