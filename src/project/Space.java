package project;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Space {
    //Ширина та висота ігрового поля
    private int width;
    private int height;

    //Космічний корабель
    private SpaceShip ship;
    //Список НЛО
    private List<Ufo> ufos = new ArrayList<Ufo>();
    //Список бомб
    private List<Bomb> bombs = new ArrayList<Bomb>();
    //Список ракет
    private List<Rocket> rockets = new ArrayList<Rocket>();

    public Space(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Основний цикл програми.
     * Тут відбуваються всі важливі дії
     */
    public void run() {
        //Створюємо полотно для відмальовування.
        Canvas canvas = new Canvas(width, height);

 //Створюємо об 'єкт "спостерігач за клавіатурою" і стартуємо його.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //Гра працює, поки корабель живий
        while (ship.isAlive()) {
            //"спостерігач" містить події про натискання клавіш?
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();
                //Якщо "стрілка вліво" - зрушити фігурку вліво
                System.out.print(event.getKeyCode());
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    ship.moveLeft();
                    //Якщо "стрілка вправо" - зрушити фігурку вправо
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    ship.moveRight();
                    //Якщо "пробіл" - стріляємо
                else if (event.getKeyCode() == KeyEvent.VK_SPACE)
                    ship.fire();
            }

            // рухаємо всі об'єкти гри
            moveAllItems();

            //перевіряємо зіткнення
            checkBombs();
            checkRockets();
            //видаляємо померлі об'єкти зі списків
            removeDead();

            //Створюємо НЛО (1 раз на 10 ходів)
            createUfo();

            //Отрисовуємо всі об'єкти на полотно, а полотно виводимо на екран
            canvas.clear();
            draw(canvas);
            canvas.print();

            //Пауза 300 мілісекунд
            Space.sleep(300);
        }

        //Виводимо повідомлення "Game Over"
        System.out.println("Game Over!");
    }

    /**
     * Рухаємо всі об'єкти гри
     */
    public void moveAllItems() {
        for (BaseObject object : getAllItems()) {
            object.move();
        }
    }

    /**
     * Метод повертає загальний список, який містить усі об'єкти гри
     */
    public List<BaseObject> getAllItems() {
        ArrayList<BaseObject> list = new ArrayList<BaseObject>(ufos);
        list.add(ship);
        list.addAll(bombs);
        list.addAll(rockets);
        return list;
    }

    /**
     * Створюємо новий НЛО. 1 раз на 10 дзвінків.
     */
    public void createUfo() {
        if (ufos.size() > 0) return;

        int random10 = (int) (Math.random() * 10);
        if (random10 == 0) {
            double x = Math.random() * width;
            double y = Math.random() * height / 2;
            ufos.add(new Ufo(x, y));
        }
    }

    /**
     * Перевіряємо бомби.
     * а) зіткнення з кораблем (бомба та корабель вмирають)
     * б) падіння нижче краю ігрового поля (бомба вмирає)
     */
    public void checkBombs() {
        for (Bomb bomb : bombs) {
            if (ship.isIntersect(bomb)) {
                ship.die();
                bomb.die();
            }

            if (bomb.getY() >= height)
                bomb.die();
        }
    }

    /**
     * Перевіряємо рокети.
     * а) зіткнення з НЛО (ракета та НЛО вмирають)
     * б) виліт вище краю ігрового поля (ракета вмирає)
     */
    public void checkRockets() {
        for (Rocket rocket : rockets) {
            for (Ufo ufo : ufos) {
                if (ufo.isIntersect(rocket)) {
                    ufo.die();
                    rocket.die();
                }
            }

            if (rocket.getY() <= 0)
                rocket.die();
        }
    }

    /**
     * Видаляємо померлі об'єкти (бомби, ракети, НЛО) зі списків
     */
    public void removeDead() {
        for (BaseObject object : new ArrayList<BaseObject>(bombs)) {
            if (!object.isAlive())
                bombs.remove(object);
        }

        for (BaseObject object : new ArrayList<BaseObject>(rockets)) {
            if (!object.isAlive())
                rockets.remove(object);
        }

        for (BaseObject object : new ArrayList<BaseObject>(ufos)) {
            if (!object.isAlive())
                ufos.remove(object);
        }
    }

    /**
     * Відображення всіх об'єктів гри:
     * а) заповнюємо все полотно крапками.
     * б) малюємо всі об'єкти на полотно.
     */
    public void draw(Canvas canvas) {
        //draw game
        for (int i = 0; i < width + 2; i++) {
            for (int j = 0; j < height + 2; j++) {
                canvas.setPoint(i, j, '.');
            }
        }

        for (int i = 0; i < width + 2; i++) {
            canvas.setPoint(i, 0, '-');
            canvas.setPoint(i, height + 1, '-');
        }

        for (int i = 0; i < height + 2; i++) {
            canvas.setPoint(0, i, '|');
            canvas.setPoint(width + 1, i, '|');
        }

        for (BaseObject object : getAllItems()) {
            object.draw(canvas);
        }
    }


    public SpaceShip getShip() {
        return ship;
    }

    public void setShip(SpaceShip ship) {
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

    public static Space game;

    public static void main(String[] args) throws Exception {
        game = new Space(20, 20);
        game.setShip(new SpaceShip(10, 18));
        game.run();
    }

    /**
     * Метод делает паузу длинной delay миллисекунд.
     */
    public static void sleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ignored) {
        }
    }
}
