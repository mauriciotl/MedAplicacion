package datalayer.ejb.daos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entities.usuario.Medico;


@Stateless
public class MedicoFacade extends AbstractFacade<Medico> {
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

    public MedicoFacade() {
        super(Medico.class);
    }
    

}//MedicoFacade
