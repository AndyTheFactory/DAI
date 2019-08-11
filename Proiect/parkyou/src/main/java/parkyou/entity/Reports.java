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
    @NamedQuery(name = "Reports.findAll", query = "SELECT r FROM Reports r"),
    @NamedQuery(name = "Reports.findById", query = "SELECT r FROM Reports r WHERE r.id = :id"),
    @NamedQuery(name = "Reports.findByParkingspotId", query = "SELECT r FROM Reports r WHERE r.parkingspotId = :parkingspotId"),
    @NamedQuery(name = "Reports.findByCreated", query = "SELECT r FROM Reports r WHERE r.created = :created"),
    @NamedQuery(name = "Reports.findByFreespots", query = "SELECT r FROM Reports r WHERE r.freespots = :freespots"),
    @NamedQuery(name = "Reports.findByIsObsolete", query = "SELECT r FROM Reports r WHERE r.isObsolete = :isObsolete"),
    @NamedQuery(name = "Reports.findByUserId", query = "SELECT r FROM Reports r WHERE r.userId = :userId")})
public class Reports implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PARKINGSPOT_ID", nullable = false)
    private int parkingspotId;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int freespots;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_OBSOLETE", nullable = false)
    private Boolean isObsolete;
    @Column(name = "USER_ID")
    private Integer userId;

    public Reports() {
    }

    public Reports(Integer id) {
        this.id = id;
    }

    public Reports(Integer id, int parkingspotId, Date created, int freespots, Boolean isObsolete) {
        this.id = id;
        this.parkingspotId = parkingspotId;
        this.created = created;
        this.freespots = freespots;
        this.isObsolete = isObsolete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getParkingspotId() {
        return parkingspotId;
    }

    public void setParkingspotId(int parkingspotId) {
        this.parkingspotId = parkingspotId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getFreespots() {
        return freespots;
    }

    public void setFreespots(int freespots) {
        this.freespots = freespots;
    }

    public Boolean getIsObsolete() {
        return isObsolete;
    }

    public void setIsObsolete(Boolean isObsolete) {
        this.isObsolete = isObsolete;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        if (!(object instanceof Reports)) {
            return false;
        }
        Reports other = (Reports) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "parkyou.entity.Reports[ id=" + id + " ]";
    }
    
}
