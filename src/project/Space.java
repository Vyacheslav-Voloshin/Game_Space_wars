package project;

import java.util.ArrayList;
import java.util.List;

public class Space {

    private int width; // довжина космічного простору
    private int height; // вистота космічного простору

    private SpaceShip ship; // космічний корабель

    private List<Ufo> ufos = new ArrayList<>(); // список НЛО

    private List<Rocket> rockets = new ArrayList<>(); // список ракет

    private List<Bomb> bombs = new ArrayList<>(); // список бомб

    public static Space game; // створюємо зміну game

    public Space(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public SpaceShip getShip() {
        return ship;
    }

    public List<Ufo> getUfos() {
        return ufos;
    }

    public List<Rocket> getRockets() {
        return rockets;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    public void setShip(SpaceShip ship) {
        this.ship = ship;
    }

    // данний метод керує логікой гри
    public void run(){

    }

    // данний метод відповідає за прорисовку кадру
    public void draw(){

    }

    public void  sleep (int ms){

    }

    public static void main(String[] args) {

    }
}
