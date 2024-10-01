package project;

public class Rocket extends BaseObject{

    public Rocket(double x, double y) {

        super(x, y, 1);
    }

    //метод реалізує переміщення ракети яка летить вгору
    @Override
    public void move(){
        y--;
    }

    // метод встановлює точку на екрані с координатами х та у в кольор "В"
    @Override
    public void draw(Canvas canvas){
        canvas.setPoint(x,y,'R');
    }
}
