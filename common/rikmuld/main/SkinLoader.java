package rikmuld.main;

import java.awt.Color;
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
import javax.swing.JTextField;

import rikmuld.skin2D.SkinDrawer2D;
import rikmuld.skin2D.Stats2D;
import rikmuld.skin2D.TextureLoader2D;
import rikmuld.skin3D.skin.SkinCollection;
import rikmuld.skin3D.world.Skin3DWorld;
import rikmuld.util.FileManager;
import rikmuld.util.ImageCreator;
import rikmuld.util.SkinFileRquirements;
import rikmuld.util.fileFilter.FileFilterCollection;
import rikmuld.util.fileFilter.FileFilterPng;

@SuppressWarnings("serial")
public class SkinLoader extends JPanel implements ActionListener {

	URL url;
	public String skinName = "No Skin Loaded";
	public static JFileChooser skinFileFinder = new JFileChooser();
	JButton option, img, skinLoadButton, createCollection, addColl, delColl,
	back, next, loadColl;
	SkinDrawer2D drawer = new SkinDrawer2D();
	public TextureLoader2D loader = new TextureLoader2D();
	JTextField text, skinID;
	Options options = new Options();

	public SkinLoader()
	{
		super();

		option = new JButton();
		option.setBounds(25, 25, 150, 25);
		option.setText("Options");
		option.addActionListener(this);
		img = new JButton();
		img.setBounds(25, 55, 150, 25);
		img.setText("Save 3D View");
		img.addActionListener(this);
		skinLoadButton = new JButton();
		skinLoadButton.setBounds(500, 25, 200, 30);
		skinLoadButton.setText("Load A New Skin File");
		skinLoadButton.addActionListener(this);
		text = new JTextField();
		text.setText("Or type an username!");
		text.setBounds(525, 60, 150, 20);
		text.addActionListener(this);
		createCollection = new JButton();
		createCollection.setBounds(320, 720, 200, 30);
		createCollection.setText("Create A New Collection");
		createCollection.addActionListener(this);
		loadColl = new JButton();
		loadColl.setBounds(680, 720, 200, 30);
		loadColl.setText("Load A Collection");
		loadColl.addActionListener(this);
		addColl = new JButton();
		addColl.setBounds(1000, 30, 85, 20);
		addColl.setText("Add Skin");
		addColl.addActionListener(this);
		delColl = new JButton();
		delColl.setBounds(1000, 55, 85, 20);
		delColl.setText("Del Skin");
		delColl.addActionListener(this);
		back = new JButton();
		back.setBounds(535, 720, 65, 40);
		back.setText("Back");
		back.addActionListener(this);
		next = new JButton();
		next.setBounds(600, 720, 65, 40);
		next.setText("Next");
		next.addActionListener(this);
		skinID = new JTextField();
		skinID.setText("Skin ID");
		skinID.setBounds(535, 760, 131, 20);
		skinID.addActionListener(this);

		setLayout(null);

		add(option);
		add(img);
		add(skinLoadButton);
		add(text);
		add(addColl);
		add(delColl);
		add(createCollection);
		add(back);
		add(next);
		add(skinID);
		add(loadColl);
	}

