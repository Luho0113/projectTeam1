package student.Management;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Data {
	
	public List<Student> getStudentList() {
		//�л� ����Ʈ ����
		List<Student> studentList = new ArrayList<Student>();
		//��ü �߰�
		studentList.add(new Student("ȫ�浿", "010-1111-1111", "1��", "����"));
		studentList.add(new Student("�̼���", "010-2222-2222", "2��", "����"));
		studentList.add(new Student("������1", "010-3333-3333", "1��", "����"));
		studentList.add(new Student("������2", "010-4444-4444", "2��", "����"));
		studentList.add(new Student("������3", "010-5555-5555", "1��", "����"));
		studentList.add(new Student("������4", "010-6666-6666", "1��", "����"));
		studentList.add(new Student("������5", "010-7777-7777", "2��", "����"));
		studentList.add(new Student("������6", "010-8888-8888", "1��", "����"));
		studentList.add(new Student("������7", "010-9999-9999", "1��", "����"));
		studentList.add(new Student("������8", "010-0000-0000", "1��", "����"));

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
	
	public List<Score> getScoreList() {
		// ����ǥ(����) ����Ʈ ����
		List<Score> scoreList = new ArrayList<Score>();

		// ��ü �߰�
		scoreList.add(new Score(80));
		scoreList.add(new Score(70));
		scoreList.add(new Score(100));
		scoreList.add(new Score(80));
		scoreList.add(new Score(50));
		scoreList.add(new Score(80));
		scoreList.add(new Score(90));
		scoreList.add(new Score(80));

		return scoreList; // ����Ʈ�� �ּҸ� ����

	}

	public Map<Object, Object> getScoreMap() {

		return null;
	}
	
	
}
