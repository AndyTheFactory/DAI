/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkyou.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import jdk.internal.jline.internal.Nullable;

/**
 *
 * @author andrei
 */
@Entity(name = "Parkingspot")
@Table(name = "PARKINGSPOTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parkingspots.count", query = "SELECT count(p) FROM Parkingspot p"),
    @NamedQuery(name = "Parkingspots.countOwner", query = "SELECT count(p) FROM Parkingspot p where p.owner = :owner"),
    @NamedQuery(name = "Parkingspots.findAll", query = "SELECT p FROM Parkingspot p"),
    @NamedQuery(name = "Parkingspots.findByOwner", query = "SELECT p FROM Parkingspot p where p.owner = :owner"),
    @NamedQuery(name = "Parkingspots.findBySchedule", query = "SELECT p FROM Parkingspot p INNER JOIN p.schedules s where s.fromdate>=:fromdate and s.todate<=:todate")
        
})
public class Parkingspot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "X1")
    private int x1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Y1")
    private int y1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "X2")
    private int x2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Y2")
    private int y2;
    @Basic(optional = true)
    @Nullable
    @Column(name = "OWNER")
    private Integer owner;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
    @OneToMany
    private List<Parkingschedule> schedules;

    public Parkingspot() {
    }

    public Parkingspot(Integer id) {
        this.id = id;
    }

    public Parkingspot(Integer id, int x1, int y1, int x2, int y2,  Date created) {
        this.id = id;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }
    
    
    public List<Parkingschedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Parkingschedule> schedules) {
        this.schedules = schedules;
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
        if (!(object instanceof Parkingspot)) {
            return false;
        }
        Parkingspot other = (Parkingspot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "parkyou.entity.Parkingspots[ id=" + id + " ]";
    }

    public void setOwner(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
