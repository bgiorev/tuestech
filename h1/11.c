﻿/*
Училище - Технологично училище "Електронни системи" към ТУ-София http://www.elsys-bg.org/
Клас - 11Б клас
Номер - 6
Име - Божидар Ивов Гьорев
Задача - Да се разработи програма, която изисква от потребителя да въведе целочислено число х, където 0<x<10. 
Да се инициализира масив от 10 елемента. Да се намери сумата от cos(z) за всяко z в интервала [0;x) и да се запише като първи елемент в масива. 
Да се намери сумата от cos(z) за всяко z в интервала [x; 2x) и да се запише като втори елемент в масива. 
Аналогично да се намерят сумите на cos(z) за всички интервали [Nx; (N+1)x ) и да се запишат като елемент N в масива за всяко N в интервала [0, 10). 
Масивът да се изведе на стандартния изход.
*/

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

	for(i = 0; i <= 10; i++)
	{
		sum = 0;
		for(z = i*x; z<(i+1)*x; z++)
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
