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
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import static javax.persistence.InheritanceType.SINGLE_TABLE;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jelena
 */

    @Entity
@Table(name = "LekarFizo")
 @Inheritance(strategy=SINGLE_TABLE)
@DiscriminatorColumn(name = "type")  
 
@XmlRootElement
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "broj_licence")
    protected String brojLicence;
    @Column(name = "password")
    private String password;
    @Column(name = "ime")
    private String ime;
    @Column(name = "prezime")
    private String prezime;
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "brojLicence")
    private Collection<Lekarpacijent> lekarpacijentCollection;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "brojLicence")
    private Collection<Pregled> pregledCollection;

    public AbstractEntity () {
    }

    public AbstractEntity (String brojLicence) {
        this.brojLicence = brojLicence;
    }

    public AbstractEntity (String brojLicence, String password, String ime, String prezime, String email) {
        this.brojLicence = brojLicence;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }

    public String getBrojLicence() {
        return brojLicence;
    }

    public void setBrojLicence(String brojLicence) {
        this.brojLicence = brojLicence;
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

    
    

}
