package project;

public class Ufo extends BaseObject {
    //картинка НЛО для отрисовки
    private static int[][] matrix = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 0, 1, 0, 1},
            {1, 1, 1, 1, 1},
    };

    public Ufo(double x, double y) {

        super(x, y, 3);
    }

    //// метод встановлює точку на екрані с координатами х та у в кольор "U"
    @Override
    public void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y - radius + 1, matrix, 'U');
    }

    /*
    Метод move() треба зробити так:
а) UFO переміщається випадковою траєкторією  (не забудь про перевірку кордонів);
б) UFO не опускається у нижню половину екрана;
y <= height/2
в) З ймовірністю 10% UFO повинен стріляти – викликати метод fire.
     */
    @Override
    public void move() {
        double dx = Math.random() * 2 - 1;
        double dy = Math.random() * 2 - 1;

        x += dx;
        y += dy;

        checkBorders(radius, Space.game.getWidth() - radius + 1, radius - 1, Space.game.getHeight() / 2 - 1);
        double rundomFire =  Math.random()*100;
        if (rundomFire<=10){
            fire();
        }
    }

    //цей метод викликається коли НЛО скидає бомбу
    public void fire(){
        Space.game.getBombs().add(new Bomb(x, y+3));
    }
}
