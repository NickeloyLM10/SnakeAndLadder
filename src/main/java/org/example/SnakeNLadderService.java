package org.example;

import java.util.*;

public class SnakeNLadderService {
    private SnakeNLadderBoard snakeNLadderBoard;
    private Queue<Player> players;
    private int initialNoOfPlayers;
//    private int boardSize;
    private boolean isGameComplete;
    private static final int DEFAULT_BOARD_SIZE = 100;


    public SnakeNLadderService(int boardSize) {
        this.snakeNLadderBoard = new SnakeNLadderBoard(boardSize);
//        this.players = new LinkedList<Player>();
    }

    public SnakeNLadderService(){
        this(SnakeNLadderService.DEFAULT_BOARD_SIZE);
    }

    public void setPlayers(List<Player> players) {
        this.players = new LinkedList<Player>();
        this.initialNoOfPlayers = players.size();
        HashMap<String, Integer> playerPieces = new HashMap<String, Integer>();
        for(Player player : players){
            this.players.add(player);
            playerPieces.put(player.getPlayerId() , 0);
        }
        snakeNLadderBoard.setPlayerPieces(playerPieces);
    }

    public void setSnakes(List<Snake> snakes){
        snakeNLadderBoard.setSnakes(snakes);
    }
    private int getValueofdice(){
        return DiceService.roll();
    }
    public void setLadders(List<Ladder> ladders){
        snakeNLadderBoard.setLadders(ladders);
    }

    public void movePlayer(Player player,int position){
        int oldPosition = snakeNLadderBoard.getPlayerPieces().get(player.getPlayerId());
        int currPosition = position + oldPosition;
        if(currPosition > 100){
            currPosition = oldPosition;
        }
        else{
            currPosition = goThroughSnakesAndLadders(currPosition);
        }
        snakeNLadderBoard.getPlayerPieces().put(player.getPlayerId(), currPosition);
        System.out.println(player.getPlayerName() + " rolled a " + position + " and moved from " + oldPosition + " to " + currPosition);
    }
    private boolean hasPlayerWon(Player player){
        int currPosition = snakeNLadderBoard.getPlayerPieces().get(player.getPlayerId());
        return currPosition == 100;
    }

    private boolean isGameComplete(){
        int currPlayers = players.size();
        return currPlayers < initialNoOfPlayers;
    }

    private int goThroughSnakesAndLadders(int currPosition) {

        while(true){
            int temp = currPosition;
            for(Ladder ladder : snakeNLadderBoard.getLadders()){
                if(ladder.getStart() == currPosition){
                    currPosition = ladder.getEnd();
                }
            }
            for(Snake snake : snakeNLadderBoard.getSnakes()){
                if(snake.getStart() == currPosition){
                    currPosition = snake.getEnd();
                }
            }
            if(temp == currPosition){
                break;
            }
        }
        return currPosition;
    }

    public void startGame(){

        while(!isGameComplete()){
            int diceValue = getValueofdice();
            Player currentPlayer = players.poll();
            movePlayer(currentPlayer , diceValue);
            if(hasPlayerWon(currentPlayer)){
                System.out.println(currentPlayer.getPlayerName() + " has Won! ");
                snakeNLadderBoard.getPlayerPieces().remove(currentPlayer.getPlayerId());
            }
            else{
                players.add(currentPlayer);
            }
        }

    }
}
