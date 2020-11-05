package com.karn.service;

import java.util.stream.Stream;

public interface CellProvider {
    Stream<String> retrievePossiblePlaces(String piece, String place) throws InstantiationException, IllegalAccessException;
}
