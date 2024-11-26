import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
//import calculations.UnitConverter; 

/*
	Main Class
*/

public class AssiStu implements ActionListener 
{
	private JFrame f;
	private Container c;
	JButton b1,b2,b3,b4;
	
	Image aSicon = Toolkit.getDefaultToolkit().getImage("fIcon.jpg");
	ImageIcon forB1 = new ImageIcon("calc.jpg");
	ImageIcon forB2 = new ImageIcon("unitC.jpg");
	ImageIcon forB3 = new ImageIcon("ttt.jpg");
	ImageIcon forB4 = new ImageIcon("info-removebg-preview.png");


	public AssiStu()
	{
		f = new JFrame("AssiStu");
		f.setSize(600,600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setIconImage(aSicon);
		
		c = f.getContentPane();
		c.setLayout(new GridLayout(2,2));

		b1 = new JButton();
		b1.setIcon(forB1);
		b1.setBackground(Color.BLACK);
		b2 = new JButton();
		b2.setIcon(forB2);
		b2.setBackground(Color.BLACK);
		b3 = new JButton();
		b3.setIcon(forB3);
		b3.setBackground(Color.BLACK);
		b4 = new JButton();
		b4.setIcon(forB4);
		b4.setBackground(Color.BLACK);
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		c.add(b1);
		c.add(b2);
		c.add(b3);
		c.add(b4);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			f.setVisible(false);
			new Calculator();
		}
		if(ae.getSource()==b2)
		{
			f.setVisible(false);
			UnitConverter uc = new UnitConverter();
			uc.unitConverter(); 
		}
		if(ae.getSource()==b3)
		{
			f.setVisible(false);
			new TicTacToe();
		}
		if(ae.getSource()==b4)
		{
			f.setVisible(false);
			f.setVisible(false);
			new Info();
		}
	}

	public static void main(String[] AssiStu)
	{
		new AssiStu();
	}
}


/*
		**********
************************************************
*****************Calculator*********************
************************************************
		**********
*/

class Calculator implements ActionListener
{
	//Initiallizing frame,container and other components' objects
	JFrame f;
	Container c;
	JTextField t;
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bPls,bMin,bMul,bDiv,bEqualTo,bClr,bDot,bDel,bNeg,bBack;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8;
	double num=0,num2=0;
	char operator;
	int i;

