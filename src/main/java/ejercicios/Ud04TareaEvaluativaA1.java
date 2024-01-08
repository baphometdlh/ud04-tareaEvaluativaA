package ejercicios;

import entidades.*;

import java.time.LocalDate;

import jakarta.persistence.*;

public class Ud04TareaEvaluativaA1 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ud04");
		EntityManager entityManager = factory.createEntityManager();
		
		
		try {
			//creamos un objeto de student
			System.out.println("Cerando un nuevo objeto Student con su dirección y matrícula (tuition)");
			Student student = createStudent();
			Tuition tuition = new Tuition();
			tuition.setFee(1000.00);
			tuition.setStudent(student);
			student.setTuition(tuition);
			
			entityManager.getTransaction().begin();			
			
			System.out.println("Guardando el estudiante...");
			entityManager.persist(student);
			
			entityManager.getTransaction().commit();
			
			System.out.println("Hecho!");
			
			
		}
		catch (Exception e) {
			//hacemos rollback
			System.out.println("Realizando Rollback");
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			
		}
		finally {
			entityManager.close();
			factory.close();
		}
		
		
	}
	
	private static Student createStudent() {
		Student tempStudent = new Student();
		Address tempAddress = new Address();
		
		tempStudent.setFirstName("Lourdes");
		tempStudent.setLastName("Perez");
		tempStudent.setEmail("lperez@birt.eus");
		tempStudent.getPhones().add("123456789");
		tempStudent.getPhones().add("666333444");
		tempStudent.setBirthdate(LocalDate.parse("1979-03-05"));
		tempAddress.setAddressLine1("Calle arregitorre 10");
		tempAddress.setAddressLine2("7B");
		tempAddress.setCity("Elgoibar");
		tempAddress.setZipCode("20870");
		tempStudent.setAddress(tempAddress);
		
		return tempStudent;
		
	}

}
