public class Main {
    public static void main(String[] args) {
       Rocket rocket = new Rocket(71,35);
       double x = rocket.getX(3);
       double y = rocket.getY(3);
       double time = rocket.getFlightTime();
       System.out.println("x = " + x);
       System.out.println("y = " + y);
       System.out.println("flight time = " + time);
    }
}
