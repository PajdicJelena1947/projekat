/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest;

import com.service.LekarDaoImpl;
import com.entity.Karton;
import com.entity.Pregled;
import com.entity.Terapija;
import com.service.KartonDaoImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jelena.pajdic
 */

@RestController
public class ProjRestController {
    @Autowired
    private LekarDaoImpl dao;
    @Autowired
      private KartonDaoImpl daoK;
    
    
    
     @RequestMapping(value = "/karton/pacijent/{jmbg}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Karton> getKarton(@PathVariable("jmbg") String jmbg) {
        Karton karton= daoK.pacijent(jmbg);
        if (karton== null) {
            
            return new ResponseEntity<Karton>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Karton>(karton, HttpStatus.OK);
    }
    
    
}
