public class Sector {
    double x;
    double y;
    int pointValue;
    boolean clicked;
    String topic;

    public Sector(double x, double y) {
        this.x = x;
        this.y = y;
        pointValue = 0;
        clicked = false;
        topic = "";
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

    public int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
}