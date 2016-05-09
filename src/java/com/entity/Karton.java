/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jelena.pajdic
 */
@Entity
@Table(name = "Karton")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Karton.findAll", query = "SELECT k FROM Karton k")})
public class Karton implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "jmbg")
    private String jmbg;
    @Column(name = "password")
    private String password;
    @Column(name = "ime")
    private String ime;
    @Column(name = "prezime")
    private String prezime;
    @Column(name = "telefon")
    private String telefon;
    @Column(name = "adresa")
    private String adresa;
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jmbg")
    private Collection<Lekarpacijent> lekarpacijentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jmbg")
    private Collection<Pregled> pregledCollection;

    public Karton() {
    }

    public Karton(String jmbg) {
        this.jmbg = jmbg;
    }

    public Karton(String jmbg, String password, String ime, String prezime, String telefon, String adresa, String email) {
        this.jmbg = jmbg;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
        this.adresa = adresa;
        this.email = email;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Lekarpacijent> getLekarpacijentCollection() {
        return lekarpacijentCollection;
    }

    public void setLekarpacijentCollection(Collection<Lekarpacijent> lekarpacijentCollection) {
        this.lekarpacijentCollection = lekarpacijentCollection;
    }

    @XmlTransient
    public Collection<Pregled> getPregledCollection() {
        return pregledCollection;
    }

    public void setPregledCollection(Collection<Pregled> pregledCollection) {
        this.pregledCollection = pregledCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jmbg != null ? jmbg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Karton)) {
            return false;
        }
        Karton other = (Karton) object;
        if ((this.jmbg == null && other.jmbg != null) || (this.jmbg != null && !this.jmbg.equals(other.jmbg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Karton[ jmbg=" + jmbg + " ]";
    }
    
}
