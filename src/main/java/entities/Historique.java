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
@Table(name = "historique")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historique.findAll", query = "SELECT h FROM Historique h")
    , @NamedQuery(name = "Historique.findByIdhistorique", query = "SELECT h FROM Historique h WHERE h.idhistorique = :idhistorique")
    , @NamedQuery(name = "Historique.findByMotrecherche", query = "SELECT h FROM Historique h WHERE h.motrecherche = :motrecherche")
    , @NamedQuery(name = "Historique.findByDate", query = "SELECT h FROM Historique h WHERE h.date = :date")})
public class Historique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_historique")
    private Integer idhistorique;
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

    public Historique() {
    }

    public Historique(Integer idhistorique) {
        this.idhistorique = idhistorique;
    }

    public Historique(Integer idhistorique, String motrecherche, Date date) {
        this.idhistorique = idhistorique;
        this.motrecherche = motrecherche;
        this.date = date;
    }

    public Integer getIdhistorique() {
        return idhistorique;
    }

    public void setIdhistorique(Integer idhistorique) {
        this.idhistorique = idhistorique;
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
        hash += (idhistorique != null ? idhistorique.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historique)) {
            return false;
        }
        Historique other = (Historique) object;
        if ((this.idhistorique == null && other.idhistorique != null) || (this.idhistorique != null && !this.idhistorique.equals(other.idhistorique))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Historique[ idhistorique=" + idhistorique + " ]";
    }
    
}
