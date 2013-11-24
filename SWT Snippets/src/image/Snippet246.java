package image;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.widgets.*;

public class Snippet246 {

	public static void main(String[] args) {
		Display display = new Display();
		Font font = new Font(display, "Comic Sans MS", 24, SWT.BOLD);
		Image image = new Image(display, 87, 48);
		GC gc = new GC(image);
		gc.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
		gc.fillRectangle(image.getBounds());
		gc.setFont(font);
		gc.setForeground(display.getSystemColor(SWT.COLOR_RED));
		gc.drawString("S", 3, 0);
		gc.setForeground(display.getSystemColor(SWT.COLOR_GREEN));
		gc.drawString("W", 25, 0);
		gc.setForeground(display.getSystemColor(SWT.COLOR_BLUE));
		gc.drawString("T", 62, 0);
		gc.dispose();

		ImageLoader loader = new ImageLoader();
		loader.data = new ImageData[] {image.getImageData()};
		loader.save("swt.png", SWT.IMAGE_PNG);

		image.dispose();
		font.dispose();
		display.dispose();
	}
}
