package com.example.projectm;

import java.text.ParseException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class bomcontroller{

    @Autowired
    bomrepo bomrepo;

    @ResponseBody
    @RequestMapping(value = "/boms", method = RequestMethod.GET) //link eke name
    public List<bom> getboms(){                                 
         
        return bomrepo.findAll(); 
    }

    @RequestMapping(value = "/bomview", method = RequestMethod.GET)  
    public ModelAndView bomView(ModelAndView model) throws ParseException {

        checkStatus();
        List<bom> list = bomrepo.findAll();        
        model.addObject("list", list);
        model.setViewName("billofmaterials");

        return model;
    }


    public void checkStatus () {
        
    String theUrl2 = "https://eirlss-production.herokuapp.com/public/api/billofmaterials?includes=billItems.material";
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImM3ZjFiNzhiYzU4NTQ1NzA2ZGIyNzYyZDFjMzE0Y2Y3YWEyYTkwNDA3OGI5OTY2YjVjMjY4NzRlYzYzNWYxMzQ5ZTVkZTY2YTU1NzlhOWJmIn0.eyJhdWQiOiI2IiwianRpIjoiYzdmMWI3OGJjNTg1NDU3MDZkYjI3NjJkMWMzMTRjZjdhYTJhOTA0MDc4Yjk5NjZiNWMyNjg3NGVjNjM1ZjEzNDllNWRlNjZhNTU3OWE5YmYiLCJpYXQiOjE1NjA3MDIyMzAsIm5iZiI6MTU2MDcwMjIzMCwiZXhwIjoxNTkyMzI0NjI5LCJzdWIiOiIiLCJzY29wZXMiOlsiKiJdfQ.HTDqOIiQR_s8um_kTYbZLGszpFgwdzXR2g156rtQpwxLRfWuP6uih9f8XiHSacJaKwQqnkZjEesvAuCGlfssUcm8bNaSD2JXalBHiHE7fanbvCk5bK8jaA6dQe6DwlSy7LnzWlmrYsRqabUGEM5NCx37phMS3GxiGSLCWww_4Sq4hR5TDfmOzdMzlzRZVRU0-EdU0U1y5sJQhaSHJo3pKwWDswVEvUGaXwL1YtzQbO_zph3qyf83Woc-poNOEilUbtIt1fWGWUjX8ZQnuAEw6I1h6v5OiM2f1wX7WgZUYRfXZAiBAhAqSoIj9vPuhH0sMjoToSUgtykmlsB0BUU7SSzSfOppQnCUyvkMT89uwEbF0BfY_BRwPYS3qFIqjh4hjBPcfG-9XhYhjMt7sAHEqi1VkLkxXRdZgwsQFET1pEyuaC45kAMfwgeY0lwehlnpWQZJaH5VAP1GZBUbfG19fEP6RRXfnK67TCBC_hGfMwLdAewGFMSnoca4bBQzkVJ2Y40ZVEvsBcfaRQ5dmIY3mcegoB1n4dYCcKi5T6tYZmAuHusKVRO1HK_IMtqvkkbv7FT_D96ctgpzgpKN9RIEEk2D3QHTC1z90rlyVUsXlo-MeMDKABdLIwXYJ4C-U0VGMnR0vfOwnjgo4fSWdJKYb4UhEJc7XNygyxAFflFpuUU";

    RestTemplate restTemplates = new RestTemplate();

    try {

      HttpHeaders headers = new HttpHeaders();                      
      headers.add("Authorization", "Bearer " + token);
      headers.setContentType(MediaType.APPLICATION_JSON);
     
      HttpEntity<String> entities = new HttpEntity<String>("parameters", headers);

      ResponseEntity<bom[]> respEntity2 = restTemplates.exchange(theUrl2, HttpMethod.GET, entities,
      bom[].class);
        
      bom[] resp = respEntity2.getBody();
      List<bom> bomList = new ArrayList<>();
      

      for (bom b: resp) {
            for(bom newB: bomList) {
                newB.setCreatedDate(b.getCreatedDate());
                newB.setOrderItemid(b.getOrderItemid());
                newB.setUpdatedDate(b.getUpdatedDate());
                newB.setStatus("Delivered");
                bomrepo.save(newB);
            }
      }

        }catch(Exception e) {

        }
    }


    private void bommethod(masterstock master) {

        String URL = "https://eirls-mm.herokuapp.com/api/sales-orders";
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