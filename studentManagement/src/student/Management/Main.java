package student.Management;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//���� ȭ�� �� �α��� �޼ҵ�
		
		Scanner sc = new Scanner(System.in);
		boolean run = true; // �α��� ������ boolean ���������� ����ȭ�餡��
		int count = 0; // 3��Ʋ���� ����
		
		System.out.println("-----------------");
		System.out.println("�����п� ���� ���α׷�");
		System.out.println("-----------------");
		
		
		StudentManager sm = new StudentManager();
		
		
		while (run) {

			System.out.print("���̵� > ");
			String inputId = sc.nextLine();
			System.out.println("��й�ȣ > ");
			String inputPassword = sc.nextLine();
			
			if (inputId.equals(Login.getId()) && inputPassword.equals(Login.getPassword())) {
				count = 0; // Ȥ�ø��� �ʱ�ȭ��
				sm.studentRun(); //StudentManager Ŭ������ �޴� ���� �޼ҵ� ����!
				break; // ������ run�� �������� while�� ����
			} else {
				if (count == 2) {
					run = false;// 3��Ʋ���� �̼����� �ٷ� ����
					System.out.println("�α��� ����\n���α׷��� ����˴ϴ�.");
					break;
				}
				System.out.println("�ٽ� �Է��ϼ���.");
				count++;
				continue; // continue�� Ʋ���� count++ ��� �ݺ�
			}
		}
		
		
	}
}
