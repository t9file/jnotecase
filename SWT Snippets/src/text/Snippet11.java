package text;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class Snippet11 {

public static void main (String [] args) {
	Display display = new Display ();
	Shell shell = new Shell (display);
	Text text = new Text (shell, SWT.BORDER | SWT.V_SCROLL);
	Rectangle clientArea = shell.getClientArea ();
	text.setBounds (clientArea.x + 10, clientArea.y + 10, 100, 100);
	for (int i=0; i<16; i++) {
		text.append ("Line " + i + "\n");
	}
	shell.open ();
	text.setSelection (30);
	System.out.println ("selection=" + text.getSelection ());
	System.out.println ("caret position=" + text.getCaretPosition ());
	System.out.println ("caret location=" + text.getCaretLocation ());
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
}
