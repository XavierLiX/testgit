package csvtool;

import javax.swing.*;

import java.awt.*;

public class MainForm extends JFrame {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private JFrame mainForm = new JFrame("CSVTOOL");//Mian window，Title is CSVTOOL
		private JLabel label1 = new JLabel("Please choose files:");
		private JLabel label2 = new JLabel("New file name:");
		private JLabel label3 = new JLabel("Save Path:");
		public static JTextField sourcefile = new JTextField(); // Choose the source files
		public static JTextField namefile = new JTextField(); // New file name
		public static JTextField targetfile = new JTextField(); // Save Path
		public static JButton buttonBrowseSource = new JButton("Browse"); // Browse button
		public static JButton buttonBrowseTarget = new JButton("Browse"); // Browse button
		public static JButton buttonExecute = new JButton("Execute"); // Execution button
	  
		public MainForm() {
			    Container container = mainForm.getContentPane();
			    /* 设置主窗体属性 */
			    mainForm.setSize(500, 370);// 设置主窗体大小
			    mainForm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// 设置主窗体关闭按钮样式
			    mainForm.setLocationRelativeTo(null);// 设置居于屏幕中央
			    mainForm.setResizable(false);// 设置窗口不可缩放
			    mainForm.setLayout(null);
			    mainForm.setVisible(true);// 显示窗口
			    /* 设置各元素位置布局 */
			    label1.setBounds(30, 10, 300, 30);
			    sourcefile.setBounds(50, 50, 300, 30);
			    buttonBrowseSource.setBounds(380, 50, 100, 30);
			    label2.setBounds(30, 90, 300, 30);
			    namefile.setBounds(50, 130, 300, 30);
			    label3.setBounds(30, 170, 300, 30);
			    targetfile.setBounds(50, 210, 300, 30);
			    buttonBrowseTarget.setBounds(380, 210, 100, 30);
			    buttonExecute.setBounds(200, 280, 100, 30);
			    //buttonDecrypt.setBounds(200, 180, 60, 30);

			    
			    /* 为各元素绑定事件监听器 */
			    buttonBrowseSource.addActionListener(new BrowseAction()); // 为源文件浏览按钮绑定监听器，点击该按钮调用文件选择窗口
			    buttonBrowseTarget.addActionListener(new BrowseAction()); // 为目标位置浏览按钮绑定监听器，点击该按钮调用文件选择窗口
			    buttonExecute.addActionListener(new ExecuteAction()); // 为加密按钮绑定监听器，单击加密按钮会对源文件进行加密并输出到目标位置
			    sourcefile.getDocument().addDocumentListener(new TextFieldAction());
			    sourcefile.setEditable(true);// 设置源文件文本域不可手动修改
			    targetfile.setEditable(false);// 设置目标位置文本域不可手动修改
			    container.add(label1);
			    container.add(label2);
			    container.add(label3);
			    container.add(sourcefile);
			    container.add(namefile);
			    container.add(targetfile);
			    container.add(buttonBrowseSource);
			    container.add(buttonBrowseTarget);
			    container.add(buttonExecute);
			    
			    

	    	}
		 public static void main(String args[]) {
			    new MainForm();
			  }
		
}
