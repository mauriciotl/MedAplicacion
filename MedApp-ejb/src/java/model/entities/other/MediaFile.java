package model.entities.other;

import model.entities.enums.MediaType;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class MediaFile implements Serializable {

// ===================================== 
// = Attributes  = 
// ===================================== 

    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String descripcion;
    
    @Enumerated(EnumType.STRING) 
    private MediaType mediaType;
    
    private byte[] mediaBytes;
    
// ===================================== 
// = Constructor(s)  = 
// ===================================== 

    public MediaFile() {
    }
    
    
    public MediaFile(String descripcion, MediaType mediaType, byte[] mediaBytes) {
        this.descripcion = descripcion;
        this.mediaType = mediaType;
        this.mediaBytes = mediaBytes;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public byte[] getMediaBytes() {
        return mediaBytes;
    }

    public void setMediaBytes(byte[] mediaBytes) {
        this.mediaBytes = mediaBytes;
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
        if (!(object instanceof MediaFile)) {
            return false;
        }
        MediaFile other = (MediaFile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.mediafile.MediaFile[ id=" + id + " ]";
    }

    
    
}//MediaFile
