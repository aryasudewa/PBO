import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clock {
    private ClockDisplay clockDisplay;
    private JLabel timeLabel;

    public Clock() {
        clockDisplay = new ClockDisplay();
        clockDisplay.setTime(12, 0, 0);

        JFrame frame = new JFrame("Clock");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        timeLabel = new JLabel(clockDisplay.getTime(), JLabel.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 40));
        frame.add(timeLabel, BorderLayout.CENTER);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clockDisplay.timeTick();
                timeLabel.setText(clockDisplay.getTime());
            }
        });
        timer.start();

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Clock();
    }
}