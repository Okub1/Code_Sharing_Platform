class Circle implements Measurable{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }


    @Override
    public double area() {
        return this.radius * this.radius * Math.PI;
    }
}

// do not change the interface
interface Measurable {
    double area();
}