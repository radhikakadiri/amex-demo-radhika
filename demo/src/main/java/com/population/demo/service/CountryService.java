package com.population.demo.service;


import com.population.demo.model.Country;
import com.population.demo.model.CountryAndCur;
import com.population.demo.model.CountryAndPop;
import com.population.demo.pojo.CountryPopInfo;
import com.population.demo.repository.CountryRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.transaction.Transactional;

@Service
@Transactional
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
  
    public List<Country> listAllCountries() {
        return countryRepository.findAll();
    }
    
    
    public List<CountryAndCur> findAllCurr(){
    	return countryRepository.findAllCurr();
    }
    
    public List<CountryAndPop> findPop(){
    	return countryRepository.findAllPop();
    	
    }
    
    public Object findCountPop(String ccode){
    	System.out.println("ccode vallue: "+ccode);
    	//JSONObject jo = new JSONObject();
    	//jo = countryRepository.getPopwithCountry(ccode)
    	//CountryPopInfo cf = countryRepository.getPopwithCountry(ccode);
    	//System.out.println("obj:"+cf);
    	return countryRepository.getPopwithCountry(ccode);
    	
    }
    
    
   /* @Autowired
    private CountryJpaRepository countryJpaRepository;
    
    public List<Country> listAllCurr() {
        return countryRepository.findAll();
    }*/
 
  /*  public List<Country> getAllCountryCurrencies(){
        return countryRepository.findAllCurr();
    }*/
    
    /* getAllCountryPopulations()
     * getAllCountryCurrencies()
     * validateState(country_code, state_code)
     * addState(country_cd, state_cd, state_name, state_population)
     */
     
    
    /*public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).get();
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }*/
    
    
}

