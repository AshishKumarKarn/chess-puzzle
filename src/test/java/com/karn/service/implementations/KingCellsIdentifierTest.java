package com.karn.service.implementations;

import com.karn.service.absraction.CellsIdentifier;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KingCellsIdentifierTest {

    //no need to use Mockito.mock as there is no third party API call or DB call
    private CellsIdentifier cellsIdentifier = new KingCellsIdentifier();

    @Test
    public void testGetPossiblePlacesForKing() {
        Stream<Integer> response = cellsIdentifier.getPossiblePlaces(0);
        Assert.assertNotNull(response);

        //includes current position, which gets filtered by the call method
        List<Integer> result = response.collect(Collectors.toList());
        Assert.assertEquals(4, result.size());
    }
}
