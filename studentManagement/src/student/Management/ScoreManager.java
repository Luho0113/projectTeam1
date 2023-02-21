package student.Management;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ScoreManager {
	// ���� �˻�, ��ü ����, �ݺ� ����
	// �˻� -> �̸�
	// �̸� -> ���� > ����
	// Map -> <Student,value = ����
	Scanner sc = new Scanner(System.in);
	String choice;
	boolean run = true;
	Data data = new Data();

	List<Student> studentList = data.getStudentList();
	List<Lecture> lectureList = data.getLectureList();
	List<Score> scoreList = data.getScoreList();
	Map<List<Student>, Score> scoreMap; 
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
		// ����ǥ�� �����θ� �ϴ�, �ε����� ������ ã�� �ý����� �����غ��� �̻��ϴ�..
		// ��������Ʈ�� �л�����Ʈ�� ��� ������ұ�
		// �����Ժ��� �����Ǵ� �ý���(����), �ݺ��� �����Ǵ� �ý���
		// ������ -> ���� -> �л��̸� -> ����
		if(data.getScoreList().isEmpty()) {
			System.out.print("���� �����Ͱ� �����ϴ�. �Է��Ͻðڽ��ϱ�?");
			System.out.print("������ ������ �ʿ��մϴ�. ��й�ȣ�� �Է����ּ���>");
		}
		for(int i = 0; i<studentList.size();i++) {
			// ����, �̸�, �� -> ���� ����Ʈ ����(Map)
		}
	}

	private void printAll() {
		System.out.println("---------------------------------------");
		System.out.printf("%-8s%-8s%-8s%-8s\n", "������", "�л��̸�", "��缱����", "����");
		System.out.println("---------------------------------------");
		String teacherName = null;
		for (int i = 0; i < studentList.size(); i++) {
			for (int j = 0; j < lectureList.size(); j++) {
				if (studentList.get(i).getSubjectName().equals(lectureList.get(j).getLecture())) {
					teacherName = lectureList.get(j).getTeacherName();
				}
			}
			if (i < scoreList.size()) {
				System.out.printf("%-8s%-8s%-8s%-8d\n", studentList.get(i).getSubjectName(),
						studentList.get(i).getStudentName(), teacherName, scoreList.get(i).getScore());
			} else
				System.out.printf("%-8s%-8s%-8s%-8s\n", studentList.get(i).getSubjectName(),
						studentList.get(i).getStudentName(), teacherName, "�����̾����ϴ�.");
		}
	}

	private void search() {
		while (true) {
			int count = 0;
			System.out.print("�л� �̸� �Է�>");
			String searchName = sc.nextLine();
			System.out.println("\n" + searchName + " �л��� ����");
			for (int i = 0; i < studentList.size(); i++) {
				if (searchName.equals(studentList.get(i).getStudentName())) {
					System.out.println(studentList.get(i).subjectName + ": " + scoreList.get(i).getScore() + " ��");
					count++;
				}
			}
			if (count == 0) {
				System.out.println("���������Ͱ� �����ϴ�.");
			}
			System.out.println("��� �˻��Ͻ÷��� \"y(Y)\"�� �Է��ϼ���.");
			String choice = sc.nextLine();
			if (choice.equals("y".toUpperCase())) {
				continue;
			} else
				break;
		}
	}

	private void print() {
		System.out.println("�ݺ�����");
		List<Student> classList;
	}

}
