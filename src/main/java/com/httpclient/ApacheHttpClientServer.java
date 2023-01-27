package com.httpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ApacheHttpClientServer {

	static String postUrl = "http://localhost:8080//student";
	static String getUrl = "http://localhost:8080//student/14";

	public static void main(String[] args) throws ParseException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();

		getStudentById(client);
		postStudent(client);

	}

	private static void getStudentById(CloseableHttpClient client) throws IOException, ClientProtocolException {

		HttpGet getReq = new HttpGet(getUrl);
		CloseableHttpResponse response = client.execute(getReq);
		HttpEntity entity = response.getEntity();
		String result = EntityUtils.toString(entity);
		System.out.println(result);
	}

	private static void postStudent(CloseableHttpClient client) throws ParseException, IOException {

		HttpPost postReq = new HttpPost(postUrl);

		final String json = "{\"roll\":40,\"name\":\"Sham\",\"address\":\"Mumbai\"}";
		final StringEntity postEntity = new StringEntity(json);
		postReq.setHeader("Content-type", "application/json");
		postReq.setEntity(postEntity);

		CloseableHttpResponse postResponse = client.execute(postReq);
		String postRes = EntityUtils.toString(postResponse.getEntity());
		System.out.println(postReq);

	}

}
