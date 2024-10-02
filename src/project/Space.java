package project;

import java.awt.event.KeyEvent;
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


    // данний метод керує логікой гри
    public void run(){
        //Створюємо холст для відображення наших обєктів
        Canvas canvas = new Canvas(width, height);

        //Створюємо обєкт наглядач за клавіатурой та стартуєм його
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //Ігра працює, поки корабель жив
        while (ship.isAlive()) {
            //"наглядач" містить події про натискання клавіш?
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();
                //Якщо "стрілка вліво" - сдвинути фігурку вліво
                System.out.print(event.getKeyCode());
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    ship.moveLeft();
                    //Якщо "стрілка вправо" - сдвинути фігурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    ship.moveRight();
                    //Якщо "пробел" - стріляємо
                else if (event.getKeyCode() == KeyEvent.VK_SPACE)
                    ship.fire();
            }

            //двигаємо всі обєкти гри
            moveAllItems();

            //перевіряємо зіткнення
            checkBombs();
            checkRockets();

            //видаляємо померлі обєкти зі списків
            removeDead();

            //Створюємо НЛО (1 раз в 10 ходов)
            createUfo();

            //відрисовуємо всі обєкти на холст, а холст виводимо на экран
            canvas.clear();
            draw(canvas);
            canvas.print();

            //Пауза 300 міллісекунд
            Space.sleep(300);
        }

        //Выводим сообщение "Game Over"
        System.out.println("Game Over!");

    }

    /**
     * Рухаємо всі об'єкти гри
     */
    public void moveAllItems() {
        //Потрібно отримати список всіх ігрових об'єктів і у кожного викликати метод move().
        for (BaseObject bo:getAllItems()) {
            bo.move();
        }
    }

    /**
     * Метод повертає загальний список, який містить усі об'єкти гри
     */
    public List<BaseObject> getAllItems() {
        //Необхідно створити новий список і покласти в нього всі ігрові об'єкти.
        List<BaseObject> objectList = new ArrayList<>();
        objectList.addAll(getRockets());
        objectList.addAll(getBombs());
        objectList.addAll(getUfos());
        objectList.add(ship);
        return objectList;
    }

    /**
     * Створюємо новий НЛО. 1 раз на 10 дзвінків.
     */
    public void createUfo() {
        //Тут потрібно створити новий НЛО.
    }

    /**
     * Перевіряємо бомби.
     * а) зіткнення з кораблем (бомба та корабель вмирають)
     * б) падіння нижче краю ігрового поля (бомба вмирає)
     */
    public void checkBombs() {
        //Тут потрібно перевірити всі можливі зіткнення для кожної бомби.
    }

    /**
     * Перевіряємо рокети.
     * а) зіткнення з НЛО (ракета та НЛО вмирають)
     * б) виліт вище краю ігрового поля (ракета вмирає)
     */
    public void checkRockets() {
        //Тут потрібно перевірити всі можливі зіткнення для кожної ракети.
    }

    /**
     * Видаляємо померлі об'єкти (бомби, ракети, НЛО) зі списків
     */
    public void removeDead() {
        //Тут потрібно видалити всі померлі об'єкти зі списків (крім космічного корабля)
    }

    /**
     * Відображення всіх об'єктів гри:
     * а) заповнюємо все полотно крапками.
     * б) малюємо всі об'єкти на полотно.
     */
    public void draw(Canvas canvas) {
        //Тут потрібно відмалювати всі об'єкти гри
    }


    public SpaceShip getShip() {
        return ship;
    }

    public void setShip (SpaceShip ship) {
        this.ship = ship;
    }

    public List<Ufo> getUfos() {
        return ufos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    public List<Rocket> getRockets() {
        return rockets;
    }


    public static void main(String[] args) {
        game = new Space(20, 20);
        game.setShip(new SpaceShip(10, 18));
        game.run();
    }

    /**
     * Метод робить паузу довгою delay мілісекунд.
     */
    public static void sleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ignored) {
        }
    }
}
