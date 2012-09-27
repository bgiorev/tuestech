#include<stdio.h>
#include<math.h>

int main()
{
	int i, k;
	double box,arr[10];
	
	for(i = 0; i < 10; i++)
	{
		arr[i] = cos(i);
	}

	for(i = 0; i < 10; i++)
	{
		printf("%d - %f - nesortiran\n", i, arr[i]);
	}

	for(i = 9; i > 0; i--)
	{
		for(k = 1; k <= i; k++)
		{
			if(arr[k-1]<arr[k])
			{
				box = arr[k-1];
				arr[k-1] = arr[k];
				arr[k] = box;
			}
		}
	}

	for(i = 0; i < 10; i++)
	{
		printf("%d - %f - sortiran\n", i, arr[i]);
	}

	return 0;
}
