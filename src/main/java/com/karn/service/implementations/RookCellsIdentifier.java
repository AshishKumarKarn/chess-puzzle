package com.karn.service.implementations;

import com.karn.service.absraction.CellsIdentifier;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class RookCellsIdentifier implements CellsIdentifier {
    @Override
    public Stream<Integer> getPossiblePlaces(Integer currentPlace) {
        final int ones = (currentPlace % 10);
        final int tens = (currentPlace / 10);
        final Set<Integer> result = new HashSet();
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                if (j == tens || i == ones)
                    result.add(Integer.valueOf(j + "" + i));
            }
        }
        return result.stream().sorted();
    }
}
