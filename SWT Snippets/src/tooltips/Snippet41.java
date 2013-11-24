package tooltips;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class Snippet41 {

public static void main (String [] args) {
	String string = "This is a string\nwith a new line.";
	Display display = new Display ();
	Shell shell = new Shell (display);
	TabFolder folder = new TabFolder (shell, SWT.BORDER);
	Rectangle clientArea = shell.getClientArea ();
	folder.setBounds (clientArea.x, clientArea.y, 200, 200);
	TabItem item0 = new TabItem (folder, 0);
	item0.setText ("tab item");
	item0.setToolTipText ("TabItem toolTip: " + string);
	ToolBar bar = new ToolBar (shell, SWT.BORDER);
	bar.setBounds (clientArea.x, clientArea.y + 200, 200, 40);
	ToolItem item1 = new ToolItem (bar, SWT.PUSH);
	item1.setText ("tool item");
	item1.setToolTipText ("ToolItem toolTip: " + string);
	shell.setToolTipText ("Shell toolTip: " + string);
	shell.open ();
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
} 
