/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Historiqueuser;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author l_a-b
 */
@Named(value = "historiqueManager")
@SessionScoped
public class HistoriqueManager implements Serializable {

    
    @Inject
    HistoriqueuserFacade facade;
    
    
    Historiqueuser historiqueuser= new Historiqueuser();

    public Historiqueuser getHistoriqueuser() {
        return historiqueuser;
    }

    public void setHistoriqueuser(Historiqueuser historiqueuser) {
        this.historiqueuser = historiqueuser;
    }
    
    
    
    public String deleteHistorique(){
        this.facade.remove(historiqueuser);
        return "List";
    }
    
    /**
     * Creates a new instance of HistoriqueManager
     */
    public HistoriqueManager() {
    }
    
}
