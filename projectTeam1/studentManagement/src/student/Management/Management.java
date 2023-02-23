package student.Management;
import java.util.List;
import java.util.Scanner;

public class Management {
	Scanner sc;

	Management() {
		sc = new Scanner(System.in);
	}
	
	//��ü ���� - �߰��� �κ�
	Data data = new Data();
	List<Lecture> lectureList = data.getLectureList();
	
	// ���� �˻�
	void serch() {

		String find; // ���� �̸� �޴� ��

		System.out.print("�˻��� ���� ������ �Է��ϼ��� : ");
		find = sc.next();

		for (int i = 0; i < lectureList.size(); i++) { // list ũ�⸸ŭ for�� ����
			// ���� �˻�
			if (find.equals(lectureList.get(i).getLecture())) {
				System.out.println("���� : " + lectureList.get(i).getLecture());
				System.out.println("������ : " + lectureList.get(i).getTeacherName());
			} else {
				System.out.println("������ �ٽ� Ȯ�����ּ���.");
			}break;
		}
	}
	
	// ��ü ���� ���
	void serchAll() {
		System.out.println("��ü ���� ���");
		System.out.println("----------------------------------");
		System.out.println("������   ��缱����   �����ο�   ������");
		System.out.println("----------------------------------");
		for (int i = 0; i < lectureList.size(); i++) {
			System.out.println(lectureList.get(i).getLecture() + " " + lectureList.get(i).getTeacherName());
		}
	}
}
