import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.text.html.*;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

public class User {
	userdata[] Data = new userdata[200];
	
	boolean[] seats = new boolean[50];
	
	
	public static void main(String[] args) {
		new FirstFrame();
		new InsertNumber();
	}
	
}

class userdata{
	String name;
	String number;
	String starttime;
	String finishtime;
}

//첫번째 화면
//당일권 구매+ 정기이용권 구매 + 입실/퇴실 + 기간자유석 자리선택 + 좌석 이동 + 사물함 대여 + 스터디룸 예약
class FirstFrame extends JFrame{
	
	
	String b2 = "<html>" + "정기/시간권" + "<br>" + "구매" + "</html>";
	String b5 = "<html>" + "기간자유석" + "<br>" + "자리선택" + "</html>";
	
	String pattern = "MM월 dd일 HH:mm:ss";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	
	
	String date = simpleDateFormat.format(new Date());
	
	JLabel posseat = new JLabel();
	JLabel time = new JLabel(date);
	JButton Button1 = new JButton("당일권 구매");
	JButton Button2 = new JButton(b2);
	JButton Button3 = new JButton("입실");
	JButton Button4 = new JButton("퇴실");
	JButton Button5 = new JButton(b5);
	JButton Button6 = new JButton("사물함 대여");
	//JButton Button7 = new JButton("스터디룸 예약");
	//JButton Button8 = new JButton("좌석이동");
	
	
	public FirstFrame() {
		getContentPane().setBackground(Color.DARK_GRAY); //배경색 바꾸기
		setVisible(true);
		setSize(900,1000);
		setLayout(null);
		
		time.setFont(new Font("맑은고딕",Font.BOLD, 30));
		time.setBounds(260, 10, 400, 100);
		time.setForeground(Color.white); //글씨 색 현재는 흰색, 원하는대로 바꾸기
		
		add(time);
		
		Button1.setBackground(Color.orange);
		Button1.setBounds(60,400,150,150);
		Button1.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Button1);
		Button1.addActionListener(new EventHandler());
		
		Button2.setBackground(Color.orange);
		Button2.setBounds(260,400,150,150);
		Button2.setFont(new Font("맑은고딕",Font.BOLD,20));
		add(Button2);
		
		Button5.setBackground(Color.orange);
		Button5.setBounds(460,400,150,150);
		Button5.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Button5);
		
		Button6.setBackground(Color.orange);
		Button6.setBounds(660,400,150,150);
		Button6.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Button6);
		
		Button3.setBackground(Color.orange);
		Button3.setBounds(460,600,150,150);
		Button3.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Button3);
		
		Button4.setBackground(Color.orange);
		Button4.setBounds(660,600,150,150);
		Button4.setFont(new Font("맑은고딕",Font.BOLD, 20));
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

//전화번호 입력
class InsertNumber extends JFrame implements ActionListener{
	
	
	JLabel info = new JLabel("핸드폰 뒤 8자리를 입력해 주세요");
	JTextField number = new JTextField();
	JButton Button0 = new JButton("0");
	JButton Button1 = new JButton("1");
	JButton Button2 = new JButton("2");
	JButton Button3 = new JButton("3");
	JButton Button4 = new JButton("4");
	JButton Button5 = new JButton("5");
	JButton Button6 = new JButton("6");
	JButton Button7 = new JButton("7");
	JButton Button8 = new JButton("8");
	JButton Button9 = new JButton("9");
	JButton Pay = new JButton("결제");
	
	
	JButton Del = new JButton("<-");
	
	public InsertNumber() {
		
		//getContentPane().setBackground(Color.DARK_GRAY); //색깔 정하기
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		setVisible(true);
		setSize(600,650);
		
		info.setFont(new Font("맑은고딕",Font.BOLD, 20));
		info.setHorizontalAlignment(JLabel.CENTER);
		Button0.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Button1.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Button2.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Button3.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Button4.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Button5.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Button6.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Button7.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Button8.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Button9.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Pay.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Del.setFont(new Font("맑은고딕",Font.BOLD, 30));
		
		
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 5;
		gbc.gridheight = 2;
		add(info, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 3;
		gbc.gridheight = 2;
		add(number, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(Button1, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(Button2, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(Button3, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(Button4, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(Button5, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(Button6, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(Button7, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(Button8, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(Button9, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 8;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		add(Button0, gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 8;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		add(Del, gbc);
		
		gbc.gridx = 3;
		gbc.gridy = 10;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		add(Pay, gbc);
		
		
		Button0.addActionListener(this);
		Button1.addActionListener(this);
		Button2.addActionListener(this);
		Button3.addActionListener(this);
		Button4.addActionListener(this);
		Button5.addActionListener(this);
		Button6.addActionListener(this);
		Button7.addActionListener(this);
		Button8.addActionListener(this);
		Button9.addActionListener(this);
		Del.addActionListener(this);
		Pay.addActionListener(this);
		
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		String input = e.getActionCommand();
		String temp = number.getText();
		if(input.equals("0")) {
			temp += "0";
			number.setText(temp);
		}
		else if(input.equals("1")) {
			temp += "1";
			number.setText(temp);
		}
		else if(input.equals("2")) {
			temp += "2";
			number.setText(temp);
		}
		else if(input.equals("3")) {
			temp += "3";
			number.setText(temp);
		}
		else if(input.equals("4")) {
			temp += "4";
			number.setText(temp);
		}
		else if(input.equals("5")) {
			temp += "5";
			number.setText(temp);
		}
		else if(input.equals("6")) {
			temp += "6";
			number.setText(temp);
		}
		else if(input.equals("7")) {
			temp += "7";
			number.setText(temp);
		}
		else if(input.equals("8")) {
			temp += "8";
			number.setText(temp);
		}
		else if(input.equals("9")) {
			temp += "9";
			number.setText(temp);
		}
		else if(input.equals("<-")) {
			temp = temp.substring(0,temp.length()-1);
			number.setText(temp);
		}
		else if(input.equals("결제")){
			//홈 화면으로 넘어가기
		}
		
		
		
		
	}
	
	
}



