package display;

import org.eclipse.swt.widgets.*;

public class Snippet42 {

public static void main (String [] args) {
	Display display = new Display ();
	System.out.println ("Display Bounds=" + display.getBounds () + " Display ClientArea=" + display.getClientArea ());
	display.dispose ();
}
} 
