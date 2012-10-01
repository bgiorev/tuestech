#include<stdio.h>

int main()
{
	int arr[10], i, x, n, cp = 1, sum = 0;
	
	do
	{
		printf("Vuvedi x:");
		scanf("%d", &x);
		getchar();
	}
	while(0>x && x>10);
	
	for(i = 0; i < 10; i++)
	{
		sum = 0;
		for(n = cp; ; n++)
		{
			sum += n;
			if(n % ((i+1)*x) == 0)
			{
				cp = n;
				break;
			}
		}
		arr[i] = sum;
	}
	
	for(i = 0; i<10; i++)
	{
		printf("%d - %d\n", i, arr[i]);
	}
	
	return 0;
}
