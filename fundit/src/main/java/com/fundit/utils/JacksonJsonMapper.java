/**
 * 
 */
package com.fundit.utils;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * @author Kashif
 *
 */
public class JacksonJsonMapper {

	public static <T> HttpEntity<T> createEntity(final T body){
		ObjectMapper mapper = new ObjectMapper();
		int contentLength = 0;
		String convertedObj = null;
		try {
			convertedObj = mapper.writeValueAsString(body);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		contentLength = convertedObj.length();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setContentLength(contentLength);
		HttpEntity<T> entity = new HttpEntity<T>(body, headers);
		return entity;
	}
}
