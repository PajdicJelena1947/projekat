/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Karton;
import com.entity.Lekarfizo;
import com.entity.Pregled;
import com.entity.Terapija;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jelena.pajdic
 */

@Service
public class LekarDaoImpl {
    
    @Autowired
    private LekarDao lekarDao;
    @Autowired 
    private PregeldDao pregledDao;
    @Autowired 
    private TerapijaDao terapijaDao;
    @Autowired 
    private KartonDao kartonDao;
    
    
   @Transactional(readOnly=true)
  public Lekarfizo nadji (String brojlicence){
      return lekarDao.findByBrojLicence(brojlicence);
  }
   @Transactional
   public void saveLekar(Lekarfizo l){
       lekarDao.save(l);
       
   }
    @Transactional(readOnly=true)
   public List<Karton> sviPacijenti(String brojLicence){
       
       return kartonDao.findBylekarpacijentCollection(brojLicence);
   }
   @Transactional(readOnly=true)
   public boolean nemaPregleda(Pregled p){
      
      int brojPregleda=pregledDao.countByVremeAndBrojLicence(p.getVreme(),p.getIdLekar()).intValue();
      
      if (brojPregleda==0){
          return true;
      }
      return false;
  }
   @Transactional(readOnly=true)
   public List<Pregled> sviPregledi(String brojLicence){
       return (List<Pregled>) lekarDao.findByBrojLicence(brojLicence).getPregledCollection();
   }
  @Transactional(readOnly=true)
  public boolean postojiLekar(String brojLicence,String password){
      
      int broj=lekarDao.countByBrojLicenceAndPassword(brojLicence, password).intValue();
      
      if(broj==0){
          return false;
      }
      return true;
  }
  @Transactional
  public void dodajPregled(Pregled p){
      if(nemaPregleda(p)){
          pregledDao.save(p);
      }
      else{
          System.out.println("ima pregled");
      }
  }
  @Transactional
public void dodajTerapiju(Terapija t){
    
    if(!postojiIstiTip(t)){
        System.out.println("isti tip");
    }
    else{
        terapijaDao.save(t);
    }
   
    
}
@Transactional(readOnly=true)
public Pregled nadjiPregledPojedinacan(int id){
 return   pregledDao.findById(id);
}
@Transactional(readOnly=true)
public boolean postojiIstiTip(Terapija t){
    
    int broj=terapijaDao.countDistinctByIdTip(t.getPregledId()).intValue();
    Pregled p =t.getPregledId();
    int brojT=p.getTerapijaCollection().size();
    
    if(broj==brojT){
        return false;
    }
    return true;
    
}
@Transactional(readOnly=true)
public Terapija nadjiTerapiju(int id){
    
    return terapijaDao.findById(id);
}
    /**
     * @return the lekarDao
     */
    
}
