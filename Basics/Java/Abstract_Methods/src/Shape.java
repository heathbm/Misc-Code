
//create a multilevel hierarchy

// add a constructor to triangle

// a class for two-dimensional objects.
abstract class TwoDShape {
	private double width;
	private double height;
	private String name;
	
	// a default constructor
	TwoDShape(){
		width = height = 0.0;
		name = "none";
	}
	
	// Parameterized constructors
	TwoDShape(double w, double h, String n) {
		width = w;
		height = h;
		name = n;
	}
	
	// constuct object that with equal dimentions
	TwoDShape(double x, String n){
		width = height = x;
		name = n;
	}
	
	//construct an object from an object
	
	TwoDShape(TwoDShape ob) {
		width = ob.width;
		height = ob.height;
		name = ob.name;
	}
	
	//Accessor methods for width and height
	void setWidth(double w) { width = w; }
	void setHeight(double h) { height = h; }
	double getWidth() { return width; }
	double getHeight() { return height; }
	
	String getName() { return name; }
	
	void showDim() {
		System.out.println("Width and height are " + width + " and " + height);
	}
	
	// abstract method
	abstract double area();
	
}

// a subclass of TwoDShpae for triangles
class Triangle extends TwoDShape {
	private String style;
	
	//default constructor
	Triangle() {
		super();
		
		style = "none";
	}
	
	//constructor for triangle
	Triangle( String s, double w, double h) {
		super(w, h, "Triangle"); // call super class constructors
		
		style = s;
	}
	
	//one argument constructor
	Triangle(double x) {
		super(x, "triangle"); //call superclass constructor
		
		style = "filled";
	}
	
	//Construct an object from an object 
	Triangle(Triangle ob) {
		super(ob); // pass object to TwoDShape constructors
		
		style = ob.style;
	}
	
	//override area() for triangle 
	double area() {
		return getWidth() * getHeight() / 2;
	}
	
	void showStyle() {
		System.out.println("Triangle is " + style);
	}
}

//a subclass of TwoDShape for circles
class Circle extends TwoDShape {
	
	Circle(double x) {
		super(x, "Triangle");
	}

	@Override
	double area() {
		return Math.PI * (getHeight() * getHeight());
	}
	
}

//extend triangle
class ColorTriangle extends Triangle {
	private String color;
	
	ColorTriangle(String c, String s, double w, double h) {
		super(s, w, h);
		
		color = c;
	}
	
	String getColor() { return color; }
	
	void showColor() {
		System.out.println("Color is " + color);
	}
}

//A subclass of TwoDShape for rectangles 
class Rectangle extends TwoDShape {
	// a default constructor 
	Rectangle() {
		super();
	}
	
	//constructor for rectangle 
	Rectangle(double w, double h) {
		super(w, h, "rectangle"); // call superclass cpnstructor
	}
	
	//construct a square 
	Rectangle(double x) {
		super(x, "rectangle"); // call superclass constructor
	}
	
	//construct an object from an object 
	Rectangle(Rectangle ob) {
		super(ob); // pass object to TwoDShape constructor
	}
	
	boolean isSquare() {
		if(getWidth() == getHeight()) return true;
		return false;
	}
	
	//override area() for Rectangle 
	double area() {
		return getWidth() * getHeight();
	}
}
public class Shape {

	public static void main(String[] args) {
		
			//////// OLD MAIN ////////
		 
		/* Triangle t1 = new Triangle();
		Triangle t2 = new Triangle("outlined", 8.0, 12.0);
		Triangle t3 = new Triangle(4.0);
		Triangle t4 = new Triangle();
		ColorTriangle t5 = new ColorTriangle("blue" ,"outlined", 8.0, 12.0);
		ColorTriangle t6 = new ColorTriangle("Red" , "Filled", 2.0, 2.0);
		
		t4 = t2;
		
		System.out.println("Info for t1: ");
		t1.showStyle();
		t1.showDim();
		System.out.println("Area is " + t1.area());
		
		System.out.println();
		
		System.out.println("Info for t2: ");
		t2.showStyle();
		t2.showDim();
		System.out.println("Area is " + t2.area());
		
		System.out.println();
		
		System.out.println("Info for t3: ");
		t3.showStyle();
		t3.showDim();
		System.out.println("Area is " + t3.area());
		
		System.out.println();
		
		System.out.println("Info for t4: ");
		t4.showStyle();
		t4.showDim();
		System.out.println("Area is " + t4.area());
		
		System.out.println();
		
		System.out.println("Info for t5: ");
		t5.showStyle();
		t5.showDim();
		t5.showColor();                                 //via color method
		System.out.println("Area is " + t5.area());
		
		System.out.println();
		
		System.out.println("Info for t6: ");
		t6.showStyle();
		t6.showDim();
		String colort = t6.getColor();                  //via getter
		System.out.println("Color is " + colort);
		System.out.println("Area is " + t6.area()); */
		
		////// NEW MAIN //////
		
		TwoDShape shapes[] = new TwoDShape[4];
		
		shapes[0] = new Triangle("outlined", 8.0, 12.0);
		shapes[1] = new Rectangle(10);
		shapes[2] = new Rectangle(10, 4);
		shapes[3] = new Triangle(7.0);
		
		for(int i = 0; i < shapes.length; i++) {
			System.out.println("object is " + shapes[i].getName());
			System.out.println("Area is " + shapes[i].area());
			System.out.println();
			
		}	
			
		Circle circ1 = new Circle(5);
		
		double radius = circ1.getWidth();
		
		System.out.println("The radius is: " + radius);
		
		double area = circ1.area();
		
		System.out.println("The area of circ1 is: " + area);
		}

}


