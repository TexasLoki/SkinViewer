package rikmuld.skin3D.skin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import rikmuld.skin3D.SkinDrawer3D;
import rikmuld.skin3D.TextureLoader3D;
import rikmuld.util.ModelBox;

public class Skin {

	TextureLoader3D loader3D;
	public BufferedImage skinFile;
	int id;
	public String name;
	SkinCollection collection;
	public SkinStats stats = new SkinStats();
	ModelBox block;
	
	public Skin(BufferedImage img, int id, Texture texTop, Texture texSide, Texture texBottom, String name, SkinCollection collection)
	{
		loader3D = new TextureLoader3D(img);
		this.skinFile = img;
		this.id = id;
		this.name = name;
		this.collection = collection;
		this.block = new ModelBox(new Texture[]{texBottom, texTop, texSide, texSide, texSide, texSide}, 0, 0, 0, 16, 16, 16);
	}

	public void skinChanged()
	{
		collection.saveCollectionToDisk();
	}

	public void renderUpdate()
	{
		if(loader3D==null||loader3D.skinFile!=this.skinFile)
		{
			loader3D = new TextureLoader3D(skinFile);
			this.skinChanged();
		}

		GL11.glTranslatef(-24.0F*id, 0.0F, 0.0F);

		GL11.glPushMatrix();

		this.drawSkin();
		GL11.glPopMatrix();

		if(stats.hasBlock)this.block.draw();

		GL11.glTranslatef(24.0F*id, 0.0F, 0.0F);
	}

	public void setSkinTexture(BufferedImage img)
	{
		this.skinFile = img;
		this.skinChanged();
	}

	public void setSkinTexture(File file)
	{
		try
		{
			this.skinFile = ImageIO.read(file);
			this.skinChanged();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public void drawSkin()
	{
		if(stats.head)SkinDrawer3D.drawHead(loader3D, true);
		if(stats.headWear&&!this.name.equals("Notch")) SkinDrawer3D.drawHeadWear(loader3D);
		if(stats.body)SkinDrawer3D.drawBody(loader3D, true);
		if(stats.armL)SkinDrawer3D.drawLeftArm(loader3D, false, true);
		if(stats.armR)SkinDrawer3D.drawRightArm(loader3D, true, true);
		if(stats.legL)SkinDrawer3D.drawLeftLeg(loader3D, false);
		if(stats.legR)SkinDrawer3D.drawRightLeg(loader3D, true);
	}
}
