package javaLAB.exp2;
class b {
   public
      double length;   // Length of a box
      double breadth;  // Breadth of a box
      double height;   // Height of a box
        Box()
	{
	length=5;
	breadth=7;
	height=9;
	}
      
	Box(int a,int b,int c)
	{
		length=a;
		breadth=b;
		height=c;
	}
	
      void volume()
	{
		System.out.println("Volume="+length*breadth*height);
	}
};


class JavaApplication1 {
  public static void main(String args[]) {
    // declare, allocate, and initialize Box objects
    Box mybox1 = new Box();
    Box mybox2 = new Box(3, 6, 9);
 
    double vol;
 
    // get volume of first box
    mybox1.volume();
  //  System.out.println("Volume is " + vol);
 
    // get volume of second box
   mybox2.volume();
 //   System.out.println("Volume is " + vol);
  }
}
