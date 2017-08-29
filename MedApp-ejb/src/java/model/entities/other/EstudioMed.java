package model.entities.other;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import model.entities.enums.EstudioType;
import model.entities.usuario.Tecnico;


@Entity
public class EstudioMed implements Serializable {
    
    
// ===================================== 
// = Attributes  = 
// ===================================== 

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double costo;
    
    private String fecha;
    
    boolean isComplete = false;
    
    @Enumerated(EnumType.STRING) 
    private EstudioType estudioType;
    
    @OneToOne (cascade ={CascadeType.PERSIST, CascadeType.REFRESH})
    private Tecnico tecnico;
    
    @OneToOne (cascade ={CascadeType.ALL})
    private Interpretacion interpretacion;
    
    @OneToMany (cascade ={CascadeType.ALL})
    private List<MediaFile> mediaFiles;
    
    
// ===================================== 
// = Constructor(s)  = 
// ===================================== 

    public EstudioMed() {
    }

    //Nota. El EstudioMed nace sin Interpretacion y sin MediaFile
    public EstudioMed(EstudioType estudioType, double costo, String fecha, Tecnico tecnico) {
        this.estudioType = estudioType;
        this.costo = costo;
        this.fecha = fecha;
        this.tecnico = tecnico;
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

    public EstudioType getEstudioType() {
        return estudioType;
    }

    public void setEstudioType(EstudioType estudioType) {
        this.estudioType = estudioType;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Interpretacion getInterpretacion() {
        return interpretacion;
    }

    public void setInterpretacion(Interpretacion interpretacion) {
        this.interpretacion = interpretacion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public List<MediaFile> getMediaFiles() {
        return mediaFiles;
    }

    public void setMediaFiles(List<MediaFile> mediaFiles) {
        this.mediaFiles = mediaFiles;
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
        if (!(object instanceof EstudioMed)) {
            return false;
        }
        EstudioMed other = (EstudioMed) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.other.EstudioMedico[ id=" + id + " ]";
    }


}//EstudioMedico
