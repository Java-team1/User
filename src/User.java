import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.text.html.*;
import javax.swing.border.*;
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
		new LockerFrame();
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

//사물함 선택+홈버튼 기능
class LockerFrame extends JFrame{
	
	JButton homeButton = new JButton("홈으로");
	JLabel info = new JLabel("사물함 예약");
	JTextField used = new JTextField() {  
		public void setBorder(Border boder) {   //현재는 textfield 테두리 투명하게
			
		}
	};
	JLabel total = new JLabel("/35");
	
	JButton Locker1 = new JButton("1");
	JButton Locker2 = new JButton("2");
	JButton Locker3 = new JButton("3");
	JButton Locker4 = new JButton("4");
	JButton Locker5 = new JButton("5");
	JButton Locker6 = new JButton("6");
	JButton Locker7 = new JButton("7");
	JButton Locker8 = new JButton("8");
	JButton Locker9 = new JButton("9");
	JButton Locker10 = new JButton("10");
	JButton Locker11 = new JButton("11");
	JButton Locker12 = new JButton("12");
	JButton Locker13 = new JButton("13");
	JButton Locker14 = new JButton("14");
	JButton Locker15 = new JButton("15");
	JButton Locker16 = new JButton("16");
	JButton Locker17 = new JButton("17");
	JButton Locker18 = new JButton("18");
	JButton Locker19 = new JButton("19");
	JButton Locker20 = new JButton("20");
	JButton Locker21 = new JButton("21");
	JButton Locker22 = new JButton("22");
	JButton Locker23 = new JButton("23");
	JButton Locker24 = new JButton("24");
	JButton Locker25 = new JButton("25");
	JButton Locker26 = new JButton("26");
	JButton Locker27 = new JButton("27");
	JButton Locker28 = new JButton("28");
	JButton Locker29 = new JButton("29");
	JButton Locker30 = new JButton("30");
	JButton Locker31 = new JButton("31");
	JButton Locker32 = new JButton("32");
	JButton Locker33 = new JButton("33");
	JButton Locker34 = new JButton("34");
	JButton Locker35 = new JButton("35");
	
	public LockerFrame() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		setSize(600,650);
		setLayout(null);
		
		homeButton.setBackground(Color.orange); //홈버튼 색깔 현재는 오렌지
		homeButton.setBounds(55,50,70,40);
		homeButton.setFont(new Font("맑은고딕",Font.BOLD, 12));
		add(homeButton);
		
		
		info.setFont(new Font("맑은고딕",Font.BOLD, 30));
		info.setBounds(220,40, 200,50);
		info.setForeground(Color.white); 
		add(info);
		
		total.setFont(new Font("맑은고딕",Font.BOLD, 25));
		total.setBounds(495,135,50,50);
		total.setForeground(Color.white); 
		add(total);
		
		used.setBackground(Color.orange); 
		used.setBounds(445,135,50,50);
		used.setFont(new Font("맑은고딕",Font.BOLD, 13));
		used.setOpaque(false); 
		add(used);
		
		Locker1.setBackground(Color.orange);
		Locker1.setBounds(55,220,70,70);
		Locker1.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker1);
		
		Locker2.setBackground(Color.orange);
		Locker2.setBounds(125,220,70,70);
		Locker2.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker2);
	
		Locker3.setBackground(Color.orange);
		Locker3.setBounds(195,220,70,70);
		Locker3.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker3);
	
		Locker4.setBackground(Color.orange);
		Locker4.setBounds(265,220,70,70);
		Locker4.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker4);
	
		Locker5.setBackground(Color.orange);
		Locker5.setBounds(335,220,70,70);
		Locker5.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker5);
	
		Locker6.setBackground(Color.orange);
		Locker6.setBounds(405,220,70,70);
		Locker6.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker6);
	
		Locker7.setBackground(Color.orange);
		Locker7.setBounds(475,220,70,70);
		Locker7.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker7);
	
		Locker8.setBackground(Color.orange);
		Locker8.setBounds(55,290,70,70);
		Locker8.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker8);
	
		Locker9.setBackground(Color.orange);
		Locker9.setBounds(125,290,70,70);
		Locker9.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker9);
		
		Locker10.setBackground(Color.orange);
		Locker10.setBounds(195,290,70,70);
		Locker10.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker10);

		Locker11.setBackground(Color.orange);
		Locker11.setBounds(265,290,70,70);
		Locker11.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker11);
	
		Locker12.setBackground(Color.orange);
		Locker12.setBounds(335,290,70,70);
		Locker12.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker12);
	
		Locker13.setBackground(Color.orange);
		Locker13.setBounds(405,290,70,70);
		Locker13.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker13);
	
		Locker14.setBackground(Color.orange);
		Locker14.setBounds(475,290,70,70);
		Locker14.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker14);
	
		Locker15.setBackground(Color.orange);
		Locker15.setBounds(55,360,70,70);
		Locker15.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker15);
	
		Locker16.setBackground(Color.orange);
		Locker16.setBounds(125,360,70,70);
		Locker16.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker16);
	
		Locker17.setBackground(Color.orange);
		Locker17.setBounds(195,360,70,70);
		Locker17.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker17);
	
		Locker18.setBackground(Color.orange);
		Locker18.setBounds(265,360,70,70);
		Locker18.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker18);
	
		Locker19.setBackground(Color.orange);
		Locker19.setBounds(335,360,70,70);
		Locker19.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker19);
	
		Locker20.setBackground(Color.orange);
		Locker20.setBounds(405,360,70,70);
		Locker20.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker20);
	
		Locker21.setBackground(Color.orange);
		Locker21.setBounds(475,360,70,70);
		Locker21.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker21);
		
		Locker22.setBackground(Color.orange);
		Locker22.setBounds(55,430,70,70);
		Locker22.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker22);

		Locker23.setBackground(Color.orange);
		Locker23.setBounds(125,430,70,70);
		Locker23.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker23);

		Locker24.setBackground(Color.orange);
		Locker24.setBounds(195,430,70,70);
		Locker24.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker24);
		
		Locker25.setBackground(Color.orange);
		Locker25.setBounds(265,430,70,70);
		Locker25.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker25);
		
		Locker26.setBackground(Color.orange);
		Locker26.setBounds(335,430,70,70);
		Locker26.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker26);
		
		Locker27.setBackground(Color.orange);
		Locker27.setBounds(405,430,70,70);
		Locker27.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker27);
		
		Locker28.setBackground(Color.orange);
		Locker28.setBounds(475,430,70,70);
		Locker28.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker28);
		
		Locker29.setBackground(Color.orange);
		Locker29.setBounds(55,500,70,70);
		Locker29.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker29);
		
		Locker30.setBackground(Color.orange);
		Locker30.setBounds(125,500,70,70);
		Locker30.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker30);
		
		Locker31.setBackground(Color.orange);
		Locker31.setBounds(195,500,70,70);
		Locker31.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker31);
		
		Locker32.setBackground(Color.orange);
		Locker32.setBounds(265,500,70,70);
		Locker32.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker32);
		
		Locker33.setBackground(Color.orange);
		Locker33.setBounds(335,500,70,70);
		Locker33.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker33);
		
		Locker34.setBackground(Color.orange);
		Locker34.setBounds(405,500,70,70);
		Locker34.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker34);
		
		Locker35.setBackground(Color.orange);
		Locker35.setBounds(475,500,70,70);
		Locker35.setFont(new Font("맑은고딕",Font.BOLD, 20));
		add(Locker35);
		
		
	}
}

