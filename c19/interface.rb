class NoImplementedError
end

class MyInterface
	private
	
	def initialize
		throw NoImplementedError
	end
	
	def a
		throw NoImplementedError
	end
end

class Derivative < MyInterface
	def initialize
	
	end
	
	def a
	
	end
end

a = Derivative.new
