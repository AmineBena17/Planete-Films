/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reserver;

import beans.ReservationtournageFacade;

import entities.Reservationtournage;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author l_a-b
 */
@Named(value = "reserverFilm")
@RequestScoped
public class ReserverFilm {

    
    @Inject
    ReservationtournageFacade reservationtournageFacade;
    
    
    private Reservationtournage reservationtournage= new Reservationtournage();

    public Reservationtournage getReservationtournage() {
        return reservationtournage;
    }

    public void setReservationtournage(Reservationtournage reservationtournage) {
        this.reservationtournage = reservationtournage;
    }
    
    
     public String reserverFilm(){
        this.reservationtournageFacade.create(this.reservationtournage);
        return "listefilms";
    }
    
    
    /**
     * Creates a new instance of ReserverFilm
     */
    public ReserverFilm() {
    }
    
}
