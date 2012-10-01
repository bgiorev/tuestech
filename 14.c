#include<stdio.h>

int main()
{
	int i, k, m = 2, n, x, b = 0;
	int arr[10];

	do
	{
		printf("Vuvedi x:");
		scanf("%d", &x);
		getchar();
	}
	while(0>x && x>10);

	for(n = 0; n < 10; n++)
	{
		for(k = m; b == 0; k++)
		{
			b = 0;
			for(i = 2; i < k; i++)
			{
				if(k%i==0)
					break;
			}
			if(i == k)
			{
				if(k % 10 == x)
				{	
					arr[n] = k;
					printf("%d - %d\n", n, arr[n]);
					b = 1;
				}
			}
		}
	}
	for(i = 0; i < 10; i++)
	{
		printf("%d - %d\n", i, arr[i]); 
	}

	return 0;
}
