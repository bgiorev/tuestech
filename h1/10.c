/*
Училище - Технологично училище "Електронни системи" към ТУ-София http://www.elsys-bg.org/
Клас - 11Б клас
Номер - 6
Име - Божидар Ивов Гьорев
Задача - Да се разработи програма,  която изисква от потребителя да въведе четири числа x, y, w, h където x>0, y>0, w>0, h>0. 
Числото x е дължината на плоча дървесина, а числото y е височината. Да се определи на колко цели плочи с размери w, h може да се разреже голямата плоча. 
Да се инициализира масив от 10 елемента. Стойностите на елементите на масива да са първите 10 координати по дължина на плочата, 
в които тя трябва да се разреже, за да се получат по-малките плочи.
*/

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
