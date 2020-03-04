package JAVA_assignment_final;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.JFrame;

import javafx.application.*;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * This class is a drawing line chart panel
 * 
 */

public class GraphicsPanel extends JFXPanel {

	static List<String> a = new ArrayList<String>();
	static List<Double> b = new ArrayList<Double>();
	XYChart.Series<String, Number> series;
	NumberAxis yAxis;
	CategoryAxis xAxis;

	public void initMyLineChart(JFXPanel jfxPanel, List<String> a, List<Double> b) {

		//set X axis & Y axis
		xAxis = new CategoryAxis();
		yAxis = new NumberAxis();
		xAxis.setLabel("Date");
		final LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);

		lineChart.setTitle("Line Chart");
		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();

		//two variables for point
		for (int i = 0; i < a.size(); i++) {
			series.getData().add(new XYChart.Data<String, Number>(a.get(i), b.get(i)));

		}
		Scene scene = new Scene(lineChart, 800, 600);
		lineChart.getData().add(series);
		jfxPanel.setScene(scene);

	}

}
