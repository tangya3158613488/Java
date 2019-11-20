package test;

import java.util.ArrayList;

import dao.EmpDao;
import entity.Emp;

public class Test {

	public static void main(String[] args) {
		EmpDao dao=new EmpDao();
		ArrayList<Emp> list=dao.selectAll();
		System.out.println(list);
	}

}
