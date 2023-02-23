package student.Management;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AttendanceManage {
	String attendStatus; // �⼮ ����

	public AttendanceManage(String attendStatus) {
		super();
		this.attendStatus = attendStatus;
	}

	public String getAttendStatus() {
		return attendStatus;
	}

	public void setAttendStatus(String attendStatus) {
		this.attendStatus = attendStatus;
	}

	public void studentArrive() {// �л� ���� �޼ҵ�
		Scanner sc = new Scanner(System.in);
		Data data = new Data();
		System.out.print("������ �ڵ��� ��ȣ�� �Է��Ͽ��ֽʽÿ� > ");
		String id = sc.next();
		boolean flag = true;
		while (flag) {
			List<AttendanceManage> list = new ArrayList<AttendanceManage>();
			String sNum;
			String sName;
			for (int i = 0; i < data.getStudentList().size(); i++) {
				sNum = data.getStudentList().get(i).getPhoneNum();// .get(i).getPhoneNum(); // studentList - i�ε����� ��ȭ��ȣ�� ����
				sName = data.getStudentList().get(i).getStudentName();// studentList - i�ε����� �л��̸��� ����			
			
				if(id.equals(sNum)) { // sNum�� �Է��� id�� ���ٸ�
					System.out.println(sName + " ��, �⼮ �Ͻðڽ��ϱ�? > (y/n) ");
					System.out.println("'n'�� �Է��ϸ� ���α׷��� ����˴ϴ�");
					String answer = sc.next(); //��� �Է�
					if (answer.equals("y")) {
						attendingCheck();// �⼮ üũ �޼ҵ� ����
						flag = false;	
					}else if (answer.equals("n")) {
						System.out.println("���α׷��� �����մϴ�");
						flag = false;	
					}else { // y or n�� �ƴ� �ٸ��� �Էµ��� ��
						System.out.println("�߸� �Է��Ͽ����ϴ�");
						System.out.println("�ٽ� �Է��Ͽ��ֽʽÿ�");		
					}
				}
			}
		}
	}
		/*	if(!id.equals(sNum)) { // sNum�� �Է��� id�� �ٸ��ٸ�
				System.out.println("��ϵ��� ���� �л��� ��ȣ�Դϴ�");
				System.out.println("�ٽ� �Է��Ͻðڽ��ϱ�? > (y/n)");
				String answer = sc.next();
				if(answer.equals("n")) {
					System.out.println("���α׷��� �����մϴ�");
					flag = false;
				}else if(answer.equals("y")) {
							
				}
			}*/

	public void attendingCheck() {// �⼮ üũ �޼ҵ�
//		Calendar now = Calendar.getInstance();
//		int year = now.get(Calendar.YEAR);
//		int month = now.get(Calendar.MONTH);
//		int day = now.get(Calendar.DAY_OF_WEEK);// ��/��/��/
		
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("HH��mm��ss��"); // ��¥�� Ư�� ���·� �ٲ�
		String str = sim.format(date);// ��¥�� ���ڷ� ����ȯ

		if (9 <= date.getHours() && date.getHours() <= 18) {
			System.out.println("�⼮üũ �Ϸ�");
			System.out.println("���� �ð� : " + str);
			System.out.println(date.getHours() - 9 + "�ð� " + date.getMinutes() + "�� " + date.getSeconds() + "�� �����Դϴ�.");
		} else if (8 <= date.getHours() && date.getHours() < 9) {
			System.out.println("�⼮üũ �Ϸ�");
			System.out.println("���� �ð� : " + str);
			System.out.println("���� �⼮ �Դϴ�.");
		} else if (0 <= date.getHours() && date.getHours() < 8){
		 	System.out.println("�ʹ� ���� ���̽��ϴ�");
			System.out.println("���½ð� ���Ŀ� ��� ��Ź�帳�ϴ�.");
		} else {
			System.out.println("�⼮ ������ �ð��� �������ϴ�.");
			System.out.println("���� �ٽ� ������ֽʽÿ�.");
		}

	}
}
