package template.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import template.model.Users;

@Repository
@SuppressWarnings("unchecked")
@Transactional
public class UserRepository{

	@PersistenceContext
    EntityManager em;
	
	
	public void createUser(Users user) {
		em.persist(user);
	}
	
	public List<Users> getAllUser() {
               List<Users> userlist = em.createQuery("select u from Users u ORDER BY u.id")
                .getResultList();
           return userlist;     
    }
	

	
	public String getMaxIndex(){
		String res = (String) em.createQuery("Select MAX(u.id) from Users u")
                .getSingleResult();
        return res;
	}
	
	public void merge(Users user) {
		em.merge(user);
	}
	
	public void detacheEntity(Users user) {
		em.detach(user);
	}
	
	public void delete(Users user) {
		em.remove(user);
	}
	
	public Users find(Long id){
		return em.find(Users.class, id);
	}
	
	public Users findIdString(String id){
		Long stringid = Long.parseLong(id);
		return em.find(Users.class, stringid);
	}
	
	protected Users getSingleOrNullResult(Query query) {
        try {
            Users result = (Users)query.getSingleResult();
            return result;
        } catch (NoResultException nre) {
            return null;  // Normal, entity is just not found.
        }
    }
	
	public  Users getUserByUserName(String identifier) {
        return getSingleOrNullResult( 
                em.createQuery("select u from Users u where lower(u.pseudo) =:userName")
                .setParameter("userName", identifier.toLowerCase())
                );
    }
 
    public List<Users> findAll(){
        return  em.createQuery("select u from User u").getResultList();
    }
    
    public List<Users> searchUsers(String identifier){
        String name = "\\" +identifier.toUpperCase()+ "%";
        List<Users> results= em.createQuery("select u from User u where upper(u.userName) like :name or upper(u.firstName) like :name or upper(u.lastName) like :name ")
                .setParameter("name", name)
                .getResultList();
        return results;
    }
    
    public List<Users> getUserWithRoleNotNull(){
    	List<Users> results = (List<Users>) em.createQuery("select u from User u where u.role != null").getResultList();
		return results;
    }
    
    public List<Users> getUserWithPrivilegeNotEmpty(){ 
    	List<Users> results = (List<Users>) em.createQuery("select u from User u where size(u.privileges) != 0").getResultList();
		return results;
    }
    
    public List<Users> getUsersWithSpecialType(){
        List<Users> results = (List<Users>) em.createQuery("select u from User u where u.specialType != 'PRIVATE' order by u.specialType").getResultList();
        return results;
        
    }
    
    public Long findMaxIdValue(){
    	return (Long)em.createQuery("select max(u.id) from User u").getSingleResult();
    }
    
    
}
