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

	// 菜单要有增加信息、修改信息等的功能，增加信息的时候要选择是增加学生还是工人
	public Menu() {
		this.input = new InputData();
		while (true) {
			this.showMain();
		}
	}

	// 显示主菜单
	public void showMain() {
		System.out
				.println("                    学校信息管理程序                            ");
		System.out
				.println("                    1、学生信息管理                             ");
		System.out
				.println("                    2、工人信息管理                             ");
		System.out
				.println("                    3、退出系统                                     ");
		// 要进行选择
		System.out.println("\n\n 请选择所要的操作：");
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
			System.out.println("系统退出，拜拜~~~");
			System.exit(1);
			break;
		}
		default: {
			System.out.println("            选择错误，请重新选择！");
			break;
		}
		}
	}

	// 显示学生操作的菜单
	public void showStudent() {
		this.po = new StudentOperate();
		System.out
				.println("                        学生信息管理                                 ");
		System.out
				.println("                     1、增加学生信息                             ");
		System.out
				.println("                     2、列出全部学生信息                     ");
		System.out
				.println("                     3、查询学生信息                             ");
		System.out
				.println("                     4、删除学生信息                             ");
		System.out
				.println("                     5、修改学生信息                             ");
		System.out
				.println("                     6、返回上一级菜单                         ");
		System.out.println("\n\n请选择具体的操作：");
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
			System.out.println("            选择错误，请重新选择！");
			break;
		}
		}
	}

	// 显示工人操作的菜单
	public void showWorker() {
		this.po = (PersonOperate) new WorkerOperate();
		System.out
				.println("                        工人信息管理                                 ");
		System.out
				.println("                     1、增加工人信息                             ");
		System.out
				.println("                     2、列出全部工人信息                     ");
		System.out
				.println("                     3、查询工人信息                             ");
		System.out
				.println("                     4、删除工人信息                             ");
		System.out
				.println("                     5、修改工人信息                             ");
		System.out
				.println("                     6、返回上一级菜单                         ");
		System.out.println("\n\n请选择具体的操作：");
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
			System.out.println("            选择错误，请重新选择！");
			break;
		}
		}
	}
}
