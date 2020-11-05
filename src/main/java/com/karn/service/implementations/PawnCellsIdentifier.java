package com.karn.service.implementations;

import com.karn.service.absraction.CellsIdentifier;

import java.util.stream.Stream;

public class PawnCellsIdentifier implements CellsIdentifier {
    @Override
    public Stream<Integer> getPossiblePlaces(Integer currentPlace) {
        final int ones = (currentPlace % 10);
        final int tens = (currentPlace / 10);
        return Stream.of(Integer.valueOf((tens + 1) + "" + ones));
    }
}
