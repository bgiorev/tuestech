#include <stdio.h>

int main()
{
	int sum = 0, x, y, i;
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
		if(i%2 != 0)
			sum += i;
	}
	
	printf("%d\n", sum);
	
	return 0;
}
