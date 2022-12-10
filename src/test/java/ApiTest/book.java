package ApiTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class book {
	@Test(priority = 1, description ="checking the booking id ")	
	public void creatBooing() {
			
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		String response2=given().log().all().header("Content-Type","application/json").header("Accept","application/json")
	.body(payload.booking("Jim","Brown",111,true,"2018-01-01","2018-01-02","Breakfast")) .when().post("/booking")
	.then().log().all().assertThat().statusCode(200)
	//.body("status", equalTo("success"))
	.header("Content-Type", "application/json; charset=utf-8").extract().response().asString();
		JsonPath js=new JsonPath(response2);
int  bookingid=  js.get("bookingid");
    System.out.println(bookingid);	
}
	@Test(priority = 2, description ="checking the Namevalidation ")	
	public void Namevalidation() {
			
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		String response2=given().log().all().header("Content-Type","application/json").header("Accept","application/json")
	.body(payload.booking("Jim","Brown",111,true,"2018-01-01","2018-01-02","Breakfast")) .when().post("/booking")
	.then().log().all().assertThat().statusCode(200)
	.body("booking.firstname", equalTo("Jim")).body("booking.lastname", equalTo("Brown"))
	.header("Content-Type", "application/json; charset=utf-8").extract().response().asString();	
}
	
	@Test(priority = 3, description ="checking the totalprice ")	
	public void totalprice() {
			
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		String response2=given().log().all().header("Content-Type","application/json").header("Accept","application/json")
	.body(payload.booking("Jim","Brown",111,true,"2018-01-01","2018-01-02","Breakfast")) .when().post("/booking")
	.then().log().all().assertThat().statusCode(200)
	.body("booking.totalprice", equalTo(111))
	.header("Content-Type", "application/json; charset=utf-8").extract().response().asString();	
}
	@Test(priority = 4, description ="checking the depositpaid ")	
	public void depositpaid() {
			
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		String response2=given().log().all().header("Content-Type","application/json").header("Accept","application/json")
	.body(payload.booking("Jim","Brown",111,true,"2018-01-01","2018-01-02","Breakfast")) .when().post("/booking")
	.then().log().all().assertThat().statusCode(200)
	.body("booking.depositpaid", equalTo(true))
	.header("Content-Type", "application/json; charset=utf-8").extract().response().asString();	
}
	@Test(priority = 5, description ="checking the additionalneeds ")	
	public void additionalneeds() {
			
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		String response2=given().log().all().header("Content-Type","application/json").header("Accept","application/json")
	.body(payload.booking("Jim","Brown",111,true,"2018-01-01","2018-01-02","Breakfast")) .when().post("/booking")
	.then().log().all().assertThat().statusCode(200)
	.body("booking.additionalneeds", equalTo("Breakfast"))
	.header("Content-Type", "application/json; charset=utf-8").extract().response().asString();	
}
	// checkout date is changing in response
	@Test(priority = 6, description ="checking the same date ")	
	public void sameDate() {
			
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		String response2=given().log().all().header("Content-Type","application/json").header("Accept","application/json")
	.body(payload.booking("Jim","Brown",111,true,"2018-01-01","2018-01-01","Breakfast")) .when().post("/booking")
	.then().log().all().assertThat().statusCode(200)
	.body("booking.bookingdates.checkout", equalTo("2018-01-02"))
	.header("Content-Type", "application/json; charset=utf-8").extract().response().asString();	
}
	@Test(priority = 7, description ="checking the same date ")	
	public void WrongdateFormate () {
			
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		String response2=given().log().all().header("Content-Type","application/json").header("Accept","application/json")
	.body(payload.booking("Jim","Brown",111,true,"dec-02-2022","dec-03-2022","Breakfast")) .when().post("/booking")
	.then().log().all().assertThat().statusCode(200)
	//.body("booking.bookingdates.checkout", equalTo("2018-01-02"))
	.header("Content-Type", "application/json; charset=utf-8").extract().response().asString();	
}
	@Test(priority = 7, description ="checking that checkin date should blank ")	
	public void checkinBlank () {
			
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		String response2=given().log().all().header("Content-Type","application/json").header("Accept","application/json")
	.body(payload.booking("Jim","Brown",111,true,"","dec-03-2022","Breakfast")) .when().post("/booking")
	.then().log().all().assertThat().statusCode(200)
	//.body("booking.bookingdates.checkout", equalTo("2018-01-02"))
	.header("Content-Type", "application/json; charset=utf-8").extract().response().asString();	
}
	@Test(priority = 8, description ="checking that checkout is blank ")	
	public void checkoutBlank () {
			
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		String response2=given().log().all().header("Content-Type","application/json").header("Accept","application/json")
	.body(payload.booking("Jim","Brown",111,true,"dec-02-2022","","Breakfast")) .when().post("/booking")
	.then().log().all().assertThat().statusCode(200)
	//.body("booking.bookingdates.checkout", equalTo("2018-01-02"))
	.header("Content-Type", "application/json; charset=utf-8").extract().response().asString();	
}
	@Test(priority = 7, description ="checking the depositpaid is false")	
	public void depositpaidFalse () {
			
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		String response2=given().log().all().header("Content-Type","application/json").header("Accept","application/json")
	.body(payload.booking("Jim","Brown",111,false,"dec-02-2022","dec-03-2022","Breakfast")) .when().post("/booking")
	.then().log().all().assertThat().statusCode(200)
	.body("booking.depositpaid", equalTo(false))
	.header("Content-Type", "application/json; charset=utf-8").extract().response().asString();	
}
}
		
	
