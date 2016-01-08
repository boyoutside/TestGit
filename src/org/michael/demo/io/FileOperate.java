package org.michael.demo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeSet;

import org.michael.demo.vo.Person;

public class FileOperate {
	private File file = null;

	// �ڹ�����������ָ�������ļ�������
	public FileOperate(String path) {
		this.file = new File(path);
		if (!this.file.exists()) {
			// ������ݲ����ڣ�����Ϊ�ǵ�һ�β�������Ҫ��ʼ��
			try {
				this.save(new TreeSet<Person>());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// �Ѷ��󱣴����ļ�֮��
	public void save(Object obj) throws Exception {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(this.file));
			// д�����
			out.writeObject(obj);
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				out.close();
			} catch (Exception e) {
			}
		}
	}

	// �Ѷ�����ļ�֮�ж�����
	public Object load() throws Exception {
		Object obj = null;
		ObjectInputStream input = null;
		try {
			input = new ObjectInputStream(new FileInputStream(this.file));
			obj = input.readObject();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				input.close();
			} catch (Exception e) {
			}
		}
		return obj;
	}
}
