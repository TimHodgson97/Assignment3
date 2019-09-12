//Vector class
//Tim Hodgson
//August 2019

import java.lang.Math;

public class Vector
{
	public float x;
	public float y;
	
	public Vector()
	{
	}

	public Vector(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	public float getX()
	{
		return x;
	}

	public float getY()
	{
		return y;
	}
	
	//Adds two vectors' components
	public void add(Vector v)
	{
		x+= d.x;
		y+= d.y;
	}
	
	//Divides a vector's components by a number
	public void divide(int n)
	{
		x = x/n;
		y = y/n;
	}
	
	public double len()
	{
		return Math.sqrt(x*x+y*y);
	}
}
