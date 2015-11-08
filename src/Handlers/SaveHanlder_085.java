package Handlers;

	import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

	import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

	import code.FileTypeFilter_085;
import code.Save_t085;
import code.Scrabble_CE_085;

	public class SaveHanlder_085 implements ActionListener {
		Scrabble_CE_085 _scrabble;
		/**
		 * An action is performed when the save button is clicked which open a new window and saves it
		 * @author ziangzha (Ziang Zhao)
		 */
		
		public SaveHanlder_085(Scrabble_CE_085 s) {
			_scrabble = s;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fs = new JFileChooser(new File("c:\\"));
			fs.setDialogTitle("Save a File");
			fs.setFileFilter(new FileTypeFilter_085(".txt", "Text File"));
			int result = fs.showSaveDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				File fi = fs.getSelectedFile();
				try {
					FileWriter fw = new FileWriter(fi.getPath());
					fw.write(_scrabble.save(_scrabble.getInventory(), _scrabble.getPlayers()));
					fw.flush();
					fw.close();
				} 
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
			
		}
	}







