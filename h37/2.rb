##Class: 11b
##Number: 6
##Name: Bozhidar Giorev
##task - https://docs.google.com/document/d/1DF14IHfXhcXVVYX8QRmOV-Ay5ZuJzP6mYvb05GvPa34/edit
class Song
	attr_accessor :name
	attr_accessor :artist
	attr_accessor :genre
	attr_accessor :subgenre
	attr_accessor :tags
	
	def initialize (name, artist, genre, subgenre, tags)
		@name = name.strip
		@artist = artist.strip
		@genre = genre.strip
		@subgenre = subgenre.strip if subgenre
		@tags = tags.split(", ")
		@tags.each{|tag| tag.strip}
	end
	
	def match?(criteria)
		criteria.each do |key, value|
			case key
			when :name then return value == @name
			when :artist then return value == @artist
			when :genre then return value == @genre
			when :subgenre then return value == @subgenre
			when :tags then return @tags.index(value)
			when :filter
			else return false
			end
		end
	end
end

class Collection
	attr_accessor :collection
	def initialize(songs_as_string, artist_tags)
		@collection = []
		lines = songs_as_string.split(/\r?\n/)
		lines.each do |line| 
			name, artist, genres, tags = line.split(".")
			genre, subgenre = genres.split(",")
			tags << ", " + genre
			tags << ", " + subgenre if subgenre
			tags << ", " + artist_tags if artist_tags
			song = Song.new(name, artist, genre, subgenre, tags)
			@collection << song
		end
	end
	
	def find(criteria = {})
		@collection.select{|song| song.match?(criteria)}
	end
end