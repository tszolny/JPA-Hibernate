package local.tszolny.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import local.tszolny.jpa.domain.Address;
import local.tszolny.jpa.domain.Employee;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = new Employee();
        Address address = new Address();
        employee.setFirstName("Jan");
        employee.setLastName("Pasterniak");
        employee.setSalary(2345.2);
        employee.setAddress(address);
        address.setLocality("Opole");
        address.setZipCode("23-453");
        address.setStreet("Kluczborska");
        address.setStreetNumber(65);
        
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.persist(address);
        entityManager.getTransaction().commit();
        
        entityManager.close();
        entityManagerFactory.close();
    }
}
