/*
Училище - Технологично училище "Електронни системи" към ТУ-София http://www.elsys-bg.org/
Клас - 11Б клас
Номер - 6
Име - Божидар Ивов Гьорев
Задача - Да се разработи програма, която изисква от потребителя да въведе число x, където x e интервала (0;1). 
Да се намери сумата от сбора на реципрочните стойности за всеки две twin primes. Развитието да продължи докато отношението не стане по-малко то x.
*/

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
	int i, k, l, m;
	float x, sum, sumprev;

	do
	{
		printf("Vuvedi x:");
		scanf("%f", &x);
	}
	while(x<0 && x > 1);
	
	sum = 0;
	sumprev = 1;
	printf("PURVO\n");
	
	for(i = 2; sumprev > x; i++)
	{
		printf("VTORO\n");
		for(k = 2; ; k++)
		{
			printf("TRETO\n");
			if(i % k == 0)
				break;
		}
		
		if(i == k)
		{
			printf("CHETVURTO\n");
			m = i + 2;
			for(k = 2; ; k++)
			{
				if(m % k == 0)
					break;
			}
			
			if(m == k)
			{
				printf("PETO\n");
				sumprev = (float) (1.0/i + 1.0/m);
				sum = sum + (float)(1.0/i + 1.0/m);
				printf("SUM = %f\n", sum);
			}
		}
		
	}
	
	printf("Sumata na chislata e:%f\n", sum);
	
	return 0;
}

/*for(i = 2; ; i++)
	{
		if(x % i == 0)
			break;
	}
	if(x == i)
		printf("X e prosto chislo\n");
	else
		printf("X ne e prosto chislo\n");*/
