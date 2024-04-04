
class BoxClass {
   int length;
    int width;
    int height;

    BoxClass () {
        length = 0;
        width = 0;
        height = 0;
    }
    
    BoxClass(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    int volume() {
        return length * width * height;
    }
    
}

public class Box{
    public static void main(String[] args) {
        BoxClass b1 = new BoxClass();
        BoxClass b2 = new BoxClass(2, 3, 4);
        System.out.println(b1.volume());
        System.out.println(b2.volume());
    }
}

