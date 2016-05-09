/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest;

import com.entity.Pregled;
import com.entity.Terapija;
import com.service.KartonDaoImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jelena.pajdic
 */
@RestController
public class KartonRestController {
     @Autowired
      private KartonDaoImpl daoK;
     
     @RequestMapping(value = "/svipreglediPacijent/{jmbg}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pregled>> sviPreglediPacijent(@PathVariable("jmbg") String jmbg) {
        List<Pregled> pregledi=daoK.sviPreglediPacijenta(jmbg);
        return new ResponseEntity<List<Pregled>>(pregledi, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/sveTerapijePacijent/{jmbg}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Terapija>> sveTerapijePacijenta(@PathVariable("jmbg") String jmbg) {
        List<Terapija> terapije=daoK.sveTerapijePacijenta(jmbg);
        return new ResponseEntity<List<Terapija>>(terapije, HttpStatus.OK);
    }
    
}
