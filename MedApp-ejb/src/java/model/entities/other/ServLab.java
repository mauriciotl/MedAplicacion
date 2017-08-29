package model.entities.other;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import model.entities.usuario.Recepcionista;


@Entity
public class ServLab implements Serializable {

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
    private Recepcionista recepcionista;

    @OneToMany (cascade ={CascadeType.ALL})
    private List<EstudioMed> estudiosMedicos;
    
    
// ===================================== 
// = Constructor(s=  = 
// ===================================== 
    
    public ServLab() {
    }

    //Nota el ServLab nace sin EstudiosMedicos
    public ServLab(String fecha, String descripcion, Recepcionista recepcionista) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.recepcionista = recepcionista;
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

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }

    public boolean isIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public List<EstudioMed> getEstudiosMedicos() {
        return estudiosMedicos;
    }

    public void setEstudiosMedicos(List<EstudioMed> estudiosMedicos) {
        this.estudiosMedicos = estudiosMedicos;
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
        if (!(object instanceof ServLab)) {
            return false;
        }
        ServLab other = (ServLab) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.other.ServicioLaboratorio[ id=" + id + " ]";
    }

    
    
    
}//ServicioLaboratorio
