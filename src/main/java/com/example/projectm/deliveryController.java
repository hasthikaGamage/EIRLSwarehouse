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
public class deliveryController{

  @Autowired
  deliveryRepo deliveryrepo;

  @Autowired
  return_noteRepo returnrepo;

  @Autowired
  return_productsRepo returnProductsrepo;

   

    @ResponseBody
    @RequestMapping(value = "/showItems", method = RequestMethod.GET)
    public List<delivery> getItems(){
        
      
        return deliveryrepo.findAll(); 
    }

    @ResponseBody
    @RequestMapping(value = "/showItemsDelivered", method = RequestMethod.GET)
    public List<delivery> getDeliveries(){
        

        return deliveryrepo.deliveredItems(); 
    }


 public void checkDetails(){


    String theUrl2 = "http://eirls.herokuapp.com/deliveryNotes";
    
    RestTemplate restTemplates = new RestTemplate();

    try {

      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
     
      HttpEntity<String> entities = new HttpEntity<String>("parameters", headers);

      ResponseEntity<delivery[]> respEntity2 = restTemplates.exchange(theUrl2, HttpMethod.GET, entities,
      delivery[].class);
      
      

      delivery[] resp = respEntity2.getBody();
      


      List<delivery> list = deliveryrepo.findAll();

      for (delivery var : resp) {

        //  for (delivery deli : list) {

        //      if(var.getDelivery_id() == deli.getDelivery_id()){


              
        //     }else{

                delivery del = new delivery();
          
                
                del.setaddress(var.getaddress()); 
                del.setDelivery_status(var.getDelivery_status());
                del.setuser_id(var.getuser_id());
                
                deliveryrepo.save(del);

            // }
            
         //}


       
    } 
}
    
    catch (Exception eek) {
      System.out.println("** Exception: " + eek.getMessage());
    }

    
}

@RequestMapping(value = "/displayDeliveries", method = RequestMethod.GET)
    public ModelAndView showForm2(ModelAndView model) throws ParseException {

        checkDetails();
      //  enquiry enq = new enquiry();
        List<delivery> list = deliveryrepo.findAll();

        model.addObject("list", list);
        model.setViewName("displayDeliveryNote");

        return model;
    }

    @RequestMapping(value = "/returnform", method = RequestMethod.GET)
    public ModelAndView ReturnForm() {
        return new ModelAndView("returnform", "returnmodel", new return_note_model());


    }

    @RequestMapping(value = "/returnformsend", method = RequestMethod.POST)
    public String submitDetails(@Valid @ModelAttribute("returnmodel")return_note_model returnmodel, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }


    return_note newnote = new return_note();
    newnote.setCustomer_name(returnmodel.getCustomer_name());
    newnote.setDescription(returnmodel.getDescription());
    newnote.setProduct_name(returnmodel.getProduct_name());
    newnote.setTelephone(returnmodel.getTelephone());
    newnote.setStatus(returnmodel.getStatus());
    newnote.setDate(returnmodel.getDate());

    returnrepo.save(newnote);



        return "index";
    }



    @ModelAttribute("productList")
    public Map<String, String> getProductList() {
    
      
      Map<String, String> productList = new HashMap<String, String>();
     
     List<return_products> ilist = returnProductsrepo.findAll();
    
     for (return_products var : ilist) {
    
        productList.put(var.getProduct_name(), var.getProduct_name());
       
     }
     return productList;
    }

    

    @RequestMapping(value = "/returnnote", method = RequestMethod.GET) 
    public ModelAndView returnnote(ModelAndView model) throws ParseException {

        
      //  enquiry enq = new enquiry();
        List<return_note> list = returnrepo.findAll();

        model.addObject("list", list);
        model.setViewName("returnnote");

        return model;
    }


    @RequestMapping(value = "/displaydelivery", method = RequestMethod.GET) 
    public ModelAndView canceldelivery(ModelAndView model) throws ParseException {

   
       List<delivery> list = deliveryrepo.findAll();

        model.addObject("list", list);
        model.setViewName("displayDeliveryNote");

        return model;
    }


    @RequestMapping(value = "/updatedeliverystatus", method = RequestMethod.POST)  
    public String cancelDelivery(@RequestParam("myField") int id) {

      delivery del = new delivery();
      del = deliveryrepo.findbydeliveredid(id);
      del.setDelivery_status("Delivered"); 
      deliveryrepo.save(del);
      return "index";
    }


 }














