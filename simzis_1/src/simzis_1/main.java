package simzis_1;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class main {

	public static void main(String[] args) {
        int maxPasswordLength = 20;  // Maximum length of the password
        XYSeries series = new XYSeries("Average Time vs. Password Length");

        for (int i = 1; i <= maxPasswordLength; i++) {
            String password = PasswordGenerator.generateRandomString(i);
            System.out.println(password);
            double avgTime = PasswordGenerator.calculateAverageTime(password);
            series.add(i, avgTime);
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Average Time vs. Password Length",
                "Password Length",
                "Average Time (seconds)",
                dataset
        );

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Password Cracking Analysis");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.add(new ChartPanel(chart), BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

}
