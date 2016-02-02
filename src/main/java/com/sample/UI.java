package com.sample;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.sample.AssessmentModelTest.UserInfo;
import com.sample.AssessmentModelTest.UserInfo.Degree;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JButton;

public class UI extends JFrame implements ActionListener {
	JButton btnProcess;
	JRadioButton v1_high;
	JRadioButton v1_medium;
	JRadioButton v2_high;
	JRadioButton v2_medium;
	JRadioButton v3_high;
	JRadioButton v3_medium;
	JRadioButton v4_high;
	JRadioButton v4_medium;
	JRadioButton v5_high;
	JRadioButton v5_medium;
	JRadioButton v1_low;
	JRadioButton v2_low;
	JRadioButton v3_low;
	JRadioButton v4_low;
	JRadioButton v5_low;
	JLabel lblResult;
	StringBuffer sb = new StringBuffer("");
	private JLabel lblV;
	/**
	 * Create the panel.
	 */
	public UI() {

		this.setTitle("Assessment Model Test");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));

		ButtonGroup group = new ButtonGroup();
		ButtonGroup group2 = new ButtonGroup();
		ButtonGroup group3 = new ButtonGroup();
		ButtonGroup group4 = new ButtonGroup();
		ButtonGroup group5 = new ButtonGroup();
				
				lblV = new JLabel("V1");
				getContentPane().add(lblV, "2, 6, center, center");
		
				v1_high = new JRadioButton("high");
				getContentPane().add(v1_high, "4, 6");
				group.add(v1_high);
				
						v1_medium = new JRadioButton("medium");
						getContentPane().add(v1_medium, "8, 6");
						group.add(v1_medium);
						
								v1_low = new JRadioButton("low");
								getContentPane().add(v1_low, "10, 6");
								group.add(v1_low);
				
						JLabel v2 = new JLabel("V2");
						getContentPane().add(v2, "2, 8, center, center");
		
				v2_high = new JRadioButton("high");
				getContentPane().add(v2_high, "4, 8");
				group2.add(v2_high);
				
						v2_medium = new JRadioButton("medium");
						getContentPane().add(v2_medium, "8, 8");
						group2.add(v2_medium);
						
								v2_low = new JRadioButton("low");
								getContentPane().add(v2_low, "10, 8");
								group2.add(v2_low);
				
						JLabel V3 = new JLabel("V3");
						getContentPane().add(V3, "2, 10, center, center");
		
				v3_high = new JRadioButton("high");
				getContentPane().add(v3_high, "4, 10");
				group3.add(v3_high);
				
						v3_medium = new JRadioButton("medium");
						getContentPane().add(v3_medium, "8, 10");
						group3.add(v3_medium);
						
								v3_low = new JRadioButton("low");
								getContentPane().add(v3_low, "10, 10");
								group3.add(v3_low);
				
						JLabel V4 = new JLabel("V4");
						getContentPane().add(V4, "2, 12, center, default");
		
				v4_high = new JRadioButton("high");
				getContentPane().add(v4_high, "4, 12");
				group4.add(v4_high);
		
				v4_medium = new JRadioButton("medium");
				getContentPane().add(v4_medium, "8, 12");
				group4.add(v4_medium);
				
						v4_low = new JRadioButton("low");
						getContentPane().add(v4_low, "10, 12");
						group4.add(v4_low);
		
				JLabel V5 = new JLabel("V5");
				getContentPane().add(V5, "2, 14, center, center");
		
				v5_high = new JRadioButton("high");
				getContentPane().add(v5_high, "4, 14");
				group5.add(v5_high);
		
				v5_medium = new JRadioButton("medium");
				getContentPane().add(v5_medium, "8, 14");
				group5.add(v5_medium);
		
				v5_low = new JRadioButton("low");
				getContentPane().add(v5_low, "10, 14");
				group5.add(v5_low);
		
				btnProcess = new JButton("Process");
				btnProcess.addActionListener(this);
				getContentPane().add(btnProcess, "2, 16");
				
						lblResult = new JLabel("result");
						getContentPane().add(lblResult, "2, 18, 3, 1, center, default");
		// this.setVisible(true);


	}
	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new UI().setVisible(true);
				System.out.println(javax.swing.SwingUtilities.isEventDispatchThread());
			}
		});
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnProcess)) {
			Thread t = new Thread(new Runnable() {
				public void run() {
					try {
						processInformation();
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			t.start();
		}
	}

	public void processInformation() throws UnknownHostException, IOException {
		Socket s = new Socket("localhost", 5000);

		DataInputStream inFromServer = new DataInputStream(s.getInputStream());
		DataOutputStream outToServer = new DataOutputStream(s.getOutputStream());
		// ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
		check();
		check2();
		check3();
		check4();
		check5();

		System.out.println(sb);
		outToServer.writeUTF(sb.toString());

		String result = inFromServer.readLine();
		System.out.println(result.toString());
		lblResult.setText( result.toString());

		sb.setLength(0);
		outToServer.close();
		inFromServer.close();
		s.close();
		

	}
	public void check() {
		if (v1_high.isSelected()) {

			sb.append("high");

		} else if (v1_medium.isSelected()) {

			sb.append("medium");

		} else if (v1_low.isSelected()) {

			sb.append("low");
		}
		sb.append(",");
	}
	public void check2() {
		if (v2_high.isSelected()) {

			sb.append("high");

		} else if (v2_medium.isSelected()) {

			sb.append("medium");

		} else if (v2_low.isSelected()) {

			sb.append("low");

		}
		sb.append(",");
	}
	public void check3() {
		if (v3_high.isSelected()) {

			sb.append("high");

		} else if (v3_medium.isSelected()) {

			sb.append("medium");

		} else if (v3_low.isSelected()) {

			sb.append("low");

		}
		sb.append(",");
	}
	public void check4() {
		if (v4_high.isSelected()) {

			sb.append("high");

		} else if (v4_medium.isSelected()) {

			sb.append("medium");

		} else if (v4_low.isSelected()) {

			sb.append("low");

		}
		sb.append(",");
	}
	public void check5() {
		if (v5_high.isSelected()) {

			sb.append("high");

		} else if (v5_medium.isSelected()) {

			sb.append("medium");

		} else if (v5_low.isSelected()) {

			sb.append("low");

		}
		sb.append(",");
	}

}
