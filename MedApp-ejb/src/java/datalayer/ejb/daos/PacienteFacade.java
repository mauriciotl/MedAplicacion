package datalayer.ejb.daos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entities.usuario.Paciente;


@Stateless
public class PacienteFacade extends AbstractFacade<Paciente> {
    @PersistenceContext(unitName = "MedApp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

// ===================================== 
// = Attributes                        = 
// ===================================== 

    
    
// ===================================== 
// = Constructor(s)                    = 
// ===================================== 
  
    
    
// ===================================== 
// = getters / setters                 = 
// ===================================== 

    
    
// ===================================== 
// = other methods                     = 
// ===================================== 

    public PacienteFacade() {
        super(Paciente.class);
    }
    

}//PacienteFacade
