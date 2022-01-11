package com.herokuapp.booker.bookinginfo;


import com.herokuapp.booker.constants.EndPoints;
import com.herokuapp.booker.model.BookingPojo;
import com.herokuapp.booker.testbase.TestBaseBooking;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Test;

//@RunWith(SerenityRunner.class)
public class BookingPatchRequest extends TestBaseBooking {

    @Title("Updating a current booking with partial payload")
    @Test
    public void updatePartialDetails(){

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Name After");
        bookingPojo.setLastname("Patch");


        SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .header("cookie", "token=2b60f78007a66ac")
                .body(bookingPojo)
                .pathParam("bookingId", 2)
                .when()
                .patch(EndPoints.UPDATE_SINGLE_BOOKING_WITH_ID)
                .then()
                .statusCode(200)
                .log().all();

    }




}
