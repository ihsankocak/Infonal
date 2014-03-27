package com.infonal.service;

import com.infonal.service.interfaces.UserServiceInt;
import com.infonal.model.CaptchaPair;
import com.infonal.model.User;
import java.util.List;
import java.util.UUID;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserService implements UserServiceInt {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void addUser(User user) {
        if (!mongoTemplate.collectionExists(User.class)) {
            mongoTemplate.createCollection(User.class);
        }
        user.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(user, COLLECTION_NAME);
    }

    @Override
    public List<User> listUser() {
        return mongoTemplate.findAll(User.class, COLLECTION_NAME);
    }

    @Override
    public void deleteUserById(String userId) {
        User user = mongoTemplate.findById(userId, User.class, COLLECTION_NAME);
        mongoTemplate.remove(user);
    }

    @Override
    public void deleteUser(User user) {
        mongoTemplate.remove(user, COLLECTION_NAME);
    }

    @Override
    public void updateUser(User user) {
        mongoTemplate.insert(user, COLLECTION_NAME);
    }

    @Override
    public void updateUserById(String userId) {
        User user = mongoTemplate.findById(userId, User.class, COLLECTION_NAME);
        updateUser(user);
    }
    @Autowired
    private ReCaptchaImpl reCaptcha;

    public Boolean isCaptchaValid(String remoteAddress, CaptchaPair captchaPair) {

        ReCaptchaResponse reCaptchaResponse = this.reCaptcha.checkAnswer(remoteAddress, captchaPair.getRecaptcha_challenge_field(), captchaPair.getRecaptcha_response_field());
        return reCaptchaResponse.isValid();

    }
    @Override
    public void deleteAllUsers(){
        Query query=new Query();
        query.addCriteria(Criteria.where("id").is("1"));
        
        mongoTemplate.remove(query, COLLECTION_NAME);
    }

}
