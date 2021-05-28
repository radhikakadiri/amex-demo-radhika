# amex-demo-radhika

# census-rest-demo-new


rest end points to be used (in postman) - 

For adding a state - 

http://localhost:8087/countries/

In postman, in the Post, select body and json type and give the input - 

{
    "ccode":"BLD",
    "stcode":"CTR",
    "stname":"CenterProvince",
    "pop":13987

}

For getting list of countries - 

http://localhost:8087/countries/

adding state with post with given data as parmvalue-
http://localhost:8087/census/addState/MDR/STN/state/6964564


For retriving total population start a getrequest from postman - 

http://localhost:8087/census/getAllCountryPop/NUM

where NUM is the country code

For retrieving the validateState get request - 

http://localhost:8087/census/validateState/BLD/RIG

where BLD is ccode and RIG is stcode


SELECT country.ccode, sum(state.pop) 
			FROM population.country, population.state 
			WHERE state.ccode = country.ccode and country.ccode = 'BLD' ;
