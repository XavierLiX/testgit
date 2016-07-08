package csvtool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;  
import java.io.FileReader;  

import javax.swing.JOptionPane;



public class ExecuteAction implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (MainForm.sourcefile.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"please choose files!");
		}else if(MainForm.targetfile.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"please choose Save Path!");
		}else{
			  String sourcepath = MainForm.sourcefile.getText();
			  String[] sourcepathes = sourcepath.split(";");
		      String targetpath = MainForm.targetfile.getText();
		      String filename = MainForm.namefile.getText();
		      File dir = new File(targetpath);
		      File result = new File(getFinalFile(targetpath, filename));
		      try {
		      BufferedWriter bw = new BufferedWriter(new FileWriter(result));
		    for (int i = 0; i < sourcepathes.length;i++){
		      File file = new File(sourcepathes[i]);
		      if (file.exists() && dir.isDirectory()) {		         	          
		        	  @SuppressWarnings("resource")
		        	     BufferedReader reader = new BufferedReader(new FileReader(file));
		        	 
			             String line = ""; 
			             int dmtemp = 0;
			             int mtemp = 0; //varible for minute change
			             int dtemp = -1;
			             int temp = -1; //varible for second change
			             while((line=reader.readLine()) != null){  
			                 String[] item = line.split(";");//CSV file is divided by "," , here is according to ";". 
			                 String[] time = item[0].split(":");
			                 int dm = Integer.parseInt(time[1])/10;
			                 int m = Integer.parseInt(time[1])%10;//mod minute
			                 int ds = Integer.parseInt(time[2])/10;
			                 int s = Integer.parseInt(time[2])%10;//mod second		
			                 
			                 if(temp < 0){
			                	 temp = s;		                 			                 
			                	 bw.write(item[1]);
			                	 bw.flush();
			                	 bw.newLine();
			                	 continue;
			                 }else if(s != temp + 1 && s != 9 && s != temp && s != 0){			                	 	
			                	 	for(int k = 0; k < (s-temp)-1; k++ ) {
				                	 	bw.write(item[2]);
				                	 	bw.flush();
				                	 	bw.newLine();
				                	 	}	                	 				                	 	
			                	 	temp = s;
			                	 	bw.write(item[1]);
			                	 	bw.flush();
			                	 	bw.newLine();
			                	 	continue;
			                 }else if(s != temp + 1 && s == temp){				                		                 			               				               				              
			                	 	continue;
				             }else if(s == 9 && temp == s){				                	 
//				                	 bw.write(item[1]);
//				                	 bw.flush();
//				                	 bw.newLine();
				                	 continue;
			                 }else{
			                 bw.write(item[1]);
			                 bw.flush();
				             bw.newLine();
				             temp = s;
			                 }
		    
			             }  			             			             			      		          
		         		          
		          if (!result.exists()) {
			            try {
			              result.createNewFile();
			            } catch (IOException e1) {
			              JOptionPane.showMessageDialog(null,
			                  "Fail to create the file");
			            }
			          }
		        }
		        else if (!file.exists()) {
		          JOptionPane.showMessageDialog(null, "The file is not exist£¡");
		        } else {
		          JOptionPane.showMessageDialog(null, "The directory is not exist£¡");
		        }
		
		      }
		    bw.close();
		      } catch (Exception e1) {
		            JOptionPane.showMessageDialog(null, "Unknow Error£¡");
		          }
		
		    }
		  JOptionPane.showMessageDialog(null, "Creation is successful£¡");
		
		
		    }
		   
		    public String getFinalFile(String targetpath, String filename) {
		      String finalFile = targetpath + "\\" + filename + ".csv";
		      return finalFile;
		    }


		
	}



	 

	       
	


