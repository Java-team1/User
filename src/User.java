import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class User {
	userdata[] Data = new userdata[200];
	
	boolean[] seats = new boolean[50];
	
	
	public static void main(String[] args) {
		new FirstFrame();
	}
	
}

class userdata{
	String name;
	String number;
}

//ù��° ȭ��
//���ϱ� ����+ �����̿�� ���� + �Խ�/��� + �Ⱓ������ �ڸ����� + �¼� �̵� + �繰�� �뿩 + ���͵�� ����
class FirstFrame extends JFrame{
	
	
	
	JLabel posseat = new JLabel();
	JLabel time = new JLabel();
	JButton Button1 = new JButton("���ϱ� ����");
	JButton Button2 = new JButton("����/�ð��� ����");
	JButton Button3 = new JButton("�Խ�");
	JButton Button4 = new JButton("���");
	JButton Button5 = new JButton("�Ⱓ������\n �ڸ�����");
	JButton Button6 = new JButton("�繰�� �뿩");
	//JButton Button7 = new JButton("���͵�� ����");
	//JButton Button8 = new JButton("�¼��̵�");
	
	public FirstFrame() {
		
		setVisible(true);
		setSize(900,1000);
		setLayout(null);
		
		Button1.setBackground(Color.orange);
		Button1.setBounds(60,400,150,150);
		add(Button1);
		Button1.addActionListener(new EventHandler());
		
		Button2.setBackground(Color.orange);
		Button2.setBounds(260,400,150,150);
		add(Button2);
		
		Button5.setBackground(Color.orange);
		Button5.setBounds(460,400,150,150);
		add(Button5);
		
		Button6.setBackground(Color.orange);
		Button6.setBounds(660,400,150,150);
		add(Button6);
		
		Button3.setBackground(Color.orange);
		Button3.setBounds(460,600,150,150);
		add(Button3);
		
		Button4.setBackground(Color.orange);
		Button4.setBounds(660,600,150,150);
		add(Button4);
		
	}
	
	
	
	
	
	
}

class EventHandler implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		new SecondFrame();
	}
}

//�¼� ���� + Ȩ��ư ��� �߰�
class SecondFrame extends JFrame{
	JButton seat1 = new JButton("1");
	
	public SecondFrame() {
		setVisible(true);
		setSize(900,1000);
		setLayout(null);
		seat1.setBackground(Color.orange);
		seat1.setBounds(50,50,50,50);
		add(seat1);
	}
}

//���ϱ� ����
class BuyFrame extends JFrame{
	
	//�¼�����
	
}

//�ð�/����� ����
class BuyFrame2 extends JFrame{
	
}