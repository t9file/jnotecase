package display;

import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.layout.*;

public class Snippet268 {

public static void main(String[] args) {
	final Display display = new Display();
	Shell shell = new Shell(display);
	shell.setLayout(new FillLayout());
	StyledText styledText = new StyledText(shell, SWT.V_SCROLL);
	String multiLineString = "";
	for (int i = 0; i < 200; i++) {
		multiLineString = multiLineString.concat("This is line number " + i + " in the multi-line string.\n");
	}
	styledText.setText(multiLineString);
	shell.setSize(styledText.computeSize(SWT.DEFAULT, 400));
	shell.open();
	styledText.addListener(SWT.MouseWheel, new Listener() {
		@Override
		public void handleEvent(Event e){
			System.out.println("Mouse Wheel event " + e);
		}
	});
	new Thread(){
		Event event;
		@Override
		public void run() {
			for (int i = 0; i < 50; i++) {
				event = new Event();
				event.type = SWT.MouseWheel;
				event.detail = SWT.SCROLL_LINE;
				event.count = -2;
				if (!display.isDisposed()) display.post(event);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {}
			}
		}	
	}.start();
	while (!shell.isDisposed()) {
		if (!display.readAndDispatch()) display.sleep();
	}
	display.dispose();
}
}
