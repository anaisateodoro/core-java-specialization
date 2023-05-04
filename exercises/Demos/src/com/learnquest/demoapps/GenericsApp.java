package com.learnquest.demoapps;

import com.learnquest.demos.Stack;
import com.learnquest.demos.StackArray;
import com.learnquest.demos.transport.Car;
import com.learnquest.demos.transport.SUV;
import com.learnquest.demos.transport.SpeedException;
import com.learnquest.demos.transport.SportsCar;
import com.learnquest.demos.transport.StationWagon;

public class GenericsApp {

	public static Stack<String> makeStackString(Stack<String> strings) {
		strings.push("World");
		strings.push("Hello");
		
		return strings;
	}

	public static Stack<Integer> makeStackInteger(Stack<Integer> ints) {
		ints.push(5);
		ints.push(3);
		ints.push(2);
		ints.push(1);
		ints.push(1);

		return ints;
	}

	public static Stack<SportsCar> makeStackSportsCar(Stack<SportsCar> cars) {
		try {
			cars.push(new SportsCar("Mach I", 250, 21, true));
			cars.push(new SportsCar("Mach II", 250, 21, true));
			cars.push(new SportsCar("Mach III", 250, 21, true));
			cars.push(new SportsCar("Mach IV", 250, 21, true));
			cars.push(new SportsCar("Mach V", 250, 21, true));
		} catch (SpeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cars;
	}

//	public static void printStackRaw(Stack stack) {
//		for (Object e = stack.pop(); e != null ; e = stack.pop()) {
//			System.out.println(e);
//		} 
//	}
//
//	public static void raceStackRaw(Stack stack) {
//		for (Object e = stack.pop(); e != null ; e = stack.pop()) {
//			((SportsCar)e).race();
//		} 
//	}
//
//	public static void printStackObject(Stack<Object> stack) {
//		for (Object e = stack.pop(); e != null ; e = stack.pop()) {
//			System.out.println(e);
//		} 
//	}
//
//	public static void printStackInteger(Stack<Integer> stack) {
//		for (Object e = stack.pop(); e != null ; e = stack.pop()) {
//			System.out.println(e);
//		}
//	}
//	
//	public static void printStackString(Stack<String> stack) {
//		for (Object e = stack.pop(); e != null ; e = stack.pop()) {
//			System.out.println(e);
//		}
//	}
//	
//	public static void printStackSportsCar(Stack<SportsCar> stack) {
//		for (Object e = stack.pop(); e != null ; e = stack.pop()) {
//			System.out.println(e);
//		}
//	}
//	
//	public static void printStackCar(Stack<Car> stack) {
//		for (Object e = stack.pop(); e != null ; e = stack.pop()) {
//			System.out.println(e);
//		}
//	}

	
	public static void printStack(Stack<?> stack) {
		// Explicitly allow Stack of any type, but what else could we
		// safely treat it as, other than Object?
		for (Object e = stack.pop(); e != null ; e = stack.pop()) {
			System.out.println(e);
		}		
	}
	
	public static void setSpeedStackCar(Stack<Car> stack) {
		for (Car e = stack.pop(); e != null ; e = stack.pop()) {
			try {
				e.setSpeed(25);
			} catch (SpeedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}		
	}	

	public static Stack<Car> makeStackCar(Stack<Car> cars) {
		try {
			cars.push(new SportsCar("Mach V", 250, 21, true));
			cars.push(new SUV("Jurassic Explorer"));
		} catch (SpeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cars;
	}
	
	public static void setSpeedStackExtendsCar(Stack<? extends Car> stack) {
		for (Car e = stack.pop(); e != null ; e = stack.pop()) {
			try {
				e.setSpeed(25);
			} catch (SpeedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	

//	public static Stack<? extends Car> makeStackExtendsCar(Stack<? extends Car> cars) {
//		// <? extends X> cannot assign
//		// if this were allowed, we could pass a Stack<SUV> and add a SportsCar to it!
//		cars.push(new SportsCar("Mach V", 250, 21, true));
//		cars.push(new SUV("Jurassic Explorer"));
//
//		return cars;
//	}

	public static Stack<? super Car> makeStackSuperCar(Stack<? super Car> cars) {
		try {
			cars.push(new SportsCar("Mach V", 250, 21, true));
			cars.push(new SUV("Jurassic Explorer"));
		} catch (SpeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return cars;
	}
	
//	public static void setSpeedStackSuperCar(Stack<? super Car> stack) {
//		// <? super X> cannot read
//		// We only know that we've been giving Car or a super class.
//		// We could pass a Stack<Object> and it would be OK.  We do
//		// not know anything about the instances on hand.
//		for (Car e = stack.pop(); e != null ; e = stack.pop()) {
//			e.setSpeed(25);
//		}
//	}

//	public static <T> void loadFromArray(Object[] arr, Stack<T> stack) {
//		for (Object o: arr) {
//			if (o instanceof T) {
//				stack.push((T) o);
//			}
//		}
//	}

	public static <T> Stack<T> loadFromArray(Object[] arr, Class<T> type) {
		Stack<T> stack = new StackArray<>(arr.length);
		for (Object o: arr) {
			if (type.isInstance(o)) {
				stack.push((T) o);
			}
		}
		return stack;
	}

	public static void main(String[] args) {
		// Create stacks of different types
		Stack<Integer> ints = new StackArray<>();
		Stack<String> strings = new StackArray<>();
		Stack<SportsCar> racers = new StackArray<>();
		
		// Print them out raw ... it works
		//printStackRaw(makeStackInteger(ints));
		//printStackRaw(makeStackString(strings));
		//printStackRaw(makeStackSportsCar(racers));

		/// But this is why we use Generics instead of raw types ...
		//raceStackRaw(makeStackInteger(ints));			// blows up
		//raceStackRaw(makeStackString(strings));		// blows up
		// raceStackRaw(makeStackSportsCar(racers));	// actually works

		// So let's switch to Generics, and since Object defines println
		// we can use Stack<Object>, right?   No.
		//printStackObject(makeStackInteger(ints));
		//printStackObkect(makeStackString(strings));
		//printStackObject(makeStackSportsCar(racers));

		// The compiler demands that we have exact matching types
		//printStackInteger(makeStackInteger(ints));
		//printStackString(makeStackString(strings));
		//printStackSportsCar(makeStackSportsCar(racers));
		
		// It won't even let us use Car because we have SportsCar
		//printStackCar(makeStackSportsCar(racers));
		
		// This is becoming way too much work to use Generics, right?
		// But we can use a wildcard, Stack<?>, to fix it.
		printStack(makeStackInteger(ints));
		printStack(makeStackString(strings));
		printStack(makeStackSportsCar(racers));
		
		// The ? wildcard is acting as if it allows anything, but we treat
		// the type as Object, since we know nothing else about it.
		
		// But what if we want to work with Car types generically, e.g.,
		// set the speed, which is not a method of Object?
		Stack<Car> cars = new StackArray<>(10);
		
		// Stack<Car> is OK as an exact match
		setSpeedStackCar(makeStackCar(cars));
		// But, we cannot use Stack<Car> when we have Stack<SportsCar>
		//setSpeedStackCar(makeStackSportsCar(racers));
		
		// So now we learn that wildcards can be "bounded", so that ? isn't
		// just Object, but perhaps something else, like Car.  We can declare
		// that the type is <? extends Car> -- something that EXTENDS Car.
		// And now both are OK.
		setSpeedStackExtendsCar(makeStackCar(cars));
		setSpeedStackExtendsCar(makeStackSportsCar(racers));
		
		// So now let's have a method that will populate a stack of Car types
		// Right now, we have a Stack<Car> *and* a Stack<SportsCar>.  Let's
		// consolidate, and put them both in the Stack<Car> ...
		makeStackCar(cars);
		//makeStackSportsCar(cars);	// incompatible types!

		// OK, so let's do the <? extended Car> that we just learned ...
		// It may look ok HERE, but the method, itself, shows errors!
		// makeStackExtendsCar(cars);

		// Methods using <? extends> can only read not assign
		// We need a new way, <? super Car> to be able to assign
		makeStackSuperCar(cars);	// This works.  <? super Car> can assign
		makeStackSuperCar(new StackArray<Object>());	// Stack<Object> is OK
		//makeStackSuperCar(racers);	// But you can't pass something using a subclass!
		
		// It may look ok HERE, but the method, itself, shows errors!
		//setSpeedStackSuperCar(cars);	// <? super Car> cannot read!
		
		Stack<Car> c = loadFromArray(new Object[] { new SUV(), new SportsCar(), new StationWagon() }, Car.class);
		//Stack<Object> o = loadFromArray(new Object[] { new SUV(), new SportsCar(), new StationWagon() }, Car.class);
		
	}
}
