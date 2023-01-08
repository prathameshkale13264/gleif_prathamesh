package com.clearstream.lei.controller;

import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.clearstream.lei.model.users;
import com.clearstream.lei.service.LeiService;

@RestController()
public class LeiController 
{
	private static final String GOLDEN_COPY_URL = "https://goldencopy.gleif.org/api/v2/golden-copies/publishes/lei2/latest.csv?delta=LastDay";
	
	@Autowired
	private final LeiService leiService;


    public LeiController(LeiService leiService) 
    {
        this.leiService = leiService;
    }
    
	/* Method For Testing Purpose */
	@GetMapping(value = "/")
	public String test() 
	{
		return "Testing...";
	}

	@GetMapping(value = "/getAllDataById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<users> getDataById(@PathVariable int id) 
	{
		return new ResponseEntity<>(leiService.getAllDataByLeiId(id), HttpStatus.OK);
	}

	@GetMapping(value = "/getAllData", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<users> getAllData() 
	{
		return new ResponseEntity<>(leiService.getAllData(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/golden_Copy_Download")
	public static ResponseEntity<Object> goldenCopyDownload() throws URISyntaxException 
	{
		 URI golden_copy_url = new URI(GOLDEN_COPY_URL);
		 HttpHeaders httpHeaders = new HttpHeaders();
		 httpHeaders.setLocation(golden_copy_url);
		 return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
	} 
}
