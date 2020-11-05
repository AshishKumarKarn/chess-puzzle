package com.karn;

import com.karn.factory.BeansProvider;
import com.karn.service.CellProvider;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Program takes System input and processes the result.
 * Sample input = "King d3" (case insensitive).
 * Prints all possible position for the piece on the chess board.
 *
 * @author Ashish Karn
 */
public class App {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Piece and cell number!");
        String pieceString = sc.next();
        String placeString = sc.next();
        CellProvider cellProvider = (CellProvider) BeansProvider.getEnumInstanceByName("CELL_PROVIDER").getBean();
        List<String> result = cellProvider.retrievePossiblePlaces(pieceString, placeString).collect(Collectors.toList());
        System.out.println(result);
    }
}
