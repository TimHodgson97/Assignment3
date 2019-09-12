//Serialised verion of meteorology
//Tim Hodgson
//August 2019

import java.io.*;
import java.util.Scanner;

public class Meteorology
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		String outputFile;
		String inputFile;
		long tick[] = new long[151];
		long tock[] = new long[150];
		long tot;
		long avg;

		System.out.println("Input files in form <data file name> <output file name> separated by a space");
		inputFile = s.next();
		outputFile = s.Next();
		System.out.println("Input mode (0 for sequential, 1 for parallel)");
		int mode = s.nextInt();
			
		//Use CloudData class to read the input file
		CloudData cd = new CloudData();
		cd.readData(inputFile);
		System.gc();
		if (mode = 0)
		{
			tick[0] = System.currentTimeMillis();
			for (int i=0; i<151 i++)
			{
				SerialCloud sc = new SerialCloud(cd, 0, cd.dim()-1)
				cd.setWind(sc.classify());
				tick[i] = System.currentTimeMillis();
			}
			for (int j = 0; j<150; j++)
			{
				tock[j] = tick[j+1]-tick[j];
				tot += tock[j];
			}
		}
		else if (mode = 1)
		{
			tick[0] = System.currentTimeMillis();
			for (int i=0; i<151 i++)
			{
				ThreadSum ts = new ThreadSum(cd, 0, cd.dim()-1);
				cd.setWind(ts.compute());
				tick[i] = System.currentTimeMillis();
			}
			for (int j = 0; j<150; j++)
			{
				tock[j] = tick[j+1]-tick[j];
				tot += tock[j];
			}
		}
		//Catch the naughty ones trying to pull a fast one with a mode we didn't prepare for!
		else
		{
			System.out.println("Error: Incorrect Mode Entry");
		}
		avg = tot/150;
		System.out.println("Time to run 150 times: " + tot+ " Average time taken: ");
		cd.writeData(outputFile);
	}
		
/*	private static void tick()
	{
		startTime = System.currentTimeMillis();
	}
	private static float tock()
	{
		return (System.currentTimeMillis() - startTime)
	}*/









/*
	public static void readInputFile(String s)
	{
		String line = null;

        	try {
            	//FileReader reads text from input file
            	FileReader fileReader = new FileReader(s);
            	BufferedReader bufferedReader = new BufferedReader(fileReader);

            	while((line = bufferedReader.readLine()) != null)
		{
                	System.out.println(line);
            	}

            	bufferedReader.close();
        	}
	        catch(FileNotFoundException ex)
		{
            		System.out.println("Unable to open file '" + s + "'");
        	}
        	catch(IOException ex)
		{
            		System.out.println("Error reading file '" + s + "'");
      		}
	}*/
}
