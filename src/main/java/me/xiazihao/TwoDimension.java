package me.xiazihao;

abstract class TwoDimension {
    private double x = 1f;
    private double y = 1f;

    public TwoDimension(double x, double y) {
        this.x = x;
        this.y = y;
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

    @Override
    public String toString() {
        return "TwoDimension{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