	Calculator()
	{
		//Frame setting
		f = new JFrame("Calculator");
		f.setSize(400,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);

		//Container Setting
		c = f.getContentPane();
		c.setBackground(new Color(90,9,98));
		c.setLayout(new BorderLayout());

		p8 = new JPanel();
		p8.setLayout(new GridLayout(2,1));

		Border border = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black,10),BorderFactory.createTitledBorder("AssiStu"));
		Font font= new Font("Courier", Font.BOLD, 28);

		//TextField setting;
		t=new JTextField(String.valueOf(num));
		t.setForeground(new Color(225,225,0));
		t.setFont(font);
		t.setEditable(false);
		t.setBackground(new Color(1,2,3));


		//Initiallizing and setting panels
		p1 = new JPanel();
		p1.setBorder(border);
		p1.setLayout(new GridLayout(1,1));

		p2 = new JPanel();
		p2.setLayout(new BorderLayout());

		p3 = new JPanel();
		p3.setBackground(new Color(100,200,200));
		p3.setLayout(new GridLayout(1,4));

		p4 = new JPanel();//initiallizing panel 1 to 9 number buttons
		p4.setBackground(new Color(1,2,200)); 
		p4.setLayout(new GridLayout(3,3));
		p5 = new JPanel();
		p5.setBackground(new Color(111,23,200));
		p5.setLayout(new GridLayout(3,3));

		p6 = new JPanel();
		p6.setLayout(new GridLayout(1,2));
		p7 = new JPanel();
		

		//Buttons setting(Number buttons)
		b1 = new JButton("1");
		//b1.setBorder(); 
		b1.setFont(new Font("Courier", Font.BOLD, 30));
		b2 = new JButton("2");
		b2.setFont(new Font("Courier", Font.BOLD, 30));
		b3 = new JButton("3");
		b3.setFont(new Font("Courier", Font.BOLD, 30));
		b4 = new JButton("4");
       		b4.setFont(new Font("Courier", Font.BOLD, 30));
		b5 = new JButton("5");
		b5.setFont(new Font("Courier", Font.BOLD, 30));
		b6 = new JButton("6");
		b6.setFont(new Font("Courier", Font.BOLD, 30));
		b7 = new JButton("7");
		b7.setFont(new Font("Courier", Font.BOLD, 30));
		b8 = new JButton("8");
		b8.setFont(new Font("Courier", Font.BOLD, 30));
		b9 = new JButton("9");
		b9.setFont(new Font("Courier", Font.BOLD, 30));
		b0 = new JButton("0");
		b0.setFont(new Font("Courier", Font.BOLD, 30));
		

		//Setting delete and clear button
		bClr = new JButton("c");
		bClr.setFont(new Font("Courier", Font.BOLD, 30));
		bDel = new JButton("x");
		bDel.setFont(new Font("Courier",Font.ITALIC+Font.BOLD, 20));
		
		//Setting Back button
		bBack = new JButton("Back");
		bBack.setFont(new Font("Courier", Font.BOLD, 30));
		bBack.setBackground(Color.GRAY);
		
		//Setting operator buttons
		bMul = new JButton("*");
		bMul.setFont(new Font("Courier", Font.BOLD, 33));
		bMin = new JButton("-");
		bMin.setFont(new Font("Courier", Font.BOLD, 33));
		bDot = new JButton(".");
		bDot.setFont(new Font("Courier", Font.BOLD, 30));
		bDiv = new JButton("/");
		bDiv.setFont(new Font("Courier", Font.BOLD, 33));		
		bPls = new JButton("+");
		bPls.setFont(new Font("Courier", Font.BOLD, 33));
		bEqualTo = new JButton("=");
		bEqualTo.setFont(new Font("Courier", Font.BOLD, 30));

		//Setting negative buttons
		bNeg = new JButton("(-)");// button that will negate the value
		bNeg.setFont(new Font("Courier", Font.BOLD, 35));
		
		//Adding components to panels
		p1.add(t);
		p4.add(b1);
		p4.add(b2);
		p4.add(b3);
		p4.add(b4);
		p4.add(b5);
		p4.add(b6);
		p4.add(b7);
		p4.add(b8);
		p4.add(b9);
		
		
		p6.add(b0);
		p6.add(bEqualTo);
		
		
		p5.add(bDiv);
		p5.add(bMin);
		p5.add(bPls);
		
		p3.add(bClr);
		p3.add(bDel);
		p3.add(bDot);
		p3.add(bNeg);
		p3.add(bMul);
		
		
		

		p2.add(p3,"North");
		p2.add(p4,"Center");
		p2.add(p5,"East");
		p2.add(p6,"South");
		p8.add(p1);
		p8.add(p2);
		c.add(p8,"Center");
		c.add(bBack,"South");
		
		

			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			b5.addActionListener(this);
			b6.addActionListener(this);
			b7.addActionListener(this);
			b8.addActionListener(this);
			b9.addActionListener(this);
			b0.addActionListener(this);
			bDot.addActionListener(this);
			bClr.addActionListener(this);
			bDel.addActionListener(this);
			bPls.addActionListener(this);
			bDiv.addActionListener(this);
			bMul.addActionListener(this);
			bMin.addActionListener(this);
			bNeg.addActionListener(this);
			bEqualTo.addActionListener(this);
			bBack.addActionListener(this);
			


		f.setVisible(true);

	}

	public void actionPerformed(ActionEvent ae)
	{
		try
		{
		//num=Double.parseDouble(t.getText());
		if(ae.getSource()==b1)
		{
			if(i==0)
			{
				t.setText("1");
			}else
			{ 
				t.setText(t.getText()+"1");
			}
			i++;
		}
		if(ae.getSource()==b2)
		{
			if(i==0)
			{
				t.setText("2");
			}else
			t.setText(t.getText()+"2");
			i++;
		}
		if(ae.getSource()==b3)
		{
			if(i==0)
			{
				t.setText("3");
			}else
			t.setText(t.getText()+"3");
			i++;
		}
		if(ae.getSource()==b4)
		{
			if(i==0)
			{
				t.setText("4");
			}else
			t.setText(t.getText()+"4");
			i++;
		}
		if(ae.getSource()==b5)
		{
			if(i==0)
			{
				t.setText("5");
			}else
			t.setText(t.getText()+"5");
			i++;
		}
		if(ae.getSource()==b6)
		{
			if(i==0)
			{
				t.setText("6");
			}else
			t.setText(t.getText()+"6");
			i++;
		}
		if(ae.getSource()==b7)
		{
			if(i==0)
			{
				t.setText("7");
			}else
			t.setText(t.getText()+"7");
			i++;
		}
		if(ae.getSource()==b8)
		{
			if(i==0)
			{
				t.setText("8");
			}else
			t.setText(t.getText()+"8");
			i++;
		}
		if(ae.getSource()==b9)
		{
			if(i==0)
			{
				t.setText("9");
			}else
			t.setText(t.getText()+"9");
			i++;
		}
		if(ae.getSource()==b0)
		{
			if(i==0)
			{
				t.setText("0");
			}else
			t.setText(t.getText()+"0");
		}
		if(ae.getSource()==bDot)
		{	if(t.getText()=="0.0")
			t.setText(t.getText()+".");
			else
			t.setText(t.getText()+".");
			i++;
		}
		if(ae.getSource()==bClr)
		{
			t.setText("0");
			num=Double.parseDouble(t.getText());
			i=0;
		}
		if(ae.getSource()==bDel)
		{
			String getFieldText = t.getText();
			int ln = getFieldText.length();
			String updatedFieldText = getFieldText.substring(0,ln-1);
				
			if(ln==1)
			{
				
				t.setText("0");
			}
			else
			{
				t.setText(updatedFieldText);
			}
		}
		if(ae.getSource()==bNeg)
		{
			double ptve = Double.parseDouble(t.getText());
			double ntve = ptve*(-1);
			t.setText(""+ntve);
		}
		if(ae.getSource()==bPls)
		{
			num=Double.parseDouble(t.getText());
			t.setText("0");
			operator='+';
			i=0;
		}
		if(ae.getSource()==bMin)
		{
			num = Double.parseDouble(t.getText());
			t.setText("0");
			operator = '-';
			i=0;
		}
		if(ae.getSource()==bMul)
		{
			num = Double.parseDouble(t.getText());
			t.setText("0");
			operator='*';
			i=0;
		}
		if(ae.getSource()==bDiv)
		{
			num = Double.parseDouble(t.getText());
			t.setText("0");
			operator = '/';	
			i=0;
		}
		if(ae.getSource()==bEqualTo)
		{
			num2 = Double.parseDouble(t.getText());
			switch(operator)
			{
				
				case '+':
				{
					num=num+num2;
				}break;	
				case '-':
				{
					num=num-num2;
				}break;
				case '*':
				{
					num=num*num2;
				}break;
				case '/':
				{
					num=num/num2;
				}break;
				default:
				{
					num=num2;
				}
				
			}
			t.setText(""+num);
			if(num==0.0)
			i=0;
			operator = '=';
			
					
		}
		if(ae.getSource()==bBack)
		{
			f.setVisible(false);
			new AssiStu();
		}
		}
		catch(java.lang.NumberFormatException e)
		{
			t.setText("  Syntax Error, press C ");
		}

	}

}

