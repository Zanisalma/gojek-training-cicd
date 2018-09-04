package com.gojek.academy.refactoring.game01.game;

import java.util.Random;

// TODO: 1. Mind you language
public class Game {

    private int totalCard;
    private CardBoard board;

    public Game(int totalRow, int totalColumn){

        this.totalCard = totalRow * totalColumn / 2;
        this.board = new CardBoard(totalRow, totalColumn);

        System.out.println(totalCard);
        System.out.println(board);

        //TODO: 6. Feature Envy
        for(int i = 0; i < totalRow; i++){
            for(int j = 0; j < totalColumn; j++){
                board.getMap()[i][j] = "x";
            }
        }

        // reshuffle cards
        Random random = new Random();

        for(int i = 0; i < this.totalCard; i ++){

            for(int j = 0; j < 2; j++){
                int row;
                int column;


                while(true){
                    row = random.nextInt(totalRow);
                    column = random.nextInt(totalColumn);

                    //TODO: 6. Feature Envy
                    if(board.getMap()[row][column] == "x"){
                        board.getMap()[row][column] = i + "";
                        break;
                    }
                }
            }
        }
    }


    public int getTotalCard() {
        return totalCard;
    }

    //TODO: 6. Feature Envy
    public String getCard(int row, int column){
        return board.getMap()[row][column];
    }
}
