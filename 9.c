#include<stdio.h>

int main()
{
	double pi = 4.00f;
	float x;
	int i,k = 1;

	do
	{
		printf("Vuvedete x(0<x<1):");
		scanf("%f",&x);
		getchar();
	}
	while(0>x && x>1);
	
	for(i = 3; (float) pi/i>x; i += 2)
	{
		if(k%2 == 0)
		{
			pi += (double) 4/i;			
		}
		else
		{
			pi -= (double) 4/i;
		}
		k++;
	}
	
	printf("%f\n", pi);

	return 0;
}