/**
		**********
************************************************
***************#UnitConverter#********************
************************************************
		**********
*/

class UnitConverter implements ActionListener
{
	 JFrame f;
	 Container c;
	 JLabel lab1,lab2,lab3;
	 JTextField tf1,tf2,tf3,tf11,tf22,tf33;
	
	 String [] weightUnitList = {"Kilogram(Kg)","Gram(g)","Miligram(mg)"};
	 JComboBox<String> cblist1 = new JComboBox<>(weightUnitList);
	 JComboBox<String> cblist11 = new JComboBox<>(weightUnitList);

	 String [] lengthUnitList = {"Kilometre(Km)","Meter(m)","Centimeter(cm)","Milimeter(mm)","Foot(ft)","inch(In)"};
	 JComboBox<String> cblist2 = new JComboBox<>(lengthUnitList);
	 JComboBox<String> cblist22 = new JComboBox<>(lengthUnitList);

	 String [] temperatureUnitList = {"Centigrade(C)","Fahrenheit(F)","Kelvin(K)"};
	 JComboBox<String> cblist3 = new JComboBox<>(temperatureUnitList);
	 JComboBox<String> cblist33 = new JComboBox<>(temperatureUnitList);
	 JButton bBack = new JButton("Back");
	
	void unitConverter()
	{
		//Frame setting
		f = new JFrame("Unit Converter");
		f.setSize(400,500);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);

