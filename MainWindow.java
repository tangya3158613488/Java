import java.awt.BorderLayout;
import java.awt.Cursor;
import java.io.File;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
public class MainWindow extends JFrame { 
	public MainWindow() {
		FileExplporer fileExplorer=new FileExplporer(); 
		this.add(fileExplorer)   ; 
		initComponents(); 
		}
	public class FileExplporer extends JPanel implements TreeSelectionListener { 
		JTree tree; 
		public FileExplporer(){ 
			try{  jbInit();    } 
			catch(Exception e){
				e.printStackTrace();  }
			} 
		private void jbInit() throws Exception{ 
			this.setSize(200,500); 
			this.setLayout(new BorderLayout()); 
			initTree("�ҵĵ���"); 
			JScrollPane jScrollPane1=new JScrollPane();  
			jScrollPane1.getViewport().add(tree,null); 
			this.add(jScrollPane1,BorderLayout.CENTER); 
			this.setVisible(true);         
			} 
		void initTree(String dir){ 
			FileTreeNode root=(FileTreeNode)buildTree(dir); 
			FileTreeNode parent1=(FileTreeNode)buildTree("c:\\"); 
			FileTreeNode parent2=(FileTreeNode)buildTree("d:\\"); 
			root.add(parent1); 
			root.add(parent2); 
			DefaultTreeModel treeModel=new DefaultTreeModel(root); 
			tree=new JTree(treeModel); 
			MyTreeExpansionListener listener =new MyTreeExpansionListener(tree,root,treeModel,this);
			tree.addTreeExpansionListener(listener); 
			tree.addTreeSelectionListener(this); 
			} 
		public TreeNode buildTree(String dir){ 
			FileTreeNode root=new FileTreeNode(new File(dir)); 
			root.readTree(false); 
			return (TreeNode)root; 
			} 
		public void valueChanged(TreeSelectionEvent e) { 
			Object path[]=e.getPath().getPath(); 
			String s=path[0].toString(); 
			for(int i=1;i<path.length;i++){ 
				s+="\\"+path[i].toString(); 
				jTextField1.setText(s); 
				System.out.println("haha"); 
				}
			} 
		class MyTreeExpansionListener implements TreeExpansionListener{ 
			FileTreeNode root; 
			JTree jtree; 
			DefaultTreeModel treeNodel; 
			JPanel prame; 
			public MyTreeExpansionListener(JTree tree,FileTreeNode node,DefaultTreeModel tmodel,JPanel thePanel){ 
				root=node; 
				jtree=tree; 
				treeNodel=tmodel; 
				prame=thePanel; 
				} 
			public void treeExpanded(TreeExpansionEvent event){ 
				TreePath path=event.getPath(); 
				FileTreeNode node=(FileTreeNode)path.getLastPathComponent(); 
				prame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR)); 
				prame.setEnabled(false);
				if(node.readTree()){
					int childrenIdx[]=new int[node.getChildCount()];
					int i=0;
					for(Enumeration e=node.children();e.hasMoreElements();){
						Object obj=e.nextElement();
						childrenIdx[i]=node.getIndex((TreeNode)obj);
						i++;
						}
					treeNodel.nodesWereInserted(node,childrenIdx);
					}
				prame.setEnabled(true);
				prame.setCursor(Cursor.getDefaultCursor());
				}
			public void treeCollapsed(TreeExpansionEvent event){   }
			}
		class FileTreeNode extends DefaultMutableTreeNode{
			boolean isAdded;
			public FileTreeNode(File file){
				super(file);
				isAdded=false;
				}
			public boolean readTree(){
				return readTree(false);   }
			public boolean readTree(boolean b){
				if(isAdded)
					return false;
				String list[]=getFileObject().list();
				if(list!=null){
					for(int i=0;i<list.length;i++){
						FileTreeNode subnode=new FileTreeNode(new File(getFileObject(),list[i]));
						add(subnode);
						if(b){
							subnode.readTree(b);
							}
						}
					}
				isAdded=true;
				return true;
				}
			public File getFileObject(){
				return (File)getUserObject();
				}                   
				public String toString(){
					File file=getFileObject();
					return file.getName().length()>0?file.getName():file.getPath();
					}
				@Override
				public boolean isLeaf(){
					return ((File)userObject).isFile();
					}
				}
		}   
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">                          164    
	private void initComponents() {
		 jTextField1 = new javax.swing.JTextField();
		 jLabel1 = new javax.swing.JLabel();
		 jMenuBar1 = new javax.swing.JMenuBar();
		 jMenu1 = new javax.swing.JMenu();
		 jMenu2 = new javax.swing.JMenu();
		 jMenu3 = new javax.swing.JMenu();
		 setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		 jTextField1.addActionListener(new java.awt.event.ActionListener() {
			 public void actionPerformed(java.awt.event.ActionEvent evt) {
				// jTextField1ActionPerformed(evt);
				 }
			 });
		 jLabel1.setText("�ļ�·��");
		 jMenu1.setText("�ļ�");
		 jMenu1.setFont(new java.awt.Font("����", 0, 18));
		 jMenuBar1.add(jMenu1);
		 jMenu2.setText("�༭");
		 jMenu2.setFont(new java.awt.Font("����", 0, 18));
		 jMenuBar1.add(jMenu2);
		 jMenu3.setText("����");
		 jMenu3.setFont(new java.awt.Font("����", 0, 18));
		 jMenuBar1.add(jMenu3);
		 setJMenuBar(jMenuBar1);}
		/* org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
		 getContentPane().setLayout(layout);
		 layout.setHorizontalGroup(
				 layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup().addContainerGap(251, Short.MAX_VALUE).add(jLabel1).add(36, 36, 36).add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 472, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)));
		 layout.setVerticalGroup(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(layout.createSequentialGroup().add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)).addContainerGap(491, Short.MAX_VALUE)));
		 pack();
		 }// </editor-fold>                       218 219     
	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {    
		// TODO add your handling code here:221   
		}                                          
	/**224     * @param args the command line arguments225     */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() { new MainWindow().setVisible(true);
			}
			});
		}
	// Variables declaration - do not modify                     
	private javax.swing.JLabel jLabel1;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JTextField jTextField1;     // End of variables declaration                  
	
}