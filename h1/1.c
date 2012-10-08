/*
Училище - Технологично училище "Електронни системи" към ТУ-София http://www.elsys-bg.org/
Клас - 11Б клас
Номер - 6
Име - Божидар Ивов Гьорев

Задача - Да се разработи програма, която изисква от потребителя да въведе две целочислени числа, x и y, където x < y. Да се намери сумата на всички нечетни числа в интервала [x,y].
*/

#include <stdio.h>

int main()
{
	int sum = 0, x, y, i;
	do
	{
		printf("Vuvedi x:");
		scanf("%d", &x);
		getchar();
		printf("Vuvedi y:");
		scanf("%d", &y);
		getchar();
	}
	while(x>y);
	
	for(i = x; i <= y; i++)
	{
		if(i%2 != 0)
			sum += i;
	}
	
	printf("%d\n", sum);
	
	return 0;
}
