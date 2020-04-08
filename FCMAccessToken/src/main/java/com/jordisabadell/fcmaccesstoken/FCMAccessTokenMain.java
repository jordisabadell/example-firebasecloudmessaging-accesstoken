package com.jordisabadell.fcmaccesstoken;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

public class FCMAccessTokenMain {

	public static void main(String[] args) throws IOException {

		FileInputStream privateKeyFile = new FileInputStream("c:/tmp/private_key.json");
		
		//OAuth 2.0 Scopes for Google APIs --> https://developers.google.com/identity/protocols/oauth2/scopes#fcmv1
		String[] scopes = new String[] { 
				"https://www.googleapis.com/auth/cloud-platform"
		};
				
		GoogleCredential googleCredential = GoogleCredential
			.fromStream(privateKeyFile)
			.createScoped(Arrays.asList(scopes));
		
		googleCredential.refreshToken();
		
		String accessToken = googleCredential.getAccessToken();
		
		System.out.println(accessToken);
	}
}