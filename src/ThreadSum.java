import java.util.concurrent.RecursiveTask;

public class ThreadSum extends RecursiveTask<Vector>
 {
	  //Declare variables
	  int lo;
	  int hi;
	  int[] pos;
	  CloudData cd;
	  static final int SEQUENTIAL_CUTOFF=500;

	  int ans = 0; //Result

	  ThreadSum(CloudData cd, int lo, int hi)
	  {
	  	this.lo = lo;
		this.hi = hi;
		this.cd = cd
	  }


	  protected Vector compute()
	  {
		  //Return answer
		  if((hi-lo) < SEQUENTIAL_CUTOFF)
		  {
			  int ans = 0;
		      for(int i=lo; i < hi; i++)
		        ans += arr[i];
		      return ans;
		  }
		  else
		  {
			  ThreadSum left = new ThreadSum(arr,lo,(hi+lo)/2);
			  ThreadSum right= new ThreadSum(arr,(hi+lo)/2,hi);
			  left.fork();
			  int rightAns = right.compute();
			  int leftAns  = left.join();
			  return leftAns + rightAns;
		  }
		  
	 }
	 
	 public double localAvg(int t, int x, int y)
	 {
	 
	 }
	 
	 public Vector avg(int dim, int x, int y)
	 {
	 	
	
	 }
}

