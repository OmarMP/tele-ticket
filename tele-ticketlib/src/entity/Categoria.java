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
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
    , @NamedQuery(name = "Categoria.findByIdCategoria", query = "SELECT c FROM Categoria c WHERE c.idCategoria = :idCategoria")
    , @NamedQuery(name = "Categoria.findByCategoria", query = "SELECT c FROM Categoria c WHERE c.categoria = :categoria")
    , @NamedQuery(name = "Categoria.findByDescricion", query = "SELECT c FROM Categoria c WHERE c.descricion = :descricion")
    , @NamedQuery(name = "Categoria.findByUsuariocreo", query = "SELECT c FROM Categoria c WHERE c.usuariocreo = :usuariocreo")
    , @NamedQuery(name = "Categoria.findByUsuariomodifico", query = "SELECT c FROM Categoria c WHERE c.usuariomodifico = :usuariomodifico")
    , @NamedQuery(name = "Categoria.findByFechamodifico", query = "SELECT c FROM Categoria c WHERE c.fechamodifico = :fechamodifico")
    , @NamedQuery(name = "Categoria.findByFechacreo", query = "SELECT c FROM Categoria c WHERE c.fechacreo = :fechacreo")
    , @NamedQuery(name = "Categoria.findByStatus", query = "SELECT c FROM Categoria c WHERE c.status = :status")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCategoria")
    private Integer idCategoria;
    @Basic(optional = false)
    @Column(name = "categoria")
    private String categoria;
    @Basic(optional = false)
    @Column(name = "descricion")
    private String descricion;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoria")
    private List<Incidencia> incidenciaList;

    public Categoria() {
    }

    public Categoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Categoria(Integer idCategoria, String categoria, String descricion, String usuariocreo, Date fechacreo, boolean status) {
        this.idCategoria = idCategoria;
        this.categoria = categoria;
        this.descricion = descricion;
        this.usuariocreo = usuariocreo;
        this.fechacreo = fechacreo;
        this.status = status;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
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
    public List<Incidencia> getIncidenciaList() {
        return incidenciaList;
    }

    public void setIncidenciaList(List<Incidencia> incidenciaList) {
        this.incidenciaList = incidenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoria != null ? idCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Categoria[ idCategoria=" + idCategoria + " ]";
    }
    
}
