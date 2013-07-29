package rikmuld.skin3D.world;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector3f;

public class Camera {

	public Vector3f vector = new Vector3f();
	public Vector3f rotation = new Vector3f();
	public Vector3f vectorPrevious = new Vector3f();
	boolean moveForward = false, moveBackward = false;
	boolean strafeLeft = false, strafeRight = false;
	boolean flyUp = false, flyDown = false;
	static float speed = 0.15f;
	Skin3DWorld skin3DWorld;
	public boolean mouseClose = false;
	public boolean[] setVector = new boolean[]{ false, false};
	
	public Camera(Skin3DWorld world)
	{
		this.skin3DWorld = world;
		Mouse.setGrabbed(false);
		mouseClose = true;
	}
	
	public void update()
	{
		updatePrevious();
		input();
		updateVector();
	}
	
	public void updateVector()
	{
		if(setVector[0]==false)
		{
			setVector[0] = true;
			vector.z = -10;
			vector.y = 8;
			vector.x = -10;
		}
		
		if(Mouse.isCreated())
		{
			if(moveForward)
			{
				vector.x -= (float) (Math.sin(-rotation.y * Math.PI / 180) * speed);
				vector.z -= (float) (Math.cos(-rotation.y * Math.PI / 180) * speed);
			}
			if(moveBackward)
			{
				vector.x += (float) (Math.sin(-rotation.y * Math.PI / 180) * speed);
				vector.z += (float) (Math.cos(-rotation.y * Math.PI / 180) * speed);
			}
			if(strafeLeft)
			{
				vector.x += (float) (Math.sin((-rotation.y - 90) * Math.PI / 180) * speed);
				vector.z += (float) (Math.cos((-rotation.y - 90) * Math.PI / 180) * speed);
			}
			if(strafeRight)
			{
				vector.x += (float) (Math.sin((-rotation.y + 90) * Math.PI / 180) * speed);
				vector.z += (float) (Math.cos((-rotation.y + 90) * Math.PI / 180) * speed);
			}
			if(flyUp&&vector.y<50)
			{
				vector.y+=speed;
			}
			else if(flyDown&&vector.y>0)
			{
				vector.y-=speed;
			}
		}
	}
	
	public void translatePostion()
	{
		GL11.glRotatef(rotation.x, 1, 0, 0);
		GL11.glRotatef(rotation.y, 0, 1, 0);
		GL11.glRotatef(rotation.z, 0, 0, 1);
		GL11.glTranslatef(-vector.x, -vector.y-2.4f, -vector.z);
	}
	
	public void updatePrevious()
	{
		vectorPrevious.x = vector.x;
		vectorPrevious.y = vector.y;
		vectorPrevious.z = vector.z;
	}
	
	public void input()
	{
		moveForward = skin3DWorld.keys[Keyboard.KEY_W];
		moveBackward = skin3DWorld.keys[Keyboard.KEY_S];
		strafeLeft = skin3DWorld.keys[Keyboard.KEY_A];
		strafeRight = skin3DWorld.keys[Keyboard.KEY_D];
		flyUp = skin3DWorld.keys[Keyboard.KEY_SPACE];
		flyDown = skin3DWorld.keys[Keyboard.KEY_LSHIFT];

		if(skin3DWorld.keys[Keyboard.KEY_Q]||skin3DWorld.keys[Keyboard.KEY_E])
		{
			speed=speed+0.01F;
		}
		else
		{
			speed = 0.15F;
		}
		
		if(setVector[1]==false)
		{
			setVector[1] = true;
			rotation.y = 135;
		}
		
		if(Mouse.isGrabbed())
		{
			float mouseDX = Mouse.getDX() * 0.8f * 0.16f;
			float mouseDY = Mouse.getDY() * 0.8f * 0.16f;
			if (rotation.y + mouseDX >= 360) 
			{
				rotation.y = rotation.y + mouseDX - 360;
			} 
			else if (rotation.y + mouseDX < 0) 
			{
				rotation.y = 360 - rotation.y + mouseDX;
			} 
			else
			{
				rotation.y += mouseDX;
			}
			if (rotation.x - mouseDY >= -89 && rotation.x - mouseDY <= 89)
			{
				rotation.x += -mouseDY;
			} 
			else if (rotation.x - mouseDY < -89) 
			{
				rotation.x = -89;
			} 
			else if (rotation.x - mouseDY > 89)
			{
				rotation.x = 89;
			}
		}
		if(mouseClose)
		{
			Mouse.destroy();
		}
		else
		{
			try 
			{
				Mouse.create();
			} 
			catch (LWJGLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
