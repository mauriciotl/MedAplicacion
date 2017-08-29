package model.entities.other;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import model.entities.usuario.Medico;


@Entity
public class Interpretacion implements Serializable {
    
// ===================================== 
// = Attributes  = 
// ===================================== 

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String fecha;
    
    private String descripcion;
    
    private boolean isComplete = false;
    
    @OneToOne (cascade ={CascadeType.PERSIST, CascadeType.REFRESH})
    private Medico medico;

    
// ===================================== 
// = Constructor(s)  = 
// ===================================== 

    public Interpretacion() {
        
    }

    
    public Interpretacion(String fecha, String descripcion, Medico medico) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.medico = medico;
    }

    
// ===================================== 
// = g / s  = 
// ===================================== 
  
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public boolean isIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    
    
// ===================================== 
// = Overrided methods  = 
// ===================================== 


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interpretacion)) {
            return false;
        }
        Interpretacion other = (Interpretacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.other.Interpretacion[ id=" + id + " ]";
    }

    
    
}//Interpretacion
