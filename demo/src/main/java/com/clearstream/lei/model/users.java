package com.clearstream.lei.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class users 
{
	@JsonProperty("userId")
	String userId;

	@JsonProperty("id")
	int id;

	@JsonProperty("title")
	String title;

	@JsonProperty("completed")
	boolean completed;

	public String getUserId() 
	{
		return userId;
	}

	public void setUserId(String userId) 
	{
		this.userId = userId;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public boolean isCompleted() 
	{
		return completed;
	}

	public void setCompleted(boolean completed) 
	{
		this.completed = completed;
	}

	@Override
	public String toString() 
	{
		return "users [userId=" + userId + ", id=" + id + ", title=" + title + ", completed=" + completed + "]";
	}
}
