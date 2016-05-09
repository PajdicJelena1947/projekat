/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Fizioterapeut;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jelena.pajdic
 */
public interface FizioterapeutDao extends CrudRepository<Fizioterapeut, Long>{
    Long countByBrojLicenceAndPassword(String brojLicence,String password);
    Fizioterapeut findByBrojLicence(String brojLicence);
    @Query(value= "SELECT email FROM `lekarfizo` JOIN `lekarpacijent` on lekarfizo.broj_licence=lekarpacijent.broj_licence AND lekarpacijent.jmbg=?1 AND type=\"fizio\"",nativeQuery=true)
    String findByEmail(String jmbg);
    
}
