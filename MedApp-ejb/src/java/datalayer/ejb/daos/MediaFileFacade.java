package datalayer.ejb.daos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entities.other.MediaFile;


@Stateless
public class MediaFileFacade extends AbstractFacade<MediaFile> {
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

    public MediaFileFacade() {
        super(MediaFile.class);
    }
    

}//MediaFileFacade
