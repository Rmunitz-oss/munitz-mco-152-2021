package munitz.physics;
public class Rocket {
    private static final double GRAVITY  = 9.8;
    private final double velocity;
    private final double angle;

    public Rocket(double velocity, double angle) {
        this.velocity = velocity;
        this.angle = Math.toRadians(angle);
    }
    /*change methods to use these instead?
    public double getXVelocity (){
        return Math.cos(angle) * velocity;

    }
    public double getYVelocity (){
        return Math.sin(angle) * velocity;

    }
    */

    /**
     *
     * @param time in seconds
     * @return x coordinate
     */

    public double getX (double time){
        double xVelocity = Math.cos(angle) * velocity;
        return xVelocity * time;
    }

    /**
     *
     * @param time in seconds
     * @return y coordinate
     */

    public double getY (double time){
        double yVelocity = Math.sin(angle) * velocity;
        return yVelocity * time - .5 * GRAVITY * (time * time) ;
    }

    /**
     *
     * @return length of flight in seconds
     */
    public double getFlightTime (){
        double yVelocity = Math.sin(angle) * velocity;
        return yVelocity / (.5 * GRAVITY);
    }
}

/*
 * Question:
 * getFlightTime method is repetitive,
 * either create method that returns yVelocity,
 * or yVelocity attribute, calculated upon construction
 * (getters and setters?)
 * double yVelocity = getYVelocity();
 * etc.
 */