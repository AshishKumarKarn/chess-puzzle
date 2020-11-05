package com.karn.service;

import com.karn.factory.BeansProvider;
import com.karn.service.absraction.CellsIdentifier;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class CellProviderImpl implements CellProvider {
    private final Map<Integer, String> boardMapByIntegerLocation = new HashMap<>(64,1f);
    private final Map<String, Integer> boardMapByStringLocation = new HashMap<>(64,1f);
    private final Map<Integer, String> horizontalLevel = new HashMap<>(8,1f);

    private void initializeBoard() {
        //initialize levels
        horizontalLevel.put(0, "A");
        horizontalLevel.put(1, "B");
        horizontalLevel.put(2, "C");
        horizontalLevel.put(3, "D");
        horizontalLevel.put(4, "E");
        horizontalLevel.put(5, "F");
        horizontalLevel.put(6, "G");
        horizontalLevel.put(7, "H");

        //initialize boardMaps
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0) {
                    boardMapByIntegerLocation.put(j, horizontalLevel.get(j) + "1");
                    boardMapByStringLocation.put(horizontalLevel.get(j) + "1", j);
                } else {
                    boardMapByIntegerLocation.put(Integer.valueOf(i + "" + j), horizontalLevel.get(j) + "" + (i + 1));
                    boardMapByStringLocation.put(horizontalLevel.get(j) + "" + (i + 1), Integer.valueOf(i + "" + j));
                }
            }
        }
    }

    public Stream<String> retrievePossiblePlaces(String piece, String stringPlace) throws InstantiationException, IllegalAccessException {
        initializeBoard();
        Integer currentPlace = boardMapByStringLocation.get(stringPlace.toUpperCase());
        CellsIdentifier possibleCellsIdentifier = BeansProvider.getEnumInstanceByName(piece).getIdentifierBean();
        return possibleCellsIdentifier.getPossiblePlaces(currentPlace)
                .filter(a -> Optional.ofNullable(boardMapByIntegerLocation.get(a)).isPresent() && !a.equals(currentPlace))
                .map(boardMapByIntegerLocation::get);
    }
}
