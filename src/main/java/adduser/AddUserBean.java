/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adduser;

import beans.UserFacade;
import entities.User;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author l_a-b
 */
@Named(value = "addUserBean")
@RequestScoped
public class AddUserBean {

        @Inject
        UserFacade userFacade;
        
        
        private User user= new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
        
        
        public String addUser(){
            
            this.userFacade.create(this.user);
            return "index";
        }
  
    
    
    /**
     * Creates a new instance of AddUserBean
     */
    public AddUserBean() {
    }
    
    
    
    
}
