package ru.tronin.math;

public class Key {
    private int code;
    private boolean isPressed;

    public void pressKey(int code){
        this.code = code;
        this.isPressed = true;
    }

    public void releaseKey(){
        this.isPressed = false;
    }

    public int getCode() {
        return code;
    }

    public boolean isPressed() {
        return isPressed;
    }
}
