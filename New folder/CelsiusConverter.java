package com.wordpress.bgiorev.gui.code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;

public class CelsiusConverter {
	private JFrame frame;
	private JLabel celsiusLabel;
	private JTextField celsiusTextField;
	private JLabel farenhaitLabel;
	private JTextField farenhaitTextField;
	
	public CelsiusConverter() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame("Celsius Converter");
		celsiusLabel = new JLabel("Celsius");
		farenhaitLabel = new JLabel("Farenhait");
		celsiusTextField = new JTextField("0");
		farenhaitTextField = new JTextField("32");
		farenhaitTextField.setSize(130,130);
		
		GroupLayout layout = new GroupLayout(frame.getContentPane());
		frame.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addComponent(celsiusTextField, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(celsiusLabel))
						.addGroup(layout.createSequentialGroup()
							.addComponent(farenhaitTextField)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(farenhaitLabel)))
						.addContainerGap(27, Short.MAX_VALUE))
		);
		
		layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {farenhaitLabel, celsiusLabel});
		
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(celsiusTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(celsiusLabel))
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(farenhaitTextField)
							.addComponent(farenhaitLabel))
					.addContainerGap(21, Short.MAX_VALUE))
				
		);
		frame.pack();
		
		celsiusTextField.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				convert();
				
			}

			private void convert() {
				DecimalFormat df = new DecimalFormat("#.#");
				double temp = Double.parseDouble(celsiusTextField.getText()) * 1.8 + 32;
				String t = df.format(temp);
				farenhaitTextField.setText(t);
			}
			
		});		
		
		
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		CelsiusConverter converter = new CelsiusConverter();
	}
}
