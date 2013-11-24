package text;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class Snippet55 {

public static void main (String [] args) {
	Display display = new Display ();
	Shell shell = new Shell (display);
	Text text = new Text (shell, SWT.BORDER);
	Rectangle clientArea = shell.getClientArea ();
	text.setLocation (clientArea.x, clientArea.y);
	int columns = 10;
	GC gc = new GC (text);
	FontMetrics fm = gc.getFontMetrics ();
	int width = columns * fm.getAverageCharWidth ();
	int height = fm.getHeight ();
	gc.dispose ();
	text.setSize (text.computeSize (width, height));
	shell.pack ();
	shell.open ();
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
} 
