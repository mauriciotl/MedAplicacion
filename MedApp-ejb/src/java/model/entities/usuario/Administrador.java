package model.entities.usuario;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import model.entities.other.Expediente;


@Entity
public class Administrador extends Usuario implements Serializable {

    
// ===================================== 
// = Attributes  = 
// ===================================== 

    private static final long serialVersionUID = 1L;
    
    private String tipo;
    
    @OneToMany (cascade ={CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Expediente> expediente;

// ===================================== 
// = Constructor  = 
// ===================================== 
    
    public Administrador() {
    }

    //El Administrador puede nacer sin Expedientes
    public Administrador(String nombre, String email, String password, String tipo) {
        super(nombre, email, password);
        this.tipo = tipo;
    }

// ===================================== 
// = getters / setters                 = 
// ===================================== 
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Expediente> getExpediente() {
        return expediente;
    }

    public void setExpediente(List<Expediente> expediente) {
        this.expediente = expediente;
    }


}//Administrador
