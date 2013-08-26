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
	public int size = 3;
	Texture blockTop;
	Texture blockSide;
	public int view = 0;
	public int part = 0;
	public String name;
	SkinCollection collection;

	public float rotat = 0;
	boolean reverse = false;

	public Skin(BufferedImage img, int id, Texture texTop, Texture texSide, String name, SkinCollection collection)
	{
		loader3D = new TextureLoader3D(img);
		this.skinFile = img;
		this.id = id;
		this.blockTop = texTop;
		this.blockSide = texSide;
		this.name = name;
		this.collection = collection;
	}

	public void skinChanged()
	{
		collection.saveCollectionToDisk();
	}

	public void setSize(int size)
	{
		this.size = size;
		this.skinChanged();
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

		if(size==5)
		{
			GL11.glScalef(1.5F, 1.5F, 1.5F);
			GL11.glTranslatef(-2.75F, 0, -2.75F);
		}
		if(size==4)
		{
			GL11.glScalef(1.25F, 1.25F, 1.25F);
			GL11.glTranslatef(-1.6F, 0, -1.6F);
		}
		if(size==2)
		{
			GL11.glScalef(0.75F, 0.75F, 0.75F);
			GL11.glTranslatef(2.75F, 0, 2.75F);
		}
		if(size==1)
		{
			GL11.glScalef(0.5F, 0.5F, 0.5F);
			GL11.glTranslatef(8F, 0, 8F);
		}
		if(size==0)
		{
			GL11.glScalef(0.25F, 0.25F, 0.25F);
			GL11.glTranslatef(24F, 0, 24F);
		}

		this.drawSkin();
		GL11.glPopMatrix();

		this.drawSkinBlock();

		GL11.glTranslatef(24.0F*id, 0.0F, 0.0F);
	}

	public void setView(int view)
	{
		this.view = view;
		this.skinChanged();
	}

	public void setPart(int part)
	{
		this.part = part;
		this.skinChanged();
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
		if(part==0)
		{
			if(!reverse) rotat += 0.1F;
			else rotat -= 0.1F;

			if(rotat>10.0F) reverse = true;
			else if(rotat<-10.0F) reverse = false;

			SkinDrawer3D.drawLeftLeg(loader3D, false);
			SkinDrawer3D.drawRightLeg(loader3D, true);
			SkinDrawer3D.drawBody(loader3D, false);
			SkinDrawer3D.drawLeftArm(loader3D, false, false);
			SkinDrawer3D.drawRightArm(loader3D, true, false);
			SkinDrawer3D.drawHead(loader3D, false);
			if(!this.name.equals("Notch")) SkinDrawer3D.drawHeadWear(loader3D);
		}
		else if(part==1)
		{
			if(view==0) SkinDrawer3D.drawHead(loader3D, true);
			if(!this.name.equals("Notch")) if(view==1) SkinDrawer3D.drawHeadWear(loader3D);
		}
		else if(part==2)
		{
			SkinDrawer3D.drawBody(loader3D, true);
		}
		else if(part==3)
		{
			if(view==0) SkinDrawer3D.drawLeftArm(loader3D, false, true);
			if(view==1) SkinDrawer3D.drawRightArm(loader3D, true, true);
		}
		else if(part==4)
		{
			if(view==0) SkinDrawer3D.drawLeftLeg(loader3D, false);
			if(view==1) SkinDrawer3D.drawRightLeg(loader3D, true);
		}
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

		blockSide.bind();

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
