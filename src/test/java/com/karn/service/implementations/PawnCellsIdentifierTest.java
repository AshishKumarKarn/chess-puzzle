package com.karn.service.implementations;

import com.karn.service.absraction.CellsIdentifier;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PawnCellsIdentifierTest {

    //no need to use Mockito.mock as there is no third party API call or DB call
    private CellsIdentifier cellsIdentifier = new PawnCellsIdentifier();

    @Test
    public void testGetPossiblePlacesForPawn() {
        Stream<Integer> response = cellsIdentifier.getPossiblePlaces(0);
        Assert.assertNotNull(response);

        //doesn't includes current position as per the logic
        List<Integer> result = response.collect(Collectors.toList());
        Assert.assertEquals(1, result.size());
    }
}
