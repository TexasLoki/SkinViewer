package rikmuld.main;

import java.awt.Checkbox;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import rikmuld.skin2D.Stats2D;
import rikmuld.skin3D.Stats3D.Background;
import rikmuld.skin3D.world.Skin3DWorld;

@SuppressWarnings("serial")
public class OptionsPanel extends JPanel implements ActionListener, ItemListener {

	JButton view1Button, view2Button, partMain, partHead, partBody, partArm, partLeg;

	public Checkbox head = new Checkbox("Display Head", Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.head:true));
	public Checkbox headWear = new Checkbox("Display Headwear", Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.headWear:true));
	public Checkbox body = new Checkbox("Display Body", Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.body:true));
	public Checkbox armL = new Checkbox("Display Left Arm", Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.armL:true));
	public Checkbox armR = new Checkbox("Display Right Arm", Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.armR:true));
	public Checkbox legL = new Checkbox("Display Left Leg", Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.legL:true));
	public Checkbox legR = new Checkbox("Display Right Leg", Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.legR:true));
	public Checkbox block = new Checkbox("Display Block", Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.hasBlock:true));
	public Checkbox background = new Checkbox("Display Background", Skin3DWorld.skins==null? false:Skin3DWorld.skins.stats.background.ordinal()==0);

	public OptionsPanel()
	{
		super();

		view1Button = new JButton();
		view1Button.setBounds(20, 160, 125, 30);
		view1Button.setText("Viewpoint 1");
		view1Button.addActionListener(this);
		view2Button = new JButton();
		view2Button.setBounds(159, 160, 125, 30);
		view2Button.setText("Viewpoint 2");
		view2Button.addActionListener(this);
		partMain = new JButton();
		partMain.setBounds(40, 40, 225, 30);
		partMain.setText("Total View");
		partMain.addActionListener(this);
		partHead = new JButton();
		partHead.setBounds(52, 115, 100, 30);
		partHead.setText("Head View");
		partHead.addActionListener(this);
		partBody = new JButton();
		partBody.setBounds(52, 85, 100, 30);
		partBody.setText("Body View");
		partBody.addActionListener(this);
		partArm = new JButton();
		partArm.setBounds(152, 115, 100, 30);
		partArm.setText("Arm View");
		partArm.addActionListener(this);
		partLeg = new JButton();
		partLeg.setBounds(152, 85, 100, 30);
		partLeg.setText("Leg View");
		partLeg.addActionListener(this);
	
		head.setBounds(25, 280, 150, 25);
		headWear.setBounds(25, 305, 150, 25);
		body.setBounds(25, 330, 150, 25);
		armL.setBounds(25, 355, 150, 25);
		armR.setBounds(25, 380, 150, 25);
		legL.setBounds(25, 405, 150, 25);
		legR.setBounds(25, 430, 150, 25);
		block.setBounds(25, 455, 150, 25);
		background.setBounds(25, 225, 150, 25);

		head.addItemListener(this);
		headWear.addItemListener(this);
		body.addItemListener(this);
		armL.addItemListener(this);
		armR.addItemListener(this);
		legL.addItemListener(this);
		legR.addItemListener(this);
		block.addItemListener(this);
		background.addItemListener(this);
		
		setLayout(null);

		add(view1Button);
		add(view2Button);
		add(partMain);
		add(partHead);
		add(partBody);
		add(partArm);
		add(partLeg);
		add(head);
		add(headWear);
		add(body);
		add(armL);
		add(armR);
		add(legL);
		add(legR);
		add(block);
		add(background);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawString("2D Viewer Options", 25, 25);
		g.drawString("3D Viewer Options", 25, 215);
		g.drawString("3D Skin Specific Options", 25, 270);

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
	
	@Override
	public void itemStateChanged(ItemEvent event)
	{
		if(Skin3DWorld.skins.skins[Skin3DWorld.skins.curr]!=null)
		{
			Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.head = head.getState();
			Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.headWear = headWear.getState();
			Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.body = body.getState();
			Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.armL = armL.getState();
			Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.armR = armR.getState();
			Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.legL = legL.getState();
			Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.legR = legR.getState();
			Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.hasBlock = block.getState();
			
			Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].skinChanged();
		}
		Skin3DWorld.skins.stats.background = Background.values()[background.getState()? 0:1];
	}

	public void reload()
	{
		if(Skin3DWorld.skins.skins[Skin3DWorld.skins.curr]!=null)
		{
			head.setState(Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.head:true));
			headWear.setState(Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.headWear:true));
			body.setState(Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.body:true));
			armL.setState(Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.armL:true));
			armR.setState(Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.armR:true));
			legL.setState(Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.legL:true));
			legR.setState(Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.legR:true));
			block.setState(Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.hasBlock:true));
		}
		background.setState(Skin3DWorld.skins==null?false:Skin3DWorld.skins.stats.background.ordinal()==0);
	}
}
