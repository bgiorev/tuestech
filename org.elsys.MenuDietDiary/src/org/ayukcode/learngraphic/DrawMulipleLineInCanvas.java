package org.ayukcode.learngraphic;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Draw multiple line
 * 
 * @author putukus
 * 
 */
public class DrawMulipleLineInCanvas {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		shell.setText("Draw Multi line in Canvas");

		Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				e.gc.setLineWidth(4);
				
				//draw line start from coordinat 5,5 to 300,60 continue to 100,80 contiune to 100, 250 
				int[] points = { 5, 5, 300, 60, 100,80, 100, 250};
				e.gc.drawPolyline(points);
				
				int[] point2 = { 70, 70, 400, 70, 200,90, 120, 260};
				e.gc.drawPolyline(point2);
				
				int[] point3 = { 100, 100, 300, 60, 100,80, 100, 250};
				e.gc.drawPolyline(point2);
				
			}
		});

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}
