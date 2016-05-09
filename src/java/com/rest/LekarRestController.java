/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest;

import com.entity.Karton;
import com.entity.Pregled;
import com.entity.Terapija;
import com.service.LekarDaoImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
public class LekarRestController {
      @Autowired
    private LekarDaoImpl dao;
      @RequestMapping(value = "/svipacijenti/{brojLicence}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Karton>> sviPacijentiLekar(@PathVariable("brojLicence") String brojLicence) {
        List<Karton> kartoni=dao.sviPacijenti(brojLicence);
        return new ResponseEntity<List<Karton>>(kartoni, HttpStatus.OK);
    }
     @RequestMapping(value = "/svipregledi/{brojLicence}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pregled>> sviPreglediLekar(@PathVariable("brojLicence") String brojLicence) {
        List<Pregled> pregledi=dao.sviPregledi(brojLicence);
        return new ResponseEntity<List<Pregled>>(pregledi, HttpStatus.OK);
    }
    
    
    
   @RequestMapping(value = "/pregled", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> dodajPregled(@RequestBody Pregled pregled) {
       dao.dodajPregled(pregled);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/terapija", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> dodajTerapiju(@RequestBody Terapija terapija) {
       dao.dodajTerapiju(terapija);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
