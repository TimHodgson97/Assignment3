import java.util.concurrent.RecursiveTask;

public class ThreadSum extends RecursiveTask<Vector>
 {
	//Declare variables
	int lo;
	int hi;
	CloudData cd;
	static final int SEQUENTIAL_CUTOFF=500;
	
	ThreadSum(CloudData cd, int lo, int hi)
	{
		this.lo = lo;
		this.hi = hi;
		this.cd = cd
	}


	public Vector compute()
	{
		if ((hi-lo)<SEQUENTIAL_CUTOFF)
		{
			Vector wind = new Vector(0,0);
		  	int count = 0;
		  	//Iterate through t, x, y
			for (int t = 0; t<cd.dimt; t++}
			{
				for (int x = 0; x< dimx; x++)
				{
					for (int y = 0; y< dimy; y++)
					{
						double lenW = localAvg(t, x, y);
						wind.add(cd.advection[i][j][k]);
						if (absUp>lenW)
						{
							cd.classification[t][x][y] = 0;
						}
						else if (lenW>0.2)
						{
							cd.classification[t][x][y] = 1;
						}
						else
						{
							cd.classification[t][x][y] = 2;
						}
						count++;
					}
				}
			}
			wind.divide(count);
			return wind;
		}
		else
		{
			ThreadSum left = new ThreadSum(cd, lo, (hi+lo)/2);
			ThreadSum right = new ThreadSum(cd, (hi+lo)/2, hi);
			left.fork();
			Vector rightAns = right.compute();
			Vector leftAns = left.join();
			Vector ans = rightAns.add(leftAns);
			return ans;
		}
	}
	
	static final ForkJoinPool fjPool = new ForkJoinPool();
	
	public double localAverage(int t, int x ,int y)
	{
		Vector v = new Vector(x, y);
		int divisor = 9; //The number of adjacent blocks
		int leaveX = 2;
		int leaveY = 2;
		if (x==0||x==dimx -1)
		{
			divisor = divisor *2/3; //Adjust for corner or edge
		}
		if (y==0||y==dimy -1)
		{
			divisor = divisor *2/3;//Adjust for corner or edge
		}
		if (x ==0)
		{
				leaveX = -1;
		}
		if (x ==cd.dimx()-1)
		{
				leaveX = 1;
		}
		if (y ==0)
		{
				leaveY = -1;
		}
		if (y ==cd.dimy()-1)
		{
				leaveY = 1;
		}
		//Iterate through surrounding blocks
		for (int i =-1; i<2;i++)
		{	
			for (int j =-1; j<2; j++)
			{
				if (leaveX! = i && leaveY! = j)
				{
					v.add(cd.advection[t][x+i][y+j]);
				}
		}
		v.divide(divisor);
	}
	public double absUp(int t, int x, int y)
	{
		return Math.abs(cd.advection[t][x][y]);
	}
}

