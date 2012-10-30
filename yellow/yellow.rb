#Училище - Технологично училище "Електронни системи" към ТУ-София http://www.elsys-bg.org/
#Клас - 11Б клас
#Номер - 6
#Име - Божидар Ивов Гьорев
#Задача - Да се намерят първите 10, по-малки от 3
require 'csv'
i = 0
sum = 0.00
CSV.open("results_from_feature_scenarios_times.csv", "wb") do |csv|
	CSV.foreach("feature_scenarios_times.csv") do |row|
		sum += row[0].to_f
		i += 1
		if i == 10
			break
		end
	end
	csv << [sum]
end
