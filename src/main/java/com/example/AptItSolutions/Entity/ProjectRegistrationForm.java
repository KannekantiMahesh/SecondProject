package com.example.AptItSolutions.Entity;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class ProjectRegistrationForm {

    @Id
    private String  proRegId;
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
    
    private String link;
    
    @Lob
    @Column(columnDefinition = "LongBlob")
    private byte[] certificates;

	public String getProRegId() {
		return proRegId;
	}

	public void setProRegId(String proRegId) {
		this.proRegId = proRegId;
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public byte[] getCertificates() {
		return certificates;
	}

	public void setCertificates(byte[] certificates) {
		this.certificates = certificates;
	}

	public ProjectRegistrationForm(String proRegId, String name, String email, String mobile, String collegename,
			String collegeid, String country, String state, String city, String choosedomain, String timeduration,
			String anyquiries, String link, byte[] certificates) {
		super();
		this.proRegId = proRegId;
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
		this.link = link;
		this.certificates = certificates;
	}

	@Override
	public String toString() {
		return "ProjectRegistrationForm [proRegId=" + proRegId + ", name=" + name + ", email=" + email + ", mobile="
				+ mobile + ", collegename=" + collegename + ", collegeid=" + collegeid + ", country=" + country
				+ ", state=" + state + ", city=" + city + ", choosedomain=" + choosedomain + ", timeduration="
				+ timeduration + ", anyquiries=" + anyquiries + ", link=" + link + ", certificates="
				+ Arrays.toString(certificates) + "]";
	}

	public ProjectRegistrationForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    
    
}
