package text;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class Snippet22 {

public static void main (String [] args) {
	Display display = new Display ();
	Shell shell = new Shell (display);
	Text text = new Text (shell, 0);
	text.setText ("ASDF");
	Rectangle clientArea = shell.getClientArea ();
	text.setBounds (clientArea.x, clientArea.y, 64, 32);
	text.selectAll ();
	shell.pack ();
	shell.open ();
	while (!shell.isDisposed()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
} 
