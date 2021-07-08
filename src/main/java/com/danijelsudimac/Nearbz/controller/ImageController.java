package com.danijelsudimac.Nearbz.controller;

import com.danijelsudimac.Nearbz.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class ImageController {

    @Autowired
    private StorageService storageService;

    @GetMapping(value = "/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImage(@PathVariable(value = "id") String id) throws IOException {
        return storageService.getImage(id);
    }
}
