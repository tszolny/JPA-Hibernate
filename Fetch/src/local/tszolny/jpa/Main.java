package local.tszolny.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import local.tszolny.jpa.domain.Employee;
import local.tszolny.jpa.domain.Phone;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = new Employee();
        employee.setFirstName("Ryszard");
        employee.setLastName("Krzysztowiak");
        employee.setSalary(5600);
        
        Phone phone1 = new Phone();
        phone1.setType("home");
        phone1.setNumber("42351541");
        
        Phone phone2 = new Phone();
        phone2.setType("office");
        phone2.setNumber("1234545");
        
        List<Phone> phones = new ArrayList<>();
        phones.add(phone1);
        phones.add(phone2);
        
        employee.setPhones(phones);
        
        
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.persist(phone1);
        entityManager.persist(phone2);
        entityManager.getTransaction().commit();
        
        entityManager.close();
        entityManagerFactory.close();
    }
}
