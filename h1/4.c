﻿/*
Училище - Технологично училище "Електронни системи" към ТУ-София http://www.elsys-bg.org/
Клас - 11Б клас
Номер - 6
Име - Божидар Ивов Гьорев
Задача -Да се разработи програма, която изисква от потребителя да въведе две целочислени числа, x и y, 
където x < y. Да се намерят и изведат всички числа на Фибоначи в интервала [x, y] 
*/

#include<stdio.h>

int fib(int x);

int main()
{
	int x,y,i;

	do
	{
		printf("Vuvedi x:");
		scanf("%d", &x);
		getchar();
	
		printf("Vuvedi y(x<y):");
		scanf("%d", &y);
		getchar();
				
	}
	while(x>y);

	for(i = 1; fib(i)<y; i++)
	{
		if(fib(i)>x && fib(i)<y)
			printf("%d\n", fib(i));
		
	}

	return 0;
}

int fib(int x)
{
	int a = 0,b = 1,c = 1,i;
	
	if(x == 1 || x == 2)
	{
		return 1;
	}
	else
	{
		for(i = 3; i < x; i++)
		{
			a = b;
			b = c;
			c = a + b;	
		}
		return c;
	}
}
