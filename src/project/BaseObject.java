package project;

/*
����  ���������� �� ��������� ����� �����

��-�����. ��� ��������, �������� �� ��'���� � ��� � ������ ��������.
ͳ, �������� �� ������ ���������, �� � �����.
� ��� ��� ����������� ����� �����䳿 �������� � ����, �� ���� �����.
��� � �������� �������.

��-�����. ����� ���������� ��'���� �� ����� ������ �������� �������.
�� ������� �������� ����� �� ������� ��� �����������.
� ��� �������� �� �� �������������.
 */
public abstract class BaseObject {

    protected double x; //���������� �� ������
    protected double y; //���������� �� �����
    protected double radius; // ����� ������ ��������� �����

    private boolean isAlive; // ���� ��� ������ ���� �����(����� �� �)

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // ����� ���������� �����
    public  void draw(){

    }

    // ����� ���������� �����
    public  void move(){

    }

    // ���� ������
    public void die(){
        isAlive=false;
    }


    // ����� ����������� - "����������" ��'���� �� �. ���� ����������� - ��������� true, ���� � - false.
    /*
    ����  ���������� �� ��������� ����� ������:
       �.�. ��'���� �� ������ ������� ������, �� �������� ���� ������� �����䳿:
       ���� ����� ���� ������ ��'���� �������� � ���� ������, �� �����������, �� ���� ���������.
    ��� �� �������:
        ���������_��_��'������ < max (�����_�������_��'����, �����_�������_��'����).
     */
    public boolean isIntersect(BaseObject o){
        double dx = x - o.x;
        double dy = y - o.y;
        double distance = Math.sqrt(dx * dx + dy * dy);
        double max = Math.max(radius, o.radius);
        return distance <= max;
    }

    /**
     * ���������� - �� �� �������� �� (x,y) �� �������.
     */
    public void checkBorders(double minx, double maxx, double miny, double maxy) {
        if (x < minx) x = minx;
        if (x > maxx) x = maxx;
        if (y < miny) y = miny;
        if (y > maxy) y = maxy;
    }
}

