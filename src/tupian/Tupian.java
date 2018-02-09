package tupian;

import java.awt.*;
import java.awt.event.*;  
import java.io.*;  
import javax.swing.*;  


public class Tupian {
	//主函数
    public static void main(String[] args) {  

        ImageViewer ff = new ImageViewer();  //创建对象
  
    }  
  

}


class ImageViewer extends JFrame implements ActionListener  {  
	
	
     JLabel label;  //标签
     JPanel jp1; //画板
     JFileChooser chooser;  //选择对话框
     JMenuBar jmb; //菜单条
     JMenu menu; //文件
     JMenuItem jm1; //打开图片
     JMenuItem jm2; //退出
    //构造函数
    public ImageViewer() {  
    	
        this.setTitle("图片浏览器");  //标题
        this.setSize(500,500);  //大小
          
        label = new JLabel(); //创建对象
        
        jp1=new JPanel();//创建对象
        this.add(jp1,BorderLayout.SOUTH); //边界布局
        this.add(label,BorderLayout.CENTER); //边界布局
          
        this.chooser = new JFileChooser();//文件选择器  
        chooser.setCurrentDirectory(new File("."));//设置当前浏览路径  
          
        jmb = new JMenuBar();  
        this.setJMenuBar(jmb);  
          
        menu = new JMenu("文件");  
        jmb.add(menu);  
          
        jm1 = new JMenuItem("打开图片");  
        //注册监听
        jm1.addActionListener(this);
        jm1.setActionCommand("open");        
        menu.add(jm1);  
        
        jm2 = new JMenuItem("退出");  
        jm2.addActionListener(this);
        jm2.setActionCommand("exit");  
        menu.add(jm2);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //关闭
        this.setVisible(true);  //默认显示
        
    }

	@Override
	//实现接口
	public void actionPerformed(ActionEvent b) {
		// TODO 自动生成的方法存根
		
		//打开文件处理
		if(b.getActionCommand().equals("open"))
		{
			   chooser.showOpenDialog(null);//弹出文件选择对话框   
               String name = chooser.getSelectedFile().getPath();  //得到路径
               ImageIcon a=new ImageIcon(name);    //得到图片并创建 
               a.setImage(a.getImage().getScaledInstance(a.getIconWidth()-50,a.getIconHeight()-50,Image.SCALE_DEFAULT));//绘制图片
               label.setIcon(a);  //显示图片
               this.setSize(a.getIconWidth(),a.getIconHeight()+30); //窗口显示大小
               this.repaint();//重绘界面

        //退出处理
		}else if(b.getActionCommand().equals("exit"))
		{
			System.exit(0);  //关闭
		}
		 
	}

  
}  