package local.tszolny.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import local.tszolny.jpa.domain.Cat;
import local.tszolny.jpa.domain.Owner;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Owner owner = new Owner();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        cat1.setName("Binkie");
        cat2.setName("Pooch");
        owner.setFirstName("Antoni");
        owner.setLastName("Kulczycki");
        owner.setCat(cat2);
        
        entityManager.getTransaction().begin();
        entityManager.persist(owner);
        entityManager.persist(cat1);
        entityManager.persist(cat2);
        entityManager.getTransaction().commit();
        
        entityManager.refresh(cat2);        
        
        entityManager.close();
        entityManagerFactory.close();
    }
}
