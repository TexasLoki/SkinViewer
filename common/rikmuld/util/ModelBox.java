package rikmuld.util;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

public class ModelBox {

	Texture[] textures;
	int x, y, z, width, height, depth;

	public ModelBox(Texture[] textures, int x, int y, int z, int width, int height, int depth)
	{
		this.textures = textures;
		this.x = x;
		this.y = y;
		this.z = z;
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	public void draw()
	{
		GL11.glPushMatrix();

		GL11.glTranslatef(x, y, z);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		textures[1].bind();

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(width, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(width, 0, depth);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, depth);
		GL11.glEnd();

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		GL11.glTranslatef(0, -height, 0);

		textures[0].bind();

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(width, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(width, 0, depth);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, depth);
		GL11.glEnd();

		GL11.glTranslatef(0, height, 0);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		textures[2].bind();

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		GL11.glRotatef(-90, -1.0F, 0.0F, 0.0F);

		GL11.glBegin(GL11.GL_QUADS);

		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(width, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(width, 0, depth);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, depth);

		GL11.glEnd();

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		textures[3].bind();

		GL11.glTranslatef(0.0F, height, 0.0F);

		GL11.glBegin(GL11.GL_QUADS);

		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(width, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(width, 0, depth);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, depth);

		GL11.glEnd();

		GL11.glTranslatef(0.0F, -height, 0.0F);
		GL11.glRotatef(90, -1.0F, 0.0F, 0.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		textures[4].bind();

		GL11.glRotatef(-90, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(-width, 0.0F, 0.0F);

		GL11.glBegin(GL11.GL_QUADS);

		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(width, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(width, 0, depth);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, depth);

		GL11.glEnd();

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		textures[5].bind();

		GL11.glTranslatef(0.0F, height, 0.0F);

		GL11.glBegin(GL11.GL_QUADS);

		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(width, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(width, 0, width);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, width);

		GL11.glEnd();

		GL11.glTranslatef(width, -height, 0.0F);
		GL11.glRotatef(-90, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(90, 0.0F, 0.0F, 1.0F);

		GL11.glPopMatrix();
	}
}
