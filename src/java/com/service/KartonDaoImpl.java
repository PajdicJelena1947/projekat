/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Karton;
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
public class KartonDaoImpl {
    @Autowired 
    private KartonDao kartonDao;
    @Autowired 
    private TerapijaDao terapijaDao;
    @Autowired
    private LekarDao lekarDao;
    @Autowired
    private FizioterapeutDao fizioDao;
    
    
    @Transactional(readOnly=true)
    public boolean postojiPaijent(String jmbg,String password){
      
      int broj=kartonDao.countByJmbgAndPassword(jmbg, password).intValue();
      
      if(broj==0){
          return false;
      }
      return true;
  }
    @Transactional(readOnly=true)
    public List<Pregled> sviPreglediPacijenta(String jmbg)
    {
        return (List<Pregled>) kartonDao.findByJmbg(jmbg).getPregledCollection();
    }
    @Transactional(readOnly=true)
  public List<Terapija> sveTerapijePacijenta(String jmbg){
      return terapijaDao.findByJmbgPacijeta(jmbg);
  }
  @Transactional(readOnly=true)
  public Karton pacijent(String jmbg){
      return kartonDao.findByJmbg(jmbg);
  }
  @Transactional(readOnly=true)
  public String emailLekara(String jmbg){
      
      return lekarDao.findByEmail(jmbg);
      
  }
  @Transactional(readOnly=true)
  public String emailFizioterapeuta(String jmbg){
      return fizioDao.findByEmail(jmbg);
  }
            
    
}
