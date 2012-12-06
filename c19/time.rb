module TimeConvertions
	def seconds
		self
	end
	
	def minutes
		self.seconds * 60
	end
	
	def hours
		self.minutes * 60
	end
	
	def days
		self.hours * 24
	end
	
	def weeks
		self.days * 7
	end
	
	alias :second :seconds
	alias :hour :hours
	alias :day :days
	alias :week :weeks
end

class Bignum
	include TimeConvertions
end

class Fixnum
	include TimeConvertions
end

class Float
	include TimeConvertions
end

module HelloWorld
	def hello_world
		"Hello World!" 
	end
end

class String
	extend HelloWorld
end
puts String.hello_world
puts 1.week
puts (3.14).minutes
puts 6487216843809563425643278564327598634279856432565454651618179814234565485642586423576234598723465024835842708956724485643280564850460285623485042356740359432658708642350872463574239856802859742308594375806243578423528340750846252346754082957428359672378450087518458742365045462305623450524594375226937619378356923478562974361578153425774367534798563498725634789657945624356987934275673496534978534279.weeks








