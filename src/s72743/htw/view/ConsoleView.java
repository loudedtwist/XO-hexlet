package s72743.htw.view;


import s72743.htw.controller.CurrentMoveController;
import s72743.htw.controller.MoveController;
import s72743.htw.controller.WinnerController;
import s72743.htw.model.Field;
import s72743.htw.model.Figure;
import s72743.htw.model.Game;
import s72743.htw.model.Player;
import s72743.htw.model.exceptions.AlreadyOccupiedException;
import s72743.htw.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    public static void show(final Game game){
         final Field field = game.getField();
        System.out.format("Game: %s \n", game.getName());
        try {
        for(int y = 0 ;  y< field.getSize(); y++){
            System.out.print("~~~~~~~\n");
            System.out.print("|");
            for(int x = 0 ; x < field.getSize(); x++){
                if(field.getFigure(new Point(x,y))==null) System.out.print(" ");
                else System.out.print(field.getFigure(new Point(x,y)));
                System.out.print("|");
            }
            System.out.print("\n");

        }
        } catch (InvalidPointException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static boolean move(final Game game){
        final MoveController moveController = new MoveController();
        System.out.println();
        final Field field = game.getField();
        final Figure figure = CurrentMoveController.currentMove(field);
        final Figure winner = WinnerController.getWinner(field);
        if(winner != null){
            System.out.format("\nHey %s, you are the Winner ! Congrats!\n", CurrentMoveController.whoIsWho(game, winner));
            return false;
        }

        if(figure ==null) {
                System.out.print("There is no winner and no moves left");
                return false;
            }

        final Player currentPlayer = CurrentMoveController.currentMove(field)
                == game.getPlayers()[0].getFigure() ? game.getPlayers()[0]: game.getPlayers()[1];

        System.out.format("Player %s, it's your turn now\n", currentPlayer.getName());

        moveController.applyFigure(field,figure,askPoint());
        return true;

    }

    private static Point askPoint(){
         return new Point(askCoordinat("X")-1, askCoordinat("Y")-1);
    }
    private static int askCoordinat(final String coordinatName){
        System.out.format("Please inter %s coordinate:\n",coordinatName);
        final Scanner scanner = new Scanner(System.in);
        try{
        return scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.print("Wrong input, Please, Enter a number.\n");
            return askCoordinat(coordinatName);
        }
    }
}
