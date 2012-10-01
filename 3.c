#include<stdio.h>

int main()
{
	int x, y, i, k;
	do
	{
		printf("Vuvedi x:");
		scanf("%d", &x);
		getchar();
		
		printf("Vuvedi y (x<y): ");
		scanf("%d", &y);
		getchar();
	}
	while(x>y);
	
	for(i = x; i < y; i++)
	{
		for(k = 2; ; k++)
		{
			if (i%k == 0)
				break;
		}
		if(i == k)
		{
			if(i % 10 == 3)
				printf("%d\t", i);
		}
	}	

	return 0;
}
