package com.codelogic.MultiUserAuth.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table; 
 
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Plan")
public class Plan {

    @Id
    @Column(name="plan_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String name;
    private String pdescription;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPdescription() {
		return pdescription;
	}
	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}

 
}
