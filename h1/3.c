/*
Училище - Технологично училище "Електронни системи" към ТУ-София http://www.elsys-bg.org/
Клас - 11Б клас
Номер - 6
Име - Божидар Ивов Гьорев
Задача - Да се разработи програма, която изисква от потребителя да въведе две целочислени числа, x и y, 
където x < y. Да се намерят и изведат всички прости числа завършващи на 3 в интервал [x,y].
*/

#include<stdio.h>

int main()
{
	int x, y, i, k;
	do
	{
		printf("Vuvedi x:");
		scanf("%d", &x);
		getchar();
		
		printf("Vuvedi y (x<y): ");
		scanf("%d", &y);
		getchar();
	}
	while(x>y);
	
	for(i = x; i < y; i++)
	{
		for(k = 2; ; k++)
		{
			if (i%k == 0)
				break;
		}
		if(i == k)
		{
			if(i % 10 == 3)
				printf("%d\t", i);
		}
	}	

	return 0;
}
