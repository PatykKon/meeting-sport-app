package com.meeting.sport.app.booking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class BookingGameTimeTest {



    @ParameterizedTest
    @ValueSource(ints = {1,2})
    void returnCorrectBookingTime(int gameTime){
        BookingGameTime bookingGameTime = new BookingGameTime(gameTime);

        assertEquals(gameTime,bookingGameTime.gameTime());
        assertNotNull(bookingGameTime);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,0,3,4})
    void shouldThrowExceptionWithWrongValue(int gameTime){

        assertThrows(RuntimeException.class, () -> new BookingGameTime(gameTime));
    }

    @Test
    void shouldThrowExceptionWithNullValue(){
        assertThrows(RuntimeException.class, () -> new BookingGameTime(null));
    }

}