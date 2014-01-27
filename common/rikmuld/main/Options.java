package rikmuld.main;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class Options {
	
	public JFrame guiFrame = new JFrame();
	public OptionsPanel panel = new OptionsPanel();

	public void setupGui()
	{
		guiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		guiFrame.setTitle("Options");
		guiFrame.setSize(310, 600);
		guiFrame.setLocationRelativeTo(null);
		guiFrame.setVisible(true);
		guiFrame.setResizable(false);
		guiFrame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/12, Toolkit.getDefaultToolkit().getScreenSize().height/8);

		panel.setVisible(true);

		guiFrame.add(panel);
	}
}
