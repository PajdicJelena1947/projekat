/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;


import com.entity.Lekarfizo;
import com.entity.Pregled;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



/**
 *
 * @author jelena.pajdic
 */

public interface LekarDao extends CrudRepository<Lekarfizo, Long> {
    
  
  @Override
  Lekarfizo save(Lekarfizo f);
   
    Lekarfizo findByBrojLicence(String brojLicence);
   
    Long countByBrojLicenceAndPassword(String brojLicence,String password);
    
    @Query(value= "SELECT email FROM `lekarfizo` JOIN `lekarpacijent` on lekarfizo.broj_licence=lekarpacijent.broj_licence AND lekarpacijent.jmbg=?1 AND type=\"lekar\"",nativeQuery=true)
    String findByEmail(String jmbg);

   
   
}
