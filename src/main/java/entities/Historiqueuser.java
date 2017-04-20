/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author l_a-b
 */
@Entity
@Table(name = "historiqueuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historiqueuser.findAll", query = "SELECT h FROM Historiqueuser h")
    , @NamedQuery(name = "Historiqueuser.findByIdhistouser", query = "SELECT h FROM Historiqueuser h WHERE h.idhistouser = :idhistouser")
    , @NamedQuery(name = "Historiqueuser.findByMotrecherche", query = "SELECT h FROM Historiqueuser h WHERE h.motrecherche = :motrecherche")
    , @NamedQuery(name = "Historiqueuser.findByDate", query = "SELECT h FROM Historiqueuser h WHERE h.date = :date")})
public class Historiqueuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhistouser")
    private Integer idhistouser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "motrecherche")
    private String motrecherche;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Historiqueuser() {
    }

    public Historiqueuser(Integer idhistouser) {
        this.idhistouser = idhistouser;
    }

    public Historiqueuser(Integer idhistouser, String motrecherche, Date date) {
        this.idhistouser = idhistouser;
        this.motrecherche = motrecherche;
        this.date = date;
    }

    public Integer getIdhistouser() {
        return idhistouser;
    }

    public void setIdhistouser(Integer idhistouser) {
        this.idhistouser = idhistouser;
    }

    public String getMotrecherche() {
        return motrecherche;
    }

    public void setMotrecherche(String motrecherche) {
        this.motrecherche = motrecherche;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhistouser != null ? idhistouser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historiqueuser)) {
            return false;
        }
        Historiqueuser other = (Historiqueuser) object;
        if ((this.idhistouser == null && other.idhistouser != null) || (this.idhistouser != null && !this.idhistouser.equals(other.idhistouser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Historiqueuser[ idhistouser=" + idhistouser + " ]";
    }
    
}
