require "csv"
ARGV.each do |a|
    CSV.open("#{a}_result.csv","wb") do |csv|
        CSV.foreach("#{a}") do |row|
            csv<<[ row[0], row[1], rand(row[1].to_i/2)+row[1].to_i ]
        end
    end
end