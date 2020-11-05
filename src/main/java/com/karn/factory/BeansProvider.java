package com.karn.factory;

import com.karn.service.CellProvider;
import com.karn.service.CellProviderImpl;
import com.karn.service.absraction.CellsIdentifier;
import com.karn.service.implementations.*;
/**
 * Register a new bean here to get instance through BeanProvider factory
 * */
public enum BeansProvider {
    KING(KingCellsIdentifier.class), QUEEN(QueenCellsIdentifier.class),
    BISHOP(BishopCellsIdentifier.class), HORSE(HorseCellsIdentifier.class),
    ROOK(RookCellsIdentifier.class), PAWN(PawnCellsIdentifier.class),
    CELL_PROVIDER(CellProviderImpl.class);

    private Class<?> type;

    BeansProvider(Class<?> cellsIdentifierClass) {
        this.type = cellsIdentifierClass;
    }

    public static BeansProvider getEnumInstanceByName(String name) {
        return BeansProvider.valueOf(name.toUpperCase());
    }

    public CellsIdentifier getIdentifierBean() throws IllegalAccessException, InstantiationException {
        return (CellsIdentifier) this.type.newInstance();
    }

    public Object getBean() throws IllegalAccessException, InstantiationException {
        return this.type.newInstance();
    }

}
