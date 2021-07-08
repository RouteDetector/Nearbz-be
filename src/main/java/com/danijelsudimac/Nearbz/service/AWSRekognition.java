package com.danijelsudimac.Nearbz.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.CompareFacesMatch;
import com.amazonaws.services.rekognition.model.CompareFacesRequest;
import com.amazonaws.services.rekognition.model.CompareFacesResult;
import com.amazonaws.services.rekognition.model.Image;

import javax.validation.ValidationException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

public class AWSRekognition {
    public static final Float SIMILARITY_THRESHOLD = 70F;

    public static void match(ByteBuffer profileImageBytes, ByteBuffer validationImageBytes) throws IOException {
        AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.defaultClient();

        Image profile = new Image()
                .withBytes(profileImageBytes);
        Image validation = new Image()
                .withBytes(validationImageBytes);

        CompareFacesRequest request = new CompareFacesRequest()
                .withSourceImage(profile)
                .withTargetImage(validation)
                .withSimilarityThreshold(SIMILARITY_THRESHOLD);

        // Call operation
        CompareFacesResult compareFacesResult = rekognitionClient.compareFaces(request);

        // Display results
        List<CompareFacesMatch> faceDetails = compareFacesResult.getFaceMatches();
        if (faceDetails.isEmpty())
            throw new ValidationException();
    }
}
