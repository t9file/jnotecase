package program;

import org.eclipse.swt.program.*;
import org.eclipse.swt.widgets.*;

public class Snippet30 {

public static void main (String [] args) {
	Display display = new Display ();
	Program p = Program.findProgram (".txt");
	if (p != null) p.execute ("newfile");
	display.dispose ();
}

} 
