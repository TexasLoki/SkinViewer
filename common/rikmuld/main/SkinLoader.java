package rikmuld.main;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import rikmuld.skin2D.SkinDrawer2D;
import rikmuld.skin2D.TextureLoader2D;
import rikmuld.skin3D.skin.SkinCollection;
import rikmuld.skin3D.world.Skin3DWorld;
import rikmuld.util.FileManager;
import rikmuld.util.SkinFileRquirements;
import rikmuld.util.fileFilter.FileFilterCollection;
import rikmuld.util.fileFilter.FileFilterPng;

@SuppressWarnings("serial")
public class SkinLoader extends JPanel implements ActionListener, ChangeListener{
	
	URL url;
	public String skinName = "No Skin Loaded";
	public static JFileChooser skinFileFinder = new JFileChooser();
	JButton skinLoadButton, view1Button, view2Button, partMain, partHead, partBody, partArm, partLeg, createCollection, addColl, delColl, back, next, defaultColl, loadColl;
    SkinDrawer2D drawer = new SkinDrawer2D();
    public TextureLoader2D loader = new TextureLoader2D();
    public int view = 0;
    public int part = 0;
    JTextField text, collectionName, skinID;
	public boolean sync = false;
	public JSlider size;
	public int skinSize;

	public SkinLoader()
	{
		super();
		
		 skinLoadButton = new JButton();	
	     skinLoadButton.setBounds(25, 25, 200, 30);      
	     skinLoadButton.setText("Load A New Skin File");	       
	     skinLoadButton.addActionListener(this);
	     text = new JTextField();
	     text.setText("Or type an username!");
	     text.setBounds(50, 60, 150, 20);  
	     text.addActionListener(this);
	     view1Button = new JButton();	
	     view1Button.setBounds(263, 550, 100, 30);      
	     view1Button.setText("View 1");	       
	     view1Button.addActionListener(this);
	     view2Button = new JButton();	
	     view2Button.setBounds(388, 550, 100, 30);      
	     view2Button.setText("View 2");	       
	     view2Button.addActionListener(this);
	     partMain = new JButton();	
	     partMain.setBounds(287, 62, 175, 30);      
	     partMain.setText("Total View");	       
	     partMain.addActionListener(this);
	     partHead = new JButton();	
	     partHead.setBounds(35, 250, 100, 30);      
	     partHead.setText("Head View");	       
	     partHead.addActionListener(this);
	     partBody = new JButton();	
	     partBody.setBounds(35, 300, 100, 30);      
	     partBody.setText("Body View");	       
	     partBody.addActionListener(this);
	     partArm = new JButton();	
	     partArm.setBounds(615, 250, 100, 30);      
	     partArm.setText("Arm View");	       
	     partArm.addActionListener(this);
	     partLeg = new JButton();	
	     partLeg.setBounds(615, 300, 100, 30);      
	     partLeg.setText("Leg View");	       
	     partLeg.addActionListener(this);
	     createCollection = new JButton();	
	     createCollection.setBounds(25, 625, 200, 30);      
	     createCollection.setText("Create A New Collection");	       
	     createCollection.addActionListener(this);
	     loadColl = new JButton();	
	     loadColl.setBounds(25, 685, 200, 30);      
	     loadColl.setText("Load A Collection");	       
	     loadColl.addActionListener(this);
	     addColl = new JButton();	
	     addColl.setBounds(632, 100, 85, 20);      
	     addColl.setText("Add Skin");	       
	     addColl.addActionListener(this);
	     delColl = new JButton();	
	     delColl.setBounds(632, 125, 85, 20);      
	     delColl.setText("Del Skin");	       
	     delColl.addActionListener(this);
	     collectionName = new JTextField();
	     collectionName.setText("Collection Name");
	     collectionName.setBounds(50, 660, 150, 20);  
	     collectionName.addActionListener(this);
	     back = new JButton();	
	     back.setBounds(585, 625, 65, 40);      
	     back.setText("Back");	       
	     back.addActionListener(this);
	     next = new JButton();	
	     next.setBounds(650, 625, 65, 40); 
	     next.setText("Next");	       
	     next.addActionListener(this);
	     skinID = new JTextField();
	     skinID.setText("Skin ID");
	     skinID.setBounds(585, 665, 130, 20);  
	     skinID.addActionListener(this);
	     defaultColl = new JButton();	
	     defaultColl.setBounds(277, 675, 200, 30); 
	     defaultColl.setText("Change To Default Collection");	       
	     defaultColl.addActionListener(this);
	     size = new JSlider();
	     size.setBounds(287, 590, 175, 19);
	     size.setMinimum(0);
	     size.setMaximum(5);
	     size.addChangeListener(this);
	     setLayout(null);   
	     
	     add(skinLoadButton);
	     add(view1Button);
	     add(view2Button);
	     add(partMain);
	     add(partHead);
	     add(partBody);
	     add(partArm);
	     add(partLeg);
		 add(text);
		 add(addColl);
		 add(delColl);
		 add(createCollection);
		 add(collectionName);
		 add(back);
		 add(next);
		 add(skinID);
		 add(defaultColl);
		 add(loadColl);
		 add(size);
	}
	
