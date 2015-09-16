package s72743.htw.model;

import s72743.htw.model.exceptions.AlreadyOccupiedException;
import s72743.htw.model.exceptions.InvalidPointException;

import java.awt.*;

public class Field {




    public static final int MIN_FIELDVALUE = 0;

    private final int fieldSize;
    private final Figure figure[][];

    public Field(int fieldSize) {
        this.fieldSize = fieldSize;
        figure = new Figure[fieldSize][fieldSize];
    }


    public int getSize(){
        return fieldSize;
    }

    public static int getMinFieldvalue() {
        return MIN_FIELDVALUE;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) throw new InvalidPointException();
        return figure[point.y][point.x];
    }

    public void setFigure (final Point point, final Figure figure)
            throws InvalidPointException,
                    AlreadyOccupiedException {
        if (!checkPoint(point)) throw new InvalidPointException();
        if(this.figure[point.y][point.x] != null) throw new AlreadyOccupiedException();
        this.figure[point.y][point.x] = figure;
    }

    private boolean checkPoint(final Point point){
        return ((point.y >= MIN_FIELDVALUE && point.y < fieldSize) && (point.x >= MIN_FIELDVALUE && point.x < fieldSize) );

    }



}
