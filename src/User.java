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

//첫번째 화면
//당일권 구매+ 정기이용권 구매 + 입실/퇴실 + 기간자유석 자리선택 + 좌석 이동 + 사물함 대여 + 스터디룸 예약
class FirstFrame extends JFrame{
	
	
	
	JLabel posseat = new JLabel();
	JLabel time = new JLabel();
	JButton Button1 = new JButton("당일권 구매");
	JButton Button2 = new JButton("정기/시간권 구매");
	JButton Button3 = new JButton("입실");
	JButton Button4 = new JButton("퇴실");
	JButton Button5 = new JButton("기간자유석\n 자리선택");
	JButton Button6 = new JButton("사물함 대여");
	//JButton Button7 = new JButton("스터디룸 예약");
	//JButton Button8 = new JButton("좌석이동");
	
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

//좌석 선택 + 홈버튼 기능 추가
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

//당일권 구매
class BuyFrame extends JFrame{
	
	//좌석선택
	
}

//시간/정기권 구매
class BuyFrame2 extends JFrame{
	
}