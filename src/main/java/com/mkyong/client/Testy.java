package com.mkyong.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Testy {

	public static void main(String[] args) {
		Testy testy = new Testy();
		
		String input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}";
		System.out.println("input = " + input);
		
		String outputPOST = testy.sendPOST();
		System.out.println("outputPOST = " + outputPOST);
		
		String outputGET = testy.sendGET();
		System.out.println("outputGET = " + outputGET);		
	}

	private String sendPOST(){
		try {
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/RESTfulExample/rest/json/testy/przybadzJednorozcu");
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class);
			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
			}
			return response.getEntity(String.class);
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	private String sendGET(){
		try {
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/RESTfulExample/rest/json/testy/znajdzZgube");
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "+ response.getStatus());
			}
			return response.getEntity(String.class);
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
