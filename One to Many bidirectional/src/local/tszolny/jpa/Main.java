package local.tszolny.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import local.tszolny.jpa.domain.Employee;
import local.tszolny.jpa.domain.Phone;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Phone phone1 = new Phone();
        phone1.setType("mobile");
        phone1.setNumber("22345134");
        Phone phone2 = new Phone();
        phone2.setType("home");
        phone2.setNumber("764532435");
        Employee employee = new Employee();
        employee.setFirstName("Janina");
        employee.setLastName("Wygodna");
        employee.setSalary(564345);
        phone1.setOwner(employee);
        phone2.setOwner(employee);
        
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.persist(phone1);
        entityManager.persist(phone2);
        entityManager.getTransaction().commit();
        
        entityManager.refresh(employee);
        
        entityManager.close();
        entityManagerFactory.close();
    }
}
