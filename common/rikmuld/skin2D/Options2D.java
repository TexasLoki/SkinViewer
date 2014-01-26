package rikmuld.skin2D;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class Options2D {
	
	public JFrame guiFrame = new JFrame();
	public Option2DPanel panel = new Option2DPanel();

	public void setupGui()
	{
		guiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		guiFrame.setTitle("2D Options");
		guiFrame.setSize(310, 225);
		guiFrame.setLocationRelativeTo(null);
		guiFrame.setVisible(true);
		guiFrame.setResizable(false);
		guiFrame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/12, Toolkit.getDefaultToolkit().getScreenSize().height/3+60);

		panel.setVisible(true);

		guiFrame.add(panel);
	}
}
