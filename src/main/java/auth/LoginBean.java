/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;


import entities.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import services.util.JsfUtil;
import utils.SessionUtils;

/**
 *
 * @author l_a-b
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    
    @Inject
    AuthService authService;
    

    User user=new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    
    
    
    /*auth medecin*/
    public String authUser(){
        boolean validerMed=authService.validateUser(user.getEmail(), user.getPassword());
        if(validerMed){
            HttpSession session=SessionUtils.getSession();
           session.setAttribute("login", user.getEmail());
            return "home";
        }
        else{
              JsfUtil.addErrorMessage("Erreur d'authentification : Email ou mot de passe invalide !");
            return "index";
        }
    }
    
        public String logout(){
        HttpSession session=SessionUtils.getSession();
        session.invalidate();
        return "/index";
    }
    
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
}
