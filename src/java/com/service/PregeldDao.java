/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;


import com.entity.Lekarfizo;
import com.entity.Pregled;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jelena
 */
public interface PregeldDao extends CrudRepository<Pregled, Long> {
    
    List<Pregled> findByBrojLicence(Lekarfizo lekar);
    Long countByVremeAndBrojLicence(Date vreme,Lekarfizo lekar);
    Pregled findById(int id);
    
}
