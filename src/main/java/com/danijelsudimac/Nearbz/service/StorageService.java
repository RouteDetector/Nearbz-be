package com.danijelsudimac.Nearbz.service;

import com.amazonaws.util.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageService {

    @Value("${storage_location}")
    private String location;

    public void saveImage(String fileName, byte[] bytes) throws IOException {
        Path path = Paths.get(location + fileName);
        Files.write(path, bytes);
    }

    public byte[] getImage(String id) throws IOException {
        Path path = Paths.get(location + id);
        InputStream in = Files.newInputStream(path);
        return IOUtils.toByteArray(in);
    }
}
