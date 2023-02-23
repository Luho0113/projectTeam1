package student.Management;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Attendance {

	Scanner sc = new Scanner(System.in);
	String choice; // �޴����� ����
	boolean run = true; // �޴� while ����
	Data data = new Data(); // ������Ŭ���� ��ü����
	List<Lecture> lectureList = data.getLectureList(); // �����Ը��, �̸� �����÷��� �����´�.
	TreeMap<Student, AttendanceData> attendanceMap = data.getAttendanceMap(); // ���ǥ �����´�.
	TreeMap<Student, AttendanceData> blackList = new TreeMap<Student, AttendanceData>(new StudentComporator()); // �Ἦ����Ʈ

	Set<Student> set = attendanceMap.keySet(); // �޼ҵ帶�� ������ ������,�ݺ�����

	public Attendance() {
		while (run) {
			System.out.println("---------------------------------------");
			System.out.printf("%-8s%-8s%-8s%-8s\n", "1. ���˻�", "2. �⼮��Ȳ", "3. �ݺ��⼮", "4. ����ȭ��");
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
		String status = null; // �⼮���¸� ǥ���� ���ڿ� ����
		System.out.printf("%-5s%-6s%-7s%-8s%-5s\n", "�ݸ�", "������", "�л��̸�", "��缱����", "�⼮����");
		if (set.isEmpty()) {
			System.out.println("��ᵥ���Ͱ� �����ϴ�.");
			return;
		}
		for (Student st : set) {
			for (int i = 0; i < lectureList.size(); i++) {
				if (st.getSubjectName().equals(lectureList.get(i).getLecture())) {
					teacher = lectureList.get(i).getTeacherName(); // �������̸� �̾ƿ�
				}
				if (attendanceMap.get(st).getStatus() == 0) {
					status = "�Ἦ"; // �⼮���� 0 �̸� ���ڿ������� ���������� "�⼮����"�� �־���.
					blackList.put(st, attendanceMap.get(st)); // �̶� �����⼮���ѻ�� ������ ����Ʈ �����.

				} else {
					status = "�⼮";
				}
			}
			System.out.printf("%-6s%-6s%-9s%-7s%-5s\n", st.getClassName(), st.getSubjectName(), st.getStudentName(),
					teacher, status);
		}

		if (!blackList.isEmpty()) {
			System.out.println("-------------------------------------------");
			System.out.println("����ʿ� �л� : (���Ϲ��⼮)"); // �⼮�����ڷ� ������ ������� �׳� ���� �⼮�߳ľ��߳ķθ�..
			Set<Student> blackSet = blackList.keySet();
			for (Student st : blackSet) {
				System.out.printf("%-7s%-15s\n", st.getStudentName(), st.getPhoneNum());
			}
			System.out.println("-------------------------------------------");
		}
	}

	private void search() {
		if (set.isEmpty()) {
			System.out.println("��ᵥ���Ͱ� �����ϴ�.");
			return;
		}
		while (!set.isEmpty()) {
			int count = 0;
			String status = null;
			System.out.print("�л� �̸� �Է�>");
			String searchName = sc.nextLine();
			for (Student st : set) {
				if (st.getStudentName().equals(searchName)) {
					count++;
					if (attendanceMap.get(st).getStatus() == 0) {
						status = "�Ἦ";
					} else {
						status = "�⼮";
					}

					System.out.println(searchName + " �л�, ���� " + status + " �Ͽ����ϴ�.");
				}
			}
			if (count == 0) {
				System.out.println("�⼮������ �����ϴ�.");
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
		int sum1 = 0; // 1���� �⼮�ο���
		double rate1 = 0;// 1���� �⼮��
		int sum2 = 0; // 2���� �⼮�ο���
		double rate2 = 0; // 2���� �⼮��
		// 1�ݸ� �з�
		TreeMap<Student, AttendanceData> tempMap1 = new TreeMap<Student, AttendanceData>(new StudentComporator());
		// 2�ݸ� �з�
		TreeMap<Student, AttendanceData> tempMap2 = new TreeMap<Student, AttendanceData>(new StudentComporator());
		System.out.println("�ݺ� �⼮ ��Ȳ");
		System.out.printf("%-5s%-6s%-7s\n", "�ݸ�", "�����ο�", "�⼮��");
		for (Student st : set) { // 1��, 2�� �и��ϰڴ�
			if (st.getClassName().equals("1��")) {
				tempMap1.put(st, attendanceMap.get(st)); // 1�ݵ����� ������
				sum1 += attendanceMap.get(st).getStatus(); // �� ���� �⼮�� �ο����� �������� ��Ÿ����.

			} else if (st.getClassName().equals("2��")) {
				tempMap2.put(st, attendanceMap.get(st)); // 2�ݵ����� ������
				sum2 += attendanceMap.get(st).getStatus();
			}
		}
		if (!tempMap1.isEmpty()) { // 1���� �ο��� ������ �ο� 0��, �⼮�� 0% -> �� if���ǹ��� �־�� 0���� �ٷ� �ȳ�����. ��������
			// �⼮���� = �⼮�ϸ� 1 �ƴϸ� 0 �̹Ƿ�
			// 1�� ��ü �ο� = tempMap1.size(), �� �հ� = �⼮���ο���
			// ���� �⼮�� = (�⼮���ο����� ��)/(����ü�ο�) *100
			rate1 = ((double) sum1 / (double) tempMap1.size()) * 100;
		}
		if (!tempMap2.isEmpty()) { // 2���� �ο��� ������ �ο� 0��, �⼮�� 0%
			rate2 = ((double) sum2 / (double) tempMap2.size()) * 100; // �̰� �ٷ� �⼮��

		}
		// (%-7s)ù��° ���� ���ڿ��� ���ʱ��� 7ĭ
		// �ְ�,(%d��)�ι�°��������"��",(\s=����),(%.2f%%\n)�Ҽ������ڸ��Ǽ�����"%"�ϰ��ٹٲ�(%�����%%�Է��ؾ���)
		System.out.printf("%-7s%d��\s\s\s%.2f%%\n", "1��", tempMap1.size(), rate1);
		System.out.printf("%-7s%d��\s\s\s%.2f%%\n", "2��", tempMap2.size(), rate2);

	}

}
