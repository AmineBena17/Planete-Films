/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;


import entities.*;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author l_a-b
 */
@Stateless
public class SearchService {
    
    @PersistenceContext
    private EntityManager em;
    

   public List<User> searchUser(String nom){
       Historique historique= new Historique();
       Query query= em.createQuery("SELECT a FROM User a WHERE a.nom=:nom OR a.email=:nom OR a.prenom=:nom OR a.telephone=:nom");
       query.setParameter("nom", nom);
       historique.setDate(new Date());
       historique.setMotrecherche(nom);
       em.persist(historique);
       return query.getResultList();
   } 
   

   public List<Etablissement> searchEtab(String nom){
       Historique historique= new Historique();
       Query q=em.createQuery("SELECT a FROM Etablissement a WHERE a.nom= :nom");
       q.setParameter("nom", nom);
       historique.setDate(new Date());
       historique.setMotrecherche(nom);

       em.persist(historique);
       return q.getResultList();
   }
   
      public List<Etablissement> searchEtabUser(String nom){
       Historiqueuser historique= new Historiqueuser();
       Query q=em.createQuery("SELECT a FROM Etablissement a WHERE a.nom LIKE :nom OR a.adresse LIKE :nom OR a.regionAdministrative LIKE :nom");
       q.setParameter("nom", nom);
       historique.setDate(new Date());
       historique.setMotrecherche(nom);
       em.persist(historique);
       return q.getResultList();
   }
   
   //chercher structure
    public List<Tournagefilmcourt> searchTournage(String nom){
        Historique historique= new Historique();
       Query q2=em.createQuery("SELECT a FROM Tournagefilmcourt a WHERE a.titre=:nom");
       q2.setParameter("nom", nom);
         historique.setDate(new Date());
       historique.setMotrecherche(nom);
       em.persist(historique);
       return q2.getResultList();
   }
    
       public List<Tournagefilmcourt> searchTournageUser(String nom){
       Historiqueuser historique= new Historiqueuser();
       Query q2=em.createQuery("SELECT a FROM Tournagefilmcourt a WHERE a.titre=:nom");
       q2.setParameter("nom", nom);
       historique.setDate(new Date());
       historique.setMotrecherche(nom);
       em.persist(historique);
       return q2.getResultList();
   }
    
    
    
}
