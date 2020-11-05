package com.karn;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;

/**
 * Unit test for App.
 */
public class AppTest
{
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testMainWithValidData() throws IllegalAccessException, InstantiationException {
        String validData = "King d3";
        System.setIn(new ByteArrayInputStream(validData.getBytes()));
        App.main(null);
    }

    @Test
    public void testMainWithInvalidPlaceData() throws IllegalAccessException, InstantiationException {
        //Place could not be mapped to any valid location.
        expectedException.expect(NullPointerException.class);
        String invalidData = "King d";
        System.setIn(new ByteArrayInputStream(invalidData.getBytes()));
        App.main(null);
    }

    @Test
    public void testMainWithInvalidPieceData() throws IllegalAccessException, InstantiationException {
        // Piece could not be converted to a valid Bean (through BeanProvider)
        expectedException.expect(IllegalArgumentException.class);
        String invalidData = "Wajeer d3";
        System.setIn(new ByteArrayInputStream(invalidData.getBytes()));
        App.main(null);
    }
}
