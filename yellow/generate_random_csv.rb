require 'csv'
CSV.open("belt1_1.csv", "w") do |csv|
	0.upto(49).each do |i|
		csv << [i,Random.rand(100)]
	end
end
