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
		new BuyFrame2();
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
	//
	JLabel com1 = new JLabel("이용 안내");
	JLabel com2 = new JLabel("1. 이용권 선택");
	JLabel com3 = new JLabel("2. 원하는 좌석 선택");
	JLabel com4 = new JLabel("3. 원하는 메뉴 선택");
	JLabel com5 = new JLabel("4. 결재(현금/카드)");
	JLabel com6 = new JLabel("5. 입실 버튼 누른 후");
	JLabel com7 = new JLabel("바코드 및 휴대폰 번호로 입장 가능");
	JLabel com8 = new JLabel("문의사항 : 010-1234-5678");
	JLabel com9 = new JLabel("*스터디룸 1회 이용시 시간권 구매 이용");
	JLabel com10 = new JLabel("장기이용시 문의바람");
	//
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
		setSize(600,650);
		setLayout(null);
		
		time.setFont(new Font("맑은고딕",Font.BOLD, 30));
		time.setBounds(160, 10, 400, 100);
		time.setForeground(Color.white); //글씨 색 현재는 흰색, 원하는대로 바꾸기
		
		add(time);
		
		Button1.setBackground(Color.PINK);
		Button1.setBounds(40,300,100,100);
		Button1.setFont(new Font("맑은고딕",Font.BOLD, 10));
		add(Button1);
		Button1.addActionListener(new EventHandler());
		
		Button2.setBackground(Color.PINK);
		Button2.setBounds(180,300,100,100);
		Button2.setFont(new Font("맑은고딕",Font.BOLD, 10));
		add(Button2);
		
		Button5.setBackground(Color.PINK);
		Button5.setBounds(320,300,100,100);
		Button5.setFont(new Font("맑은고딕",Font.BOLD, 10));
		add(Button5);
		
		Button6.setBackground(Color.PINK);
		Button6.setBounds(460,300,100,100);
		Button6.setFont(new Font("맑은고딕",Font.BOLD, 10));
		add(Button6);
		
		Button3.setBackground(Color.PINK);
		Button3.setBounds(320,450,100,100);
		Button3.setFont(new Font("맑은고딕",Font.BOLD, 15));
		add(Button3);
		
		Button4.setBackground(Color.PINK);
		Button4.setBounds(460,450,100,100);
		Button4.setFont(new Font("맑은고딕",Font.BOLD, 15));
		add(Button4);
		
		com1.setBounds(40,450,100,100);
		com1.setFont(new Font("맑은고딕",Font.BOLD, 15));
		com1.setForeground(Color.white);
		add(com1);
	}
	
	
	
	
	
	
}

class EventHandler implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		new SeatFrame();
	}
}

//좌석 선택 + 홈버튼 기능 추가
class SeatFrame extends JFrame{
	JButton home = new JButton("홈으로");
	JButton seat1 = new JButton("1");
	JButton seat2 = new JButton("2");
	JButton seat3 = new JButton("3");
	JButton seat4 = new JButton("4");
	JButton seat5 = new JButton("5");
	JButton seat6 = new JButton("6");
	JButton seat7 = new JButton("7");
	JButton seat8 = new JButton("8");
	JButton seat9 = new JButton("9");
	JButton seat10 = new JButton("10");
	JButton seat11 = new JButton("11");
	JButton seat12 = new JButton("12");
	JButton seat13 = new JButton("13");
	JButton seat14 = new JButton("14");
	JButton seat15 = new JButton("15");
	JButton seat16 = new JButton("16");
	JButton seat17 = new JButton("17");
	JButton seat18 = new JButton("18");
	JButton seat19 = new JButton("19");
	JButton seat20 = new JButton("20");
	JButton seat21 = new JButton("21");
	JButton seat22 = new JButton("22");
	JButton seat23 = new JButton("23");
	JButton seat24 = new JButton("24");
	JButton seat25 = new JButton("25");
	JButton seat26 = new JButton("26");
	JButton seat27 = new JButton("27");
	JButton seat28 = new JButton("28");
	JButton seat29 = new JButton("29");
	JButton seat30 = new JButton("30");
	JButton seat31 = new JButton("31");
	JButton seat32 = new JButton("32");
	JButton seat33 = new JButton("33");
	JButton seat34 = new JButton("34");
	JButton seat35 = new JButton("35");
	JButton seat36 = new JButton("36");
	JButton seat37 = new JButton("37");
	JButton seat38 = new JButton("38");
	JButton seat39 = new JButton("39");
	JButton seat40 = new JButton("40");
	JButton seat41 = new JButton("41");
	JButton seat42 = new JButton("42");
	JButton seat43 = new JButton("43");
	JButton seat44 = new JButton("44");
	JButton seat45 = new JButton("45");
	JButton seat46 = new JButton("46");
	JButton seat47 = new JButton("47");
	JButton seat48 = new JButton("48");
	JButton seat49 = new JButton("49");
	JButton seat50 = new JButton("50");
	
