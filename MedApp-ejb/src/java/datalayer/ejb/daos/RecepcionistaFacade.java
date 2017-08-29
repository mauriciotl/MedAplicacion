package datalayer.ejb.daos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entities.usuario.Recepcionista;


@Stateless
public class RecepcionistaFacade extends AbstractFacade<Recepcionista> {
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

    public RecepcionistaFacade() {
        super(Recepcionista.class);
    }
    

}//RecepcionistaFacade
