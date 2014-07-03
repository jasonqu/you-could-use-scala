##Basics
###Hello World

#####JAVA
	System.out.println("Hello, world!");
#####SCALA
	println("Hello, world!")

###Variables And Constants

#####JAVA
	int myVariable = 42;
	myVariable = 50;
	final int myConstant = 42;
	
	// static type
	String myStringVariable = "42";
	myStringVariable = 42; // compile error

#####SCALA
	var myVariable = 42
	myVariable = 50
	val myConstant = 42
	
	// static type
	val myStringVariable = "42"
	myStringVariable = 42 // compile error

###Explicit Types

#####JAVA
	double explicitDouble = 70;
#####SCALA
	val explicitDouble: Double = 70
###Type Coercion

#####JAVA
	String label = "The width is ";
	int width = 94;
	String widthLabel = label + width;
#####SCALA
	val label = "The width is "
	val width = 94
	val widthLabel = label + width
	String Interpolation

#####JAVA
	int apples = 3;
	int oranges = 5;
	String fruitSummary = "I have " + (apples + oranges) + 
	                   "pieces of fruit.";
#####SCALA
	val apples = 3
	val oranges = 5
	val fruitSummary = s"I have ${apples + oranges} " +
	                   " pieces of fruit."
###Range Operator

#####JAVA
	String names = new String[]{"Anna", "Alex", "Brian", "Jack"};
	int count = names.length;
	for (int i = 0; i < count; i++) {
	  System.out.println("Person " + (i + 1) + " is called " + names[i]);
	}
	// Person 1 is called Anna
	// Person 2 is called Alex
	// Person 3 is called Brian
	// Person 4 is called Jack
#####SCALA
	val names = Array("Anna", "Alex", "Brian", "Jack")
	val count = names.length
	for (i <- 0 until count) {
	  println(s"Person ${i + 1} is called ${names(i)}")
	}
	// Person 1 is called Anna
	// Person 2 is called Alex
	// Person 3 is called Brian
	// Person 4 is called Jack
###Inclusive Range Operator

#####JAVA
	for (int i = 0; i <= 5; i++) {
	  println(i + " times 5 is " + i * 5);
	}
	// 1 times 5 is 5
	// 2 times 5 is 10
	// 3 times 5 is 15
	// 4 times 5 is 20
	// 5 times 5 is 25
#####SCALA
	for (index <- 1 to 5) {
	  println(s"$index times 5 is ${index * 5}")
	}
	// 1 times 5 is 5
	// 2 times 5 is 10
	// 3 times 5 is 15
	// 4 times 5 is 20
	// 5 times 5 is 25
##COLLECTIONS
###Arrays

#####JAVA
	String shoppingList = new String[]{"catfish", "water",
	  "tulips", "blue paint"};
	shoppingList[1] = "bottle of water";
#####SCALA
	var shoppingList = Array("catfish",
	  "water", "tulips", "blue paint")
	shoppingList(1) = "bottle of water"
###Maps

#####JAVA
	// java map could initial with values, but be careful
	// because it creates a new class that inherits from HashMap
	// http://stackoverflow.com/questions/6802483/how-to-directly-initialize-a-hashmap-in-a-literal-way
	HashMap<String, String> occupations = new HashMap<String, String>(){{
	  put("Malcolm", "Captain");
	  put("Kaylee", "Mechanic");
	}}; 
	occupations.put("Jayne", "Public Relations");

#####SCALA
	var occupations = scala.collection.mutable.Map(
	  "Malcolm" -> "Captain",
	  "Kaylee" -> "Mechanic"
	)
	occupations("Jayne") = "Public Relations"
###Empty Collections

#####JAVA
	String[] emptyArray = new String[]{};
	Map<String, Float> emptyDictionary = Collections.emptyMap();
	// type must be specified
	Object emptyArrayNoType = new Object[]{};
#####SCALA
	val emptyArray = Array[String]()
	val emptyDictionary = Map[String, Float]()
	val emptyArrayNoType = Array()
##FUNCTIONS
###Functions

#####JAVA
	// in java, you have to use class
	class Util {
	  static String greet(String name, String day) = {
	    return "Hello " + name +", today is " + day + ".";
	  }
	}
	System.out.println(Util.greet("Bob", "Tuesday"));
#####SCALA
	def greet(name: String, day: String): String = {
	  return s"Hello $name, today is $day."
	}
	greet("Bob", "Tuesday")
###Tuple Return

#####JAVA
	// java has no tuple, have to create yourself
	class GasPrices {
	  public double min;
	  public double avg;
	  public double max;
	  public GasPrices(double min, double avg, double max) {
	    this.min = min;
	    this.avg = avg;
	    this.max = max;
	  }
	  public static GasPrices getGasPrices() = {
	    return new GasPrices(3.59, 3.69, 3.79);
	  }
	}
#####SCALA
	def getGasPrices(): (Double, Double, Double) = {
	    return (3.59, 3.69, 3.79)
	}
###Variable Number Of Arguments

#####JAVA
	int sumOf(int... numbers) {
	  int sum = 0;
	  for (int number : numbers) {
	    sum += number;
	  }
	  return sum;
	}
	sumOf(42, 597, 12);
#####SCALA
	def sumOf(numbers: Int*): Int = {
	  var sum = 0
	  for (number <- numbers) {
	    sum += number
	  }
	  return sum
	}
	sumOf(42, 597, 12)
###Function Type

