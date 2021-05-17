package com.tts.SpringBootAddingAddition.repository;

import com.tts.SpringBootAddingAddition.model.Subscriber;
import org.springframework.data.repository.CrudRepository;

// To post the info from the form to the database,
// we need to create an interface that will aid in adding data to our database.
// This is called a repository.  We will call ours "SubscriberRepository"
// by extending the CrudRep the Subscriber repo inherits several methods
// for working with Subscriber persistence which include methods
// for saving, deleting, and reading customer entities
public interface SubscriberRepository extends CrudRepository <Subscriber, Long>{
}
