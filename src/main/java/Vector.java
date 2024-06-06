public class Vector {
    private double x,y;

    /**
     *Default constructor for Vector
     */
    public Vector() {
        x = 0;
        y = 0;
    }

    /**
     * Constructor for Vector with x and y values
     * @param x x value
     * @param y y value
     */
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor for Vector
     */
    public Vector(Vector other) {
        if (other == null) {
            throw new IllegalArgumentException("Other Vector cannot be null");
        }
        this.x = other.x;
        this.y = other.y;
    }

    //Getter for x and y values
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    //Setter for x and y values
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }

    /**
     * @return sqrt(x^(2)+y^(2))
     */
    public double getMagnitude() {
     /*
     Falls sqrt(0) nicht erlaubt:
        if (x == 0 && y == 0)
         throw new IllegalArgumentException ("x and y cannot be 0");
         */
        return Math.sqrt((Math.pow((x),2)) + (Math.pow((y),2)));
    }

    /**
     *gets calculated through X/magnitude and Y/magnitude
     *  @return the calculated Vector as an new Instance
     */
    public Vector asNormalized() {
        if (getMagnitude() == 0) {
            throw new IllegalStateException ("Length is 0");
        }
        return new Vector(getX()/getMagnitude(),getY()/getMagnitude());
    }

    /**
     *adds coordinates of other vector to this instance
     * @param v other vector
     */
    public void add(Vector v) {
        this.x += v.x;
        this.y += v.y;
    }

    public Vector fromPolar(double angle, double magnitude) {
        if (magnitude < 0) {
            throw new IllegalArgumentException("Invalid magnitude");
        }
        if (angle < 0 || angle > 2*Math.PI) {
            throw new IllegalArgumentException("Invalid angle");
        }
        return new Vector(magnitude*Math.cos(angle),magnitude*Math.sin(angle));
    }
}