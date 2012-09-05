/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import persistencia.ObjetoPersistente;

/**
 *
 * @author LEO
 */
@Entity
public class Domicilio extends ObjetoPersistente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String descripcion;
    private String direccion;
    private String nombre;
    private String telefono;
    private String url_control;
    
    
    @OneToMany
    private List<Ambiente> ambientes;

    public List<Ambiente> getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(List<Ambiente> ambientes) {
        this.ambientes = ambientes;
    }

    public Estado_Domicilio getEstado_domicilio() {
        return estado_domicilio;
    }

    public void setEstado_domicilio(Estado_Domicilio estado_domicilio) {
        this.estado_domicilio = estado_domicilio;
    }
    
    @ManyToOne
    private Estado_Domicilio estado_domicilio;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUrl_control() {
        return url_control;
    }

    public void setUrl_control(String url_control) {
        this.url_control = url_control;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Domicilio)) {
            return false;
        }
        Domicilio other = (Domicilio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Negocio.Domicilio[ id=" + id + " ]";
    }
    
}
