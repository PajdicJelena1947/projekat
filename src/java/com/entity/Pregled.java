/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jelena.pajdic
 */
@Entity
@Table(name = "Pregled")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pregled.findAll", query = "SELECT p FROM Pregled p")})
public class Pregled implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "vreme")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vreme;
    @Column(name = "bolest")
    private String bolest;
    @Column(name = "dijagnoza")
    private String dijagnoza;
    @Column(name = "lekovi")
    private String lekovi;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "pregledId")
    private Collection<Terapija> terapijaCollection;
    @JoinColumn(name = "jmbg", referencedColumnName = "jmbg")
    @ManyToOne(optional = false)
    private Karton jmbg;
    @JoinColumn(name = "id_lekar", referencedColumnName = "broj_licence")
    @ManyToOne(optional = false)
    private Lekarfizo brojLicence;

    public Pregled() {
    }

    public Pregled(Integer id) {
        this.id = id;
    }

    public Pregled(Integer id, Date vreme, String bolest) {
        this.id = id;
        this.vreme = vreme;
        this.bolest = bolest;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getVreme() {
        return vreme;
    }

    public void setVreme(Date vreme) {
        this.vreme = vreme;
    }

    public String getBolest() {
        return bolest;
    }

    public void setBolest(String bolest) {
        this.bolest = bolest;
    }

    public String getDijagnoza() {
        return dijagnoza;
    }

    public void setDijagnoza(String dijagnoza) {
        this.dijagnoza = dijagnoza;
    }

    public String getLekovi() {
        return lekovi;
    }

    public void setLekovi(String lekovi) {
        this.lekovi = lekovi;
    }

    @XmlTransient
    public Collection<Terapija> getTerapijaCollection() {
        return terapijaCollection;
    }

    public void setTerapijaCollection(Collection<Terapija> terapijaCollection) {
        this.terapijaCollection = terapijaCollection;
    }

    public Karton getJmbg() {
        return jmbg;
    }

    public void setJmbg(Karton jmbg) {
        this.jmbg = jmbg;
    }

    public Lekarfizo getIdLekar() {
        return brojLicence;
    }

    public void setIdLekar(Lekarfizo brojLicence) {
        this.brojLicence = brojLicence;
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
        if (!(object instanceof Pregled)) {
            return false;
        }
        Pregled other = (Pregled) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Pregled[ id=" + id + " ]";
    }
    
}
