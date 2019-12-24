import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*; //�����Ժ�Դ�ļ��п�ֱ�ӵ�������������Ҫ������
public class TestJTree extends JFrame {
    //�������
	public static void main(String[] args) {
		TestJTree tj=new TestJTree();
		tj.init();
	}
      
	//��ʼ����������,���Է��ڹ��췽����
	public void init() {
		this.setTitle("����JTreeʾ��");
		this.setSize(300, 400);
		java.awt.FlowLayout fl = new java.awt.FlowLayout();
		this.setLayout(fl);
		// ���Լ����������ӵ�������:
		javax.swing.JTree tree = createTree();
		this.add(tree);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	}

	 //����һ���Զ�����
	public javax.swing.JTree createTree() {
		// ����Ĭ����
		javax.swing.JTree tree = new javax.swing.JTree();
		// ����,����һ�����ڵ�:
		javax.swing.tree.DefaultMutableTreeNode rootNode = new javax.swing.tree.DefaultMutableTreeNode();
		// �趨�ڵ��ϵ����ݶ���,�ڵ���ʾ������Ϊ�趨�����toString()ֵ
		rootNode.setUserObject("���Ĳ���");
		// ������5����:
		for (int i = 0; i < 5; i++) {
			DefaultMutableTreeNode teamNode = new DefaultMutableTreeNode();
			teamNode.setUserObject("��" + i + "��");
			// ����ڵ�ӵ����ڵ���:
			rootNode.add(teamNode);
			for (int t = 0; t < 6; t++) {
				DefaultMutableTreeNode userNode = new DefaultMutableTreeNode();
				userNode.setUserObject("��" + t + "���û�");
				// ���û��ڵ�ӵ���ڵ���:
				teamNode.add(userNode);
			}
			// ��������Model���󣬴���ʱ������ڵ㣺
			javax.swing.tree.DefaultTreeModel dm = new DefaultTreeModel(
					rootNode);
			// ��ģ�������,������ʾ�Ľ���ǰ�������صĽڵ�
			tree.setModel(dm);
			// �趨���ϵ�ͼ��
			// ImageIcon leafIcon = new ImageIcon("src/budy_init.gif");
			// DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
			// renderer.setLeafIcon(leafIcon);
			// tree.setCellRenderer(renderer);
		}
		return tree;
	}
}
