package com.vz.springbatch.batch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.vz.springbatch.model.Api;

@Component
public class ApiProcessor implements ItemProcessor<Api, Api> {

	@Override
	public Api process(Api api) throws Exception {
		String apiName = api.getApi();
		String request = api.getRequest();
		String response = api.getResponse();
		String method = api.getMethod();
		String responseFromApi = callRestPostRequest(apiName, request, response,method);
		api.setResponse(responseFromApi);
		api.setRequest(request.replace('^', ','));
		return api;
	}

	private String callRestPostRequest(String apiName, String request, String response, String method) {
		StringBuffer out = new StringBuffer();
		try {

			URL url = new URL(apiName);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod(method.toUpperCase());
			conn.setRequestProperty("Content-Type", "application/json");

			String input = request.replace('^', ',');
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;

			System.err.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.err.println(output);
				out.append(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return out.toString();
	}
}
