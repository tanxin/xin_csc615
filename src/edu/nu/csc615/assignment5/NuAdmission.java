package edu.nu.csc615.assignment5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class NuAdmission extends JPanel{

	private boolean satBool;
	private boolean actBool;
	private boolean admitBool;
	private int iSAT=0;
	private int iACT=0;
	private String degreeString="";


	private JCheckBox satCheckBox;
	private JCheckBox actCheckBox;
	private JRadioButton gedRadioButton;
	private JRadioButton hsRadioButton;
	private JRadioButton noRadioButton;
	private JRadioButton collogeRadioButton;
	private JRadioButton bachelorRadioButton;
	private JRadioButton masterRadioButton;
	private JRadioButton doctorradioButton;
	private JRadioButton workRadioButton;
	private JRadioButton familyRadioButton;
	private JRadioButton labRadioButton;
	private JComboBox programChoose;
	private JLabel tLabel1;
	private JLabel tLabel2;
	private JLabel tLabel3;
	private TextArea printTextArea;
	private ButtonGroup eGroup;
	private ButtonGroup dGroup;
	private ButtonGroup wGroup;
	private JFrame pFrame;
	private JTextField satTextField;
	private JTextField actTextField;

	public NuAdmission() {
		super(new BorderLayout());

		collogeRadioButton = new JRadioButton("Attend College (Degree unfinished)");
		bachelorRadioButton= new JRadioButton("Bachelor's Degree");
		masterRadioButton = new JRadioButton("Master's Degree");
		doctorradioButton = new JRadioButton("Doctorate");

		dGroup = new ButtonGroup();
		dGroup.add(collogeRadioButton);
		dGroup.add(bachelorRadioButton);
		dGroup.add(masterRadioButton);
		dGroup.add(doctorradioButton);

		gedRadioButton = new JRadioButton("GED");
		gedRadioButton.setSelected(false);

		hsRadioButton = new JRadioButton("High School");

		noRadioButton = new JRadioButton("None of Above");

		eGroup = new ButtonGroup();
		eGroup.add(gedRadioButton);
		eGroup.add(hsRadioButton);
		eGroup.add(noRadioButton);

		workRadioButton = new JRadioButton("Work Experience in industry");
		familyRadioButton = new JRadioButton("Family Business");
		labRadioButton = new JRadioButton("Labortary Research");


		wGroup = new ButtonGroup();
		wGroup.add(workRadioButton);
		wGroup.add(familyRadioButton);
		wGroup.add(labRadioButton);


		satCheckBox = new JCheckBox("SAT");
		satCheckBox.setSelected(false);
		actCheckBox = new JCheckBox("ACT");
		satCheckBox.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				satBool = satCheckBox.isSelected();
			}
		});
		actCheckBox.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				actBool=actCheckBox.isSelected();
			}
		});

		JLabel scoreLabel = new JLabel("Score");
		JLabel actScoreLabel = new JLabel("Score");

		JButton processJButton = new JButton("Process");
		JButton clearJButton = new JButton("Clear");
		clearJButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				clearAll();
			}
		});
		JButton exitJButton = new JButton("Exit");
		exitJButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		processJButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				pFrame = new JFrame("Admission Feedback");

				if(programChoose.getSelectedIndex()==0){
						JOptionPane.showMessageDialog(null, "Please choose the program");
						return;
				}

				if(satBool){	
					try{
						iSAT = Integer.parseInt(satTextField.getText());
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "SAT score is invalid!!");
						return;
					}
					if(iSAT < 0){
						JOptionPane.showMessageDialog(null, "SAT score is invalid!!");
						return;
					}
				}
				
				if(actBool){
					try{
						iACT = Integer.parseInt(actTextField.getText());
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "ACT score is invalid!!");
						return;
					}
					if(iACT < 0){
						JOptionPane.showMessageDialog(null, "ACT score is invalid!!");
						return;
					}
				}
				
				admitBool = true;

				if(!bachelorRadioButton.isSelected() && !masterRadioButton.isSelected() && !doctorradioButton.isSelected()){
					if((satBool&&iSAT>=1000) || (actBool&&iACT>=15)){
						admitBool = true;
					}else{
						admitBool = false;
					}
						
				}
				printTextArea = new TextArea();

				printTextArea.setSize(450, 400);
				printTextArea.setPreferredSize(new Dimension(450,380));
				printTextArea.setRows(50);

				printTextArea.setText(getPrintString());

				JPanel feedbackPanel = new JPanel();

				JButton Okay = new JButton("Ok");
				Okay.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						pFrame.setVisible(false);
					}
				});

				JButton Print = new JButton("Click to print");
				Print.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						Printer.printComponent(printTextArea);
					}
				});

				feedbackPanel.add(printTextArea);      
				feedbackPanel.add(Okay);
				feedbackPanel.add(Print);
				pFrame.add(feedbackPanel);
				pFrame.setPreferredSize(new Dimension(460, 450));
				pFrame.pack();
				pFrame.setVisible(true);
				
			}
		});

		JPanel testPanel = new JPanel(new GridLayout(4,1));
		testPanel.setPreferredSize(new Dimension(150,50));
		testPanel.setMaximumSize(new Dimension(150,50));
		testPanel.setBorder(BorderFactory.createTitledBorder("Test"));

		JPanel satPanel = new JPanel(new GridLayout(1,2,0,0));
		JPanel actPanel = new JPanel(new GridLayout(1,2,0,0));

		satTextField = new JTextField();
		actTextField = new JTextField();
		
		satPanel.add(scoreLabel);
		satPanel.add(satTextField);

		actPanel.add(actScoreLabel);
		actPanel.add(actTextField);

		testPanel.add(satCheckBox);
		testPanel.add(satPanel);
		testPanel.add(actCheckBox);
		testPanel.add(actPanel);

		JPanel actionPanel = new JPanel(new GridLayout(0,1,10,25));
		actionPanel.setBorder(BorderFactory .createEmptyBorder(15, 15, 15, 15));

		actionPanel.add(processJButton);
		actionPanel.add(clearJButton);
		actionPanel.add(exitJButton);
		JPanel eastPanel = new JPanel(new GridLayout(0,1));
		eastPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		eastPanel.add(testPanel);
		eastPanel.add(actionPanel);


		String programs[] =  {"Please select a program:",
				"Computer Science",
				"Teaching", 
				"Business Administration",
				"Arts & Sciences"};
		programChoose= new JComboBox(programs);
		programChoose.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				degreeString = "";  
				JComboBox cb = (JComboBox)e.getSource();
				String newSelection = (String)cb.getSelectedItem();
				degreeString = newSelection;
			}
		});


		JLabel chooseLabel = new JLabel("Choose a Program:   ");
		JLabel welcomeLabel1 = new JLabel("Welcome to the National University program admission requirements");
		JLabel welcomeLabel2 = new JLabel("calendar. Please select the program which interests you.");


		JPanel welcomePanel = new JPanel(new GridLayout(2, 1));
		welcomePanel.add(welcomeLabel1);
		welcomePanel.add(welcomeLabel2);

		JPanel thankyouPanel = new JPanel(new GridLayout(3, 1));
		tLabel1 = new JLabel("Thank you. Now please indicate your qualifications by selecting the");
		tLabel2 = new JLabel("appropriate boxes and are commendation based on your particular");
		tLabel3 = new JLabel("experience will be made.");
		thankyouPanel.add(tLabel1);
		thankyouPanel.add(tLabel2);
		thankyouPanel.add(tLabel3);

		JPanel choosePanel = new JPanel();
		choosePanel.setLayout(new BoxLayout(choosePanel, BoxLayout.X_AXIS));
		choosePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		choosePanel.add(chooseLabel);
		choosePanel.add(programChoose);

		JPanel nuPanel = new JPanel();
		nuPanel.setLayout(new BoxLayout(nuPanel, BoxLayout.Y_AXIS));
		nuPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
		nuPanel.add(welcomePanel);
		nuPanel.add(choosePanel);
		nuPanel.add(thankyouPanel);

		JPanel educationPanel = new JPanel(new GridLayout(3, 1));
		educationPanel.add(gedRadioButton);
		educationPanel.add(hsRadioButton);
		educationPanel.add(noRadioButton);
		educationPanel.setBorder(BorderFactory.createTitledBorder("Education (Highest Completed)")); 


		JPanel collegePanel = new JPanel(new GridLayout(0, 1));
		collegePanel.add(collogeRadioButton);
		collegePanel.add(bachelorRadioButton);
		collegePanel.add(masterRadioButton);
		collegePanel.add(doctorradioButton);
		collegePanel.setBorder(BorderFactory.createTitledBorder("College Education (Highest Completed)"));

		JPanel workPanel = new JPanel(new GridLayout(0, 1));
		workPanel.add(workRadioButton);
		workPanel.add(familyRadioButton);
		workPanel.add(labRadioButton);
		workPanel.setBorder(BorderFactory.createTitledBorder("Additional Experience"));

		JPanel groupButtonPanel = new JPanel(new GridLayout(0, 1));

		groupButtonPanel.add(educationPanel, BorderLayout.NORTH);
		groupButtonPanel.add(collegePanel, BorderLayout.CENTER);
		groupButtonPanel.add(workPanel, BorderLayout.SOUTH);
		clearAll();
		add(nuPanel, BorderLayout.NORTH);
		add(groupButtonPanel, BorderLayout.WEST);
		add(eastPanel, BorderLayout.EAST);

		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	}

	private String getPrintString() {
		String string = String.format("NATIONAL UNIVERSITY ADMISSION RECOMMENDATION\n" +
				"You entered the following:\n" +
				"_______________________________________________________________\n" +
				"Date:%s\n" +
				"Choosen Program:%s\n" +
				"Education:%s\n" +
				"College Education:%s\n" +
				"Additional Experience:%s\n" +
				"Your SAT score:%s\n" +
				"Your ACT score:%s\n\n" +
				"Based on your acadamic background, you %s the\n" +
				"requirements for admission to the National University\n\n" +
				"Please talk to an admissions advisor for more information.\n", 
				Calendar.getInstance().getTime(), degreeString, getEdu(), getDegree(), getWork(), iSAT, iACT,
				admitBool?"met":"do NOT meet");
		return string;
	}
	
	public String getEdu(){
		if(gedRadioButton.isSelected())
			return "GED";
		if(hsRadioButton.isSelected())
			return "High School Graduate";
		if(noRadioButton.isSelected())
			return "None";
		return "";
	}
	
	public String getDegree(){
		if(collogeRadioButton.isSelected())
			return "Some College, o degree obtaied";
		if(bachelorRadioButton.isSelected())
			return "Bachelor's Degree";
		if(masterRadioButton.isSelected())
			return "Master's Degree";
		if(doctorradioButton.isSelected())
			return "Doctorate";
		return "";
	}
	
	public String getWork(){
		if(workRadioButton.isSelected())
			return "Work Experiece in industry";
		if(familyRadioButton.isSelected())
			return "Family Business";
		if(labRadioButton.isSelected())
			return "Laboratory Research";
		return "";
	}

	public void clearAll() 
	{
		satBool=false;
		actBool=false;
		satTextField.setText("");
		actTextField.setText("");
		satCheckBox.setSelected(false);
		actCheckBox.setSelected(false);
		eGroup.clearSelection();
		dGroup.clearSelection();
		wGroup.clearSelection();
		programChoose.setSelectedIndex(0);
	}
	
	public static void main(String[] args) {
		try {
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					JFrame frame = new JFrame("NU Admission Form");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

					JComponent newContentPane = new NuAdmission();
					newContentPane.setOpaque(true);
					frame.setContentPane(newContentPane);

					frame.pack();
					frame.setSize(new Dimension(500,600));
					frame.setVisible(true);
					
				}
			});			
		} catch (Exception e) {}
	}
}