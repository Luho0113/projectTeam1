package student.Management;

import java.util.ArrayList;
import java.util.List;

public class Data {
	
	public List<Student> getStudentList() {
		//�л� ����Ʈ ����
		List<Student> studentList = new ArrayList<Student>();
		
		//��ü �߰�
		studentList.add(new Student("ȫ�浿", "010-1111-1111", "1��", "����"));
		studentList.add(new Student("�̼���", "010-2222-2222", "2��", "����"));
		studentList.add(new Student("������", "010-3333-3333", "1��", "����"));
		
		return studentList; //����Ʈ�� �ּҸ� ����
 		
	}
	
	public List<Lecture> getLectureList() {
		// ���� ����Ʈ ����
		List<Lecture> lectureList = new ArrayList<Lecture>();

		// ��ü �߰�
		lectureList.add(new Lecture("����", "��μ�", 200000));
		lectureList.add(new Lecture("����", "������", 300000));
		lectureList.add(new Lecture("����", "�ּ���", 400000));

		return lectureList; // ����Ʈ�� �ּҸ� ����

	}
}
