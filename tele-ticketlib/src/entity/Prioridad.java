/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "prioridad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prioridad.findAll", query = "SELECT p FROM Prioridad p")
    , @NamedQuery(name = "Prioridad.findByIdPrioridad", query = "SELECT p FROM Prioridad p WHERE p.idPrioridad = :idPrioridad")
    , @NamedQuery(name = "Prioridad.findByPrioridad", query = "SELECT p FROM Prioridad p WHERE p.prioridad = :prioridad")
    , @NamedQuery(name = "Prioridad.findByDescripcion", query = "SELECT p FROM Prioridad p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Prioridad.findByUsuariocreo", query = "SELECT p FROM Prioridad p WHERE p.usuariocreo = :usuariocreo")
    , @NamedQuery(name = "Prioridad.findByUsuariomodifico", query = "SELECT p FROM Prioridad p WHERE p.usuariomodifico = :usuariomodifico")
    , @NamedQuery(name = "Prioridad.findByFechamodifico", query = "SELECT p FROM Prioridad p WHERE p.fechamodifico = :fechamodifico")
    , @NamedQuery(name = "Prioridad.findByFechacreo", query = "SELECT p FROM Prioridad p WHERE p.fechacreo = :fechacreo")
    , @NamedQuery(name = "Prioridad.findByStatus", query = "SELECT p FROM Prioridad p WHERE p.status = :status")})
public class Prioridad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPrioridad")
    private Integer idPrioridad;
    @Basic(optional = false)
    @Column(name = "prioridad")
    private String prioridad;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "usuariocreo")
    private String usuariocreo;
    @Column(name = "usuariomodifico")
    private String usuariomodifico;
    @Column(name = "fechamodifico")
    @Temporal(TemporalType.DATE)
    private Date fechamodifico;
    @Basic(optional = false)
    @Column(name = "fechacreo")
    @Temporal(TemporalType.DATE)
    private Date fechacreo;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrioridad")
    private List<Ticket> ticketList;

    public Prioridad() {
    }

    public Prioridad(Integer idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public Prioridad(Integer idPrioridad, String prioridad, String descripcion, String usuariocreo, Date fechacreo, boolean status) {
        this.idPrioridad = idPrioridad;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
        this.usuariocreo = usuariocreo;
        this.fechacreo = fechacreo;
        this.status = status;
    }

    public Integer getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(Integer idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUsuariocreo() {
        return usuariocreo;
    }

    public void setUsuariocreo(String usuariocreo) {
        this.usuariocreo = usuariocreo;
    }

    public String getUsuariomodifico() {
        return usuariomodifico;
    }

    public void setUsuariomodifico(String usuariomodifico) {
        this.usuariomodifico = usuariomodifico;
    }

    public Date getFechamodifico() {
        return fechamodifico;
    }

    public void setFechamodifico(Date fechamodifico) {
        this.fechamodifico = fechamodifico;
    }

    public Date getFechacreo() {
        return fechacreo;
    }

    public void setFechacreo(Date fechacreo) {
        this.fechacreo = fechacreo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrioridad != null ? idPrioridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prioridad)) {
            return false;
        }
        Prioridad other = (Prioridad) object;
        if ((this.idPrioridad == null && other.idPrioridad != null) || (this.idPrioridad != null && !this.idPrioridad.equals(other.idPrioridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Prioridad[ idPrioridad=" + idPrioridad + " ]";
    }
    
}
