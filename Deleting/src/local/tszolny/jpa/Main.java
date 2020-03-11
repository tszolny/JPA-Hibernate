package local.tszolny.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import local.tszolny.jpa.domain.Employee;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = new Employee();
        employee.setFirstName("Anna");
        employee.setLastName("Wójcik");
        employee.setSalary(4532);
        
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        
        
        entityManager.getTransaction().begin();
        Employee foundEmployee = entityManager.find(Employee.class, 1L);
        if (!foundEmployee.equals(null)) {
        	foundEmployee.printData();
        	entityManager.remove(foundEmployee);
        }
        entityManager.getTransaction().commit();
        
        
        entityManager.close();
        entityManagerFactory.close();
    }

}
