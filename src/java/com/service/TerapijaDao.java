/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Fizioterapeut;
import com.entity.Lekarfizo;
import com.entity.Pregled;
import com.entity.Terapija;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jelena.pajdic
 */
public interface TerapijaDao  extends CrudRepository<Terapija, Long> {
    List<Terapija> findByJmbgPacijeta(String jmbgPacijenta);
     List<Terapija> findTop10ByJmbgPacijeta(String jmbgPacijenta);
   
    
    @Query(value="SELECT COUNT(DISTINCT id_tip) FROM `terapija` WHERE pregled_id=?1;",nativeQuery=true)
    Long countDistinctByIdTip(Pregled p);
    
     @Query(value = "SELECT COUNT(pocetak) FROM `terapija` JOIN `lekarpacijent`on terapija.jmbg_pacijeta=lekarpacijent.jmbg AND lekarpacijent.broj_licence=?1 AND terapija.pocetak=?2",nativeQuery = true)
    Long countByPocetak(String brojLicence,Date pocetak);
    
    @Query(value = "SELECT * FROM `terapija` JOIN `lekarpacijent`on terapija.jmbg_pacijeta=lekarpacijent.jmbg AND lekarpacijent.broj_licence=?1",nativeQuery=true)
    List<Terapija> findTop30All(String brojLicence);
    
    Terapija findById(int id);
    
    
            
            
}
