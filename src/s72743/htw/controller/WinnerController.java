package s72743.htw.controller;

import s72743.htw.model.Field;
import s72743.htw.model.Figure;
import s72743.htw.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {
    public Figure getWinner(Field field){

            try {
                //updown lines
                for(int x = Field.getMinFieldvalue(); x < field.getSize(); x++) {
                    if (field.getFigure(new Point(x, 0)) == null) return null;
                    if (field.getFigure(new Point(x, 0)) == field.getFigure(new Point(x, 1))
                            && field.getFigure(new Point(x, 1)) == field.getFigure(new Point(x, 2)))
                        return field.getFigure(new Point(x, 0));
                }
                //---lines
                for(int y = Field.getMinFieldvalue(); y < field.getSize(); y++) {
                    if (field.getFigure(new Point(0, y)) == null) return null;
                    if (field.getFigure(new Point(0, y)) == field.getFigure(new Point(1, y))
                            && field.getFigure(new Point(1, y)) == field.getFigure(new Point(2, y)))
                        return field.getFigure(new Point(0, y));
                }
                //diagonal 1 \
                if (field.getFigure(new Point(0, 0)) == null) return null;
                if (field.getFigure(new Point(0, 0)) == field.getFigure(new Point(1, 1))
                        && field.getFigure(new Point(1, 1)) == field.getFigure(new Point(2, 2)))
                    return field.getFigure(new Point(0, 0));

                //diagonal 2 /
                if (field.getFigure(new Point(0, 2)) == null) return null;
                if (field.getFigure(new Point(0, 2)) == field.getFigure(new Point(1, 1))
                        && field.getFigure(new Point(1, 1)) == field.getFigure(new Point(2, 0)))
                    return field.getFigure(new Point(0, 2));

            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        return null;
    }
    private boolean check(final Field field, final Point currentPoint,final IPointGenerator pointGenerator){
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.nextPoint(currentPoint);

        try {
            currentFigure = field.getFigure(currentPoint);
            nextFigure = field.getFigure(nextPoint);
        } catch (InvalidPointException e) {
            return true;
        }

        if (currentFigure == null) return false;
        if (currentFigure != nextFigure) return false;
        return check(field, next, pointGenerator)


    }
    private interface IPointGenerator{
        Point nextPoint(final Point point);
    }
}
