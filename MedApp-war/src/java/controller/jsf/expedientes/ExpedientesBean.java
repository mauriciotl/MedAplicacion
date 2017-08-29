package controller.jsf.expedientes;


import controller.jsf.logIn.LogInBean;
import datalayer.ejb.daos.ExpedienteFacade;
import datalayer.ejb.daos.UsuarioFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import model.entities.other.Expediente;

@Named(value = "expedientesBean")
@RequestScoped
public class ExpedientesBean {

    
// ===================================== 
// = Attributes  = 
// ===================================== 

    @EJB
    ExpedienteFacade expedienteDAO;
     
    @Inject
    LogInBean loginBean;
    
// ===================================== 
// = Constructor(s)  = 
// ===================================== 
    
    public ExpedientesBean() {
    }
    
    
// ===================================== 
// = g / s  = 
// ===================================== 
  
    
    
    
// ===================================== 
// = Methods  = 
// ===================================== 

    
    public List<Expediente> getExpedientes(){
        
        List<Expediente> expedientes = new ArrayList<>();
        
        expedientes = expedienteDAO.findAll();
        
        
        return expedientes;
    }
    
    
}
