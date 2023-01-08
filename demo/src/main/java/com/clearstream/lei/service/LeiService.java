package com.clearstream.lei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.clearstream.lei.model.users;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LeiService 
{
	private static final String BASE_URL = "https://jsonplaceholder.typicode.com/todos";
	
	@Autowired
	private final RestTemplate restTemplate;
	users url_reponse = new users();
	JsonNode root;

	public LeiService(RestTemplate restTemplate) 
	{
		this.restTemplate = restTemplate;	
	}

	public String test() 
	{
		return "Test";
	}

	public users getAllDataByLeiId(int id) 
	{
		ObjectMapper mapper = new ObjectMapper();
		String json = restTemplate.getForObject(BASE_URL + "/" + id, String.class);
		try 
		{
			url_reponse = mapper.readerFor(users.class).readValue(json);
		} 
		catch (JsonProcessingException e) 
		{
			e.printStackTrace();
		}
		System.out.println(json);
		return url_reponse;
	}

	public users getAllData() 
	{
		ObjectMapper mapper = new ObjectMapper();
		String json = restTemplate.getForObject(BASE_URL, String.class);
		try 
		{
			url_reponse = mapper.readerFor(users.class).readValue(json);
		} 
		catch (JsonProcessingException e) 
		{
			e.printStackTrace();
		}
		return url_reponse;
	}
}
