/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author LEO
 */
@Entity
public class Ambiente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numero;
    private String nombre;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date hora_ultimo_acceso;
    private int hora_actualizacion;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_ultima_modificacion;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_alta;
    private String descripcion;
    
    @OneToOne
    private Mensaje mensaje;
    
    @ManyToOne
    private Estado_Ambiente estado_ambiente;
    
    @ManyToOne
    private Tipo_Ambiente tipo_ambiente;
    
    @OneToOne
    private Sensor sensor;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado_Ambiente getEstado_ambiente() {
        return estado_ambiente;
    }

    public void setEstado_ambiente(Estado_Ambiente estado_ambiente) {
        this.estado_ambiente = estado_ambiente;
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

    public int getHora_actualizacion() {
        return hora_actualizacion;
    }

    public void setHora_actualizacion(int hora_actualizacion) {
        this.hora_actualizacion = hora_actualizacion;
    }

    public Date getHora_ultimo_acceso() {
        return hora_ultimo_acceso;
    }

    public void setHora_ultimo_acceso(Date hora_ultimo_acceso) {
        this.hora_ultimo_acceso = hora_ultimo_acceso;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Tipo_Ambiente getTipo_ambiente() {
        return tipo_ambiente;
    }

    public void setTipo_ambiente(Tipo_Ambiente tipo_ambiente) {
        this.tipo_ambiente = tipo_ambiente;
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
        if (!(object instanceof Ambiente)) {
            return false;
        }
        Ambiente other = (Ambiente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Negocio.Ambiente[ id=" + id + " ]";
    }
    
}
