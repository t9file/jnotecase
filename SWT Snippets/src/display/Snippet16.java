package display;

import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class Snippet16 {

public static void main (String [] args) {
	final Display display = new Display ();
	final Shell shell = new Shell (display);
	final int time = 500;
	Runnable timer = new Runnable () {
		@Override
		public void run () {
			if (shell.isDisposed()) return;
			Point point = display.getCursorLocation ();
			Rectangle rect = shell.getBounds ();
			if (rect.contains (point)) {
				System.out.println ("In");
			} else {
				System.out.println ("Out");
			}
			display.timerExec (time, this);
		}
	};
	display.timerExec (time, timer);
	shell.setSize (200, 200);
	shell.open ();
	while (!shell.isDisposed()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();	
}
} 
