package s72743.htw.controller;

import s72743.htw.model.Field;
import s72743.htw.model.Figure;
import s72743.htw.model.exceptions.InvalidPointException;

import java.awt.*;

/**
 * Created by warik on 16.09.15.
 */
public class WinnerController {
    public Figure getWinner(Field field){

            try {
                //updown lines
                for(int x = 0; x < 3; x++) {
                    if (field.getFigure(new Point(x, 0)) == null) break;
                    if (field.getFigure(new Point(x, 0)) == field.getFigure(new Point(x, 1))
                            && field.getFigure(new Point(x, 1)) == field.getFigure(new Point(x, 2)))
                        return field.getFigure(new Point(x, 0));
                }
                //---lines
                for(int y = 0; y < 3; y++) {
                    if (field.getFigure(new Point(0, y)) == null) break;
                    if (field.getFigure(new Point(0, y)) == field.getFigure(new Point(1, y))
                            && field.getFigure(new Point(1, y)) == field.getFigure(new Point(2, y)))
                        return field.getFigure(new Point(0, y));
                }
                //diagonal 1 \
                if (field.getFigure(new Point(0, 0)) == null) break;
                if (field.getFigure(new Point(0, 0)) == field.getFigure(new Point(1, 1))
                        && field.getFigure(new Point(1, 1)) == field.getFigure(new Point(2, 2)))
                    return field.getFigure(new Point(0, 0));

                //diagonal 2 /
                if (field.getFigure(new Point(0, 2)) == null) break;
                if (field.getFigure(new Point(0, 2)) == field.getFigure(new Point(1, 1))
                        && field.getFigure(new Point(1, 1)) == field.getFigure(new Point(2, 0)))
                    return field.getFigure(new Point(0, 2));

            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
    }
}
