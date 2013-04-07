##Class: 11b
##Number: 6
##Name: Bozhidar Giorev
##task - https://docs.google.com/document/d/1waNU1ecWvyiarK0FFe5pnq88GBBuKO_PLX_TStnL_BM/edit
class Array
	def to_hash
		Hash[*self.flatten]
	end
	
	def index_by 
		hash = self.map {|value| [yield(value), value]}
	end
	
	def subarray_count(subarray)
		count = 0
		self.each_cons(subarray.length) {|x| (x == subarray)? (count = count + 1) : ()}
		count
	end
	
	def occurences_count
		array = self.uniq
		hash = array.map {|value| [value,self.count(value)] }
	end
	
	def densities
		map {|item| count item }
	end
end