	public SeatFrame() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		setSize(600,650);
		setLayout(null);
		//
		home.setBackground(Color.GREEN);
		home.setBounds(10,10,70,30);
		add(home);
		//
		JLabel s1 = new JLabel("좌석예약");
		JLabel s2 = new JLabel("이용현황:");
		s1.setBounds(200,50,250,50);
		s2.setBounds(450,100,50,50);
		s1.setFont(new Font("맑은고딕",Font.BOLD, 50));
		s1.setForeground(Color.white);
		s2.setFont(new Font("맑은고딕",Font.BOLD, 10));
		s2.setForeground(Color.white);
		add(s1);
		add(s2);
		//
		seat1.setBackground(Color.orange);
		seat1.setBounds(50,150,50,50);
		add(seat1);
		seat2.setBackground(Color.orange);
		seat2.setBounds(100,150,50,50);
		add(seat2);
		seat3.setBackground(Color.orange);
		seat3.setBounds(150,150,50,50);
		add(seat3);
		seat4.setBackground(Color.orange);
		seat4.setBounds(200,150,50,50);
		add(seat4);
		seat5.setBackground(Color.orange);
		seat5.setBounds(250,150,50,50);
		add(seat5);
		seat6.setBackground(Color.orange);
		seat6.setBounds(300,150,50,50);
		add(seat6);
		seat7.setBackground(Color.orange);
		seat7.setBounds(350,150,50,50);
		add(seat7);
		seat8.setBackground(Color.orange);
		seat8.setBounds(400,150,50,50);
		add(seat8);
		seat9.setBackground(Color.orange);
		seat9.setBounds(450,150,50,50);
		add(seat9);
		seat10.setBackground(Color.orange);
		seat10.setBounds(500,150,50,50);
		add(seat10);
		//
		seat11.setBackground(Color.orange);
		seat11.setBounds(0,250,50,50);
		add(seat11);
		seat12.setBackground(Color.orange);
		seat12.setBounds(0,300,50,50);
		add(seat12);
		seat13.setBackground(Color.orange);
		seat13.setBounds(0,350,50,50);
		add(seat13);
		seat14.setBackground(Color.orange);
		seat14.setBounds(0,400,50,50);
		add(seat14);
		seat15.setBackground(Color.orange);
		seat15.setBounds(0,450,50,50);
		add(seat15);
		//
		seat16.setBackground(Color.orange);
		seat16.setBounds(100,250,50,50);
		add(seat16);
		seat17.setBackground(Color.orange);
		seat17.setBounds(100,300,50,50);
		add(seat17);
		seat18.setBackground(Color.orange);
		seat18.setBounds(100,350,50,50);
		add(seat18);
		seat19.setBackground(Color.orange);
		seat19.setBounds(100,400,50,50);
		add(seat19);
		seat20.setBackground(Color.orange);
		seat20.setBounds(100,450,50,50);
		add(seat20);
		//
		seat21.setBackground(Color.orange);
		seat21.setBounds(150,250,50,50);
		add(seat21);
		seat22.setBackground(Color.orange);
		seat22.setBounds(150,300,50,50);
		add(seat22);
		seat23.setBackground(Color.orange);
		seat23.setBounds(150,350,50,50);
		add(seat23);
		seat24.setBackground(Color.orange);
		seat24.setBounds(150,400,50,50);
		add(seat24);
		seat25.setBackground(Color.orange);
		seat25.setBounds(150,450,50,50);
		add(seat25);
		//
		seat26.setBackground(Color.orange);
		seat26.setBounds(250,250,50,50);
		add(seat26);
		seat27.setBackground(Color.orange);
		seat27.setBounds(250,300,50,50);
		add(seat27);
		seat28.setBackground(Color.orange);
		seat28.setBounds(250,350,50,50);
		add(seat28);
		seat29.setBackground(Color.orange);
		seat29.setBounds(250,400,50,50);
		add(seat29);
		seat30.setBackground(Color.orange);
		seat30.setBounds(250,450,50,50);
		add(seat30);
		//
		seat31.setBackground(Color.orange);
		seat31.setBounds(300,250,50,50);
		add(seat31);
		seat32.setBackground(Color.orange);
		seat32.setBounds(300,300,50,50);
		add(seat32);
		seat33.setBackground(Color.orange);
		seat33.setBounds(300,350,50,50);
		add(seat33);
		seat34.setBackground(Color.orange);
		seat34.setBounds(300,400,50,50);
		add(seat34);
		seat35.setBackground(Color.orange);
		seat35.setBounds(300,450,50,50);
		add(seat35);
		//
		seat36.setBackground(Color.orange);
		seat36.setBounds(400,250,50,50);
		add(seat36);
		seat37.setBackground(Color.orange);
		seat37.setBounds(400,300,50,50);
		add(seat37);
		seat38.setBackground(Color.orange);
		seat38.setBounds(400,350,50,50);
		add(seat38);
		seat39.setBackground(Color.orange);
		seat39.setBounds(400,400,50,50);
		add(seat39);
		seat40.setBackground(Color.orange);
		seat40.setBounds(400,450,50,50);
		add(seat40);
		//
		seat41.setBackground(Color.orange);
		seat41.setBounds(450,250,50,50);
		add(seat41);
		seat42.setBackground(Color.orange);
		seat42.setBounds(450,300,50,50);
		add(seat42);
		seat43.setBackground(Color.orange);
		seat43.setBounds(450,350,50,50);
		add(seat43);
		seat44.setBackground(Color.orange);
		seat44.setBounds(450,400,50,50);
		add(seat44);
		seat45.setBackground(Color.orange);
		seat45.setBounds(450,450,50,50);
		add(seat45);
		//
		seat46.setBackground(Color.orange);
		seat46.setBounds(550,250,50,50);
		add(seat46);
		seat47.setBackground(Color.orange);
		seat47.setBounds(550,300,50,50);
		add(seat47);
		seat48.setBackground(Color.orange);
		seat48.setBounds(550,350,50,50);
		add(seat48);
		seat49.setBackground(Color.orange);
		seat49.setBounds(550,400,50,50);
		add(seat49);
		seat50.setBackground(Color.orange);
		seat50.setBounds(550,450,50,50);
		add(seat50);
	}
}

