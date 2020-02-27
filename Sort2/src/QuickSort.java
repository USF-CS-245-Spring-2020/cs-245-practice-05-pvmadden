
public class QuickSort
{
	public void sort(int [] a)
	{
		qs(a, 0, a.length-1);
	}

	void qs(int[] a, int start, int end)
	{
		if(start < end)
		{
			int p = partition(a, start, end);
			qs(a, start, p - 1);
			qs(a, p + 1, end);
		}

	}

	int partition(int[] a, int start, int end)
	{
		//we set pivot to be the first element
		int pivot = a[start];
		int left = start+1;
		int temp;

		// for loop iterates from the right of the pivot
		// to the end of the array
		for (int i = start+1; i <= end; i++)
		{
			//
			if(a[i] < pivot)
			{
				if(i != left)
				{
					//swaps the values from moving right to left
					temp=a[left];
					a[left]=a[i];
					a[i]=temp;
				}
				left++;
			}
		}
		a[start] = a[left-1];
		a[left-1] = pivot;

		return left-1;
	}
}
