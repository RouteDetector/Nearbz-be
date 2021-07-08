package com.danijelsudimac.Nearbz;

import com.amazonaws.util.IOUtils;
import com.danijelsudimac.Nearbz.service.AWSRekognition;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class AWSRekognitionTests {

    @Test
    void givenTwoSimilarImages_onSubmit_shouldReturnMatch() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();

        try (InputStream profileIs = classLoader.getResource("profile.jpg").openStream();
             InputStream confirmationIs = classLoader.getResource("confirmation.jpg").openStream();
        ) {
            ByteBuffer profileImageBytes = ByteBuffer.wrap(IOUtils.toByteArray(profileIs));
            ByteBuffer validationImageBytes = ByteBuffer.wrap(IOUtils.toByteArray(confirmationIs));

            AWSRekognition rekognition = new AWSRekognition();
            rekognition.match(profileImageBytes, validationImageBytes);

        }
    }
}
