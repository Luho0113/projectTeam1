package student.Management;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AttendanceManage extends Data{ //data�� �л��̸� �������
	String name; //�л� �̸�
	String attendStatus; // �⼮ ����
	Date date; // ��¥ ��ƿ
	SimpleDateFormat spdf; // ��¥ ��ƿ
	
	public String getName() {
		return name;
	}

	public void setName(String name) {//<< ���⿡ data�� �̸��� ����;��ϴµ� ����� �𸣰ڴ�
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public SimpleDateFormat getSpdf() {
		return spdf;
	}

	public void setSpdf(SimpleDateFormat spdf) {
		this.spdf = spdf;
	}

	public void attendingCheck() {//�⼮ üũ �޼ҵ�
		
		Date date = new Date();//��¥ ��� ��ƿ(����)
		SimpleDateFormat sim = new SimpleDateFormat("HH��mm��ss��");
		//��¥�� Ư�� ���·� �����ϴ� ��ƿ
		String str = sim.format(date);//��¥�� ���ڷ� ����ȯ
        int hour = Integer.parseInt(str.substring(0, 2));//���ڿ����� 
        int minute = Integer.parseInt(str.substring(3, 5));
/*      �⼮, ����, �Ἦ ���� : �⺻���� �Ἦ, ��¥ ��� ������ �Ϻκ��� ������ int �ڷ������� ����ȯ �� ��
       	���� ���Ͽ� ����, �⼮ ���θ� �Ǻ��Ѵ�. >> �̰� ���� ���ϱ�...*/ 
		ArrayList<AttendanceManage> am = new ArrayList<AttendanceManage>();

        
 /*       if (hour >= 9 ) { 
            System.out.println("[�⼮üũ �Ϸ�]");
            System.out.println("���� �ð� : "+str);
            System.out.println("�����Դϴ�.");
 //           studentsInfo.get(num).checkStatus = "����"; 
        } else {
            System.out.println("[�⼮üũ �Ϸ�]");
            System.out.println("���� �ð� : "+str);
            System.out.println("���� �⼮ �Դϴ�.");
  //          studentsInfo.get(num).checkStatus = "�⼮";
        }*/
        
    }

}
