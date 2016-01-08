package org.michael.demo.menu;

import org.michael.demo.operate.PersonOperate;
import org.michael.demo.operate.StudentOperate;
import org.michael.demo.operate.WorkerOperate;
import org.michael.demo.util.InputData;

public class Menu {
	private InputData input = null;
	private PersonOperate po = null;
	private boolean sflag = true;
	private boolean wflag = true;

	// �˵�Ҫ��������Ϣ���޸���Ϣ�ȵĹ��ܣ�������Ϣ��ʱ��Ҫѡ��������ѧ�����ǹ���
	public Menu() {
		this.input = new InputData();
		while (true) {
			this.showMain();
		}
	}

	// ��ʾ���˵�
	public void showMain() {
		System.out
				.println("                    ѧУ��Ϣ�������                            ");
		System.out
				.println("                    1��ѧ����Ϣ����                             ");
		System.out
				.println("                    2��������Ϣ����                             ");
		System.out
				.println("                    3���˳�ϵͳ                                     ");
		// Ҫ����ѡ��
		System.out.println("\n\n ��ѡ����Ҫ�Ĳ�����");
		switch (input.getInt()) {
		case 1: {
			this.sflag = true;
			while (sflag) {
				this.showStudent();
			}
			break;
		}
		case 2: {
			this.wflag = true;
			while (wflag) {
				this.showWorker();
			}
			break;
		}
		case 3: {
			System.out.println("ϵͳ�˳����ݰ�~~~");
			System.exit(1);
			break;
		}
		default: {
			System.out.println("            ѡ�����������ѡ��");
			break;
		}
		}
	}

	// ��ʾѧ�������Ĳ˵�
	public void showStudent() {
		this.po = new StudentOperate();
		System.out
				.println("                        ѧ����Ϣ����                                 ");
		System.out
				.println("                     1������ѧ����Ϣ                             ");
		System.out
				.println("                     2���г�ȫ��ѧ����Ϣ                     ");
		System.out
				.println("                     3����ѯѧ����Ϣ                             ");
		System.out
				.println("                     4��ɾ��ѧ����Ϣ                             ");
		System.out
				.println("                     5���޸�ѧ����Ϣ                             ");
		System.out
				.println("                     6��������һ���˵�                         ");
		System.out.println("\n\n��ѡ�����Ĳ�����");
		switch (this.input.getInt()) {
		case 1: {
			this.po.add();
			break;
		}
		case 2: {
			this.po.findAll();
			break;
		}
		case 3: {
			this.po.findByLike();
			break;
		}
		case 4: {
			this.po.delete();
			break;
		}
		case 5: {
			this.po.update();
			break;
		}
		case 6: {
			this.sflag = false;
			break;
		}
		default: {
			System.out.println("            ѡ�����������ѡ��");
			break;
		}
		}
	}

	// ��ʾ���˲����Ĳ˵�
	public void showWorker() {
		this.po = (PersonOperate) new WorkerOperate();
		System.out
				.println("                        ������Ϣ����                                 ");
		System.out
				.println("                     1�����ӹ�����Ϣ                             ");
		System.out
				.println("                     2���г�ȫ��������Ϣ                     ");
		System.out
				.println("                     3����ѯ������Ϣ                             ");
		System.out
				.println("                     4��ɾ��������Ϣ                             ");
		System.out
				.println("                     5���޸Ĺ�����Ϣ                             ");
		System.out
				.println("                     6��������һ���˵�                         ");
		System.out.println("\n\n��ѡ�����Ĳ�����");
		switch (this.input.getInt()) {
		case 1: {
			this.po.add();
			break;
		}
		case 2: {
			this.po.findAll();
			break;
		}
		case 3: {
			this.po.findByLike();
			break;
		}
		case 4: {
			this.po.delete();
			break;
		}
		case 5: {
			this.po.update();
			break;
		}
		case 6: {
			this.wflag = false;
			break;
		}
		default: {
			System.out.println("            ѡ�����������ѡ��");
			break;
		}
		}
	}
}
