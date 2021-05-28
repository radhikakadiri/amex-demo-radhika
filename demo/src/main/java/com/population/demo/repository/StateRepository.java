package com.population.demo.repository;

import com.population.demo.model.Country;
import com.population.demo.model.State;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StateRepository extends CrudRepository<State, Long> {

    List<State> findByCountry(Country country, Sort sort);
    //State save(State state);
    
    public static final String FIND_POP = "select count(*) from population.state where ccode =?1 and stcode =?2";
    		//"select count(*) from population.state where stcode = 'RIG' and ccode ='BLD';"
			//+ "FROM population.country, population.state \r\n"
			//+ "WHERE state.ccode = country.ccode and country.ccode = 'BLD';";
			//+ "WHERE state.ccode = country.ccode and country.ccode=?1";
    
    @Query(value = FIND_POP, nativeQuery = true)
	public int validateState(@Param("ccode") String ccode, @Param("stcode") String stcode);
}