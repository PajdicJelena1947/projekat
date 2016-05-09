
import com.service.FizioterapeutDaoImpl;
import com.service.KartonDaoImpl;
import com.service.LekarDaoImpl;
import com.entity.Fizioterapeut;
import com.entity.Karton;

import com.entity.Lekarfizo;
import com.entity.Pregled;
import com.entity.Terapija;
import java.util.Date;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jelena.pajdic
 */
public class MainApp {
    public static void main(String[] args) {
        
      
     ApplicationContext context = 
             new ClassPathXmlApplicationContext("Bean2.xml");
        LekarDaoImpl dao =  (LekarDaoImpl) context.getBean("lekarDaoImpl");
        FizioterapeutDaoImpl fiziodao=(FizioterapeutDaoImpl) context.getBean("fizioterapeutDaoImpl");
        
        Lekarfizo lekar=dao.nadji("185642");
        System.out.println(""+lekar.getIme());
        KartonDaoImpl daok=(KartonDaoImpl) context.getBean("kartonDaoImpl");
        Karton k=daok.pacijent("12345");
      Pregled p =dao.nadjiPregledPojedinacan(1);
      
      List<Karton> pacijenti =dao.sviPacijenti("123");
        for(Karton ka:pacijenti){
            System.out.println(""
                    + ka.getIme());
        }
    
      
    }
    
}
