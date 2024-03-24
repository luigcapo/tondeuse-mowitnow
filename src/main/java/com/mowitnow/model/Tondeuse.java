package com.mowitnow.model;

public class Tondeuse {

    private int x;
    private int y;
    private Orientation orientation;


    private Pelouse pelouse;

    public Tondeuse(Pelouse pelouse){
        this.pelouse = pelouse;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        //Controle sur la valeure de y afin qu'elle reste dans la pelouse définie
        if (x < 0 || x > pelouse.getXmax()) {
            throw new IllegalArgumentException("La valeur de x est hors des limites de la pelouse");
        }
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        //Controle sur la valeure de y afin qu'elle reste dans la pelouse définie
        if (y < 0 || y > pelouse.getYmax()) {
            throw new IllegalArgumentException("La valeur de y est hors des limites de la pelouse");
        }
        this.y = y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public Pelouse getPelouse() {
        return pelouse;
    }

    public void setPelouse(Pelouse pelouse) {
        this.pelouse = pelouse;
    }


    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return x + " "+y+" "+orientation.getIdOrientation();
    }

    public void avancer(){
        switch (orientation){
            case EAST:
                x = x< pelouse.getXmax() ? x+1:x;break;
            case SOUTH:
                y = y>0 ? y-1:y;break;
            case WEST:
                x = x>0 ? x-1:x;break;
            case NORTH:
                y = y< pelouse.getYmax()? y+1:y;break;
        }
    }
}
