package csvtool;

import javax.swing.*;

import java.awt.*;

public class MainForm extends JFrame {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private JFrame mainForm = new JFrame("CSVTOOL");//Mian window��Title is CSVTOOL
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
			    /* �������������� */
			    mainForm.setSize(500, 370);// �����������С
			    mainForm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// ����������رհ�ť��ʽ
			    mainForm.setLocationRelativeTo(null);// ���þ�����Ļ����
			    mainForm.setResizable(false);// ���ô��ڲ�������
			    mainForm.setLayout(null);
			    mainForm.setVisible(true);// ��ʾ����
			    /* ���ø�Ԫ��λ�ò��� */
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

			    
			    /* Ϊ��Ԫ�ذ��¼������� */
			    buttonBrowseSource.addActionListener(new BrowseAction()); // ΪԴ�ļ������ť�󶨼�����������ð�ť�����ļ�ѡ�񴰿�
			    buttonBrowseTarget.addActionListener(new BrowseAction()); // ΪĿ��λ�������ť�󶨼�����������ð�ť�����ļ�ѡ�񴰿�
			    buttonExecute.addActionListener(new ExecuteAction()); // Ϊ���ܰ�ť�󶨼��������������ܰ�ť���Դ�ļ����м��ܲ������Ŀ��λ��
			    sourcefile.getDocument().addDocumentListener(new TextFieldAction());
			    sourcefile.setEditable(true);// ����Դ�ļ��ı��򲻿��ֶ��޸�
			    targetfile.setEditable(false);// ����Ŀ��λ���ı��򲻿��ֶ��޸�
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
