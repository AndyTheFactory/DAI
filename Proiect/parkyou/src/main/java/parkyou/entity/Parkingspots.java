/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkyou.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dell
 */
@Entity
@Table(catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parkingspots.findAll", query = "SELECT p FROM Parkingspots p"),
    @NamedQuery(name = "Parkingspots.findById", query = "SELECT p FROM Parkingspots p WHERE p.id = :id"),
    @NamedQuery(name = "Parkingspots.findByX1", query = "SELECT p FROM Parkingspots p WHERE p.x1 = :x1"),
    @NamedQuery(name = "Parkingspots.findByY1", query = "SELECT p FROM Parkingspots p WHERE p.y1 = :y1"),
    @NamedQuery(name = "Parkingspots.findByX2", query = "SELECT p FROM Parkingspots p WHERE p.x2 = :x2"),
    @NamedQuery(name = "Parkingspots.findByY2", query = "SELECT p FROM Parkingspots p WHERE p.y2 = :y2"),
    @NamedQuery(name = "Parkingspots.findByNrParkspaces", query = "SELECT p FROM Parkingspots p WHERE p.nrParkspaces = :nrParkspaces"),
    @NamedQuery(name = "Parkingspots.findByCreated", query = "SELECT p FROM Parkingspots p WHERE p.created = :created"),
    @NamedQuery(name = "Parkingspots.findByLastcheck", query = "SELECT p FROM Parkingspots p WHERE p.lastcheck = :lastcheck")})
public class Parkingspots implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int x1;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int y1;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int x2;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int y2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NR_PARKSPACES", nullable = false)
    private int nrParkspaces;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastcheck;

    public Parkingspots() {
    }

    public Parkingspots(Integer id) {
        this.id = id;
    }

    public Parkingspots(Integer id, int x1, int y1, int x2, int y2, int nrParkspaces, Date created) {
        this.id = id;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.nrParkspaces = nrParkspaces;
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public int getNrParkspaces() {
        return nrParkspaces;
    }

    public void setNrParkspaces(int nrParkspaces) {
        this.nrParkspaces = nrParkspaces;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastcheck() {
        return lastcheck;
    }

    public void setLastcheck(Date lastcheck) {
        this.lastcheck = lastcheck;
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
        if (!(object instanceof Parkingspots)) {
            return false;
        }
        Parkingspots other = (Parkingspots) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "parkyou.entity.Parkingspots[ id=" + id + " ]";
    }
    
}
