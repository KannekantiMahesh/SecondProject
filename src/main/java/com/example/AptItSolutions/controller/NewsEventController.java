package com.example.AptItSolutions.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.AptItSolutions.Entity.NewsEvent;
import com.example.AptItSolutions.Entity.NewsImages;
import com.example.AptItSolutions.service.NewsEventService;

@RestController
@RequestMapping("/api/newEvent")
public class NewsEventController {



    @Autowired
    private NewsEventService newsEventService;

    @Autowired
    public NewsEventController(NewsEventService newsEventService) {
        this.newsEventService = newsEventService;
    }

    @GetMapping("/getallnews")
    public List<NewsEvent> getAllNewsEvents() {
        return newsEventService.getAllNewsEvents();
    }

    @PostMapping("/save")
    public ResponseEntity<NewsEvent> createNewsEvent(
            @RequestParam("date") Date newsDate,
            @RequestParam("newsEvent") String newsText,
            @RequestParam(value = "link", required = false) String link,
            @RequestParam("imageFile") List<MultipartFile> imageFiles) {

        try {
            // Create a new NewsEvent
            NewsEvent newsEvent = new NewsEvent();

            newsEvent.setDate(newsDate);
            newsEvent.setNewsEvent(newsText);
            newsEvent.setLink(link);

            // Process and save each image
            List<NewsImages> newsImagesList = new ArrayList<>();

            for (MultipartFile imageFile : imageFiles) {
                NewsImages newsImage = new NewsImages();
                newsImage.setImage(imageFile.getBytes());
                newsImage.setNewsS(newsEvent); // Set the relationship
                newsImagesList.add(newsImage);
            }

            // Set the images to the NewsEvent
            newsEvent.setImages(newsImagesList);

            // Save the NewsEvent with images
            NewsEvent savedNewsEvent = newsEventService.save(newsEvent);

            return new ResponseEntity<>(savedNewsEvent, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception, e.g., log an error
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/get/{id}")
    public NewsEvent getNewsEventById(@PathVariable("id") Long id) {
        return newsEventService.getNewsEventById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<NewsEvent> updateNewsEvent(
            @PathVariable("id") Long id,
            @RequestParam("newsEvent") String newsText,
            @RequestParam("link") String link,
            @RequestPart(value = "imageFile", required = false) MultipartFile imageFile) {

        try {
            // Get the existing NewsEvent
            NewsEvent newsEvent = newsEventService.getNewsEventById(id);

            if (newsEvent == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            // Update NewsEvent properties
            newsEvent.setNewsEvent(newsText);
            newsEvent.setLink(link);

            // Check if a new image file is provided
            if (imageFile != null && !imageFile.isEmpty()) {
                NewsImages newsImage = new NewsImages();
                newsImage.setImage(imageFile.getBytes());

                newsImage.setNewsS(newsEvent); // Set the relationship
                newsEvent.getImages().add(newsImage); // Add image to the list
            }

            // Save and return the updated NewsEvent
            NewsEvent updatedNewsEvent = newsEventService.saveNewsEvent(id, newsEvent);
            return new ResponseEntity<>(updatedNewsEvent, HttpStatus.OK);

        } catch (IOException e) {
            // Log or handle the exception appropriately
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    
    
    
    

    @DeleteMapping("/deletenews/{id}")
    public void deleteNewsEvent(@PathVariable("id") Long id) {
        NewsEvent newsEvent = newsEventService.getNewsEventById(id);
        if (newsEvent != null) {
            newsEventService.deleteNewsEvent(newsEvent);
        }
    }
}
