package code;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Save_t085 {
	/**
	 * Constructor that intializes Save
	 * @author ziangzha (Ziang Zhao)
	 */
	
	public Save_t085() {
			initialize();
		}
	/**
	 * Creates a new Frame and create file wherever we want as a text file
	 * @author ziangzha (Ziang Zhao)
	 */
		private void initialize() {
			JButton jb = new JButton("Save");
			jb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fs = new JFileChooser(new File("c:\\"));
					fs.setDialogTitle("Save a File");
					fs.setFileFilter(new FileTypeFilter_085(".txt", "Text File"));
					int result = fs.showSaveDialog(null);
					if (result == JFileChooser.APPROVE_OPTION) {
						File fi = fs.getSelectedFile();
						try {
							FileWriter fw = new FileWriter(fi.getPath());
							fw.flush();
							fw.close();
						} 
						catch (Exception e2) {
							JOptionPane.showMessageDialog(null, e2.getMessage());
						}
					}
				}
			});
			JButton btnOpen = new JButton("Open");
			btnOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fs = new JFileChooser(new File("c:\\"));
					fs.setDialogTitle("Open a File");
					fs.setFileFilter(new FileTypeFilter_085(".txt", "Text File"));
					int result = fs.showOpenDialog(null);
					if (result == JFileChooser.APPROVE_OPTION) {
						try {
							File fi = fs.getSelectedFile();
							BufferedReader br = new BufferedReader(new FileReader(fi.getPath()));
							String line = "";
							String s = "";
							while ((line = br.readLine()) != null) {
								s = s + line;
							}
						} 
						catch (Exception e2) {
							JOptionPane.showMessageDialog(null, e2.getMessage());
						}

					}
				}
			});	
		}
	}




