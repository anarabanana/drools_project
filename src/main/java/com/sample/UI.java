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
	/**
	 * Create the panel.
	 */
	public UI() {

		this.setTitle("Simple Sample");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FormLayout(new ColumnSpec[]{
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,},
				new RowSpec[]{FormFactory.RELATED_GAP_ROWSPEC,
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

		v1_high = new JRadioButton("high");
		add(v1_high, "10, 10");

		v1_medium = new JRadioButton("medium");
		add(v1_medium, "12, 10");

		v1_low = new JRadioButton("low");
		add(v1_low, "14, 10");

		JLabel v2 = new JLabel("V2");
		add(v2, "6, 12");

		v2_high = new JRadioButton("high");
		add(v2_high, "10, 12");

		v2_medium = new JRadioButton("medium");
		add(v2_medium, "12, 12");

		v2_low = new JRadioButton("low");
		add(v2_low, "14, 12");

		JLabel V3 = new JLabel("V3");
		add(V3, "6, 14");

		v3_high = new JRadioButton("high");
		add(v3_high, "10, 14");

		v3_medium = new JRadioButton("medium");
		add(v3_medium, "12, 14");

		v3_low = new JRadioButton("low");
		add(v3_low, "14, 14");

		JLabel V4 = new JLabel("V4");
		add(V4, "6, 16");

		v4_high = new JRadioButton("high");
		add(v4_high, "10, 16");

		v4_medium = new JRadioButton("medium");
		add(v4_medium, "12, 16");

		v4_low = new JRadioButton("low");
		add(v4_low, "14, 16");

		JLabel V5 = new JLabel("V5");
		add(V5, "6, 18");

		v5_high = new JRadioButton("high");
		add(v5_high, "10, 18");

		v5_medium = new JRadioButton("medium");
		add(v5_medium, "12, 18");

		v5_low = new JRadioButton("low");
		add(v5_low, "14, 18");

		btnProcess = new JButton("Process");
		btnProcess.addActionListener(this);
		add(btnProcess, "6, 20");

		JLabel lblResult = new JLabel("result");
		add(lblResult, "10, 20");
		// this.setVisible(true);

		ButtonGroup group = new ButtonGroup();
		group.add(v1_low);
		group.add(v1_high);
		group.add(v1_medium);
		ButtonGroup group2 = new ButtonGroup();
		group2.add(v2_low);
		group2.add(v2_high);
		group2.add(v2_medium);

	}
	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new UI().setVisible(true);
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

		UserInfo item1 = new UserInfo();

		check();
		check2();
		check3();
		check4();
		check5();

		System.out.println(sb);
		outToServer.writeUTF(sb.toString());

		String result = inFromServer.readUTF();
		System.out.println(result.toString());
		lblResult.setText(result.toString());
		lblResult.paintImmediately(lblResult.getVisibleRect());
		

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
