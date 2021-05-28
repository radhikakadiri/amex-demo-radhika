package com.population.demo.controllers;

import com.population.demo.model.Country;
import com.population.demo.model.CountryAndCur;
import com.population.demo.model.CountryAndPop;
import com.population.demo.model.State;
import com.population.demo.pojo.CountryPopInfo;
import com.population.demo.repository.StateRepository;
import com.population.demo.service.StateService;
import com.population.demo.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/census")
public class CensusController {
    @Autowired
    StateService stateService;
    @Autowired
    CountryService countryService;

    
    @GetMapping("/getAllCountries")
    public List<Country> list() {
        return countryService.listAllCountries();
    }
    
    @PostMapping("/addState/{ccode}/{stcode}/{stname}/{pop}")
    public void add(@PathVariable("ccode") String ccode, @PathVariable("stcode") String stcode,@PathVariable("stname") String stname, @PathVariable("pop") Integer pop) {//,@RequestBody State state
   
    	//State state = new State(ccode.trim(),stcode.trim(),stname.trim(),pop);
       	State state=new State();
    	state.setCcode(ccode);
    	state.setStcode(stcode);
    	state.setStname(stname);
    	state.setPop(pop);
    	 	
    	stateService.addState(state);
    }
    
    @PostMapping("/")//adding the state with input as request body. Provide the input in the json format in body of the request
    public void add(@RequestBody State state) {//,@RequestBody State state
    	//State state = new State(country_cd,state_cd,state_name,state_population);
    	//State state = new State("BLD","CTR","CenterProvince",13987);
    	System.out.println("calling the addstate service from controller");
    	// state = new State("BLD","CTR","CenterProvince",13987);
        stateService.addState(state);
    }
       
    @GetMapping("/getAllCCurr")
    public List<CountryAndCur> listCurr() {
        return countryService.findAllCurr();   
        }
    
    @GetMapping("/getAllCPop")
    public List<CountryAndPop> listPop() {
        return countryService.findPop();   
        }
    
    
    @GetMapping("/getAllCountryPop/{ccode}")
    public Object listCountryPop(@PathVariable("ccode") String ccode){
    	return countryService.findCountPop(ccode);
//    	JSONObject obj = new JSONObject();
//    	try {
//			obj.put("Population",json.get(1));
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        return obj;   
        }
    

    @GetMapping("/validateState/{ccode}/{stcode}")
    public boolean validateState(@PathVariable("ccode") String ccode,@PathVariable("stcode") String stcode ){
    	return stateService.validateState(ccode,stcode);
    }
    
    //To do
    /* getAllCountryPopulations()
     * getAllCountryCurrencies()
     * validateState(country_code, state_code)
     * addState(country_cd, state_cd, state_name, state_population)
     */
    
}