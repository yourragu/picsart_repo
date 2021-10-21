package apiScript;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response; 


public class JsonValidator {


	@Test
	public void getValues() throws IOException {	
		
		Map<String, String> allparams = new HashMap<String, String>();
		allparams.put("project", "reusable_components,photo_editor");
		RestAssured.baseURI = "https://api.picsart.com/localizations/en/messages";
		/*Response response = RestAssured.given().queryParams(allparams).accept(ContentType.JSON).get();
		response.body().prettyPrint();
		System.out.println("******************************************************************************************");
		System.out.println(response.jsonPath().get("Align"));*/
	
		//String file = FileUtils.readFileToString(new File("./jsonfile/Testjson.json"));
		File file = new File("./jsonfile/Testjson.json");
				
		Response response = RestAssured
				.given()
				.queryParams(allparams)
				.contentType(ContentType.JSON)
				.post()
				.then()
				.assertThat()
				.body(matchesJsonSchema(file))
				.extract()
				.response();
		
		response.body().prettyPrint();
		System.out.println(response.getStatusCode());
	}


}
