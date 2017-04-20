/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author l_a-b
 */
@Entity
@Table(name = "etablissement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etablissement.findAll", query = "SELECT e FROM Etablissement e")
    , @NamedQuery(name = "Etablissement.findByNauto", query = "SELECT e FROM Etablissement e WHERE e.nauto = :nauto")
    , @NamedQuery(name = "Etablissement.findByNom", query = "SELECT e FROM Etablissement e WHERE e.nom = :nom")
    , @NamedQuery(name = "Etablissement.findByAdresse", query = "SELECT e FROM Etablissement e WHERE e.adresse = :adresse")
    , @NamedQuery(name = "Etablissement.findByComplement", query = "SELECT e FROM Etablissement e WHERE e.complement = :complement")
    , @NamedQuery(name = "Etablissement.findByCodeINSEE", query = "SELECT e FROM Etablissement e WHERE e.codeINSEE = :codeINSEE")
    , @NamedQuery(name = "Etablissement.findByCommune", query = "SELECT e FROM Etablissement e WHERE e.commune = :commune")
    , @NamedQuery(name = "Etablissement.findByRegionAdministrative", query = "SELECT e FROM Etablissement e WHERE e.regionAdministrative = :regionAdministrative")
    , @NamedQuery(name = "Etablissement.findByGeoBan", query = "SELECT e FROM Etablissement e WHERE e.geoBan = :geoBan")
    , @NamedQuery(name = "Etablissement.findByGeoInsee", query = "SELECT e FROM Etablissement e WHERE e.geoInsee = :geoInsee")
    , @NamedQuery(name = "Etablissement.findByCorrdonneesFinales", query = "SELECT e FROM Etablissement e WHERE e.corrdonneesFinales = :corrdonneesFinales")
    , @NamedQuery(name = "Etablissement.findByIdEtab", query = "SELECT e FROM Etablissement e WHERE e.idEtab = :idEtab")})
public class Etablissement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "N_auto")
    private Integer nauto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "adresse")
    private String adresse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "complement")
    private String complement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "code_INSEE")
    private int codeINSEE;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "commune")
    private String commune;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "region_administrative")
    private String regionAdministrative;
    @Size(max = 255)
    @Column(name = "geo_ban")
    private String geoBan;
    @Size(max = 255)
    @Column(name = "geo_insee")
    private String geoInsee;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "corrdonnees_finales")
    private String corrdonneesFinales;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_etab")
    private Integer idEtab;

    public Etablissement() {
    }

    public Etablissement(Integer idEtab) {
        this.idEtab = idEtab;
    }

    public Etablissement(Integer idEtab, String nom, String adresse, String complement, int codeINSEE, String commune, String regionAdministrative, String corrdonneesFinales) {
        this.idEtab = idEtab;
        this.nom = nom;
        this.adresse = adresse;
        this.complement = complement;
        this.codeINSEE = codeINSEE;
        this.commune = commune;
        this.regionAdministrative = regionAdministrative;
        this.corrdonneesFinales = corrdonneesFinales;
    }

    public Integer getNauto() {
        return nauto;
    }

    public void setNauto(Integer nauto) {
        this.nauto = nauto;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public int getCodeINSEE() {
        return codeINSEE;
    }

    public void setCodeINSEE(int codeINSEE) {
        this.codeINSEE = codeINSEE;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getRegionAdministrative() {
        return regionAdministrative;
    }

    public void setRegionAdministrative(String regionAdministrative) {
        this.regionAdministrative = regionAdministrative;
    }

    public String getGeoBan() {
        return geoBan;
    }

    public void setGeoBan(String geoBan) {
        this.geoBan = geoBan;
    }

    public String getGeoInsee() {
        return geoInsee;
    }

    public void setGeoInsee(String geoInsee) {
        this.geoInsee = geoInsee;
    }

    public String getCorrdonneesFinales() {
        return corrdonneesFinales;
    }

    public void setCorrdonneesFinales(String corrdonneesFinales) {
        this.corrdonneesFinales = corrdonneesFinales;
    }

    public Integer getIdEtab() {
        return idEtab;
    }

    public void setIdEtab(Integer idEtab) {
        this.idEtab = idEtab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEtab != null ? idEtab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etablissement)) {
            return false;
        }
        Etablissement other = (Etablissement) object;
        if ((this.idEtab == null && other.idEtab != null) || (this.idEtab != null && !this.idEtab.equals(other.idEtab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Etablissement[ idEtab=" + idEtab + " ]";
    }
    
}
