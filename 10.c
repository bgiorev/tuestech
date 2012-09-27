#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int main()
{
	float x, y, h, w;
	int i;
	float arr[10];

	do
	{
		printf("Vuvedi visochina i shirina na golqmata plocha:");
		scanf("%f", &h);
		getchar();
		scanf("%f", &w);
		getchar();
		
		printf("Vuvedi razmerite na malkite plochi:");
		scanf("%f", &x);
		getchar();
		scanf("%f", &y);
		getchar();
		
	}
	while(x<0 && y<0 && h<0 && w<0);
	
	printf("Ot golqmata plocha mogat da se izrejat tochno %f plochki\n", ((h/x)*(w/y)));

	for(i = 0; i < 10; i++)
	{
		arr[i] = (i+1)*x;
	}
	
	for(i = 0; i < 10; i++)
	{
		printf("%d - %f\n", i, arr[i]);
	}

	return 0;
}
