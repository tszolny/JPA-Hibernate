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
        employee.setFirstName("Zenon");
        employee.setLastName("Brzytwa");
        employee.setSalary(2300);
        Address address = new Address();
        address.setLocality("Kluczbork");
        address.setStreet("Krótka");
        address.setZipCode("34-544");
        address.setStreetNumber(43);
        employee.setAddress(address);
        
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        
        entityManager.close();
        entityManagerFactory.close();
    }
}
