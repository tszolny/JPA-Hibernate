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

        Professor professor = new Professor();
        professor.setFirstName("Karol");
        professor.setLastName("Dziubak");
        professor.setSalary(8900);
        
        Student student = new Student();
        student.setFirstName("Alina");
        student.setLastName("Zamorska");
        student.setAverageGrade(4.01);
        
        entityManager.getTransaction().begin();
        entityManager.persist(professor);
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        
        
        
        entityManager.close();
        entityManagerFactory.close();
    }
}
