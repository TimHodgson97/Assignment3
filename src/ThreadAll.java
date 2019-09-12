import java.util.concurrent.ForkJoinPool;

public class ThreadAll
{
	static long startTime = 0;
	CloudData cd;
	int lo;
	int hi;

	public ThreadAll(CloudData cd, int lo, int hi)
	{
		this.cd = cd;
		this.lo = lo;
		this.hi = hi;
	}
	private static void tick()
	{
		startTime = System.currentTimeMillis();
	}

	private static float tock()
	{
		return (System.currentTimeMillis() - startTime) / 1000.0f;
	}

	static final ForkJoinPool fjPool = new ForkJoinPool();

	static Vector calc(CloudData c)
	{
		return fjPool.invoke(new ThreadSum(c,0,c.dim()-1));
	}


	public static void main(String[] args)
	{
		/*int max =1000000;
		int [] arr = new int[max];
		for (int i=0;i<max;i++)
		{
			arr[i]=100;
		}*/
		tick();
		Vector windV = calc(cd);
		float time = tock();
		System.out.println("Run took "+ time +" seconds");

		System.out.println("Wind Vector is:");
		System.out.println(sumArr);
		tick();
		windV = calc(cd);
		time = tock();
		System.out.println("Second run took "+ time +" seconds");

		System.out.println("Wind Vector is:");
		System.out.println(windV);
	}
}
