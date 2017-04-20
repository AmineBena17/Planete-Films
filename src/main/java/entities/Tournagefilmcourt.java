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
@Table(name = "tournagefilmcourt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tournagefilmcourt.findAll", query = "SELECT t FROM Tournagefilmcourt t")
    , @NamedQuery(name = "Tournagefilmcourt.findByTitre", query = "SELECT t FROM Tournagefilmcourt t WHERE t.titre = :titre")
    , @NamedQuery(name = "Tournagefilmcourt.findByRealisateur", query = "SELECT t FROM Tournagefilmcourt t WHERE t.realisateur = :realisateur")
    , @NamedQuery(name = "Tournagefilmcourt.findByDateDebutEvenement", query = "SELECT t FROM Tournagefilmcourt t WHERE t.dateDebutEvenement = :dateDebutEvenement")
    , @NamedQuery(name = "Tournagefilmcourt.findByDateFinEvenement", query = "SELECT t FROM Tournagefilmcourt t WHERE t.dateFinEvenement = :dateFinEvenement")
    , @NamedQuery(name = "Tournagefilmcourt.findByCadre", query = "SELECT t FROM Tournagefilmcourt t WHERE t.cadre = :cadre")
    , @NamedQuery(name = "Tournagefilmcourt.findByLieu", query = "SELECT t FROM Tournagefilmcourt t WHERE t.lieu = :lieu")
    , @NamedQuery(name = "Tournagefilmcourt.findByAdresse", query = "SELECT t FROM Tournagefilmcourt t WHERE t.adresse = :adresse")
    , @NamedQuery(name = "Tournagefilmcourt.findByArrondissement", query = "SELECT t FROM Tournagefilmcourt t WHERE t.arrondissement = :arrondissement")
    , @NamedQuery(name = "Tournagefilmcourt.findByAdresseComplete", query = "SELECT t FROM Tournagefilmcourt t WHERE t.adresseComplete = :adresseComplete")
    , @NamedQuery(name = "Tournagefilmcourt.findByGeoCoordinates", query = "SELECT t FROM Tournagefilmcourt t WHERE t.geoCoordinates = :geoCoordinates")
    , @NamedQuery(name = "Tournagefilmcourt.findByIdTournagefilm", query = "SELECT t FROM Tournagefilmcourt t WHERE t.idTournagefilm = :idTournagefilm")})
public class Tournagefilmcourt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "titre")
    private String titre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "realisateur")
    private String realisateur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_debut_evenement")
    @Temporal(TemporalType.DATE)
    private Date dateDebutEvenement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_fin_evenement")
    @Temporal(TemporalType.DATE)
    private Date dateFinEvenement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cadre")
    private String cadre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "lieu")
    private String lieu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "arrondissement")
    private Integer arrondissement;
    @Size(max = 255)
    @Column(name = "adresse_complete")
    private String adresseComplete;
    @Size(max = 255)
    @Column(name = "geo_coordinates")
    private String geoCoordinates;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tournagefilm")
    private Integer idTournagefilm;

    public Tournagefilmcourt() {
    }

    public Tournagefilmcourt(Integer idTournagefilm) {
        this.idTournagefilm = idTournagefilm;
    }

    public Tournagefilmcourt(Integer idTournagefilm, String titre, String realisateur, Date dateDebutEvenement, Date dateFinEvenement, String cadre, String lieu, String adresse) {
        this.idTournagefilm = idTournagefilm;
        this.titre = titre;
        this.realisateur = realisateur;
        this.dateDebutEvenement = dateDebutEvenement;
        this.dateFinEvenement = dateFinEvenement;
        this.cadre = cadre;
        this.lieu = lieu;
        this.adresse = adresse;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public Date getDateDebutEvenement() {
        return dateDebutEvenement;
    }

    public void setDateDebutEvenement(Date dateDebutEvenement) {
        this.dateDebutEvenement = dateDebutEvenement;
    }

    public Date getDateFinEvenement() {
        return dateFinEvenement;
    }

    public void setDateFinEvenement(Date dateFinEvenement) {
        this.dateFinEvenement = dateFinEvenement;
    }

    public String getCadre() {
        return cadre;
    }

    public void setCadre(String cadre) {
        this.cadre = cadre;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getArrondissement() {
        return arrondissement;
    }

    public void setArrondissement(Integer arrondissement) {
        this.arrondissement = arrondissement;
    }

    public String getAdresseComplete() {
        return adresseComplete;
    }

    public void setAdresseComplete(String adresseComplete) {
        this.adresseComplete = adresseComplete;
    }

    public String getGeoCoordinates() {
        return geoCoordinates;
    }

    public void setGeoCoordinates(String geoCoordinates) {
        this.geoCoordinates = geoCoordinates;
    }

    public Integer getIdTournagefilm() {
        return idTournagefilm;
    }

    public void setIdTournagefilm(Integer idTournagefilm) {
        this.idTournagefilm = idTournagefilm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTournagefilm != null ? idTournagefilm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tournagefilmcourt)) {
            return false;
        }
        Tournagefilmcourt other = (Tournagefilmcourt) object;
        if ((this.idTournagefilm == null && other.idTournagefilm != null) || (this.idTournagefilm != null && !this.idTournagefilm.equals(other.idTournagefilm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tournagefilmcourt[ idTournagefilm=" + idTournagefilm + " ]";
    }
    
}
