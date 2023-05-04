package com.learnquest.demoapps;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

import com.learnquest.demos.transport.Car;
import com.learnquest.demos.transport.SUV;
import com.learnquest.demos.transport.SpeedException;
import com.learnquest.demos.transport.SportsCar;
import com.learnquest.demos.transport.StationWagon;
import com.learnquest.demos.transport.Train;
import com.learnquest.demos.transport.Vehicle;


public class VehicleApp {

	public static void race(Object[] raceCars) {
		for (Object raceCar: raceCars) {
			if (raceCar instanceof SportsCar) {
				SportsCar racer = (SportsCar) raceCar;
				racer.race();
			}
		}
	}

	
	public static void race(SportsCar[] raceCars) {
		for (SportsCar raceCar: raceCars) {
			raceCar.race();
		}
	}
	
	
	public static void race(Collection<SportsCar> raceCars) {
		for (SportsCar raceCar: raceCars) {
				raceCar.race();
		}
	}

	
	public static List<Vehicle> populate() {
		List<Vehicle> vehicles = new ArrayList<>();
		
		try {
			Car car54 = new SportsCar();

			car54.setName("Car 54");
			car54.setSpeed(20);
			car54.setGasoline(20);
			car54.setManufactured(LocalDate.of(1961, 9,  17));
			
			vehicles.add(car54);
		}
		catch (SpeedException e) {
			e.printStackTrace();
		}
		
		try {
			Car mach5 = new SportsCar("Mach V", 250, 21, true);
			mach5.setManufactured(LocalDate.of(1967, 4, 2));
			// mach5.setTirePressures(32, 32, 40, 50);
			// mach5.setTirePressures(new int[]{32, 32, 40, 50});
			
			vehicles.add(mach5);
		} catch (SpeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			StationWagon wagon = new StationWagon("Wagon Queen Family Truckster");
			wagon.setManufactured(LocalDate.of(1979, 7, 29));
			wagon.setCurrentCargoLoad(500);
			wagon.setSpeed(75);
			
			vehicles.add(wagon);
		} catch (SpeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			SUV suv = new SUV("Jurassic Explorer");
			suv.setManufactured(LocalDate.of(1993, 6, 11));
			suv.setCurrentCargoLoad(500);
			suv.setSpeed(25);
			
			vehicles.add(suv);
		} catch (SpeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		// Type reference = new Class(...)
		SportsCar sc = new SportsCar();
		Car c = sc;
		sc.race();
		c.race();
		*/
		
		Train train = new Train("City of New Orleans");
		vehicles.add(train);
		
		return vehicles;
	}

	
	public static void main(String[] args) {
		/*
		for (Vehicle vehicle: new Vehicle[]{ car54, mach5, wagon, suv, train }) {
			if (vehicle instanceof SportsCar) {
				((SportsCar) vehicle).race();   // shortcut rather than SportsCar sc = (SportsCar) car
			} else {
				Vehicle.travelAtSpeedLimit(vehicle);
			}
			System.out.println(vehicle);
		}
		*/
		
		List<Vehicle> vehicles = populate();

//		vehicles.forEach(vehicle -> {
//			if (vehicle instanceof SportsCar) ((SportsCar) vehicle).race();
//			else Vehicle.travelAtSpeedLimit(vehicle);
//			System.out.println(vehicle);
//		});
//
//		// Show method reference as shorthand
//
//		vehicles.forEach(Vehicle::travelAtSpeedLimit);
//		vehicles.forEach(System.out::println);
//
//		// More method reference.  Compiler figures out what to do
//
//		vehicles.forEach(Vehicle::stop);
//		vehicles.forEach(System.out::println);
//
//		// Otherwise, just go with fleshed out lambdas
//
//		vehicles.forEach(vehicle -> vehicle.setSpeed(25));
//		vehicles.forEach(vehicle -> System.out.printf("%s is traveling at %d mph%n", vehicle.getName(), vehicle.getSpeed()));

		Consumer<Vehicle> go25 = vehicle -> {
			try {
				vehicle.setSpeed(25);
			} catch (SpeedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		vehicles.forEach(go25.andThen(System.out::println));

		Collection<Integer> speeds = Arrays.asList(15, 25, 35, 55, 70);
		Consumer<Vehicle> stop = Vehicle::stop;

		speeds.forEach(speed -> {
			Consumer<Vehicle> setSpeed = vehicle -> {
				try {
					vehicle.setSpeed(speed);
				} catch (SpeedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
			vehicles.forEach(setSpeed.andThen(System.out::println));
			Consumer<Vehicle> speedAndPrint = setSpeed.andThen(System.out::println);
			vehicles.forEach(speedAndPrint.andThen(stop).andThen(System.out::println));
		});
	}
}
