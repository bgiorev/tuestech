#include<stdio.h>

int main()
{
	int x, i, k, arr[10], sum = 0;
	
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
		for(k = 0; k < 1000; k++)
		{
			if(k%((i+1)*x) == 0)
				sum += k;
		}
		arr[i] = sum;
	}
	
	for(i = 0; i < 10; i++)
	{
		printf("%d - %d\n", i, arr[i]); 
	}
	
	
	return 0;
}
