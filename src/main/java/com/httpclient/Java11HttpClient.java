package com.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Java11HttpClient {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

		getStudentById();
		postStudent();

	}

	private static void getStudentById() throws URISyntaxException, IOException, InterruptedException {
		String getUrl="http://localhost:8080//student/40";
		
		HttpRequest getReq = HttpRequest.newBuilder().uri(new URI(getUrl)).build();

		HttpClient client = HttpClient.newBuilder().build();

		HttpResponse<String> response = client.send(getReq, BodyHandlers.ofString());

		System.out.println(response.body());
		System.out.println(response.statusCode());
	}

	private static void postStudent() throws URISyntaxException, IOException, InterruptedException{
		
		String postUrl=  "http://localhost:8080//student";
		final String json = "{\"roll\":17,\"name\":\"AAA\",\"address\":\"ZZZ\"}";

		HttpRequest postReq=HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(json)).uri(new URI(postUrl)).header("Content-Type", "application/json").build();
		
		HttpClient client = HttpClient.newBuilder().build();

		HttpResponse<String> httpResponse= client.send(postReq, HttpResponse.BodyHandlers.ofString());
		
		System.out.println(httpResponse);
		System.out.println(httpResponse.statusCode());
		System.out.println(httpResponse.body());
		
		
	}


}
