package com.example.projectm;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import lombok.var;

@Controller
public class masterStockControlller{

    @Autowired
    masterStockRepo masterrepo;
    
    @Autowired
    return_productsRepo returnProductsrepo;



    @RequestMapping(value = "/supplierform", method = RequestMethod.GET)
    public ModelAndView supplierform() {
        return new ModelAndView("supplierform", "mastermodel", new masterstock_model());


    }


    @ResponseBody
    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public void addItem(masterstock newRecord){
        
        masterrepo.save(newRecord);
    
    }    
    
    @RequestMapping(value = "/masterstock", method = RequestMethod.GET)  
    public ModelAndView masterstockview(ModelAndView model) throws ParseException {

         
        List<masterstock> list = masterrepo.findAll();

        model.addObject("list", list);
        model.setViewName("masterstock");

        return model;
    }

    @ResponseBody   
    @RequestMapping(value = "/updateItem", method = RequestMethod.PUT)
    public  String updateItem(@Valid @ModelAttribute("mastermodel") masterstock_model msmd, 
    BindingResult result, ModelMap model){

        String prodname= msmd.getProductName();   
        int quantity = msmd.getQuantity();
         String quality = msmd.getQuanlity(); 
        String productname = msmd.getProductName();
        String supplierName = msmd.getSuppplierName();

 
        masterstock mr = new masterstock();
        mr.setProductName(prodname);
        mr.setQuantity(quantity);
        mr.setSuppplierName(supplierName);
        mr.setQuanlity(quality); 
        mr.setStatus("raw");
        masterrepo.save(mr);
            
         

        return "redirect:/masterstock"; 
    }

       

    @ResponseBody
    @RequestMapping(value = "/goodrecievednotice", method = RequestMethod.GET)
    public List<masterstock> confirmedQualityItems(){
        
        
        List<masterstock> mlist = masterrepo.findByQuanlity("Good");

        for (masterstock var : mlist) {

            goodrecievednoticemethod(var);

            
        }
        return masterrepo.findByQuanlity("Good"); 
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


    private void goodrecievednoticemethod(masterstock master) {

        String URL = "http://eirls-mm.herokuapp.com/api/goods-received";
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJleHRlcm5hbCIsImlhdCI6MTU1NTMyNjk2OSwiZXhwIjoxNTU1NDEzMzY5fQ.kDnlreG8p_VcoLh3FVrZI3a8go4IXQCWHBMIGJxNOaMeKsrhPz-Axv3RWiXgsxbQNXmXc4HTx7IQ9622Z20RZw";
        
        RestTemplate template = new RestTemplate();
        Map payload = new HashMap<String, String>();

        payload.put("productName", master.getProductName());
        payload.put("quantity", String.valueOf(master.getQuantity()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map> requestEntity = new HttpEntity<>(payload, headers);
        ResponseEntity<Object> result = template.exchange(URL, HttpMethod.POST, requestEntity, Object.class);

        if (!result.getStatusCode().is2xxSuccessful()) {
           
        }
    }

}