#####JAVA
	// have to use strategy_pattern in java
	// http://www.tutorialspoint.com/design_pattern/strategy_pattern.htm
	public interface Strategy {
	  public int addOne(int num);
	}
	
	public class OperationAddOne implements Strategy{
	  @Override
	  public int addOne(int num) {
	    return num1 + 1;
	  }
	}
	
	public class Context {
	  private Strategy strategy;
	  
	  public Context(Strategy strategy){
	    this.strategy = strategy;
	  }
	
	  public Strategy makeIncrementer(){
	    return strategy;
	  }
	}
	
	public static void main(String[] args) {
	  Context c = new Context(new OperationAddOne());
	  Strategy s = c.makeIncrementer();  
	  System.out.println(s.addOne(7));
	}
#####SCALA
	def makeIncrementer(): Int => Int = {
	  def addOne(number: Int): Int = {
	    return 1 + number
	  }
	  return addOne
	}
	var increment = makeIncrementer()
	increment(7)
###Map

#####JAVA
	int[] numbers = new int[]{20, 19, 7, 12};
	int[] triples = new int[numbers.length];
	for(int i = 0; i < numbers.length; i++) {
	  triples[i] = numbers[i] * 3;
	}
#####SCALA
	var numbers = Array(20, 19, 7, 12)
	numbers.map( number => 3 * number )
###Sort

#####JAVA
	// use Integer in order to sort in descending order
	Integer[] intArray = new Integer[] { 1, 5, 3, 12, 2 };
	Arrays.sort(intArray, Collections.reverseOrder());
#####SCALA
	Array(1, 5, 3, 12, 2).sortWith(_ > _)
###Named Arguments

#####JAVA
	int area(int width, int height) {
	  return width * height;
	}
	// have to invoke in order
	area(11, 10);
#####SCALA
	def area(width: Int, height: Int): Int = {
	  return width * height
	}
	
	// invoke by name
	area(height = 10, width = 11)
##CLASSES
###Declaration

#####JAVA
	public class Shape {
	  public int numberOfSides = 0;
	  public String simpleDescription() {
	    return "A shape with " + numberOfSides + " sides.";
	  }
	}
#####SCALA
	class Shape {
	  var numberOfSides = 0
	  def simpleDescription(): String = {
	    return s"A shape with $numberOfSides sides."
	  }
	}
###Usage

#####JAVA
	Shape shape = Shape();
	shape.numberOfSides = 7;
	String shapeDescription = shape.simpleDescription();
#####SCALA
	var shape = new Shape()
	shape.numberOfSides = 7
	var shapeDescription = shape.simpleDescription()
###Subclass

#####JAVA
	public class NamedShape {
	  public int numberOfSides = 0;
	  public String name;
	
	  public NamedShape(String name) {
	    this.name = name;
	  }
	
	  public String simpleDescription() {
	    return "A shape with " + numberOfSides + " sides.";
	  }
	}
	
	public class Square extends NamedShape {
	  Double sideLength;
	
	  public Square(Double sideLength, String name) {
	    this.sideLength = sideLength;
	    super(name);
	    numberOfSides = 4;
	  }
	
	  public Double area() {
	    return sideLength * sideLength;
	  }
	
	  public String simpleDescription() {
	    return "A square with sides of length " + sideLength;
	  }
	}

	Square test = new Square(5.2, "my test square");
	test.area();
	test.simpleDescription();
#####SCALA
	class NamedShape(var name: String) {
	  var numberOfSides: Int = 0
	
	  def simpleDescription() =
	    s"A shape with $numberOfSides sides."
	}
	
	class Square(var sideLength: Double, name: String)
	  extends NamedShape(name) {
	  numberOfSides = 4
	  def area() = sideLength * sideLength
	
	  override def simpleDescription() =
	    s"A square with sides of length $sideLength."
	}
	
	val test = new Square(5.2, "my test square")
	test.area()
	test.simpleDescription()
###Checking Type

#####JAVA
	int movieCount = 0;
	int songCount = 0;
	 
	for (Item item : library) {
	  if(item instanceof Movie) {
	    ++movieCount;
	  } else if (item instanceof Song) {
	    ++songCount;
	  }
	}
#####SCALA
	var movieCount = 0
	var songCount = 0
	 
	for (item <- library) {
	  if (item.isInstanceOf[Movie]) {
	    movieCount += 1
	  } else if (item.isInstanceOf[Song]) {
	    songCount += 1
	  }
	}
###Downcasting

#####JAVA
	for (Object object : someObjects) {
	  Movie movie = (Movie) object; 
	  System.out.println("Movie: " + movie.name + ", dir. " + movie.director);
	}
#####SCALA
	for (obj <- someObjects) {
	  val movie = obj.asInstanceOf[Movie]
	  println(s"Movie: '${movie.name}', dir. ${movie.director}")
	}
###Protocol

#####JAVA

#####SCALA
	trait Nameable {
	  def name(): String
	}
	
	def f[T <: Nameable](x: T) = {
	  println("Name is " + x.name())
	}
###Extensions

#####JAVA

#####SCALA
	object Extensions {
	  implicit class DoubleUnit(d: Double) {
	    def km: Double = { return d * 1000.0 }
	    def m: Double = { return d }
	    def cm: Double = { return d / 100.0 }
	    def mm: Double = { return d / 1000.0 }
	    def ft: Double = { return d / 3.28084 }
	  }
	}
	
	import Extensions.DoubleUnit
	
	val oneInch = 25.4.mm
	println(s"One inch is $oneInch meters")
	// prints "One inch is 0.0254 meters"
	val threeFeet = 3.ft
	println(s"Three feet is $threeFeet meters")
	// prints "Three feet is 0.914399970739201 meters"

