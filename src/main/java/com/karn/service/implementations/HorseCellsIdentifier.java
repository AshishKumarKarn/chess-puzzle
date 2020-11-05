package com.karn.service.implementations;

import com.karn.service.absraction.CellsIdentifier;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class HorseCellsIdentifier implements CellsIdentifier {
    @Override
    public Stream<Integer> getPossiblePlaces(Integer currentPlace) {
        final int ones = (currentPlace % 10);
        final int tens = (currentPlace / 10);
        final Set<Integer> result = new HashSet();
        for (int j = tens - 2; j <= tens + 2; j++) {
            for (int i = ones - 2; i <= ones + 2; i++) {
                if (!((ones - i) == (tens - j) ||
                        (i - ones) == (tens - j) ||
                        (ones - i) == (j - tens) ||
                        (ones + i) == (tens - j) ||
                        (j == tens) ||
                        (i == ones)) && i>=0 && j>=0){
                    result.add(Integer.valueOf(j + "" + i));
                }

            }
        }
        return result.stream().sorted();
    }
}
