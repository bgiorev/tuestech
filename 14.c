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

	for(i = 0; i < 10; i++)
	{
		for(k = m; ; k++)
		{
			for(n = 2; ; n++)
			{
				if(k%n == 0)
				{
					break;
				}
			}
			if(k == n && k%10 == x)
			{
					break;
			}
		}
		arr[i] = k;
		m = k + 1;
	}
	
	for(i = 0; i < 10; i++)
	{
		printf("%d - %d\n", i, arr[i]); 
	}

	return 0;
}
