package ejercicios;

import entidades.*;

import jakarta.persistence.*;

public class Ud04TareaEvaluativaA2 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ud04");
		EntityManager entityManager = factory.createEntityManager();
		
		try {
			System.out.println("Borrando un nuevo Student y en cascada su Tuition asociado");
			int student_id = 9;
			
			Student tempStudent = entityManager.getReference(Student.class, student_id);
			
			entityManager.getTransaction().begin();
			
			entityManager.remove(tempStudent);
			
			entityManager.getTransaction().commit();
			
			System.out.println("Hecho!");
		}
		catch(Exception e) {
			//hacemos rollback
			System.out.println("Realizando Rollback...");
			entityManager.getTransaction().rollback();
			e.printStackTrace();			
		}
		finally {
			entityManager.close();
			factory.close();			
		}

	}

}
