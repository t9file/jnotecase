package directorydialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

public class Snippet33 {

public static void main (String [] args) {
	Display display = new Display ();
	Shell shell = new Shell (display);
	shell.open ();
	DirectoryDialog dialog = new DirectoryDialog (shell);
	String platform = SWT.getPlatform();
	dialog.setFilterPath (platform.equals("win32") || platform.equals("wpf") ? "c:\\" : "/");
	System.out.println ("RESULT=" + dialog.open ());
	while (!shell.isDisposed()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}

} 
