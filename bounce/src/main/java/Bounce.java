import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by ScorpionOrange on 2016/11/08.
 */
public class Bounce {
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

/**
 * The frame with ball component and buttons.
 */
class BounceFrame extends JFrame{
    private BallComponent component;
    public static final int STEPS = 1000;
    public static final int DELAY = 2;

    /**
     * Constructs the frame with the component for showing the bouncing ball and Start and Close buttons.
     */
    public BounceFrame(){
        setTitle("Bounce");

        component = new BallComponent();
        add(component, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", event -> addBall());
        addButton(buttonPanel, "Close", event -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    /**
     * Adds a button to a container.
     * @param c the container
     * @param title the button title
     * @param listener the action listener for the button
     */
    public void addButton(Container c, String title, ActionListener listener){
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    /**
     * Adds a bouncing ball to the panel and makes if bounce 1000 times.
     */
    public void addBall(){
        try{
            Ball ball = new Ball();
            component.add(ball);
            for(int i = 1; i <= STEPS; i++){
                ball.move(component.getBounds());
                component.paint(component.getGraphics());
                Thread.sleep(DELAY);
            }
        }
        catch (InterruptedException e){}
    }
}
