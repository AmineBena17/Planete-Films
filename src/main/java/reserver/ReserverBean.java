/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reserver;

import beans.ReservationetablissementFacade;
import entities.Etablissement;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;
import entities.Reservationetablissement;
import entities.Reservationtournage;
import entities.Tournagefilmcourt;
import services.EtablissementController;
/**
 *
 * @author l_a-b
 */
@Named(value = "reserverBean")
@SessionScoped
public class ReserverBean implements Serializable {

    @Inject
    ReservationetablissementFacade reservationetablissementFacade;



    

    
    
    private Reservationetablissement reservationetablissement= new Reservationetablissement();

    public Reservationetablissement getReservationetablissement() {
        return reservationetablissement;
    }

    public void setReservationetablissement(Reservationetablissement reservationetablissement) {
        this.reservationetablissement = reservationetablissement;
    }
    
    
    public String reserverEtab(){
        this.reservationetablissementFacade.create(this.reservationetablissement);
        return "listeetab";
    }
    /**
     * Creates a new instance of ReserverBean
     */
    public ReserverBean() {
    }
    
}
