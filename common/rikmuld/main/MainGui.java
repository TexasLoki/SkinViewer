package rikmuld.main;

import java.awt.Canvas;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainGui {

	public static JFrame guiFrame = new JFrame();
	public SkinLoader panel = new SkinLoader();
	public static Canvas canvas = new Canvas();

	public void setupStartGui()
	{
		canvas.setSize(600, 600);
		canvas.setFocusable(true);
		canvas.setIgnoreRepaint(true);
		canvas.setBounds(600, 105, 600, 600);

		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("RikMuld's Skin Viewer");
		guiFrame.setSize(1200, 825);
		guiFrame.setLocationRelativeTo(null);
		guiFrame.setVisible(true);
		guiFrame.setResizable(false);
		guiFrame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width / 4, Toolkit.getDefaultToolkit().getScreenSize().height / 8);

		panel.setVisible(true);

		guiFrame.add(canvas);
		guiFrame.add(panel);
	}
}