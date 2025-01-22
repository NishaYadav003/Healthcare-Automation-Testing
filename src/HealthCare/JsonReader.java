package HealthCare;

import com.fasterxml.jackson.databind.JsonNode;


import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {

public static JsonNode readJson(String filepath) throws IOException {
	
	ObjectMapper objectmapper = new ObjectMapper();
	
	return objectmapper.readTree(new File(filepath));
	
	
	
}

}
