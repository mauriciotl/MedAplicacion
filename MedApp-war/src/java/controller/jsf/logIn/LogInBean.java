package controller.jsf.logIn;

import datalayer.ejb.daos.UsuarioFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import model.entities.usuario.Usuario;

@Named(value = "logInBean")
@SessionScoped
public class LogInBean implements Serializable {
    

// ===================================== 
// = Attributes  = 
// ===================================== 
    
    @EJB
    UsuarioFacade usuarioDAO;
    
    private String email;
    private String password;
    private Usuario usuario;
    
    
// ===================================== 
// = Constructor(s)  = 
// ===================================== 


    public LogInBean() {
    }
    
// ===================================== 
// = g / s  = 
// ===================================== 
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
// ===================================== 
// = Methods   = 
// ===================================== 

    public String verificaUser(){
        
        List<Usuario> usuarios = new ArrayList<>();
        usuarios = usuarioDAO.findAll();
        
        
        for(Usuario u: usuarios){
            if(u.getEmail().equalsIgnoreCase(this.email) && 
                    u.getPassword().equalsIgnoreCase(this.password)){
                
                System.out.println("Acceso correcto");
                
                return "/webApp/expedientes/expedientes";
            }
        }
        
        return "index";
    }
    
    
    
    
    
}
