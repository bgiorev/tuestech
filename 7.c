#include<stdio.h>
#include<math.h>

int main()
{
	int x, i, k, l = 1, n;
	double arr[10];
	do
	{
		printf("Vuvedi x:");
		scanf("%d", &x);
		getchar();
	}
	while(0>x && x>10);	
	
	for(i = 0; i < 10; i++)
	{
		for(k = l; ; k++)
		{
			n = (int)(cos(k) * 1000);
			if (n%10 == x)
			{
				arr[i] = cos(k);
				l = k + 1;
				break;
			}
		}
	}	
	
	for(i = 0; i < 10; i++)
	{
		printf("%d - %f\n", i, arr[i]); 
	}
	
	return 0;
}
