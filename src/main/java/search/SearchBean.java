/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import entities.*;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author l_a-b
 */
@Named(value = "searchBean")
@RequestScoped
public class SearchBean {

    @Inject
    SearchService service;
    


    private Tournagefilmcourt tournagefilmcourt= new Tournagefilmcourt();
    private Etablissement etablissement= new Etablissement();
    private User user= new User();
    private Reservationetablissement reservationetablissement=new Reservationetablissement();
    private Reservationtournage reservationtournage=new Reservationtournage();

    private List<User> list_user= new ArrayList<>();
    private List<Etablissement> list_etablissement= new ArrayList<>();
    private List<Tournagefilmcourt> list_filmcourt= new ArrayList<>();
    private List<Reservationetablissement> list_reservationetab= new ArrayList<>();
    private List<Reservationtournage> list_reservationtournage= new ArrayList<>();

    public Tournagefilmcourt getTournagefilmcourt() {
        return tournagefilmcourt;
    }

    public void setTournagefilmcourt(Tournagefilmcourt tournagefilmcourt) {
        this.tournagefilmcourt = tournagefilmcourt;
    }

    public Etablissement getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Reservationetablissement getReservationetablissement() {
        return reservationetablissement;
    }

    public void setReservationetablissement(Reservationetablissement reservationetablissement) {
        this.reservationetablissement = reservationetablissement;
    }

    public Reservationtournage getReservationtournage() {
        return reservationtournage;
    }

    public void setReservationtournage(Reservationtournage reservationtournage) {
        this.reservationtournage = reservationtournage;
    }

    public List<User> getList_user() {
        return list_user;
    }

    public void setList_user(List<User> list_user) {
        this.list_user = list_user;
    }

    public List<Etablissement> getList_etablissement() {
        return list_etablissement;
    }

    public void setList_etablissement(List<Etablissement> list_etablissement) {
        this.list_etablissement = list_etablissement;
    }

    public List<Tournagefilmcourt> getList_filmcourt() {
        return list_filmcourt;
    }

    public void setList_filmcourt(List<Tournagefilmcourt> list_filmcourt) {
        this.list_filmcourt = list_filmcourt;
    }

    public List<Reservationetablissement> getList_reservationetab() {
        return list_reservationetab;
    }

    public void setList_reservationetab(List<Reservationetablissement> list_reservationetab) {
        this.list_reservationetab = list_reservationetab;
    }

    public List<Reservationtournage> getList_reservationtournage() {
        return list_reservationtournage;
    }

    public void setList_reservationtournage(List<Reservationtournage> list_reservationtournage) {
        this.list_reservationtournage = list_reservationtournage;
    }
    
    
    
    
/*beans user*/
    

    
     public String chercherEtablissementUser(){
        
        this.list_etablissement=service.searchEtabUser(etablissement.getNom());
        return "ResultatEtabUser";
    }

    public String chercherTournageUser(){
        this.list_filmcourt=service.searchTournageUser(tournagefilmcourt.getTitre());
        return "ResultatLieuxUser";
        
    }
    
    /*admin*/
    
    
     public String chercherUser(){
        this.list_user=service.searchUser(user.getNom());
        return "RechercheUser";
    }
    
        public String chercherEtablissementAdmin(){
        this.list_etablissement=service.searchEtab(etablissement.getNom());
        return "ResultatEtabAdmin";
    }

    public String chercherTournageAdmin(){
        this.list_filmcourt=service.searchTournage(tournagefilmcourt.getTitre());
        return "ResultatLieuxAdmin";
    }
     
    
       public String chercherReservationEtablissement(){
        this.list_etablissement=service.searchEtab(etablissement.getNom());
        return "ResultatResEtabAdmin";
    }

    public String chercherReservationEtab(){
        this.list_filmcourt=service.searchTournage(tournagefilmcourt.getTitre());
        return "ResultatTournageAdmin";
    }
    /**
     * Creates a new instance of SearchBean
     */
    public SearchBean() {
    }
    
}
