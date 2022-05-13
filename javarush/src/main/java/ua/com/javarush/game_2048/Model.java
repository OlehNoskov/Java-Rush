package ua.com.javarush.game_2048;

import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;

    public Model() {
//        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
//        for (int i = 0; i < FIELD_WIDTH; i++) {
//            for (int b = 0; b < FIELD_WIDTH; b++) {
//                gameTiles[i][b] = new Tile();
//            }
//        }
        resetGameTiles();
    }

    List<Tile> getEmptyTiles() {
        return null;
    }

    private void addTile(){

    }

    void resetGameTiles() {

    }
}