//Serial implementation of the cloud classification things
//Tim Hodgson
//September 2019

import java.lang.Math;

public class SerialCloud
{
	CloudData cd;
	int lo;
	int hi;
	
	
	public SerialCloud(CloudData cd, int lo, int hi)
	{
		this.cd = cd;
		this.lo = lo;
		this.hi = hi;
	}
	
	public Vector classify()
	{
		Vector wind = new Vector(0,0);
		int count = 0;
		for (int t = 0; t<cd.dimt; t++}
		{
			for (int x = 0; x< dimx; x++)
			{
				for (int y = 0; y< dimy; y++)
				{
					wind.add(cd.advection[i][j][k]);
				}
			}
		}
	}
	
	public double localAverage(int t, int x ,int y)
	{
		Vector v = new Vector(x, y);
		int divisor = 9; //The number of adjacent blocks
		if (x==0||x==dimx -1)
		{
			divisor = divisor *2/3; //Adjust for corner or edge
		}
		if (y==0||y==dimy -1)
		{
			divisor = divisor *2/3;//Adjust for corner or edge
		}
		//Iterate through surrounding blocks
		for (int i =-1; i<2;i++)
		{
			if (x ==0 && i==-1)
			{
				i = 0;
			}
			for (int j =-1; j<2; j++)
			{
				if (y == 0 && j==-1)
				{
					j = 0;
				}
				v.add(advection[t][x+i][y+j]);
				if (y==dimy -1 && j == 0)
				{
					j++;
				}
			}
			if (x == dimx -1 && i == 0)
			{
				i++;
			}
		}
		
	}
}
