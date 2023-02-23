package student.Management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class ScoreManager {

	Scanner sc = new Scanner(System.in);
	String choice;	// �޴����� ����
	boolean run = true;	// �޴� while �ݺ��� ����
	Data data = new Data();	// ������Ŭ���� ��ü����
	List<Lecture> lectureList = data.getLectureList(); // ������ �̸� �����÷��� �����´�.
	TreeMap<Student, Score> scoreMap = data.getScoreMap(); // ����ǥ �����´�.
	TreeMap<Student, Score> blackList = new TreeMap<Student, Score>(new StudentComporator()); // ����ʿ��л� ��Ƴ�����
	Set<Student> set = scoreMap.keySet(); // �޼ҵ帶�� ������ ������ scoreMap�� Ű���� �ش��ϴ� Set<Student>�ڷ�

	public ScoreManager() {
		while (run) {
			System.out.println("---------------------------------------");
			System.out.printf("%-8s%-8s%-8s%-8s\n", "1. �����˻�", "2. ��ü����", "3. �ݺ�����", "4. ����ȭ��");
			System.out.println("---------------------------------------");
			System.out.println("�޴�����>");
			String choice = sc.nextLine();
			switch (choice) {
			case "1": {
				search();
				break;
			}
			case "2": {
				printAll();
				break;
			}
			case "3": {
				print();
				break;
			}
			case "4": {
				System.out.println("���� ȭ������ ���ư��ϴ�.");
				run = false;
				break;
			}
			default: {
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				continue;
			}
			}
		}
	}

	private void printAll() {
		String teacher = null; // �ݺ��� �ȿ��� �������̸� ����ش�.
		System.out.printf("%-5s%-6s%-7s%-8s%-5s\n", "�ݸ�", "������", "�л��̸�", "��缱����", "����");
		if (set.isEmpty()) {
			System.out.println("���������Ͱ� �����ϴ�.");
			return;
		}
		for (Student st : set) {	//����ǥ �ݺ���
			for (int i = 0; i < lectureList.size(); i++) {
				if (st.getSubjectName().equals(lectureList.get(i).getLecture())) {
					//����ǥ�� �ִ� ������ ������������Ʈ���ִ� ������� ���� ��� �������̸��� ���� teacher�� �־��ش� 
					teacher = lectureList.get(i).getTeacherName();
				}
				if (scoreMap.get(st).getScore() < 70) {	// 70������ ���� �л� �ʿ� ǲ
					blackList.put(st, scoreMap.get(st));

				}
			}
			System.out.printf("%-6s%-6s%-9s%-7s%-2d\n", st.getClassName(), st.getSubjectName(), st.getStudentName(),
					teacher, scoreMap.get(st).getScore());
		}

		if (!blackList.isEmpty()) {
			System.out.println("-------------------------------------------");
			System.out.println("����ʿ� �л� : (70���̸�)");
			Set<Student> blackSet = blackList.keySet();
			for (Student st : blackSet) {
				System.out.printf("%-7s%-15s\n", st.getStudentName(), st.getPhoneNum());
			}
			System.out.println("-------------------------------------------");
		}
	}

	private void search() {
		if (set.isEmpty()) {
			System.out.println("���������Ͱ� �����ϴ�.");
			return;
		}
		while (!set.isEmpty()) {
			int count = 0;
			System.out.print("�л� �̸� �Է�>");
			String searchName = sc.nextLine();
			System.out.println("\n" + searchName + " �л��� ����");
			for (Student st : set) {
				if (st.getStudentName().equals(searchName)) {
					count++;
					System.out.println(st.getSubjectName() + ": " + scoreMap.get(st).getScore() + " ��");
				}
			}
			if (count == 0) {
				System.out.println("���������� �����ϴ�.");
			}
			System.out.println("��� �˻��Ͻ÷��� \"y(Y)\"�� �Է��ϼ���.");
			String choice = sc.nextLine();
			if (choice.equalsIgnoreCase("y")) {
				continue;
			} else
				break;
		}

	}

	private void print() {
		int sum1 = 0; // 1���� ����
		int sum2 = 0; // 2���� ����
		double average1 = 0; // 1���� ���
		double average2 = 0; // 2���� ���
		double disSum1 = 0; // 1���� �л���
		double disSum2 = 0; // 2���� �л���
		double sd1 = 0; // 1���� ǥ������
		double sd2 = 0; // 1���� ǥ������
		// 1���� ��
		TreeMap<Student, Score> tempMap1 = new TreeMap<Student, Score>(new StudentComporator());
		// 2���� ��
		TreeMap<Student, Score> tempMap2 = new TreeMap<Student, Score>(new StudentComporator());
		System.out.println("�ݺ�����");
		System.out.printf("%-5s%-6s%-7s%-8s\n", "�ݸ�", "�����ο�", "�������", "ǥ������");
		for (Student st : set) { // 1��, 2�� �и��ϰڴ�
			if (st.className.equals("1��")) {
				tempMap1.put(st, scoreMap.get(st));
				sum1 += scoreMap.get(st).getScore();

			} else if (st.className.equals("2��")) {
				tempMap2.put(st, scoreMap.get(st));
				sum2 += scoreMap.get(st).getScore();
			}
		}
		Set<Student> tempSet1 = tempMap1.keySet(); // 1�� ��(�ݺ��� ���ε�������..)
		Set<Student> tempSet2 = tempMap2.keySet(); // 2�� ��
		if (!tempMap1.isEmpty()) {	// �������� 1�ݵ����Ͱ� ������(size = 0) ������ ���ϰ� �ʱⰪ 0���� ����̵ȴ�.
			average1 = (double) sum1 / tempMap1.size();
			for (Student st : tempSet1) {
				disSum1 += Math.pow(tempMap1.get(st).getScore() - average1, 2); // 1�� �л� ��
			}
			sd1 = Math.sqrt((double) (disSum1 / tempSet1.size())); // �л��� ����� ������(ǥ������)
		}
		if (!tempMap2.isEmpty()) {// �������� 2�ݵ����Ͱ� ������(size = 0) ������ ���ϰ� �ʱⰪ 0���� ����̵ȴ�.
			average2 = (double) sum2 / tempMap2.size();
			for (Student st : tempSet2) {
				disSum2 += Math.pow(tempMap2.get(st).getScore() - average2, 2); // 2�� �л��� ��
			}
			sd2 = Math.sqrt((double) (disSum2 / tempSet2.size()));	// 2�� ǥ������
		}
		// �������Ŀ��� �Ҽ��� �ι�°�ڸ����� ����϶�� �߰��ؼ� ���� MathŬ���� ���� ������ �����Ͽ����ϴ�.
		// (%-7s)ù��° ���� ���ڿ��� ���ʱ��� 7ĭ
		// �ְ�,(%d��)�ι�°��������"��",(\s=����),(%.2f��)�Ҽ����ι�°�ڸ��Ǽ�
//		System.out.printf("%-7s%d��\s\s\s%.2f��\s\s\s%.2f\n", "1��", tempMap1.size(), average1, sd1);
		System.out.println("1��     " + tempMap1.size() + "��    " + Math.round(average1*100.0)/100.0 + "��  " + Math.round(sd1*100.0)/100.0);
//		System.out.printf("%-7s%d��\s\s\s%.2f��\s\s\s%.2f\n", "2��", tempMap2.size(), average2, sd2);
		System.out.println("2��     " + tempMap2.size() + "��    " + Math.round(average2*100.0)/100.0 + "��  " + Math.round(sd2*100.0)/100.0);
	}

}
