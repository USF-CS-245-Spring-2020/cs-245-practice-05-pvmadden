//
// Tom Sawyer Software
// Copyright 2007 - 2020
// All rights reserved.
//
// www.tomsawyer.com
//


import java.io.*;


public class MegaSort
{
	public static void main(String[] args)
	{
		File textFile = null;

		int[] ints = new int[1000000];

		// This try catch will attempt to use the string argument passed from args to
		// create a file object.
		try
		{
			textFile = new File(args[0]);
		}
		catch (Exception e)
		{
			System.out.println("No file argument " + e.getMessage());
		}

		// This buffered reader will read the file line by line
		try (BufferedReader br = new BufferedReader(new FileReader(textFile)))
		{
			int count = 0;

			// Until we hit the bottom of the file, keep adding each number into ints
			while (br.ready())
			{
				char[] c = br.readLine().toCharArray();

				boolean foundFirstNonZero = false;
				int startingIndex = c.length - 1;

				for (int i = 0; i < c.length - 1; i++)
				{
					// if an initial value in c that is not zero isn't found, check, and
					// if so, set that as the starting index that will be used to create a
					// string without leading zeros
					if (!foundFirstNonZero)
					{
						if (c[i] != '0')
						{
							startingIndex = i;
							foundFirstNonZero = true;
						}
					}
				}

				String numWithNoLeadingZero = "";

				// Now we construct a new string with no leading zeros
				for (int i = startingIndex; i != c.length; i++)
				{
					numWithNoLeadingZero += c[i];
				}

				// Parse it to an int and add it to the int array and move on..
				ints[count++] = Integer.parseInt(numWithNoLeadingZero);
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		QuickSort qs = new QuickSort();
		qs.sort(ints);

		for(int i = 0; i < 3; i++)
		{
			System.out.println(ints[i]);
		}
	}
}
