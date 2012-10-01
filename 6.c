#include<stdio.h>
#include<stdlib.h>

int main()
{
	int arr[100], i, x, box, k = 0;
	
	do
	{
		printf("Vuvedi x: (0<x<10)");
		scanf("%d", &x);
		getchar();
	}
	while(0<x && x>10);	
	
	for(i = 0; i < 100; i++)
	{
		arr[i] = rand()%100;
	}
	
	for(i = 0; i < 100; i++)
	{
		if(arr[i]%10 == x)
		{
			box = arr[i];
			arr[k] = arr[i];
			arr[k] = box;
			k++;
		}
	}
	
	for(i = 0; i < 100; i++)
	{
		printf("%d - %d\n", i, arr[i]);
	}
	
	return 0;
}
