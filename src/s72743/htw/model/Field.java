package s72743.htw.model;

import s72743.htw.model.exceptions.AlreadyOccupiedException;
import s72743.htw.model.exceptions.InvalidPointException;

import java.awt.*;

public class Field {

    public static final int FIELD_SIZE = 3;
    public static final int MIN_FIELDVALUE = 0;
    private Figure figure[][] = new Figure[FIELD_SIZE][FIELD_SIZE];




    public int getSize(){
        return FIELD_SIZE*FIELD_SIZE;
    }
    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) throw new InvalidPointException();
        return figure[point.y][point.x];
    }

    public void setFigure (final Point point, final Figure figure)
            throws InvalidPointException {
        if (!checkPoint(point)) throw new InvalidPointException();
        this.figure[point.y][point.x] = figure;
    }

    private boolean checkPoint(final Point point){
        return ((point.y >= MIN_FIELDVALUE && point.y < FIELD_SIZE) && (point.x >= MIN_FIELDVALUE && point.x < FIELD_SIZE) );

    }



}
