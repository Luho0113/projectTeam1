package student.Management;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class ScoreManager {

	Scanner sc = new Scanner(System.in);
	String choice;
	boolean run = true;
	Data data = new Data();
	List<Lecture> lectureList = data.getLectureList();	// ������ �̸� �����÷��� �����´�.
	TreeMap<Student, Score> scoreMap = data.getScoreMap();	// ����ǥ �����´�.
	TreeMap<Student, Score> blackList = new TreeMap<Student, Score>(new StudentComporator());	// ����ʿ��л� ��Ƴ�����
	Set<Student> set = scoreMap.keySet();	// �޼ҵ帶�� ������ ������

	public ScoreManager() {
		test();
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

	private void test() {

	}

	private void printAll() {
		String teacher = null;	// �ݺ��� �ȿ��� �������̸� ����ش�.
		System.out.printf("%-5s%-6s%-7s%-8s%-5s\n", "�ݸ�", "������", "�л��̸�", "��缱����", "����");
		if (set.isEmpty()) {
			System.out.println("���������Ͱ� �����ϴ�.");
			return;
		}
		for (Student st : set) {
			for (int i = 0; i < lectureList.size(); i++) {
				if (st.getSubjectName().equals(lectureList.get(i).getLecture())) {
					teacher = lectureList.get(i).getTeacherName();
				}
				if (scoreMap.get(st).getScore() < 70) {
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
		} else {	// �̰Ŵ� ���߿� ���ֵ��ɰŰ���.
			System.out.println("������ ��ü�� �����ϴ�.");
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
					System.out.println(st.getSubjectName() + ": " + scoreMap.get(st).getScore() + " ��");
				}
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
		int sum1 = 0;
		double average1 = 0;
		int sum2 = 0;
		double average2 = 0;
		double result1 = 0;
		double result2 = 0;
		String className = null;	// �ݸ��� ������ �����غ���� �ߴµ�,,�ϴ� ����
		TreeMap<Student, Score> tempMap1 = new TreeMap<Student, Score>(new StudentComporator());
		TreeMap<Student, Score> tempMap2 = new TreeMap<Student, Score>(new StudentComporator());
		System.out.println("�ݺ�����");
		System.out.printf("%-5s%-6s%-7s%-8s\n", "�ݸ�", "�����ο�", "�������", "ǥ������");
		for (Student st : set) {	// 1��, 2�� �и��ϰڴ� -> �ƴϸ� �迭�� �̾Ƽ� MathŬ������ �Ẽ�� �ͱ⵵ �ϴ�..
			if (st.className.equals("1��")) {
				tempMap1.put(st, scoreMap.get(st));
				sum1 += scoreMap.get(st).getScore();

			} else if (st.className.equals("2��")) {
				tempMap2.put(st, scoreMap.get(st));
				sum2 += scoreMap.get(st).getScore();
			}
		}
		Set<Student> tempSet1 = tempMap1.keySet();	// 1�� ��(�ݺ��� ���ε�������..)
		Set<Student> tempSet2 = tempMap2.keySet();	// 2�� ��
		average1 = (double) (sum1 / tempMap1.size());
		average2 = (double) (sum2 / tempMap2.size());

		double disSum1 = 0; // �л��� ��
		double disSum2 = 0;
		for (Student st : tempSet1) {
			disSum1 += Math.pow(tempMap1.get(st).getScore() - average1, 2);	// 1�� �л� ��
		}
		for (Student st : tempSet2) {
			disSum2 += Math.pow(tempMap2.get(st).getScore() - average2, 2);	// 2�� �л��� ��
		}
		result1 = Math.sqrt((double) (disSum1 / tempSet1.size()));	// �л��� ����� ������(ǥ������)
		result2 = Math.sqrt((double) (disSum2 / tempSet2.size()));	// �ٵ� �Ҽ����� �ʹ� ��

		double sd1 = Math.round(result1 * 100) / 100.0;	//ǥ������ �Ҽ��� ��°�ڸ������� ���(��������)
		double sd2 = Math.round(result2 * 100) / 100.0;

		System.out.printf("%-7s%-6s%-9s%-6s\n", "1��", tempMap1.size() + "��", average1, sd1);
		System.out.printf("%-7s%-6s%-9s%-6s\n", "2��", tempMap2.size() + "��", average2, sd2);
		// �ݸ� �Է������ؼ� ������ָ� �� ����� �Ǿ�� �Ѵ�..
	}

}
