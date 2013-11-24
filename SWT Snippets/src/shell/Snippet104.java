package shell;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

public class Snippet104 {

public static void main(String[] args) {
	final Display display = new Display();
	final int [] count = new int [] {4};
	final Image image = new Image(display, 300, 300);
	GC gc = new GC(image);
	gc.setBackground(display.getSystemColor(SWT.COLOR_CYAN));
	gc.fillRectangle(image.getBounds());
	gc.drawText("Splash Screen", 10, 10);
	gc.dispose();
	final Shell splash = new Shell(SWT.ON_TOP);
	final ProgressBar bar = new ProgressBar(splash, SWT.NONE);
	bar.setMaximum(count[0]);
	Label label = new Label(splash, SWT.NONE);
	label.setImage(image);
	FormLayout layout = new FormLayout();
	splash.setLayout(layout);
	FormData labelData = new FormData ();
	labelData.right = new FormAttachment (100, 0);
	labelData.bottom = new FormAttachment (100, 0);
	label.setLayoutData(labelData);
	FormData progressData = new FormData ();
	progressData.left = new FormAttachment (0, 5);
	progressData.right = new FormAttachment (100, -5);
	progressData.bottom = new FormAttachment (100, -5);
	bar.setLayoutData(progressData);
	splash.pack();
	Rectangle splashRect = splash.getBounds();
	Rectangle displayRect = display.getBounds();
	int x = (displayRect.width - splashRect.width) / 2;
	int y = (displayRect.height - splashRect.height) / 2;
	splash.setLocation(x, y);
	splash.open();
	display.asyncExec(new Runnable() {
		@Override
		public void run() {
			Shell [] shells = new Shell[count[0]];
			for (int i=0; i<count[0]; i++) {
				shells [i] = new Shell(display);
				shells [i].setSize (300, 300);
				shells [i].addListener(SWT.Close, new Listener() {
					@Override
					public void handleEvent (Event e) {
						--count[0];
					}
				});
				bar.setSelection(i+1);
				try {Thread.sleep(1000);} catch (Throwable e) {}
			}
			splash.close();
			image.dispose();
			for (int i=0; i<count[0]; i++) {
				shells [i].open();
			}
		}
	});
	while (count [0] != 0) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose();
}

}
