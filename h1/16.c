﻿/*
Училище - Технологично училище "Електронни системи" към ТУ-София http://www.elsys-bg.org/
Клас - 11Б клас
Номер - 6
Име - Божидар Ивов Гьорев
Задача - Да се разработи програма, която изисква от потребителя да въведе целочислено число x, където x e интервала [0; +∞). 
Да се намерят първите 10 нечетни числа делители на x и да се запишат в масив. 
Масивът да се изведе на екрана и да се намерят простите числа в този масив.
*/

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
