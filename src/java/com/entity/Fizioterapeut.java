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
import javax.persistence.DiscriminatorValue;
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
@DiscriminatorValue("fizio")  
@XmlRootElement
public class Fizioterapeut extends AbstractEntity implements Serializable  {

    public Fizioterapeut() {
        super();
    }

    public Fizioterapeut(String brojLicence) {
           super(brojLicence);
    }

    public Fizioterapeut(String brojLicence, String password, String ime, String prezime, String email) {
             super(brojLicence,password,ime,prezime,email);
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brojLicence != null ? brojLicence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fizioterapeut)) {
            return false;
        }
        Fizioterapeut other = (Fizioterapeut) object;
        if ((this.brojLicence == null && other.brojLicence != null) || (this.brojLicence != null && !this.brojLicence.equals(other.brojLicence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entiti.Lekarfizo[ brojLicence=" + brojLicence + " ]";
    }
    
}

