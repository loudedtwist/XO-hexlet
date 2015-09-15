package s72743.htw.model;

import org.junit.Test;

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
}