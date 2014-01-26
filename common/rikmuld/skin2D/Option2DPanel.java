package rikmuld.skin2D;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import rikmuld.main.Start;

@SuppressWarnings("serial")
public class Option2DPanel extends JPanel implements ActionListener {

	JButton view1Button, view2Button, partMain, partHead, partBody, partArm, partLeg;

	public Option2DPanel()
	{
		super();

		view1Button = new JButton();
		view1Button.setBounds(20, 140, 125, 30);
		view1Button.setText("Viewpoint 1");
		view1Button.addActionListener(this);
		view2Button = new JButton();
		view2Button.setBounds(159, 140, 125, 30);
		view2Button.setText("Viewpoint 2");
		view2Button.addActionListener(this);
		partMain = new JButton();
		partMain.setBounds(40, 20, 225, 30);
		partMain.setText("Total View");
		partMain.addActionListener(this);
		partHead = new JButton();
		partHead.setBounds(52, 95, 100, 30);
		partHead.setText("Head View");
		partHead.addActionListener(this);
		partBody = new JButton();
		partBody.setBounds(52, 65, 100, 30);
		partBody.setText("Body View");
		partBody.addActionListener(this);
		partArm = new JButton();
		partArm.setBounds(152, 95, 100, 30);
		partArm.setText("Arm View");
		partArm.addActionListener(this);
		partLeg = new JButton();
		partLeg.setBounds(152, 65, 100, 30);
		partLeg.setText("Leg View");
		partLeg.addActionListener(this);
	
		setLayout(null);

		add(view1Button);
		add(view2Button);
		add(partMain);
		add(partHead);
		add(partBody);
		add(partArm);
		add(partLeg);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Start.gui.panel.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource()==view1Button)
		{
			Stats2D.view = 0;
			Stats2D.sync = true;
			this.repaint();
		}
		if(event.getSource()==view2Button)
		{
			Stats2D.view = 1;
			Stats2D.sync = true;
			this.repaint();
		}
		if(event.getSource()==partMain)
		{
			Stats2D.part = 0;
			Stats2D.sync = true;
			this.repaint();
		}
		if(event.getSource()==partHead)
		{
			Stats2D.part = 1;
			Stats2D.sync = true;
			this.repaint();
		}
		if(event.getSource()==partBody)
		{
			Stats2D.part = 2;
			Stats2D.sync = true;
			this.repaint();
		}
		if(event.getSource()==partArm)
		{
			Stats2D.part = 3;
			Stats2D.sync = true;
			this.repaint();
		}
		if(event.getSource()==partLeg)
		{
			Stats2D.part = 4;
			Stats2D.sync = true;
			this.repaint();
		}
	}
}
