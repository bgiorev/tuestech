#	Технологично училище "Електронни системи"
#	www.elsys-bg.org
#	11Б клас
#	Божидар ивов Гьорев
#	Номер 6
#	Задача - да се състави програма, която взима съдържанието на един сайт и изкарва всички линкове от него

require 'nokogiri'
require 'open-uri'
require 'csv'

def start(a)
CSV.open("link_result.csv","wb") do |csv|
	page = Nokogiri::HTML(open(a))
	links = page.search('a')
	main_title = page.search("title")
	i = 0
	for link in links
		if link['href'].include? "http"
			puts link['href']
			csv <<[link['href']]
		else
			puts "#{a + link['href']}"
			csv << ["#{a + link['href']}"]
		end
		i+= 1
	end	
	puts "The number of links on this page is #{i}"
	puts main_title
end
end

ARGV.each do |a|
	if !a.end_with?('/')
		a = a + '/'
	end
	puts a
	start(a)
end