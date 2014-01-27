package rikmuld.skin3D;

import org.lwjgl.opengl.GL11;

public class SkinDrawer3D {
	
	public static void drawLeftLeg(TextureLoader3D loader, boolean flipped)
	{
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.leg3D[0].bind();

		GL11.glTranslatef(12.0F, 12F, 10.0F);
		GL11.glRotatef(270, -1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-90, 0.0F, 0.0F, 1.0F);

		if(flipped)
		{
			GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(-4.0F, 0F, 0F);
		}

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(4, 0, 0);

		GL11.glTexCoord2f(1, 0.75F);
		GL11.glVertex3f(4, 0, 12);

		GL11.glTexCoord2f(0, 0.75F);
		GL11.glVertex3f(0, 0, 12);

		GL11.glEnd();

		if(flipped)
		{
			GL11.glTranslatef(4.0F, 0F, 0F);
			GL11.glRotatef(-180, 0.0F, 0.0F, 1.0F);
		}

		GL11.glRotatef(90, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-270, -1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(-12.0F, -12F, -10.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.leg3D[3].bind();

		GL11.glTranslatef(8.0F, 12F, 6.0F);
		GL11.glRotatef(270, -1.0F, 0.0F, 0.0F);
		GL11.glRotatef(90, 0.0F, 0.0F, 1.0F);

		if(flipped)
		{
			GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(-4.0F, 0F, 0F);
		}

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(4, 0, 0);

		GL11.glTexCoord2f(1, 0.75F);
		GL11.glVertex3f(4, 0, 12);

		GL11.glTexCoord2f(0, 0.75F);
		GL11.glVertex3f(0, 0, 12);

		GL11.glEnd();

		if(flipped)
		{
			GL11.glTranslatef(4.0F, 0F, 0F);
			GL11.glRotatef(-180, 0.0F, 0.0F, 1.0F);
		}

		GL11.glRotatef(-90, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-270, -1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(-8.0F, -12F, -6.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.leg3D[1].bind();

		GL11.glTranslatef(12.0F, 12F, 6.0F);
		GL11.glRotatef(270, -1.0F, 0.0F, 0.0F);
		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);

		if(flipped)
		{
			GL11.glTranslatef(0.0F, -4F, 0F);
		}

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(4, 0, 0);

		GL11.glTexCoord2f(1, 0.75F);
		GL11.glVertex3f(4, 0, 12);

		GL11.glTexCoord2f(0, 0.75F);
		GL11.glVertex3f(0, 0, 12);

		GL11.glEnd();

		if(flipped)
		{
			GL11.glTranslatef(0.0F, 4F, 0F);
		}

		GL11.glRotatef(-180, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-270, -1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(-12.0F, -12F, -6.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.leg3D[2].bind();

		GL11.glTranslatef(8.0F, 12F, 10.0F);
		GL11.glRotatef(270, -1.0F, 0.0F, 0.0F);

		if(flipped)
		{
			GL11.glTranslatef(0.0F, -4F, 0F);
		}

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(4, 0, 0);

		GL11.glTexCoord2f(1, 0.75F);
		GL11.glVertex3f(4, 0, 12);

		GL11.glTexCoord2f(0, 0.75F);
		GL11.glVertex3f(0, 0, 12);

		GL11.glEnd();

		if(flipped)
		{
			GL11.glTranslatef(0.0F, 4F, 0F);
		}

		GL11.glRotatef(-270, -1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(-8.0F, -12F, -10.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.leg3D[5].bind();

		GL11.glTranslatef(12.0F, 0.05F, 6.0F);
		GL11.glRotatef(-180, 0.0F, 0.0F, 1.0F);

		if(flipped)
		{
			GL11.glTranslatef(0.0F, 0F, 4.0F);
			GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
		}

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(4, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(4, 0, 4);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, 4);

		GL11.glEnd();

		if(flipped)
		{
			GL11.glRotatef(-180, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0.0F, 0F, -4.0F);
		}

		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(-12.0F, -0.05F, -6.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.leg3D[4].bind();

		GL11.glTranslatef(12.0F, 12F, 6.0F);
		GL11.glRotatef(-180, 0.0F, 0.0F, 1.0F);

		if(flipped)
		{
			GL11.glTranslatef(0.0F, 0F, 4.0F);
			GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
		}

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(4, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(4, 0, 4);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, 4);

		GL11.glEnd();

		if(flipped)
		{
			GL11.glRotatef(-180, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0.0F, 0F, -4.0F);
		}

		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(-12.0F, -12F, -6.0F);
	}

	public static void drawRightLeg(TextureLoader3D loader, boolean flipped)
	{
		GL11.glRotatef(-180, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(-16.0F, 0, -16.0F);

		drawLeftLeg(loader, flipped);

		GL11.glTranslatef(16.0F, 0, 16.0F);
		GL11.glRotatef(-180, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
	}

	public static void drawBody(TextureLoader3D loader, boolean solo)
	{
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.body3D[0].bind();

		GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(12.0F, 6.0F, -24.0F);
		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(8, 0, 0);

		GL11.glTexCoord2f(1, 0.75F);
		GL11.glVertex3f(8, 0, 12);

		GL11.glTexCoord2f(0, 0.75F);
		GL11.glVertex3f(0, 0, 12);

		GL11.glEnd();

		GL11.glRotatef(-180, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(-12.0F, -6.0F, 24.0F);
		GL11.glRotatef(-90, 1.0F, 0.0F, 0.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.body3D[3].bind();

		GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(4.0F, 10.0F, -24.0F);

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(8, 0, 0);

		GL11.glTexCoord2f(1, 0.75F);
		GL11.glVertex3f(8, 0, 12);

		GL11.glTexCoord2f(0, 0.75F);
		GL11.glVertex3f(0, 0, 12);

		GL11.glEnd();

		GL11.glTranslatef(-4.0F, -10.0F, 24.0F);
		GL11.glRotatef(-90, 1.0F, 0.0F, 0.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.body3D[1].bind();

		GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(90, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(6.0F, -4.0F, -24.0F);

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(4, 0, 0);

		GL11.glTexCoord2f(1, 0.75F);
		GL11.glVertex3f(4, 0, 12);

		GL11.glTexCoord2f(0, 0.75F);
		GL11.glVertex3f(0, 0, 12);

		GL11.glEnd();

		GL11.glTranslatef(-6.0F, 4.0F, 24.0F);
		GL11.glRotatef(-90, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-90, 1.0F, 0.0F, 0.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.body3D[2].bind();

		GL11.glRotatef(-180, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(90, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(-10.0F, 12.0F, -24.0F);

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(4, 0, 0);

		GL11.glTexCoord2f(1, 0.75F);
		GL11.glVertex3f(4, 0, 12);

		GL11.glTexCoord2f(0, 0.75F);
		GL11.glVertex3f(0, 0, 12);

		GL11.glEnd();

		GL11.glTranslatef(10.0F, -12.0F, 24.0F);
		GL11.glRotatef(-90, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-90, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(180, 0.0F, 1.0F, 0.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.body3D[4].bind();

		GL11.glTranslatef(12.0F, 24.0F, 10.0F);
		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(8, 0, 0);

		GL11.glTexCoord2f(1, 0.75F);
		GL11.glVertex3f(8, 0, 4);

		GL11.glTexCoord2f(0, 0.75F);
		GL11.glVertex3f(0, 0, 4);

		GL11.glEnd();

		GL11.glRotatef(-180, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-180, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(-12.0F, -24.0F, -10.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.body3D[5].bind();

		if(!solo) GL11.glTranslatef(12.0F, 12.02F, 10.0F);
		else if(solo) GL11.glTranslatef(12.0F, 12F, 10.0F);
		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(8, 0, 0);

		GL11.glTexCoord2f(1, 0.75F);
		GL11.glVertex3f(8, 0, 4);

		GL11.glTexCoord2f(0, 0.75F);
		GL11.glVertex3f(0, 0, 4);

		GL11.glEnd();

		GL11.glRotatef(-180, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-180, 0.0F, 0.0F, 1.0F);
		if(!solo) GL11.glTranslatef(-12.0F, -12.02F, -10.0F);
		else if(solo) GL11.glTranslatef(-12.0F, -12F, -10.0F);
	}

	public static void drawLeftArm(TextureLoader3D loader, boolean flipped, boolean solo)
	{
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.arm3D[0].bind();

		if(!flipped) GL11.glTranslatef(4.0F, 0F, 0.0F);

		GL11.glTranslatef(12.0F, 24F, 10.0F);
		GL11.glRotatef(270, -1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-90, 0.0F, 0.0F, 1.0F);

		if(flipped)
		{
			GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(-4.0F, 0F, 0F);
		}

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(4, 0, 0);

		GL11.glTexCoord2f(1, 0.75F);
		GL11.glVertex3f(4, 0, 12);

		GL11.glTexCoord2f(0, 0.75F);
		GL11.glVertex3f(0, 0, 12);

		GL11.glEnd();

		if(flipped)
		{
			GL11.glTranslatef(4.0F, 0F, 0F);
			GL11.glRotatef(-180, 0.0F, 0.0F, 1.0F);
		}

		GL11.glRotatef(90, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-270, -1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(-12.0F, -24F, -10.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.arm3D[3].bind();

		GL11.glTranslatef(8.0F, 24F, 6.0F);
		GL11.glRotatef(270, -1.0F, 0.0F, 0.0F);
		GL11.glRotatef(90, 0.0F, 0.0F, 1.0F);

		if(flipped)
		{
			GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
			GL11.glTranslatef(-4.0F, 0F, 0F);
		}

		if(!solo&&flipped) GL11.glTranslatef(0F, 0.05F, 0F);
		else if(!solo) GL11.glTranslatef(0F, -0.05F, 0F);

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(4, 0, 0);

		GL11.glTexCoord2f(1, 0.75F);
		GL11.glVertex3f(4, 0, 12);

		GL11.glTexCoord2f(0, 0.75F);
		GL11.glVertex3f(0, 0, 12);

		GL11.glEnd();

		if(!solo&&flipped) GL11.glTranslatef(0F, -0.05F, 0F);
		else if(!solo) GL11.glTranslatef(0F, 0.05F, 0F);

		if(flipped)
		{
			GL11.glTranslatef(4.0F, 0F, 0F);
			GL11.glRotatef(-180, 0.0F, 0.0F, 1.0F);
		}

		GL11.glRotatef(-90, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-270, -1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(-8.0F, -24F, -6.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.arm3D[1].bind();

		GL11.glTranslatef(12.0F, 24F, 6.0F);
		GL11.glRotatef(270, -1.0F, 0.0F, 0.0F);
		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);

		if(flipped)
		{
			GL11.glTranslatef(0.0F, -4F, 0F);
		}

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(4, 0, 0);

		GL11.glTexCoord2f(1, 0.75F);
		GL11.glVertex3f(4, 0, 12);

		GL11.glTexCoord2f(0, 0.75F);
		GL11.glVertex3f(0, 0, 12);

		GL11.glEnd();

		if(flipped)
		{
			GL11.glTranslatef(0.0F, 4F, 0F);
		}

		GL11.glRotatef(-180, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-270, -1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(-12.0F, -24F, -6.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.arm3D[2].bind();

		GL11.glTranslatef(8.0F, 24F, 10.0F);
		GL11.glRotatef(270, -1.0F, 0.0F, 0.0F);

		if(flipped)
		{
			GL11.glTranslatef(0.0F, -4F, 0F);
		}

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(4, 0, 0);

		GL11.glTexCoord2f(1, 0.75F);
		GL11.glVertex3f(4, 0, 12);

		GL11.glTexCoord2f(0, 0.75F);
		GL11.glVertex3f(0, 0, 12);

		GL11.glEnd();

		if(flipped)
		{
			GL11.glTranslatef(0.0F, 4F, 0F);
		}

		GL11.glRotatef(-270, -1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(-8.0F, -24F, -10.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.arm3D[5].bind();

		GL11.glTranslatef(12.0F, 12F, 6.0F);
		GL11.glRotatef(-180, 0.0F, 0.0F, 1.0F);

		if(flipped)
		{
			GL11.glTranslatef(0.0F, 0F, 4.0F);
			GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
		}

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(4, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(4, 0, 4);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, 4);

		GL11.glEnd();

		if(flipped)
		{
			GL11.glRotatef(-180, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0.0F, 0F, -4.0F);
		}

		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(-12.0F, -12F, -6.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.arm3D[4].bind();

		GL11.glTranslatef(12.0F, 24F, 6.0F);
		GL11.glRotatef(-180, 0.0F, 0.0F, 1.0F);

		if(flipped)
		{
			GL11.glTranslatef(0.0F, 0F, 4.0F);
			GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
		}

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(4, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(4, 0, 4);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, 4);

		GL11.glEnd();

		if(flipped)
		{
			GL11.glRotatef(-180, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0.0F, 0F, -4.0F);
		}

		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(-12.0F, -24F, -6.0F);

		if(!flipped) GL11.glTranslatef(-4.0F, 0F, 0.0F);
	}

	public static void drawRightArm(TextureLoader3D loader, boolean flipped, boolean solo)
	{
		GL11.glRotatef(-180, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(-16.0F, 0, -16.0F);
		GL11.glTranslatef(4.0F, 0F, 0.0F);

		drawLeftArm(loader, flipped, solo);

		GL11.glTranslatef(-4.0F, 0F, 0.0F);
		GL11.glTranslatef(16.0F, 0, 16.0F);
		GL11.glRotatef(-180, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
	}

	public static void drawHead(TextureLoader3D loader, boolean solo)
	{
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.head3D[0].bind();

		GL11.glTranslatef(0F, 8F, 2F);

		GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(12.0F, 2.0F, -24.0F);
		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(8, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(8, 0, 8);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, 8);

		GL11.glEnd();

		GL11.glRotatef(-180, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(-12.0F, -2.0F, 24.0F);
		GL11.glRotatef(-90, 1.0F, 0.0F, 0.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.head3D[3].bind();

		GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(4.0F, 10.0F, -24.0F);

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(8, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(8, 0, 8);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, 8);

		GL11.glEnd();

		GL11.glTranslatef(-4.0F, -10.0F, 24.0F);
		GL11.glRotatef(-90, 1.0F, 0.0F, 0.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.head3D[2].bind();

		GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(90, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(2.0F, -4.0F, -24.0F);

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(8, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(8, 0, 8);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, 8);

		GL11.glEnd();

		GL11.glTranslatef(-2.0F, 4.0F, 24.0F);
		GL11.glRotatef(-90, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-90, 1.0F, 0.0F, 0.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.head3D[1].bind();

		GL11.glRotatef(-180, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(90, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(-10.0F, 12.0F, -24.0F);

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(8, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(8, 0, 8);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, 8);

		GL11.glEnd();

		GL11.glTranslatef(10.0F, -12.0F, 24.0F);
		GL11.glRotatef(-90, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-90, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(180, 0.0F, 1.0F, 0.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.head3D[4].bind();

		GL11.glTranslatef(12.0F, 24.0F, 10.0F);
		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(8, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(8, 0, 8);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, 8);

		GL11.glEnd();

		GL11.glRotatef(-180, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-180, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(-12.0F, -24.0F, -10.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.head3D[5].bind();

		if(!solo) GL11.glTranslatef(12.0F, 16.02F, 10.0F);
		else if(solo) GL11.glTranslatef(12.0F, 16F, 10.0F);
		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(8, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(8, 0, 8);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, 8);

		GL11.glEnd();

		GL11.glRotatef(-180, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-180, 0.0F, 0.0F, 1.0F);
		if(!solo) GL11.glTranslatef(-12.0F, -16.02F, -10.0F);
		else if(solo) GL11.glTranslatef(-12.0F, -16F, -10.0F);

		GL11.glTranslatef(0F, -8F, -2F);
	}

	public static void drawHeadWear(TextureLoader3D loader)
	{
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		GL11.glTranslatef(-1F, -3.5F, -1F);
		GL11.glScalef(1.125F, 1.125F, 1.125F);

		loader.headWear3D[0].bind();

		GL11.glTranslatef(0F, 8F, 2F);

		GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(12.0F, 2.0F, -24.0F);
		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(8, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(8, 0, 8);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, 8);

		GL11.glEnd();

		GL11.glRotatef(-180, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(-12.0F, -2.0F, 24.0F);
		GL11.glRotatef(-90, 1.0F, 0.0F, 0.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.headWear3D[3].bind();

		GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
		GL11.glTranslatef(4.0F, 10.0F, -24.0F);

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(8, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(8, 0, 8);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, 8);

		GL11.glEnd();

		GL11.glTranslatef(-4.0F, -10.0F, 24.0F);
		GL11.glRotatef(-90, 1.0F, 0.0F, 0.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.headWear3D[2].bind();

		GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(90, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(2.0F, -4.0F, -24.0F);

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(8, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(8, 0, 8);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, 8);

		GL11.glEnd();

		GL11.glTranslatef(-2.0F, 4.0F, 24.0F);
		GL11.glRotatef(-90, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-90, 1.0F, 0.0F, 0.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.headWear3D[1].bind();

		GL11.glRotatef(-180, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(90, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(-10.0F, 12.0F, -24.0F);

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(8, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(8, 0, 8);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, 8);

		GL11.glEnd();

		GL11.glTranslatef(10.0F, -12.0F, 24.0F);
		GL11.glRotatef(-90, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(-90, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(180, 0.0F, 1.0F, 0.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.headWear3D[4].bind();

		GL11.glTranslatef(12.0F, 24.0F, 10.0F);
		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(8, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(8, 0, 8);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, 8);

		GL11.glEnd();

		GL11.glRotatef(-180, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-180, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(-12.0F, -24.0F, -10.0F);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		loader.headWear3D[5].bind();

		GL11.glTranslatef(12.0F, 16F, 10.0F);
		GL11.glRotatef(180, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex3f(0, 0, 0);

		GL11.glTexCoord2f(1, 0);
		GL11.glVertex3f(8, 0, 0);

		GL11.glTexCoord2f(1, 1);
		GL11.glVertex3f(8, 0, 8);

		GL11.glTexCoord2f(0, 1);
		GL11.glVertex3f(0, 0, 8);

		GL11.glEnd();

		GL11.glRotatef(-180, 1.0F, 0.0F, 0.0F);
		GL11.glRotatef(-180, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(-12.0F, -16F, -10.0F);

		GL11.glTranslatef(0F, -8F, -2F);

		GL11.glScalef(0.888888888888888888888888F, 0.888888888888888888888888F, 0.888888888888888888888888F);
		GL11.glTranslatef(1F, 3.5F, 1F);
	}
}
