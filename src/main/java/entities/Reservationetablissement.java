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
@Table(name = "reservationetablissement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservationetablissement.findAll", query = "SELECT r FROM Reservationetablissement r")
    , @NamedQuery(name = "Reservationetablissement.findById", query = "SELECT r FROM Reservationetablissement r WHERE r.id = :id")
    , @NamedQuery(name = "Reservationetablissement.findByDate", query = "SELECT r FROM Reservationetablissement r WHERE r.date = :date")
    , @NamedQuery(name = "Reservationetablissement.findByEtablissement", query = "SELECT r FROM Reservationetablissement r WHERE r.etablissement = :etablissement")
    , @NamedQuery(name = "Reservationetablissement.findByPrix", query = "SELECT r FROM Reservationetablissement r WHERE r.prix = :prix")})
public class Reservationetablissement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "etablissement")
    private String etablissement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix")
    private double prix;

    public Reservationetablissement() {
    }

    public Reservationetablissement(Integer id) {
        this.id = id;
    }

    public Reservationetablissement(Integer id, Date date, String etablissement, double prix) {
        this.id = id;
        this.date = date;
        this.etablissement = etablissement;
        this.prix = prix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservationetablissement)) {
            return false;
        }
        Reservationetablissement other = (Reservationetablissement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Reservationetablissement[ id=" + id + " ]";
    }
    
}
