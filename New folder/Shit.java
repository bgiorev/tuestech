package com.wordpress.bgiorev.gui.code;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.*;


public class Shit{
	private javax.swing.JFrame frame;
	private javax.swing.JLabel label;
	private javax.swing.JTextField textField;
	private javax.swing.JTextPane textBox;
	
	public Shit() {
		frame = new JFrame();
		frame.setTitle("MyFrame");
		frame.setSize(300, 300);
		frame.setVisible(true);
		label = new JLabel("You didn't clicked the button");
		frame.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent mouseEvt) {
				label.setText("You scrolled ");
			}
			
		});
		
		
		//frame.add(label);
		JButton button = new JButton("Click");
		button.setSize(20, 20);
		//frame.add(button);
		button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                clicked(evt);
            }
        });
		textField = new javax.swing.JTextField();
		textField.setSize(50, 100);
		//frame.add(textField);
		textField.setText("Text Field");
		
		textBox = new JTextPane();
		textBox.setSize(100, 100);
		//frame.add(textBox);
		textBox.setText("TextBox");
		textField.addActionListener(new java.awt.event.ActionListener(){

			@Override
			public void actionPerformed(ActionEvent evt) {
				clicked(evt);
				
			}
			
		});
		
		 javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
	        frame.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(label))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(button)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(textBox)))
	                .addContainerGap(27, Short.MAX_VALUE))
	        );
	 
	        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {button, textField});
	 
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(label))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(button)
	                    .addComponent(textBox))
	                .addContainerGap(21, Short.MAX_VALUE))
	        );
	        frame.pack();
		
	}
	
	public static void main(String[] args) {
		Shit shit = new Shit();
	}
	
	public void clicked(java.awt.event.ActionEvent evn){
		label.setText(textBox.getText());
	}
}
