package rikmuld.skin3D.skin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import rikmuld.skin3D.SkinDrawer3D;
import rikmuld.skin3D.TextureLoader3D;

public class Skin {

	TextureLoader3D loader3D;
	public BufferedImage skinFile;
	int id;
	Texture blockTop;
	Texture blockSide;
	Texture blockBottom;
	public String name;
	SkinCollection collection;
	public SkinStats stats = new SkinStats();
	
	public Skin(BufferedImage img, int id, Texture texTop, Texture texSide, Texture texBottom, String name, SkinCollection collection)
	{
		loader3D = new TextureLoader3D(img);
		this.skinFile = img;
		this.id = id;
		this.blockTop = texTop;
		this.blockSide = texSide;
		this.blockBottom = texBottom;
		this.name = name;
		this.collection = collection;
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

		if(stats.hasBlock)this.drawSkinBlock();

		GL11.glTranslatef(24.0F*id, 0.0F, 0.0F);
	}

	public void setBlockTextures(Texture texTop, Texture texSide)
	{
		this.blockTop = texTop;
		this.blockSide = texSide;
		this.skinChanged();
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

	public void drawSkinBlock()
	{
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		blockTop.bind();

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(16, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(16, 0, 16);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, 16);
		GL11.glEnd();

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		GL11.glTranslatef(0, -16, 0);
		
		blockBottom.bind();

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(16, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(16, 0, 16);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, 16);
		GL11.glEnd();
		
		GL11.glTranslatef(0, 16, 0);
		
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		blockSide.bind();

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		GL11.glRotatef(-90, -1.0F, 0.0F, 0.0F);

		GL11.glBegin(GL11.GL_QUADS);

		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(16, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(16, 0, 16);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, 16);

		GL11.glEnd();

		GL11.glTranslatef(0.0F, 16.0F, 0.0F);

		GL11.glBegin(GL11.GL_QUADS);

		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(16, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(16, 0, 16);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, 16);

		GL11.glEnd();

		GL11.glTranslatef(0.0F, -16.0F, 0.0F);
		GL11.glRotatef(90, -1.0F, 0.0F, 0.0F);

		GL11.glRotatef(-90, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(-16.0F, 0.0F, 0.0F);

		GL11.glBegin(GL11.GL_QUADS);

		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(16, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(16, 0, 16);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, 16);

		GL11.glEnd();

		GL11.glTranslatef(0.0F, 16.0F, 0.0F);

		GL11.glBegin(GL11.GL_QUADS);

		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(16, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(16, 0, 16);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, 16);

		GL11.glEnd();

		GL11.glTranslatef(16.0F, -16.0F, 0.0F);
		GL11.glRotatef(-90, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(90, 0.0F, 0.0F, 1.0F);

	}
}
