#include<stdio.h>

int fib(int x);

int main()
{
	int x, i, k, l, m = 1;
	int arr[10];
	printf("Vuvedi x:");
	scanf("%d",&x);
	getchar();
	
	for(i = 0; i < 10; i++)
	{
		for(k = m;; k++)
		{
			if(fib(k)%10==x)
			{
				l = fib(k);
				printf("%d\n", fib(k));
				break;
			}
		}
		arr[i] = l;
		m = k+1; 
	}	

	for(i = 0; i < 10; i++)
	{
		printf("%d - %d\n", i, arr[i]);
	}
	return 0;
}

int fib(int x)
{
	/*if(x==1 || x== 2) 
	{
		return 1;
	}
	else
	{
		return fib(x-1)+fib(x-2);
	}*/

	int i,a = 0, b = 0, c = 1;
	if(x == 1 || x == 2)
	{
		return 1;
	}
	else
	{
		for(i = 1; i < x; i++)
		{
			a = b;
			b = c;
			c = a + b;
		}
		return c;
	}
}
