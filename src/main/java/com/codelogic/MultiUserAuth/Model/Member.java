package com.codelogic.MultiUserAuth.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

 
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Member {
	
	  @Id
	 
	  @GeneratedValue(strategy = GenerationType.AUTO)
	 
	  
	  private int id;
    
	  private String name;
    private String gender;
    private Date DOB;
    private int contactNumber;
    private String email;
    
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;
    
    private int planCost;
    private Timestamp appointmentdate;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public int getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	public int getPlanCost() {
		return planCost;
	}
	public void setPlanCost(int planCost) {
		this.planCost = planCost;
	}
	public Timestamp getAppointmentdate() {
		return appointmentdate;
	}
	public void setAppointmentdate(Timestamp appointmentdate) {
		this.appointmentdate = appointmentdate;
	}
	


	
	




  



 
}
