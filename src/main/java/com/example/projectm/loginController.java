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
public class loginController{


  @Autowired
  loginRepo loginrepo;   

  

  @RequestMapping(value = "/signup", method = RequestMethod.GET)
public ModelAndView signupform() {
return new ModelAndView("signup", "usermod", new UserModel());


}

@RequestMapping(value = "/signupsubmit", method = RequestMethod.POST)
    public String signupform2(@Valid @ModelAttribute("usermod") UserModel usermod, 
    BindingResult result, ModelMap model) {
    


    User u = new User();

    u.setUsername(usermod.getUsername());
    u.setPassword(usermod.getPassword());
    u.setEmail(usermod.getEmail());


    loginrepo.save(u);
    
    return "login";
}


@RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showForm3() {

      //  updateStocks();
    return new ModelAndView("login", "usermod", new UserModel());


}

    @RequestMapping(value = "/placelogin", method = RequestMethod.POST)
    public String submitdetails(@Valid @ModelAttribute("usermod") UserModel usermod, 
    BindingResult result, ModelMap model) {

        List<User> ulist = loginrepo.findAll();

        for (User var : ulist) {

            if(var.getUsername().equals(usermod.getUsername())){

                User u =  loginrepo.findByUsername(usermod.getUsername());
 
                    return "index";
        
               
            }
           
        }

        return "redirect:/login";
       
    
    
}


}