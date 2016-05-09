/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Fizioterapeut;
import com.entity.Terapija;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jelena.pajdic
 */
@Service
public class FizioterapeutDaoImpl {
    @Autowired 
     private FizioterapeutDao fiziodao;
    
    @Autowired 
    private TerapijaDao terapijadao;
    
   @Transactional(readOnly=true)
    public List<Terapija> sveTerapije(String brojLicence){
        
        return terapijadao.findTop30All(brojLicence);
    }
    @Transactional(readOnly=true)
    public List<Terapija> terapijePacijenta(String jmbg){
        return terapijadao.findTop10ByJmbgPacijeta(jmbg);
    }
    @Transactional(readOnly=true)
     public boolean postojiFizp(String brojLicence,String password){
      
      int broj=fiziodao.countByBrojLicenceAndPassword(brojLicence, password).intValue();
      
      if(broj==0){
          return false;
      }
      return true;
  }
     @Transactional(readOnly=true)
    public boolean postojiTerapija(String brojLicence,Terapija t){
        int broj=terapijadao.countByPocetak(brojLicence,t.getPocetak()).intValue();
        if(broj==0){
            return false;
        }
        return true;
        
    }
    
    public void dodajTerapiju(String brojLicence,Terapija t){
        if(!postojiTerapija(brojLicence,t)){
            terapijadao.save(t);
        }
        else{
            System.out.println("ima terapija");
        }
        
    }
    @Transactional(readOnly=true)
    public Fizioterapeut nadjiPoLicenci(String jmbg){
        return fiziodao.findByBrojLicence(jmbg);
    }
    @Transactional
     public void saveFizio(Fizioterapeut f){
         fiziodao.save(f);
     }
     
}
