/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.Serializable;
import javax.persistence.*;
import persistencia.ObjetoPersistente;

/**
 *
 * @author LEO
 */
@Entity
public class Modelo_Sensor extends ObjetoPersistente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String modelo;
    private String marca;
    private float distancia_deteccion_max;
    private float captacion_vertical;
    private float captacion_horizontal;
    
    @ManyToOne
    private Tipo_Sensor tipo_sensor;

    public Tipo_Sensor getTipo_sensor() {
        return tipo_sensor;
    }

    public void setTipo_sensor(Tipo_Sensor tipo_sensor) {
        this.tipo_sensor = tipo_sensor;
    }

    public float getCaptacion_horizontal() {
        return captacion_horizontal;
    }

    public void setCaptacion_horizontal(float captacion_horizontal) {
        this.captacion_horizontal = captacion_horizontal;
    }

    public float getCaptacion_vertical() {
        return captacion_vertical;
    }

    public void setCaptacion_vertical(float captacion_vertical) {
        this.captacion_vertical = captacion_vertical;
    }

    public float getDistancia_deteccion_max() {
        return distancia_deteccion_max;
    }

    public void setDistancia_deteccion_max(float distancia_deteccion_max) {
        this.distancia_deteccion_max = distancia_deteccion_max;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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
        if (!(object instanceof Modelo_Sensor)) {
            return false;
        }
        Modelo_Sensor other = (Modelo_Sensor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Negocio.Modelo_Sensor[ id=" + id + " ]";
    }
    
}
