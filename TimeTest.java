import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * TimeTest class is the main class for the Elapsed Timer application.
 * This class creates a simple Swing GUI with two buttons to track the time elapsed
 * between "Start" and "Stop". The difference in milliseconds is displayed
 * in a pop-up message box.
 * @author ELYSE NIYONAGIRA
 * @since java version "21.0.4"
 */
public class TimeTest {

    // Declaring the variables for the start and finish times
    private long startTime;
    private long finishTime;
    private boolean isRunning; // Flag to track if the timer is running

    /**
     * Constructor for the TimeTest class.
     * This method sets up the GUI components and action listeners for the buttons.
     */
    public TimeTest() {
        // Creating the frame for the GUI of the user
        JFrame frame = new JFrame("Elapsed Timer");
        frame.setSize(500, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating the panel to hold buttons in a flow
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Creating the "Start" and "Stop" buttons
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");

        // Adding action listener for the "Start" button
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Start the timer if it is not already running
                if (!isRunning) {
                    startTime = System.currentTimeMillis();
                    isRunning = true; // Set the flag to true
                    JOptionPane.showMessageDialog(frame, "Timer started at: " + startTime + " milliseconds.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Timer is already running.");
                }
            }
        });

        // Adding action listener for the "Stop" button
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Only allow stopping if the timer is running
                if (isRunning) {
                    finishTime = System.currentTimeMillis();

                    // Calculating the elapsed time in milliseconds from the start and finish time
                    long elapsedTime = finishTime - startTime;

                    // Display the elapsed time in a pop-up dialog
                    JOptionPane.showMessageDialog(frame, "Elapsed time: " + elapsedTime + " milliseconds.");
                    isRunning = false; // Resetting the flag
                } else {
                    JOptionPane.showMessageDialog(frame, "Timer is not running. Please start the timer first.");
                }
            }
        });

        // Adding the buttons to the panel
        panel.add(startButton);
        panel.add(stopButton);

        // Adding the panel to the frame
        frame.add(panel);

        // Setting the frame visible
        frame.setVisible(true);
    }

}