package s72743.htw;


import s72743.htw.controller.CurrentMoveController;
import s72743.htw.model.Field;
import s72743.htw.model.Figure;
import s72743.htw.model.Game;
import s72743.htw.model.Player;
import s72743.htw.view.ConsoleView;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class XOCLI {
    public static void main(String[] args) {
        final String name1 = "Warik";
        final String name2 = "Polina";
        final Field field = new Field(3);

        final Player[] players = new Player[2];
        players[0] = new Player(name1,Figure.X);
        players[1] = new Player(name2,Figure.O);

        final Game game = new Game(players ,"XO",field);
        do{
        ConsoleView.show(game);}
        while(ConsoleView.move(game));
    }
}
