package com.vz.springbatch.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Api {
	@Id
	private Integer id;
	private String api;
	private String request;
	private String response;
	private String method;

	public Api(Integer id, String api, String request, String response, String method) {
		super();
		this.id = id;
		this.api = api;
		this.request = request;
		this.response = response;
		this.method = method;
	}
	
	

	public Api() {
	
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public String toString() {
		return "Api [id=" + id + ", api=" + api + ", request=" + request + ", response=" + response + ", method="
				+ method + "]";
	}

}