//당일권 구매
class BuyFrame extends JFrame{
	
	//좌석선택
	
}

//시간/정기권 구매
class BuyFrame2 extends JFrame implements ActionListener{
	

	String b1 = "<html>" + "2주" + "<br>" + "70,000원" + "</html>";
	String b2 = "<html>" + "4주" + "<br>" + "110,000원" + "</html>";
	String b3 = "<html>" + "15시간" + "<br>" + "20,000원" + "</html>";
	String b4 = "<html>" + "30시간" + "<br>" + "38,000원" + "</html>";
	String b5 = "<html>" + "50시간" + "<br>" + "60,000원" + "</html>";
	String b6 = "<html>" + "100시간" + "<br>" + "110,000원" + "</html>";
	String b7 = "<html>" + "200시간" + "<br>" + "180,000원" + "</html>";
	
	JButton homeButton = new JButton("홈으로");
	JLabel info = new JLabel("정기권 구입");
	JLabel step1 = new JLabel("1단계 : 원하는 메뉴를 선택하세요");
	JLabel step2 = new JLabel("2단계 : 핸드폰 번호를 입력하세요");
	JButton Button1 = new JButton(b1);
	JButton Button2 = new JButton(b2);
	JButton Button3 = new JButton(b3);
	JButton Button4 = new JButton(b4);
	JButton Button5 = new JButton(b5);
	JButton Button6 = new JButton(b6);
	JButton Button7 = new JButton(b7);
	//JButton cashButton = new JButton("현금결제");
	//JButton cardButton = new JButton("카드결제");
	
	JTextField number = new JTextField() {  
		public void setBorder(Border boder) {   //현재는 textfield 테두리 투명하게
			
		}
	};
	JButton num0 = new JButton("0");
	JButton num1 = new JButton("1");
	JButton num2 = new JButton("2");
	JButton num3 = new JButton("3");
	JButton num4 = new JButton("4");
	JButton num5 = new JButton("5");
	JButton num6 = new JButton("6");
	JButton num7 = new JButton("7");
	JButton num8 = new JButton("8");
	JButton num9 = new JButton("9");
	JButton Pay = new JButton("결제");
	
	
	JButton Del = new JButton("<-");
		
		
	
	public BuyFrame2() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		setSize(600,650);
		setLayout(null);
		
		info.setFont(new Font("맑은고딕",Font.BOLD, 20));
		info.setBounds(220,20, 200,30);
		info.setForeground(Color.white); 
		add(info);
		step1.setFont(new Font("맑은고딕",Font.BOLD, 15));
		step1.setBounds(150,70, 300,20);
		step1.setForeground(Color.white); 
		add(step1);
			
		Button1.setBackground(Color.orange); //버튼 색깔 현재는 오렌지
		Button1.setBounds(60,110,120,70);
		Button1.setFont(new Font("맑은고딕",Font.BOLD, 12));
		add(Button1);
		
		Button2.setBackground(Color.orange); 
		Button2.setBounds(180,110,120,70);
		Button2.setFont(new Font("맑은고딕",Font.BOLD, 12));
		add(Button2);
		
