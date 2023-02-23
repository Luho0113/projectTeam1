package student.Management;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
			for (int i = 0; i < data.getStudentList().size(); i++) {
				String pNum = data.getStudentList().get(i).phoneNum; // i�ε����� ��ȭ��ȣ�� ����
				String sName = data.getStudentList().get(i).studentName;// i�ε����� �л��̸��� ����
				if (id.contains(pNum)) {
					System.out.println(sName + " ���� �����Ͽ����ϴ�");
					System.out.print("�⼮ �Ͻðڽ��ϱ�? > (y/n) ");
					String answer = sc.next();
					if (answer.equals("y")) {
						attendingCheck();// �⼮ üũ �޼ҵ� ����
						break;
					} else if (answer.equals("n")) {
						System.out.println("�����մϴ�");
						break;
					}
				} else {
					System.out.println("��ϵ��� ���� �л��� ��ȣ�Դϴ�");
					System.out.println("�ٽ� �Է��Ͻðڽ��ϱ�? > (y/n)");
					String answer = sc.next();
					if (answer.equals("y")) {
						return;
					} else
						break;
				}
			}
			break;
		}
	}

//			if(id.) {
//					System.out.println("��ϵ��� ���� �л��� ��ȣ�Դϴ�");
//					System.out.println("�ٽ� �Է��Ͻðڽ��ϱ�? > (y/n)");
//					String answer = sc.next();
//				if(answer.equals("y")) {
//						break;
//					}else if(answer.equals("n")) {
//						System.out.println("�����մϴ�");
//					}
//				}
//			}
//		System.out.println("�߸� �Է��Ͽ����ϴ�");
//		System.out.println("�ٽ� �Է��Ͻðڽ��ϱ�? > (y/n)");
//		String answer = sc.next();
//		if(answer.equals("y")) {
//				continue;
//		}else if(answer.equals("n")) {
//			break;
//			}

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
		} else {
			System.out.println("�⼮ ������ �ð��� �ƴմϴ�");
		}

	}
}
