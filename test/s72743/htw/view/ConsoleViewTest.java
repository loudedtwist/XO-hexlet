package s72743.htw.view;

import org.junit.Test;
import s72743.htw.controller.CurrentMoveController;
import s72743.htw.model.Field;
import s72743.htw.model.Figure;
import s72743.htw.model.Game;
import s72743.htw.model.Player;

import java.awt.*;

import static org.junit.Assert.*;

public class ConsoleViewTest {

    @Test
    public void testShow() throws Exception {
        final Field field = new Field(3);
        final Figure expectedFigure = Figure.X;
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(0, 1), Figure.O);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.O);
        final Game game = new Game(new Player[2],"game1",field);
        final Figure actualFigure = CurrentMoveController.currentMove(field);

        ConsoleView.show(game);
        assertEquals(expectedFigure, actualFigure);
    }
}