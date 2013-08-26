package rikmuld.skin3D.skin;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.newdawn.slick.opengl.Texture;

import rikmuld.main.Start;
import rikmuld.skin3D.world.Skin3DWorld;
import rikmuld.util.FileManager;

public class SkinCollection {

	public int curr = 0;
	String name;
	public Skin[] skins;

	int id = -1;
	BufferedImage img;
	Texture texTop;
	Texture texSide;
	String skinName;

	public SkinCollection(String name, int size)
	{
		this.name = name.replaceAll("\\s", "");
		skins = new Skin[size];
	}

	public String getName()
	{
		return name;
	}

	public void setSkin(int id, BufferedImage img, Texture texTop, Texture texSide, String name)
	{
		this.curr = id;
		this.id = id;
		this.img = img;
		this.texTop = texTop;
		this.texSide = texSide;
		this.skinName = name;
	}

	public int getNextId()
	{
		int i = 0;
		for(Skin skin : skins)
		{
			if(skin==null) return i;
			i++;
		}
		return -1;
	}

	public void updateSkins()
	{
		if(this.id!=-1)
		{
			skins[id] = new Skin(img, id, texTop, texSide, skinName, this);
			this.id = -1;
			this.img = null;
			this.texTop = null;
			this.texSide = null;
			this.skinName = "";

			this.saveCollectionToDisk();
			Start.gui.panel.sync = true;
			Start.gui.panel.repaint();
		}
	}

	public void saveCollectionToDisk()
	{
		FileManager.saveProps();

		(new File(FileManager.dir)).mkdir();
		(new File(FileManager.dir+this.name)).mkdir();

		for(File file2 : new File(FileManager.dir+this.name).listFiles())
		{
			file2.delete();
		}

		File file = new File(FileManager.dir+this.name+"/"+this.name+".collection");

		try
		{
			file.createNewFile();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.write(Integer.toString(this.skins.length));
			out.newLine();
			out.write(Integer.toString(this.curr)+"\n");
			out.newLine();

			out.write(Float.toString(Skin3DWorld.camera.vector.getX()));
			out.newLine();
			out.write(Float.toString(Skin3DWorld.camera.vector.getY()));
			out.newLine();
			out.write(Float.toString(Skin3DWorld.camera.vector.getZ()));
			out.newLine();
			out.write(Float.toString(Skin3DWorld.camera.rotation.getX()));
			out.newLine();
			out.write(Float.toString(Skin3DWorld.camera.rotation.getY()));
			out.newLine();
			out.write(Float.toString(Skin3DWorld.camera.rotation.getZ()));
			out.newLine();

			for(int i = 0; i<skins.length; i++)
			{
				if(skins[i]!=null)
				{
					out.write(skins[i].name.replaceAll("\\s", ""));
					out.newLine();
					out.write(Integer.toString(skins[i].part));
					out.newLine();
					out.write(Integer.toString(skins[i].view));
					out.newLine();
					out.write(Integer.toString(skins[i].size));
					out.newLine();

					String fileName = this.name+"/"+skins[i].name+".png";

					ImageIO.write(skins[i].skinFile, "png", (new File(FileManager.dir+fileName.replaceAll("\\s", ""))));
				}
			}

			out.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public static boolean loadCollectionFromDisk(String name)
	{
		SkinCollection collect = null;
		File file = new File(FileManager.dir+name+"/"+name+".collection");
		int skinNum = 0;
		int current = 0;
		String[] nameSkin = null;
		int[] skinView = null;
		int[] skinPart = null;
		int[] skinSize = null;
		Skin[] skin = null;

		if(file.exists())
		{
			try
			{
				Scanner scanner = new Scanner(new FileReader(file));

				skinNum = Integer.parseInt(scanner.next());
				current = Integer.parseInt(scanner.next());

				nameSkin = new String[skinNum];
				skinView = new int[skinNum];
				skinPart = new int[skinNum];
				skinSize = new int[skinNum];

				Skin3DWorld.camera.vector.x = Float.parseFloat(scanner.next());
				Skin3DWorld.camera.vector.y = Float.parseFloat(scanner.next());
				Skin3DWorld.camera.vector.z = Float.parseFloat(scanner.next());
				Skin3DWorld.camera.rotation.x = Float.parseFloat(scanner.next());
				Skin3DWorld.camera.rotation.y = Float.parseFloat(scanner.next());
				Skin3DWorld.camera.rotation.z = Float.parseFloat(scanner.next());

				Skin3DWorld.camera.setVector[0] = true;
				Skin3DWorld.camera.setVector[1] = true;

				for(int j = 0; j<skinNum; j++)
				{
					if(scanner.hasNext())
					{
						nameSkin[j] = scanner.next();
						skinPart[j] = Integer.parseInt(scanner.next());
						skinView[j] = Integer.parseInt(scanner.next());
						skinSize[j] = Integer.parseInt(scanner.next());
					}
				}
				scanner.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}

			try
			{
				collect = new SkinCollection(name, (skinNum==0) ? 1 : 100);

				skin = new Skin[skinNum];

				for(int i = 0; i<skinNum; i++)
				{
					if(nameSkin[i]!=null)
					{
						BufferedImage skinFile = ImageIO.read((new File(FileManager.dir+name+"/"+nameSkin[i]+".png")));
						int view = skinView[i];
						int part = skinPart[i];
						int size = skinSize[i];
						String nameS = nameSkin[i];

						skin[i] = new Skin(skinFile, i, Skin3DWorld.grassTop, Skin3DWorld.grassSide, nameS, collect);
						skin[i].view = view;
						skin[i].part = part;
						skin[i].size = size;
					}
				}

				collect.skins = skin;
				Skin3DWorld.skins = collect;
				Skin3DWorld.skins.curr = current;
				collect.saveCollectionToDisk();

				return true;
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}
}
