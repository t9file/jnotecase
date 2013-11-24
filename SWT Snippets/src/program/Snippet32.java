package program;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.program.*;

public class Snippet32 {

public static void main (String [] args) {
	Display display = new Display ();
	Shell shell = new Shell (display);
	Label label = new Label (shell, SWT.NONE);
	label.setText ("Can't find icon for .bmp");
	Image image = null;
	Program p = Program.findProgram (".bmp");
	if (p != null) {
		ImageData data = p.getImageData ();
		if (data != null) {
			image = new Image (display, data);
			label.setImage (image);
		}
	}
	label.pack ();
	shell.pack ();
	shell.open ();
	while (!shell.isDisposed()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	if (image != null) image.dispose ();
	display.dispose ();
}

} 
