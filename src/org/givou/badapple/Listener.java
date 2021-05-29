package org.givou.badapple;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.JPanel;

public class Listener extends JPanel implements ActionListener {

	int i = 1;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		if (i == 6569) {
			System.exit(0);
		}
		i++;

		try {
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			
			InputStream in = classloader.getResourceAsStream("data/badapple-("+i+").txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			
			int j = 0;
			String temp;

			while ((temp = reader.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(temp);
				while (st.hasMoreTokens()) {
					int start = Integer.parseInt(st.nextToken());
					int end = Integer.parseInt(st.nextToken());
					
					graphics.drawLine(start, j, end, j);
				}
				j++;
			}
			
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
