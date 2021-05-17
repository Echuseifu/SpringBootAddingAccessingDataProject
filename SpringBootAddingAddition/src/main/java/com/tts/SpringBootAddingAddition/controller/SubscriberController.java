package com.tts.SpringBootAddingAddition.controller;

import com.tts.SpringBootAddingAddition.model.Subscriber;
import com.tts.SpringBootAddingAddition.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// This controller will determine how the data and user will move through our project.
// The controller provides the connection between our templates (browser view) and
// the data from our database.
@Controller
public class SubscriberController {

    // to add our subscriber repo to the controller
    // this repository is described as a dependency of controller
    // we need to inject it into our controller for it to work
    // we can do this easily with the autowired annotation
    @Autowired
    private SubscriberRepository subscriberRepository;

    @GetMapping("/")
    public String index(Subscriber subscriber) {
        // this is the specified template
        // it will be utilized by thymeleaf

        return "subscriber/index";
    }

    private Subscriber subscriber;
@PostMapping("/")
    public String addNewSubscriber(Subscriber subscriber, Model model) {
        subscriberRepository.save(new Subscriber(
                subscriber.getFirstName(),
                subscriber.getLastName(),
                subscriber.getUserName(),
                subscriber.getSignedUp()
        ));


        model.addAttribute("firstName", subscriber.getFirstName());
        model.addAttribute("lastName", subscriber.getLastName());
        model.addAttribute("userName", subscriber.getUserName());
        return "subscriber/result";
    }

    @GetMapping(value="/showSubscribers")
    public String getSubscribers(Model model, String keyword) {
        List<Subscriber> subscriberList = (List<Subscriber>) subscriberRepository.findAll();

        model.addAttribute("subscribers", subscriberList);

        return"subscriber/AllSubscribers";
    }

}











