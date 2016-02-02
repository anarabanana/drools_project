package com.sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import com.sample.AssessmentModelTest.UserInfo.Category;
import com.sample.AssessmentModelTest.UserInfo.Degree;

/**
 * This is a sample class to launch a rule.
 */
public class AssessmentModelTest implements Runnable {

	Socket ss;
	AssessmentModelTest(Socket ss) {
		this.ss = ss;
	}

	public static final void main(String[] args) throws Exception {
		try {

			ServerSocket s = new ServerSocket(5000);
			System.out.println("Server started");

			while (true) {

				Socket ss = s.accept();
				System.out.println("Server connected");

				new Thread(new AssessmentModelTest(ss)).start();

			}

		} catch (Throwable t) {
			t.printStackTrace();
		}

	}

	public static class UserInfo {

		public enum Category {
			var_1, var_2, var_3, var_4, var_5
		}

		public enum Degree {
			high, medium, low;
		}
		private Category variable_n;
		private double result;
		private Degree level_n;

		public Degree getLevel_n() {
			return level_n;
		}
		public void setLevel_n(Degree level_n) {
			this.level_n = level_n;
		}
		public Category getVariable_n() {
			return variable_n;
		}
		public void setVariable_n(Category variable_n) {
			this.variable_n = variable_n;

		}
		public double calculateResult() {
			if (level_n == Degree.high) {
				result = 100;
			} else if (level_n == Degree.medium) {
				result = 50;
			} else if (level_n == Degree.low) {
				result = 1;
			}
			return result;
		}
		public double getResult() {
			return result;
		}

		/*
		 * public void setResult(double result) { this.result = result; }
		 */

		/*
		 * KieServices kieServices = KieServices.Factory.get(); KieFileSystem
		 * kieFileSystem = kieServices.newKieFileSystem(); Resource resource =
		 * kieServices.getResources().newClassPathResource("./File.xls");
		 * kieFileSystem.write(resource); KieBuilder kbuilder =
		 * kieServices.newKieBuilder(kieFileSystem); kbuilder.buildAll();
		 * KieRepository kieRepository = kieServices.getRepository();
		 * KieContainer kContainer =
		 * kieServices.newKieContainer(kieRepository.getDefaultReleaseId());
		 * KieSession kSession = kContainer.newKieSession();
		 */

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			DataInputStream inFromClient = new DataInputStream(
					ss.getInputStream());
			DataOutputStream outToCLient = new DataOutputStream(
					ss.getOutputStream());

			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rules");

			String msg = inFromClient.readUTF();
			System.out.println(msg);

			List<String> myList = new ArrayList<String>(Arrays.asList(msg
					.split(",")));

			UserInfo item1 = new UserInfo();
			item1.setVariable_n(Category.var_1);


			if (myList.get(0).toString().equalsIgnoreCase("high")) {
				item1.setLevel_n(Degree.high);
				System.out.println("Wohohohoho");
			} else if (myList.get(0).toString().equalsIgnoreCase("medium")) {
				item1.setLevel_n(Degree.medium);
			} else if (myList.get(0).toString().equalsIgnoreCase("low")) {
				item1.setLevel_n(Degree.low);
			}
			kSession.insert(item1);

			UserInfo item2 = new UserInfo();
			item2.setVariable_n(Category.var_2);
			if (myList.get(1).toString().equalsIgnoreCase("high")) {
				item2.setLevel_n(Degree.high);
			} else if (myList.get(1).toString().equalsIgnoreCase("medium")) {
				item2.setLevel_n(Degree.medium);
			} else if (myList.get(1).toString().equalsIgnoreCase("low")) {
				item2.setLevel_n(Degree.low);
			}
			kSession.insert(item2);

			UserInfo item3 = new UserInfo();
			item3.setVariable_n(Category.var_3);
			if (myList.get(2).toString().equalsIgnoreCase("high")) {
				item3.setLevel_n(Degree.high);
			} else if (myList.get(2).toString().equalsIgnoreCase("medium")) {
				item3.setLevel_n(Degree.medium);
			} else if (myList.get(2).toString().equalsIgnoreCase("low")) {
				item3.setLevel_n(Degree.low);
			}
			kSession.insert(item3);

			UserInfo item4 = new UserInfo();
			item4.setVariable_n(Category.var_4);
			if (myList.get(3).toString().equalsIgnoreCase("high")) {
				item4.setLevel_n(Degree.high);
			} else if (myList.get(3).toString().equalsIgnoreCase("medium")) {
				item4.setLevel_n(Degree.medium);
			} else if (myList.get(3).toString().equalsIgnoreCase("low")) {
				item4.setLevel_n(Degree.low);
			}
			kSession.insert(item4);

			UserInfo item5 = new UserInfo();
			item5.setVariable_n(Category.var_5);
			if (myList.get(4).toString().equalsIgnoreCase("high")) {
				item5.setLevel_n(Degree.high);
			} else if (myList.get(4).toString().equalsIgnoreCase("medium")) {
				item5.setLevel_n(Degree.medium);
			} else if (myList.get(4).toString().equalsIgnoreCase("low")) {
				item5.setLevel_n(Degree.low);
			}
			kSession.insert(item5);

			kSession.fireAllRules();
			kSession.dispose();

			System.out.println("V1 index is " + item1.getResult() + " %");
			System.out.println("V2 index is " + item2.getResult() + " %");
			System.out.println("V3 index is " + item3.getResult() + " %");
			System.out.println("V4 index is " + item4.getResult() + " %");
			System.out.println("V5 index is " + item5.getResult() + " %");

			double total = (item1.getResult() + item2.getResult()
					+ item3.getResult() + item4.getResult() + item5.getResult()) / 5;

			String vall = "Total ER Index is " + total + " %";

			outToCLient.writeBytes(vall);
			myList.clear();
			msg = "";
			System.out.println(msg);
			outToCLient.close();
			inFromClient.close();
			ss.close();

		} catch (IOException e) {
			System.out.println(e);
		}

	}

}