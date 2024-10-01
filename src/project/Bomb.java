package project;

public class Bomb extends BaseObject{
    public Bomb(double x, double y) {

        super(x, y, 1);
    }

    //метод реалізує падіння бомби вниз
    public void move(){
        y++;
    }

    // метод встановлює точку с координатами х та у в кольор "В"
    public void draw(Canvas canvas){
        canvas.setPoint(x,y,'B');
    }
}
