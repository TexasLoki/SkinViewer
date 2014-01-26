package rikmuld.skin3D;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class Options3D {
	
	public JFrame guiFrame = new JFrame();
	public Option3DPanel panel = new Option3DPanel();

	public void setupGui()
	{
		guiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		guiFrame.setTitle("3D Options");
		guiFrame.setSize(310, 275);
		guiFrame.setLocationRelativeTo(null);
		guiFrame.setVisible(true);
		guiFrame.setResizable(false);
		guiFrame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/12, Toolkit.getDefaultToolkit().getScreenSize().height/8);

		panel.setVisible(true);

		guiFrame.add(panel);
	}
}
