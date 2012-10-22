#	Технологично училище "Електронни системи"
#	www.elsys-bg.org
#	11Б клас
#	Божидар ивов Гьорев
#	Номер 6
#	Задача - Трябва да се открие:
#   -   Кой е най-свързаният номер в клас - всеки ученик получава листа от друг. Написва си номера на него. Човекът, 
#		който е получил лист най-много пъти е най-свързаният номер в клас
#	-	Кой е най-малко свързаният номер в клас - аналогично на горната, човекът написал най-малко пъти номера си е най-малко свързаният.
#   -   За всеки номер да се намери на кой номер е предал листа най-много пъти - ако на даден лист поредния номер е 4,
#		а следващият е 7 то номер 4 е предал листа на номер 7. Номер 4 е предал листа и на много други номера. 
#		Да се намери кой е номерът на който номер 4 е предал листа най-много пъти. Аналогично да се намери и за останалите номера.
#   -   За всеки номер да се намери кой номер му е предал листа най-много пъти - ако на даден лист поредния номер е 4, 
#		а следващият е 7 то номер 4 е предал листа на номер 7. Номер 7 е получил листа и от много други номера.
#		Да се намери кой е номерът, който най-много пъти е дал листа на номер 7. Аналогично да се намери за всеки един номер.
#   -   За точки c и d да се намерят стойностите на най-малко предадените и получените листове.


require 'csv'
require 'pathname'

def izvesten
	mostnum = Array.new
	leastnum = Array.new
	b = 0
	c = 0
	most = $array[1]
	mostnum[0] = 1
	least = $array[1]
	leastnum[0] = 1
	for m in 2..29
		if most<$array[m]
			most = $array[m]
			mostnum[b] = m
		else
			if most == $array[m]
				b += 1
				mostnum[b] = m
			end
		end
		if least>$array[m]
			least = $array[m]
			leastnum[c] = m
		else
			if least == $array[m]
				c += 1
				leastnum[c] = m
			end
		end
	end
	
	for i in mostnum
		p "The most liked person in this class is #{i} number with #{most} likes"
	end
	
	for i in leastnum
		p "The least liked person in this class is #{i} number with #{least} likes"
	end
	
	
end

def predavane
	predalnamax = Hash.new(0)
	predalnamin = Hash.new(0)
	numbers = Array.new(30, 0)
	numbersmin = Array.new(30,0)
	numpred = 1
	numpol = 1
	numpol1 = 1
	number = 1
	numbermin = 1
	for i in 1..29
		number = 1
		numbermin = 1
		predalnamax[[i,1]] = $predalna[[i,1]]
		predalnamin[[i,1]] = $predalna[[i,1]]
		numpred = i
		numpol = 1
		numpol1 = 1
		numbers[number] = 1
		numbersmin[numbermin] = 1
		for m in 2..29
			if predalnamax[[numpred,numpol]] < $predalna[[i,m]]
				predalnamax[[numpred, numpol]] = $predalna[[i,m]]
				numbers[number] = m
			else 
				if	predalnamax[[numpred,numpol]] == $predalna[[i,m]]
					numpol += 1
					number += 1
					predalnamax[[numpred,numpol]] = $predalna[[i,m]]
					numbers[number] = m
				
				end
			end
			
			if predalnamin[[numpred, numpol1]] > $predalna[[i,m]]
				predalnamin[[numpred, numpol1]] = $predalna[[i,m]]
				numbersmin[numbermin] = m
			else
				if	predalnamin[[numpred, numpol1]] == $predalna[[i,m]]
					numpol1 += 1
					numbermin += 1
					predalnamin[[numpred, numpol1]] = $predalna[[i,m]]
					numbersmin[numbermin] = m
				end
			end
		end
		for m in 1..number
			p "Nomer #{i} e predal nai-mnogo puti na nomer #{numbers[m]} ->>>> #{predalnamax[[numpred, numpol]]} puti"
		end	
		
		p "###############################"
		
		for m in 1..numbermin
			p "Nomer #{i} e predal nai-malko puti na nomer #{numbersmin[m]} ->>>>>> #{predalnamin[[numpred, numpol1]]} puti"
		end
		
		p "----------------------------------"
	end
end

def poluchavane
	poluchilmax = Hash.new(0)
	poluchilmin = Hash.new(0)
	numbersmin = Array.new(30,0)
	numbers = Array.new(30,0)
	numpred = 1
	numpred1 = 1
	numpol = 1
	number = 1
	numbermin = 1
	for i in 1..29
		number = 1
		numbermin = 1
		poluchilmax[[i,1]] = $poluchil[[i,1]]
		poluchilmin[[i,1]] = $poluchil[[i,1]]
		numpol = i
		numpred = 1
		numpred1 = 1
		numbers[number] = 1
		numbersmin[numbermin] = 1
		for m in 2..29
			if poluchilmax[[numpol,numpred]] < $poluchil[[i,m]]
				poluchilmax[[numpol, numpred]] = $poluchil[[i,m]]
				numbers[number] = m
			else 
				if	poluchilmax[[numpol,numpred]] == $poluchil[[i,m]]
					numpred += 1
					number += 1
					poluchilmax[[numpol,numpred]] = $poluchil[[i,m]]
					numbers[number] = m
				
				end
			end
			
			if poluchilmin[[numpol, numpred1]] > $poluchil[[i,m]]
				poluchilmin[[numpol, numpred1]] = $poluchil[[i,m]]
				numbersmin[numbermin] = m
			else
				if	poluchilmin[[numpol, numpred1]] == $poluchil[[i,m]]
					numpred1 += 1
					numbermin +=1
					poluchilmin[[numpol, numpred]] = $poluchil[[i,m]]
					numbersmin[numbermin] = m
				end
			end
		end
		for m in 1..number
			p "Nomer #{i} e poluchil nai-mnogo puti ot nomer #{numbers[m]} ->>>>>> #{poluchilmax[[numpol,numpred]]} puti"
		end	
		
		p "###############################"
		
		for m in 1..numbermin
			p "Nomer #{i} e poluchil nai-malko puti ot nomer #{numbersmin[m]} ->>>>>> #{poluchilmin[[numpol,numpred1]]} puti"
		end	
		
		p "--------------------------------"
	end
end

def process_file
	$array = Array.new(30,0)
	$predalna = Hash.new(0)
	$poluchil = Hash.new(0)
	last = 0
	for k in 1..29
		s = k.to_s + ".csv"
		if File.exist?(s)
			f = File.open(s, "r")
			content = f.read
			result = 0
			content.each_line do |line|
				l = line.to_i
				$array[l] = $array[l].to_i + 1
				if last != 0
					$predalna[[last,l]] += 1
					$poluchil[[l, last]] += 1
				end
				last = l
			end
		end
	end
	
	
	
end

process_file
izvesten
predavane
poluchavane
