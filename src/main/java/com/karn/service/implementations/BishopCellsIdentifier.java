package com.karn.service.implementations;

import com.karn.service.absraction.CellsIdentifier;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class BishopCellsIdentifier implements CellsIdentifier {
    @Override
    public Stream<Integer> getPossiblePlaces(Integer currentPlace) {
        final int ones = (currentPlace % 10);
        final int tens = (currentPlace / 10);
        final Set<Integer> result = new HashSet();
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                if ((ones - i) == (tens - j) || (i - ones) == (tens - j) || (ones - i) == (j - tens) || (ones + i) == (tens - j))
                    result.add(Integer.valueOf(j + "" + i));
            }
        }
        return result.stream().sorted();
    }
}
