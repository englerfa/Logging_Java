package aop;


public class Image {
	public static void main(String[] args) {
		System.out.println("Starting* " + Math.sin(5));
		printSlope();
	}
	
	
	public static void printSlope() {
		int width = 600;
		Window window = new Window("Slope", width, width);
		window.open();
		window.fillCircle(300, 300, 20);
		
		// create slope
		for(int i=0; i<width; i++) {
			int strokeDepthSlope = 1;
			window.fillCircle(i, 300+100*Math.sin(i*2*Math.PI/width), strokeDepthSlope);
		}
		
		
		while(window.isOpen()) {
			
			
			window.refresh();
		}
		
	}

}
