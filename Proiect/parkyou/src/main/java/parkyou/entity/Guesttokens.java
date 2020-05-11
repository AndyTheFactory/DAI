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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andrei
 */
@Entity
@Table(name = "GUESTTOKENS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Guesttokens.findAll", query = "SELECT g FROM Guesttokens g"),
    @NamedQuery(name = "Guesttokens.findById", query = "SELECT g FROM Guesttokens g WHERE g.id = :id"),
    @NamedQuery(name = "Guesttokens.findByCreationtime", query = "SELECT g FROM Guesttokens g WHERE g.creationtime = :creationtime"),
    @NamedQuery(name = "Guesttokens.findByName", query = "SELECT g FROM Guesttokens g WHERE g.name = :name"),
    @NamedQuery(name = "Guesttokens.findByEmail", query = "SELECT g FROM Guesttokens g WHERE g.email = :email"),
    @NamedQuery(name = "Guesttokens.findByMobile", query = "SELECT g FROM Guesttokens g WHERE g.mobile = :mobile"),
    @NamedQuery(name = "Guesttokens.findByToken", query = "SELECT g FROM Guesttokens g WHERE g.token = :token")})
public class Guesttokens implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATIONTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationtime;
    @Size(max = 250)
    @Column(name = "NAME")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 250)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 50)
    @Column(name = "MOBILE")
    private String mobile;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TOKEN")
    private String token;

    public Guesttokens() {
    }

    public Guesttokens(Integer id) {
        this.id = id;
    }

    public Guesttokens(Integer id, Date creationtime, String token) {
        this.id = id;
        this.creationtime = creationtime;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
        if (!(object instanceof Guesttokens)) {
            return false;
        }
        Guesttokens other = (Guesttokens) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "parkyou.entity.Guesttokens[ id=" + id + " ]";
    }
    
}
