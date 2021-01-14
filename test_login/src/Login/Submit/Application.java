package Login.Submit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.awt.print.*;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.lang.String;
import java.sql.*;
//import oracle.sql.*;

class AppDemo extends JFrame implements ItemListener //Class containing all the components
{
	static Container c;
	static CardLayout cl;
	static JPanel p, login_p, p_s, p1, p_c, p2, p3, ptc, pcoc, topPanel, tcPanel, cocPanel;
	static JButton reset, next, submit, print, update, submit_2, go_to, data, clr, prt, home, login_btn, logout, yes, ok, Ok, tc_button, coc_button, goToCoc, view, reset_2;
	static Font f, ff, fff, ffff, fffff,ffffff, fo, fb, fffs, fbold, fcoc, f_f;
	static Color col, col2;
	static JLabel title, name, roll, regd, course, child, Native, join, pass, conduct, fees, issue, select, login_text, login_warn, uim, pim, tl, clrnce, regd_no, msg, branch, gender, reg_no, print_warn, topLabel, l1, l2, l3, l4, l5, l6, l7, l8, confT, conf_2, igitLogo1, igitLogo2, hl1, hl2, hl3, hl4, hl5, hl6, hl7, hl8, view_label, warnLogin;
	static JTextArea confD, tcPrint, cocPrint, cocPrint2, hta1;
	static JTextField fn, mn, ln, gn, rn1, rn2, pl, cn, un, regdNo, regNo;
	static JPasswordField pw;
	static JComboBox year, day, month, jy, py, feen, branch_box, branch_box_2;
	static JRadioButton btech, barch, mtech, dip, mca, male, female, third, null_course, null_gender;
	static Cursor cur1, cur2;
	static Timer timer, timer2;
	static double timeLeft;
	static JCheckBox Hod, coord, phy, chem, maths, eng, ws, carp, fit, weld, bs, turn, ms, sm, mound, lib, cult, avc, athl, acad, exam, acc, bb, host, ncc, nss, tc, coc;
	static String nameC1, nameC2, nameC3, rollC, regdC, guardC, courseC, placeC, conductC, jyC, pyC, feesC, genC, branchC, dayC, m, yearC, issueDateTc, issueDateCoc, monthC;
	static Connection con;
	AppDemo() //Automatic constructor
	{
		c=this.getContentPane();
		c.setBackground(Color.BLUE);
		c.setLayout(null);
		
		cl=new CardLayout(); //layout of the application
		f=new Font("Calibri",Font.PLAIN,21); //font for Buttons
		fb=new Font("Candara",Font.PLAIN,20); //font for Buttons
		ff=new Font("Castellar",Font.BOLD,20); //font for titles
		fff=new Font("Calibri",Font.PLAIN,18); //larger font
		fffs=new Font("Cambria",Font.PLAIN,18);
		ffff=new Font("Calibri",Font.PLAIN,15); //smaller font
		f_f=new Font("Calibri",Font.PLAIN,13);
		fffff=new Font("Calibri",Font.BOLD,21);
		ffffff=new Font("Calibri",Font.PLAIN,12);
		fo=new Font("Calibri",Font.BOLD,18);
		fbold=new Font("Calibri",Font.BOLD,17); //bold font
		fcoc=new Font("High Tower Text",Font.ITALIC,22);
		col=new Color(227,247,248); //background of the panels
		col2=new Color(0,0,64); //color for buttons
		cur1=new Cursor(Cursor.HAND_CURSOR); //Cursor for the buttons
		cur2=new Cursor(Cursor.TEXT_CURSOR); //Cursor for the textfields
		ButtonGroup course_bg=new ButtonGroup(); //buttongroup for the course radiobuttons
		ButtonGroup gender_bg=new ButtonGroup(); //buttongroup for the gender radiobuttons

		//main panel
		p=new JPanel();
		p.setBounds(0,150,1250,550);
		p.setLayout(cl);

		//topmost panel which is constant
		topPanel=new JPanel();
		topPanel.setBounds(0,0,1250,150);
		topPanel.setLayout(null);

		//background for the topmost panel
		ImageIcon bck=new ImageIcon("Capture.PNG");
		topLabel=new JLabel(bck);
		topLabel.setBounds(0,0,1250,150);

		//background for other panels
		ImageIcon back_login=new ImageIcon("BACKGROUND.png");
		l1=new JLabel(back_login);
		l1.setBounds(0,-15,1250,550);

		ImageIcon back_img=new ImageIcon("BACK.png");
		l2=new JLabel(back_img);
		l2.setBounds(0,0,1250,550);

		l3=new JLabel(back_img);
		l3.setBounds(0,0,1250,550);

		l4=new JLabel(back_img);
		l4.setBounds(0,0,1250,550);

		l5=new JLabel(back_img);
		l5.setBounds(0,0,1250,550);

		l6=new JLabel(back_img);
		l6.setBounds(0,0,1250,550);

		l7=new JLabel(back_img);
		l7.setBounds(0,0,1250,550);

		l8=new JLabel(back_img);
		l8.setBounds(0,0,1250,550);

		//login panel
		login_p=new JPanel();
		login_p.setBackground(col);
		login_p.setLayout(null);

		//first panel
		p_s=new JPanel();
		p_s.setBackground(col);
		p_s.setLayout(null);

		//second panel for data entry section
		p1=new JPanel();
		p1.setBackground(col);
		p1.setLayout(null);

		//third panel for confirmation page
		p_c=new JPanel();
		p_c.setBackground(col);
		p_c.setLayout(null);

		//fourth panel for clearance section
		p2=new JPanel();
		p2.setBackground(col);
		p2.setLayout(null);

		//fifth panel for print section
		p3=new JPanel();
		p3.setBackground(col);
		p3.setLayout(null);

		//panel to print tc
		ptc=new JPanel();
		ptc.setBackground(Color.WHITE);
		ptc.setLayout(null);

		//panel to print coc
		pcoc=new JPanel();
		pcoc.setBackground(Color.WHITE);;
		pcoc.setLayout(null);

		//panel of tc
		tcPanel=new JPanel();
		tcPanel.setBackground(Color.WHITE);
		tcPanel.setBounds(0,0,580,650);
		tcPanel.setLayout(null);

		//panel of coc
		cocPanel=new JPanel();
		cocPanel.setBackground(Color.WHITE);
		cocPanel.setBounds(0,0,580,650);
		cocPanel.setLayout(null);

		//label for login text
		login_text=new JLabel("Admin Login");
		login_text.setBounds(275,450,200,50);
		login_text.setFont(ff);
		login_text.setForeground(col);

		//username
		un=new JTextField("User Name");
		un.setForeground(Color.GRAY);
		un.setBounds(700,230,300,40);
		un.setFont(ffff);
		un.setCursor(cur2);
		un.addFocusListener(new FocusListener()
			{
				public void focusGained(FocusEvent fe)
				{
					userFocusGained(fe);
				}
				public void focusLost(FocusEvent fe)
				{
					userFocusLost(fe);
				}
			});
		un.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent ke)
				{
					userAction(ke);
				}
			});

		//password field
		pw=new JPasswordField("Password");
		pw.setForeground(Color.GRAY);
		pw.setBounds(700,295,300,40);
		pw.setFont(f);
		pw.setCursor(cur2);
		pw.addFocusListener(new FocusListener()
			{
				public void focusGained(FocusEvent fe)
				{
					passFocusGained(fe);
				}
				public void focusLost(FocusEvent fe)
				{
					passFocusLost(fe);
				}
			});
		pw.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent ke)
				{
					passAction(ke);
				}
			});

		//warning messages for false login
		login_warn=new JLabel("");
		login_warn.setBounds(550,450,500,50);
		login_warn.setFont(fff);
		login_warn.setForeground(Color.RED);

		warnLogin=new JLabel("");
		warnLogin.setBounds(550,415,500,50);
		warnLogin.setFont(fff);
		warnLogin.setForeground(Color.RED);

		//title label of data entry section
		title=new JLabel("STUDENT DETAILS");
		title.setBounds(500,5,250,100);
		title.setFont(ff);

		//label for name of the student
		name=new JLabel("Name");
		name.setBounds(125,100,100,20);
		name.setFont(fff);

		//textfield for first name
		fn=new JTextField("First Name");
		fn.setBounds(185,100,115,25);
		fn.setForeground(Color.GRAY); //changing the text colour
		fn.setFont(ffff);
		fn.setCursor(cur2);
		fn.addFocusListener(new FocusListener()
			{
				public void focusGained(FocusEvent fe)
				{
					firstFocusGained(fe);
				}
				public void focusLost(FocusEvent fe)
				{
					firstFocusLost(fe);
				}
			}); 
		fn.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent ke)
				{
					firstTyped(ke);
				}
			});

		//textfield for middle name
		mn=new JTextField("Middle Name");
		mn.setBounds(305,100,115,25);
		mn.setForeground(Color.GRAY);
		mn.setFont(ffff);
		mn.setCursor(cur2);
		mn.addFocusListener(new FocusListener()
			{
				public void focusGained(FocusEvent fe)
				{
					middleFocusGained(fe);
				}
				public void focusLost(FocusEvent fe)
				{
					middleFocusLost(fe);
				}
			});
		mn.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent ke)
				{
					middleTyped(ke);
				}
			});

		//textfield for last name
		ln=new JTextField("Last Name");
		ln.setBounds(425,100,115,25);
		ln.setForeground(Color.GRAY);
		ln.setFont(ffff);
		ln.setCursor(cur2);
		ln.addFocusListener(new FocusListener()
			{
				public void focusGained(FocusEvent fe)
				{
					lastFocusGained(fe);
				}
				public void focusLost(FocusEvent fe)
				{
					lastFocusLost(fe);
				}
			});
		ln.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent ke)
				{
					lastTyped(ke);
				}
			});

		//label for guardian's name
		child=new JLabel("Father's/Guardian's name");
		child.setBounds(625,100,250,25);
		child.setFont(fff);

		//textfield for guardian's name
		gn=new JTextField();
		gn.setBounds(835,100,265,25);
		gn.setFont(ffff);
		gn.setCursor(cur2);
		gn.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent ke)
				{
					guardTyped(ke);
				}
			});

		//label for roll number
		roll=new JLabel("Roll No");
		roll.setBounds(125,150,100,25);
		roll.setFont(fff);

		//textfield for roll number
		rn1=new JTextField();
		rn1.setBounds(190,150,75,25);
		rn1.setFont(ffff);
		rn1.setCursor(cur2);
		rn1.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent ke)
			{
				rollTyped(ke);
			}
		});

		//label for registration number
		regd=new JLabel("Registration No");
		regd.setBounds(290,150,125,25);
		regd.setFont(fff);

		//textfield for registration number
		rn2=new JTextField();
		rn2.setBounds(425,150,115,25);
		rn2.setFont(ffff);
		rn2.setCursor(cur2);

		//label for course
		course=new JLabel("Course");
		course.setBounds(625,150,100,20);
		course.setFont(fff);

		//radiobuttons for course
		//b.tech
		btech=new JRadioButton("B.Tech");
		btech.setBounds(700,150,75,20);
		btech.setOpaque(false);
		btech.setFont(fff);
		btech.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					btechAction(ae);
				}
			});

		//b.arch
		barch=new JRadioButton("B.Arch");
		barch.setBounds(780,150,75,20);
		barch.setOpaque(false);
		barch.setFont(fff);
		barch.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					barchAction(ae);
				}
			});

		//m.tech
		mtech=new JRadioButton("M.Tech");
		mtech.setBounds(860,150,80,20);
		mtech.setOpaque(false);
		mtech.setFont(fff);
		mtech.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					mtechAction(ae);
				}
			});

		//diploma
		dip=new JRadioButton("Diploma");
		dip.setBounds(950,150,90,20);
		dip.setOpaque(false);
		dip.setFont(fff);
		dip.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					dipAction(ae);
				}
			});

		//mca
		mca=new JRadioButton("MCA");
		mca.setBounds(1040,150,70,20);
		mca.setOpaque(false);
		mca.setFont(fff);
		mca.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					mcaAction(ae);
				}
			});

		//null radio buttons for course and gender
		null_course=new JRadioButton();
		null_gender=new JRadioButton();

		//label for birth place
		Native=new JLabel("Birth Place");
		Native.setBounds(900,250,100,25);
		Native.setFont(fff);

		//textfield for birth place
		pl=new JTextField("e.g. New Delhi");
		pl.setBounds(1000,250,100,25);
		pl.setForeground(Color.GRAY);
		pl.setFont(ffff);
		pl.setCursor(cur2);
		pl.addFocusListener(new FocusListener()
			{
				public void focusGained(FocusEvent fe)
				{
					placeFocusGained(fe);
				}
				public void focusLost(FocusEvent fe)
				{
					placeFocusLost(fe);
				}
			});
		pl.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent ke)
				{
					placeTyped(ke);
				}
			});

		//label for year of joining
		join=new JLabel("Year of joining");
		join.setBounds(625,200,200,25);
		join.setFont(fff);

		//combobox for year of joining
		String[] jy_arr=new String[101];
		jy_arr[0]="-select-";
		for(int i=2010;i<=2109;i++)
			jy_arr[i-2009]=Integer.toString(i);
		jy=new JComboBox(jy_arr);
		jy.setBounds(750,200,80,25);
		jy.setFont(ffff);

		//label for year of passing out
		pass=new JLabel("Year of passing out");
		pass.setBounds(855,200,200,25);
		pass.setFont(fff);

		//combobox for year of passing out
		String[] py_arr=new String[101];
		py_arr[0]="-select-";
		for(int i=2014;i<=2113;i++)
			py_arr[i-2013]=Integer.toString(i);
		py=new JComboBox(py_arr);
		py.setBounds(1015,200,80,25);
		py.setFont(ffff);

		//label for conduct
		conduct=new JLabel("Conduct");
		conduct.setBounds(390,200,100,25);
		conduct.setFont(fff);

		//textfield for conduct
		cn=new JTextField("e.g. Good");
		cn.setBounds(465,200,75,25);
		cn.setForeground(Color.GRAY);
		cn.setFont(ffff);
		cn.setCursor(cur2);
		cn.addFocusListener(new FocusListener()
			{
				public void focusGained(FocusEvent fe)
				{
					conductFocusGained(fe);
				}
				public void focusLost(FocusEvent fe)
				{
					conductFocusLost(fe);
				}
			});
		cn.addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent ke)
				{
					conductTyped(ke);
				}
			});

		//label for fees paid upto
		fees=new JLabel("Fees paid upto");
		fees.setBounds(625,250,150,25);
		fees.setFont(fff);

		//combobox for fees paid upto
		String[] fee_arr={"Select Semester"};
		feen=new JComboBox(fee_arr);
		feen.setBounds(745,250,120,25);
		feen.setFont(ffffff);

		//gender label
		gender=new JLabel("Gender");
		gender.setBounds(125,200,100,25);
		gender.setFont(fff);

		//radiobuttons for gender
		//male
		male=new JRadioButton("Male");
		male.setBounds(185,200,58,25);
		male.setOpaque(false);
		male.setFont(ffff);

		//female
		female=new JRadioButton("Female");
		female.setBounds(240,200,73,25);
		female.setOpaque(false);
		female.setFont(ffff);

		//other
		third=new JRadioButton("Other");
		third.setBounds(310,200,65,25);
		third.setOpaque(false);
		third.setFont(ffff);

		//label for branch in the data entry section
		branch=new JLabel("Branch");
		branch.setFont(fff);
		branch.setBounds(125,250,75,25);

		//label for the message for view button
		view_label=new JLabel("<html>Enter the registration number and click on<br>View button to view existing student details</html>");
		view_label.setBounds(450,425,500,100);
		view_label.setFont(f);
		view_label.setForeground(Color.BLACK);

		//combobox for branch in the data entry section
		String[] branch_arr={"Select Branch"};
		branch_box=new JComboBox(branch_arr);
		branch_box.setBounds(225,250,315,25);
		branch_box.setFont(ffffff);

		//text areas for displaying the entered data on the confirmationn page
		//text area for labels
		confT=new JLabel("No data entered");
		confT.setBounds(325,10,300,300);
		confT.setFont(fo);

		//text area for details
		confD=new JTextArea("");
		confD.setOpaque(false);
		confD.setBounds(725,25,300,300);
		confD.setFont(fff);

		//text area for message
		conf_2=new JLabel("");
		conf_2.setBounds(325,350,600,75);
		conf_2.setForeground(Color.RED);
		conf_2.setFont(fffs);

		//radiobuttons for the first page
		//data entry section
		data=new JButton("Data Entry Section");
		data.setBackground(col2);
		data.setForeground(Color.WHITE);
		data.setBounds(225,250,200,50);
		data.setFont(fb);
		data.setCursor(cur1);
		data.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				dataAction(ae);
			}
		});

		//clearance section
		clr=new JButton("Clearance Section");
		clr.setBackground(col2);
		clr.setForeground(Color.WHITE);
		clr.setBounds(525,250,200,50);
		clr.setFont(fb);
		clr.setCursor(cur1);
		clr.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				clrAction(ae);
			}
		});

		//print section
		prt=new JButton("Print Section");
		prt.setBackground(col2);
		prt.setForeground(Color.WHITE);
		prt.setBounds(825,250,200,50);
		prt.setFont(fb);
		prt.setCursor(cur1);
		prt.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				prtAction(ae);
			}
		});

		//Label to display error
		select=new JLabel("");
		select.setBounds(550,550,300,50);
		select.setForeground(Color.RED);
		select.setFont(f);

		//clearance section
		//main title label
		clrnce=new JLabel("Clearance Section");
		clrnce.setFont(ff);
		clrnce.setBounds(500,5,275,100);

		//label for registration number in the clearance section
		regd_no=new JLabel("Enter Registration no");
		regd_no.setBounds(395,70,200,50);
		regd_no.setFont(f);

		//textfield for registration number in the clearance section
		regdNo=new JTextField();
		regdNo.setBounds(600,80,115,30);
		regdNo.setFont(ffff);
		regdNo.setCursor(cur2);

		//checkboxes for the clearance
		//hod
		Hod=new JCheckBox("HOD");
		Hod.setBounds(275,120,70,25);
		Hod.setOpaque(false);
		Hod.setFont(f);

		//branch combobox for clearance page
		String[] branch_arr_2={"--Branch--","Architecture","Chemical Engineering","Civil Engineering","Computer Science and Engineering","Computer Science and Engineering (SSC)","Computer Science and Information Security","Electrical Engineering","Electronics and Telecommunication Engineering","Electronics and Telecommunication Engineering (SSC)","Energy Conservation and Management","Energy System Engineering","Geotechnical Engineering","Industrial Metallurgy","Master in Computer Application","Mechanical Engineering","Mechanical System Design","Metallurgical and Materials Engineering","Metallurgical Engineering","Power Electronics and Drives","Power System Engineering","Production Engineering","Structural Engineering","Thermal Engineering","Transportation Engineering","Wireless Communication Technology"};
		branch_box_2=new JComboBox(branch_arr_2);
		branch_box_2.setBounds(345,125,315,20);
		branch_box_2.setForeground(Color.BLACK);
		branch_box_2.setFont(ffffff);
		branch_box_2.setEnabled(false);

		//coordinators
		coord=new JCheckBox("Co-ordinators");
		coord.setBounds(275,150,150,25);
		coord.setOpaque(false);
		coord.setFont(f);
		coord.setEnabled(false);
		coord.addItemListener(this);

		//physics
		phy=new JCheckBox("Physics");
		phy.setBounds(295,170,100,25);
		phy.setOpaque(false);
		phy.setFont(ffff);
		phy.addItemListener(this);

		//chemistry
		chem=new JCheckBox("Chemistry");
		chem.setBounds(295,190,110,25);
		chem.setOpaque(false);
		chem.setFont(ffff);
		chem.addItemListener(this);

		//mathematics
		maths=new JCheckBox("Mathematics");
		maths.setBounds(295,210,120,25);
		maths.setOpaque(false);
		maths.setFont(ffff);
		maths.addItemListener(this);

		//english
		eng=new JCheckBox("English");
		eng.setBounds(295,230,100,25);
		eng.setOpaque(false);
		eng.setFont(ffff);
		eng.addItemListener(this);

		//workshop
		ws=new JCheckBox("Workshop");
		ws.setBounds(275,260,150,25);
		ws.setOpaque(false);
		ws.setFont(f);
		ws.setEnabled(false);
		ws.addItemListener(this);

		//carpentry
		carp=new JCheckBox("Carpentry");
		carp.setBounds(295,280,100,25);
		carp.setOpaque(false);
		carp.setFont(ffff);
		carp.addItemListener(this);

		//fitting
		fit=new JCheckBox("Fitting");
		fit.setBounds(295,300,100,25);
		fit.setOpaque(false);
		fit.setFont(ffff);
		fit.addItemListener(this);

		//welding
		weld=new JCheckBox("Welding");
		weld.setBounds(295,320,100,25);
		weld.setOpaque(false);
		weld.setFont(ffff);
		weld.addItemListener(this);

		//blacksmith
		bs=new JCheckBox("Blacksmith");
		bs.setBounds(295,340,100,25);
		bs.setOpaque(false);
		bs.setFont(ffff);
		bs.addItemListener(this);

		//turning
		turn=new JCheckBox("Turning");
		turn.setBounds(295,360,100,25);
		turn.setOpaque(false);
		turn.setFont(ffff);
		turn.addItemListener(this);

		//machine shop
		ms=new JCheckBox("Machine Shop");
		ms.setBounds(295,380,150,25);
		ms.setOpaque(false);
		ms.setFont(ffff);
		ms.addItemListener(this);

		//sheet metal
		sm=new JCheckBox("Sheet Metal");
		sm.setBounds(295,400,100,25);
		sm.setOpaque(false);
		sm.setFont(ffff);
		sm.addItemListener(this);

		//mounding
		mound=new JCheckBox("Mounding");
		mound.setBounds(295,420,100,25);
		mound.setOpaque(false);
		mound.setFont(ffff);
		mound.addItemListener(this);

		//library
		lib=new JCheckBox("Officer-in-Charge, Library");
		lib.setBounds(675,110,250,50);
		lib.setOpaque(false);
		lib.setFont(f);
		
		//cultural association
		cult=new JCheckBox("V.P., Cultural Association");
		cult.setBounds(675,140,250,50);
		cult.setOpaque(false);
		cult.setFont(f);
		
		//audio visual club
		avc=new JCheckBox("V.P., Audio Visual Club");
		avc.setBounds(675,170,250,50);
		avc.setOpaque(false);
		avc.setFont(f);
		
		//athletics
		athl=new JCheckBox("V.P., Athletics");
		athl.setBounds(675,200,250,50);
		athl.setOpaque(false);
		athl.setFont(f);

		//academic section
		acad=new JCheckBox("Academic Section");
		acad.setBounds(675,230,250,50);
		acad.setOpaque(false);
		acad.setFont(f);
		
		//examination section
		exam=new JCheckBox("Examination Section");
		exam.setBounds(675,260,250,50);
		exam.setOpaque(false);
		exam.setFont(f);
		
		//accounts section
		acc=new JCheckBox("Accounts Section");
		acc.setBounds(675,290,250,50);
		acc.setOpaque(false);
		acc.setFont(f);
		
		//book bank
		bb=new JCheckBox("Officer-in-Charge, Book Bank");
		bb.setBounds(675,320,275,50);
		bb.setOpaque(false);
		bb.setFont(f);
		
		//respective hostel
		host=new JCheckBox("Hostel Superintendent");
		host.setBounds(675,350,250,50);
		host.setOpaque(false);
		host.setFont(f);
		
		//ncc
		ncc=new JCheckBox("Programme Officer, NCC");
		ncc.setBounds(675,380,250,50);
		ncc.setOpaque(false);
		ncc.setFont(f);
		
		//nss
		nss=new JCheckBox("Programme Officer, NSS");
		nss.setBounds(675,410,250,50);
		nss.setOpaque(false);
		nss.setFont(f);

		//warning message of clearance page
		msg=new JLabel("");
		msg.setForeground(Color.RED);
		msg.setBounds(700,460,300,50);
		msg.setFont(f);

		//label for registration number in the print section
		reg_no=new JLabel("Enter Registration no");
		reg_no.setBounds(395,90,200,50);
		reg_no.setFont(f);

		//textfield for registration number in the print section
		regNo=new JTextField();
		regNo.setBounds(600,100,115,30);
		regNo.setFont(ffff);
		regNo.setCursor(cur2);

		//label for date of issue
		issue=new JLabel("Date of issue");
		issue.setBounds(400,150,150,25);
		issue.setFont(f);

		//comboboxes for date of issue
		//year
		String[] year_arr=new String[101];
		year_arr[0]="Year";
		for(int i=2018;i<=2117;i++)
			year_arr[i-2017]=Integer.toString(i);
		year=new JComboBox(year_arr);
		year.setBounds(525,150,75,25);
		year.setFont(fff);
		year.addItemListener(this);

		//month
		String[] month_arr={"Month","January","February","March","April","May","June","July","August","September","October","November","December"};
		month=new JComboBox(month_arr);
		month.setBounds(610,150,100,25);
		month.setFont(fff);
		month.addItemListener(this);

		//day
		String[] day_arr={"Day"};
		day=new JComboBox(day_arr);
		day.setBounds(720,150,65,25);
		day.setFont(fff);

		//checkbox for tc
		tc=new JCheckBox("Transfer Certificate");
		tc.setBounds(500,200,200,30);
		tc.setOpaque(false);
		tc.setFont(f);
		tc.setEnabled(false);

		//checkbox for coc
		coc=new JCheckBox("Conduct Certificate");
		coc.setBounds(500,250,200,30);
		coc.setOpaque(false);
		coc.setFont(f);
		coc.setEnabled(false);

		//warning message for print page
		print_warn=new JLabel("");
		print_warn.setBounds(550,400,500,200);
		print_warn.setFont(f);
		print_warn.setForeground(Color.RED);

		//textarea for tc
		tcPrint=new JTextArea();
		tcPrint.setBounds(25,141,535,650);
		tcPrint.setFont(f_f);
		tcPrint.setLineWrap(true);
		tcPrint.setWrapStyleWord(true);
		tcPrint.setRows(25);
		tcPrint.setColumns(25);
		//tcPrint.setEditable(false);

		//textarea for coc
		cocPrint=new JTextArea();
		cocPrint.setBounds(25,171,535,220);
		cocPrint.setFont(fcoc);
		cocPrint.setLineWrap(true);
		cocPrint.setWrapStyleWord(true);
		//cocPrint.setEditable(false);

		cocPrint2=new JTextArea();
		cocPrint2.setBounds(310,411,300,200);
		cocPrint2.setFont(fff);
		cocPrint2.setLineWrap(true);
		cocPrint2.setWrapStyleWord(true);
		cocPrint2.setEditable(false);

		//for the heading of the tc
		hl1=new JLabel("Schedule XIX-Form No.59");
		hl1.setFont(ffffff);
		hl1.setBounds(170,10,200,25);

		hta1=new JTextArea("No. ");
		hta1.setFont(ffffff);
		hta1.setBounds(500,10,60,15);

		hl2=new JLabel("<html>INDIRA GANDHI INSTITUTE OF TECHNOLOGY<br>SARANG-759146 (ODISHA)</html>");
		hl2.setFont(fbold);
		hl2.setBounds(170,15,400,60);

		hl3=new JLabel("<html>(FORM OF TRANSFER CERTIFICATE PRESCRIBED BY THE SYNDICATE UNDER<br> REGULATION 8 (2) OF CHAPTER XIX OF THE PATNA UNIVERSITY REGULATION)</html>");
		hl3.setFont(ffffff);
		hl3.setBounds(170,65,400,40);

		hl4=new JLabel("(AN AUTONOMOUS INSTITUTE OF GOVT. OF ODISHA)");
		hl4.setFont(fbold);
		hl4.setBounds(170,110,400,25);

		//for the heading of the coc
		hl5=new JLabel("<html>INDIRA GANDHI INSTITUTE OF TECHNOLOGY<br>SARANG-759146 (ODISHA)</html>");
		hl5.setFont(fbold);
		hl5.setBounds(170,10,400,60);

		hl6=new JLabel("(AN AUTONOMOUS INSTITUTE OF GOVT. OF ODISHA)");
		hl6.setFont(ffff);
		hl6.setBounds(170,80,400,25);

		hl7=new JLabel("CONDUCT  CERTIFICATE");
		hl7.setFont(ff);
		hl7.setBounds(150,135,300,30);

		hl8=new JLabel("Date: ");
		hl8.setFont(ffff);
		hl8.setBounds(450,100,200,25);

		//label for logo
		ImageIcon logo_img=new ImageIcon("IGIT.png");
		igitLogo1=new JLabel(logo_img);
		igitLogo1.setBounds(25,0,logo_img.getIconWidth(),logo_img.getIconHeight());

		igitLogo2=new JLabel(logo_img);
		igitLogo2.setBounds(25,0,logo_img.getIconWidth(),logo_img.getIconHeight());

		//ok button for clearance page
		ok=new JButton("OK");
		ok.setBounds(725,80,75,30);
		ok.setBackground(col2);
		ok.setForeground(Color.WHITE);
		ok.setCursor(cur1);
		ok.setFont(ffffff);
		ok.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					okAction(ae);
				}
			});

		//ok button for print page
		Ok=new JButton("OK");
		Ok.setBounds(725,100,75,30);
		Ok.setBackground(col2);
		Ok.setForeground(Color.WHITE);
		Ok.setCursor(cur1);
		Ok.setFont(ffffff);
		Ok.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					OkAction(ae);
				}
			});

		//login button for login page
		login_btn=new JButton("LOG IN");
		login_btn.setBackground(Color.BLACK);
		login_btn.setForeground(Color.WHITE);
		login_btn.setBounds(700,375,300,40);
		login_btn.setFont(fb);
		login_btn.setCursor(cur1);
		login_btn.setBorder(BorderFactory.createEmptyBorder());
		login_btn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				loginAction(ae);
			}
		});

		//reset button to reset all the entered data on the confirmation page
		reset=new JButton("Reset");
		reset.setBounds(420,325,100,50);
		reset.setBackground(col2);
		reset.setForeground(Color.WHITE);
		reset.setFont(fb);
		reset.setCursor(cur1);
		reset.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					resetAction(ae);
				}
			});

		//next button to go to the confirmation page
		next=new JButton("Next");
		next.setBounds(750,325,100,50);
		next.setBackground(col2);
		next.setForeground(Color.WHITE);
		next.setFont(fb);
		next.setCursor(cur1);
		next.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				nextAction(ae);
			}
		});
		
		//submit button to save the data of clearance section
		submit=new JButton("Submit");
		submit.setBounds(585,460,100,50);
		submit.setBackground(col2);
		submit.setForeground(Color.WHITE);
		submit.setFont(fb);
		submit.setCursor(cur1);
		submit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					submitAction(ae);
				}
			});

		//print button to print the certificate
		print=new JButton("Print");
		print.setBounds(550,400,100,50);
		print.setBackground(col2);
		print.setForeground(Color.WHITE);
		print.setFont(fb);
		print.setCursor(cur1);
		print.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				printAction(ae);
			}
		});

		//update button to go back to the data entry section to correct any mistake
		update=new JButton("Update");
		update.setBounds(420,460,100,50);
		update.setFont(fb);
		update.setBackground(col2);
		update.setForeground(Color.WHITE);
		update.setCursor(cur1);
		update.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					updateAction(ae);
				}
			});

		//submit button for saving the data of data entry section
		submit_2=new JButton("Submit");
		submit_2.setBounds(750,460,100,50);
		submit_2.setBackground(col2);
		submit_2.setForeground(Color.WHITE);
		submit_2.setFont(fb);
		submit_2.setCursor(cur1);
		submit_2.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					submit_2Action(ae);
				}
			});

		//home button to go to the first page
		home=new JButton("MAIN");
		home.setBounds(1000,470,150,50);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorder(BorderFactory.createEmptyBorder());
		home.setFont(fb);
		home.setCursor(cur1);
		home.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					homeAction(ae);
				}
			});

		//label for the countdown timer of the login page
		tl=new JLabel("");
		tl.setBounds(0,0,100,50);
		tl.setFont(f);
		tl.setForeground(Color.RED);

		//timer for activating login
		timeLeft=(double)30000;
		ActionListener countDown=new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				timeLeft-=100;
				SimpleDateFormat df=new SimpleDateFormat("mm:ss:S");
				tl.setText(df.format(timeLeft));
				if(timeLeft<=0)
				{
					timer.stop();
					un.setEditable(true);
					pw.setEditable(true);
					login_warn.setText("");
					timeLeft=(double)30000;
				}
			}
		};
		timer=new Timer(100,countDown);

		//logout button to go back to the login page
		logout=new JButton("LOG OUT");
		logout.setBounds(1100,470,150,50);
		logout.setOpaque(false);
		logout.setContentAreaFilled(false);
		logout.setBorder(BorderFactory.createEmptyBorder());
		logout.setFont(fb);
		logout.setCursor(cur1);
		logout.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					logoutAction(ae);
				}
			});

		//button to enter new data for another student in data entry section
		yes=new JButton("New");
		yes.setBounds(585,460,100,50);
		yes.setBackground(col2);
		yes.setForeground(Color.WHITE);
		yes.setCursor(cur1);
		yes.setFont(fb);
		yes.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					yesAction(ae);
				}
			});

		//button to print tc
		tc_button=new JButton("Print");
		tc_button.setBounds(700,470,100,50);
		tc_button.setBackground(col2);
		tc_button.setForeground(Color.WHITE);
		tc_button.setCursor(cur1);
		tc_button.setFont(fb);
		tc_button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					tcAction(ae);
				}
			});

		//button to print coc
		coc_button=new JButton("Print");
		coc_button.setBounds(700,470,100,50);
		coc_button.setBackground(col2);
		coc_button.setForeground(Color.WHITE);
		coc_button.setCursor(cur1);
		coc_button.setFont(fb);
		coc_button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					cocAction(ae);
				}
			});

		//go to print the coc from the tc page
		goToCoc=new JButton("Next");
		goToCoc.setBounds(850,470,100,50);
		goToCoc.setBackground(col2);
		goToCoc.setForeground(Color.WHITE);
		goToCoc.setCursor(cur1);
		goToCoc.setFont(fb);
		goToCoc.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
					goToCocAction(ae);
				}
			});

		view=new JButton("View");
		view.setBounds(585,325,100,50);
		view.setBackground(col2);
		view.setForeground(Color.WHITE);
		view.setCursor(cur1);
		view.setFont(fb);
		view.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				viewAction(ae);
			}
		});

		//reset button for clearance page
		reset_2=new JButton("Reset");
		reset_2.setBounds(385,460,100,50);
		reset_2.setBackground(col2);
		reset_2.setForeground(Color.WHITE);
		reset_2.setCursor(cur1);
		reset_2.setFont(f);
		reset_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				reset_2Action(ae);
			}
		});

		//adding all the panels to the main panel
		p.add(login_p,"First");
		p.add(p_s,"Second");
		p.add(p1,"Third");
		p.add(p_c,"Fourth");
		p.add(p2,"Fifth");
		p.add(p3,"Sixth");
		p.add(ptc,"Seventh");
		p.add(pcoc,"Eighth");

		//adding the components to the login panel
		login_p.add(login_text);
		login_p.add(login_btn);
		login_p.add(pw);
		login_p.add(un);
		login_p.add(tl);
		login_p.add(login_warn);
		login_p.add(warnLogin);
		login_p.add(l1);

		//adding components to the first page
		p_s.add(data);
		p_s.add(prt);
		p_s.add(clr);
		p_s.add(select);
		p_s.add(logout);
		p_s.add(l2);

		//adding components to the data entry section
		p1.add(reset);
		p1.add(next);
		p1.add(title);
		p1.add(name);
		p1.add(fn);
		p1.add(mn);
		p1.add(ln);
		p1.add(child);
		p1.add(gn);
		p1.add(roll);
		p1.add(rn1);
		p1.add(regd);
		p1.add(rn2);
		p1.add(course);
		p1.add(btech);
		p1.add(mtech);
		p1.add(barch);
		p1.add(dip);
		p1.add(mca);
		p1.add(null_gender);
		p1.add(null_course);
		p1.add(Native);
		p1.add(pl);
		p1.add(join);
		p1.add(jy);
		p1.add(pass);
		p1.add(py);
		p1.add(conduct);
		p1.add(cn);
		p1.add(fees);
		p1.add(feen);
		p1.add(gender);
		p1.add(male);
		p1.add(female);
		p1.add(third);
		p1.add(branch);
		p1.add(branch_box);
		p1.add(view);
		p1.add(view_label);
		p1.add(l3);

		//adding components to the confirmation page of data entry section
		p_c.add(update);
		p_c.add(submit_2);
		p_c.add(confT);
		p_c.add(confD);
		p_c.add(conf_2);
		p_c.add(yes);
		p_c.add(l4);

		//adding components to the clearance section
		p2.add(submit);
		p2.add(reset_2);
		p2.add(clrnce);
		p2.add(Hod);
		p2.add(regd_no);
		p2.add(regdNo);
		p2.add(ok);
		p2.add(coord);
		p2.add(phy);
		p2.add(chem);
		p2.add(maths);
		p2.add(eng);
		p2.add(ws);
		p2.add(carp);
		p2.add(fit);
		p2.add(weld);
		p2.add(bs);
		p2.add(turn);
		p2.add(ms); 
		p2.add(sm);
		p2.add(mound);
		p2.add(lib);
		p2.add(cult);
		p2.add(avc);
		p2.add(athl);
		p2.add(acad);
		p2.add(exam);
		p2.add(acc);
		p2.add(bb);
		p2.add(host);
		p2.add(ncc);
		p2.add(nss);
		p2.add(msg);
		p2.add(branch_box_2);
		p2.add(l5);

		//adding components to the print section
		p3.add(print);
		p3.add(regNo);
		p3.add(reg_no);
		p3.add(Ok);
		p3.add(issue);
		p3.add(day);
		p3.add(month);
		p3.add(year);
		p3.add(tc);
		p3.add(coc);
		p3.add(print_warn);
		p3.add(l6);
		
		//adding the components to the tc panel
		ptc.add(tcPanel);
		ptc.add(tc_button);
		ptc.add(goToCoc);
		ptc.add(l7);

		tcPanel.add(tcPrint);
		tcPanel.add(igitLogo1);
		tcPanel.add(hl1);
		tcPanel.add(hta1);
		tcPanel.add(hl2);
		tcPanel.add(hl3);
		tcPanel.add(hl4);

		//addint the components to the coc panel
		pcoc.add(cocPanel);
		pcoc.add(coc_button);
		pcoc.add(l8);

		cocPanel.add(cocPrint);
		cocPanel.add(cocPrint2);
		cocPanel.add(igitLogo2);
		cocPanel.add(hl5);
		cocPanel.add(hl6);
		cocPanel.add(hl7);
		cocPanel.add(hl8);

		//adding the main panel to the container
		c.add(p);
		c.add(topPanel);

		//adding the course radiobuttons to the buttongroup
		course_bg.add(btech);
		course_bg.add(mtech);
		course_bg.add(dip);
		course_bg.add(mca);
		course_bg.add(barch);
		course_bg.add(null_course);

		//adding the gender radiobuttons to the buttongroup
		gender_bg.add(male);
		gender_bg.add(female);
		gender_bg.add(third);
		gender_bg.add(null_gender);

		//adding the components to the topmost panel
		topPanel.add(topLabel);

		//load the Driver and establish a connection
		try
		{
		   Class.forName("com.mysql.jdbc.Driver");
		   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root123");
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }

	}

	static void loginAction(ActionEvent ae) //actions to be performed on click of the login button of the login page
	{
		try
		{
		String sql="select * from tab";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		boolean ex = false;
	    while(rs.next())
	    {
	   	if((rs.getString(1)).equals("LOGIN_TABLE"))
	   	  ex=true;
        }
        if(!ex)
        {
			Statement st = con.createStatement();
			String sql1 = "create table login_table(user_id varchar2(25),password varchar2(25))";
            boolean result = st.execute(sql1);

            String sql2 = "insert into login_table values('Admin','IGIT')";
            int status = st.executeUpdate(sql2);

        }

        String sq = "select * from login_table";
        PreparedStatement ps = con.prepareStatement(sq);
        ResultSet rs1 = ps.executeQuery();
        String u_id1="",pw1="";
        while(rs1.next())
        {
            u_id1 = rs1.getString("user_id");
            pw1 = rs1.getString("password");
        }

        String u_id2=un.getText();
        String pw2=pw.getText();

		if(u_id1.equals(u_id2) && pw1.equals(pw2))
		{
			cl.next(p);
			p_s.add(logout);
			p_s.add(l2);
		}
		else
		{
			if(pw2.equals("Password")||pw2.equals("")||u_id2.equals("User Name")||u_id2.equals(""))
			{
				if(login_warn.getText().equals("Wrong attempt! Left with 3 more attempts.")||login_warn.getText().equals("Wrong attempt! Left with 2 more attempts.")||login_warn.getText().equals("Wrong attempt! Left with 1 more attempt."))
					login_warn.setForeground(Color.BLACK);
				else
					login_warn.setText("Please enter user name and password!");
			}
			else
			{
				if(un.isEditable()==false&&pw.isEditable()==false)
				{
					login_warn.setText("");
				}
				else
				{
					login_warn.setForeground(Color.RED);
					if(login_warn.getText().equals("")||login_warn.getText().equals("Please enter user name and password!"))
						login_warn.setText("Wrong attempt! Left with 3 more attempts.");
					else if(login_warn.getText().equals("Wrong attempt! Left with 3 more attempts."))
						login_warn.setText("Wrong attempt! Left with 2 more attempts.");
					else if(login_warn.getText().equals("Wrong attempt! Left with 2 more attempts."))
						login_warn.setText("Wrong attempt! Left with 1 more attempt.");
					else if(login_warn.getText().equals("Wrong attempt! Left with 1 more attempt."))
					{
						login_warn.setText("");
						un.setText("User Name");
						un.setForeground(Color.GRAY);
						pw.setText("Password");
						pw.setForeground(Color.GRAY);
						un.setEditable(false);
						pw.setEditable(false);
						timer.start();
					}
				}
			}
		}
	  }
	  catch(Exception e)
	  {
	  	warnLogin.setText("Couldn't fetch login data");
	  }
	}

	static void resetAction(ActionEvent ae) //actions to be performed on click of the reset button of the data entry section
	{
		fn.setText("First Name");
		fn.setForeground(Color.GRAY);
		mn.setText("Middle Name");
		mn.setForeground(Color.GRAY);
		ln.setText("Last Name");
		ln.setForeground(Color.GRAY);
		gn.setText("");
		rn1.setText("");
		rn2.setText("");
		null_course.setSelected(true);
		feen.removeAllItems();
		feen.addItem("Select Semester");
		branch_box.removeAllItems();
		branch_box.addItem("Select Branch");
		jy.setSelectedItem("-select-");
		py.setSelectedItem("-select-");
		pl.setText("e.g. New Delhi");
		pl.setForeground(Color.GRAY);
		cn.setText("e.g. Good");
		cn.setForeground(Color.GRAY);
		feen.setSelectedItem("Select Semester");
		null_gender.setSelected(true);
		branch_box.setSelectedItem("Select Branch");
	}

	static void nextAction(ActionEvent ae) //actions to be performed on click of the next button of the data entry section
	{
		cl.next(p);
		p_c.add(home);
		p_c.add(logout);
		p_c.add(l4);
		nameC1=fn.getText();
		nameC2=mn.getText();
		nameC3=ln.getText();
		if(nameC1.equals("First Name"))
			nameC1="";
		if(nameC2.equals("Middle Name"))
			nameC2="";
		if(nameC3.equals("Last Name"))
			nameC3="";
		rollC=rn1.getText();
		regdC=rn2.getText();
		guardC=gn.getText();
		courseC="";
		if(btech.isSelected()==true)
			courseC="B.Tech";
		else if(barch.isSelected()==true)
			courseC="B.Arch";
		else if(mtech.isSelected()==true)
			courseC="M.Tech";
		else if(dip.isSelected()==true)
			courseC="Diploma";
		else if(mca.isSelected()==true)
			courseC="MCA";
		placeC=pl.getText();
		if(placeC.equals("e.g. New Delhi"))
			placeC="";
		conductC=cn.getText();
		if(conductC.equals("e.g. Good"))
			conductC="";
		jyC=(String)jy.getSelectedItem();
		if(jyC.equals("-select-"))
			jyC="";
		pyC=(String)py.getSelectedItem();
		if(pyC.equals("-select-"))
			pyC="";
		feesC=(String)feen.getSelectedItem();
		if(feesC.equals("Select Semester"))
			feesC="";
		genC="";
		if(male.isSelected()==true)
			genC="Male";
		else if(female.isSelected()==true)
			genC="Female";
		else if(third.isSelected()==true)
			genC="Other";
		branchC=(String)branch_box.getSelectedItem();
		if(branchC.equals("Select Branch"))
			branchC="";
		confT.setText("<html>Name:<br>Roll no:<br>Regd no:<br>Father's/Guardian's name:<br>Gender:<br>Course:<br>Branch:<br>Birth Place:<br>Conduct:<br>Year of joining:<br>Year of passing out:<br>Fees paid upto:</html>");
		confD.setText(nameC1+" "+nameC2+" "+nameC3+"\n"+rollC+"\n"+regdC+"\n"+guardC+"\n"+genC+"\n"+courseC+"\n"+branchC+"\n"+placeC+"\n"+conductC+"\n"+jyC+"\n"+pyC+"\n"+feesC);
		conf_2.setText("<html>Verify all the informations you entered before clicking Submit.<br>If you want to make any changes, click Update.</html>");
		view_label.setForeground(Color.BLACK);
		view_label.setText("<html>Enter the registration number and click on<br>View button to view existing student details</html>");
	}

	static void submitAction(ActionEvent ae) //actions to be performed on click of the submit button of the clearance section
	{
		try
		{
			 String c_hod = "";
			 if(Hod.isSelected())
			 	c_hod = "Yes";
			 else
			 	c_hod = "No";
			 String c_phys = "";
			 if(phy.isSelected())
			 	c_phys = "Yes";
			 else
			 	c_phys = "No";
			 String c_chem = "";
			 if(chem.isSelected())
			 	c_chem = "Yes";
			 else
			 	c_chem = "No";
			 String c_math = "";
			 if(maths.isSelected())
			 	c_math = "Yes";
			 else
			 	c_math = "No";
			 String c_eng = "";
			 if(eng.isSelected())
			 	c_eng = "Yes";
			 else
			 	c_eng = "No";
			 String c_carpentry = "";
			 if(carp.isSelected())
			 	c_carpentry = "Yes";
			 else
			 	c_carpentry = "No";
			 String c_fitting = "";
			 if(fit.isSelected())
			 	c_fitting = "Yes";
			 else
			 	c_fitting = "No";
			 String c_welding = "";
			 if(weld.isSelected())
			 	c_welding = "Yes";
			 else
			 	c_welding = "No";
			 String c_blacksmith = "";
			 if(bs.isSelected())
			 	c_blacksmith = "Yes";
			 else
			 	c_blacksmith = "No";
			 String c_turning = "";
			 if(turn.isSelected())
			 	c_turning = "Yes";
			 else
			 	c_turning = "No";
			 String c_machanine_shop = "";
			 if(ms.isSelected())
			 	c_machanine_shop = "Yes";
			 else
			 	c_machanine_shop = "No";
			 String c_sheet_metal = "";
			 if(sm.isSelected())
			 	c_sheet_metal = "Yes";
			 else
			 	c_sheet_metal = "No";
			 String c_mounding = "";
			 if(mound.isSelected())
			 	c_mounding = "Yes";
			 else
			 	c_mounding = "No";
			 String c_library = "";
			 if(lib.isSelected())
			 	c_library = "Yes";
			 else
			 	c_library = "No";
			 String c_cultural = "";
			 if(cult.isSelected())
			 	c_cultural = "Yes";
			 else
			 	c_cultural = "No";
			 String c_audio = "";
			 if(avc.isSelected())
			 	c_audio = "Yes";
			 else
			 	c_audio = "No";
			 String c_athletics = "";
			 if(athl.isSelected())
			 	c_athletics = "Yes";
			 else
			 	c_athletics = "No";
			 String c_academic = "";
			 if(acad.isSelected())
			 	c_academic = "Yes";
			 else
			 	c_academic = "No";
			 String c_Examination = "";
			 if(exam.isSelected())
			 	c_Examination = "Yes";
			 else
			 	c_Examination = "No";
			 String c_accounts = "";
			 if(acc.isSelected())
			 	c_accounts = "Yes";
			 else
			 	c_accounts = "No";
			 String c_book_bank = "";
			 if(bb.isSelected())
			 	c_book_bank = "Yes";
			 else
			 	c_book_bank = "No";
			 String c_hostel_superintendent = "";
			 if(host.isSelected())
			 	c_hostel_superintendent = "Yes";
			 else
			 	c_hostel_superintendent = "No";
			 String c_ncc = "";
			 if(ncc.isSelected())
			 	c_ncc = "Yes";
			 else
			 	c_ncc = "No";
			 String c_nss = "";
			 if(nss.isSelected())
			 	c_nss = "Yes";
			 else
			 	c_nss = "No"; 
		     int reg_no =Integer.parseInt(regdNo.getText());
             String sql = "update StudentDetails set c_hod=?,c_phys=?,c_chem=?,c_math=?,c_eng=?,c_carpentry=?,c_fitting=?,c_welding=?,c_blacksmith=?,c_turning=?,c_machanine_shop=?,c_sheet_metal=?,c_mounding=?,c_library=?,c_cultural=?,c_audio=?,c_athletics=?,c_academic=?,c_Examination=?,c_accounts=?,c_book_bank=?,c_hostel_superintendent=?,c_ncc=?,c_nss=? where reg_no=?";
             PreparedStatement pst = con.prepareStatement(sql);
             pst.setString(1,c_hod);
             pst.setString(2,c_phys);
             pst.setString(3,c_chem);
             pst.setString(4,c_math);
             pst.setString(5,c_eng );
             pst.setString(6,c_carpentry);
             pst.setString(7,c_fitting);
             pst.setString(8,c_welding);
             pst.setString(9,c_blacksmith);
             pst.setString(10,c_turning);
             pst.setString(11,c_machanine_shop);
             pst.setString(12,c_sheet_metal);
             pst.setString(13,c_mounding);
             pst.setString(14,c_library);
             pst.setString(15,c_cultural);
             pst.setString(16,c_audio);
             pst.setString(17,c_athletics);
             pst.setString(18,c_academic);
             pst.setString(19,c_Examination);
             pst.setString(20,c_accounts);
             pst.setString(21,c_book_bank);
             pst.setString(22,c_hostel_superintendent);
             pst.setString(23,c_ncc);
             pst.setString(24,c_nss);
             pst.setInt(25,reg_no);
             int status = pst.executeUpdate();
             //if the clearance section data is saved to database, then
             if(status>0)
          		msg.setText("Saved successfully!");

		}
		catch(Exception e)
		{
			msg.setText("Error in fetching the data");
		}
	}

	static void printAction(ActionEvent ae) //actions to be performed on click of the print button
	{
		print_warn.setText("");
		String yearC=(String)year.getSelectedItem();
		if(yearC.equals("Year"))
			yearC="";
		dayC=(String)day.getSelectedItem();
		if(dayC.equals("Day"))
			dayC="";
		m=(String)month.getSelectedItem();
		if(m.equals("Month"))
			m="";
		monthC="";
		if(m=="Month")
			monthC="";
		else if(m=="January")
			monthC="01";
		else if(m=="February")
			monthC="02";
		else if(m=="March")
			monthC="03";
		else if(m=="April")
			monthC="04";
		else if(m=="May")
			monthC="05";
		else if(m=="June")
			monthC="06";
		else if(m=="July")
			monthC="07";
		else if(m=="August")
			monthC="08";
		else if(m=="September")
			monthC="09";
		else if(m=="October")
			monthC="10";
		else if(m=="November")
			monthC="11";
		else if(m=="December")
			monthC="12";
		issueDateTc=""; issueDateCoc="";
		if((dayC.equals("")||monthC.equals("")||yearC.equals(""))&&(tc.isSelected()==false&&coc.isSelected()==false))
			print_warn.setText("Invalid selection!");
		else if((dayC.equals("")||monthC.equals("")||yearC.equals(""))&&(tc.isSelected()==true||coc.isSelected()==true))
		{
			issueDateTc="";
			issueDateCoc="";
			print_warn.setText("Please enter a valid date!");
		}
		else
		{
			issueDateTc="The "+dayC+" "+m+" of "+yearC;
			issueDateCoc=dayC+"/"+monthC+"/"+yearC;

			//feed the date into the database and print the selected certificates
			if(issueDateTc.equals("")||issueDateCoc.equals(""))
			{
				//nothing is to be done
			}
			else
			{
				if(tc.isSelected()==false&&coc.isSelected()==false)
				{
					//nothing is to be done
				}	
				else if(tc.isSelected()==true&&tc.isEnabled()==true)
				{
					try
					{
   						String sql = "select name,p_g_name,birth_place,course,yoj,yop,conduct,feespaid,gender from studentdetails where reg_no=?";
  		 				int reg_no = Integer.parseInt(regNo.getText());
  	 					PreparedStatement pst = con.prepareStatement(sql);
   						pst.setInt(1,reg_no);
   						ResultSet rs = pst.executeQuery();
   						while(rs.next())
  			 			{
  	 						String genC=rs.getString("gender");
							if(genC.equals("Male"))
								tcPrint.setText("Certified that "+rs.getString("name")+" son of "+rs.getString("p_g_name")+" an inhabitant of "+rs.getString("birth_place")+" has been a student in the "+rs.getString("course")+" class of Indira Gandhi Institute of Technology, Sarang from "+rs.getString("yoj")+" to "+rs.getString("yop")+". His conduct has been "+rs.getString("conduct")+". I know nothing against his character. All sums due by him to the college have been paid, including college fees upto "+rs.getString("feespaid")+".\n\nHis attendance in each course of lectures is given below.\n_________________________________________________________________________________________\nSUBJECT\n_________________________________________________________________________________________\nNumber of\nlectures\ndelivered\n_________________________________________________________________________________________\nAttended\n_________________________________________________________________________________________\nRemark- (Here entries may be made under Regulation 13 (1) of Chapter XIX of the Regulations).\n"+issueDateTc+"\n\n\n\n\n\t\t\t\t\tDEPUTY  REGISTRAR");
							else if(genC.equals("Female")||genC.equals("Other"))
								tcPrint.setText("Certified that "+rs.getString("name")+" daughter of "+rs.getString("p_g_name")+" an inhabitant of "+rs.getString("birth_place")+" has been a student in the "+rs.getString("course")+" class of Indira Gandhi Institute of Technology, Sarang from "+rs.getString("yoj")+" to "+rs.getString("yop")+". Her conduct has been "+rs.getString("conduct")+". I know nothing against her character. All sums due by her to the college have been paid, including college fees upto "+rs.getString("feespaid")+".\n\nHer attendance in each course of lectures is given below.\n_________________________________________________________________________________________\nSUBJECT\n_________________________________________________________________________________________\nNumber of\nlectures\ndelivered\n_________________________________________________________________________________________\nAttended\n_________________________________________________________________________________________\nRemark- (Here entries may be made under Regulation 13 (1) of Chapter XIX of the Regulations).\n"+issueDateTc+"\n\n\n\n\n\t\t\t\t\tDEPUTY  REGISTRAR");
						}
					}
					catch(Exception ee)
					{
						tcPrint.setText("Fetching error!");
					}
					try
					{
						String sql = "select name,course,yoj,yop,feespaid,conduct,gender from studentdetails where reg_no=?";
   						int reg_no = Integer.parseInt(regNo.getText());
   						PreparedStatement pst = con.prepareStatement(sql);
   						pst.setInt(1,reg_no);
   						ResultSet rs = pst.executeQuery();
   						while(rs.next())
   						{
   							String genC=rs.getString("gender");
				   			String courseC=rs.getString("course");
   							String feesC=rs.getString("feespaid");
							if(genC.equals("Male")&&((courseC.equals("B.Tech")&&feesC.equals("8th Semester"))||(courseC.equals("B.Arch")&&feesC.equals("10th Semester"))||(courseC.equals("Diploma")&&feesC.equals("6th Semester"))||(courseC.equals("M.Tech")&&feesC.equals("4th Semester"))||(courseC.equals("MCA")&&feesC.equals("6th Semester"))))
								cocPrint.setText("This is to certify that Shri "+rs.getString("name")+" was a student of "+rs.getString("course")+" course of this institution during the year "+rs.getString("yoj")+"-"+rs.getString("yop")+" and has passed "+rs.getString("feespaid")+".\n\n          His character and conduct were "+rs.getString("conduct")+".");
							else if((genC.equals("Female")||genC.equals("Other"))&&((courseC.equals("B.Tech")&&feesC.equals("8th Semester"))||(courseC.equals("B.Arch")&&feesC.equals("10th Semester"))||(courseC.equals("Diploma")&&feesC.equals("6th Semester"))||(courseC.equals("M.Tech")&&feesC.equals("4th Semester"))||(courseC.equals("MCA")&&feesC.equals("6th Semester"))))
								cocPrint.setText("This is to certify that Miss "+rs.getString("name")+" was a student of "+rs.getString("course")+" course of this institution during the year "+rs.getString("yoj")+"-"+rs.getString("yop")+" and has passed "+rs.getString("feespaid")+".\n\n          Her character and conduct were "+rs.getString("conduct")+".");
							else if(genC.equals("Male"))
								cocPrint.setText("This is to certify that Shri "+rs.getString("name")+" is a student of "+rs.getString("course")+" course of this institution during the year "+rs.getString("yoj")+"-"+rs.getString("yop")+" and has passed "+rs.getString("feespaid")+".\n\n          His character and conduct were "+rs.getString("conduct")+".");
							else if(genC.equals("Female"))
								cocPrint.setText("This is to certify that Miss "+rs.getString("name")+" is a student of "+rs.getString("course")+" course of this institution during the year "+rs.getString("yoj")+"-"+rs.getString("yop")+" and has passed "+rs.getString("feespaid")+".\n\n          Her character and conduct were "+rs.getString("conduct")+".");
							hl8.setText("Date :"+issueDateCoc);
						}
					}
					catch(Exception ee)
					{
						cocPrint.setText("Fetching error!");
					}
					cocPrint2.setText("                      DEAN\n           STUDENT WELFARE\n                IGIT, SARANG\nDist-Dhenkanal, Odisha-759146");
					cl.next(p);
					ptc.add(home);
					ptc.add(logout);
					ptc.add(l7);
				}
				else if(coc.isSelected()==true)
				{
					try
					{
						String sql = "select name,course,yoj,yop,feespaid,conduct,gender from studentdetails where reg_no=?";
			   			int reg_no = Integer.parseInt(regNo.getText());
			   			PreparedStatement pst = con.prepareStatement(sql);
			   			pst.setInt(1,reg_no);
			   			ResultSet rs = pst.executeQuery();
   						while(rs.next())
   						{
				   			String genC=rs.getString("gender");
   							String courseC=rs.getString("course");
   							String feesC=rs.getString("feespaid");
   							if(genC.equals("Male")&&((courseC.equals("B.Tech")&&feesC.equals("8th Semester"))||(courseC.equals("B.Arch")&&feesC.equals("10th Semester"))||(courseC.equals("Diploma")&&feesC.equals("6th Semester"))||(courseC.equals("M.Tech")&&feesC.equals("4th Semester"))||(courseC.equals("MCA")&&feesC.equals("6th Semester"))))
								cocPrint.setText("This is to certify that Shri "+rs.getString("name")+" was a student of "+rs.getString("course")+" course of this institution during the year "+rs.getString("yoj")+"-"+rs.getString("yop")+" and has passed "+rs.getString("feespaid")+".\n\n          His character and conduct were "+rs.getString("conduct")+".");
							else if((genC.equals("Female")||genC.equals("Other"))&&((courseC.equals("B.Tech")&&feesC.equals("8th Semester"))||(courseC.equals("B.Arch")&&feesC.equals("10th Semester"))||(courseC.equals("Diploma")&&feesC.equals("6th Semester"))||(courseC.equals("M.Tech")&&feesC.equals("4th Semester"))||(courseC.equals("MCA")&&feesC.equals("6th Semester"))))
								cocPrint.setText("This is to certify that Miss "+rs.getString("name")+" was a student of "+rs.getString("course")+" course of this institution during the year "+rs.getString("yoj")+"-"+rs.getString("yop")+" and has passed "+rs.getString("feespaid")+".\n\n          Her character and conduct were "+rs.getString("conduct")+".");
							else if(genC.equals("Male"))
								cocPrint.setText("This is to certify that Shri "+rs.getString("name")+" is a student of "+rs.getString("course")+" course of this institution during the year "+rs.getString("yoj")+"-"+rs.getString("yop")+" and has passed "+rs.getString("feespaid")+".\n\n          His character and conduct were "+rs.getString("conduct")+".");
							else if(genC.equals("Female"))
								cocPrint.setText("This is to certify that Miss "+rs.getString("name")+" is a student of "+rs.getString("course")+" course of this institution during the year "+rs.getString("yoj")+"-"+rs.getString("yop")+" and has passed "+rs.getString("feespaid")+".\n\n          Her character and conduct were "+rs.getString("conduct")+".");
							hl8.setText("Date :"+issueDateCoc);
						}
					}
					catch(Exception ee)
					{
						cocPrint.setText("Fetching error");
					}
					cocPrint2.setText("                      DEAN\n           STUDENT WELFARE\n                IGIT, SARANG\nDist-Dhenkanal, Odisha-759146");
					cl.next(p);
					cl.next(p);
					pcoc.add(home);
					pcoc.add(logout);
					pcoc.add(l8);
				}
			}
		}	
	}

	static void updateAction(ActionEvent ae) //actions to be performed on click of the update button of confirmation page
	{
		cl.previous(p);
		p1.add(home);
		p1.add(logout);
		p1.add(l3);
	}

	static void submit_2Action(ActionEvent ae) //actions to be performed on click of the submit button of the data entry section
	{
		try
		{
		String sql="select * from tab";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		boolean ex = false;
	    while(rs.next())
	    {
	   	if((rs.getString(1)).equals("STUDENTDETAILS"))
	   	  ex=true;
        }
        if(!ex)
        {
			Statement st = con.createStatement();
			String sql1 = "create table StudentDetails(name varchar2(40) not null,p_g_name varchar2(40) not null,roll varchar2(10) unique,reg_no number(15) primary key,course varchar2(6) not null,gender varchar2(6) not null,conduct varchar2(15) not null,yoj varchar2(4) check(yoj>=2010 and yoj<=2109),yop varchar2(4) check(yop>=2014 and yop<=2113),branch varchar2(70) not null,feespaid varchar2(12),birth_place varchar2(15) not null,c_hod varchar(3),c_phys varchar(3),c_chem varchar(3),c_math varchar(3),c_eng varchar(3),c_carpentry varchar(3),c_fitting varchar(3),c_welding varchar(3),c_blacksmith varchar(3),c_turning varchar(3),c_machanine_shop varchar(3),c_sheet_metal varchar(3),c_mounding varchar(3),c_library varchar(3),c_cultural varchar(3),c_audio varchar(3),c_athletics varchar(3),c_academic varchar(3),c_Examination varchar(3),c_accounts varchar(3),c_book_bank varchar(3),c_hostel_superintendent varchar(3),c_ncc varchar(3),c_nss varchar(3),doi_tc varchar2(30),doi_coc varchar2(30))";
            boolean result = st.execute(sql1);
        }
        String f1 = fn.getText();
        String m1 = mn.getText();
        String l1 = ln.getText();
        if(f1.equals("First Name"))
			f1="";
		if(m1.equals("Middle Name"))
			m1="";
		if(l1.equals("Last Name"))
			l1="";
        String name = f1+" " +m1+" " + l1;
        String p_g_name = gn.getText();
        String roll = rn1.getText();
        int reg_no = Integer.parseInt(rn2.getText());
        String course = "";
        if(btech.isSelected())
           course = btech.getText();
        else if(barch.isSelected())
            course = btech.getText();
        else if(mtech.isSelected())
            course = mtech.getText();
        else if(dip.isSelected())
            course = dip.getText();
        else if(mca.isSelected())
            course = mca.getText();
        String gender = "";
        if(male.isSelected())
        	gender = male.getText();
        else if(female.isSelected())
        	gender = female.getText();
        else if(third.isSelected())
        	gender = third.getText();
        String conduct = cn.getText();
        if(conduct.equals("e.g. Good"))
        	conduct = "";
        String yoj = (jy.getSelectedItem()).toString();
        if(yoj.equals("-select-"))
        	yoj="";
        String yop = (py.getSelectedItem()).toString();
        if(yop.equals("-select-"))
        	yoj="";
        String branch = branch_box.getSelectedItem().toString();
        if(branch.equals("Select Branch"))
			branch="";
        String feespaid = feen.getSelectedItem().toString();
        if(feespaid.equals("Select Semester"))
			feespaid="";
        String birth_place = pl.getText();
        if(birth_place.equals("e.g. New Delhi"))
        	birth_place="";

        String sq = "select count(*) from StudentDetails where reg_no =?";
        PreparedStatement sq_pst = con.prepareStatement(sq);
         sq_pst.setInt(1,reg_no);
		ResultSet res = sq_pst.executeQuery();
		int n=0;
		while(res.next())
		{
			n = res.getInt("count(*)");
		}
		
        if(n==1)
        {
        	String up = "update StudentDetails set name=?,p_g_name=?,roll=?,course=?,gender=?,conduct=?,yoj=?,yop=?,branch=?,feespaid=?,birth_place=? where reg_no=?";
            PreparedStatement up_pst = con.prepareStatement(up);
            up_pst.setString(1,name);
            up_pst.setString(2,p_g_name);
            up_pst.setString(3,roll);
        	up_pst.setString(4,course);
        	up_pst.setString(5,gender);
        	up_pst.setString(6,conduct);
        	up_pst.setString(7,yoj);
        	up_pst.setString(8,yop);
         	up_pst.setString(9,branch);
        	up_pst.setString(10,feespaid);
        	up_pst.setString(11,birth_place);
         	up_pst.setInt(12,reg_no);
            int up_status = up_pst.executeUpdate();

		//if the data is successfully stored in the database
        if(up_status>0)
        	conf_2.setText("updated successfully!");
        else
            conf_2.setText("Error in updating the data!");
        }
        else{
        String sql2 = "insert INTO StudentDetails (name,p_g_name,roll,reg_no,course,gender,conduct,yoj,yop,branch,feespaid,birth_place,c_hod,c_phys,c_chem,c_math,c_eng,c_carpentry,c_fitting,c_welding,c_blacksmith,c_turning,c_machanine_shop,c_sheet_metal,c_mounding,c_library,c_cultural,c_audio,c_athletics,c_academic,c_Examination,c_accounts,c_book_bank,c_hostel_superintendent,c_ncc,c_nss) values (?,?,?,?,?,?,?,?,?,?,?,?,'no','no','no','no','no','no','no','no','no','no','no','no','no','no','no','no','no','no','no','no','no','no','no','no')";
        PreparedStatement pst2 = con.prepareStatement(sql2);
        pst2.setString(1,name);
        pst2.setString(2,p_g_name);
        pst2.setString(3,roll);
        pst2.setInt(4,reg_no);
        pst2.setString(5,course);
        pst2.setString(6,gender);
        pst2.setString(7,conduct);
        pst2.setString(8,yoj);
        pst2.setString(9,yop);
        pst2.setString(10,branch);
        pst2.setString(11,feespaid);
        pst2.setString(12,birth_place);
        int status = pst2.executeUpdate();

		//if the data is successfully stored in the database
        if(status>0)
        	conf_2.setText("Saved successfully!");
        else
            conf_2.setText("Error in saving the data!");
        }

        }
        catch(Exception e){
        	conf_2.setText("Error!");
        }
	}

	static void yesAction(ActionEvent ae) //actions to be performed on the click of the yes button of the confirmation page
	{
		cl.previous(p);
		p1.add(logout);
		p1.add(home);
		p1.add(l3);
		fn.setText("First Name");
		fn.setForeground(Color.GRAY);
		mn.setText("Middle Name");
		mn.setForeground(Color.GRAY);
		ln.setText("Last Name");
		ln.setForeground(Color.GRAY);
		gn.setText("");
		rn1.setText("");
		rn2.setText("");
		null_course.setSelected(true);
		feen.removeAllItems();
		feen.addItem("Select Semester");
		branch_box.removeAllItems();
		branch_box.addItem("Select Branch");
		jy.setSelectedItem("-select-");
		py.setSelectedItem("-select-");
		pl.setText("e.g. New Delhi");
		pl.setForeground(Color.GRAY);
		cn.setText("e.g. Good");
		cn.setForeground(Color.GRAY);
		feen.setSelectedItem("Select Semester");
		null_gender.setSelected(true);
		branch_box.setSelectedItem("Select Branch");
	}

	static void dataAction(ActionEvent ae) //actions to be performed on click of "data entry section"
	{
		cl.next(p);
		p1.add(home);
		p1.add(logout);
		p1.add(l3);
	}
	
	static void clrAction(ActionEvent ae) //actions to be performed on click of "clearance section"
	{
		cl.next(p);
		cl.next(p);
		cl.next(p);
		p2.add(logout);
		p2.add(home);
		p2.add(l5);
	}
	
	static void prtAction(ActionEvent ae) //actions to be performed on click of "print section"
	{
		cl.next(p);
		cl.next(p);
		cl.next(p);
		cl.next(p);
		p3.add(home);
		p3.add(logout);
		p3.add(l6);
	}

	static void homeAction(ActionEvent ae) //actions to be perfrmed on click of home button
	{
		fn.setText("First Name");
		fn.setForeground(Color.GRAY);
		mn.setText("Middle Name");
		mn.setForeground(Color.GRAY);
		ln.setText("Last Name");
		ln.setForeground(Color.GRAY);
		gn.setText("");
		rn1.setText("");
		rn2.setText("");
		null_course.setSelected(true);
		feen.removeAllItems();
		feen.addItem("Select Semester");
		branch_box.removeAllItems();
		branch_box.addItem("Select Branch");
		jy.setSelectedItem("-select-");
		py.setSelectedItem("-select-");
		pl.setText("e.g. New Delhi");
		pl.setForeground(Color.GRAY);
		cn.setText("e.g. Good");
		cn.setForeground(Color.GRAY);
		feen.setSelectedItem("Select Semester");
		null_gender.setSelected(true);
		branch_box.setSelectedItem("Select Branch");
		msg.setText("");
		Hod.setSelected(false);
		coord.setEnabled(false);
		coord.setSelected(false);
		phy.setSelected(false);
		chem.setSelected(false);
		maths.setSelected(false);
		eng.setSelected(false);
		ws.setEnabled(false);
		ws.setSelected(false);
		carp.setSelected(false);
		fit.setSelected(false);
		weld.setSelected(false);
		bs.setSelected(false);
		turn.setSelected(false);
		ms.setSelected(false);
		sm.setSelected(false);
		mound.setSelected(false);
		lib.setSelected(false);
		cult.setSelected(false);
		avc.setSelected(false);
		athl.setSelected(false);
		acad.setSelected(false);
		exam.setSelected(false);
		acc.setSelected(false);
		bb.setSelected(false);
		host.setSelected(false);
		ncc.setSelected(false);
		nss.setSelected(false);
		regdNo.setText("");
		branch_box_2.setSelectedItem("--Branch--");
		regNo.setText("");
		year.setSelectedItem("Year");
		month.setSelectedItem("Month");
		day.setSelectedItem("Day");
		print_warn.setText("");
		tc.setSelected(false);
		tc.setEnabled(false);
		coc.setSelected(false);
		coc.setEnabled(false);
		cl.first(p);
		cl.next(p);
		p_s.add(logout);
		p_s.add(l2);
	}

	//all the focuslisteners are added for the textfields only
	//for first name
	static void firstFocusGained(FocusEvent fe) 
	{
		if(fn.getText().equals("First Name"))
		{
			fn.setText("");
			fn.setForeground(Color.BLACK);
		}
	}

	static void firstFocusLost(FocusEvent fe)
	{
		if(fn.getText().equals(""))
		{
			fn.setText("First Name");
			fn.setForeground(Color.GRAY);
		}
	}

	//for middle name
	static void middleFocusGained(FocusEvent fe)
	{
		if(mn.getText().equals("Middle Name"))
		{
			mn.setText("");
			mn.setForeground(Color.BLACK);
		}
	}

	static void middleFocusLost(FocusEvent fe)
	{
		if(mn.getText().equals(""))
		{
			mn.setText("Middle Name");
			mn.setForeground(Color.GRAY);
		}
	}

	//for last name
	static void lastFocusGained(FocusEvent fe)
	{
		if(ln.getText().equals("Last Name"))
		{
			ln.setText("");
			ln.setForeground(Color.BLACK);
		}
	}

	static void lastFocusLost(FocusEvent fe)
	{
		if(ln.getText().equals(""))
		{
			ln.setText("Last Name");
			ln.setForeground(Color.GRAY);
		}
	}

	//for birthplace
	static void placeFocusGained(FocusEvent fe)
	{
		if(pl.getText().equals("e.g. New Delhi"))
		{
			pl.setText("");
			pl.setForeground(Color.BLACK);
		}
	}

	static void placeFocusLost(FocusEvent fe)
	{
		if(pl.getText().equals(""))
		{
			pl.setText("e.g. New Delhi");
			pl.setForeground(Color.GRAY);
		}
	}

	//for conduct
	static void conductFocusGained(FocusEvent fe)
	{
		if(cn.getText().equals("e.g. Good"))
		{
			cn.setText("");
			cn.setForeground(Color.BLACK);
		}
	}

	static void conductFocusLost(FocusEvent fe)
	{
		if(cn.getText().equals(""))
		{
			cn.setText("e.g. Good");
			cn.setForeground(Color.GRAY);
		}
	}

	//itemevent for combobox and checkbox
	public void itemStateChanged(ItemEvent ie)
	{
		String year_item=(String)year.getSelectedItem();
		String month_item=(String)month.getSelectedItem();
		if(month_item.equals("February"))
		{
			if(year_item.equals("2020")||year_item.equals("2024")||year_item.equals("2028")||year_item.equals("2032")||year_item.equals("2036")||year_item.equals("2040")||year_item.equals("2044")||year_item.equals("2048")||year_item.equals("2052")||year_item.equals("2056")||year_item.equals("2060")||year_item.equals("2064")||year_item.equals("2068")||year_item.equals("2072")||year_item.equals("2076")||year_item.equals("2080")||year_item.equals("2084")||year_item.equals("2088")||year_item.equals("2092")||year_item.equals("2096")||year_item.equals("2104")||year_item.equals("2108")||year_item.equals("2112")||year_item.equals("2116"))
			{
				day.removeAllItems();
				day.addItem("Day");
				day.addItem("01");
				day.addItem("02");
				day.addItem("03");
				day.addItem("04");
				day.addItem("05");
				day.addItem("06");
				day.addItem("07");
				day.addItem("08");
				day.addItem("09");
				day.addItem("10");
				day.addItem("11");
				day.addItem("12");
				day.addItem("13");
				day.addItem("14");
				day.addItem("15");
				day.addItem("16");
				day.addItem("17");
				day.addItem("18");
				day.addItem("19");
				day.addItem("20");
				day.addItem("21");
				day.addItem("22");
				day.addItem("23");
				day.addItem("24");
				day.addItem("25");
				day.addItem("26");
				day.addItem("27");
				day.addItem("28");
				day.addItem("29");
			}
			else
			{
				day.removeAllItems();
				day.addItem("Day");
				day.addItem("01");
				day.addItem("02");
				day.addItem("03");
				day.addItem("04");
				day.addItem("05");
				day.addItem("06");
				day.addItem("07");
				day.addItem("08");
				day.addItem("09");
				day.addItem("10");
				day.addItem("11");
				day.addItem("12");
				day.addItem("13");
				day.addItem("14");
				day.addItem("15");
				day.addItem("16");
				day.addItem("17");
				day.addItem("18");
				day.addItem("19");
				day.addItem("20");
				day.addItem("21");
				day.addItem("22");
				day.addItem("23");
				day.addItem("24");
				day.addItem("25");
				day.addItem("26");
				day.addItem("27");
				day.addItem("28");
			}
		}
		else if(month_item.equals("April")||month_item.equals("June")||month_item.equals("September")||month_item.equals("November"))
		{
			day.removeAllItems();
			day.addItem("Day");
			day.addItem("01");
			day.addItem("02");
			day.addItem("03");
			day.addItem("04");
			day.addItem("05");
			day.addItem("06");
			day.addItem("07");
			day.addItem("08");
			day.addItem("09");
			day.addItem("10");
			day.addItem("11");
			day.addItem("12");
			day.addItem("13");
			day.addItem("14");
			day.addItem("15");
			day.addItem("16");
			day.addItem("17");
			day.addItem("18");
			day.addItem("19");
			day.addItem("20");
			day.addItem("21");
			day.addItem("22");
			day.addItem("23");
			day.addItem("24");
			day.addItem("25");
			day.addItem("26");
			day.addItem("27");
			day.addItem("28");
			day.addItem("29");
			day.addItem("30");
		}
		else
		{
			day.removeAllItems();
			day.addItem("Day");
			day.addItem("01");
			day.addItem("02");
			day.addItem("03");
			day.addItem("04");
			day.addItem("05");
			day.addItem("06");
			day.addItem("07");
			day.addItem("08");
			day.addItem("09");
			day.addItem("10");
			day.addItem("11");
			day.addItem("12");
			day.addItem("13");
			day.addItem("14");
			day.addItem("15");
			day.addItem("16");
			day.addItem("17");
			day.addItem("18");
			day.addItem("19");
			day.addItem("20");
			day.addItem("21");
			day.addItem("22");
			day.addItem("23");
			day.addItem("24");
			day.addItem("25");
			day.addItem("26");
			day.addItem("27");
 			day.addItem("28");
			day.addItem("29");
			day.addItem("30");
			day.addItem("31");
		}

		if(phy.isSelected()==true&&chem.isSelected()==true&&maths.isSelected()==true&&eng.isSelected()==true)
			coord.setEnabled(true);
		if(carp.isSelected()==true&&fit.isSelected()==true&&weld.isSelected()==true&&bs.isSelected()==true&&turn.isSelected()==true&&ms.isSelected()==true&&sm.isSelected()==true&&mound.isSelected()==true)
			ws.setEnabled(true);
		if(phy.isSelected()==false||chem.isSelected()==false||maths.isSelected()==false||eng.isSelected()==false)
		{
			coord.setEnabled(false);
			coord.setSelected(false);
		}
		if(carp.isSelected()==false||fit.isSelected()==false||weld.isSelected()==false||bs.isSelected()==false||turn.isSelected()==false||ms.isSelected()==false||sm.isSelected()==false||mound.isSelected()==false)
		{
			ws.setEnabled(false);
			ws.setSelected(false);
		}
	}

	static void btechAction(ActionEvent ae) //actions to be performed on selection of b.tech
	{
		//for semesters
		feen.removeAllItems();
		feen.addItem("Select Semester");
		feen.addItem("1st Semester");
		feen.addItem("2nd Semester");
		feen.addItem("3rd Semester");
		feen.addItem("4th Semester");
		feen.addItem("5th Semester");
		feen.addItem("6th Semester");
		feen.addItem("7th Semester");
		feen.addItem("8th Semester");
		//for branches
		branch_box.removeAllItems();
		branch_box.addItem("Select Branch");
		branch_box.addItem("Mechanical Engineering");
		branch_box.addItem("Civil Engineering");
		branch_box.addItem("Electrical Engineering");
		branch_box.addItem("Chemical Engineering");
		branch_box.addItem("Computer Science and Engineering (SSC)");
		branch_box.addItem("Metallurgical and Materials Engineering");
		branch_box.addItem("Electronics and Telecommunication Engineering (SSC)");
		branch_box.addItem("Production Engineering");
	}

	static void barchAction(ActionEvent ae) //actions to be performed on selection of b.arch
	{
		//for semesters
		feen.removeAllItems();
		feen.addItem("Select Semester");
		feen.addItem("1st Semester");
		feen.addItem("2nd Semester");
		feen.addItem("3rd Semester");
		feen.addItem("4th Semester");
		feen.addItem("5th Semester");
		feen.addItem("6th Semester");
		feen.addItem("7th Semester");
		feen.addItem("8th Semester");
		feen.addItem("9th Semester");
		feen.addItem("10th Semester");
		//for branches
		branch_box.removeAllItems();
		branch_box.addItem("Select Branch");
		branch_box.addItem("Architecture");
	}

	static void mtechAction(ActionEvent ae) //actions to be performed on selection of m.tech
	{
		//for semesters
		feen.removeAllItems();
		feen.addItem("Select Semester");
		feen.addItem("1st Semester");
		feen.addItem("2nd Semester");
		feen.addItem("3rd Semester");
		feen.addItem("4th Semester");
		//for branches
		branch_box.removeAllItems();
		branch_box.addItem("Select Branch");
		branch_box.addItem("Chemical Engineering");
		branch_box.addItem("Computer Science and Engineering");
		branch_box.addItem("Metallurgical and Materials Engineering");
		branch_box.addItem("Electronics and Telecommunication Engineering");
		branch_box.addItem("Production Engineering");
		branch_box.addItem("Computer Science and Information Security");
		branch_box.addItem("Energy Conservation and Management");
		branch_box.addItem("Energy System Engineering");
		branch_box.addItem("Geotechnical Engineering");
		branch_box.addItem("Industrial Metallurgy");
		branch_box.addItem("Mechanical System Design");
		branch_box.addItem("Power Electronics and Drives");
		branch_box.addItem("Power System Engineering");
		branch_box.addItem("Thermal Engineering");
		branch_box.addItem("Structural Engineering");
		branch_box.addItem("Transportation Engineering");
		branch_box.addItem("Wireless Communication Technology");
	}

	static void dipAction(ActionEvent ae) //actions to be performed on selection of diploma
	{
		//for semesters
		feen.removeAllItems();
		feen.addItem("Select Semester");
		feen.addItem("1st Semester");
		feen.addItem("2nd Semester");
		feen.addItem("3rd Semester");
		feen.addItem("4th Semester");
		feen.addItem("5th Semester");
		feen.addItem("6th Semester");
		//for branches
		branch_box.removeAllItems();
		branch_box.addItem("Select Branch");
		branch_box.addItem("Mechanical Engineering");
		branch_box.addItem("Civil Engineering");
		branch_box.addItem("Electrical Engineering");
		branch_box.addItem("Metallurgical and Materials Engineering");
		branch_box.addItem("Electronics and Telecommunication Engineering");
	}

	static void mcaAction(ActionEvent ae) //actions to be performed on selection of mca
	{
		//for semesters
		feen.removeAllItems();
		feen.addItem("Select Semester");
		feen.addItem("1st Semester");
		feen.addItem("2nd Semester");
		feen.addItem("3rd Semester");
		feen.addItem("4th Semester");
		feen.addItem("5th Semester");
		feen.addItem("6th Semester");
		//for branches
		branch_box.removeAllItems();
		branch_box.addItem("Select Branch");
		branch_box.addItem("Master in Computer Application");
	}

	//keyevents to make the text title case
	//first name
	static void firstTyped(KeyEvent ke)
	{
		if(fn.getText().equals(""))
		{
			char kc=ke.getKeyChar();
			if(Character.isLowerCase(kc))
				ke.setKeyChar(Character.toUpperCase(kc));
		}
	}

	//middle name
	static void middleTyped(KeyEvent ke)
	{
		if(mn.getText().equals(""))
		{
			char kc=ke.getKeyChar();
			if(Character.isLowerCase(kc))
				ke.setKeyChar(Character.toUpperCase(kc));
		}
	}

	//last name
	static void lastTyped(KeyEvent ke)
	{
		if(ln.getText().equals(""))
		{
			char kc=ke.getKeyChar();
			if(Character.isLowerCase(kc))
				ke.setKeyChar(Character.toUpperCase(kc));
		}
	}

	//guardian's name
	static void guardTyped(KeyEvent ke)
	{
		int chi=0;
		String st=gn.getText();
		int len=st.length();
		len--;
		if(len>=1)
		{
			char ch=st.charAt(len);
			chi=(int)ch;
		}
		if(st.equals("")||chi==32)
		{
			char kc=ke.getKeyChar();			
			if(Character.isLowerCase(kc))
				ke.setKeyChar(Character.toUpperCase(kc));
		}
	}

	//birth place
	static void placeTyped(KeyEvent ke)
	{
		int chi=0;
		String st=pl.getText();
		int len=st.length();
		len--;
		if(len>=1)
		{
			char ch=st.charAt(len);
			chi=(int)ch;
		}
		if(st.equals("")||chi==32)
		{
			char kc=ke.getKeyChar();
			if(Character.isLowerCase(kc))
				ke.setKeyChar(Character.toUpperCase(kc));
		}
	}

	//conduct
	static void conductTyped(KeyEvent ke)
	{
		if(cn.getText().equals(""))
		{
			char kc=ke.getKeyChar();
			if(Character.isLowerCase(kc))
				ke.setKeyChar(Character.toUpperCase(kc));
		}
	}

	//roll no
	static void rollTyped(KeyEvent ke)
	{
		char kc=ke.getKeyChar();
		if(Character.isLowerCase(kc))
				ke.setKeyChar(Character.toUpperCase(kc));
	}

	//focuslistener for username
	static void userFocusGained(FocusEvent fe)
	{
		if(un.getText().equals("User Name"))
		{
			un.setText("");
			un.setForeground(Color.BLACK);
		}
	}

	static void userFocusLost(FocusEvent fe)
	{
		if(un.getText().equals(""))
		{
			un.setText("User Name");
			un.setForeground(Color.GRAY);
		}
	}

	//focuslistener for password
	static void passFocusGained(FocusEvent fe)
	{
		if(pw.getText().equals("Password"))
		{
			pw.setText("");
			pw.setForeground(Color.BLACK);
		}
	}

	static void passFocusLost(FocusEvent fe)
	{
		if(pw.getText().equals(""))
		{
			pw.setText("Password");
			pw.setForeground(Color.GRAY);
		}
	}

	static void logoutAction(ActionEvent ae) //actions to be performed on click of the logout button
	{
		fn.setText("First Name");
		fn.setForeground(Color.GRAY);
		mn.setText("Middle Name");
		mn.setForeground(Color.GRAY);
		ln.setText("Last Name");
		ln.setForeground(Color.GRAY);
		gn.setText("");
		rn1.setText("");
		rn2.setText("");
		null_course.setSelected(true);
		feen.removeAllItems();
		feen.addItem("Select Semester");
		branch_box.removeAllItems();
		branch_box.addItem("Select Branch");
		jy.setSelectedItem("-select-");
		py.setSelectedItem("-select-");
		pl.setText("e.g. New Delhi");
		pl.setForeground(Color.GRAY);
		cn.setText("e.g. Good");
		cn.setForeground(Color.GRAY);
		feen.setSelectedItem("Select Semester");
		null_gender.setSelected(true);
		branch_box.setSelectedItem("Select Branch");
		msg.setText("");
		Hod.setSelected(false);
		coord.setEnabled(false);
		coord.setSelected(false);
		phy.setSelected(false);
		chem.setSelected(false);
		maths.setSelected(false);
		eng.setSelected(false);
		ws.setEnabled(false);
		ws.setSelected(false);
		carp.setSelected(false);
		fit.setSelected(false);
		weld.setSelected(false);
		bs.setSelected(false);
		turn.setSelected(false);
		ms.setSelected(false);
		sm.setSelected(false);
		mound.setSelected(false);
		lib.setSelected(false);
		cult.setSelected(false);
		avc.setSelected(false);
		athl.setSelected(false);
		acad.setSelected(false);
		exam.setSelected(false);
		acc.setSelected(false);
		bb.setSelected(false);
		host.setSelected(false);
		ncc.setSelected(false);
		nss.setSelected(false);
		regdNo.setText("");
		branch_box_2.setSelectedItem("--Branch--");
		regNo.setText("");
		year.setSelectedItem("Year");
		month.setSelectedItem("Month");
		day.setSelectedItem("Day");
		print_warn.setText("");
		cl.first(p);
		un.setText("User Name");
		un.setForeground(Color.GRAY);
		pw.setText("Password");
		pw.setForeground(Color.GRAY);
		p_s.add(logout);
		p_s.add(l2);
		login_warn.setText("");
	}

	static void okAction(ActionEvent ae) //actions to be performed on click of the ok button of the clearance page
	{
		//fetch data from database or reset all the fields
		msg.setText("");
		try
		{
		int reg_no = Integer.parseInt(regdNo.getText()); 
		PreparedStatement pst = con.prepareStatement("select branch,c_hod,c_phys,c_chem,c_math,c_eng,c_carpentry,c_fitting,c_welding,c_blacksmith,c_turning,c_machanine_shop,c_sheet_metal,c_mounding,c_library,c_cultural,c_audio,c_athletics,c_academic,c_Examination,c_accounts,c_book_bank,c_hostel_superintendent,c_ncc,c_nss from StudentDetails where reg_no=?");
		pst.setInt(1,reg_no); 
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
			branch_box_2.setSelectedItem(rs.getString("branch"));
            if(rs.getString("c_hod").equalsIgnoreCase("Yes"))
            	Hod.setSelected(true);
            else
            	Hod.setSelected(false);
            if(rs.getString("c_phys").equalsIgnoreCase("Yes"))
            	phy.setSelected(true);
            else
            	phy.setSelected(false);
            if(rs.getString("c_chem").equalsIgnoreCase("Yes"))
            	chem.setSelected(true);
            else
            	chem.setSelected(false);
            if(rs.getString("c_math").equalsIgnoreCase("Yes"))
            	maths.setSelected(true);
            else
            	maths.setSelected(false);
            if(rs.getString("c_eng").equalsIgnoreCase("Yes"))
            	eng.setSelected(true);
            else
            	eng.setSelected(false);
            if(rs.getString("c_carpentry").equalsIgnoreCase("Yes"))
            	carp.setSelected(true);
            else
            	carp.setSelected(false);
            if(rs.getString("c_fitting").equalsIgnoreCase("Yes"))
            	fit.setSelected(true);
            else
            	fit.setSelected(false);
            if(rs.getString("c_welding").equalsIgnoreCase("Yes"))
            	weld.setSelected(true);
            else
            	weld.setSelected(false);
            if(rs.getString("c_blacksmith").equalsIgnoreCase("Yes"))
            	bs.setSelected(true);
            else
            	bs.setSelected(false);
            if(rs.getString("c_turning").equalsIgnoreCase("Yes"))
            	turn.setSelected(true);
            else
            	turn.setSelected(false);
            if(rs.getString("c_machanine_shop").equalsIgnoreCase("Yes"))
            	ms.setSelected(true);
            else
            	ms.setSelected(false);
            if(rs.getString("c_sheet_metal").equalsIgnoreCase("Yes"))
            	sm.setSelected(true);
            else
            	sm.setSelected(false);
            if(rs.getString("c_mounding").equalsIgnoreCase("Yes"))
            	mound.setSelected(true);
            else
            	mound.setSelected(false);
            if(rs.getString("c_library").equalsIgnoreCase("Yes"))
            	lib.setSelected(true);
            else
            	lib.setSelected(false);
            if(rs.getString("c_cultural").equalsIgnoreCase("Yes"))
            	cult.setSelected(true);
            else
            	cult.setSelected(false);
            if(rs.getString("c_audio").equalsIgnoreCase("Yes"))
            	avc.setSelected(true);
            else
            	avc.setSelected(false);
            if(rs.getString("c_athletics").equalsIgnoreCase("Yes"))
            	athl.setSelected(true);
            else
            	athl.setSelected(false);
            if(rs.getString("c_academic").equalsIgnoreCase("Yes"))
            	acad.setSelected(true);
            else
            	acad.setSelected(false);
            if(rs.getString("c_Examination").equalsIgnoreCase("Yes"))
            	exam.setSelected(true);
            else
            	exam.setSelected(false);
            if(rs.getString("c_accounts").equalsIgnoreCase("Yes"))
            	acc.setSelected(true);
            else
            	acc.setSelected(false);
            if(rs.getString("c_book_bank").equalsIgnoreCase("Yes"))
            	bb.setSelected(true);
            else
            	bb.setSelected(false);
            if(rs.getString("c_hostel_superintendent").equalsIgnoreCase("Yes"))
            	host.setSelected(true);
            else
            	host.setSelected(false);
            if(rs.getString("c_ncc").equalsIgnoreCase("Yes"))
            	ncc.setSelected(true);
            else
            	ncc.setSelected(false);
           if(rs.getString("c_nss").equalsIgnoreCase("Yes"))
            	nss.setSelected(true);
            else
            	nss.setSelected(false);
           if(phy.isSelected()&&chem.isSelected()&&maths.isSelected()&&eng.isSelected())
           {
           	coord.setSelected(true);
           coord.setEnabled(true);
           }
           else
           {
           	coord.setSelected(false);
           	coord.setEnabled(false);
           }
           if(carp.isSelected()&&fit.isSelected()&&weld.isSelected()&&bs.isSelected()&&turn.isSelected()&&ms.isSelected()&&sm.isSelected()&&mound.isSelected())
           {
           	ws.setSelected(true);
           	ws.setEnabled(true);
           }
           else
           {
           	ws.setSelected(false);
           	ws.setEnabled(false);
           }
		}
	    }
	    catch(Exception e)
	    {
	    	Hod.setSelected(false);
            phy.setSelected(false);
            chem.setSelected(false);
            maths.setSelected(false);
            eng.setSelected(false);
            carp.setSelected(false);
            fit.setSelected(false);
            weld.setSelected(false);
            bs.setSelected(false);
            turn.setSelected(false);
            ms.setSelected(false);
            sm.setSelected(false);
            mound.setSelected(false);
			lib.setSelected(false);
            cult.setSelected(false);
            avc.setSelected(false);
            athl.setSelected(false);
            acad.setSelected(false);
            exam.setSelected(false);
            acc.setSelected(false);
            bb.setSelected(false);
            host.setSelected(false);
            ncc.setSelected(false);
            nss.setSelected(false);
            if(phy.isSelected()&&chem.isSelected()&&maths.isSelected()&&eng.isSelected())
           {
           	coord.setSelected(true);
           coord.setEnabled(true);
           }
           else
           {
           	coord.setSelected(false);
           	coord.setEnabled(false);
           }
           if(carp.isSelected()&&fit.isSelected()&&weld.isSelected()&&bs.isSelected()&&turn.isSelected()&&ms.isSelected()&&sm.isSelected()&&mound.isSelected())
           {
           	ws.setSelected(true);
           	ws.setEnabled(true);
           }
           else
           {
           	ws.setSelected(false);
           	ws.setEnabled(false);
           }
	    }
	}

	//keylisteners for login page
	static void userAction(KeyEvent ke)
	{
		int av=(int)ke.getKeyChar();
		if(av==10)
		{
			try
		{
		String sql="select * from tab";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		boolean ex = false;
	    while(rs.next())
	    {
	   	if((rs.getString(1)).equals("LOGIN_TABLE"))
	   	  ex=true;
        }
        if(!ex)
        {
			Statement st = con.createStatement();
			String sql1 = "create table login_table(user_id varchar2(25),password varchar2(25))";
            boolean result = st.execute(sql1);

            String sql2 = "insert into login_table values('Admin','IGIT')";
            int status = st.executeUpdate(sql2);

        }

        String sq = "select * from login_table";
        PreparedStatement ps = con.prepareStatement(sq);
        ResultSet rs1 = ps.executeQuery();
        String u_id1="",pw1="";
        while(rs1.next())
        {
            u_id1 = rs1.getString("user_id");
            pw1 = rs1.getString("password");
        }

        String u_id2=un.getText();
        String pw2=pw.getText();

		if(u_id1.equals(u_id2) && pw1.equals(pw2))
		{
			cl.next(p);
			p_s.add(logout);
			p_s.add(l2);
		}
		else
		{
			if(pw2.equals("Password")||pw2.equals("")||u_id2.equals("User Name")||u_id2.equals(""))
			{
				if(login_warn.getText().equals("Wrong attempt! Left with 3 more attempts.")||login_warn.getText().equals("Wrong attempt! Left with 2 more attempts.")||login_warn.getText().equals("Wrong attempt! Left with 1 more attempt."))
					login_warn.setForeground(Color.BLACK);
				else
					login_warn.setText("Please enter user name and password!");
			}
			else
			{
				if(un.isEditable()==false&&pw.isEditable()==false)
				{
					login_warn.setText("");
				}
				else
				{
					login_warn.setForeground(Color.RED);
					if(login_warn.getText().equals("")||login_warn.getText().equals("Please enter user name and password!"))
						login_warn.setText("Wrong attempt! Left with 3 more attempts.");
					else if(login_warn.getText().equals("Wrong attempt! Left with 3 more attempts."))
						login_warn.setText("Wrong attempt! Left with 2 more attempts.");
					else if(login_warn.getText().equals("Wrong attempt! Left with 2 more attempts."))
						login_warn.setText("Wrong attempt! Left with 1 more attempt.");
					else if(login_warn.getText().equals("Wrong attempt! Left with 1 more attempt."))
					{
						login_warn.setText("");
						un.setText("User Name");
						un.setForeground(Color.GRAY);
						pw.setText("Password");
						pw.setForeground(Color.GRAY);
						un.setEditable(false);
						pw.setEditable(false);
						timer.start();
					}
				}
			}
		}
	  }
	  catch(Exception e)
	  {
	  	warnLogin.setText("Couldn't fetch login data");
	  }
		}
	}

	static void passAction(KeyEvent ke)
	{
		int av=(int)ke.getKeyChar();
		if(av==10)
		{
			try
		{
		String sql="select * from tab";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		boolean ex = false;
	    while(rs.next())
	    {
	   	if((rs.getString(1)).equals("LOGIN_TABLE"))
	   	  ex=true;
        }
        if(!ex)
        {
			Statement st = con.createStatement();
			String sql1 = "create table login_table(user_id varchar2(25),password varchar2(25))";
            boolean result = st.execute(sql1);

            String sql2 = "insert into login_table values('Admin','IGIT')";
            int status = st.executeUpdate(sql2);

        }

        String sq = "select * from login_table";
        PreparedStatement ps = con.prepareStatement(sq);
        ResultSet rs1 = ps.executeQuery();
        String u_id1="",pw1="";
        while(rs1.next())
        {
            u_id1 = rs1.getString("user_id");
            pw1 = rs1.getString("password");
        }

        String u_id2=un.getText();
        String pw2=pw.getText();

		if(u_id1.equals(u_id2) && pw1.equals(pw2))
		{
			cl.next(p);
			p_s.add(logout);
			p_s.add(l2);
		}
		else
		{
			if(pw2.equals("Password")||pw2.equals("")||u_id2.equals("User Name")||u_id2.equals(""))
			{
				if(login_warn.getText().equals("Wrong attempt! Left with 3 more attempts.")||login_warn.getText().equals("Wrong attempt! Left with 2 more attempts.")||login_warn.getText().equals("Wrong attempt! Left with 1 more attempt."))
					login_warn.setForeground(Color.BLACK);
				else
					login_warn.setText("Please enter user name and password!");
			}
			else
			{
				if(un.isEditable()==false&&pw.isEditable()==false)
				{
					login_warn.setText("");
				}
				else
				{
					login_warn.setForeground(Color.RED);
					if(login_warn.getText().equals("")||login_warn.getText().equals("Please enter user name and password!"))
						login_warn.setText("Wrong attempt! Left with 3 more attempts.");
					else if(login_warn.getText().equals("Wrong attempt! Left with 3 more attempts."))
						login_warn.setText("Wrong attempt! Left with 2 more attempts.");
					else if(login_warn.getText().equals("Wrong attempt! Left with 2 more attempts."))
						login_warn.setText("Wrong attempt! Left with 1 more attempt.");
					else if(login_warn.getText().equals("Wrong attempt! Left with 1 more attempt."))
					{
						login_warn.setText("");
						un.setText("User Name");
						un.setForeground(Color.GRAY);
						pw.setText("Password");
						pw.setForeground(Color.GRAY);
						un.setEditable(false);
						pw.setEditable(false);
						timer.start();
					}
				}
			}
		}
	  }
	  catch(Exception e)
	  {
	  	warnLogin.setText("Couldn't fetch login data");
	  }
		}
	}

	static void OkAction(ActionEvent ae) //actions to be performed on click of the ok button of the print page
	{
		try
		{
        String sql ="Select c_hod,c_phys,c_chem,c_math,c_eng,c_carpentry,c_fitting,c_welding,c_blacksmith,c_turning,c_machanine_shop,c_sheet_metal,c_mounding,c_library,c_cultural,c_audio,c_athletics,c_academic,c_Examination,c_accounts,c_book_bank,c_hostel_superintendent,c_ncc,c_nss,doi_tc from StudentDetails where reg_no=?";
        PreparedStatement pst = con.prepareStatement(sql);
        int reg_no = Integer.parseInt(regNo.getText());
        pst.setInt(1,reg_no); 
        ResultSet rs = pst.executeQuery();
        String doi_tc1 ;
        while(rs.next())
        {
            doi_tc1 = rs.getString("doi_tc");
            if(doi_tc1==null&&rs.getString("c_hod").equalsIgnoreCase("Yes")&&rs.getString("c_phys").equalsIgnoreCase("Yes")&&rs.getString("c_chem").equalsIgnoreCase("Yes")&&rs.getString("c_math").equalsIgnoreCase("Yes")&&rs.getString("c_eng").equalsIgnoreCase("Yes")&&rs.getString("c_carpentry").equalsIgnoreCase("Yes")&&rs.getString("c_fitting").equalsIgnoreCase("Yes")&&rs.getString("c_welding").equalsIgnoreCase("Yes")&&rs.getString("c_blacksmith").equalsIgnoreCase("Yes")&&rs.getString("c_turning").equalsIgnoreCase("Yes")&&rs.getString("c_machanine_shop").equalsIgnoreCase("Yes")&&rs.getString("c_sheet_metal").equalsIgnoreCase("Yes")&&rs.getString("c_mounding").equalsIgnoreCase("Yes")&&rs.getString("c_library").equalsIgnoreCase("Yes")&&rs.getString("c_cultural").equalsIgnoreCase("Yes")&&rs.getString("c_audio").equalsIgnoreCase("Yes")&&rs.getString("c_athletics").equalsIgnoreCase("Yes")&&rs.getString("c_academic").equalsIgnoreCase("Yes")&&rs.getString("c_Examination").equalsIgnoreCase("Yes")&&rs.getString("c_accounts").equalsIgnoreCase("Yes")&&rs.getString("c_book_bank").equalsIgnoreCase("Yes")&&rs.getString("c_hostel_superintendent").equalsIgnoreCase("Yes")&&rs.getString("c_ncc").equalsIgnoreCase("Yes")&&rs.getString("c_nss").equalsIgnoreCase("Yes"))
            {
            	tc.setEnabled(true);
            	coc.setEnabled(true);
            }
           else if(rs.getString("c_hod").equalsIgnoreCase("Yes")&&rs.getString("c_phys").equalsIgnoreCase("Yes")&&rs.getString("c_chem").equalsIgnoreCase("Yes")&&rs.getString("c_math").equalsIgnoreCase("Yes")&&rs.getString("c_eng").equalsIgnoreCase("Yes")&&rs.getString("c_carpentry").equalsIgnoreCase("Yes")&&rs.getString("c_fitting").equalsIgnoreCase("Yes")&&rs.getString("c_welding").equalsIgnoreCase("Yes")&&rs.getString("c_blacksmith").equalsIgnoreCase("Yes")&&rs.getString("c_turning").equalsIgnoreCase("Yes")&&rs.getString("c_machanine_shop").equalsIgnoreCase("Yes")&&rs.getString("c_sheet_metal").equalsIgnoreCase("Yes")&&rs.getString("c_mounding").equalsIgnoreCase("Yes")&&rs.getString("c_library").equalsIgnoreCase("Yes")&&rs.getString("c_cultural").equalsIgnoreCase("Yes")&&rs.getString("c_audio").equalsIgnoreCase("Yes")&&rs.getString("c_athletics").equalsIgnoreCase("Yes")&&rs.getString("c_academic").equalsIgnoreCase("Yes")&&rs.getString("c_Examination").equalsIgnoreCase("Yes")&&rs.getString("c_accounts").equalsIgnoreCase("Yes")&&rs.getString("c_book_bank").equalsIgnoreCase("Yes")&&rs.getString("c_hostel_superintendent").equalsIgnoreCase("Yes")&&rs.getString("c_ncc").equalsIgnoreCase("Yes")&&rs.getString("c_nss").equalsIgnoreCase("Yes"))
            {
            	tc.setEnabled(false);
            	tc.setSelected(false);
            	coc.setEnabled(true);
            }
            else
            {
            	tc.setEnabled(false);
            	tc.setSelected(false);
            	coc.setEnabled(false);
            	coc.setSelected(false);
            }
        }
        }
        catch(Exception e)
        {
        	print_warn.setText("Couldn't fetch data!");
        }
	}

	static void tcAction(ActionEvent ae) //actions to be performed on click of the print button on the tc page
	{
		try
			{
		    int reg_no = Integer.parseInt(regNo.getText());
			String sql =  "update StudentDetails set doi_tc=? where reg_no=?";
            PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,issueDateTc);
			pst.setInt(2,reg_no);
            int result = pst.executeUpdate();
            }
		catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		PrintUtilities.printComponent(tcPanel);
	}

	static void cocAction(ActionEvent ae) //actions to be performed on click of the print button on the coc page
	{
		try
			{
		    int reg_no = Integer.parseInt(regNo.getText());
			String sql =  "update StudentDetails set doi_coc=? where reg_no=?";
            PreparedStatement pst = con.prepareStatement(sql);
		    pst.setString(1,issueDateCoc);
			pst.setInt(2,reg_no);
            int result = pst.executeUpdate();
            }
		catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		PrintUtilities.printComponent(cocPanel);
	}

	static void goToCocAction(ActionEvent ae) //actions to be performed on the click of the next button present in the tc page
	{
		if(coc.isSelected()==true&&coc.isEnabled()==true)
		{
			cl.next(p);
			pcoc.add(home);
			pcoc.add(logout);
			pcoc.add(l8);
		}
	}

	static void viewAction(ActionEvent ae) //actions to be performed on click of the view button
	{
		try
		{
		String sql = "select name,p_g_name,roll,course,gender,conduct,yoj,yop,branch,feespaid,birth_place from StudentDetails where reg_no=?";
		PreparedStatement pst = con.prepareStatement(sql);
		int reg_no = Integer.parseInt(rn2.getText()); 
	    pst.setInt(1,reg_no); 
		ResultSet rs = pst.executeQuery();
	    while(rs.next())
	    {
	    	String ob =rs.getString("name");
	    	String o[] = ob.split(" "); 
	       fn.setText(o[0]);
           mn.setText(o[1]);
           ln.setText(o[2]);
           gn.setText(rs.getString("p_g_name"));
           fn.setForeground(Color.BLACK);
           mn.setForeground(Color.BLACK);
           ln.setForeground(Color.BLACK);
           gn.setForeground(Color.BLACK);
           rn1.setText(rs.getString("roll"));
        String course = rs.getString("course");
        if(course.equals("B.Tech"))
        {
           btech.setSelected(true);
           //for semesters
		feen.removeAllItems();
		feen.addItem("Select Semester");
		feen.addItem("1st Semester");
		feen.addItem("2nd Semester");
		feen.addItem("3rd Semester");
		feen.addItem("4th Semester");
		feen.addItem("5th Semester");
		feen.addItem("6th Semester");
		feen.addItem("7th Semester");
		feen.addItem("8th Semester");
		//for branches
		branch_box.removeAllItems();
		branch_box.addItem("Select Branch");
		branch_box.addItem("Mechanical Engineering");
		branch_box.addItem("Civil Engineering");
		branch_box.addItem("Electrical Engineering");
		branch_box.addItem("Chemical Engineering");
		branch_box.addItem("Computer Science and Engineering (SSC)");
		branch_box.addItem("Metallurgical and Materials Engineering");
		branch_box.addItem("Electronics and Telecommunication Engineering (SSC)");
		branch_box.addItem("Production Engineering");
        }
        else if(course.equals("B.Arch"))
        {
            barch.setSelected(true);
            //for semesters
		feen.removeAllItems();
		feen.addItem("Select Semester");
		feen.addItem("1st Semester");
		feen.addItem("2nd Semester");
		feen.addItem("3rd Semester");
		feen.addItem("4th Semester");
		feen.addItem("5th Semester");
		feen.addItem("6th Semester");
		feen.addItem("7th Semester");
		feen.addItem("8th Semester");
		feen.addItem("9th Semester");
		feen.addItem("10th Semester");
		//for branches
		branch_box.removeAllItems();
		branch_box.addItem("Select Branch");
		branch_box.addItem("Architecture");
        }
        else if(course.equals("M.Tech"))
        {
           mtech.setSelected(true);
           //for semesters
		feen.removeAllItems();
		feen.addItem("Select Semester");
		feen.addItem("1st Semester");
		feen.addItem("2nd Semester");
		feen.addItem("3rd Semester");
		feen.addItem("4th Semester");
		//for branches
		branch_box.removeAllItems();
		branch_box.addItem("Select Branch");
		branch_box.addItem("Chemical Engineering");
		branch_box.addItem("Computer Science and Engineering");
		branch_box.addItem("Metallurgical and Materials Engineering");
		branch_box.addItem("Electronics and Telecommunication Engineering");
		branch_box.addItem("Production Engineering");
		branch_box.addItem("Computer Science and Information Security");
		branch_box.addItem("Energy Conservation and Management");
		branch_box.addItem("Energy System Engineering");
		branch_box.addItem("Geotechnical Engineering");
		branch_box.addItem("Industrial Metallurgy");
		branch_box.addItem("Mechanical System Design");
		branch_box.addItem("Power Electronics and Drives");
		branch_box.addItem("Power System Engineering");
		branch_box.addItem("Thermal Engineering");
		branch_box.addItem("Structural Engineering");
		branch_box.addItem("Transportation Engineering");
		branch_box.addItem("Wireless Communication Technology");
        }
        else if(course.equals("Diploma"))
        {
            dip.setSelected(true);
            //for semesters
		feen.removeAllItems();
		feen.addItem("Select Semester");
		feen.addItem("1st Semester");
		feen.addItem("2nd Semester");
		feen.addItem("3rd Semester");
		feen.addItem("4th Semester");
		feen.addItem("5th Semester");
		feen.addItem("6th Semester");
		//for branches
		branch_box.removeAllItems();
		branch_box.addItem("Select Branch");
		branch_box.addItem("Mechanical Engineering");
		branch_box.addItem("Civil Engineering");
		branch_box.addItem("Electrical Engineering");
		branch_box.addItem("Metallurgical and Materials Engineering");
		branch_box.addItem("Electronics and Telecommunication Engineering");
        }
        else if(course.equals("MCA"))
        {
            mca.setSelected(true);
            //for semesters
		feen.removeAllItems();
		feen.addItem("Select Semester");
		feen.addItem("1st Semester");
		feen.addItem("2nd Semester");
		feen.addItem("3rd Semester");
		feen.addItem("4th Semester");
		feen.addItem("5th Semester");
		feen.addItem("6th Semester");
		//for branches
		branch_box.removeAllItems();
		branch_box.addItem("Select Branch");
		branch_box.addItem("Master in Computer Application");
        }
        String gender = rs.getString("gender");
        if(gender.equals("Male"))
        	male.setSelected(true);
        else if(gender.equals("Female"))
        	female.setSelected(true);
        else if(gender.equals("Other"))
        	third.setSelected(true);
        cn.setText(rs.getString("conduct"));
        cn.setForeground(Color.BLACK);
        jy.setSelectedItem(rs.getString("yoj")); 
        py.setSelectedItem(rs.getString("yop"));
        branch_box.setSelectedItem(rs.getString("branch"));
        feen.setSelectedItem(rs.getString("feespaid")); 
        pl.setText(rs.getString("birth_place"));
        pl.setForeground(Color.BLACK);
	    }
	    }
	    catch(Exception e)
	    {
           view_label.setText("Please enter a valid registration number!");
           view_label.setForeground(Color.RED);
	    }
	}

	static void reset_2Action(ActionEvent ae)
	{
		msg.setText("");
		Hod.setSelected(false);
		coord.setEnabled(false);
		coord.setSelected(false);
		phy.setSelected(false);
		chem.setSelected(false);
		maths.setSelected(false);
		eng.setSelected(false);
		ws.setEnabled(false);
		ws.setSelected(false);
		carp.setSelected(false);
		fit.setSelected(false);
		weld.setSelected(false);
		bs.setSelected(false);
		turn.setSelected(false);
		ms.setSelected(false);
		sm.setSelected(false);
		mound.setSelected(false);
		lib.setSelected(false);
		cult.setSelected(false);
		avc.setSelected(false);
		athl.setSelected(false);
		acad.setSelected(false);
		exam.setSelected(false);
		acc.setSelected(false);
		bb.setSelected(false);
		host.setSelected(false);
		ncc.setSelected(false);
		nss.setSelected(false);
		regdNo.setText("");
		branch_box_2.setSelectedItem("--Branch--");
	}
}

