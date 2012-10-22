#	Технологично училище "Електронни системи"
#	www.elsys-bg.org
#	11Б клас
#	Божидар ивов Гьорев
#	Номер 6
#	Задача - Да се състави програма, която прави автоматична подредба на пътниците в самолет, който има 162 места, разделени на 6 колони и 27 реда.
class AirPlane
	@@seats = Hash.new(0)
	@@sum = 0
	@@sat = false
	
	def	add(rvalue)
		@@sat = false
		k = 0
		i = 0
		l = 0
		while i<27
			k = 0
			while k<6
				if @@seats[[k,i]] == 0
					if rvalue == 1
						@@seats[[k,i]] = 1
						@@sum += rvalue
						@@sat = true
						break
					end
					
					if rvalue == 2  && k<=4
						if @@seats[[k+1,i]] == 0 && k%3<=1
							@@seats[[k,i]] = 2
							@@seats[[k+1,i]] = 2
							@@sum = @@sum + rvalue
							@@sat = true
							break
						end
					end
					
					if rvalue == 3 && k<=3
						if @@seats[[k+1,i]] == 0 && @@seats[[k+2,i]] == 0 && k%3 == 0
							@@seats[[k,i]] = 3
							@@seats[[k+1,i]] = 3
							@@seats[[k+2,i]] = 3
							@@sum = @@sum + rvalue
							@@sat = true
							break
						end
					end
					
					k = k + 1
				else
					k = k + 1
				end
			end
			if @@sat == true
				i = 27
			else
				i = i + 1
			end
		end
		if @@sat == false
			puts "You must wait another plane!"
		end
	end
	
	def freeSeats() 
		if @@sum < 162
			freeseats = 162 - @@sum
			return freeseats
		else 
			puts "There are no freeseats left"
			return 0
		end
	end
	
	def printSeats()
		i = 0
		k = 0
		while i<27
			k = 0
			while k < 6
				if k == 2
					print "#{@@seats[[k,i]]}  "
				else
					print "#{@@seats[[k,i]]}"
				end
				k = k + 1
			end
			puts
			i = i + 1
			
		end
	end
	
end

plane = AirPlane.new
passangers = 0
plane.printSeats() 
while plane.freeSeats() != 0
	passangers = rand(3) + 1
	plane.add(passangers)
end
plane.printSeats() 