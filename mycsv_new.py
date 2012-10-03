# -*- coding: cp1251 -*-
import csv

file = open("test.csv", 'rb')
reader = csv.reader(file, delimiter = ';')
sumruby = 0
sumpython = 0
sumperl = 0
fields = reader.next()
for row in reader:
    items = zip(fields, row)
    numbers = zip(fields, row)
    item = {}
    number = {}
    for (name, value) in items:
        item[name] = value.strip()
        if name == "Използван език":
            if item[name] == "Ruby":
                for (name1,value1) in numbers:
                    number[name1] = value1.strip()
                    if name1 == "Номер":
                        if number[name1].isdigit():
                            sumruby += int(str(number[name1]))
            elif item[name] == "Python":
                for (name1, value1) in numbers:
                    number[name1] = value1.strip()
                    if name1 == "Номер":
                        if number[name1].isdigit():
                            sumpython += int(str(number[name1]))
            elif item[name] == "Perl":
                for (name1, value1) in numbers:
                    number[name1] = value1.strip()
                    if name1 == "Номер":
                        if number[name1].isdigit():
                            sumperl += int(str(number[name1]))
            
print "Sborut ot nomerata na horata, rabotili s Ruby e:", sumruby
print "Sborut ot nomerata na horata, rabotili s Python e:", sumpython
print "Sborut ot nomerata na horata, rabotili s Perl e:", sumperl
file.close()

