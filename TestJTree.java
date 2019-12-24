import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*; //引入以后源文件中可直接调用类名而不需要带包名
public class TestJTree extends JFrame {
    //程序入口
	public static void main(String[] args) {
		TestJTree tj=new TestJTree();
		tj.init();
	}
      
	//初始化界面内容,可以放在构造方法中
	public void init() {
		this.setTitle("蓝杰JTree示例");
		this.setSize(300, 400);
		java.awt.FlowLayout fl = new java.awt.FlowLayout();
		this.setLayout(fl);
		// 将自己创建的树加到界面上:
		javax.swing.JTree tree = createTree();
		this.add(tree);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	}

	 //创建一个自定义树
	public javax.swing.JTree createTree() {
		// 创建默认树
		javax.swing.JTree tree = new javax.swing.JTree();
		// 首先,创建一个根节点:
		javax.swing.tree.DefaultMutableTreeNode rootNode = new javax.swing.tree.DefaultMutableTreeNode();
		// 设定节点上的数据对象,节点显示标题则为设定对象的toString()值
		rootNode.setUserObject("树的测试");
		// 树下有5个组:
		for (int i = 0; i < 5; i++) {
			DefaultMutableTreeNode teamNode = new DefaultMutableTreeNode();
			teamNode.setUserObject("第" + i + "组");
			// 将组节点加到根节点上:
			rootNode.add(teamNode);
			for (int t = 0; t < 6; t++) {
				DefaultMutableTreeNode userNode = new DefaultMutableTreeNode();
				userNode.setUserObject("第" + t + "个用户");
				// 将用户节点加到组节点上:
				teamNode.add(userNode);
			}
			// 创建树的Model对象，创建时传入根节点：
			javax.swing.tree.DefaultTreeModel dm = new DefaultTreeModel(
					rootNode);
			// 将模型设给树,树上显示的将上前面所加载的节点
			tree.setModel(dm);
			// 设定树上的图标
			// ImageIcon leafIcon = new ImageIcon("src/budy_init.gif");
			// DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
			// renderer.setLeafIcon(leafIcon);
			// tree.setCellRenderer(renderer);
		}
		return tree;
	}
}
