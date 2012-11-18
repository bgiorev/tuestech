require 'nokogiri'
require 'open-uri'
require 'csv'

def start()
CSV.open("link_result.csv","wb") do |csv|
	page = Nokogiri::HTML(open('http://nokogiri.org/'))
	links = page.search('a')
	main_title = page.search("title")
	i = 0
	for link in links
		if link['href'].include? "http"
			puts link['href']
			csv <<[link['href']]
		else
			puts "http://nokogiri.org/#{link['href']}"
			csv << ["http://nokogiri.org/#{link['href']}"]
		end
		i+= 1
	end	
	puts "The number of links on this page is #{i}"
	puts main_title
end
end


start()