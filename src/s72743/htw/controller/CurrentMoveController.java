package s72743.htw.controller;


import s72743.htw.model.Field;
import s72743.htw.model.Figure;
import s72743.htw.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {
    public static Figure currentMove(Field field){
        int countX=0;
        int countO=0;
        try {
            for(int y = 0 ;  y< field.getSize(); y++){
                for(int x = 0 ; x < field.getSize(); x++){
                   if(field.getFigure(new Point(x,y)) == Figure.X ) countX++;
                    if(field.getFigure(new Point(x,y)) == Figure.O ) countO++;
                }
            }
        } catch (InvalidPointException e) {
                        e.printStackTrace();
                    }
        if (countX+countO==0) return null;
        if(countX+countO == field.getSize()*field.getSize()) return null;
        return (countX>countO)? Figure.O: Figure.X;
    }
}
