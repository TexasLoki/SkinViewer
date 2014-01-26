package rikmuld.skin3D;

import java.awt.Checkbox;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;

import rikmuld.main.Start;
import rikmuld.skin3D.world.Skin3DWorld;

@SuppressWarnings("serial")
public class Option3DPanel extends JPanel implements ActionListener, ItemListener {
	
	public Checkbox head = new Checkbox("Display Head", Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.head:true));
	public Checkbox headWear = new Checkbox("Display Headwear", Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.headWear:true));
	public Checkbox body = new Checkbox("Display Body", Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.body:true));
	public Checkbox armL = new Checkbox("Display Left Arm", Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.armL:true));
	public Checkbox armR = new Checkbox("Display Right Arm", Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.armR:true));
	public Checkbox legL = new Checkbox("Display Left Leg", Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.legL:true));
	public Checkbox legR = new Checkbox("Display Right Leg", Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.legR:true));
	public Checkbox block = new Checkbox("Display Block", Skin3DWorld.skins==null?true:(Skin3DWorld.skins.skins.length>0?Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].stats.hasBlock:true));

	public Option3DPanel()
	{
		super();
						
		head.setBounds(25, 25, 150, 25);
		headWear.setBounds(25, 50, 150, 25);
		body.setBounds(25, 75, 150, 25);
		armL.setBounds(25, 100, 150, 25);
		armR.setBounds(25, 125, 150, 25);
		legL.setBounds(25, 150, 150, 25);
		legR.setBounds(25, 175, 150, 25);
		block.setBounds(25, 200, 150, 25);

		head.addItemListener(this);
		headWear.addItemListener(this);
		body.addItemListener(this);
		armL.addItemListener(this);
		armR.addItemListener(this);
		legL.addItemListener(this);
		legR.addItemListener(this);
		block.addItemListener(this);

		setLayout(null);	
 		
		add(head);
		add(headWear);
		add(body);
		add(armL);
		add(armR);
		add(legL);
		add(legR);
		add(block);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Start.gui.panel.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent event)
	{

	}

	@Override
	public void itemStateChanged(ItemEvent event)
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

	public void reload()
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
}
