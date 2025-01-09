//usersService.java
package com.example.ccsd.Users;

import com.mongodb.MongoTimeoutException;
import com.mongodb.client.MongoIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//usersService: to perform CRUD or any operations that's been called in usersController
//usersRepository: a syntax like SQL syntaxes to performed in MongoDB database

@Service
public class usersService {

    @Autowired
    private usersRepository usersRepository; //for database operation, perhaps for performing methods on table users

    @Autowired
    private MongoTemplate mongoTemplate; //use for need more control over the query process.

    //to get all user and it would give all of the user in the form of List
    public List<users> getAllUsers() {
        return usersRepository.findAll();
    }

    //to get user by the ID provided
    public Optional<users> getUserById(String userId) {
        return usersRepository.findById(userId);
    }

    //to add user in database
    public users addUser(users users) {
        return usersRepository.save(users);
    }

    //to update user data in database
    public users updateUser(String userId, users usersDetails) {
        Optional<users> userDat = usersRepository.findById(userId); //find the user ID for the user that wants to update their info
        //check if user exist
        if (userDat.isPresent()) {
            users updUserDat = userDat.get();

            //Set user data based on the new data given
            updUserDat.setEmail(usersDetails.getEmail());
            updUserDat.setPassword(usersDetails.getPassword());
            updUserDat.setFirstName(usersDetails.getFirstName());
            updUserDat.setLastName(usersDetails.getLastName());
            updUserDat.setDob(usersDetails.getDob());
            updUserDat.setPhoneNumber(usersDetails.getPhoneNumber());
            updUserDat.setAddress(usersDetails.getAddress());
            updUserDat.setRole(usersDetails.getRole());
            updUserDat.setUsername(usersDetails.getUsername());
            updUserDat.setProfPic(usersDetails.getProfPic());
            return usersRepository.save(updUserDat); //return the object after finish setting all updated data
        } else{
            return null; //if not found, return nothing
        }
    }

    //to delete user in database
    public void deleteUser(String userId) {
        usersRepository.deleteById(userId);
    }


    //get user details that matches based on their email
    public users getUserByEmail(String email) {
        Query query = new Query(); //use query when for more complex queries, especially those that don't directly map to a method name convention
        query.addCriteria(Criteria.where("email").is(email));
        return mongoTemplate.findOne(query, users.class);

    }


}
