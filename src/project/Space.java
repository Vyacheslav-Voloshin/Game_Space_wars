package project;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Space {

    private int width; // ������� ��������� ��������
    private int height; // ������� ��������� ��������

    private SpaceShip ship; // �������� ��������

    private List<Ufo> ufos = new ArrayList<>(); // ������ ���

    private List<Rocket> rockets = new ArrayList<>(); // ������ �����

    private List<Bomb> bombs = new ArrayList<>(); // ������ ����

    public static Space game; // ��������� ���� game

    public Space(int width, int height) {
        this.width = width;
        this.height = height;
    }


    // ������ ����� ���� ������ ���
    public void run(){
        //��������� ����� ��� ����������� ����� �����
        Canvas canvas = new Canvas(width, height);

        //��������� ���� �������� �� ���������� �� ������� ����
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //���� ������, ���� �������� ���
        while (ship.isAlive()) {
            //"��������" ������ ��䳿 ��� ���������� �����?
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();
                //���� "������ ����" - �������� ������� ����
                System.out.print(event.getKeyCode());
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    ship.moveLeft();
                    //���� "������ ������" - �������� ������� ������
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    ship.moveRight();
                    //���� "������" - ��������
                else if (event.getKeyCode() == KeyEvent.VK_SPACE)
                    ship.fire();
            }

            //������� �� ����� ���
            moveAllItems();

            //���������� ��������
            checkBombs();
            checkRockets();

            //��������� ������ ����� � ������
            removeDead();

            //��������� ��� (1 ��� � 10 �����)
            createUfo();

            //���������� �� ����� �� �����, � ����� �������� �� �����
            canvas.clear();
            draw(canvas);
            canvas.print();

            //����� 300 ���������
            Space.sleep(300);
        }

        //������� ��������� "Game Over"
        System.out.println("Game Over!");

    }

    /**
     * ������ �� ��'���� ���
     */
    public void moveAllItems() {
        //������� �������� ������ ��� ������� ��'���� � � ������� ��������� ����� move().
        for (BaseObject bo:getAllItems()) {
            bo.move();
        }
    }

    /**
     * ����� ������� ��������� ������, ���� ������ �� ��'���� ���
     */
    public List<BaseObject> getAllItems() {
        //��������� �������� ����� ������ � �������� � ����� �� ����� ��'����.
        List<BaseObject> objectList = new ArrayList<>();
        objectList.addAll(getRockets());
        objectList.addAll(getBombs());
        objectList.addAll(getUfos());
        objectList.add(ship);
        return objectList;
    }

    /**
     * ��������� ����� ���. 1 ��� �� 10 ������.
     */
    public void createUfo() {
        //��� ������� �������� ����� ���.
    }

    /**
     * ���������� �����.
     * �) �������� � �������� (����� �� �������� ��������)
     * �) ������ ����� ���� �������� ���� (����� �����)
     */
    public void checkBombs() {
        //��� ������� ��������� �� ������ �������� ��� ����� �����.
    }

    /**
     * ���������� ������.
     * �) �������� � ��� (������ �� ��� ��������)
     * �) ���� ���� ���� �������� ���� (������ �����)
     */
    public void checkRockets() {
        //��� ������� ��������� �� ������ �������� ��� ����� ������.
    }

    /**
     * ��������� ������ ��'���� (�����, ������, ���) � ������
     */
    public void removeDead() {
        //��� ������� �������� �� ������ ��'���� � ������ (��� ��������� �������)
    }

    /**
     * ³���������� ��� ��'���� ���:
     * �) ���������� ��� ������� ��������.
     * �) ������� �� ��'���� �� �������.
     */
    public void draw(Canvas canvas) {
        //��� ������� ���������� �� ��'���� ���
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
     * ����� ������ ����� ������ delay ��������.
     */
    public static void sleep(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ignored) {
        }
    }
}
