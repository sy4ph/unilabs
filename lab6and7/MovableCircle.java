package lab6and7;

public class MovableCircle implements Movable{
    int radius;
    MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    public String toString() {
        return "x: " + this.center.x + " y: " + this.center.y + " xSpeed: " + this.center.xSpeed + " ySpeed: " + this.center.ySpeed + " radius: " + this.radius;
    }

    public void moveUp() {
        this.center.y += this.center.ySpeed;
    }

    public void moveDown() {
        this.center.y -= this.center.ySpeed;
    }

    public void moveLeft() {
        this.center.x -= this.center.xSpeed;
    }

    public void moveRight() {
        this.center.x += this.center.xSpeed;
    }

    
}
