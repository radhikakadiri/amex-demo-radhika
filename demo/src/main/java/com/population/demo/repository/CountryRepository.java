package com.population.demo.repository;

import com.population.demo.model.Country;
import com.population.demo.model.CountryAndCur;
import com.population.demo.model.CountryAndPop;
import com.population.demo.pojo.CountryPopInfo;

import java.util.List;
import org.json.JSONArray;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CountryRepository extends CrudRepository<Country, Integer> {

    List<Country> findAll();
	
	//List<Country> findAllCurr();
	
	public static final String FIND_CURR = "SELECT cname, curr FROM population.country";
	public static final String FIND_POP = "SELECT country.ccode, sum(state.pop) \r\n"
			+ "FROM population.country, population.state \r\n"
			//+ "WHERE state.ccode = country.ccode and country.ccode = 'BLD';";
			+ "WHERE state.ccode = country.ccode and country.ccode=?1";
	
	public static final String FIND_POP1 ="select cname as country, pop as pop from Country c inner join State s on c.ccode = s.ccode and c.ccode = ccode"; //where p.id = ?1"

	@Query(value = FIND_CURR, nativeQuery = true)
	public List<CountryAndCur> findAllCurr();
	
	@Query(value = FIND_POP, nativeQuery = true)
	public List<CountryAndPop> findAllPop();
	
	
	@Query(value = FIND_POP, nativeQuery = true)
	
	//public CountryPopInfo getPopwithCountry(@Param("ccode") String ccode);
	public Object getPopwithCountry(@Param("ccode") String ccode);
	
}