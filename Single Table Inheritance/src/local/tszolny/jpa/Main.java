package local.tszolny.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import local.tszolny.jpa.domain.Professor;
import local.tszolny.jpa.domain.Student;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Student	student = new Student();
        student.setFirstName("Adam");
        student.setLastName("Kowalski");
        student.setAverageGrade(4.32);
        
        Professor professor = new Professor();
        professor.setFirstName("Janina");
        professor.setLastName("Bednarek");
        professor.setSalary(5600);
        
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.persist(professor);
        entityManager.getTransaction().commit();
        
        
        entityManager.close();
        entityManagerFactory.close();
    }
}
