package project;

    /*
    Для складності зробимо так: якщо користувач натиснув кнопку вліво,
    корабель починає весь час рухатися вліво.
    Якщо натиснути кнопку праворуч - весь час праворуч до упору.
    Тому заведемо спеціальну змінну dx, яка зберігатиме напрямок руху корабля.
    якщо dx = 1, корабель кожен хід йде на 1 праворуч,
    якщо dx = -1, корабель кожен хід йде на 1 ліворуч.
     */
    public class SpaceShip extends BaseObject{
        private double dx = 0;
        public SpaceShip(double x, double y) {

            super(x, y, 3);
        }

        // метод переміщуе корабель ліворуч
        public void moveLeft(){
            dx = -1;
        }

        // метод переміщуе корабель праворуч
        public void moveRight(){
            dx = 1;
        }

        // метод встановлює точку на екрані с координатами х та у в кольор "В"
        @Override
        public void draw(Canvas canvas) {

        }
        //метод переміщує корабель та перевіряє чи не виліз він за кордони космосу
        @Override
        public void move() {
            x+=dx;
            checkBorders(0,Space.game.getWidth(),0,Space.game.getHeight() );
        }

        //цей метод викликається коли необхідно здійснити постріл, корабель стріляє двома ракетами одночасно
        public void fire(){
            Rocket rocketLeft = new Rocket(x-2,y);
            Rocket rocketRight = new Rocket(x+2,y);
            Space.game.getRockets().add(rocketLeft);
            Space.game.getRockets().add(rocketRight);
        }
}
