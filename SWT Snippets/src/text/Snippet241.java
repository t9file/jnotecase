package text;

import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class Snippet241 {

public static void main(String [] args) {
	Display display = new Display();
	Shell shell = new Shell(display);
	shell.setBounds(10,10,200,200);
	Text text1 = new Text(shell, SWT.MULTI | SWT.WRAP);
	Rectangle clientArea = shell.getClientArea();
	text1.setBounds(clientArea.x+10,clientArea.y+10,150,50);
	text1.setText("Tab will traverse out from here.");
	text1.addTraverseListener(new TraverseListener() {
		@Override
		public void keyTraversed(TraverseEvent e) {
			if (e.detail == SWT.TRAVERSE_TAB_NEXT || e.detail == SWT.TRAVERSE_TAB_PREVIOUS) {
				e.doit = true;
			}
		}
	});
	Text text2 = new Text(shell, SWT.MULTI | SWT.WRAP);
	text2.setBounds(10,100,150,50);
	text2.setText("But Tab will NOT traverse out from here (Ctrl+Tab will).");
	shell.open();
	while (!shell.isDisposed()) {
		if (!display.readAndDispatch()) display.sleep();
	}
	display.dispose();
}
}
