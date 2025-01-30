package com.example.AptItSolutions.Entity;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class WorkshopReg {
    @Id
    private String workRegId;
    private String name;
    private String email;
    private String mobile;
    private String collegename;
    private String collegeid;
    private String country;
    private String state;
    private String city;
    private String choosedomain;
    private String timeduration;
    private String anyquiries;

    @Lob
    @Column(columnDefinition = "LongBlob")
    private byte[] certificates;

	public String getWorkRegId() {
		return workRegId;
	}

	public void setWorkRegId(String workRegId) {
		this.workRegId = workRegId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCollegename() {
		return collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	public String getCollegeid() {
		return collegeid;
	}

	public void setCollegeid(String collegeid) {
		this.collegeid = collegeid;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getChoosedomain() {
		return choosedomain;
	}

	public void setChoosedomain(String choosedomain) {
		this.choosedomain = choosedomain;
	}

	public String getTimeduration() {
		return timeduration;
	}

	public void setTimeduration(String timeduration) {
		this.timeduration = timeduration;
	}

	public String getAnyquiries() {
		return anyquiries;
	}

	public void setAnyquiries(String anyquiries) {
		this.anyquiries = anyquiries;
	}

	public byte[] getCertificates() {
		return certificates;
	}

	public void setCertificates(byte[] certificates) {
		this.certificates = certificates;
	}

	public WorkshopReg(String workRegId, String name, String email, String mobile, String collegename, String collegeid,
			String country, String state, String city, String choosedomain, String timeduration, String anyquiries,
			byte[] certificates) {
		super();
		this.workRegId = workRegId;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.collegename = collegename;
		this.collegeid = collegeid;
		this.country = country;
		this.state = state;
		this.city = city;
		this.choosedomain = choosedomain;
		this.timeduration = timeduration;
		this.anyquiries = anyquiries;
		this.certificates = certificates;
	}

	@Override
	public String toString() {
		return "WorkshopReg [workRegId=" + workRegId + ", name=" + name + ", email=" + email + ", mobile=" + mobile
				+ ", collegename=" + collegename + ", collegeid=" + collegeid + ", country=" + country + ", state="
				+ state + ", city=" + city + ", choosedomain=" + choosedomain + ", timeduration=" + timeduration
				+ ", anyquiries=" + anyquiries + ", certificates=" + Arrays.toString(certificates) + "]";
	}

	public WorkshopReg() {
		super();
		// TODO Auto-generated constructor stub
	}


    

}
