package local.tszolny.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import local.tszolny.jpa.domain.Employee;

public class Main {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String[] args) {
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();

		addEmployees();

		Query query = entityManager.createQuery(
				"select avg(e.salary), min(e.salary), max(e.salary), sum(e.salary), count(e) from Employee e");
		Object[] result = (Object[]) query.getSingleResult();
		System.out.println("Średnia: " + result[0]);
		System.out.println("Minimalna:" + result[1]);
		System.out.println("Maksymalna: " + result[2]);
		System.out.println("Suma: " + result[3]);
		System.out.println("Pracowników: " + result[4]);

		query = entityManager.createQuery(
				"select substring(e.firstName,2,2), trim(e.lastName), upper(e.firstName), lower(e.firstName), length(e.firstName) from Employee e where e.firstName = 'Jan'");
		result = (Object[]) query.getSingleResult();
		System.out.println("Druga i trzecia litera imienia: " + result[0]);
		System.out.println("Nazwisko bez spacji: |" + result[1] + '|');
		System.out.println("Imię wielkimi literami: " + result[2]);
		System.out.println("Imię małymi literami: " + result[3]);
		System.out.println("Długość imienia: " + result[4]);

		entityManager.close();
		entityManagerFactory.close();
	}

	public static void addEmployees() {
		addEmployee("Jan", "     Nowak     ", 4533);
		addEmployee("Anna", "Nowak", 2300);
		addEmployee("Janina", "Wójcik", 4500);
		addEmployee("Karol", "Dybek", 8540);
		addEmployee("Wiktor", "Rodzynek", 4700);
		addEmployee("Alicja", "Lepsza", 3800);
		addEmployee("Zuzanna", "Nielepsza", 2690);
		addEmployee("Teodor", "Lutczyn", 5000);
	}

	public static void addEmployee(String firstName, String lastName, double salary) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary(salary);

		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
	}

}
