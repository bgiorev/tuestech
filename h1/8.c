﻿/*
Училище - Технологично училище "Електронни системи" към ТУ-София http://www.elsys-bg.org/
Клас - 11Б клас
Номер - 6
Име - Божидар Ивов Гьорев
Задача - Да се разработи програма, която изисква от потребителя да въведе целочислено число x, където 0<=x<10. 
Да се инициализира масив от 10 елемента. Да се намерят първите 10 числа на Фибоначи в [0; +∞), които се делят на x без остатък. 
Намерените стойности да се зададат като стойности на елементите в масива. Елементите на масива да се изведат на стандартния изход 
*/

#include<stdio.h>

int fib(int x);

int main()
{
	int i, k, x, l = 1;
	int arr[10];
	
	do
	{
		printf("Vuvedi x:");
		scanf("%d", &x);
		getchar();
	}
	while(0>x && x>10);

	for(i = 0; i < 10; i++)
	{
		printf("MINA\n");
		for(k = l; ; k++)
		{
			if(fib(k)%x == 0)
			{
				arr[i] = fib(k);
				l = k+1;
				break;
			}
		}
	}

	for(i = 0; i < 10; i++)
	{
		printf("%d - %d\n", i, arr[i]); 
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
