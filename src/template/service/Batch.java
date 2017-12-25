package template.service;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import template.model.Users;
import template.repository.UserRepository;

@Service
public class Batch {
	@Autowired	private UserRepository userRepository;
	@SuppressWarnings("deprecation")
	public void run(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Connection");
	    EntityManager em = emf.createEntityManager();
	    em.getTransaction().begin();
	   
		Users user = new Users("juju", "juju","admin", "M", "Ciarma", "Julien", "fr");
		
		Users proprio = new Users("proprio", "proprio","proprio", "M", "Ciarma", "Julien", "fr");
		
		em.persist(proprio);
		em.persist(user);
	    em.getTransaction().commit();
	    em.close();
	    emf.close();
	}
}
