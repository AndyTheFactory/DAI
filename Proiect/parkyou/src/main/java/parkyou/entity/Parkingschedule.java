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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andrei
 */
@Entity
@Table(name = "PARKINGSCHEDULE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parkingschedule.findAll", query = "SELECT p FROM Parkingschedule p"),
    @NamedQuery(name = "Parkingschedule.findById", query = "SELECT p FROM Parkingschedule p WHERE p.id = :id"),
    @NamedQuery(name = "Parkingschedule.findByType", query = "SELECT p FROM Parkingschedule p WHERE p.type = :type"),
    @NamedQuery(name = "Parkingschedule.findByFromdate", query = "SELECT p FROM Parkingschedule p WHERE p.fromdate = :fromdate"),
    @NamedQuery(name = "Parkingschedule.findByTodate", query = "SELECT p FROM Parkingschedule p WHERE p.todate = :todate"),
    @NamedQuery(name = "Parkingschedule.findByFromtime", query = "SELECT p FROM Parkingschedule p WHERE p.fromtime = :fromtime"),
    @NamedQuery(name = "Parkingschedule.findByTotime", query = "SELECT p FROM Parkingschedule p WHERE p.totime = :totime"),
    @NamedQuery(name = "Parkingschedule.findByParkingid", query = "SELECT p FROM Parkingschedule p WHERE p.parkingid = :parkingid"),
    @NamedQuery(name = "Parkingschedule.findByDayofweek", query = "SELECT p FROM Parkingschedule p WHERE p.dayofweek = :dayofweek"),
    @NamedQuery(name = "Parkingschedule.findBySetbyuser", query = "SELECT p FROM Parkingschedule p WHERE p.setbyuser = :setbyuser"),
    @NamedQuery(name = "Parkingschedule.findBySetbyguest", query = "SELECT p FROM Parkingschedule p WHERE p.setbyguest = :setbyguest"),
    @NamedQuery(name = "Parkingschedule.findByMessage", query = "SELECT p FROM Parkingschedule p WHERE p.message = :message")})
public class Parkingschedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "TYPE")
    private String type;
    @Column(name = "FROMDATE")
    @Temporal(TemporalType.DATE)
    private Date fromdate;
    @Column(name = "TODATE")
    @Temporal(TemporalType.DATE)
    private Date todate;
    @Column(name = "FROMTIME")
    @Temporal(TemporalType.TIME)
    private Date fromtime;
    @Column(name = "TOTIME")
    @Temporal(TemporalType.TIME)
    private Date totime;
    @Column(name = "PARKINGID")
    private Integer parkingid;
    @Size(max = 50)
    @Column(name = "DAYOFWEEK")
    private String dayofweek;
    @Column(name = "SETBYUSER")
    private Integer setbyuser;
    @Size(max = 50)
    @Column(name = "SETBYGUEST")
    private String setbyguest;
    @Size(max = 500)
    @Column(name = "MESSAGE")
    private String message;
    
    @ManyToOne
    @JoinColumn(name="PARKINGID", insertable = false, updatable = false, nullable = true)
    private Parkingspot parkingspot;

    public Parkingschedule() {
    }

    public Parkingschedule(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public Date getTodate() {
        return todate;
    }

    public void setTodate(Date todate) {
        this.todate = todate;
    }

    public Date getFromtime() {
        return fromtime;
    }

    public void setFromtime(Date fromtime) {
        this.fromtime = fromtime;
    }

    public Date getTotime() {
        return totime;
    }

    public void setTotime(Date totime) {
        this.totime = totime;
    }

    public Integer getParkingid() {
        return parkingid;
    }

    public void setParkingid(Integer parkingid) {
        this.parkingid = parkingid;
    }

    public String getDayofweek() {
        return dayofweek;
    }

    public void setDayofweek(String dayofweek) {
        this.dayofweek = dayofweek;
    }

    public Integer getSetbyuser() {
        return setbyuser;
    }

    public void setSetbyuser(Integer setbyuser) {
        this.setbyuser = setbyuser;
    }

    public String getSetbyguest() {
        return setbyguest;
    }

    public void setSetbyguest(String setbyguest) {
        this.setbyguest = setbyguest;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Parkingspot getParkingspot() {
        return parkingspot;
    }

    public void setParkingspot(Parkingspot parkingspot) {
        this.parkingspot = parkingspot;
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
        if (!(object instanceof Parkingschedule)) {
            return false;
        }
        Parkingschedule other = (Parkingschedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "parkyou.entity.Parkingschedule[ id=" + id + " ]";
    }
    
}
