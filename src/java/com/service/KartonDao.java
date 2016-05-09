/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Karton;
import com.entity.Lekarfizo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;


import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jelena.pajdic
 */
public interface KartonDao extends CrudRepository<Karton, Long> {
     Long countByJmbgAndPassword(String jmbg,String password);
     
  Karton findByJmbg (String jmbg);

      @Query(value = "SELECT * FROM `karton` JOIN `lekarpacijent` ON karton.jmbg=lekarpacijent.jmbg AND lekarpacijent.broj_licence=?1;",nativeQuery = true)
     List<Karton> findBylekarpacijentCollection(String brojLicence);
     
}
