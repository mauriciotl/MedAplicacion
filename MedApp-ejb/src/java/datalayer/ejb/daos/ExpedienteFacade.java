package datalayer.ejb.daos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entities.other.Expediente;


@Stateless
public class ExpedienteFacade extends AbstractFacade<Expediente> {
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

    public ExpedienteFacade() {
        super(Expediente.class);
    }
    

}//ExpedienteFacade
