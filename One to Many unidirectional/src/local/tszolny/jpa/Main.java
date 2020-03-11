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
        List<Phone> phoneList = new ArrayList<>();
        Phone phone1 = new Phone();
        phone1.setType("office");
        phone1.setNumber("3242983");
        Phone phone2 = new Phone();
        phone2.setType("home");
        phone2.setNumber("1234145125");
        phoneList.add(phone1);
        phoneList.add(phone2);
        employee.setFirstName("Urszula");
        employee.setLastName("Budzik");
        employee.setSalary(2324.6);
        employee.setPhones(phoneList);
                
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.persist(phone1);
        entityManager.persist(phone2);
        entityManager.getTransaction().commit();
        
        
        entityManager.close();
        entityManagerFactory.close();
    }
}
