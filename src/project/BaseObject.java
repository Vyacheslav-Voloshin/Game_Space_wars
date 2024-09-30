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

    private double x; //координата по довжині
    private double y; //координата по висоті
    private double radius; // розмір нашого космічного обєкту

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
}

