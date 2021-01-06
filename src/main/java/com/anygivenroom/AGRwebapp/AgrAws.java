package com.anygivenroom.AGRwebapp;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.*;
import com.amazonaws.services.sns.model.SubscribeRequest;

public class AgrAws {
	
	private static String awsTopicARN = "arn:aws:sns:us-east-1:478455282367:AnyGivenTopic";	
	private static BasicAWSCredentials awsCreds = new BasicAWSCredentials
			("AKIAJQVWEKAKLQMLI7UQ", "1sisproKdIMnxLUSJH0Ue6KwpHYASwImHuOcnBiX");
	
	
	private static AmazonSNS snsClient = 
			AmazonSNSClient
            .builder()
            .withRegion(Regions.US_EAST_1)
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
            .build();
	
	public String subToSnsTopic (String email) {
		
		SubscribeRequest subToTopic = new SubscribeRequest(awsTopicARN, "email", email); // try catch this
		snsClient.subscribe(subToTopic);
		
		return Response.snsSubResponse;
	}

}
