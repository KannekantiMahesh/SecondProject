package com.example.AptItSolutions.Entity;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
@Entity
public class NewsImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long nId;

    @Lob
    @Column(name = "image", columnDefinition = "LONGBLOB")
    private byte[] image;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "eid")
    private NewsEvent newsS;

	public long getnId() {
		return nId;
	}

	public void setnId(long nId) {
		this.nId = nId;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public NewsEvent getNewsS() {
		return newsS;
	}

	public void setNewsS(NewsEvent newsS) {
		this.newsS = newsS;
	}

	public NewsImages(long nId, byte[] image, NewsEvent newsS) {
		super();
		this.nId = nId;
		this.image = image;
		this.newsS = newsS;
	}

	public NewsImages() {
		super();

	}

	
}