		//Container Setting
		 c = f.getContentPane();
		 c.setBackground(Color.PINK);
		 
		//Back button setting
		bBack.addActionListener(this);
		 
		//Back button setting
		bBack = new JButton("Back");
		bBack.setFont(new Font("Courier", Font.BOLD, 30));
		bBack.setBackground(Color.GRAY);
		bBack.setBounds(150, 400, 100, 30);
		bBack.addActionListener(this);
		c.add(bBack);

		//Weight Unit Converter Setting 		
		
		//label 1 setting
		lab1 = new JLabel("Weight Units");
		lab1.setBounds(40,50,200,30);
		lab1.setFont(new Font("courier",Font.BOLD,16));
		lab1.setBackground(Color.RED);
		c.add(lab1);

		//Combo Box List1 setting
		cblist1.setBounds(40,80,120,30);
		cblist1.setBackground(Color.GREEN);
		c.add(cblist1);

		//Combo Box List11 setting
		cblist11.setBounds(210,80,150,30);
		cblist11.setBackground(Color.GREEN);
		c.add(cblist11);

		//Setting tf1
		tf1 = new JTextField("0");
		tf1.setBounds(40,120,120,25);
		tf1.setBackground(Color.CYAN);
		c.add(tf1); 

		//Setting tf11
		tf11 = new JTextField("0");
		tf11.setBounds(210,120,150,25);
		tf11.setBackground(Color.CYAN);
		tf11.setBorder(BorderFactory.createLineBorder(Color.black));
		tf11.setEditable(false);
		c.add(tf11); 

		//Length unit converter Setting 
		
		//label 2 setting
		lab2 = new JLabel("Length Units");
		lab2.setBounds(40,160,200,30);
		lab2.setFont(new Font("courier",Font.BOLD,16));
		lab2.setBackground(Color.RED);
		c.add(lab2);

		//Combo Box List2 setting
		cblist2.setBounds(40,190,120,30);
		cblist2.setBackground(Color.BLUE);
		c.add(cblist2);

		//Combo Box List22 setting
		cblist22.setBounds(210,190,150,30);
		cblist22.setBackground(Color.BLUE);
		c.add(cblist22);

		//Setting tf2
		tf2 = new JTextField("0");
		tf2.setBounds(40,230,120,25);
		tf2.setBackground(Color.CYAN);
		c.add(tf2); 

		//Setting tf22
		tf22 = new JTextField("0");
		tf22.setBounds(210,230,150,25);
		tf22.setBackground(Color.CYAN);
		tf22.setEditable(false);
		c.add(tf22); 

		//Temperature unit converter Setting 
		
		//label 3 setting
		lab3 = new JLabel("Temperature Units");
		lab3.setBounds(40,270,220,30);
		lab3.setFont(new Font("courier",Font.BOLD,16));
		lab3.setBackground(Color.RED);
		c.add(lab3);

		//Combo Box List3 setting
		cblist3.setBounds(40,300,120,30);
		cblist3.setBackground(Color.RED);
		c.add(cblist3);

		//Combo Box List33 setting
		cblist33.setBounds(210,300,150,30);
		cblist33.setBackground(Color.RED);
		c.add(cblist33);

		//Setting tf3
		tf3 = new JTextField("0");
		tf3.setBounds(40,340,120,25);
		tf3.setBackground(Color.CYAN);
		c.add(tf3); 

		//Setting tf33
		tf33 = new JTextField("0");
		tf33.setBounds(210,340,150,25);
		tf33.setBackground(Color.CYAN);
		tf33.setEditable(false);
		c.add(tf33); 
		

