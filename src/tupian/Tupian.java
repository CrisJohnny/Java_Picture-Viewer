package tupian;

import java.awt.*;
import java.awt.event.*;  
import java.io.*;  
import javax.swing.*;  


public class Tupian {
	//������
    public static void main(String[] args) {  

        ImageViewer ff = new ImageViewer();  //��������
  
    }  
  

}


class ImageViewer extends JFrame implements ActionListener  {  
	
	
     JLabel label;  //��ǩ
     JPanel jp1; //����
     JFileChooser chooser;  //ѡ��Ի���
     JMenuBar jmb; //�˵���
     JMenu menu; //�ļ�
     JMenuItem jm1; //��ͼƬ
     JMenuItem jm2; //�˳�
    //���캯��
    public ImageViewer() {  
    	
        this.setTitle("ͼƬ�����");  //����
        this.setSize(500,500);  //��С
          
        label = new JLabel(); //��������
        
        jp1=new JPanel();//��������
        this.add(jp1,BorderLayout.SOUTH); //�߽粼��
        this.add(label,BorderLayout.CENTER); //�߽粼��
          
        this.chooser = new JFileChooser();//�ļ�ѡ����  
        chooser.setCurrentDirectory(new File("."));//���õ�ǰ���·��  
          
        jmb = new JMenuBar();  
        this.setJMenuBar(jmb);  
          
        menu = new JMenu("�ļ�");  
        jmb.add(menu);  
          
        jm1 = new JMenuItem("��ͼƬ");  
        //ע�����
        jm1.addActionListener(this);
        jm1.setActionCommand("open");        
        menu.add(jm1);  
        
        jm2 = new JMenuItem("�˳�");  
        jm2.addActionListener(this);
        jm2.setActionCommand("exit");  
        menu.add(jm2);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //�ر�
        this.setVisible(true);  //Ĭ����ʾ
        
    }

	@Override
	//ʵ�ֽӿ�
	public void actionPerformed(ActionEvent b) {
		// TODO �Զ����ɵķ������
		
		//���ļ�����
		if(b.getActionCommand().equals("open"))
		{
			   chooser.showOpenDialog(null);//�����ļ�ѡ��Ի���   
               String name = chooser.getSelectedFile().getPath();  //�õ�·��
               ImageIcon a=new ImageIcon(name);    //�õ�ͼƬ������ 
               a.setImage(a.getImage().getScaledInstance(a.getIconWidth()-50,a.getIconHeight()-50,Image.SCALE_DEFAULT));//����ͼƬ
               label.setIcon(a);  //��ʾͼƬ
               this.setSize(a.getIconWidth(),a.getIconHeight()+30); //������ʾ��С
               this.repaint();//�ػ����

        //�˳�����
		}else if(b.getActionCommand().equals("exit"))
		{
			System.exit(0);  //�ر�
		}
		 
	}

  
}  