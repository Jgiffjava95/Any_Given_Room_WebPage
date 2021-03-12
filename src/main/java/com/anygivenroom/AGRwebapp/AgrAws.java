package com.anygivenroom.AGRwebapp;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.*;
import com.amazonaws.services.sns.model.SubscribeRequest;

public class AgrAws {
	
	private static String awsTopicARN = "";	
	private static BasicAWSCredentials awsCreds = new BasicAWSCredentials
			("", "");
	
	
	private static AmazonSNS snsClient = 
			AmazonSNSClient
            .builder()
            .withRegion(Regions.US_EAST_1)
            .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
            .build();
	
	public void subToSnsTopic (String email) {
		
		SubscribeRequest subToTopic = new SubscribeRequest(awsTopicARN, "email", email); // try catch this
		snsClient.subscribe(subToTopic);
	}

}
