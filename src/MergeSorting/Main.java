package MergeSorting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
       /* Runnable runner = new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Button Sample");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JButton button = new JButton("Select Me");
            // Define ActionListener
                ActionListener actionListener = new ActionListener() {
                    public void actionPerformed(ActionEvent actionEvent) {
                        System.out.println("I was selected.");
                    }
                };
                // Define MouseListener
                MouseListener mouseListener = new MouseAdapter() {
                    public void mousePressed(MouseEvent mouseEvent) {
                        int modifiers = mouseEvent.getModifiers();
                        if ((modifiers & InputEvent.BUTTON1_MASK) ==InputEvent.BUTTON1_MASK) {
                            System.out.println("Left button pressed.");
                        }            if ((modifiers & InputEvent.BUTTON2_MASK) ==InputEvent.BUTTON2_MASK)
                        {
                            System.out.println("Middle button pressed.");
                        }
                        if ((modifiers & InputEvent.BUTTON3_MASK) ==InputEvent.BUTTON3_MASK) {
                            System.out.println("Right button pressed.");
                        }
                    }
                    public void mouseReleased(MouseEvent mouseEvent) {
                        if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
                            System.out.println("Left button released.");
                        }
                        if (SwingUtilities.isMiddleMouseButton(mouseEvent)) {
                            System.out.println("Middle button released.");
                        }            if (SwingUtilities.isRightMouseButton(mouseEvent)) {
                            System.out.println("Right button released.");
                        }            System.out.println();
                    }
                };
                // Attach listeners
                button.addActionListener(actionListener);
                button.addMouseListener(mouseListener);
                frame.add(button, BorderLayout.SOUTH);
                frame.setSize(300, 100);
                frame.setVisible(true);
            }
        };
        EventQueue.invokeLater(runner);  } }*/
        Runnable runner = new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Button Sample");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                final JButton button1 = new JButton("Select Me");
                final JButton button2 = new JButton("No Select Me");
                final Random random = new Random();
                // Define ActionListener
                ActionListener actionListener = new ActionListener() {
                    public void actionPerformed(ActionEvent actionEvent) {
                        JButton button = (JButton)actionEvent.getSource();
                        int red = random.nextInt(255);
                        int green = random.nextInt(255);
                        int blue = random.nextInt(255);
                        button.setBackground(new Color(red,blue,green));
                    }
                };
                // Define PropertyChangeListener
                PropertyChangeListener propertyChangeListener =new PropertyChangeListener()
                {
                    public void propertyChange(PropertyChangeEvent propertyChangeEvent)
                    {
                        String property = propertyChangeEvent.getPropertyName();
                        if ("background".equals(property)) {
                            button2.setBackground((Color)propertyChangeEvent.getNewValue());
                        }
                    }
                };
                // Attach listeners
                 button1.addActionListener(actionListener);
                button1.addPropertyChangeListener(propertyChangeListener);
                 button2.addActionListener(actionListener);

                frame.add(button1, BorderLayout.NORTH);
                frame.add(button2, BorderLayout.SOUTH);
                frame.setSize(300, 100);
                frame.setVisible(true);
            }
        };
        EventQueue.invokeLater(runner);
    }
}



