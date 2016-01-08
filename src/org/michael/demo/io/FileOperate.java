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

	// 在够方法处必须指定保存文件的名字
	public FileOperate(String path) {
		this.file = new File(path);
		if (!this.file.exists()) {
			// 如果内容不存在，则认为是第一次操作，需要初始化
			try {
				this.save(new TreeSet<Person>());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 把对象保存在文件之中
	public void save(Object obj) throws Exception {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(this.file));
			// 写入对象
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

	// 把对象从文件之中读进来
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
