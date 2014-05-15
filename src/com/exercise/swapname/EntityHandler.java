package com.exercise.swapname;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;

public class EntityHandler {

	public String handle(HttpEntity entity) throws IllegalStateException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(entity.getContent()));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while((line = input.readLine()) != null) {
			System.out.println(line);
			sb.append(line);
		}
		input.close();
		return sb.toString();
	}
}
