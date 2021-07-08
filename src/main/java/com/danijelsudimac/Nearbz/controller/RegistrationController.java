package com.danijelsudimac.Nearbz.controller;

import com.amazonaws.util.IOUtils;
import com.danijelsudimac.Nearbz.dto.Status;
import com.danijelsudimac.Nearbz.mapper.PersonMapper;
import com.danijelsudimac.Nearbz.model.Person;
import com.danijelsudimac.Nearbz.service.AWSRekognition;
import com.danijelsudimac.Nearbz.service.PersonService;
import com.danijelsudimac.Nearbz.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Random;

@RestController
@Slf4j
public class RegistrationController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonService personService;

    @GetMapping("/test")
    public String handleTest() {
        System.out.println("Test");
        return "cao";
    }

//    @PostMapping
//    public PersonDto createAccount(@RequestParam("profileImg") MultipartFile profile) throws IOException {
//        var random = new Random();
//        var token = random.nextLong();
//        var person = new Person();
//        person.setToken(token);
//        person = personService.savePerson(person);
//        return personMapper.entityToDto(person);
//    }

    @PostMapping("/register")
    public Status handleFileUpload(
//            @RequestParam("personId") Long personId,
//            @RequestParam("token") Long token,
            @RequestParam(value = "profileImg", required = false) MultipartFile profile,
            @RequestParam(value = "validationImg", required = false) MultipartFile validation
    ) {

        //check if valid and save image
        try (InputStream profileInputStream = profile.getInputStream();
             InputStream validationInputStream = validation.getInputStream();) {

            //get person from database
            var person = new Person();
            var random = new Random();
            var token = random.nextLong();
            person.setToken(token);

            //Load source and target images and create input parameters
            ByteBuffer profileImageBytes = ByteBuffer.wrap(IOUtils.toByteArray(profileInputStream));
            ByteBuffer validationImageBytes = ByteBuffer.wrap(IOUtils.toByteArray(validationInputStream));
            long len = profileImageBytes.array().length;
            long val = validationImageBytes.array().length;
            AWSRekognition.match(profileImageBytes, validationImageBytes);
            person = personService.savePerson(person);
//            person.setImagePath(String.valueOf(personId));

            storageService.saveImage(String.valueOf(person.getId()), profileImageBytes.array());

        } catch (Exception e) {
            log.info("Failed to load target images");
            return new Status(false);
        }
        ;
        return new Status(true);
    }
}
