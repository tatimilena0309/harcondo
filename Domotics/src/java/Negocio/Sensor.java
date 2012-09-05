/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import persistencia.ObjetoPersistente;

/**
 *
 * @author LEO
 */
@Entity
public class Sensor extends ObjetoPersistente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_alta;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_ultima_modificacion;

    private int numero;

    private String numero_serie;
    
    @ManyToOne
    private Estado_Sensor estado_sensor;
    
    @ManyToOne
    private Modelo_Sensor modelo_sensor;

    public Estado_Sensor getEstado_sensor() {
        return estado_sensor;
    }

    public void setEstado_sensor(Estado_Sensor estado_sensor) {
        this.estado_sensor = estado_sensor;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public Date getFecha_ultima_modificacion() {
        return fecha_ultima_modificacion;
    }

    public void setFecha_ultima_modificacion(Date fecha_ultima_modificacion) {
        this.fecha_ultima_modificacion = fecha_ultima_modificacion;
    }

    public Modelo_Sensor getModelo_sensor() {
        return modelo_sensor;
    }

    public void setModelo_sensor(Modelo_Sensor modelo_sensor) {
        this.modelo_sensor = modelo_sensor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
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
        if (!(object instanceof Sensor)) {
            return false;
        }
        Sensor other = (Sensor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Negocio.Sensor[ id=" + id + " ]";
    }
    
}
