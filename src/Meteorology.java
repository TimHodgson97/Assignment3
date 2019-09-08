// Serialised verion of meteorology
//Tim Hodgson
//August 2019

import java.io.*;
import java.util.Scanner;

public class Meteorology
{
	public static String outputFile;
	public static String inputFile;
	//public String[] data;

	public static void main(String[] args)
		{
			Scanner inputOutput = new Scanner(System.in);

			System.out.println("Input files in form <data file name> <output file name> separated by a space");
			String temp = inputOutput.nextLine();
			System.out.println(temp);
			String[]  files = temp.split("\\s+");
			//Assign file names to input and output
			inputFile = files[0].toString();
			outputFile = files[1].toString();

			//Read the input file data into an array
			readInputFile(inputFile);
		}

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
	}
}
