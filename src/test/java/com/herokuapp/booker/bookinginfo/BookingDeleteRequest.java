package com.herokuapp.booker.bookinginfo;


import com.herokuapp.booker.constants.EndPoints;
import com.herokuapp.booker.testbase.TestBaseBooking;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Test;

//@RunWith(SerenityRunner.class)
public class BookingDeleteRequest extends TestBaseBooking {

    @Title("Deletes a booking with ID")
    @Test
    public void deleteBooking(){
        SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Cookie", "{{token}}")
                .pathParam("bookingId", 10)
                .when()
                .delete(EndPoints.DELETE_SINGLE_BOOKING_WITH_ID)
                .then()
                .statusCode(201)
                .log().all();
    }
}
