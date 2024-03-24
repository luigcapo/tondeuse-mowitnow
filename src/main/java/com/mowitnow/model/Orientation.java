package com.mowitnow.model;

public enum Orientation {
    SOUTH("S"),WEST("W"),NORTH("N"),EAST("E");

    private String idOrientation;

    Orientation(String idOrientation){
        this.idOrientation=idOrientation;
    }


    public String getIdOrientation() {
        return idOrientation;
    }

    public void setIdOrientation(String idOrientation) {
        this.idOrientation = idOrientation;
    }

    public static Orientation findOrientationFromId(String id) {
        for (Orientation orientation : Orientation.values()) {
            if (orientation.getIdOrientation().equals(id)) {
                return orientation;
            }
        }
        throw new IllegalArgumentException("Invalid ID: " + id);
    }

    public Orientation pivoterDroite(){
        return values()[(this.ordinal()+1) % values().length];
    }
    public Orientation pivoterGauche(){
        if(this.ordinal() == 0){
            return values()[values().length - 1];
        }
        else{
            return values()[(this.ordinal()-1)];
        }
    }

}
