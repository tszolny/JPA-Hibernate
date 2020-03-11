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
        professor.setFirstName("Ryszard");
        professor.setLastName("Zembowski");
        professor.setSalary(7500);
        
        Student student = new Student();
        student.setFirstName("Zuzanna");
        student.setLastName("Waleczna");
        student.setAverageGrade(3.54);
        
        entityManager.getTransaction().begin();
        entityManager.persist(professor);
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        
        entityManager.close();
        entityManagerFactory.close();
    }
}
