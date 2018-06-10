package app;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.ui.RefineryUtilities;

import thread.ThreadTask;

public class MyFrame extends JFrame{
	public static JLabel tempText, humidityText, innerDustText, outerDustText;
	JPanel allPanel, p1, p2, p3, p4;
	JButton tempBtn, humidityBtn, innerDustBtn, outerDustBtn;
	JLabel tempLabel,humidityLabel,innerDustLabel,outerDustLabel;

	public MyFrame() {
		setSize(400, 200);	
		
		setTitle("���ǽ� ȯ�� ���� �ý���");

		allPanel = new JPanel(new GridLayout(3,3));

		tempLabel = new JLabel("�µ�");
		
		tempText = new JLabel();
		tempText.setText("0");
		
		tempBtn = new JButton("�µ� ��ȭ");
		tempBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TempLineChart chart = new TempLineChart("�µ� ��ȭ", ThreadTask.list.get(0).getRegtime().substring(0,10)+" Temperature");
				
				chart.pack();
				RefineryUtilities.centerFrameOnScreen(chart);
				chart.setVisible(true);
				
			}
		});
		allPanel.add(tempLabel);
		allPanel.add(tempText);
		allPanel.add(tempBtn);

		humidityLabel = new JLabel("����");
		humidityText = new JLabel();
		humidityText.setText("0");
		humidityBtn = new JButton("���� ��ȭ");
		humidityBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				HumidityLineChart chart = new HumidityLineChart("���� ��ȭ", ThreadTask.list.get(0).getRegtime().substring(0,10)+" Humidity");

				chart.pack();
				RefineryUtilities.centerFrameOnScreen(chart);
				chart.setVisible(true);
				
			}
		});
		allPanel.add(humidityLabel);
		allPanel.add(humidityText);
		allPanel.add(humidityBtn);

		innerDustLabel = new JLabel("�ǳ�����");
		innerDustText = new JLabel();
		innerDustText.setText("0");
		innerDustBtn = new JButton("�ǳ� ���� ��ȭ");
		
		innerDustBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				InnerDustLineChart chart = new InnerDustLineChart("�ǳ� �̼����� ��ȭ", ThreadTask.list.get(0).getRegtime().substring(0,10)+" InnerDust");

				chart.pack();
				RefineryUtilities.centerFrameOnScreen(chart);
				chart.setVisible(true);
				
			}
		});
		allPanel.add(innerDustLabel);
		allPanel.add(innerDustText);
		allPanel.add(innerDustBtn);

		add(allPanel);
		setVisible(true);
	}
}