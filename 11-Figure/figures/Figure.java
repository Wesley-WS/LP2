package figures;

import java.awt.*;
import java.awt.Graphics;

public abstract class Figure {
	private int x, y;
	private Color cor;

	public void Figure(int x, int y){
		this.x = x;
		this.y = y;
	}

	public abstract void drag (int dx, int dy);
	public abstract void print();
    public abstract void paint (Graphics g, boolean preenchido);
}
