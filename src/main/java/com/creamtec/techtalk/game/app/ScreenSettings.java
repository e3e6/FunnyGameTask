package com.creamtec.techtalk.game.app;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Show dialog to define some Game settings
 * @author alex
 *
 */
public class ScreenSettings extends JDialog {


	private static final long serialVersionUID = 1L;
	private JFormattedTextField refreshRateInput = new JFormattedTextField(100);
	private JFormattedTextField cellSizeInput = new JFormattedTextField(50);
	
	private JFormattedTextField screenHeight = new JFormattedTextField(800);
	private JFormattedTextField screenWidth = new JFormattedTextField(600);
	
	private JCheckBox fullscreenCheck = new JCheckBox("Fullscreen", true);
	
	/**
	 * Dialog Settings window constructor
	 */
	public ScreenSettings() {
		setTitle("Game Settings");
		setLayout(new GridBagLayout());
		
		add(new JLabel("Refresh rate:"), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.NORTHWEST, 
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		
		add(refreshRateInput, new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, 
													GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 100, 0));
		
		add(new JLabel("Cell Size:"), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.NORTHWEST, 
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		
		add(cellSizeInput, new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, 
													GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		add(fullscreenCheck, new GridBagConstraints(0, 2, 2, 1, 1, 0, GridBagConstraints.NORTHWEST, 
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		JPanel screenPanel = new JPanel();
			   screenPanel.setBorder(BorderFactory.createTitledBorder("Window Size"));
			   screenPanel.setLayout(new GridBagLayout());
			   
			   
			   screenPanel.add(new JLabel("Width:"), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, 
						GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
				
			   screenPanel.add(screenWidth, new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.WEST, 
															GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
				
			   screenPanel.add(new JLabel("Height:"), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, 
						GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
				
			   screenPanel.add(screenHeight, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.WEST, 
															GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
				
				

		add(screenPanel, new GridBagConstraints(0, 3, 2, 1, 1, 1, GridBagConstraints.WEST, 
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		
		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ScreenSettings.this.setVisible(false);
			}
		});
		
	    
		add(startButton, new GridBagConstraints(0, 4, 2, 1, 1, 1, GridBagConstraints.NORTHEAST, 
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
			
		setResizable(false);
		setModal(true);
		getRootPane().setDefaultButton(startButton);
		pack();
		setVisible(true);
	}
	
    /**
     * Refresh Rate parameter
     * @return
     */
	public int getRefreshRate() {
		return (int) refreshRateInput.getValue();
	}


	/**
	 * Cell Size parameter
	 * @return
	 */
	public int getCellSize() {
		return (int) cellSizeInput.getValue();
	}

	/**
	 * Screen Dimension parameter
	 * @return
	 */
	public Dimension getScreenDimension() {
		return new Dimension((int)screenHeight.getValue(), (int)screenWidth.getValue());
	}

	/**
	 * Fullscreen parameter
	 * @return
	 */
	public boolean isFullscreen() {
		return fullscreenCheck.isSelected();
	}

	
	/**
	 * Entry for testing purposes
	 * @param args
	 */
    public static void main(String[] args) {
    	JDialog sett = new ScreenSettings();
    			sett.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

}
