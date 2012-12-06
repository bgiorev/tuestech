module Lights
	def turn_lights_on
		@on = true
	end
	
	def turn_lights_off
		@on = false
	end
	
	def lights_on?
		@on
	end
end

module Vehicle
	class VehicleBase
		def initialize speed
			@speed = speed
			@traveled = 0
		end
		
		def print_speed
			puts @speed
		end
		
		def start
			@start_time = Time.now
		end
		
		def stop
			@traveled += @speed * (Time.now - @start_time)
		end	
		
		def print_traveled
			puts @traveled
		end
	end
	
	class Car < VehicleBase
		include Lights
		
		def initialize
			super(100)
		end
		
		def honk
			puts horn
		end
		
		private
		def horn
			"Beep beep"
		end
	end
	
	class Bike < VehicleBase
		def initialize
			super(10)
		end
	end
end


car = Vehicle::Car.new
car.turn_lights_on
puts car.lights_on?
car.print_speed
car.start
car.honk
#sleep(10)
car.stop
car.print_traveled	
car.turn_lights_off
puts car.lights_on?

module Vehicles
	class Car < Vehicle::VehicleBase
		include Lights
		def initialize
			super(10)
		end
		
		def start
			@start_time = Time.now
			turn_lights_on
		end
		
		def stop
			turn_lights_off
			@traveled += @speed * (Time.now - @start_time)
		end
	end
end

c2 = Vehicles::Car.new
c2.start
puts c2.lights_on?
