package com.example.projectm;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class exchangeController{


    @Autowired
  exchangeRepo exchangerepo;


  public void checkDetails(){


    String theUrl2 = "http://eirls.herokuapp.com/returnExchange";
    
    RestTemplate restTemplates = new RestTemplate();

    try {

      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
     
      HttpEntity<String> entities = new HttpEntity<String>("parameters", headers);

      ResponseEntity<exchange[]> respEntity2 = restTemplates.exchange(theUrl2, HttpMethod.GET, entities,
      exchange[].class);
      
      

      exchange[] resp = respEntity2.getBody();
      


      List<exchange> list = exchangerepo.findAll();

      for (exchange var : resp) {

        


            

                exchange exc = new exchange(); 
                exc.setProduct_name(var.getProduct_name());
                exc.setProduct_quantity(var.getProduct_quantity());  
                exc.setDescription(var.getDescription());
                exc.setReturn_location(var.getReturn_location());
                exc.setReturn_date(var.getReturn_date());
                exc.setOrder_id(var.getOrder_id());
                exchangerepo.save(exc);

            
            
         }


       
    
}
    
    catch (Exception eek) {
      System.out.println("** Exception: " + eek.getMessage());
    }

    
}

    @RequestMapping(value = "/displayExchange", method = RequestMethod.GET)
    public ModelAndView showExchange(ModelAndView model) throws ParseException {

        checkDetails();
        List<exchange> list = exchangerepo.findAll();

        model.addObject("list", list);
        model.setViewName("exchange");

        return model;
    }


}