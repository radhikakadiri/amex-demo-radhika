package com.population.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;


import java.util.Set;

import javax.persistence.CascadeType;

@Entity
@Table(name = "country")

public class Country {
    private String ccode;
    private String cname;
    private String curr;
    @OneToMany(mappedBy = "state", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    
    private Set<State> states;
    public Country() {
    }
    
  /*  public Country(String cname, String curr) {
    	 this.cname = cname;
         this.curr = curr;
    }*/
    public Country(String code, String name, String currency) {
        this.ccode = code;
        this.cname = name;
        this.curr = currency;
    }

    @Id
	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}
}
