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
import model.entities.usuario.Paciente;


@Entity
public class Expediente implements Serializable {
    
    
// ===================================== 
// = Attributes  = 
// ===================================== 

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    private String fecha;
    
    
    @OneToOne (cascade ={CascadeType.PERSIST, CascadeType.REFRESH})
    private Paciente paciente;
    
    
    @OneToMany (cascade ={CascadeType.ALL})
    private List<ServLab> servicioLaboratorios;

    
// ===================================== 
// = constructor(s)  = 
// ===================================== 
    
    
    public Expediente() {
    }


    //Nace sin ServLab
    public Expediente(String fecha, Paciente paciente) {
        this.fecha = fecha;
        this.paciente = paciente;
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

    
    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<ServLab> getServicioLaboratorios() {
        return servicioLaboratorios;
    }

    public void setServicioLaboratorios(List<ServLab> servicioLaboratorios) {
        this.servicioLaboratorios = servicioLaboratorios;
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
        if (!(object instanceof Expediente)) {
            return false;
        }
        Expediente other = (Expediente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.other.Expediente[ id=" + id + " ]";
    }

}//Expediente
