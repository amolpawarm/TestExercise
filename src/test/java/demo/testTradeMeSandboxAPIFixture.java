package demo;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

@RunWith(ConcordionRunner.class)
public class testTradeMeSandboxAPIFixture {
	
	Response response;

	public void getUsedCarsDetails(String uri) {
		response = given().
				when().
				get(uri.trim()).
				then().
				statusCode(200).
				contentType(ContentType.JSON).extract().response();
	}
	
	public int getNumberOfNamedBrand() {
		return response.jsonPath().getList("Subcategories.Name").size();
	}
	
	public boolean verifyBrandExist(String brandName) {
		return response.jsonPath().getList("Subcategories.Name").contains(brandName.trim());
	}
	
	public String getResponsePrettyString() {
		return response.prettyPrint();
	}
}