	public void paintComponent(Graphics g) 
	{
         super.paintComponent(g);
         g.setFont(new Font("arial", 0, 18));
		 
		 if(skinName.length()>20)
		 {
			 skinName = skinName.substring(0, 20) + "...";
		 }
		 
         g.drawString("Current Skin: "+skinName, 250, 47);         

         if(loader.skinFile!=null)
         {
             drawer.drawSkin(g, view, part, loader, !this.skinName.equals("Notch"));
         }
         
         if(Skin3DWorld.skins!=null&&Skin3DWorld.skins.getName().equals("default"))
         {
        	 addColl.setVisible(false);
        	 delColl.setVisible(false);
          	 back.setVisible(false);
        	 next.setVisible(false);
        	 skinID.setVisible(false);
        	 defaultColl.setVisible(false);
        	 
    	     createCollection.setBounds(80, 644, 200, 30);      
    	     collectionName.setBounds(300, 650, 150, 20); 
    	     loadColl.setBounds(470, 644, 200, 30);      
         }
         else if(Skin3DWorld.skins!=null)
         {
        	 if(loader.skinFile!=null)addColl.setVisible(true);
        	 else addColl.setVisible(false);
        	 if(loader.skinFile!=null)delColl.setVisible(true);
        	 else delColl.setVisible(false);
        	 back.setVisible(true);
        	 next.setVisible(true);
        	 skinID.setVisible(true);
        	 defaultColl.setVisible(true);
        	 
        	 g.drawString("Current Collection: "+Skin3DWorld.skins.getName(), 250, 647);
        	 
             g.setFont(new Font("arial", 0, 14));
        	 g.drawString("Curr ID: "+Skin3DWorld.skins.curr, 615, 705);
             g.setFont(new Font("arial", 0, 18));
             
    	     createCollection.setBounds(25, 625, 200, 30);      
    	     collectionName.setBounds(50, 660, 150, 20);  
    	     loadColl.setBounds(25, 685, 200, 30);      
         }
         
         if(this.loader.skinFile!=null&&Skin3DWorld.skins!=null&&Skin3DWorld.skins.getName().equals("default")&&sync == true)
	     {
	        if(Skin3DWorld.skins.curr == -1)Skin3DWorld.skins.setSkin(0, loader.skinFile, Skin3DWorld.grassTop, Skin3DWorld.grassSide, skinName);
			else
			{
				Skin3DWorld.skins.skins[0].setSkinTexture(loader.skinFile);
				Skin3DWorld.skins.skins[0].name = skinName;			
				Skin3DWorld.skins.skins[0].setPart(part);
				Skin3DWorld.skins.skins[0].setView(view);
				Skin3DWorld.skins.skins[0].setSize(skinSize);

				sync = false;
			}
	     }
         if(this.loader.skinFile!=null&&Skin3DWorld.skins!=null&&Skin3DWorld.skins.curr!=-1&&Skin3DWorld.skins.skins[Skin3DWorld.skins.curr]!=null&&sync == true)
         {
        	 Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].setSkinTexture(loader.skinFile);
			 Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].name = skinName;			
			 Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].setPart(part);
			 Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].setView(view);
			 Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].setSize(skinSize);			
			 sync = false;
         }
    }
	
	@Override
	public void actionPerformed(ActionEvent event) 
	{
		if (event.getSource() == skinLoadButton)
		{
			skinFileFinder.setAcceptAllFileFilterUsed(false);
			skinFileFinder.setCurrentDirectory(skinFileFinder.getFileSystemView().getDefaultDirectory());
			skinFileFinder.setFileFilter(new FileFilterPng());
			
			int returnVal = skinFileFinder.showOpenDialog(SkinLoader.this);	
			if (returnVal == JFileChooser.APPROVE_OPTION&&SkinFileRquirements.isSkinFile(skinFileFinder.getSelectedFile()))
			{
				skinName = skinFileFinder.getSelectedFile().getName().substring(0, skinFileFinder.getSelectedFile().getName().length()-4);
				this.view = 0;
				this.part = 0;
				size.setValue(3);
				
				loader.setSkinFile(skinFileFinder.getSelectedFile());
				
				sync = true;
				this.repaint();
			}	
		} 
		if (event.getSource() == view1Button)
		{
			this.view = 0;
			sync = true;
			this.repaint();
		} 
		if (event.getSource() == view2Button)
		{
			this.view = 1;
			sync = true;
			this.repaint();
		} 
		if (event.getSource() == partMain)
		{
			this.part = 0;
			sync = true;
			this.repaint();
		} 
		if (event.getSource() == partHead)
		{
			this.part = 1;
			sync = true;
			this.repaint();
		} 
		if (event.getSource() == partBody)
		{
			this.part = 2;
			sync = true;
			this.repaint();
		} 
		if (event.getSource() == partArm)
		{
			this.part = 3;
			sync = true;
			this.repaint();
		} 
		if (event.getSource() == partLeg)
		{
			this.part = 4;
			sync = true;
			this.repaint();
		} 
		if (event.getSource() == text)
		{
			try 
			{
				url = new URL("http://s3.amazonaws.com/MinecraftSkins/"+text.getText()+".png");			
				InputStream reader = url.openStream();
				BufferedImage img = ImageIO.read(reader);
				if(img != null)
				{
					this.skinName = text.getText();
					this.view = 0;
					this.part = 0;
					size.setValue(3);

					text.setText("Or type an username!");
					loader.setSkinFile(img);
					sync = true;
				}
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			this.repaint();
		} 		
		if (event.getSource() == createCollection)
		{
			if(!collectionName.getText().replaceAll("\\s","").isEmpty())
			{
				SkinCollection collect = new SkinCollection(this.collectionName.getText(), 100);
				Skin3DWorld.saveCollection();
				Skin3DWorld.skins = collect;
				
				sync = true;
				repaint();
			}
		}
		if (event.getSource() == addColl)
		{
			Skin3DWorld.saveCollection();
			Skin3DWorld.skins.setSkin(Skin3DWorld.skins.getNextId(), loader.skinFile, Skin3DWorld.grassTop, Skin3DWorld.grassSide, skinName);
			
			sync = true;
			repaint();
		} 
		if (event.getSource() == delColl)
		{
			if(Skin3DWorld.skins.curr>=0)
			{
				Skin3DWorld.saveCollection();
				Skin3DWorld.skins.skins[Skin3DWorld.skins.curr] = null;
				Skin3DWorld.skins.curr--;
				
				sync = true;
				repaint();
			}
		}
		if (event.getSource() == next)
		{
			if(Skin3DWorld.skins.curr<100&&Skin3DWorld.skins.skins[Skin3DWorld.skins.curr+1]!=null)
			{
				Skin3DWorld.skins.curr++;		
				this.loader.setSkinFile(Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].skinFile);
				this.view = Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].view;
				this.part = Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].part;
				this.skinName = Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].name;
				this.size.setValue(Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].size);
			}
			else if(Skin3DWorld.skins.curr<100&&Skin3DWorld.skins.skins[Skin3DWorld.skins.curr+1]==null)
			{
				Skin3DWorld.skins.curr++;		
				this.loader.skinFile = null;
				this.view = 0;
				this.part = 0;
				this.skinName = "No Skin Loaded";
				this.size.setValue(3);
			}
			
			repaint();
		} 
		if (event.getSource() == back)
		{
			if(Skin3DWorld.skins.curr>0&&Skin3DWorld.skins.skins[Skin3DWorld.skins.curr-1]!=null)
			{
				Skin3DWorld.skins.curr--;
				this.loader.setSkinFile(Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].skinFile);
				this.view = Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].view;
				this.part = Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].part;
				this.skinName = Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].name;
				this.size.setValue(Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].size);
			}
			else if(Skin3DWorld.skins.curr>0&&Skin3DWorld.skins.skins[Skin3DWorld.skins.curr-1]==null)
			{
				Skin3DWorld.skins.curr--;		
				this.loader.skinFile = null;
				this.view = 0;
				this.part = 0;
				this.skinName = "No Skin Loaded";
				this.size.setValue(3);
			}
			repaint();
		}
		if (event.getSource() == skinID)
		{
			if(Integer.parseInt(skinID.getText())<=100&&Integer.parseInt(skinID.getText())>=0&&Skin3DWorld.skins.skins[Integer.parseInt(skinID.getText())]!=null)
			{
				Skin3DWorld.skins.curr = Integer.parseInt(skinID.getText());
				this.loader.setSkinFile(Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].skinFile);
				this.view = Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].view;
				this.part = Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].part;
				this.skinName = Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].name;
			}
			repaint();
		}
		if (event.getSource() == defaultColl)
		{
			Skin3DWorld.requestDefaultCollection();
			repaint();
		}
		if (event.getSource() == loadColl)
		{
			skinFileFinder.setAcceptAllFileFilterUsed(false);
			skinFileFinder.setCurrentDirectory(new File(FileManager.dir));
			skinFileFinder.setFileFilter(new FileFilterCollection());
			
			int returnVal = skinFileFinder.showOpenDialog(SkinLoader.this);
						
			if (returnVal == JFileChooser.APPROVE_OPTION)
			{
				FileManager.requestCollection(skinFileFinder.getSelectedFile().getName().substring(0, skinFileFinder.getSelectedFile().getName().length()-11));
			}	
		} 
	}

	@Override
	public void stateChanged(ChangeEvent event) 
	{
		if(event.getSource() == size)
		{
			this.skinSize = size.getValue();
			this.sync = true;
			this.repaint();
		}
	}
}
