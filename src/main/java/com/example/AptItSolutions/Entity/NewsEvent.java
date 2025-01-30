package com.example.AptItSolutions.Entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "news_events")
public class NewsEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private Date date;
    
    private String newsEvent;

    @JsonManagedReference
    @OneToMany(mappedBy = "newsS", cascade = CascadeType.ALL)
     List<NewsImages> images=new ArrayList<>();

    @Column(name = "link")
    private String link;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNewsEvent() {
		return newsEvent;
	}

	public void setNewsEvent(String newsEvent) {
		this.newsEvent = newsEvent;
	}

	public List<NewsImages> getImages() {
		return images;
	}

	public void setImages(List<NewsImages> images) {
		this.images = images;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public NewsEvent(Long id, Date date, String newsEvent, List<NewsImages> images, String link) {
		super();
		this.id = id;
		this.date = date;
		this.newsEvent = newsEvent;
		this.images = images;
		this.link = link;
	}

	public NewsEvent() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    
}
