package munitz.physics;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RocketCanvas extends Canvas {
    /**
     * draws the rocket's flight path
     * @param rocket
     */
    public void draw(Rocket rocket){
        GraphicsContext context = getGraphicsContext2D();
        context.setFill(Color.CORNFLOWERBLUE);
        context.fillRect(0,0,getWidth(),getHeight());
        context.translate(0,getHeight());
        context.setFill(Color.BLACK);
        context.beginPath();
        for (double time = 0; time < rocket.getFlightTime(); time +=0.5){
            double x = rocket.getX(time);
            double y = rocket.getY(time);
            context.fillOval(x,-y,10,10);
            context.lineTo(x+5,-y+5);
            context.stroke();
        }
        context.translate(0, -getHeight());
    }
}
