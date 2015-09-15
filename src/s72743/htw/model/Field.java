package s72743.htw.model;

import java.awt.*;

public class Field {

    public static final int FIELD_SIZE = 3;
    private Figure figure[][] = new Figure[FIELD_SIZE][FIELD_SIZE];




    public int getSize(){
        return FIELD_SIZE*FIELD_SIZE;
    }
    public Figure getFigure(final Point point) {
        return figure[point.y][point.x];
    }

    public void setFigure (final Point point, final Figure figure) {
        if((point.y < 0 || point.y > 2) || (point.x < 0 || point.x > 2) )
           return;
        this.figure[point.y][point.x] = figure;
    }




}
