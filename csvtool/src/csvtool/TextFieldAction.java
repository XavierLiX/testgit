package csvtool;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class TextFieldAction implements DocumentListener {
	 @Override
	  public void insertUpdate(DocumentEvent e) {
	    // TODO Auto-generated method stub
	    ButtonAjust();
	  }
	  @Override
	  public void removeUpdate(DocumentEvent e) {
	    // TODO Auto-generated method stub
	    ButtonAjust();
	  }
	  @Override
	  public void changedUpdate(DocumentEvent e) {
	    // TODO Auto-generated method stub
	    ButtonAjust();
	  }
	  public void ButtonAjust() {
	    String file = MainForm.sourcefile.getText();
	    if (file.endsWith(".csv;")) {
	      MainForm.buttonExecute.setEnabled(true);
	    }
	    else{
	    System.out.println("Unknown file!");	
	    }
	  }


}
