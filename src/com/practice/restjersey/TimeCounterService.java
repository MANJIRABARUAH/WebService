package com.practice.restjersey;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.sun.jersey.spi.resource.Singleton;
 
@Singleton
@Path("/timeCounterservice")
public class TimeCounterService {
	
  private int count;
	
  @PostConstruct
  public void init() 
	  { 
	     count = 0;
	  } 
	  @GET
	  @Produces("application/json")
	  public Response timeAndCounter() throws JSONException {
 
		JSONObject jsonObject = new JSONObject();
		Calendar calendar = Calendar.getInstance();
		Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
		count = count+1;
		jsonObject.put("calls", count); 
		jsonObject.put("timestamp", currentTimestamp);
 
		String result = "@Produces(\"application/json\") Output: \n\n Timestamp and counter Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	  }
}