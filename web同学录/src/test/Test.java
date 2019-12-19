package test;
import java.util.ArrayList;

import dao.StuDao;
import entity.Stu;
public class Test {
public static void main(String[] args) {
	StuDao dao = new StuDao();
	ArrayList<Stu> list = dao.selectAll(1,5);
	System.out.println(list);
}
}
