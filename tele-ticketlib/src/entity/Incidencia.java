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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "incidencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incidencia.findAll", query = "SELECT i FROM Incidencia i")
    , @NamedQuery(name = "Incidencia.findByIdIncidencia", query = "SELECT i FROM Incidencia i WHERE i.idIncidencia = :idIncidencia")
    , @NamedQuery(name = "Incidencia.findByTitulo", query = "SELECT i FROM Incidencia i WHERE i.titulo = :titulo")
    , @NamedQuery(name = "Incidencia.findByDescripcion", query = "SELECT i FROM Incidencia i WHERE i.descripcion = :descripcion")
    , @NamedQuery(name = "Incidencia.findByUsuariomodifico", query = "SELECT i FROM Incidencia i WHERE i.usuariomodifico = :usuariomodifico")
    , @NamedQuery(name = "Incidencia.findByFechacreo", query = "SELECT i FROM Incidencia i WHERE i.fechacreo = :fechacreo")
    , @NamedQuery(name = "Incidencia.findByFechamodifico", query = "SELECT i FROM Incidencia i WHERE i.fechamodifico = :fechamodifico")
    , @NamedQuery(name = "Incidencia.findByStatus", query = "SELECT i FROM Incidencia i WHERE i.status = :status")})
public class Incidencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idIncidencia")
    private Integer idIncidencia;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "usuariomodifico")
    private String usuariomodifico;
    @Basic(optional = false)
    @Column(name = "fechacreo")
    @Temporal(TemporalType.DATE)
    private Date fechacreo;
    @Column(name = "fechamodifico")
    @Temporal(TemporalType.DATE)
    private Date fechamodifico;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIncidencia")
    private List<Ticket> ticketList;
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Incidencia() {
    }

    public Incidencia(Integer idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public Incidencia(Integer idIncidencia, String titulo, String descripcion, Date fechacreo, boolean status) {
        this.idIncidencia = idIncidencia;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechacreo = fechacreo;
        this.status = status;
    }

    public Integer getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(Integer idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUsuariomodifico() {
        return usuariomodifico;
    }

    public void setUsuariomodifico(String usuariomodifico) {
        this.usuariomodifico = usuariomodifico;
    }

    public Date getFechacreo() {
        return fechacreo;
    }

    public void setFechacreo(Date fechacreo) {
        this.fechacreo = fechacreo;
    }

    public Date getFechamodifico() {
        return fechamodifico;
    }

    public void setFechamodifico(Date fechamodifico) {
        this.fechamodifico = fechamodifico;
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

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIncidencia != null ? idIncidencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incidencia)) {
            return false;
        }
        Incidencia other = (Incidencia) object;
        if ((this.idIncidencia == null && other.idIncidencia != null) || (this.idIncidencia != null && !this.idIncidencia.equals(other.idIncidencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Incidencia[ idIncidencia=" + idIncidencia + " ]";
    }
    
}
