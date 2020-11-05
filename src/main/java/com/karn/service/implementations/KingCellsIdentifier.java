package com.karn.service.implementations;

import com.karn.service.absraction.CellsIdentifier;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class KingCellsIdentifier implements CellsIdentifier {
    @Override
    public Stream<Integer> getPossiblePlaces(Integer currentPlace) {
        final int ones = (currentPlace % 10);
        final int tens = (currentPlace / 10);
        final Set<Integer> result = new HashSet();
        for (int j = tens - 1; j <= tens + 1; j++) {
            for (int i = ones-1; i <= ones+1; i++) {
                if(i>=0 && j>=0){
                    result.add(Integer.valueOf(j + "" + i));
                }

            }
        }
        return result.stream().sorted();
    }
}
