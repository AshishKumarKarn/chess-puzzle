package com.karn.service.absraction;

import java.util.stream.Stream;

public interface CellsIdentifier {
    Stream<Integer> getPossiblePlaces(Integer currentPlace);
}