		Button3.setBackground(Color.orange); 
		Button3.setBounds(300,110,120,70);
		Button3.setFont(new Font("맑은고딕",Font.BOLD, 12));
		add(Button3);
		
		Button4.setBackground(Color.orange); 
		Button4.setBounds(420,110,120,70);
		Button4.setFont(new Font("맑은고딕",Font.BOLD, 12));
		add(Button4);
		
		Button5.setBackground(Color.orange); 
		Button5.setBounds(60,180,120,70);
		Button5.setFont(new Font("맑은고딕",Font.BOLD, 12));
		add(Button5);
		
		Button6.setBackground(Color.orange); 
		Button6.setBounds(180,180,120,70);
		Button6.setFont(new Font("맑은고딕",Font.BOLD, 12));
		add(Button6);
		
		Button7.setBackground(Color.orange); 
		Button7.setBounds(300,180,120,70);
		Button7.setFont(new Font("맑은고딕",Font.BOLD, 12));
		add(Button7);
		
		step2.setFont(new Font("맑은고딕",Font.BOLD, 15));
		step2.setBounds(150,280, 300,20);
		step2.setForeground(Color.white); 
		add(step2);
		
		number.setBackground(Color.white);      //현재는 번호 입력칸 배경 흰색
		number.setBounds(60,420,200,60);
		number.setFont(new Font("맑은고딕",Font.BOLD, 13));
		add(number);
		
		num0.setFont(new Font("맑은고딕",Font.BOLD, 30));
		num1.setFont(new Font("맑은고딕",Font.BOLD, 30));
		num2.setFont(new Font("맑은고딕",Font.BOLD, 30));
		num3.setFont(new Font("맑은고딕",Font.BOLD, 30));
		num4.setFont(new Font("맑은고딕",Font.BOLD, 30));
		num5.setFont(new Font("맑은고딕",Font.BOLD, 30));
		num6.setFont(new Font("맑은고딕",Font.BOLD, 30));
		num7.setFont(new Font("맑은고딕",Font.BOLD, 30));
		num8.setFont(new Font("맑은고딕",Font.BOLD, 30));
		num9.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Pay.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Del.setFont(new Font("맑은고딕",Font.BOLD, 30));
		
		num1.setBackground(Color.orange);
		num1.setBounds(360,360,60,60);
		num1.setFont(new Font("맑은고딕",Font.BOLD, 12));
		add(num1);
		num2.setBackground(Color.orange);
		num2.setBounds(420,360,60,60);
		num2.setFont(new Font("맑은고딕",Font.BOLD, 12));
		add(num2);
		num3.setBackground(Color.orange);
		num3.setBounds(480,360,60,60);
		num3.setFont(new Font("맑은고딕",Font.BOLD, 12));
		add(num3);
		num4.setBackground(Color.orange);
		num4.setBounds(360,420,60,60);
		num4.setFont(new Font("맑은고딕",Font.BOLD, 12));
		add(num4);
		num5.setBackground(Color.orange);
		num5.setBounds(420,420,60,60);
		num5.setFont(new Font("맑은고딕",Font.BOLD, 12));
		add(num5);
		num6.setBackground(Color.orange);
		num6.setBounds(480,420,60,60);
		num6.setFont(new Font("맑은고딕",Font.BOLD, 12));
		add(num6);
		num7.setBackground(Color.orange);
		num7.setBounds(360,480,60,60);
		num7.setFont(new Font("맑은고딕",Font.BOLD, 12));
		add(num7);
		num8.setBackground(Color.orange);
		num8.setBounds(420,480,60,60);
		num8.setFont(new Font("맑은고딕",Font.BOLD, 12));
		add(num8);
		num9.setBackground(Color.orange);
		num9.setBounds(480,480,60,60);
		num9.setFont(new Font("맑은고딕",Font.BOLD, 12));
		add(num9);
		num0.setBackground(Color.orange);
		num0.setBounds(360,540,60,60);
		num0.setFont(new Font("맑은고딕",Font.BOLD, 12));
		add(num0);
		Del.setBackground(Color.orange);
		Del.setBounds(420,540,60,60);
		Del.setFont(new Font("맑은고딕",Font.BOLD, 12));
		add(Del);
		Pay.setBackground(Color.orange);
		Pay.setBounds(480,540,60,60);
		Pay.setFont(new Font("맑은고딕",Font.BOLD, 12));
		add(Pay);
		
		
		num0.addActionListener(this);
		num1.addActionListener(this);
		num2.addActionListener(this);
		num3.addActionListener(this);
		num4.addActionListener(this);
		num5.addActionListener(this);
		num6.addActionListener(this);
		num7.addActionListener(this);
		num8.addActionListener(this);
		num9.addActionListener(this);
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
