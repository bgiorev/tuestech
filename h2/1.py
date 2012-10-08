#Училище - Технологично училище "Електронни системи" към ТУ-София http://www.elsys-bg.org/
#Клас - 11Б клас
#Номер - 6
#Име - Божидар Ивов Гьорев
#Задача - Да се разработи програма, която да чете даден csv документ и да сумира стойности в дадена колона 
#Енкодинга прецаква работата на програмата!

# -*- coding: cp1251 -*-
import csv

file = open("test.csv", 'rb')
reader = csv.reader(file, delimiter = ';')
sum = 0
fields = reader.next()
for row in reader:
    items = zip(fields, row)
    item = {}
    for (name, value) in items:
        item[name] = value.strip()
        if name == "Брой решени задачи":
            if item[name].isdigit():
                sum += int(str(item[name]))
print(sum)
file.close()
