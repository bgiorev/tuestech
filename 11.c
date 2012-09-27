#include<stdio.h>
#include<math.h>

int main()
{
	int x, i, z;
	double sum, arr[10];

	do
	{
		printf("Vuvedi x:");
		scanf("%d", &x);
		getchar();
	}
	while(x<0 && x>10);

	for(i = 1; i <= 10; i++)
	{
		sum = 0;
		for(z = (i-1)*x; z<i*x; z++)
		{
			sum = sum + cos(z);
		}
		arr[i] = sum;
	}

	for(i = 0; i<10; i++)
	{
		printf("%d - %f\n", i, arr[i]);
	}

	return 0;
}
