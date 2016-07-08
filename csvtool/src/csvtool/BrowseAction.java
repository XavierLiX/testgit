package csvtool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BrowseAction implements ActionListener {

	@Override
	  public void actionPerformed(ActionEvent e) {
	    if (e.getSource().equals(MainForm.buttonBrowseSource)) {
	      JFileChooser fcDlg = new JFileChooser();
	      fcDlg.setMultiSelectionEnabled(true);
	      fcDlg.setDialogTitle("please choose files");
	      FileNameExtensionFilter filter = new FileNameExtensionFilter(
	          "testfile(*.csv)", "csv");
	      fcDlg.setFileFilter(filter);
	      int returnVal = fcDlg.showOpenDialog(null);
	      if (returnVal == JFileChooser.APPROVE_OPTION) {
	    	  File[] path;
	    	  path = fcDlg.getSelectedFiles();
	    	 String filepath ="";
	    	 for(int i= 0; i < path.length; i++){
	    		 filepath +=path[i].getPath();
	    				 filepath += ";";
	    	 }
	        MainForm.sourcefile.setText(filepath);
	       
	      }
	    } else if (e.getSource().equals(MainForm.buttonBrowseTarget)) {
	      JFileChooser fcDlg = new JFileChooser();
	      fcDlg.setDialogTitle("Save Path");
	      fcDlg.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	      int returnVal = fcDlg.showOpenDialog(null);
	      if (returnVal == JFileChooser.APPROVE_OPTION) {
	        String filepath = fcDlg.getSelectedFile().getPath();
	        MainForm.targetfile.setText(filepath);
	      }
	    }
	  }


}
