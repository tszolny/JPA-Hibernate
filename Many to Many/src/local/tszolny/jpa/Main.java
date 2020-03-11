package local.tszolny.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import local.tszolny.jpa.domain.Employee;
import local.tszolny.jpa.domain.Project;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee1 = new Employee("Jan", "Nowak", 23425.5);      
        Employee employee2 = new Employee("Anna", "Dobra", 444334);
        Employee employee3 = new Employee("Zuzanna", "Kowalska", 4444);
        
        Project project1 = new Project();
        project1.setName("Project 1");
        
        Project project2 = new Project();
        project2.setName("Project 2");
        
        List<Employee> project1Employees = new ArrayList<>();
        project1Employees.add(employee2);
        project1Employees.add(employee1);
        project1Employees.add(employee3);

        List<Employee> project2Employees = new ArrayList<>();
        project2Employees.add(employee3);
        project2Employees.add(employee2);
        
        project1.setEmployees(project1Employees);
        project2.setEmployees(project2Employees);
        
        entityManager.getTransaction().begin();
        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(employee3);
        entityManager.persist(project1);
        entityManager.persist(project2);
        entityManager.getTransaction().commit();
        
        entityManager.refresh(employee1);
        entityManager.refresh(employee2);
        entityManager.refresh(employee3);
        
        
        entityManager.close();
        entityManagerFactory.close();
    }
}
