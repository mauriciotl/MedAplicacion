package test.manageBeans;

import datalayer.ejb.daos.MedicoFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
//import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


import model.entities.usuario.Medico;

@Named("test_addMedicoBean")
@RequestScoped
public class AddMedicoTestBean implements Serializable {

// ===================================== 
// = Attributes  = 
// ===================================== 

    @EJB
    MedicoFacade medicoFacade;
    
    private boolean isAdded = false;
    
    private String nombre;
    private String email;
    private String password;
    private String cedula;
    
    
// ===================================== 
// = Constructor(s)  = 
// ===================================== 

    
    public AddMedicoTestBean() {
    }
    
// ===================================== 
// = g / s  = 
// ===================================== 


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }


    //Es una variable de control

    public boolean isIsAdded() {
        return isAdded;
    }

    public void setIsAdded(boolean isAdded) {
        this.isAdded = isAdded;
    }
    
    
    
    
    
// ===================================== 
// = Other methods  = 
// ===================================== 

    
    public String testAddMedico(){
        
        Medico newMedico = new Medico(this.nombre, this.email, this.password, this.cedula);
        
        this.medicoFacade.create(newMedico);
        this.isAdded = true;
        
        System.out.println("Medico se ha agregado a DB");
        
        
        this.reset();
    
        return "/testPages/addUsuario.xhtml";
        
    }
    
// ===================================== 
// = Navigation methods  = 
// ===================================== 

    public String makeReset(){
        
       this.reset();
       return "/testPages/addUsuario.xhtml";
        
    }
    
    
// ===================================== 
// = Private Methods  = 
// ===================================== 

    
    private void reset(){
        
        this.isAdded = false;
        
        this.cedula = null;
        this.email = null;
        this.nombre = null;
        this.password = null;
        
    }
    
    
}
