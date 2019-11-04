package p1;
//将计算图形面积和周长的功能定义为对外接口
interface IShape{
	double PI = 3.1415926;
	abstract double getArea();
	abstract double getPerimeter();
}
 class Circle implements IShape{
	double radius;
	Circle (double radius)
	{
		this.radius = radius;
	}
	public double getArea()
	{
		return PI*radius*radius;
	}
	public double getPerimeter()
	{
		return PI*2*radius;
	}
 }
 class Rectangle implements IShape{
		double width,height;
		Rectangle (double width,double height)
		{
			this.width = width;
			this.height = height;
		}
		public double getArea()
		{
			return width*height;
		}
		public double getPerimeter()
		{
			return (width+height)*2;
		}
}
 class Triangle implements IShape{
		double a,b,c;
		Triangle(double a,double b,double c)
		{
			this.a = a;
			this.b = b;
			this.c = c;
		}
		public double getArea()
		{
			double s = 0.5*(a+b+c);
			return Math.sqrt(s*(s-a)*(s-b)*(s-c));
		}
		public double getPerimeter()
		{
			return a+b+c;
		}
	}
public class Test11_4 {
public static void main(String[] args) {
	Circle o1 = new Circle(10);
	System.out.println("Circle Area="+o1.getArea()+",Perimeter="+o1.getPerimeter());
	Rectangle o2 = new Rectangle(10,20);
	System.out.println("Rectangle Area="+o2.getArea()+",Perimeter="+o2.getPerimeter());
	Triangle o3 = new Triangle(3,4,5);
	System.out.println("Triangle Area="+o3.getArea()+",Perimeter="+o3.getPerimeter());
}
}