		f.setVisible(true); //Making frame visible;
		for(int t=0;t>-1;t+=0)
		fieldCheckerAndConverter();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
			f.setVisible(false);
			new AssiStu();
	}
	
	private void fieldCheckerAndConverter()
	{
		/*
			**************
			****Weight****
			**************
		*/
			try
			{

				if(cblist1.getItemAt(cblist1.getSelectedIndex())==cblist11.getItemAt(cblist11.getSelectedIndex()))
				{
					tf11.setText(tf1.getText());
				}
				else if(cblist1.getItemAt(cblist1.getSelectedIndex())=="Kilogram(Kg)")
				{
					if(cblist11.getItemAt(cblist11.getSelectedIndex())=="Gram(g)")
					{
						tf11.setText(""+1000*Double.parseDouble(tf1.getText()));
					}
					else if(cblist11.getItemAt(cblist11.getSelectedIndex())=="Miligram(mg)")
					{
						tf11.setText(""+1000000*Double.parseDouble(tf1.getText()));
					}
				}
				else if(cblist1.getItemAt(cblist1.getSelectedIndex())=="Gram(g)")
				{
					if(cblist11.getItemAt(cblist11.getSelectedIndex())=="Kilogram(Kg)")
					{
						tf11.setText(""+Double.parseDouble(tf1.getText())/1000);
					}
					else if(cblist11.getItemAt(cblist11.getSelectedIndex())=="Miligram(mg)")
					{
						tf11.setText(""+1000*Double.parseDouble(tf1.getText()));
					}
				}
				else if(cblist1.getItemAt(cblist1.getSelectedIndex())=="Miligram(mg)")
				{
					if(cblist11.getItemAt(cblist11.getSelectedIndex())=="Kilogram(Kg)")
					{
						tf11.setText(""+Double.parseDouble(tf1.getText())/1000000);
					}
					else if(cblist11.getItemAt(cblist11.getSelectedIndex())=="Gram(g)")
					{
						tf11.setText(""+Double.parseDouble(tf1.getText())/1000);
					}
				}
			}
			catch(Exception e)
			{
					System.out.println("Masla to exception ka he");	
			}
		
		/*
			**************
			****Length****
			**************
		*/
		try
			{
		
				if(cblist2.getItemAt(cblist2.getSelectedIndex())==cblist22.getItemAt(cblist22.getSelectedIndex()))
				{
					tf22.setText(tf2.getText());
				}
				else if(cblist2.getItemAt(cblist2.getSelectedIndex())=="Kilometre(Km)")
				{
					if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Meter(m)")
					{
						tf22.setText(""+1000*Double.parseDouble(tf2.getText()));
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Centimeter(cm)")
					{
						tf22.setText(""+100000*Double.parseDouble(tf2.getText()));
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Milimeter(mm)")
					{
						tf22.setText(""+1000000*Double.parseDouble(tf2.getText()));
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Foot(ft)")
					{
						tf22.setText(""+(3280.841666667)*Double.parseDouble(tf2.getText()));
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="inch(In)")
					{
						tf22.setText(""+Double.parseDouble(tf2.getText())/39370);
					}
				}
				else if(cblist2.getItemAt(cblist2.getSelectedIndex())=="Meter(m)")
				{
					if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Kilometre(Km)")
					{
						tf22.setText(""+Double.parseDouble(tf2.getText())/1000);
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Centimeter(cm)")
					{
						tf22.setText(""+100*Double.parseDouble(tf2.getText()));
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Milimeter(mm)")
					{
						tf22.setText(""+1000*Double.parseDouble(tf2.getText()));
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Foot(ft)")
					{
						tf22.setText(""+(3.281)*Double.parseDouble(tf2.getText()));
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="inch(In)")
					{
						tf22.setText(""+(39.37)*Double.parseDouble(tf2.getText()));
					}
				}
				else if(cblist2.getItemAt(cblist2.getSelectedIndex())=="Centimeter(cm)")
				{
					if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Kilometre(Km)")
					{
						tf22.setText(""+Double.parseDouble(tf2.getText())/100000);
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Meter(m)")
					{
						tf22.setText(""+Double.parseDouble(tf2.getText())/100);
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Milimeter(mm)")
					{
						tf22.setText(""+10*Double.parseDouble(tf2.getText()));
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Foot(ft)")
					{
						tf22.setText(""+Double.parseDouble(tf2.getText())*0.03);
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="inch(In)")
					{
						tf22.setText(""+Double.parseDouble(tf2.getText())*0.393701);
					}
				}
				else if(cblist2.getItemAt(cblist2.getSelectedIndex())=="Milimeter(mm)")
				{
					if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Kilometre(Km)")
					{
						tf22.setText(""+Double.parseDouble(tf2.getText())/1000000);
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Meter(m)")
					{
						tf22.setText(""+Double.parseDouble(tf2.getText())/1000);
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Centimeter(cm)")
					{
						tf22.setText(""+Double.parseDouble(tf2.getText())/10);
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Foot(ft)")
					{
						tf22.setText(""+Double.parseDouble(tf2.getText())/304.8);
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="inch(In)")
					{
						tf22.setText(""+Double.parseDouble(tf2.getText())/25.4);
					}
				}
				else if(cblist2.getItemAt(cblist2.getSelectedIndex())=="inch(In)")
				{
					if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Kilometre(Km)")
					{
						tf22.setText(""+(0.00002540001371600258102)*Double.parseDouble(tf2.getText()));
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Meter(m)")
					{
						tf22.setText(""+(0.025400013716002582675)*Double.parseDouble(tf2.getText()));
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Centimeter(cm)")
					{
						tf22.setText(""+(2.5400013716002582953)*Double.parseDouble(tf2.getText()));
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Milimeter(mm)")
					{
						tf22.setText(""+(25.400013716002582953)*Double.parseDouble(tf2.getText()));
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Foot(ft)")
					{
						tf22.setText(""+(0.083333378333341798228)*Double.parseDouble(tf2.getText()));
					}
				}
				else if(cblist2.getItemAt(cblist2.getSelectedIndex())=="Foot(ft)")
				{
					if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Kilometre(Km)")
					{
						tf22.setText(""+(0.00030480016459203101292)*Double.parseDouble(tf2.getText()));
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Meter(m)")
					{
						tf22.setText(""+(0.30480016459203101986)*Double.parseDouble(tf2.getText()));
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Centimeter(cm)")
					{
						tf22.setText(""+(30.480016459203103096)*Double.parseDouble(tf2.getText()));
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="Milimeter(mm)")
					{
						tf22.setText(""+(304.80016459203102386)*Double.parseDouble(tf2.getText()));
					}
					else if(cblist22.getItemAt(cblist22.getSelectedIndex())=="inch(In)")
					{
						tf22.setText(""+(12.000006480001221831)*Double.parseDouble(tf2.getText()));
					}
				}
			}
			catch(Exception e)
			{
					System.out.println("Masla to exception ka he");	
			}
		/*
			*******************
			****Temperature****
			*******************
		*/
			try
			{
		
				if(cblist3.getItemAt(cblist3.getSelectedIndex())==cblist33.getItemAt(cblist33.getSelectedIndex()))
				{
					tf33.setText(tf3.getText());
				}
				else if(cblist3.getItemAt(cblist3.getSelectedIndex())=="Centigrade(C)")
				{
					if(cblist33.getItemAt(cblist33.getSelectedIndex())=="Fahrenheit(F)")
					{
						tf33.setText(""+((9/5)*Double.parseDouble(tf3.getText())+32));
					}
					else if(cblist33.getItemAt(cblist33.getSelectedIndex())=="Kelvin(K)")
					{
						tf33.setText(""+(273.15+Double.parseDouble(tf3.getText())));
					}
				}
				else if(cblist3.getItemAt(cblist3.getSelectedIndex())=="Fahrenheit(F)")
				{
					if(cblist33.getItemAt(cblist33.getSelectedIndex())=="Centigrade(C)")
					{
						tf33.setText(""+(Double.parseDouble(tf3.getText())-32)*5/9);
					}
					else if(cblist33.getItemAt(cblist33.getSelectedIndex())=="Kelvin(K)")
					{
						tf33.setText(""+((Double.parseDouble(tf3.getText())-32)*5/9+273));
					}
				}
				else if(cblist3.getItemAt(cblist3.getSelectedIndex())=="Kelvin(K)")
				{
					if(cblist33.getItemAt(cblist33.getSelectedIndex())=="Centigrade(C)")
					{
						tf33.setText(""+(Double.parseDouble(tf3.getText())-273.15));
					}
					else if(cblist33.getItemAt(cblist33.getSelectedIndex())=="Fahrenheit(F)")
					{
						tf33.setText(""+((Double.parseDouble(tf3.getText())-273.15)*9/5+32));
					}
				}
				
			}
			catch(Exception e)
			{
					System.out.println("Bhai kuch likho aur saheeh likho");	
			}
	}

	
}

/*
		**********
************************************************
****************Tic Tac Toe*********************
************************************************
		**********
*/

class TicTacToe implements ActionListener 
{
	private JFrame f;
	private Container c;
	private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,bReset,bBack;
	private JPanel p1,p2,p3;
	private JLabel lab = new JLabel();
	private int i;
	private AssiStu m = new AssiStu();
	public TicTacToe()
	{
		f = new JFrame("Tic-Tac-Toe");
		f.setSize(300,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setIconImage(m.aSicon);
		

		c = f.getContentPane();
		c.setLayout(new BorderLayout());

		p1 = new JPanel();
		p1.setLayout(new GridLayout(3,3));
		p2 = new JPanel();
		p2.setBackground(Color.BLUE);
		p2.setLayout(new GridLayout(2,1));
		p1 = new JPanel();
		p1.setLayout(new GridLayout(3,3));
		p3 = new JPanel();
		p3.setBackground(Color.BLUE);
		p3.setLayout(new GridLayout(1,2));

		b1 = new JButton();
		b1.setBackground(Color.WHITE);
		b2 = new JButton();
		b2.setBackground(Color.WHITE);
		b3 = new JButton();
		b3.setBackground(Color.WHITE);
		b4 = new JButton();
		b4.setBackground(Color.WHITE);
		b5 = new JButton();
		b5.setBackground(Color.WHITE);
		b6 = new JButton();
		b6.setBackground(Color.WHITE);
		b7 = new JButton();
		b7.setBackground(Color.WHITE);
		b8 = new JButton();
		b8.setBackground(Color.WHITE);
		b9 = new JButton();
		b9.setBackground(Color.WHITE);
		bReset = new JButton("Reset");
		bBack = new JButton("Back");
		bBack.setFont(new Font("Courier", Font.BOLD, 30));
		bBack.setBackground(Color.GRAY);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bReset.addActionListener(this);
		bBack.addActionListener(this);

		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		p1.add(b6);
		p1.add(b7);
		p1.add(b8);
		p1.add(b9);

		p3.add(bReset);
		p3.add(bBack);
		p2.add(p3);
		p2.add(lab);
		

		c.add(p1,"Center");
		c.add(p2,"South");

		f.setVisible(true);

	}

	public void actionPerformed(ActionEvent ae)
	{
	try
	  {
		
		if(ae.getSource()==b1)
		{
			if(i%2==0)
			{
				b1.setText("X");
			}
			else
			{
				b1.setText("O");
			}

			i++;
			gameChecker();
			b1.setEnabled(false);	
		}
		if(ae.getSource()==b2)
		{
			if(i%2==0)
			{
				b2.setText("X");
			}else
			{
				b2.setText("O");
			}
			i++;
			gameChecker();
			b2.setEnabled(false);
			
		}
		if(ae.getSource()==b3)
		{
			if(i%2==0)
			{
				b3.setText("X");
			}else
			{
				b3.setText("O");
			}
			i++;
			gameChecker();
			b3.setEnabled(false);
				
		}
		if(ae.getSource()==b4)
		{
			if(i%2==0)
			{
				b4.setText("X");
			}else
			{
				b4.setText("O");
			}
			i++;
			gameChecker();
			b4.setEnabled(false);
				
		}
		if(ae.getSource()==b5)
		{
			if(i%2==0)
			{
				b5.setText("X");
			}else
			{
				b5.setText("O");
			}
			i++;
			gameChecker();
			b5.setEnabled(false);
			
		}
		if(ae.getSource()==b6)
		{
			if(i%2==0)
			{
				b6.setText("X");
			}else
			{
				b6.setText("O");
			}
			i++;
			gameChecker();
			b6.setEnabled(false);
			
		}
		if(ae.getSource()==b7)
		{
			if(i%2==0)
			{
				b7.setText("X");
			}else
			{
				b7.setText("O");
			}
			i++;
			gameChecker();
			b7.setEnabled(false);	
		}
		if(ae.getSource()==b8)
		{
			if(i%2==0)
			{
				b8.setText("X");
			}else 
			{
				b8.setText("O");
			}
			i++;
			gameChecker();
			b8.setEnabled(false);	
		}
		if(ae.getSource()==b9)
		{
			if(i%2==0)
			{
				b9.setText("X");
			}else
			{
				b9.setText("O");
			}
			i++;
			b9.setEnabled(false);
		}
		if(ae.getSource()==bReset)
		{
			f.setVisible(false);
			new TicTacToe();
		}
		if(ae.getSource()==bBack)
		{
			f.setVisible(false);
			new AssiStu();
		}
			if(i==100)
			{
				i=0;
			}
		
	  }
	  catch(Exception e)
	  {
	  	
	  }
    	}
	private void allButtonDisable()
	{
		b1.setEnabled(false);
		b2.setEnabled(false);
		b3.setEnabled(false);
		b4.setEnabled(false);
		b5.setEnabled(false);
		b6.setEnabled(false);
		b7.setEnabled(false);
		b8.setEnabled(false);
		b9.setEnabled(false);
	}
	
	private void gameChecker()
	{
		if(b1.getText()!="")
		{
			if(b1.getText()==b2.getText()&&b1.getText()==b3.getText())
			{
				if((i-1)%2==0)
				{
					lab.setText("X wins");
				}
				else
				{
					lab.setText("O wins");
				}
				allButtonDisable();
			}
			if((b1.getText()==b5.getText())&&(b1.getText()==b9.getText()))
			{
				if((i-1)%2==0)
				{
					lab.setText("O wins");
				}
				else
				{
					lab.setText("X wins");
				}
				allButtonDisable();
			}
			if((b1.getText()==b4.getText())&&(b1.getText()==b7.getText()))
			{
				if((i-1)%2==0)
				{
					lab.setText("X wins");
				}
				else
				{
					lab.setText("O wins");
				}
				allButtonDisable();
			}
		}
		if(b5.getText()!="")
		{
			if((b5.getText()==b2.getText())&&(b5.getText()==b8.getText()))
			{
				if((i-1)%2==0)
				{
					lab.setText("X wins");
				}
				else
				{
					lab.setText("O wins");
				}
				allButtonDisable();
			}
			if((b5.getText()==b3.getText())&&(b5.getText()==b7.getText()))
			{
				if((i-1)%2==0)
				{
					lab.setText("X wins");
				}
				else
				{
					lab.setText("O wins");
				}
				allButtonDisable();
			}
			if((b5.getText()==b4.getText())&&(b5.getText()==b6.getText()))
			{
				if((i-1)%2==0)
				{
					lab.setText("X wins");
				}
				else
				{
					lab.setText("O wins");
				}
				allButtonDisable();
			}
			if((b5.getText()==b3.getText())&&(b5.getText()==b7.getText()))
			{
				if((i-1)%2==0)
				{
					lab.setText("X wins");
				}
				else
				{
					lab.setText("O wins");
				}
				allButtonDisable();
			}
		}
		if(b9.getText()!="")
		{
			if((b9.getText()==b3.getText())&&(b9.getText()==b6.getText()))
			{
				if((i-1)%2==0)
				{
					lab.setText("O wins");
				}
				else
				{
					lab.setText("X wins");
				}
				allButtonDisable();
			}
			if((b9.getText()==b8.getText())&&(b9.getText()==b7.getText()))
			{
				if((i-1)%2==0)
				{
					lab.setText("X wins");
				}
				else
				{
					lab.setText("O wins");
				}
				allButtonDisable();
			}
		}
	}
}

//
//
// The info class
//
//	

class Info implements ActionListener
{
	JFrame f = new JFrame("Info");;
	Container c;
	JButton bb = new JButton("Back");
	JTextArea tf;//= new JTextField("This Assistu contains study help with game for fun to get rest during study\nIt contains calculator, unit converter and Tic Tac Toe game\nUnit converter is not working properly because of some reasons \nI can manage it but time is not enough\nOne can run it seperately(UC)");
	AssiStu m = new AssiStu();
	
	Info()
	{
		
		
		f.setSize(400,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setIconImage(m.aSicon);
		
		c = f.getContentPane();
		c.setLayout(new BorderLayout());
		
		try
		{
			tf = new JTextArea("This Assistu contains study help with game\n for fun to get rest during study\nIt contains calculator, unit converter and Tic Tac Toe game\nUnit converter is not working properly because of some reasons \nI can manage it but time is not enough\nOne can run it seperately(UC)");
		}
		finally{}
		tf.setEditable(false);
		bb.addActionListener(this);
		
		c.add(tf,BorderLayout.CENTER);
		c.add(bb,BorderLayout.SOUTH);
		
		f.setVisible(true);
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		f.setVisible(false);
		new AssiStu();
	}
}

