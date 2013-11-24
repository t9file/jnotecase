package tree;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Snippet302 {
	public static void main (String [] args) {
		Display display = new Display ();
		Shell shell = new Shell (display);
		FillLayout layout = new FillLayout();
		layout.marginHeight = 10;
		layout.marginWidth = 10;
		shell.setLayout(layout);
		Tree tree = new Tree (shell, SWT.BORDER | SWT.NO_SCROLL);
		for (int i=0; i<10; i++) {
			TreeItem item = new TreeItem (tree, SWT.NONE);
			item.setText ("Item " + i);
		}
		shell.pack ();
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}
}