	@Override
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == skinLoadButton)
		{
			skinFileFinder.setAcceptAllFileFilterUsed(false);
			skinFileFinder.setCurrentDirectory(skinFileFinder.getFileSystemView().getDefaultDirectory());
			skinFileFinder.setFileFilter(new FileFilterPng());

			int returnVal = skinFileFinder.showOpenDialog(SkinLoader.this);
			if((returnVal == JFileChooser.APPROVE_OPTION) && SkinFileRquirements.isSkinFile(skinFileFinder.getSelectedFile()))
			{
				skinName = skinFileFinder.getSelectedFile().getName().substring(0, skinFileFinder.getSelectedFile().getName().length() - 4);
				Stats2D.view = 0;
				Stats2D.part = 0;

				loader.setSkinFile(skinFileFinder.getSelectedFile());

				Stats2D.sync = true;
				this.repaint();
			}
		}
		if(event.getSource() == text)
		{
			try
			{
				url = new URL("http://s3.amazonaws.com/MinecraftSkins/" + text.getText() + ".png");
				InputStream reader = url.openStream();
				BufferedImage img = ImageIO.read(reader);
				if(img != null)
				{
					skinName = text.getText();
					Stats2D.view = 0;
					Stats2D.part = 0;

					text.setText("Or type an username!");
					loader.setSkinFile(img);
					Stats2D.sync = true;
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			this.repaint();
		}
		if(event.getSource() == createCollection)
		{
			Skin3DWorld.skins.saveCollectionToDisk();

			skinFileFinder.setAcceptAllFileFilterUsed(false);
			skinFileFinder.setCurrentDirectory(new File(FileManager.dir));
			skinFileFinder.setFileFilter(new FileFilterCollection());

			int returnVal = skinFileFinder.showSaveDialog(SkinLoader.this);

			if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				Skin3DWorld.skins = new SkinCollection(skinFileFinder.getSelectedFile().getName(), 100);
			}

			Stats2D.sync = true;
			repaint();
		}
		if(event.getSource() == addColl)
		{
			Skin3DWorld.saveCollection();
			Skin3DWorld.skins.setSkin(Skin3DWorld.skins.getNextId(), loader.skinFile, Skin3DWorld.grassTop, Skin3DWorld.grassSide, Skin3DWorld.grassBottom, skinName);

			Stats2D.sync = true;
			repaint();
		}
		if(event.getSource() == delColl)
		{
			if(Skin3DWorld.skins.curr >= 0)
			{
				Skin3DWorld.saveCollection();
				Skin3DWorld.skins.skins[Skin3DWorld.skins.curr] = null;

				Stats2D.sync = true;
				repaint();
			}
		}
		if(event.getSource() == next)
		{
			if((Skin3DWorld.skins.curr < 100) && (Skin3DWorld.skins.skins[Skin3DWorld.skins.curr + 1] != null))
			{
				Skin3DWorld.skins.curr++;
				loader.setSkinFile(Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].skinFile);
				skinName = Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].name;
			}
			else if((Skin3DWorld.skins.curr < 100) && (Skin3DWorld.skins.skins[Skin3DWorld.skins.curr + 1] == null))
			{
				Skin3DWorld.skins.curr++;
				loader.skinFile = null;
				Stats2D.view = 0;
				Stats2D.part = 0;
				skinName = "No Skin Loaded";
			}

			if(Skin3DWorld.skins.skins[Skin3DWorld.skins.curr] != null)
			{
				options.panel.reload();
			}
			repaint();
		}
		if(event.getSource() == back)
		{
			if((Skin3DWorld.skins.curr > 0) && (Skin3DWorld.skins.skins[Skin3DWorld.skins.curr - 1] != null))
			{
				Skin3DWorld.skins.curr--;
				loader.setSkinFile(Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].skinFile);
				skinName = Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].name;
			}
			else if((Skin3DWorld.skins.curr > 0) && (Skin3DWorld.skins.skins[Skin3DWorld.skins.curr - 1] == null))
			{
				Skin3DWorld.skins.curr--;
				loader.skinFile = null;
				Stats2D.view = 0;
				Stats2D.part = 0;
				skinName = "No Skin Loaded";
			}

			if(Skin3DWorld.skins.skins[Skin3DWorld.skins.curr] != null)
			{
				options.panel.reload();
			}
			repaint();
		}
		if(event.getSource() == skinID)
		{
			if((Integer.parseInt(skinID.getText()) <= 100) && (Integer.parseInt(skinID.getText()) >= 0) && (Skin3DWorld.skins.skins[Integer.parseInt(skinID.getText())] != null))
			{
				Skin3DWorld.skins.curr = Integer.parseInt(skinID.getText());
				loader.setSkinFile(Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].skinFile);
				skinName = Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].name;
			}
			repaint();
		}
		if(event.getSource() == loadColl)
		{
			skinFileFinder.setAcceptAllFileFilterUsed(false);
			skinFileFinder.setCurrentDirectory(new File(FileManager.dir));
			skinFileFinder.setFileFilter(new FileFilterCollection());

			int returnVal = skinFileFinder.showOpenDialog(SkinLoader.this);

			if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				FileManager.requestCollection(skinFileFinder.getSelectedFile().getName().substring(0, skinFileFinder.getSelectedFile().getName().length() - 11));
			}
		}
		if(event.getSource() == img)
		{
			skinFileFinder.setAcceptAllFileFilterUsed(false);
			skinFileFinder.setCurrentDirectory(new File(FileManager.dir));
			skinFileFinder.setFileFilter(new FileFilterPng());

			int returnVal = skinFileFinder.showSaveDialog(SkinLoader.this);

			if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				ImageCreator.requestScreenshot(skinFileFinder.getSelectedFile());
			}
		}
		if(event.getSource() == option)
		{
			options.setupGui();
			if(Skin3DWorld.skins.skins[Skin3DWorld.skins.curr] != null)
			{
				options.panel.reload();
			}
		}
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g.setColor(Color.WHITE);
		g.fillRect(0, 105, 600, 600);

		g.setColor(Color.BLACK);
		g.drawRect(-1, 104, 601, 601);
		g.drawRect(599, 104, 594, 601);

		g.setFont(new Font("arial", 0, 18));

		if(loader.skinFile != null)
		{
			drawer.drawSkin(g, Stats2D.view, Stats2D.part, loader, !skinName.equals("Notch"));
		}

		if(Skin3DWorld.skins != null)
		{
			if(loader.skinFile != null)
			{
				addColl.setVisible(true);
			}
			else
			{
				addColl.setVisible(false);
			}
			if(loader.skinFile != null)
			{
				delColl.setVisible(true);
			}
			else
			{
				delColl.setVisible(false);
			}

			next.setVisible(true);
			skinID.setVisible(true);

			skinID.setText(Integer.toString(Skin3DWorld.skins.curr));
		}

		if((loader.skinFile != null) && (Skin3DWorld.skins != null) && (Skin3DWorld.skins.curr != -1) && (Skin3DWorld.skins.skins[Skin3DWorld.skins.curr] != null) && (Stats2D.sync == true))
		{
			Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].setSkinTexture(loader.skinFile);
			Skin3DWorld.skins.skins[Skin3DWorld.skins.curr].name = skinName;
			Stats2D.sync = false;
		}

		if((Skin3DWorld.skins != null) && MainGui.guiFrame.isEnabled())
		{
			Skin3DWorld.skins.saveCollectionToDisk();
		}
	}
}
