content = File.read("Regular_expression.html")
result = content.scan(/<a\s+href=\".*?\"/)
result.each do |r|
	p r[9..-2]
end
p result.length
