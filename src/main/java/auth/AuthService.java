/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

import entities.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author l_a-b
 */

@Stateless
public class AuthService {
        
    
     @PersistenceContext
     private EntityManager em;
     
     public boolean validateUser(String email, String password){
         
         try {
             Query query=em.createQuery("SELECT u FROM User u WHERE u.email=:email AND u.password=:password");
             query.setParameter("email", email);
             query.setParameter("password", password);
             User user= (User) query.getSingleResult();
             if(user instanceof User){
                 return true;
             }
             
         } catch (NoResultException e) {
         }
         return false;
     }
     
     
     public boolean validateAdmin(String email, String password){
         try {
             Query q=em.createQuery("SELECT a FROM Admin a WHERE a.email=:email AND a.password=:password");
             q.setParameter("email", email);
             q.setParameter("password", password);
             Admin admin=(Admin) q.getSingleResult();
             if(admin instanceof Admin){
                 return true;
             }
         } catch (NoResultException e) {
         }
         return false;
     }
    
     
     
   
     
}
