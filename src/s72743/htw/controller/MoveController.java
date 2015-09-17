package s72743.htw.controller;

import s72743.htw.model.*;
import s72743.htw.model.exceptions.AlreadyOccupiedException;
import s72743.htw.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {
    public boolean applyFigure(final Field field, Figure figure, Point point ){
        try {
            field.setFigure(point, figure);
        }catch(InvalidPointException e){
            System.out.print("Falsche koordinaten\n");
            return false;
        }catch (AlreadyOccupiedException e){
            System.out.print("Stelle besetzt\n");
            return false;
        }
        return true;
    }
}
