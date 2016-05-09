/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jelena.pajdic
 */
@Entity
@Table(name = "lekarpacijent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lekarpacijent.findAll", query = "SELECT l FROM Lekarpacijent l")})
public class Lekarpacijent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "jmbg", referencedColumnName = "jmbg")
    @ManyToOne(optional = false)
    private Karton jmbg;
    @JoinColumn(name = "broj_licence", referencedColumnName = "broj_licence")
    @ManyToOne(optional = false)
    private Lekarfizo brojLicence;

    public Lekarpacijent() {
    }

    public Lekarpacijent(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Karton getJmbg() {
        return jmbg;
    }

    public void setJmbg(Karton jmbg) {
        this.jmbg = jmbg;
    }

    public Lekarfizo getBrojLicence() {
        return brojLicence;
    }

    public void setBrojLicence(Lekarfizo brojLicence) {
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
        if (!(object instanceof Lekarpacijent)) {
            return false;
        }
        Lekarpacijent other = (Lekarpacijent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Lekarpacijent[ id=" + id + " ]";
    }
    
}
