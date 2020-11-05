package com.karn.service;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CellProviderImplTest {

    private CellProvider cellProvider = new CellProviderImpl();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testRetrievePossiblePlacesForKing() throws IllegalAccessException, InstantiationException {
        Stream<String> response = cellProvider.retrievePossiblePlaces("King", "D3");
        Assert.assertNotNull(response);
        List<String> result = response.collect(Collectors.toList());
        Assert.assertEquals(8, result.size());
        Assert.assertEquals(Arrays.asList("C2", "D2", "E2", "C3", "E3", "C4", "D4", "E4"), result);
    }

    @Test
    public void testRetrievePossiblePlacesForInvalidPiece() throws IllegalAccessException, InstantiationException {
        expectedException.expect(IllegalArgumentException.class);
        List<String> response = cellProvider.retrievePossiblePlaces("Hello", "D3").collect(Collectors.toList());
        Assert.assertNull(response);
    }

    @Test
    public void testRetrievePossiblePlacesForInvalidPlace() throws IllegalAccessException, InstantiationException {
        expectedException.expect(NullPointerException.class);
        List<String> result = cellProvider.retrievePossiblePlaces("King", "3").collect(Collectors.toList());
        Assert.assertNull(result);
    }

    @Test
    public void testRetrievePossiblePlacesForBishop() throws IllegalAccessException, InstantiationException {
        Stream<String> response = cellProvider.retrievePossiblePlaces("Bishop", "A1");
        Assert.assertNotNull(response);
        List<String> result = response.collect(Collectors.toList());
        Assert.assertEquals(7, result.size());
        Assert.assertEquals(Arrays.asList("B2", "C3", "D4", "E5", "F6", "G7", "H8"), result);
    }

    @Test
    public void testRetrievePossiblePlacesForHorse() throws IllegalAccessException, InstantiationException {
        Stream<String> response = cellProvider.retrievePossiblePlaces("horse", "A1");
        Assert.assertNotNull(response);
        List<String> result = response.collect(Collectors.toList());
        Assert.assertEquals(2, result.size());
        Assert.assertEquals(Arrays.asList( "C2","B3"), result);
    }

    @Test
    public void testRetrievePossiblePlacesForPawn() throws IllegalAccessException, InstantiationException {
        Stream<String> response = cellProvider.retrievePossiblePlaces("pawn", "D3");
        Assert.assertNotNull(response);
        List<String> result = response.collect(Collectors.toList());
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(Arrays.asList("D4"), result);
    }

    @Test
    public void testRetrievePossiblePlacesForQueen() throws IllegalAccessException, InstantiationException {
        Stream<String> response = cellProvider.retrievePossiblePlaces("Queen", "A1");
        Assert.assertNotNull(response);
        List<String> result = response.collect(Collectors.toList());
        Assert.assertEquals(21, result.size());
        Assert.assertEquals(Arrays.asList("B1", "C1", "D1", "E1", "F1", "G1", "H1", "A2", "B2", "A3", "C3", "A4", "D4", "A5", "E5", "A6", "F6", "A7", "G7", "A8", "H8"), result);
    }

    @Test
    public void testRetrievePossiblePlacesForRook() throws IllegalAccessException, InstantiationException {
        Stream<String> response = cellProvider.retrievePossiblePlaces("Rook", "A1");
        Assert.assertNotNull(response);
        List<String> result = response.collect(Collectors.toList());
        Assert.assertEquals(14, result.size());
        Assert.assertEquals(Arrays.asList("B1", "C1", "D1", "E1", "F1", "G1", "H1", "A2", "A3", "A4", "A5", "A6", "A7", "A8"), result);
    }
}
