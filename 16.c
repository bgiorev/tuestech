#include<stdio.h>
#include<stdlib.h>


int a[10];
int main()
{
	int x, i, k, m = 1, l;
	
	do
	{
		printf("Vuvedete chisloto x(x>0):\n");
		scanf("%d",&x);
		getchar();
	}
	while(x<0);
	
	for(i = 0;i < 10; i++)
	{	
		l = x;
		for(k = m; k < l; k++)
		{
			if(x % k == 0)
			{	printf("%d %d %d\n", x, k, (x%k));
				if(k % 2 == 1)
				{
					l = k;
				
				}				
			}
		}
		a[i] = l;
		m = k;
	}

	for (m = 0; m<= 9; m++)
	{
		printf("%d\n", a[m]);
	}
	
	return 0;
}
