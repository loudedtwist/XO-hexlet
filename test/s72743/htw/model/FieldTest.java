package s72743.htw.model;

import org.junit.Test;
import s72743.htw.model.exceptions.AlreadyOccupiedException;
import s72743.htw.model.exceptions.InvalidPointException;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by warik on 15.09.15.
 */
public class FieldTest {

    @Test
    public void testGetSize() throws Exception {
        int expectedValue = 3*3;
        final  Field field = new Field();
        int actualValue =  field.getSize();
        assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testSetFigure() throws Exception {
        final  Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint,inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure,actualFigure);
    }
    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception {
        final  Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure actualFigure = field.getFigure(inputPoint);
        assertNull(actualFigure);
    }
    @Test
    public void testGetFigureWhenXIsLessThenZero() throws Exception {
        final  Field field = new Field();
        final Point inputPoint = new Point(0,-1);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e){}
    }
    @Test
    public void testGetFigureWhenYIsLessThenZero() throws Exception {
        final  Field field = new Field();
        final Point inputPoint = new Point(-1,0);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e){}
    }
    @Test
    public void testGetFigureWhenXIsGreaterThenSize() throws Exception {
        final  Field field = new Field();
        final Point inputPoint = new Point(0,5);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e){}
    }
    @Test
    public void testGetFigureWhenYIsGreaterThenSize() throws Exception {
        final  Field field = new Field();
        final Point inputPoint = new Point(5 ,0);
        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e){}
    }
    @Test
    public void testSetFigureIntoOccupiedCell() throws Exception {
        final  Field field = new Field();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;
        final Figure newFigure = Figure.X;
        field.setFigure(inputPoint,inputFigure);
        try{
            field.setFigure(inputPoint,newFigure);
            fail();
        }catch (AlreadyOccupiedException e){}
    }
}