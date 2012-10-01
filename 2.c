#include<stdio.h>

int main()
{
	int sum = 0, i, x, y;
	
	do
	{
		printf("Vuvedi x:");
		scanf("%d", &x);
		getchar();
		printf("Vuvedi y:");
		scanf("%d", &y);
		getchar();
	}
	while(x>y);
	
	for(i = x; i <= y; i++)
	{
		if(i%17 == 0)
		{
			sum += i;
		}
	}
	
	printf("%d\n", sum);

	return 0;
}
