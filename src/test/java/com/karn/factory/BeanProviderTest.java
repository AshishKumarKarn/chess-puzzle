package com.karn.factory;

import com.karn.service.absraction.CellsIdentifier;
import com.karn.service.implementations.KingCellsIdentifier;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BeanProviderTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testBeanProviderToGetRegisteredBean() throws IllegalAccessException, InstantiationException {
        CellsIdentifier cellsIdentifier = BeansProvider.getEnumInstanceByName("king").getIdentifierBean();
        Assert.assertNotNull(cellsIdentifier);
        Assert.assertTrue(cellsIdentifier instanceof KingCellsIdentifier);
    }

    @Test
    public void testBeanProviderForUnregisteredBean() throws IllegalAccessException, InstantiationException {
        expectedException.expect(IllegalArgumentException.class);
        BeansProvider.getEnumInstanceByName("kong").getIdentifierBean();
    }
}
