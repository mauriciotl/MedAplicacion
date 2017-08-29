package model.entities.usuario;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Recepcionista extends Usuario implements Serializable {
   
    
// ===================================== 
// = Attributes  = 
// ===================================== 

    private static final long serialVersionUID = 1L;
    
    private String codigo;

   
    
    
// ===================================== 
// = Constructor  = 
// ===================================== 
    
    public Recepcionista() {
    }

    public Recepcionista(String nombre, String email, String password, String codigo) {
        super(nombre, email, password);
        this.codigo = codigo;
    }
    
    
// ===================================== 
// = getters / setters                 = 
// ===================================== 

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    
    

}//Recepcionista
