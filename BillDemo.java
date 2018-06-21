import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

//1
class CurrentBill extends JFrame implements ActionListener
{
	JButton SUBMIT,commButton,domestButton,exitButton,commButton1,commButton2,domestButton1,domestButton2;
	JButton F4Button1,F4Button2,F5Button1,F6Button1,F6Button2,F7Button1,F8Button1,F8Button2;
	
	JPanel F1panel1,F1panel2,F1panel3,F1panel,F2panel1,F2panel2,F2panel3,F2panel4,F2panel5;
	
	JLabel optionLabel,commLabel,domestLabel,optionLabelComm,F2label1,F2label2,F2label3,F2label4,F2label5,F2label6;
	JLabel F2label7,F2label8,F2label9,F2label10,F2label11,F2label12,F2label13,F2label14,F2label15,F2label16,F2label17;
	JLabel F2label18;
	
	JTextField F2commTextField1,F3domestTextField1,F4domestTextField1;
	
	JFrame commFrame,domestFrame,proceedDomestFrame,enterDomestFrame,enterBillDomestFrame,NowPayBillDomestFrame;
	JFrame PayDomestFrame,GenBillDomestFrame;
	
	String name,aeh,address,tmpS;
	double curbal,oldbal,total,gstD=8,gstC=13,unit,tmp;	
	CurrentBill()
	{
		optionLabel = new JLabel("Choose Your Option...!!!");
		//optionLabel.setText("Choose Your Option...!!!");
		
		commButton = new JButton("COMMERTIAL LINE");
		domestButton = new JButton("DOMENSTIC LINE");
		exitButton = new JButton("EXIT");
		
//		exitButton.setActionCommand("EXIT");
		F1panel1 = new JPanel(new GridLayout(1,1));
			F1panel1.add(optionLabel);
		
		F1panel2 = new JPanel(new GridLayout(1,2));
			F1panel2.add(domestButton);
			F1panel2.add(commButton);
		
		F1panel3 = new JPanel(new GridLayout(1,1));			//FlowLayout
			F1panel3.add(exitButton);
		
		F1panel= new JPanel(new GridLayout(3,1));
			F1panel.add(F1panel1);
			F1panel.add(F1panel2);
			F1panel.add(F1panel3);
		
		add(F1panel,BorderLayout.CENTER);		//SOUTH,CENTER
		
		exitButton.addActionListener(this);
		domestButton.addActionListener(this);
 		commButton.addActionListener(this);	
		
		setTitle("ELECTRICAL BILL GENERATION");
	}
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==exitButton)
		{
			System.exit(0);
		}
		else if(evt.getSource()==commButton)
		{
			commFrame();
		}
		else if(evt.getSource()==domestButton)
		{
			domestFrame();
		}
		else if(evt.getSource()==commButton1)
		{
			goBack(1);
		}
		else if(evt.getSource()==commButton2)
		{
			goBack(0);
		}
		else if(evt.getSource()==domestButton1)
		{
			fnProceedDomestFrame();
		}
		else if(evt.getSource()==domestButton2)
		{
			goBack(1);
		}
		else if(evt.getSource()==F4Button1)
		{
			fnEnterDomestFrame();
		}
		else if(evt.getSource()==F4Button2)
		{
			goBack(2);
		}
		else if(evt.getSource()==F5Button1)
		{
			fnEnterBillDomestFrame();  
		}
		else if(evt.getSource()==F6Button1)
		{
			fnNowPayBillDomestFrame();
			enterBillDomestFrame.dispose();
		}
		else if(evt.getSource()==F7Button1)
		{
			fnPayDomestFrame();  
		}
		else if(evt.getSource()==F6Button2)
		{
			fnGenBillDomestFrame();
		}
		else if(evt.getSource()==F8Button1)
		{
			fnEnterBillDomestFrame();  
			GenBillDomestFrame.dispose();
		}
		else if(evt.getSource()==F8Button2)
		{
		JOptionPane.showMessageDialog(null,"ELECTRICITY BILL IS GENERATED...!\nYou can take printout this:"+aeh+".txt");
			System.exit(0);
		}
		
	}
	
	////1(main).1(domestic)
	public void domestFrame()
	{
		domestFrame = new JFrame("DOMENSTICAL CURRENT");
	 	domestFrame.setSize(300,100);
	 	domestFrame.setVisible(true);
	 	
	 	F2label1 = new JLabel("ENTER YOUR AEH-NUMBER: ");
	 	F3domestTextField1 = new JTextField(5);
	 	
	 	domestButton1 = new JButton("PROCEED");
	 	domestButton2 = new JButton("BACK");
	 	
	 	F2panel1 = new JPanel();
	 		domestFrame.add(F2panel1);
	 	
	 	F2panel2 = new JPanel(new GridLayout(1,2));
			F2panel2.add(F2label1);
			F2panel2.add(F3domestTextField1);
		
		F2panel3 = new JPanel(new GridLayout(1,2));
			F2panel3.add(domestButton1);
			F2panel3.add(domestButton2);
		
		F2panel1.add(F2panel2);
		F2panel1.add(F2panel3);
		
		domestButton1.addActionListener(this);
		domestButton2.addActionListener(this);
		this.dispose();
		//this.setVisible(false);
	}
	//1(main).2(commertial)
	public void commFrame()
	{
		commFrame = new JFrame("COMMERTIAL CURRENT");
		commFrame.setSize(300,100);
	 	commFrame.setVisible(true);
	 	
	 	F2label1 = new JLabel("ENTER YOUR AEH-NUMBER: ");
	 	F2commTextField1 = new JTextField(5);
	 	
	 	commButton1 = new JButton("PROCEED");
	 	commButton2 = new JButton("BACK");
	 	
	 	F2panel1 = new JPanel();
	 		commFrame.add(F2panel1);
	 	
	 	F2panel2 = new JPanel(new GridLayout(1,2));
			F2panel2.add(F2label1);
			F2panel2.add(F2commTextField1);
		
		F2panel3 = new JPanel(new GridLayout(1,2));
			F2panel3.add(commButton1);
			F2panel3.add(commButton2);
		
		F2panel1.add(F2panel2);
		F2panel1.add(F2panel3);
		
		commButton1.addActionListener(this);
		commButton2.addActionListener(this);
		this.dispose();
		//this.setVisible(false);
	}
	
	////1(main).1(domestic).1(proceed)
	public void fnProceedDomestFrame()
	{
		//String aeh; 
		aeh=F3domestTextField1.getText();
		if(fnReadFileByAEH(aeh))
		{	
		 	proceedDomestFrame = new JFrame("DOMENSTICAL CURRENT");
		 	proceedDomestFrame.setSize(300,100);
		 	proceedDomestFrame.setVisible(true);
		 	
		 	F2label1 = new JLabel("NAME: ");
		 	F2label2 = new JLabel(name);	//its actually retrive from file.
		 	F2label3 = new JLabel("AEH-NUMBER: ");
		 	F2label4 = new JLabel(aeh);	//its actually retrive from file.
		 	F2label5 = new JLabel("Enter Number Of Units: ");
		 	F4domestTextField1 = new JTextField(5);
		 	
		 	F4Button1 = new JButton("ENTER");
		 	F4Button2 = new JButton("BACK");
		 	
		 	F2panel1 = new JPanel();
		 		proceedDomestFrame.add(F2panel1);
		 	
		 	F2panel2 = new JPanel(new GridLayout(2,2));
				F2panel2.add(F2label1);
				F2panel2.add(F2label2);
				F2panel2.add(F2label3);
				F2panel2.add(F2label4);
			
			F2panel3 = new JPanel(new GridLayout(1,2));
				F2panel3.add(F2label5);
				F2panel3.add(F4domestTextField1);
		
			F2panel4 = new JPanel(new GridLayout(1,2));
				F2panel4.add(F4Button1);
				F2panel4.add(F4Button2);
		
			F2panel1.add(F2panel2);
			F2panel1.add(F2panel3);
			F2panel1.add(F2panel4);
		
			F4Button1.addActionListener(this);
			F4Button2.addActionListener(this);
			domestFrame.dispose();
		}
		else
			JOptionPane.showMessageDialog(null,"AEH-NO DID NOT MATCH...!!!");
	}
	
	//1(main).1(domestic).1(proceed).1(enter)
	public void fnEnterDomestFrame()
	{
		double per;
		enterDomestFrame = new JFrame("DOMENSTICAL CURRENT");
	 	enterDomestFrame.setSize(300,100);
	 	enterDomestFrame.setVisible(true);
	 	
	 	F2label1 = new JLabel("NAME: ");
	 	F2label2 = new JLabel(name);	//its actually retrive from file.
	 	F2label3 = new JLabel("AEH-NUMBER: ");
	 	F2label4 = new JLabel(aeh);	//its actually retrive from file.
	 	F2label5 = new JLabel("Old Balance: ");
	 	F2label6 = new JLabel(String.valueOf(oldbal));
	 	F2label7 = new JLabel("Current Amount: ");
	 	unit=Double.valueOf(F4domestTextField1.getText());

	 	double r=fnCheckUnitRate(unit,1);
	 	curbal=unit * r;
	 	per=( curbal * gstD)/100;
	 	total=oldbal + curbal + per;
	 	
	 	F2label8 = new JLabel(String.valueOf(curbal));
	 	F2label9 = new JLabel("GST: ");
	 	F2label10 = new JLabel(String.valueOf(gstD)+"%");
	 	F2label11 = new JLabel("TOTAL Balance: ");
	 	F2label12 = new JLabel(String.valueOf(total));
	 	
	 	F4domestTextField1 = new JTextField(5);
	 	
	 	F5Button1 = new JButton("ENTER");
	 	
	 	
	 	F2panel1 = new JPanel();
	 		enterDomestFrame.add(F2panel1);
	 	
	 	F2panel2 = new JPanel(new GridLayout(6,6));
			F2panel2.add(F2label1);
			F2panel2.add(F2label2);
			F2panel2.add(F2label3);
			F2panel2.add(F2label4);
			F2panel2.add(F2label5);
			F2panel2.add(F2label6);
			F2panel2.add(F2label7);
			F2panel2.add(F2label8);
			F2panel2.add(F2label9);
			F2panel2.add(F2label10);
			F2panel2.add(F2label11);
			F2panel2.add(F2label12);
					
		F2panel3 = new JPanel(new GridLayout(1,1));
			F2panel3.add(F5Button1);
			
		F2panel1.add(F2panel2);
		F2panel1.add(F2panel3);
		
		F5Button1.addActionListener(this);
		proceedDomestFrame.dispose();
	}
	//1(main).1(domestic).1(proceed).1(enter).1(enter)
	public void fnEnterBillDomestFrame()
	{
		enterBillDomestFrame = new JFrame("DOMENSTICAL CURRENT");
	 	enterBillDomestFrame.setSize(300,100);
	 	enterBillDomestFrame.setVisible(true);
	 	
	 	F2label1 = new JLabel("Choose Your Option...!!! ");
	 	 
	 	F6Button1 = new JButton("NOW PAY BILL");
	 	F6Button2 = new JButton("GENERATE BILL");
	 	exitButton = new JButton("EXIT");
	 	
	 	
	 	
	 	F2panel1 = new JPanel();
	 		enterBillDomestFrame.add(F2panel1);
	 	
	 	F2panel2 = new JPanel(new GridLayout(1,1));
	 		F2panel2.add(F2label1);
	 	F2panel3 = new JPanel(new GridLayout(1,1));
	 		F2panel3.add(F6Button1);
	 	F2panel4 = new JPanel(new GridLayout(1,1));
	 		F2panel4.add(F6Button2);
	 	F2panel5 = new JPanel(new GridLayout(1,1));
	 		F2panel5.add(exitButton);
		
		F2panel1.add(F2panel2);
		F2panel1.add(F2panel3);
		F2panel1.add(F2panel4);
		F2panel1.add(F2panel5);
		
		F6Button1.addActionListener(this);
		F6Button2.addActionListener(this);
		exitButton.addActionListener(this);
		enterDomestFrame.dispose();
	}
	
	//1(main).1(domestic).1(proceed).1(enter).1(enter).1(now pay bill)
	public void fnNowPayBillDomestFrame()
	{
		NowPayBillDomestFrame = new JFrame("DOMENSTICAL CURRENT BILL TRANSACTION");
	 	NowPayBillDomestFrame.setSize(300,100);
	 	NowPayBillDomestFrame.setVisible(true);
	 	
	 	F2label18 = new JLabel("ENTER AMOUNT TO BE PAY: ");
	 	//JOptionPane.showMessageDialog(null,"iam here..");
	 	F4domestTextField1 = new JTextField(5);
	 	
	 	F7Button1 = new JButton("PAY");
	 	exitButton = new JButton("EXIT");
	 	
	 	
	 	
	 	F2panel2 = new JPanel();
	 		NowPayBillDomestFrame.add(F2panel2);
	 	
	 	F2panel3 = new JPanel(new GridLayout(1,2));
	 		F2panel3.add(F2label18);
	 		F2panel3.add(F4domestTextField1);
	 	F2panel4 = new JPanel(new GridLayout(1,2));
	 		F2panel4.add(F7Button1);
	 		F2panel4.add(exitButton);
		
		F2panel2.add(F2panel3);
		F2panel2.add(F2panel4);
		
		F7Button1.addActionListener(this);
		exitButton.addActionListener(this);
		enterBillDomestFrame.dispose();
	}
	
	//1(main).1(domestic).1(proceed).1(enter).1(enter).2(generate bill)
	public void fnGenBillDomestFrame()
	{
		GenBillDomestFrame = new JFrame("DOMENSTICAL CURRENT BILL TRANSACTION");
	 	GenBillDomestFrame.setSize(300,100);
	 	GenBillDomestFrame.setVisible(true);
	 	
		F2label1 = new JLabel("NAME: ");
	 	F2label2 = new JLabel(name);	//its actually retrive from file.
	 	F2label3 = new JLabel("AEH-NUMBER: ");
	 	F2label4 = new JLabel(aeh);	//its actually retrive from file.
	 	F2label5 = new JLabel("ADDRESS: ");
	 	F2label6 = new JLabel(address);	//its actually retrive from file.
	 	F2label7 = new JLabel("LINE TYPE: ");
	 	F2label8 = new JLabel("DOMESTIC");	//its actually retrive from file.
	 	F2label9 = new JLabel("UNITS USED: ");
	 	F2label10 = new JLabel(String.valueOf(unit));	//its actually retrive from file.
	 	
	 	F2label11 = new JLabel("Old Balance: ");
	 	F2label12 = new JLabel(String.valueOf(oldbal));
	 	F2label13 = new JLabel("Current Amount: ");
	 	F2label14 = new JLabel(String.valueOf(curbal));
	 	F2label15 = new JLabel("GST: ");
	 	F2label16 = new JLabel(String.valueOf(gstD));
	 	F2label17 = new JLabel("TOtal :");
	 	F2label18 = new JLabel(String.valueOf(total));
	 	
	 	fnGenBill();
	 	F8Button1 = new JButton("BACK");
	 	F8Button2 = new JButton("FINISH");
	 	
	 	
	 	
	 	F2panel1 = new JPanel();
	 		GenBillDomestFrame.add(F2panel1);
	 	
	 	F2panel2 = new JPanel(new GridLayout(9,9));
	 		F2panel2.add(F2label1);
	 		F2panel2.add(F2label2);
	 		F2panel2.add(F2label3);
	 		F2panel2.add(F2label4);
	 		F2panel2.add(F2label5);
	 		F2panel2.add(F2label6);
	 		F2panel2.add(F2label7);
	 		F2panel2.add(F2label8);
	 		F2panel2.add(F2label9);
	 		F2panel2.add(F2label10);
	 		F2panel2.add(F2label11);
	 		F2panel2.add(F2label12);
	 		F2panel2.add(F2label13);
	 		F2panel2.add(F2label14);
	 		F2panel2.add(F2label15);
	 		F2panel2.add(F2label16);
	 		F2panel2.add(F2label17);
	 		F2panel2.add(F2label18);
	 		
	 	F2panel3 = new JPanel(new GridLayout(1,2));
	 		F2panel3.add(F8Button1);
	 		F2panel3.add(F8Button2);
		
		F2panel1.add(F2panel2);
		F2panel1.add(F2panel3);
		
		
		F8Button1.addActionListener(this);
		F8Button2.addActionListener(this);
		enterBillDomestFrame.dispose();
	}

	
	//1(main).1(domestic).1(proceed).1(enter).1(enter).1(now pay bill).1(pay)
	public void fnPayDomestFrame()
	{
		
		double amount=Double.valueOf(F4domestTextField1.getText());
		if(amount < 0 )
			JOptionPane.showMessageDialog(null,"Invalid amount you entered...!");
		else if(amount > total)
			JOptionPane.showMessageDialog(null,"You entered amount is more then the balence...!");
		else
		{
			//tmp=oldbal;
			oldbal=curbal=total-amount;
			PayDomestFrame = new JFrame("DOMENSTICAL CURRENT BILL TRANSACTION");
		 	PayDomestFrame.setSize(300,100);
		 	PayDomestFrame.setVisible(true);
		 	
		   	F2label1 = new JLabel(name+" YOUR TRANSACTION IS SUCCESSFULL...!!!");
		 	//replace
		 	fnReplace(curbal);
		 	
		 	F2label3 = new JLabel("AEH-NUMBER: ");
		 	F2label4 = new JLabel(aeh);	//its actually retrive from file.
		 	F2label7 = new JLabel("Current Balance: ");
		 	F2label8 = new JLabel(String.valueOf(curbal));	//its actually retrive from file.
		 	exitButton = new JButton("FINISH");
		 	
		 	F2panel1 = new JPanel();
		 		PayDomestFrame.add(F2panel1);
		 	
		 	F2panel2 = new JPanel(new GridLayout(1,1));
		 		F2panel2.add(F2label1);
		 	F2panel3 = new JPanel(new GridLayout(2,2));
		 		F2panel3.add(F2label3);
		 		F2panel3.add(F2label4);
		 		F2panel3.add(F2label7);
		 		F2panel3.add(F2label8);
		 	F2panel4 = new JPanel(new GridLayout(1,1));
		 		F2panel4.add(exitButton);
		
			F2panel1.add(F2panel2);
			F2panel1.add(F2panel3);
			F2panel1.add(F2panel4);
		
			exitButton.addActionListener(this);
			NowPayBillDomestFrame.dispose();
		}
	}

	//for all come back to parent frame
	public void goBack(int f)
	{
	 	
		if(f == 0)
		{
			CurrentBill frame = new CurrentBill();
			frame.setSize(300,100);
			frame.setVisible(true);
			commFrame.dispose();
			
		}
		else if(f == 1)
		{
			CurrentBill frame = new CurrentBill();
			frame.setSize(300,100);
			frame.setVisible(true);
			domestFrame.dispose();
		}
		else if(f == 2)
		{
			domestFrame();
			proceedDomestFrame.dispose();
			 
		}
	}	
	
	public void fnGenBill()
	{
		 String billFile=aeh+".txt";
		 BufferedWriter bw = null;
         try {
         		bw = new BufferedWriter(new FileWriter(billFile));
         		bw.write("NAME		:		"+name+"\n"+
         				 "AEH-NO		:		"+aeh+"\n"+
         				 "ADDRESS		:		"+address+"\n"+
         				 "LINE TYPE	:		DOMESTIC LINE"+"\n"+
         				 "UNITS USED	:		"+unit+"\n"+
         				 "OLD BALENCE	:		"+oldbal+"\n"+
         				 "CURRENT BALENCE	:	"+curbal+"\n"+
         				 "GST			:		"+gstD+"%"+"\n"+
         				 "TOTAL		:		"+total+"\n");
         		bw.close();
         	}
         	catch (Exception e) {
    	     	return;
   			}
   	}
   	
	public void fnReplace(double b)
	{
		double dd1=Double.valueOf(b);
		double dd2=Double.valueOf(tmp);
	  String b1=String.valueOf(dd1);
	  String b2=String.valueOf(tmp);
	  
      String oldFileName = "bill.txt";
      String tmpFileName = "tmp_bill2.dat";

      BufferedReader br = null;
      BufferedWriter bw = null;
      try {
         br = new BufferedReader(new FileReader(oldFileName));
         bw = new BufferedWriter(new FileWriter(tmpFileName));
         String line;
         while ((line = br.readLine()) != null) {
            if (line.contains(tmpS))
               line = line.replace(tmpS,b1);
            bw.write(line+"\n");
         }
      } catch (Exception e) {
         return;
      } finally {
         try {
            if(br != null)
               br.close();
         } catch (IOException e) {
         }
         try {
            if(bw != null)
               bw.close();
         } catch (IOException e) {
         }
      }
      // delete original file
      File oldFile = new File(oldFileName);
      oldFile.delete();

      // for rename tmp file old bill file
      File newFile = new File(tmpFileName);
      newFile.renameTo(oldFile);

   }
	boolean fnReadFileByAEH(String AEH)
	{	
		String textLines[];
		String textFeilds[];
		int flag=0;
		//String AEH=F3domestTextField1.getText();
		try {
				String oldFileName = "bill.txt";
      			//String tmpFileName = "tmp_bill.txt";
				File file = new File(oldFileName);
				//File file2 = new File(tmpFileName);
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				StringBuffer stringBuffer = new StringBuffer();
				
				String line;
				//fnReplace();
				while ((line = bufferedReader.readLine()) != null)
				{		
					stringBuffer.append(line);
					stringBuffer.append("\n");
				}
				fileReader.close();
				line=stringBuffer.toString();
				textLines= line.split("\n");
				for(int i=0;i<textLines.length;i++)
				{
					textFeilds= textLines[i].split("-");
				 	if(textFeilds[0].equals(AEH))
				 	{
				 		flag=1;
				 		aeh=textFeilds[0];
				 		name=textFeilds[1];
				 		tmpS=textFeilds[3];	//temp need
				 		oldbal=Double.valueOf(textFeilds[3]);
				 		
				 		address=textFeilds[2];	
				 		break;
				 	}
				}
	       }
	       catch(IOException e)
	       {
				e.printStackTrace();
		   }
		   
		   if(flag==1)
		   	return true;
		   else
		   	return false;
	}
	int fnCheckUnitRate(double u,int c)
	{
		//domestic = 1
		if(c==1)
		{
			if( u>=0 && u<30 )
				return 4;
			if( u>=30 && u<60 )
				return 6;
			if( u>=60 )
				return 8;
		}
		else 
		{ 
			if( u>=0 && u<30 )
				return 6;
			if( u>=30 && u<60 )
				return 8;
			if( u>=60 )
				return 10;
		}
		return 0;
	}	
}			
class BillDemo
{
	public static void main(String args[])
	{
		try
		{
			CurrentBill frame = new CurrentBill();
			frame.setSize(300,100);
			frame.setVisible(true);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
}