class PrintUtilities implements Printable //print class
{
	private Component componentToBePrinted;
	public static void printComponent(Component c)
	{
		new PrintUtilities(c).print();
	}
	public PrintUtilities(Component componentToBePrinted)
	{
		this.componentToBePrinted = componentToBePrinted;
	}
	public void print()
	{
		PrinterJob printJob = PrinterJob.getPrinterJob();
		printJob.setPrintable(this);
		if (printJob.printDialog())
		{
			try
			{
				printJob.print();
			}
			catch(PrinterException pe)
			{
				System.out.println("Error printing: " + pe);
			}
		}
	}
	public int print(Graphics g, PageFormat pageFormat, int pageIndex) 
	{
		if (pageIndex > 0) 			
		{
			return(NO_SUCH_PAGE);
		} 
		else 
		{
			Graphics2D g2d = (Graphics2D)g;
			g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
			disableDoubleBuffering(componentToBePrinted);
			componentToBePrinted.paint(g2d);
			enableDoubleBuffering(componentToBePrinted);
			return(PAGE_EXISTS); 
		}
	}
	public static void disableDoubleBuffering(Component c) 
	{
		RepaintManager currentManager = RepaintManager.currentManager(c);
		currentManager.setDoubleBufferingEnabled(false);
	}
	public static void enableDoubleBuffering(Component c) 
	{
		RepaintManager currentManager = RepaintManager.currentManager(c);
		currentManager.setDoubleBufferingEnabled(true);
	}
}

public class Application //Main class
{
	public static void main(String[] args)
	{
		AppDemo ap=new AppDemo();
		ap.setVisible(true);
		ap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ap.setBounds(0,0,1250,700);
		ap.setResizable(false);
	}
}