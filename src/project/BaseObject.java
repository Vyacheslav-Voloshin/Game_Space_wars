package project;

/*
Деякі  пропозиції по реалізації цього класу

По-перше. Для простоти, рахувати всі об'єкти у нас у космосі круглими.
Ні, малювати їх будемо фігурними, як і раніше.
А ось при розрахунках їхньої взаємодії виходити з того, що вони круглі.
Так – набагато простіше.

По-друге. Нехай координати об'єктів та радіус будуть речовими числами.
Це додасть плавність рухам та точність усім обчисленням.
А при малюванні ми їх округлятимемо.
 */
public abstract class BaseObject {

    protected double x; //координата по довжині
    protected double y; //координата по висоті
    protected double radius; // розмір нашого космічного обєкту

    private boolean isAlive; // зміна яка зберігає стан обєкту(живий чи ні)

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

    // метод прорисовки обєкту
    public  void draw(){

    }

    // метод переміщення обєкту
    public  void move(){

    }

    // обєкт помирає
    public void die(){
        isAlive=false;
    }


    // метод визначатиме - "пересіклися" об'єкти чи ні. Якщо перетнулися - повертати true, якщо ні - false.
    /*
    Деякі  пропозиції по реалізації цього методу:
       Т.к. об'єкти ми умовно вважаємо колами, то пропоную таку формулу взаємодії:
       Якщо центр кола одного об'єкта потрапив у коло іншого, то вважатимемо, що вони зіткнулися.
    Або ще простіше:
        дистанція_між_об'єктами < max (радіус_першого_об'єкта, радіус_другого_об'єкта).
     */
    public boolean isIntersect(BaseObject o){
        double dx = x - o.x;
        double dy = y - o.y;
        double distance = Math.sqrt(dx * dx + dy * dy);
        double max = Math.max(radius, o.radius);
        return distance <= max;
    }

    /**
     * Перевіряємо - чи не виходить ли (x,y) за кордони.
     */
    public void checkBorders(double minx, double maxx, double miny, double maxy) {
        if (x < minx) x = minx;
        if (x > maxx) x = maxx;
        if (y < miny) y = miny;
        if (y > maxy) y = maxy;
    }
}

