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
@Table(name = "reservationtournage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservationtournage.findAll", query = "SELECT r FROM Reservationtournage r")
    , @NamedQuery(name = "Reservationtournage.findByIdreservationtournage", query = "SELECT r FROM Reservationtournage r WHERE r.idreservationtournage = :idreservationtournage")
    , @NamedQuery(name = "Reservationtournage.findByDate", query = "SELECT r FROM Reservationtournage r WHERE r.date = :date")
    , @NamedQuery(name = "Reservationtournage.findByLieux", query = "SELECT r FROM Reservationtournage r WHERE r.lieux = :lieux")
    , @NamedQuery(name = "Reservationtournage.findByPrix", query = "SELECT r FROM Reservationtournage r WHERE r.prix = :prix")})
public class Reservationtournage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreservationtournage")
    private Integer idreservationtournage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lieux")
    private String lieux;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix")
    private double prix;

    public Reservationtournage() {
    }

    public Reservationtournage(Integer idreservationtournage) {
        this.idreservationtournage = idreservationtournage;
    }

    public Reservationtournage(Integer idreservationtournage, Date date, String lieux, double prix) {
        this.idreservationtournage = idreservationtournage;
        this.date = date;
        this.lieux = lieux;
        this.prix = prix;
    }

    public Integer getIdreservationtournage() {
        return idreservationtournage;
    }

    public void setIdreservationtournage(Integer idreservationtournage) {
        this.idreservationtournage = idreservationtournage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLieux() {
        return lieux;
    }

    public void setLieux(String lieux) {
        this.lieux = lieux;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreservationtournage != null ? idreservationtournage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservationtournage)) {
            return false;
        }
        Reservationtournage other = (Reservationtournage) object;
        if ((this.idreservationtournage == null && other.idreservationtournage != null) || (this.idreservationtournage != null && !this.idreservationtournage.equals(other.idreservationtournage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Reservationtournage[ idreservationtournage=" + idreservationtournage + " ]";
    }
    
}
