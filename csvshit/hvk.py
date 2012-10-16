#Училище - Технологично училище "Електронни системи" към ТУ-София http://www.elsys-bg.org/
#Клас - 11Б клас
#Номер - 6
#Име - Божидар Ивов Гьорев
#Задача - Да се разработи програма, която да чете даден csv документ и да сумира стойности в дадена колона 
#Енкодинга прецаква работата на програмата!

# -*- coding: cp1251 -*-
import csv
import os.path
members = []
for k in range(1,29):
	
	s = str(k) + ".csv"
	if os.path.isfile(s):
		file = open(s, 'rb')
		reader = csv.reader(file, delimiter = ',', quotechar = '|')
		for row in reader:
			for l in row:
				if l.isdigit():
					m = int(str(l))
					members[m] = members[m] + 1
			
		file.close()
	for k in members:
		print k
