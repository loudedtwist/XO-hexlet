package s72743.htw.controller;

import org.junit.Test;
import s72743.htw.model.Field;
import s72743.htw.model.Figure;

import java.awt.*;

import static org.junit.Assert.*;


public class CurrentMoveControllerTest {

    @Test
    public void testCurrentMoveExpected_O() throws Exception {
        final  Field field = new Field(3);
        final Figure expectedFigure = Figure.O;
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(0, 1), Figure.O);
        field.setFigure(new Point(0, 2), Figure.X);
        final Figure actualFigure = CurrentMoveController.currentMove(field);
        assertEquals(expectedFigure, actualFigure);
    }
    @Test
    public void testCurrentMoveExpected_X() throws Exception {
        final  Field field = new Field(3);
        final Figure expectedFigure = Figure.X;
        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(0, 1), Figure.O);
        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 2), Figure.O);
        final Figure actualFigure = CurrentMoveController.currentMove(field);
        assertEquals(expectedFigure, actualFigure);
    }
    @Test
    public void testCurrentMoveExpected_null_becose_Empty() throws Exception {
        final  Field field = new Field(3);
        final Figure expectedFigure = Figure.X;
        final Figure actualFigure = CurrentMoveController.currentMove(field);
        assertEquals(expectedFigure, actualFigure);
    }
    @Test
    public void testCurrentMoveExpected_X_becose_FULL() throws Exception {
        final  Field field = new Field(3);
        for(int y = 0 ;  y< field.getSize(); y++){
            for(int x = 0 ; x < field.getSize(); x++){
                field.setFigure(new Point(x,y), Figure.X) ;
            }
        }
        final Figure actualFigure = CurrentMoveController.currentMove(field);
        assertNull(actualFigure);
    }
}