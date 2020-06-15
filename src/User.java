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
	
	
	
	
	public static void main(String[] args) {
		new FirstFrame();
		//new InsertNumber(5);
		//new LockerFrame();
		//new BuyFrame();
	}
	
}

class UserData{
	public static datauser[] Data = new datauser[200];
	public static int num= 0;
}

class seatstatus{
	public static boolean[] seats = new boolean[51];
	public static int seatnum = 0;
	public static datauser[] seatData = new datauser[51];
	public static datauser soon;
}

class datauser{
	
	String number = "";
	String starttime = "";
	String finishtime ="";
	boolean nowseat = false;
	int seatnumber;
}

class lockerstatus{
	public static boolean[] lockers = new boolean[36];
	public static int lockernum = 0;
	public static lockerUser[] lockerData = new lockerUser[36];
	public static lockerUser soon;
}

class lockerUser{
	
	String number = "";
	String startdate;
	String finishdate;
	boolean usinglocker=false;
	int lockernumber;
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
	JLabel com1 = new JLabel("<이용 안내>");
	JLabel com2 = new JLabel("1. 이용권 선택");
	JLabel com3 = new JLabel("2. 원하는 좌석과 메뉴 선택");
	//JLabel com4 = new JLabel("3. 원하는 메뉴 선택");
	JLabel com5 = new JLabel("4. 결재(현금/카드)");
	JLabel com6 = new JLabel("5. 입실 버튼 누른 후");
	JLabel com7 = new JLabel("바코드 및 휴대폰 번호로 입장 가능");
	JLabel com8 = new JLabel("문의사항 : 010-1234-5678");
	JLabel com9 = new JLabel("*스터디룸 1회 이용시 시간권 구매 이용");
	JLabel com10 = new JLabel("*장기이용시 정기권 구매 이용");
	//
	JLabel logo1 = new JLabel("____________________");
	JLabel logo2 = new JLabel("成均館");
	JLabel logo3 = new JLabel("스터디카페");
	JLabel logo4 = new JLabel("Sungkyunkwan StudyCafe");
	JLabel logo5 = new JLabel("_______________________________");
	//
	JButton Button1 = new JButton("당일권 구매");
	JButton Button2 = new JButton(b2);
	JButton Button3 = new JButton("입실");
	JButton Button4 = new JButton("퇴실");
	JButton Button5 = new JButton(b5);
	JButton Button6 = new JButton("사물함 대여");
	JButton Manager = new JButton("관리자");
	//JButton Button7 = new JButton("스터디룸 예약");
	//JButton Button8 = new JButton("좌석이동");
	//
	/*static JPanel logo = new JPanel()
	{
		Image background = new ImageIcon(Main.class.getResource("JAVALOGO.png")).getImage();
		public void paint(Graphics g)
		{
			g.drawImage(background, 0, 0, null);
		}
	};
	JPanel logo = new JPanel();*/ // 이미지 로고 넣는거 시도 중
	
	public FirstFrame() {
		getContentPane().setBackground(Color.DARK_GRAY); //배경색 바꾸기
		setSize(600,650);
		setLayout(null);
		
		time.setFont(new Font("HY견고딕",Font.BOLD, 25));
		time.setBounds(160, 10, 400, 100);
		time.setForeground(Color.white); //글씨 색 현재는 흰색, 원하는대로 바꾸기
		
		add(time);
		
		Button1.setBackground(Color.PINK);
		Button1.setBounds(40,300,100,100);
		Button1.setFont(new Font("HY견고딕",Font.PLAIN, 12));
		add(Button1);
		Button1.addActionListener(new EventSeat());
		
		Button2.setBackground(Color.PINK);
		Button2.setBounds(180,300,100,100);
		Button2.setFont(new Font("HY견고딕",Font.PLAIN, 12));
		Button2.addActionListener(new EventRegularBuy());
		add(Button2);
		
		Button5.setBackground(Color.PINK);
		Button5.setBounds(320,300,100,100);
		Button5.setFont(new Font("HY견고딕",Font.PLAIN, 12));
		Button5.addActionListener(new EventChooseSeat());
		add(Button5);
		
		Button6.setBackground(Color.PINK);
		Button6.setBounds(460,300,100,100);
		Button6.setFont(new Font("HY견고딕",Font.PLAIN, 12));
		Button6.addActionListener(new EventLocker());
		add(Button6);
		
		Button3.setBackground(Color.PINK);
		Button3.setBounds(320,450,100,100);
		Button3.setFont(new Font("HY견고딕",Font.PLAIN, 12));
		Button3.addActionListener(new EventIn());
		add(Button3);
		
		Button4.setBackground(Color.PINK);
		Button4.setBounds(460,450,100,100);
		Button4.setFont(new Font("HY견고딕",Font.PLAIN, 12));
		Button4.addActionListener(new EventOut());
		add(Button4);
		//
		com1.setBounds(60,440,200,20);
		com1.setFont(new Font("HY견고딕",Font.PLAIN, 15));
		com1.setForeground(Color.white);
		add(com1);
		
		com2.setBounds(60,465,200,10);
		com2.setFont(new Font("HY견고딕",Font.PLAIN, 12));
		com2.setForeground(Color.white);
		add(com2);
		
		com3.setBounds(60,480,200,10);
		com3.setFont(new Font("HY견고딕",Font.PLAIN, 12));
		com3.setForeground(Color.white);
		add(com3);
		
		com5.setBounds(60,495,200,10);
		com5.setFont(new Font("HY견고딕",Font.PLAIN, 12));
		com5.setForeground(Color.white);
		add(com5);
		
		com6.setBounds(60,510,200,10);
		com6.setFont(new Font("HY견고딕",Font.PLAIN, 12));
		com6.setForeground(Color.white);
		add(com6);
		
		com7.setBounds(60,525,200,10);
		com7.setFont(new Font("HY견고딕",Font.PLAIN, 12));
		com7.setForeground(Color.white);
		add(com7);
		
		com8.setBounds(60,540,200,10);
		com8.setFont(new Font("HY견고딕",Font.PLAIN, 12));
		com8.setForeground(Color.white);
		add(com8);
		
		com9.setBounds(60,555,250,10);
		com9.setFont(new Font("HY견고딕",Font.PLAIN, 12));
		com9.setForeground(Color.red);
		add(com9);
		
		com10.setBounds(60,570,200,10);
		com10.setFont(new Font("HY견고딕",Font.PLAIN, 12));
		com10.setForeground(Color.red);
		add(com10);
		
		logo1.setBounds(215,105,400,20);
		logo1.setFont(new Font("HY견고딕",Font.PLAIN, 15));
		logo1.setForeground(Color.orange);
		add(logo1);
		
		logo2.setBounds(210,130,200,50);
		logo2.setFont(new Font("HY견고딕",Font.PLAIN, 50));
		logo2.setForeground(Color.orange);
		add(logo2);
		
		logo3.setBounds(190,180,200,40);
		logo3.setFont(new Font("HY견고딕",Font.PLAIN, 40));
		logo3.setForeground(Color.orange);
		add(logo3);
		
		logo4.setBounds(180,220,300,24);
		logo4.setFont(new Font("맑은 고딕",Font.ITALIC, 18));
		logo4.setForeground(Color.orange);
		add(logo4);
		
		logo5.setBounds(175,240,500,20);
		logo5.setFont(new Font("HY견고딕",Font.PLAIN, 15));
		logo5.setForeground(Color.orange);
		add(logo5);
		
		Manager.setBounds(456, 50, 100, 30);
		Manager.setFont(new Font("HY견고딕",Font.PLAIN, 15));
		Manager.addActionListener(new EventManage());
		Manager.setBackground(Color.LIGHT_GRAY);
		add(Manager);
		/*com10.setBounds(60,585,200,10);
		com10.setFont(new Font("HY견고딕",Font.PLAIN, 12));
		com10.setForeground(Color.red);
		add(com10);
		//
		/*logo.setLayout(null);
		logo.setBounds(140,150,100,100);
		add(logo);
		
		ImageIcon icon = new ImageIcon("JAVALOGO.PNG");
		JLabel label = new JLabel(icon);
		getContentPane().add(label);
		
		logo.add(label);
		logo.setLayout(null);
		logo.setBounds(140,150,300,100);
		add(logo);*/ // 이미지 로고 넣는거 시도 중
		
		setVisible(true);
	}
	
	
	
	
	
	
}


class EventSeat implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		new SeatFrame(0);
	}
}

class EventRegularBuy implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		new BuyFrame2();
	}
}

class EventLocker implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		new LockerFrame();
	}
}

class EventChooseSeat implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		new ChooseSeat();
	}
}

class EventIn implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		new InFrame();
	}
}

class EventOut implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		new OutFrame();
	}
}

class EventManage implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		new ManageFrame();
	}
}

//좌석 선택 + 홈버튼 기능 추가
class SeatFrame extends JFrame implements ActionListener{
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
	
	
	int typee;
	public SeatFrame(int type) {
		//당일권 구매 -> type: 0
		//정기권 이용자 자리 선택 -> type: 1
		typee = type;
		int seatnumber;
		
		if(type == 0) {
			
			getContentPane().setBackground(Color.DARK_GRAY);
			setVisible(true);
			setSize(600,650);
			setLayout(null);
			//
			home.setBackground(Color.PINK);
			home.setBounds(10,10,70,30);
			home.addActionListener(this);
			home.setFont(new Font("HY견고딕",Font.PLAIN, 12));
			add(home);
			//
			JLabel s1 = new JLabel("좌석예약");
			JLabel s2 = new JLabel("[이용현황: "+ Integer.toString(seatstatus.seatnum)+  "/50]");
			JLabel s3 = new JLabel("원하는 좌석을 선택하세요.");
			JLabel s4 = new JLabel("________________________________________________________");
			JLabel s5 = new JLabel("이용 중 좌석");
			JLabel s6 = new JLabel("사용 가능 좌석");
			
			
			JButton yb = new JButton();
			JButton rb = new JButton();
			JButton door = new JButton("출입구");
			door.setFont(new Font("HY견고딕",Font.PLAIN, 15));
			
			
			s1.setBounds(205,30,250,50);
			s2.setBounds(430,100,150,50);
			s3.setBounds(185,90,350,30);
			s4.setBounds(200,70,250,10);
			s5.setBounds(450,80,150,20);
			s6.setBounds(450,60,150,20);
			
			yb.setBounds(430,65,10,10);
			rb.setBounds(430,85,10,10);
			yb.setBackground(Color.orange);
			rb.setBackground(Color.red);
			door.setBounds(100,570,150,50);
			door.setBackground(Color.gray);
			
			s1.setFont(new Font("HY견고딕",Font.PLAIN, 35));
			s1.setForeground(Color.white);
			s2.setFont(new Font("HY견고딕",Font.PLAIN, 15));
			s2.setForeground(Color.white);
			s3.setFont(new Font("HY견고딕",Font.PLAIN, 15));
			s3.setForeground(Color.white);
			s4.setFont(new Font("HY견고딕",Font.BOLD, 5));
			s4.setForeground(Color.white);
			s5.setFont(new Font("HY견고딕",Font.PLAIN, 10));
			s5.setForeground(Color.white);
			s6.setFont(new Font("HY견고딕",Font.PLAIN, 10));
			s6.setForeground(Color.white);
			
			
			add(s1);
			add(s2);
			add(s3);
			add(s4);
			add(s5);
			add(s6);
			add(yb);
			add(rb);
			add(door);
			//
			seat1.setBackground(Color.orange);
			seat1.setBounds(50,150,50,50);
			if(seatstatus.seats[1]) {
				seat1.setBackground(Color.RED);
			}
			seat1.addActionListener(new EventHandler());
			add(seat1);
		
			seat2.setBackground(Color.orange);
			seat2.setBounds(100,150,50,50);
			if(seatstatus.seats[2]) {
				seat2.setBackground(Color.RED);
			}
			seat2.addActionListener(new EventHandler());
			add(seat2);
			
			seat3.setBackground(Color.orange);
			seat3.setBounds(150,150,50,50);
			if(seatstatus.seats[3]) {
				seat3.setBackground(Color.RED);
			}
			seat3.addActionListener(new EventHandler());
			add(seat3);
			
			seat4.setBackground(Color.orange);
			seat4.setBounds(200,150,50,50);
			if(seatstatus.seats[4]) {
				seat4.setBackground(Color.RED);
			}
			seat4.addActionListener(new EventHandler());
			add(seat4);
			
			seat5.setBackground(Color.orange);
			seat5.setBounds(250,150,50,50);
			if(seatstatus.seats[5]) {
				seat5.setBackground(Color.RED);
			}
			seat5.addActionListener(new EventHandler());
			add(seat5);
			
			seat6.setBackground(Color.orange);
			seat6.setBounds(300,150,50,50);
			if(seatstatus.seats[6]) {
				seat6.setBackground(Color.RED);
			}
			seat6.addActionListener(new EventHandler());
			add(seat6);
			
			seat7.setBackground(Color.orange);
			seat7.setBounds(350,150,50,50);
			if(seatstatus.seats[7]) {
				seat7.setBackground(Color.RED);
			}
			seat7.addActionListener(new EventHandler());
			add(seat7);
			
			seat8.setBackground(Color.orange);
			seat8.setBounds(400,150,50,50);
			if(seatstatus.seats[8]) {
				seat8.setBackground(Color.RED);
			}
			seat8.addActionListener(new EventHandler());
			add(seat8);
			
			seat9.setBackground(Color.orange);
			seat9.setBounds(450,150,50,50);
			if(seatstatus.seats[9]) {
				seat9.setBackground(Color.RED);
			}
			seat9.addActionListener(new EventHandler());
			add(seat9);
			
			seat10.setBackground(Color.orange);
			seat10.setBounds(500,150,50,50);
			if(seatstatus.seats[10]) {
				seat10.setBackground(Color.RED);
			}
			seat10.addActionListener(new EventHandler());
			add(seat10);
			
			seat11.setBackground(Color.orange);
			seat11.setBounds(0,250,50,50);
			if(seatstatus.seats[11]) {
				seat11.setBackground(Color.RED);
			}
			seat11.addActionListener(new EventHandler());
			add(seat11);
			
			seat12.setBackground(Color.orange);
			seat12.setBounds(0,300,50,50);
			if(seatstatus.seats[12]) {
				seat12.setBackground(Color.RED);
			}
			seat12.addActionListener(new EventHandler());
			add(seat12);
			
			seat13.setBackground(Color.orange);
			seat13.setBounds(0,350,50,50);
			if(seatstatus.seats[13]) {
				seat13.setBackground(Color.RED);
			}
			seat13.addActionListener(new EventHandler());
			add(seat13);
			
			seat14.setBackground(Color.orange);
			seat14.setBounds(0,400,50,50);
			if(seatstatus.seats[14]) {
				seat14.setBackground(Color.RED);
			}
			seat14.addActionListener(new EventHandler());
			add(seat14);
			
			seat15.setBackground(Color.orange);
			seat15.setBounds(0,450,50,50);
			if(seatstatus.seats[15]) {
				seat15.setBackground(Color.RED);
			}
			seat15.addActionListener(new EventHandler());
			add(seat15);
			
			seat16.setBackground(Color.orange);
			seat16.setBounds(100,250,50,50);
			if(seatstatus.seats[16]) {
				seat16.setBackground(Color.RED);
			}
			seat16.addActionListener(new EventHandler());
			add(seat16);
			
			seat17.setBackground(Color.orange);
			seat17.setBounds(100, 300, 50, 50);
			if(seatstatus.seats[17]) {
				seat17.setBackground(Color.RED);
			}
			seat17.addActionListener(new EventHandler());
			add(seat17);
			
			seat18.setBackground(Color.orange);
			seat18.setBounds(100, 350, 50, 50);
			if(seatstatus.seats[18]) {
				seat18.setBackground(Color.RED);
			}
			seat18.addActionListener(new EventHandler());
			add(seat18);
			
			seat19.setBackground(Color.orange);
			seat19.setBounds(100, 400, 50, 50);
			if(seatstatus.seats[19]) {
				seat19.setBackground(Color.RED);
			}
			seat19.addActionListener(new EventHandler());
			add(seat19);
			
			seat20.setBackground(Color.orange);
			seat20.setBounds(100, 450, 50, 50);
			if(seatstatus.seats[20]) {
				seat20.setBackground(Color.RED);
			}
			seat20.addActionListener(new EventHandler());
			add(seat20);
			
			seat21.setBackground(Color.orange);
			seat21.setBounds(150, 250, 50, 50);
			if(seatstatus.seats[21]) {
				seat21.setBackground(Color.RED);
			}
			seat21.addActionListener(new EventHandler());
			add(seat21);
			
			seat22.setBackground(Color.orange);
			seat22.setBounds(150, 300, 50, 50);
			if(seatstatus.seats[22]) {
				seat22.setBackground(Color.RED);
			}
			seat22.addActionListener(new EventHandler());
			add(seat22);
			
			seat23.setBackground(Color.orange);
			seat23.setBounds(150, 350, 50, 50);
			if(seatstatus.seats[23]) {
				seat23.setBackground(Color.RED);
			}
			seat23.addActionListener(new EventHandler());
			add(seat23);
			
			seat24.setBackground(Color.orange);
			seat24.setBounds(150, 400, 50, 50);
			if(seatstatus.seats[24]) {
				seat24.setBackground(Color.RED);
			}
			seat24.addActionListener(new EventHandler());
			add(seat24);
			
			seat25.setBackground(Color.orange);
			seat25.setBounds(150, 450, 50, 50);
			if(seatstatus.seats[25]) {
				seat25.setBackground(Color.RED);
			}
			seat25.addActionListener(new EventHandler());
			add(seat25);
			
			seat26.setBackground(Color.orange);
			seat26.setBounds(250, 250, 50, 50);
			if(seatstatus.seats[26]) {
				seat26.setBackground(Color.RED);
			}
			seat26.addActionListener(new EventHandler());
			add(seat26);
			
			seat27.setBackground(Color.orange);
			seat27.setBounds(250, 300, 50, 50);
			if(seatstatus.seats[27]) {
				seat27.setBackground(Color.RED);
			}
			seat27.addActionListener(new EventHandler());
			add(seat27);
			
			seat28.setBackground(Color.orange);
			seat28.setBounds(250, 350, 50, 50);
			if(seatstatus.seats[28]) {
				seat28.setBackground(Color.RED);
			}
			seat28.addActionListener(new EventHandler());
			add(seat28);
			
			//여기서부터
			seat29.setBackground(Color.orange);
			seat29.setBounds(250, 400, 50, 50);
			if(seatstatus.seats[29]) {
				seat29.setBackground(Color.RED);
			}
			seat29.addActionListener(new EventHandler());
			add(seat29);
			
			seat30.setBackground(Color.orange);
			seat30.setBounds(250, 450, 50, 50);
			if(seatstatus.seats[30]) {
				seat30.setBackground(Color.RED);
			}
			seat30.addActionListener(new EventHandler());
			add(seat30);
			
			seat31.setBackground(Color.orange);
			seat31.setBounds(300, 250, 50, 50);
			if(seatstatus.seats[31]) {
				seat31.setBackground(Color.RED);
			}
			seat31.addActionListener(new EventHandler());
			add(seat31);
			
			seat32.setBackground(Color.orange);
			seat32.setBounds(300, 300, 50, 50);
			if(seatstatus.seats[32]) {
				seat32.setBackground(Color.RED);
			}
			seat32.addActionListener(new EventHandler());
			add(seat32);
			
			seat33.setBackground(Color.orange);
			seat33.setBounds(300, 350, 50, 50);
			if(seatstatus.seats[33]) {
				seat33.setBackground(Color.RED);
			}
			seat33.addActionListener(new EventHandler());
			add(seat33);
			
			seat34.setBackground(Color.orange);
			seat34.setBounds(300, 400, 50, 50);
			if(seatstatus.seats[34]) {
				seat34.setBackground(Color.RED);
			}
			seat34.addActionListener(new EventHandler());
			add(seat34);
			
			seat35.setBackground(Color.orange);
			seat35.setBounds(300, 450, 50, 50);
			if(seatstatus.seats[35]) {
				seat35.setBackground(Color.RED);
			}
			seat35.addActionListener(new EventHandler());
			add(seat35);
			
			seat36.setBackground(Color.orange);
			seat36.setBounds(400, 250, 50, 50);
			if(seatstatus.seats[36]) {
				seat36.setBackground(Color.RED);
			}
			seat36.addActionListener(new EventHandler());
			add(seat36);
			
			seat37.setBackground(Color.orange);
			seat37.setBounds(400, 300, 50, 50);
			if(seatstatus.seats[37]) {
				seat37.setBackground(Color.RED);
			}
			seat37.addActionListener(new EventHandler());
			add(seat37);
			
			seat38.setBackground(Color.orange);
			seat38.setBounds(400, 350, 50, 50);
			if(seatstatus.seats[38]) {
				seat38.setBackground(Color.RED);
			}
			seat38.addActionListener(new EventHandler());
			add(seat38);
			
			seat39.setBackground(Color.orange);
			seat39.setBounds(400, 400, 50, 50);
			if(seatstatus.seats[39]) {
				seat39.setBackground(Color.RED);
			}
			seat39.addActionListener(new EventHandler());
			add(seat39);
			
			seat40.setBackground(Color.orange);
			seat40.setBounds(400, 450, 50, 50);
			if(seatstatus.seats[40]) {
				seat40.setBackground(Color.RED);
			}
			seat40.addActionListener(new EventHandler());
			add(seat40);
			
			seat41.setBackground(Color.orange);
			seat41.setBounds(450, 250, 50, 50);
			if(seatstatus.seats[41]) {
				seat41.setBackground(Color.RED);
			}
			seat41.addActionListener(new EventHandler());
			add(seat41);
			
			seat42.setBackground(Color.orange);
			seat42.setBounds(450, 300, 50, 50);
			if(seatstatus.seats[42]) {
				seat42.setBackground(Color.RED);
			}
			seat42.addActionListener(new EventHandler());
			add(seat42);
			
			seat43.setBackground(Color.orange);
			seat43.setBounds(450, 350, 50, 50);
			if(seatstatus.seats[43]) {
				seat43.setBackground(Color.RED);
			}
			seat43.addActionListener(new EventHandler());
			add(seat43);
			
			seat44.setBackground(Color.orange);
			seat44.setBounds(450, 400, 50, 50);
			if(seatstatus.seats[44]) {
				seat44.setBackground(Color.RED);
			}
			seat44.addActionListener(new EventHandler());
			add(seat44);
			
			seat45.setBackground(Color.orange);
			seat45.setBounds(450, 450, 50, 50);
			if(seatstatus.seats[45]) {
				seat45.setBackground(Color.RED);
			}
			seat45.addActionListener(new EventHandler());
			add(seat45);
			
			seat46.setBackground(Color.orange);
			seat46.setBounds(550, 250, 50, 50);
			if(seatstatus.seats[46]) {
				seat46.setBackground(Color.RED);
			}
			seat46.addActionListener(new EventHandler());
			add(seat46);
			
			seat47.setBackground(Color.orange);
			seat47.setBounds(550, 300, 50, 50);
			if(seatstatus.seats[47]) {
				seat47.setBackground(Color.RED);
			}
			seat47.addActionListener(new EventHandler());
			add(seat47);
			
			seat48.setBackground(Color.orange);
			seat48.setBounds(550, 350, 50, 50);
			if(seatstatus.seats[48]) {
				seat48.setBackground(Color.RED);
			}
			seat48.addActionListener(new EventHandler());
			add(seat48);
			
			seat49.setBackground(Color.orange);
			seat49.setBounds(550, 400, 50, 50);
			if(seatstatus.seats[49]) {
				seat49.setBackground(Color.RED);
			}
			seat49.addActionListener(new EventHandler());
			add(seat49);
			
			seat50.setBackground(Color.orange);
			seat50.setBounds(550, 450, 50, 50);
			if(seatstatus.seats[50]) {
				seat50.setBackground(Color.RED);
			}
			seat50.addActionListener(new EventHandler());
			add(seat50);
			
			
		}
		else if(type == 1) {
			
			getContentPane().setBackground(Color.DARK_GRAY);
			setVisible(true);
			setSize(600,650);
			setLayout(null);
			//
			home.setBackground(Color.PINK);
			home.setBounds(10,10,70,30);
			home.addActionListener(this);
			home.setFont(new Font("HY견고딕",Font.PLAIN, 12));
			add(home);
			//
			JLabel s1 = new JLabel("좌석예약");
			JLabel s2 = new JLabel("[이용현황: "+ Integer.toString(seatstatus.seatnum)+  "/50]");
			JLabel s3 = new JLabel("원하는 좌석을 선택하세요.");
			JLabel s4 = new JLabel("________________________________________________________");
			JLabel s5 = new JLabel("이용 중 좌석");
			JLabel s6 = new JLabel("사용 가능 좌석");
			
			
			JButton yb = new JButton();
			JButton rb = new JButton();
			JButton door = new JButton("출입구");
			door.setFont(new Font("HY견고딕",Font.PLAIN, 15));
			
			
			s1.setBounds(205,30,250,50);
			s2.setBounds(430,100,150,50);
			s3.setBounds(185,90,350,30);
			s4.setBounds(200,70,250,10);
			s5.setBounds(450,80,150,20);
			s6.setBounds(450,60,150,20);
			
			yb.setBounds(430,65,10,10);
			rb.setBounds(430,85,10,10);
			yb.setBackground(Color.orange);
			rb.setBackground(Color.red);
			door.setBounds(100,570,150,50);
			door.setBackground(Color.gray);
			
			s1.setFont(new Font("HY견고딕",Font.PLAIN, 35));
			s1.setForeground(Color.white);
			s2.setFont(new Font("HY견고딕",Font.PLAIN, 15));
			s2.setForeground(Color.white);
			s3.setFont(new Font("HY견고딕",Font.PLAIN, 15));
			s3.setForeground(Color.white);
			s4.setFont(new Font("HY견고딕",Font.BOLD, 5));
			s4.setForeground(Color.white);
			s5.setFont(new Font("HY견고딕",Font.PLAIN, 10));
			s5.setForeground(Color.white);
			s6.setFont(new Font("HY견고딕",Font.PLAIN, 10));
			s6.setForeground(Color.white);
			
			
			add(s1);
			add(s2);
			add(s3);
			add(s4);
			add(s5);
			add(s6);
			add(yb);
			add(rb);
			add(door);
			//
			seat1.setBackground(Color.orange);
			seat1.setBounds(50,150,50,50);
			if(seatstatus.seats[1]) {
				seat1.setBackground(Color.RED);
			}
			seat1.addActionListener(new EventHandler());
			add(seat1);
		
			seat2.setBackground(Color.orange);
			seat2.setBounds(100,150,50,50);
			if(seatstatus.seats[2]) {
				seat2.setBackground(Color.RED);
			}
			seat2.addActionListener(new EventHandler());
			add(seat2);
			
			seat3.setBackground(Color.orange);
			seat3.setBounds(150,150,50,50);
			if(seatstatus.seats[3]) {
				seat3.setBackground(Color.RED);
			}
			seat3.addActionListener(new EventHandler());
			add(seat3);
			
			seat4.setBackground(Color.orange);
			seat4.setBounds(200,150,50,50);
			if(seatstatus.seats[4]) {
				seat4.setBackground(Color.RED);
			}
			seat4.addActionListener(new EventHandler());
			add(seat4);
			
			seat5.setBackground(Color.orange);
			seat5.setBounds(250,150,50,50);
			if(seatstatus.seats[5]) {
				seat5.setBackground(Color.RED);
			}
			seat5.addActionListener(new EventHandler());
			add(seat5);
			
			seat6.setBackground(Color.orange);
			seat6.setBounds(300,150,50,50);
			if(seatstatus.seats[6]) {
				seat6.setBackground(Color.RED);
			}
			seat6.addActionListener(new EventHandler());
			add(seat6);
			
			seat7.setBackground(Color.orange);
			seat7.setBounds(350,150,50,50);
			if(seatstatus.seats[7]) {
				seat7.setBackground(Color.RED);
			}
			seat7.addActionListener(new EventHandler());
			add(seat7);
			
			seat8.setBackground(Color.orange);
			seat8.setBounds(400,150,50,50);
			if(seatstatus.seats[8]) {
				seat8.setBackground(Color.RED);
			}
			seat8.addActionListener(new EventHandler());
			add(seat8);
			
			seat9.setBackground(Color.orange);
			seat9.setBounds(450,150,50,50);
			if(seatstatus.seats[9]) {
				seat9.setBackground(Color.RED);
			}
			seat9.addActionListener(new EventHandler());
			add(seat9);
			
			seat10.setBackground(Color.orange);
			seat10.setBounds(500,150,50,50);
			if(seatstatus.seats[10]) {
				seat10.setBackground(Color.RED);
			}
			seat10.addActionListener(new EventHandler());
			add(seat10);
			
			seat11.setBackground(Color.orange);
			seat11.setBounds(0,250,50,50);
			if(seatstatus.seats[11]) {
				seat11.setBackground(Color.RED);
			}
			seat11.addActionListener(new EventHandler());
			add(seat11);
			
			seat12.setBackground(Color.orange);
			seat12.setBounds(0,300,50,50);
			if(seatstatus.seats[12]) {
				seat12.setBackground(Color.RED);
			}
			seat12.addActionListener(new EventHandler());
			add(seat12);
			
			seat13.setBackground(Color.orange);
			seat13.setBounds(0,350,50,50);
			if(seatstatus.seats[13]) {
				seat13.setBackground(Color.RED);
			}
			seat13.addActionListener(new EventHandler());
			add(seat13);
			
			seat14.setBackground(Color.orange);
			seat14.setBounds(0,400,50,50);
			if(seatstatus.seats[14]) {
				seat14.setBackground(Color.RED);
			}
			seat14.addActionListener(new EventHandler());
			add(seat14);
			
			seat15.setBackground(Color.orange);
			seat15.setBounds(0,450,50,50);
			if(seatstatus.seats[15]) {
				seat15.setBackground(Color.RED);
			}
			seat15.addActionListener(new EventHandler());
			add(seat15);
			
			seat16.setBackground(Color.orange);
			seat16.setBounds(100,250,50,50);
			if(seatstatus.seats[16]) {
				seat16.setBackground(Color.RED);
			}
			seat16.addActionListener(new EventHandler());
			add(seat16);
			
			seat17.setBackground(Color.orange);
			seat17.setBounds(100, 300, 50, 50);
			if(seatstatus.seats[17]) {
				seat17.setBackground(Color.RED);
			}
			seat17.addActionListener(new EventHandler());
			add(seat17);
			
			seat18.setBackground(Color.orange);
			seat18.setBounds(100, 350, 50, 50);
			if(seatstatus.seats[18]) {
				seat18.setBackground(Color.RED);
			}
			seat18.addActionListener(new EventHandler());
			add(seat18);
			
			seat19.setBackground(Color.orange);
			seat19.setBounds(100, 400, 50, 50);
			if(seatstatus.seats[19]) {
				seat19.setBackground(Color.RED);
			}
			seat19.addActionListener(new EventHandler());
			add(seat19);
			
			seat20.setBackground(Color.orange);
			seat20.setBounds(100, 450, 50, 50);
			if(seatstatus.seats[20]) {
				seat20.setBackground(Color.RED);
			}
			seat20.addActionListener(new EventHandler());
			add(seat20);
			
			seat21.setBackground(Color.orange);
			seat21.setBounds(150, 250, 50, 50);
			if(seatstatus.seats[21]) {
				seat21.setBackground(Color.RED);
			}
			seat21.addActionListener(new EventHandler());
			add(seat21);
			
			seat22.setBackground(Color.orange);
			seat22.setBounds(150, 300, 50, 50);
			if(seatstatus.seats[22]) {
				seat22.setBackground(Color.RED);
			}
			seat22.addActionListener(new EventHandler());
			add(seat22);
			
			seat23.setBackground(Color.orange);
			seat23.setBounds(150, 350, 50, 50);
			if(seatstatus.seats[23]) {
				seat23.setBackground(Color.RED);
			}
			seat23.addActionListener(new EventHandler());
			add(seat23);
			
			seat24.setBackground(Color.orange);
			seat24.setBounds(150, 400, 50, 50);
			if(seatstatus.seats[24]) {
				seat24.setBackground(Color.RED);
			}
			seat24.addActionListener(new EventHandler());
			add(seat24);
			
			seat25.setBackground(Color.orange);
			seat25.setBounds(150, 450, 50, 50);
			if(seatstatus.seats[25]) {
				seat25.setBackground(Color.RED);
			}
			seat25.addActionListener(new EventHandler());
			add(seat25);
			
			seat26.setBackground(Color.orange);
			seat26.setBounds(250, 250, 50, 50);
			if(seatstatus.seats[26]) {
				seat26.setBackground(Color.RED);
			}
			seat26.addActionListener(new EventHandler());
			add(seat26);
			
			seat27.setBackground(Color.orange);
			seat27.setBounds(250, 300, 50, 50);
			if(seatstatus.seats[27]) {
				seat27.setBackground(Color.RED);
			}
			seat27.addActionListener(new EventHandler());
			add(seat27);
			
			seat28.setBackground(Color.orange);
			seat28.setBounds(250, 350, 50, 50);
			if(seatstatus.seats[28]) {
				seat28.setBackground(Color.RED);
			}
			seat28.addActionListener(new EventHandler());
			add(seat28);
			
			//여기서부터
			seat29.setBackground(Color.orange);
			seat29.setBounds(250, 400, 50, 50);
			if(seatstatus.seats[29]) {
				seat29.setBackground(Color.RED);
			}
			seat29.addActionListener(new EventHandler());
			add(seat29);
			
			seat30.setBackground(Color.orange);
			seat30.setBounds(250, 450, 50, 50);
			if(seatstatus.seats[30]) {
				seat30.setBackground(Color.RED);
			}
			seat30.addActionListener(new EventHandler());
			add(seat30);
			
			seat31.setBackground(Color.orange);
			seat31.setBounds(300, 250, 50, 50);
			if(seatstatus.seats[31]) {
				seat31.setBackground(Color.RED);
			}
			seat31.addActionListener(new EventHandler());
			add(seat31);
			
			seat32.setBackground(Color.orange);
			seat32.setBounds(300, 300, 50, 50);
			if(seatstatus.seats[32]) {
				seat32.setBackground(Color.RED);
			}
			seat32.addActionListener(new EventHandler());
			add(seat32);
			
			seat33.setBackground(Color.orange);
			seat33.setBounds(300, 350, 50, 50);
			if(seatstatus.seats[33]) {
				seat33.setBackground(Color.RED);
			}
			seat33.addActionListener(new EventHandler());
			add(seat33);
			
			seat34.setBackground(Color.orange);
			seat34.setBounds(300, 400, 50, 50);
			if(seatstatus.seats[34]) {
				seat34.setBackground(Color.RED);
			}
			seat34.addActionListener(new EventHandler());
			add(seat34);
			
			seat35.setBackground(Color.orange);
			seat35.setBounds(300, 450, 50, 50);
			if(seatstatus.seats[35]) {
				seat35.setBackground(Color.RED);
			}
			seat35.addActionListener(new EventHandler());
			add(seat35);
			
			seat36.setBackground(Color.orange);
			seat36.setBounds(400, 250, 50, 50);
			if(seatstatus.seats[36]) {
				seat36.setBackground(Color.RED);
			}
			seat36.addActionListener(new EventHandler());
			add(seat36);
			
			seat37.setBackground(Color.orange);
			seat37.setBounds(400, 300, 50, 50);
			if(seatstatus.seats[37]) {
				seat37.setBackground(Color.RED);
			}
			seat37.addActionListener(new EventHandler());
			add(seat37);
			
			seat38.setBackground(Color.orange);
			seat38.setBounds(400, 350, 50, 50);
			if(seatstatus.seats[38]) {
				seat38.setBackground(Color.RED);
			}
			seat38.addActionListener(new EventHandler());
			add(seat38);
			
			seat39.setBackground(Color.orange);
			seat39.setBounds(400, 400, 50, 50);
			if(seatstatus.seats[39]) {
				seat39.setBackground(Color.RED);
			}
			seat39.addActionListener(new EventHandler());
			add(seat39);
			
			seat40.setBackground(Color.orange);
			seat40.setBounds(400, 450, 50, 50);
			if(seatstatus.seats[40]) {
				seat40.setBackground(Color.RED);
			}
			seat40.addActionListener(new EventHandler());
			add(seat40);
			
			seat41.setBackground(Color.orange);
			seat41.setBounds(450, 250, 50, 50);
			if(seatstatus.seats[41]) {
				seat41.setBackground(Color.RED);
			}
			seat41.addActionListener(new EventHandler());
			add(seat41);
			
			seat42.setBackground(Color.orange);
			seat42.setBounds(450, 300, 50, 50);
			if(seatstatus.seats[42]) {
				seat42.setBackground(Color.RED);
			}
			seat42.addActionListener(new EventHandler());
			add(seat42);
			
			seat43.setBackground(Color.orange);
			seat43.setBounds(450, 350, 50, 50);
			if(seatstatus.seats[43]) {
				seat43.setBackground(Color.RED);
			}
			seat43.addActionListener(new EventHandler());
			add(seat43);
			
			seat44.setBackground(Color.orange);
			seat44.setBounds(450, 400, 50, 50);
			if(seatstatus.seats[44]) {
				seat44.setBackground(Color.RED);
			}
			seat44.addActionListener(new EventHandler());
			add(seat44);
			
			seat45.setBackground(Color.orange);
			seat45.setBounds(450, 450, 50, 50);
			if(seatstatus.seats[45]) {
				seat45.setBackground(Color.RED);
			}
			seat45.addActionListener(new EventHandler());
			add(seat45);
			
			seat46.setBackground(Color.orange);
			seat46.setBounds(550, 250, 50, 50);
			if(seatstatus.seats[46]) {
				seat46.setBackground(Color.RED);
			}
			seat46.addActionListener(new EventHandler());
			add(seat46);
			
			seat47.setBackground(Color.orange);
			seat47.setBounds(550, 300, 50, 50);
			if(seatstatus.seats[47]) {
				seat47.setBackground(Color.RED);
			}
			seat47.addActionListener(new EventHandler());
			add(seat47);
			
			seat48.setBackground(Color.orange);
			seat48.setBounds(550, 350, 50, 50);
			if(seatstatus.seats[48]) {
				seat48.setBackground(Color.RED);
			}
			seat48.addActionListener(new EventHandler());
			add(seat48);
			
			seat49.setBackground(Color.orange);
			seat49.setBounds(550, 400, 50, 50);
			if(seatstatus.seats[49]) {
				seat49.setBackground(Color.RED);
			}
			seat49.addActionListener(new EventHandler());
			add(seat49);
			
			seat50.setBackground(Color.orange);
			seat50.setBounds(550, 450, 50, 50);
			if(seatstatus.seats[50]) {
				seat50.setBackground(Color.RED);
			}
			seat50.addActionListener(new EventHandler());
			add(seat50);
			
			
		}
	}
	
	class EventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(typee == 0)
				new BuyFrame(Integer.valueOf(e.getActionCommand()));
			else {
				String input = e.getActionCommand();
				
				if(input.equals("1")) {
					seatstatus.seatData[1] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[1] = true;
				}
				else if(input.equals("2")) {
					seatstatus.seatData[2] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[2] = true;
				}
				else if(input.equals("3")) {
					seatstatus.seatData[3] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[3] = true;
				}
				
				//여기서부터
				else if(input.equals("4")) {
					seatstatus.seatData[4] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[4] = true;
				}
				else if(input.equals("5")) {
					seatstatus.seatData[5] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[5] = true;
				}
				else if(input.equals("6")) {
					seatstatus.seatData[6] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[6] = true;
				}
				else if(input.equals("7")) {
					seatstatus.seatData[7] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[7] = true;
				}
				else if(input.equals("8")) {
					seatstatus.seatData[8] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[8] = true;
				}
				else if(input.equals("9")) {
					seatstatus.seatData[9] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[9] = true;
				}
				else if(input.equals("10")) {
					seatstatus.seatData[10] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[10] = true;
				}
				else if(input.equals("11")) {
					seatstatus.seatData[11] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[11] = true;
				}
				else if(input.equals("12")) {
					seatstatus.seatData[12] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[12] = true;
				}
				else if(input.equals("13")) {
					seatstatus.seatData[13] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[13] = true;
				}
				else if(input.equals("14")) {
					seatstatus.seatData[14] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[14] = true;
				}
				else if(input.equals("15")) {
					seatstatus.seatData[15] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[15] = true;
				}
				else if(input.equals("16")) {
					seatstatus.seatData[16] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[16] = true;
				}
				else if(input.equals("17")) {
					seatstatus.seatData[17] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[17] = true;
				}
				else if(input.equals("18")) {
					seatstatus.seatData[18] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[18] = true;
				}
				else if(input.equals("19")) {
					seatstatus.seatData[19] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[19] = true;
				}
				else if(input.equals("20")) {
					seatstatus.seatData[20] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[20] = true;
				}
				else if(input.equals("21")) {
					seatstatus.seatData[21] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[21] = true;
				}
				else if(input.equals("22")) {
					seatstatus.seatData[22] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[22] = true;
				}
				else if(input.equals("23")) {
					seatstatus.seatData[23] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[23] = true;
				}
				else if(input.equals("24")) {
					seatstatus.seatData[24] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[24] = true;
				}
				else if(input.equals("25")) {
					seatstatus.seatData[25] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[25] = true;
				}
				else if(input.equals("26")) {
					seatstatus.seatData[26] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[26] = true;
				}
				else if(input.equals("27")) {
					seatstatus.seatData[27] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[27] = true;
				}
				else if(input.equals("28")) {
					seatstatus.seatData[28] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[28] = true;
				}
				else if(input.equals("29")) {
					seatstatus.seatData[29] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[29] = true;
				}
				else if(input.equals("30")) {
					seatstatus.seatData[30] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[30] = true;
				}
				else if(input.equals("31")) {
					seatstatus.seatData[31] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[31] = true;
				}
				else if(input.equals("32")) {
					seatstatus.seatData[32] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[32] = true;
				}
				else if(input.equals("33")) {
					seatstatus.seatData[33] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[33] = true;
				}
				else if(input.equals("34")) {
					seatstatus.seatData[34] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[34] = true;
				}
				else if(input.equals("35")) {
					seatstatus.seatData[35] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[35] = true;
				}
				else if(input.equals("36")) {
					seatstatus.seatData[36] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[36] = true;
				}
				else if(input.equals("37")) {
					seatstatus.seatData[37] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[37] = true;
				}
				else if(input.equals("38")) {
					seatstatus.seatData[38] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[38] = true;
				}
				else if(input.equals("39")) {
					seatstatus.seatData[39] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[39] = true;
				}
				else if(input.equals("40")) {
					seatstatus.seatData[40] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[40] = true;
				}
				else if(input.equals("41")) {
					seatstatus.seatData[41] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[41] = true;
				}
				else if(input.equals("42")) {
					seatstatus.seatData[42] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[42] = true;
				}
				else if(input.equals("43")) {
					seatstatus.seatData[43] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[43] = true;
				}
				else if(input.equals("44")) {
					seatstatus.seatData[44] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[44] = true;
				}
				else if(input.equals("45")) {
					seatstatus.seatData[45] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[45] = true;
				}
				else if(input.equals("46")) {
					seatstatus.seatData[46] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[46] = true;
				}
				else if(input.equals("47")) {
					seatstatus.seatData[47] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[47] = true;
				}
				else if(input.equals("48")) {
					seatstatus.seatData[48] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[48] = true;
				}
				else if(input.equals("49")) {
					seatstatus.seatData[49] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[49] = true;
				}
				else if(input.equals("50")) {
					seatstatus.seatData[50] = seatstatus.soon;
					seatstatus.seatnum++;
					seatstatus.seats[50] = true;
				}
				//여기까지
				
				new FirstFrame();
				
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		
	}
	
}

class ChooseSeat extends JFrame implements ActionListener{
	
	JPanel phonenum = new JPanel();
	JLabel info = new JLabel("핸드폰 뒤 8자리를 입력하세요");
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
	JButton Pay = new JButton("확인");
	
	
	JButton Del = new JButton("<-");
	JTextField number = new JTextField();
	
	ChooseSeat(){
		
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		setSize(600,650);
		setLayout(null);
		phonenum.setLayout(new GridLayout(4,3));
		
		num0.setBackground(Color.orange);
		num1.setBackground(Color.orange);
		num2.setBackground(Color.orange);
		num3.setBackground(Color.orange);
		num4.setBackground(Color.orange);
		num5.setBackground(Color.orange);
		num6.setBackground(Color.orange);
		num7.setBackground(Color.orange);
		num8.setBackground(Color.orange);
		num9.setBackground(Color.orange);
		Pay.setBackground(Color.orange);
		Del.setBackground(Color.orange);
		
		num0.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num1.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num2.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num3.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num4.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num5.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num6.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num7.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num8.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num9.setFont(new Font("HY견고딕",Font.BOLD, 20));
		Pay.setFont(new Font("HY견고딕",Font.BOLD, 20));
		Del.setFont(new Font("HY견고딕",Font.BOLD, 20));
		
		num1.addActionListener(this);
		num2.addActionListener(this);
		num3.addActionListener(this);
		num4.addActionListener(this);
		num5.addActionListener(this);
		num6.addActionListener(this);
		num7.addActionListener(this);
		num8.addActionListener(this);
		num9.addActionListener(this);
		num0.addActionListener(this);
		Pay.addActionListener(this);
		
		phonenum.add(num1);
		phonenum.add(num2);
		phonenum.add(num3);
		phonenum.add(num4);
		phonenum.add(num5);
		phonenum.add(num6);
		phonenum.add(num7);
		phonenum.add(num8);
		phonenum.add(num9);
		phonenum.add(num0);
		phonenum.add(Del);
		phonenum.add(Pay);
		info.setBounds(100,50,450,100);
		phonenum.setBounds(150,250,300,300);
		number.setBounds(120,150,350,40);
		add(phonenum);
		add(info);
		number.setBackground(Color.white);
		number.setForeground(Color.black);
		number.setFont(new Font("맑은고딕",Font.BOLD, 20));
		info.setFont(new Font("HY견고딕",Font.PLAIN, 30));
		info.setForeground(Color.white);
		add(number);
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
		else if(input.equals("확인")){
			int order = -1;
			
			for(int i = 0; i < UserData.num; i++) {
				if(UserData.Data[i].number.equals(number.getText()))
						order = i;
			}
			
			if(order == -1) {
				this.setVisible(false);
				new WarningFrame2();
			}
			else {
				
				UserData.Data[order].nowseat = true;
				seatstatus.soon = UserData.Data[order];
				
				this.setVisible(false);
				
				new SeatFrame(1);
			
			
		
			}
		}
	}
}

class InFrame extends JFrame implements ActionListener{
	
	JLabel info = new JLabel("핸드폰 뒤 8자리를 입력하세요");
	JTextField number = new JTextField();
	JPanel phonenum = new JPanel();
	JButton num0 = new JButton("0");
	JButton num1= new JButton("1");
	JButton num2= new JButton("2");
	JButton num3 = new JButton("3");
	JButton num4 = new JButton("4");
	JButton num5 = new JButton("5");
	JButton num6 = new JButton("6");
	JButton num7 = new JButton("7");
	JButton num8 = new JButton("8");
	JButton num9 = new JButton("9");
	JButton Pay = new JButton("입실");
	JButton Del = new JButton("<-");
	
	
	InFrame(){
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		setSize(600,650);
		setLayout(null);
		phonenum.setLayout(new GridLayout(4,3));
		
		
		num1.addActionListener(this);
		num2.addActionListener(this);
		num3.addActionListener(this);
		num4.addActionListener(this);
		num5.addActionListener(this);
		num6.addActionListener(this);
		num7.addActionListener(this);
		num8.addActionListener(this);
		num9.addActionListener(this);
		num0.addActionListener(this);
		Pay.addActionListener(this);
		
		num0.setBackground(Color.orange);
		num1.setBackground(Color.orange);
		num2.setBackground(Color.orange);
		num3.setBackground(Color.orange);
		num4.setBackground(Color.orange);
		num5.setBackground(Color.orange);
		num6.setBackground(Color.orange);
		num7.setBackground(Color.orange);
		num8.setBackground(Color.orange);
		num9.setBackground(Color.orange);
		Pay.setBackground(Color.orange);
		Del.setBackground(Color.orange);
		
		num0.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num1.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num2.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num3.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num4.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num5.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num6.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num7.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num8.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num9.setFont(new Font("HY견고딕",Font.BOLD, 20));
		Pay.setFont(new Font("HY견고딕",Font.BOLD, 20));
		Del.setFont(new Font("HY견고딕",Font.BOLD, 20));
		
		phonenum.add(num1);
		phonenum.add(num2);
		phonenum.add(num3);
		phonenum.add(num4);
		phonenum.add(num5);
		phonenum.add(num6);
		phonenum.add(num7);
		phonenum.add(num8);
		phonenum.add(num9);
		phonenum.add(num0);
		phonenum.add(Del);
		phonenum.add(Pay);
		info.setBounds(100,50,450,100);
		phonenum.setBounds(150,250,300,300);
		number.setBounds(120,150,350,40);
		add(phonenum);
		add(info);
		number.setBackground(Color.white);
		number.setForeground(Color.black);
		number.setFont(new Font("맑은고딕",Font.BOLD, 20));
		info.setFont(new Font("HY견고딕",Font.PLAIN, 30));
		info.setForeground(Color.white);
		add(number);
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
		else if(input.equals("입실")){
			int order = 0;
			
			for(int i = 1; i < 51; i++) {
				if(seatstatus.seats[i])
					if(seatstatus.seatData[i].number.equals(number.getText()))
						order = i;
			}
			
			if(order == 0) {
				this.setVisible(false);
				new WarningFrame1(0);
				
			}
			else {
				
				
				
				this.setVisible(false);
				
				new afterIN();
			
			
		
			}
			
			
			
			
			
		}
			
	}
}


class OutFrame extends JFrame implements ActionListener{
	
	
	JLabel info = new JLabel("핸드폰 뒤 8자리를 입력하세요");
	JTextField number = new JTextField();
	JPanel phonenum = new JPanel();
	JButton num0 = new JButton("0");
	JButton num1= new JButton("1");
	JButton num2= new JButton("2");
	JButton num3 = new JButton("3");
	JButton num4 = new JButton("4");
	JButton num5 = new JButton("5");
	JButton num6 = new JButton("6");
	JButton num7 = new JButton("7");
	JButton num8 = new JButton("8");
	JButton num9 = new JButton("9");
	JButton Pay = new JButton("퇴실");
	JButton Del = new JButton("<-");
	
	
	OutFrame(){
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		setSize(600,650);
		setLayout(null);
		phonenum.setLayout(new GridLayout(4,3));
		
		num1.addActionListener(this);
		num2.addActionListener(this);
		num3.addActionListener(this);
		num4.addActionListener(this);
		num5.addActionListener(this);
		num6.addActionListener(this);
		num7.addActionListener(this);
		num8.addActionListener(this);
		num9.addActionListener(this);
		num0.addActionListener(this);
		Pay.addActionListener(this);
		
		num0.setBackground(Color.orange);
		num1.setBackground(Color.orange);
		num2.setBackground(Color.orange);
		num3.setBackground(Color.orange);
		num4.setBackground(Color.orange);
		num5.setBackground(Color.orange);
		num6.setBackground(Color.orange);
		num7.setBackground(Color.orange);
		num8.setBackground(Color.orange);
		num9.setBackground(Color.orange);
		Pay.setBackground(Color.orange);
		Del.setBackground(Color.orange);
		
		num0.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num1.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num2.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num3.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num4.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num5.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num6.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num7.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num8.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num9.setFont(new Font("HY견고딕",Font.BOLD, 20));
		Pay.setFont(new Font("HY견고딕",Font.BOLD, 20));
		Del.setFont(new Font("HY견고딕",Font.BOLD, 20));
		
		phonenum.add(num1);
		phonenum.add(num2);
		phonenum.add(num3);
		phonenum.add(num4);
		phonenum.add(num5);
		phonenum.add(num6);
		phonenum.add(num7);
		phonenum.add(num8);
		phonenum.add(num9);
		phonenum.add(num0);
		phonenum.add(Del);
		phonenum.add(Pay);
		info.setBounds(100,50,450,100);
		phonenum.setBounds(150,250,300,300);
		number.setBounds(120,150,350,40);
		add(phonenum);
		add(info);
		number.setBackground(Color.white);
		number.setForeground(Color.black);
		number.setFont(new Font("맑은고딕",Font.BOLD, 20));
		info.setFont(new Font("HY견고딕",Font.PLAIN, 30));
		info.setForeground(Color.white);
		add(number);
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
		else if(input.equals("퇴실")){
			int order = 0;
			
			for(int i = 1; i < 51; i++) {
				if(seatstatus.seats[i])
					if(seatstatus.seatData[i].number.equals(number.getText()))
						order = i;
			}
			
			if(order == 0) {
				this.setVisible(false);
				new WarningFrame1(1);
			}
			else {
				
				seatstatus.seats[order] = false;
				
				
				this.setVisible(false);
				
				new afterOUT();
			
			
		
			}
			
			
			
			
			
		}
			
	}
}

//당일권 구매
class BuyFrame extends JFrame implements ActionListener{
	
	int seatnumber;
	String bt1 = "<html>" + "2시간" + "<br>" + "3000원" + "</html>";
	String bt2 = "<html>" + "4시간" + "<br>" + "5000원" + "</html>";
	String bt3 = "<html>" + "6시간" + "<br>" + "8000원" + "</html>";
	String bt4 = "<html>" + "8시간" + "<br>" + "10000원" + "</html>";
	String bt5 = "<html>" + "10시간" + "<br>" + "12000원" + "</html>";
	String bt6 = "<html>" + "12시간" + "<br>" + "15000원" + "</html>";
	
	JLabel label = new JLabel("당일권 구매");
	JLabel label2 = new JLabel("원하는 메뉴를 선택하세요.");
	JLabel label3 = new JLabel("___________________________________");
	JButton but1 = new JButton(bt1);
	JButton but2 = new JButton(bt2);
	JButton but3 = new JButton(bt3);
	JButton but4 = new JButton(bt4);
	JButton but5 = new JButton(bt5);
	JButton but6 = new JButton(bt6);
	
	JPanel menu = new JPanel();
	
	
	BuyFrame(int seatnumber){
		
		getContentPane().setBackground(Color.DARK_GRAY);
		this.seatnumber = seatnumber;
		setLayout(null);
		setSize(600, 650);
		setVisible(true);
		
		
		
		label.setBounds(210, 10, 300, 90);
		label.setFont(new Font("HY견고딕",Font.BOLD, 30));
		label.setForeground(Color.white);
		add(label);
		
		label2.setBounds(130, 100,500, 100);
		label2.setFont(new Font("HY견고딕",Font.PLAIN, 25));
		label2.setForeground(Color.white);
		add(label2);
		
		label3.setBounds(0, 70,600, 30);
		label3.setFont(new Font("맑은고딕",Font.BOLD, 30));
		label3.setForeground(Color.white);
		add(label3);
		
		menu.setLayout(new GridLayout(2,3));
		menu.setBounds(80, 230, 400,300);
		
		but1.setFont(new Font("HY견고딕",Font.PLAIN, 20));
		but1.setBackground(Color.orange);
		but1.addActionListener(this);
		
		but2.setFont(new Font("HY견고딕",Font.PLAIN, 20));
		but2.setBackground(Color.orange);
		but2.addActionListener(this);
		
		but3.setFont(new Font("HY견고딕",Font.PLAIN, 20));
		but3.setBackground(Color.orange);
		but3.addActionListener(this);
		
		but4.setFont(new Font("HY견고딕",Font.PLAIN, 20));
		but4.setBackground(Color.orange);
		but4.addActionListener(this);
		
		but5.setFont(new Font("HY견고딕",Font.PLAIN, 20));
		but5.setBackground(Color.orange);
		but5.addActionListener(this);
		
		but6.setFont(new Font("HY견고딕",Font.PLAIN, 20));
		but6.setBackground(Color.orange);
		but6.addActionListener(this);
		
		menu.add(but1);
		menu.add(but2);
		menu.add(but3);
		menu.add(but4);
		menu.add(but5);
		menu.add(but6);
		
		
		add(menu);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if((JButton)obj == but1) {
			this.setVisible(false);
			new InsertNumber(seatnumber, 1);
		}
		else if((JButton)obj == but2) {
			this.setVisible(false);
			new InsertNumber(seatnumber, 2);
		}
		else if((JButton)obj == but3) {
			this.setVisible(false);
			new InsertNumber(seatnumber, 3);
		}
		else if((JButton)obj == but4) {
			this.setVisible(false);
			new InsertNumber(seatnumber, 4);
		}
		else if((JButton)obj == but5) {
			this.setVisible(false);
			new InsertNumber(seatnumber, 5);
		}
		else if((JButton)obj == but6) {
			this.setVisible(false);
			new InsertNumber(seatnumber, 6);
		}
		
		
	}

	
}

//시간/정기권 구매
class BuyFrame2 extends JFrame implements ActionListener{
	
	datauser customer = new datauser();
	int typee;
	String b1 = "<html>" + "1주" + "<br>" + "40,000원" + "</html>";
	String b2 = "<html>" + "2주" + "<br>" + "70,000원" + "</html>";
	String b3 = "<html>" + "3주" + "<br>" + "100,000원" + "</html>";
	String b4 = "<html>" + "4주" + "<br>" + "130,000원" + "</html>";
	String b5 = "<html>" + "6주" + "<br>" + "150,000원" + "</html>";
	String b6 = "<html>" + "8주" + "<br>" + "170,000원" + "</html>";
	String b7 = "<html>" + "12주" + "<br>" + "200,000원" + "</html>";
	
	JButton homeButton = new JButton("홈으로");
	JLabel info = new JLabel("정기권 구입");
	JLabel step1 = new JLabel("1단계 : 원하는 메뉴를 선택하세요");
	JLabel step2 = new JLabel("2단계 : 핸드폰 뒤 8자리를 입력하세요");
	JLabel line = new JLabel("______________________");
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
		
		info.setFont(new Font("HY견고딕",Font.PLAIN, 30));
		info.setBounds(200,20, 200,30);
		info.setForeground(Color.white); 
		add(info);
		
		line.setFont(new Font("HY견고딕",Font.BOLD, 15));
		line.setBounds(200,50,400,10);
		line.setForeground(Color.white);
		add(line);
		
		step1.setFont(new Font("HY견고딕",Font.PLAIN, 18));
		step1.setBounds(130,90, 330,20);
		step1.setForeground(Color.white); 
		add(step1);
			
		Button1.setBackground(Color.orange); //버튼 색깔 현재는 오렌지
		Button1.setBounds(60,130,120,70);
		Button1.setFont(new Font("HY견고딕",Font.PLAIN, 15));
		add(Button1);
		
		Button2.setBackground(Color.orange); 
		Button2.setBounds(180,130,120,70);
		Button2.setFont(new Font("HY견고딕",Font.PLAIN, 15));
		add(Button2);
		
		Button3.setBackground(Color.orange); 
		Button3.setBounds(300,130,120,70);
		Button3.setFont(new Font("HY견고딕",Font.PLAIN, 15));
		add(Button3);
		
		Button4.setBackground(Color.orange); 
		Button4.setBounds(420,130,120,70);
		Button4.setFont(new Font("HY견고딕",Font.PLAIN, 15));
		add(Button4);
		
		Button5.setBackground(Color.orange); 
		Button5.setBounds(60,200,120,70);
		Button5.setFont(new Font("HY견고딕",Font.PLAIN, 15));
		add(Button5);
		
		Button6.setBackground(Color.orange); 
		Button6.setBounds(180,200,120,70);
		Button6.setFont(new Font("HY견고딕",Font.PLAIN, 15));
		add(Button6);
		
		Button7.setBackground(Color.orange); 
		Button7.setBounds(300,200,120,70);
		Button7.setFont(new Font("HY견고딕",Font.PLAIN, 15));
		add(Button7);
		
		step2.setFont(new Font("HY견고딕",Font.PLAIN, 18));
		step2.setBounds(130,310,350,20);
		step2.setForeground(Color.white); 
		add(step2);
		
		number.setBackground(Color.white);      //현재는 번호 입력칸 배경 흰색
		number.setBounds(100,420,200,60);
		number.setFont(new Font("HY견고딕",Font.BOLD, 13));
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
		num1.setFont(new Font("맑은고딕",Font.BOLD, 15));
		add(num1);
		num2.setBackground(Color.orange);
		num2.setBounds(420,360,60,60);
		num2.setFont(new Font("맑은고딕",Font.BOLD, 15));
		add(num2);
		num3.setBackground(Color.orange);
		num3.setBounds(480,360,60,60);
		num3.setFont(new Font("맑은고딕",Font.BOLD, 15));
		add(num3);
		num4.setBackground(Color.orange);
		num4.setBounds(360,420,60,60);
		num4.setFont(new Font("맑은고딕",Font.BOLD, 15));
		add(num4);
		num5.setBackground(Color.orange);
		num5.setBounds(420,420,60,60);
		num5.setFont(new Font("맑은고딕",Font.BOLD, 15));
		add(num5);
		num6.setBackground(Color.orange);
		num6.setBounds(480,420,60,60);
		num6.setFont(new Font("맑은고딕",Font.BOLD, 15));
		add(num6);
		num7.setBackground(Color.orange);
		num7.setBounds(360,480,60,60);
		num7.setFont(new Font("맑은고딕",Font.BOLD, 15));
		add(num7);
		num8.setBackground(Color.orange);
		num8.setBounds(420,480,60,60);
		num8.setFont(new Font("맑은고딕",Font.BOLD, 15));
		add(num8);
		num9.setBackground(Color.orange);
		num9.setBounds(480,480,60,60);
		num9.setFont(new Font("맑은고딕",Font.BOLD, 15));
		add(num9);
		num0.setBackground(Color.orange);
		num0.setBounds(360,540,60,60);
		num0.setFont(new Font("맑은고딕",Font.BOLD, 15));
		add(num0);
		Del.setBackground(Color.orange);
		Del.setBounds(420,540,60,60);
		Del.setFont(new Font("맑은고딕",Font.BOLD, 15));
		add(Del);
		Pay.setBackground(Color.orange);
		Pay.setBounds(480,540,60,60);
		Pay.setFont(new Font("HY견고딕",Font.PLAIN, 12));
		add(Pay);
		
		Button1.addActionListener(this);
		Button2.addActionListener(this);
		Button3.addActionListener(this);
		Button4.addActionListener(this);
		Button5.addActionListener(this);
		Button6.addActionListener(this);
		Button7.addActionListener(this);
		
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
		
		if(input.equals(b1)) {
			typee = 7;
		}
		else if(input.equals(b2)) {
			typee = 8;
		}
		else if(input.equals(b3)) {
			typee = 9;
		}
		else if(input.equals(b4)) {
			typee = 10;
		}
		else if(input.equals(b5)) {
			typee = 11;
		}
		else if(input.equals(b6)) {
			typee = 12;
		}
		else if(input.equals(b7)) {
			typee = 13;
		}
		
		
		
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
			customer.number = number.getText();
			
			String pattern = "MM월 dd일 HH:mm:ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(new Date());
			Date date1 = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);
			if(typee == 7)
				cal.add(Calendar.DATE, 7);
			else if(typee == 8)
				cal.add(Calendar.DATE, 14);
			else if(typee == 9)
				cal.add(Calendar.DATE, 21);
			else if(typee == 10)
				cal.add(Calendar.DATE, 28);
			else if(typee == 11)
				cal.add(Calendar.DATE, 42);
			else if(typee == 12)
				cal.add(Calendar.DATE, 56);
			else if(typee == 13)
				cal.add(Calendar.DATE, 84);
			
			customer.starttime = date;
			customer.finishtime = simpleDateFormat.format(cal.getTime());
			
			UserData.Data[UserData.num++] = customer;
			new PayFrame(typee);
		}
			
	}
	
}


//전화번호 입력
class InsertNumber extends JFrame implements ActionListener{
	
	
	JLabel info = new JLabel("핸드폰 뒤 8자리를 입력하세요");
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
	int seatnumber;
	int type;
	
	JButton Del = new JButton("<-");
	
	public InsertNumber(int seatnumber, int type) {
		
		getContentPane().setBackground(Color.DARK_GRAY);
		this.seatnumber = seatnumber;
		this.type = type;
		//getContentPane().setBackground(Color.DARK_GRAY); //색깔 정하기
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		setVisible(true);
		setSize(600,650);
		
		info.setFont(new Font("HY견고딕",Font.BOLD, 20));
		info.setForeground(Color.white);
		info.setHorizontalAlignment(JLabel.CENTER);
		
		Button0.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Button0.setBackground(Color.orange);
		
		Button1.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Button1.setBackground(Color.orange);
		
		Button2.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Button2.setBackground(Color.orange);
		
		Button3.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Button3.setBackground(Color.orange);
		
		Button4.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Button4.setBackground(Color.orange);
		
		Button5.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Button5.setBackground(Color.orange);
		
		Button6.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Button6.setBackground(Color.orange);
		
		Button7.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Button7.setBackground(Color.orange);
		
		Button8.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Button8.setBackground(Color.orange);
		
		Button9.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Button9.setBackground(Color.orange);
		
		Pay.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Pay.setBackground(Color.orange);
		
		Del.setFont(new Font("맑은고딕",Font.BOLD, 30));
		Del.setBackground(Color.orange);
		
		
		
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
			seatstatus.seats[seatnumber] = true;
			seatstatus.seatnum++;
			
			datauser adduser = new datauser();
			adduser.number = number.getText();
			Date date1 = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date1);
			
			if(type == 1)
				cal.add(Calendar.HOUR, 2);
			else if(type == 2)
				cal.add(Calendar.HOUR, 4);
			else if(type == 3)
				cal.add(Calendar.HOUR, 6);
			else if(type == 4)
				cal.add(Calendar.HOUR, 8);
			else if(type == 5)
				cal.add(Calendar.HOUR, 10);
			else if(type == 6)
				cal.add(Calendar.HOUR, 12);
			
			String pattern = "MM월 dd일 HH:mm:ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(new Date());
			cal.add(Calendar.DATE, 30);
			adduser.starttime = date;
			adduser.finishtime = simpleDateFormat.format(cal.getTime()); 
			
			
			seatstatus.seatData[seatnumber] = adduser;
			this.setVisible(false);
			new PayFrame(type);
		}
		
		
		
		
	}
	
	
	
	
}

//결제완료 창zx
class PayFrame extends JFrame implements ActionListener{
	JLabel info;
	JButton Okay;
	JLabel logo = new JLabel("______________Sungkyunkwan StudyCafe_______________");
	JLabel logo2 = new JLabel("________________________________________________________");

	PayFrame(int cash){
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		setSize(600,650);
		setLayout(null);
		
		Okay = new JButton("확인");
		Okay.setBounds(250, 320, 100, 50);
		Okay.setFont(new Font("HY견고딕",Font.BOLD, 20));
		Okay.setBackground(Color.orange);
		logo.setBounds(50,20,500,50);
		logo.setFont(new Font("맑은 고딕",Font.ITALIC, 20));
		logo.setForeground(Color.white);
		logo2.setBounds(50,500,500,50);
		logo2.setFont(new Font("맑은 고딕",Font.ITALIC, 20));
		logo2.setForeground(Color.white);
	
		if(cash == 1) {
			info = new JLabel("3000원 결제되었습니다!");
		}
		else if(cash == 2)
			info = new JLabel("5000원 결제되었습니다!");
		else if(cash == 3)
			info = new JLabel("8000원 결제되었습니다!");
		else if(cash == 4)
			info = new JLabel("10000원 결제되었습니다!");
		else if(cash == 5)
			info = new JLabel("12000원 결제되었습니다!");
		else if(cash == 6)
			info = new JLabel("15000원 결제되었습니다!");
		else if(cash == 7)
			info = new JLabel("40000원 결제되었습니다!");
		else if(cash == 8)
			info = new JLabel("70000원 결제되었습니다!");
		else if(cash == 9)
			info = new JLabel("100,000원 결제되었습니다!");
		else if(cash == 10)
			info = new JLabel("130,000원 결제되었습니다!");
		else if(cash == 11)
			info = new JLabel("150,000원 결제되었습니다!");
		else if(cash == 12)
			info = new JLabel("170,000원 결제되었습니다!");
		else if(cash == 13)
			info = new JLabel("200,000원 결제되었습니다!");
		
		info.setFont(new Font("HY견고딕",Font.BOLD, 30));
		info.setBounds(100, 200, 500, 100);
		info.setForeground(Color.white);
		Okay.addActionListener(this);
		
		add(Okay);
		add(info);
		add(logo);
		add(logo2);
	}
	
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		new FirstFrame();
	}
	
}
//사물함 선택+홈버튼 기능
class LockerFrame extends JFrame implements ActionListener{
	int lockernum;
	
	JButton home = new JButton("홈으로");
	JLabel info = new JLabel("사물함 예약");
	JLabel line = new JLabel("__________________________________");
	String b1 = "<html>" + "기간: 1달 " + "<br>" + "가격: 10000원" + "</html>";
	JTextField used = new JTextField() {  
		public void setBorder(Border boder) {   //현재는 textfield 테두리 투명하게
			
		}
	};
	JLabel total = new JLabel("[이용현황: "+Integer.toString(lockerstatus.lockernum)+"/35]");
	
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
		int lockernumber;
		
		JLabel s5 = new JLabel("이용 중 사물함");
		JLabel s6 = new JLabel("사용 가능 사물함");
		JLabel s7 = new JLabel(b1);
		s5.setForeground(Color.white);
		s5.setFont(new Font("HY견고딕",Font.PLAIN, 10));
		s6.setForeground(Color.white);
		s6.setFont(new Font("HY견고딕",Font.PLAIN, 10));
		s7.setForeground(Color.white);
		s7.setFont(new Font("HY견고딕",Font.PLAIN, 12));
		line.setForeground(Color.white);
		line.setFont(new Font("맑은고딕",Font.BOLD, 10));
		s5.setBounds(450,80,150,20);
		s6.setBounds(450,60,150,20);
		s7.setBounds(430,110,150,40);
		line.setBounds(190,80,400,20);
		
		JButton yb = new JButton();
		JButton rb = new JButton();
		yb.setBounds(430,65,10,10);
		rb.setBounds(430,85,10,10);
		yb.setBackground(Color.orange);
		rb.setBackground(Color.red);
		add(s5);
		add(s6);
		add(s7);
		add(yb);
		add(rb);
		add(line);
		
		Locker1.addActionListener(this);
		Locker2.addActionListener(this);
		Locker3.addActionListener(this);
		Locker4.addActionListener(this);
		Locker5.addActionListener(this);
		Locker6.addActionListener(this);
		Locker7.addActionListener(this);
		Locker8.addActionListener(this);
		Locker9.addActionListener(this);
		Locker10.addActionListener(this);
		Locker11.addActionListener(this);
		Locker12.addActionListener(this);
		Locker13.addActionListener(this);
		Locker14.addActionListener(this);
		Locker15.addActionListener(this);
		Locker16.addActionListener(this);
		Locker17.addActionListener(this);
		Locker18.addActionListener(this);
		Locker19.addActionListener(this);
		Locker20.addActionListener(this);
		Locker21.addActionListener(this);
		Locker22.addActionListener(this);
		Locker23.addActionListener(this);
		Locker24.addActionListener(this);
		Locker25.addActionListener(this);
		Locker26.addActionListener(this);
		Locker27.addActionListener(this);
		Locker28.addActionListener(this);
		Locker29.addActionListener(this);
		Locker30.addActionListener(this);
		Locker31.addActionListener(this);
		Locker32.addActionListener(this);
		Locker33.addActionListener(this);
		Locker34.addActionListener(this);
		Locker35.addActionListener(this);
		
		home.setBackground(Color.PINK);
		home.setBounds(10,10,70,30);
		home.setFont(new Font("HY견고딕",Font.PLAIN, 12));
		home.addActionListener(this);
		add(home);
	
		
		info.setFont(new Font("HY견고딕",Font.PLAIN, 30));
		info.setBounds(200,40, 200,50);
		info.setForeground(Color.white); 
		add(info);
		
		total.setFont(new Font("HY견고딕",Font.PLAIN, 15));
		total.setBounds(430,135,150,50);
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
		if(lockerstatus.lockers[1]) {
			Locker1.setBackground(Color.RED);
		}
		Locker1.addActionListener(new eHandler());
		add(Locker1);
		
		Locker2.setBackground(Color.orange);
		Locker2.setBounds(125,220,70,70);
		Locker2.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[2]) {
			Locker2.setBackground(Color.RED);
		}
		Locker2.addActionListener(new eHandler());
		add(Locker2);
	
		Locker3.setBackground(Color.orange);
		Locker3.setBounds(195,220,70,70);
		Locker3.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[3]) {
			Locker3.setBackground(Color.RED);
		}
		Locker3.addActionListener(new eHandler());
		
		add(Locker3);
	
		Locker4.setBackground(Color.orange);
		Locker4.setBounds(265,220,70,70);
		Locker4.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[4]) {
			Locker4.setBackground(Color.RED);
		}
		Locker4.addActionListener(new eHandler());
		
		add(Locker4);
	
		Locker5.setBackground(Color.orange);
		Locker5.setBounds(335,220,70,70);
		Locker5.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[5]) {
			Locker5.setBackground(Color.RED);
		}
		Locker5.addActionListener(new eHandler());
		
		add(Locker5);
	
		Locker6.setBackground(Color.orange);
		Locker6.setBounds(405,220,70,70);
		Locker6.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[6]) {
			Locker6.setBackground(Color.RED);
		}
		Locker6.addActionListener(new eHandler());
		
		add(Locker6);
	
		Locker7.setBackground(Color.orange);
		Locker7.setBounds(475,220,70,70);
		Locker7.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[7]) {
			Locker7.setBackground(Color.RED);
		}
		Locker7.addActionListener(new eHandler());
		
		add(Locker7);
	
		Locker8.setBackground(Color.orange);
		Locker8.setBounds(55,290,70,70);
		Locker8.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[8]) {
			Locker8.setBackground(Color.RED);
		}
		Locker8.addActionListener(new eHandler());
		
		add(Locker8);
	
		Locker9.setBackground(Color.orange);
		Locker9.setBounds(125,290,70,70);
		Locker9.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[9]) {
			Locker9.setBackground(Color.RED);
		}
		Locker9.addActionListener(new eHandler());
		
		add(Locker9);
		
		Locker10.setBackground(Color.orange);
		Locker10.setBounds(195,290,70,70);
		Locker10.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[10]) {
			Locker10.setBackground(Color.RED);
		}
		Locker10.addActionListener(new eHandler());
		
		add(Locker10);

		Locker11.setBackground(Color.orange);
		Locker11.setBounds(265,290,70,70);
		Locker11.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[11]) {
			Locker11.setBackground(Color.RED);
		}
		Locker11.addActionListener(new eHandler());
		
		add(Locker11);
	
		Locker12.setBackground(Color.orange);
		Locker12.setBounds(335,290,70,70);
		Locker12.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[12]) {
			Locker12.setBackground(Color.RED);
		}
		Locker12.addActionListener(new eHandler());
		
		add(Locker12);
	
		Locker13.setBackground(Color.orange);
		Locker13.setBounds(405,290,70,70);
		Locker13.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[13]) {
			Locker13.setBackground(Color.RED);
		}
		Locker13.addActionListener(new eHandler());
		
		add(Locker13);
	
		Locker14.setBackground(Color.orange);
		Locker14.setBounds(475,290,70,70);
		Locker14.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[14]) {
			Locker14.setBackground(Color.RED);
		}
		Locker14.addActionListener(new eHandler());
		
		add(Locker14);
	
		Locker15.setBackground(Color.orange);
		Locker15.setBounds(55,360,70,70);
		Locker15.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[15]) {
			Locker15.setBackground(Color.RED);
		}
		Locker15.addActionListener(new eHandler());
		
		add(Locker15);
	
		Locker16.setBackground(Color.orange);
		Locker16.setBounds(125,360,70,70);
		Locker16.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[16]) {
			Locker16.setBackground(Color.RED);
		}
		Locker16.addActionListener(new eHandler());
		
		add(Locker16);
	
		Locker17.setBackground(Color.orange);
		Locker17.setBounds(195,360,70,70);
		Locker17.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[17]) {
			Locker17.setBackground(Color.RED);
		}
		Locker17.addActionListener(new eHandler());
		
		add(Locker17);
	
		Locker18.setBackground(Color.orange);
		Locker18.setBounds(265,360,70,70);
		Locker18.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[18]) {
			Locker18.setBackground(Color.RED);
		}
		Locker18.addActionListener(new eHandler());
		
		add(Locker18);
	
		Locker19.setBackground(Color.orange);
		Locker19.setBounds(335,360,70,70);
		Locker19.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[19]) {
			Locker19.setBackground(Color.RED);
		}
		Locker19.addActionListener(new eHandler());
		
		add(Locker19);
	
		Locker20.setBackground(Color.orange);
		Locker20.setBounds(405,360,70,70);
		Locker20.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[20]) {
			Locker20.setBackground(Color.RED);
		}
		Locker20.addActionListener(new eHandler());
		
		add(Locker20);
	
		Locker21.setBackground(Color.orange);
		Locker21.setBounds(475,360,70,70);
		Locker21.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[21]) {
			Locker21.setBackground(Color.RED);
		}
		Locker21.addActionListener(new eHandler());
		
		add(Locker21);
		
		Locker22.setBackground(Color.orange);
		Locker22.setBounds(55,430,70,70);
		Locker22.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[22]) {
			Locker22.setBackground(Color.RED);
		}
		Locker22.addActionListener(new eHandler());
		
		add(Locker22);

		Locker23.setBackground(Color.orange);
		Locker23.setBounds(125,430,70,70);
		Locker23.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[23]) {
			Locker23.setBackground(Color.RED);
		}
		Locker23.addActionListener(new eHandler());
		
		add(Locker23);

		Locker24.setBackground(Color.orange);
		Locker24.setBounds(195,430,70,70);
		Locker24.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[24]) {
			Locker24.setBackground(Color.RED);
		}
		Locker24.addActionListener(new eHandler());
		
		add(Locker24);
		
		Locker25.setBackground(Color.orange);
		Locker25.setBounds(265,430,70,70);
		Locker25.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[25]) {
			Locker25.setBackground(Color.RED);
		}
		Locker25.addActionListener(new eHandler());
		
		add(Locker25);
		
		Locker26.setBackground(Color.orange);
		Locker26.setBounds(335,430,70,70);
		Locker26.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[26]) {
			Locker26.setBackground(Color.RED);
		}
		Locker26.addActionListener(new eHandler());
		
		add(Locker26);
		
		Locker27.setBackground(Color.orange);
		Locker27.setBounds(405,430,70,70);
		Locker27.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[27]) {
			Locker27.setBackground(Color.RED);
		}
		Locker27.addActionListener(new eHandler());
		
		add(Locker27);
		
		Locker28.setBackground(Color.orange);
		Locker28.setBounds(475,430,70,70);
		Locker28.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[28]) {
			Locker28.setBackground(Color.RED);
		}
		Locker28.addActionListener(new eHandler());
		
		add(Locker28);
		
		Locker29.setBackground(Color.orange);
		Locker29.setBounds(55,500,70,70);
		Locker29.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[29]) {
			Locker29.setBackground(Color.RED);
		}
		Locker29.addActionListener(new eHandler());
		
		add(Locker29);
		
		Locker30.setBackground(Color.orange);
		Locker30.setBounds(125,500,70,70);
		Locker30.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[30]) {
			Locker30.setBackground(Color.RED);
		}
		Locker30.addActionListener(new eHandler());
		
		add(Locker30);
		
		Locker31.setBackground(Color.orange);
		Locker31.setBounds(195,500,70,70);
		Locker31.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[31]) {
			Locker31.setBackground(Color.RED);
		}
		Locker31.addActionListener(new eHandler());
		
		add(Locker31);
		
		Locker32.setBackground(Color.orange);
		Locker32.setBounds(265,500,70,70);
		Locker32.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[32]) {
			Locker32.setBackground(Color.RED);
		}
		Locker32.addActionListener(new eHandler());
		
		add(Locker32);
		
		Locker33.setBackground(Color.orange);
		Locker33.setBounds(335,500,70,70);
		Locker33.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[33]) {
			Locker33.setBackground(Color.RED);
		}
		Locker33.addActionListener(new eHandler());
		
		add(Locker33);
		
		Locker34.setBackground(Color.orange);
		Locker34.setBounds(405,500,70,70);
		Locker34.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[34]) {
			Locker34.setBackground(Color.RED);
		}
		Locker34.addActionListener(new eHandler());
		
		add(Locker34);
		
		Locker35.setBackground(Color.orange);
		Locker35.setBounds(475,500,70,70);
		Locker35.setFont(new Font("맑은고딕",Font.BOLD, 20));
		if(lockerstatus.lockers[35]) {
			Locker35.setBackground(Color.RED);
		}
		Locker35.addActionListener(new eHandler());
		
		add(Locker35);
		
		
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		
	}
		
	//전화번호 입력 창 띄우기
	class eHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new chooselocker(Integer.parseInt(e.getActionCommand()));
		}
		
	}
	
	
}

class WarningFrame1 extends JFrame implements ActionListener
{
	JLabel w1 = new JLabel("이용 중인 사용자가 아닙니다.");
	JButton ok = new JButton("확인");
	JLabel logo = new JLabel("______________Sungkyunkwan StudyCafe_______________");
	JLabel logo2 = new JLabel("________________________________________________________");
	int typp;
	WarningFrame1(int type)
	{	
		typp = type;
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		setSize(600,650);
		setLayout(null);

		w1.setBounds(100,230,450,50);
		w1.setFont(new Font("HY견고딕",Font.BOLD, 30));
		w1.setForeground(Color.white);
		ok.setBounds(250,350,100,50);
		ok.setBackground(Color.orange);
		ok.setFont(new Font("HY견고딕",Font.BOLD, 20));
		ok.addActionListener(this);
		logo.setBounds(50,20,500,50);
		logo.setFont(new Font("맑은 고딕",Font.ITALIC, 20));
		logo.setForeground(Color.white);
		logo2.setBounds(50,500,500,50);
		logo2.setFont(new Font("맑은 고딕",Font.ITALIC, 20));
		logo2.setForeground(Color.white);
		add(logo);
		add(logo2);
		add(w1);
		add(ok);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String input = e.getActionCommand();
		if(input.equals("확인")) {
			if(typp == 0) {
				this.setVisible(false);
				new FirstFrame();
			}
			else if(typp == 1) {
				this.setVisible(false);
				new FirstFrame();
			}
		}
	}
}

class WarningFrame2 extends JFrame implements ActionListener
{
	JLabel w1 = new JLabel("정기권 이용자가 아닙니다.");
	JButton ok = new JButton("확인");
	JLabel logo = new JLabel("______________Sungkyunkwan StudyCafe_______________");
	JLabel logo2 = new JLabel("________________________________________________________");

	WarningFrame2()
	{
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		setSize(600,650);
		setLayout(null);

		w1.setBounds(120,230,450,50);
		w1.setFont(new Font("HY견고딕",Font.BOLD, 30));
		w1.setForeground(Color.white);
		ok.setBounds(250,350,100,50);
		ok.setBackground(Color.orange);
		ok.setFont(new Font("HY견고딕",Font.BOLD, 20));
		ok.addActionListener(this);
		
		logo.setBounds(50,20,500,50);
		logo.setFont(new Font("맑은 고딕",Font.ITALIC, 20));
		logo.setForeground(Color.white);
		logo2.setBounds(50,500,500,50);
		logo2.setFont(new Font("맑은 고딕",Font.ITALIC, 20));
		logo2.setForeground(Color.white);

		add(w1);
		add(ok);
		add(logo);
		add(logo2);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String input = e.getActionCommand();
		if(input.equals("확인"))
		{
			this.setVisible(false);
			new FirstFrame();
		}
	}
}

class EnterFrame extends JFrame
{
	JLabel w1 = new JLabel("입실되었습니다.");
	JButton ok = new JButton("확인");
	EnterFrame()
	{
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		setSize(600,650);
		setLayout(null);
		w1.setBounds(180,230,450,50);
		w1.setFont(new Font("HY견고딕",Font.BOLD, 30));
		w1.setForeground(Color.white);
		ok.setBounds(250,350,100,50);
		ok.setBackground(Color.orange);
		ok.setFont(new Font("HY견고딕",Font.BOLD, 20));

		add(w1);
		add(ok);
	}
}

class LeaveFrame extends JFrame
{
	JLabel w1 = new JLabel("퇴실되었습니다.");
	JButton ok = new JButton("확인");
	LeaveFrame()
	{
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		setSize(600,650);
		setLayout(null);

		w1.setBounds(180,230,450,50);
		w1.setFont(new Font("HY견고딕",Font.BOLD, 30));
		w1.setForeground(Color.white);
		ok.setBounds(250,350,100,50);
		ok.setBackground(Color.orange);
		ok.setFont(new Font("HY견고딕",Font.BOLD, 20));

		add(w1);
		add(ok);
	}
}
class chooselocker extends JFrame implements ActionListener{
	
	JPanel phonenum = new JPanel();
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
	JButton Pay = new JButton("확인");
	JLabel info = new JLabel("핸드폰 뒤 8자리를 입력하세요");
	
	
	JButton Del = new JButton("<-");
	JTextField number = new JTextField();
	int lnum;
	
	chooselocker(int lockernum){
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		setSize(600,650);
		setLayout(null);
		phonenum.setLayout(new GridLayout(4,3));
		this.lnum=lockernum;
		
		num1.addActionListener(this);
		num2.addActionListener(this);
		num3.addActionListener(this);
		num4.addActionListener(this);
		num5.addActionListener(this);
		num6.addActionListener(this);
		num7.addActionListener(this);
		num8.addActionListener(this);
		num9.addActionListener(this);
		num0.addActionListener(this);
		Pay.addActionListener(this);
		Del.addActionListener(this);
		
		num0.setBackground(Color.orange);
		num1.setBackground(Color.orange);
		num2.setBackground(Color.orange);
		num3.setBackground(Color.orange);
		num4.setBackground(Color.orange);
		num5.setBackground(Color.orange);
		num6.setBackground(Color.orange);
		num7.setBackground(Color.orange);
		num8.setBackground(Color.orange);
		num9.setBackground(Color.orange);
		Pay.setBackground(Color.orange);
		Del.setBackground(Color.orange);
		
		num0.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num1.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num2.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num3.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num4.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num5.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num6.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num7.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num8.setFont(new Font("HY견고딕",Font.BOLD, 20));
		num9.setFont(new Font("HY견고딕",Font.BOLD, 20));
		Pay.setFont(new Font("HY견고딕",Font.BOLD, 20));
		Del.setFont(new Font("HY견고딕",Font.BOLD, 20));		
		
		phonenum.add(num1);
		phonenum.add(num2);
		phonenum.add(num3);
		phonenum.add(num4);
		phonenum.add(num5);
		phonenum.add(num6);
		phonenum.add(num7);
		phonenum.add(num8);
		phonenum.add(num9);
		phonenum.add(num0);
		phonenum.add(Del);
		phonenum.add(Pay);
		info.setBounds(100,50,450,100);
		phonenum.setBounds(150,250,300,300);
		number.setBounds(120,150,350,40);
		add(phonenum);
		add(info);
		number.setBackground(Color.white);
		number.setForeground(Color.black);
		number.setFont(new Font("맑은고딕",Font.BOLD, 20));
		info.setFont(new Font("HY견고딕",Font.PLAIN, 30));
		info.setForeground(Color.white);
		add(number);
		
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
		else if(input.equals("확인")){
		
				//사물함 이용자 정보 저장, 결제 완료 창 띄우기
				lockerstatus.lockers[lnum]=true;
				lockerstatus.lockernum++;
		
				lockerUser adduser=new lockerUser();
				adduser.number=number.getText();
				adduser.usinglocker=true;
				
				Date date1 = new Date();
				Calendar cal = Calendar.getInstance();
				cal.setTime(date1);
				String pattern = "MM월 dd일 HH:mm:ss";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				String date = simpleDateFormat.format(new Date());
				adduser.startdate = date;
				adduser.finishdate = simpleDateFormat.format(cal.getTime()); 
				
				
				
				
				lockerstatus.lockerData[lnum]=adduser;
				this.setVisible(false);
				new lockerPay(lnum);
			
				
		}		
	}
}

class lockerPay extends JFrame implements ActionListener{
	JLabel info;
	JButton Okay;
	JLabel logo = new JLabel("______________Sungkyunkwan StudyCafe_______________");
	JLabel logo2 = new JLabel("________________________________________________________");
	lockerPay(int lnum){
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		setSize(600,650);
		setLayout(null);
		Okay = new JButton("확인");
		Okay.setBounds(250, 320, 100, 50);
		Okay.setFont(new Font("HY견고딕",Font.BOLD, 20));
		Okay.setBackground(Color.orange);
		info = new JLabel(lnum+"번 사물함 결제되었습니다!");
		
		info.setFont(new Font("HY견고딕",Font.BOLD, 30));
		info.setBounds(100, 200, 500, 100);
		info.setForeground(Color.white);
		Okay.addActionListener(this);
		
		logo.setBounds(50,20,500,50);
		logo.setFont(new Font("맑은 고딕",Font.ITALIC, 20));
		logo.setForeground(Color.white);
		logo2.setBounds(50,500,500,50);
		logo2.setFont(new Font("맑은 고딕",Font.ITALIC, 20));
		logo2.setForeground(Color.white);
		
		add(logo);
		add(logo2);
		add(Okay);
		add(info);
	}
	
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		//new FirstFrame();
	}
}

class afterIN extends JFrame implements ActionListener{
	JLabel info;
	JButton Okay;
	JLabel logo = new JLabel("______________Sungkyunkwan StudyCafe_______________");
	JLabel logo2 = new JLabel("________________________________________________________");
	afterIN(){
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		setSize(600,650);
		setLayout(null);
		Okay = new JButton("확인");
		Okay.setBounds(250, 320, 100, 50);
		Okay.setFont(new Font("HY견고딕",Font.BOLD, 20));
		Okay.setBackground(Color.orange);
		Okay.addActionListener(this);
		info = new JLabel("입실 되었습니다!");
		
		info.setFont(new Font("HY견고딕",Font.BOLD, 35));
		info.setBounds(160, 200, 500, 100);
		info.setForeground(Color.white);
		
		logo.setBounds(50,20,500,50);
		logo.setFont(new Font("맑은 고딕",Font.ITALIC, 20));
		logo.setForeground(Color.white);
		logo2.setBounds(50,500,500,50);
		logo2.setFont(new Font("맑은 고딕",Font.ITALIC, 20));
		logo2.setForeground(Color.white);
		
		add(logo);
		add(logo2);
		add(Okay);
		add(info);
	}
	
	public void actionPerformed(ActionEvent e) {
		String input = e.getActionCommand();
		if(input.equals("확인")) {
			this.setVisible(false);
			new FirstFrame();
		}
	}
}

class afterOUT extends JFrame implements ActionListener{
	JLabel info;
	JButton Okay;
	JLabel logo = new JLabel("______________Sungkyunkwan StudyCafe_______________");
	JLabel logo2 = new JLabel("________________________________________________________");
	afterOUT(){
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		setSize(600,650);
		setLayout(null);
		Okay = new JButton("확인");
		Okay.setBounds(250, 320, 100, 50);
		Okay.setFont(new Font("HY견고딕",Font.BOLD, 20));
		Okay.setBackground(Color.orange);
		Okay.addActionListener(this);
		info = new JLabel("퇴실 되었습니다!");
		
		info.setFont(new Font("HY견고딕",Font.BOLD, 35));
		info.setBounds(160, 200, 500, 100);
		info.setForeground(Color.white);
		
		logo.setBounds(50,20,500,50);
		logo.setFont(new Font("맑은 고딕",Font.ITALIC, 20));
		logo.setForeground(Color.white);
		logo2.setBounds(50,500,500,50);
		logo2.setFont(new Font("맑은 고딕",Font.ITALIC, 20));
		logo2.setForeground(Color.white);
		
		add(logo);
		add(logo2);
		add(Okay);
		add(info);
	}
	
	public void actionPerformed(ActionEvent e) {
		String input = e.getActionCommand();
		if(input.equals("확인")) {
			seatstatus.seatnum--;
			this.setVisible(false);
			new FirstFrame();
		}
	}
}


class ManageFrame extends JFrame implements ActionListener{
	
	JButton Regular  = new JButton("정기권 이용자");
	JButton Seat  = new JButton("좌석 현황");
	JButton Locker  = new JButton("사물함");
	JButton home = new JButton("홈으로");
	JButton off = new JButton("관리자용");
	
	JLabel logo1 = new JLabel("____________________");
	JLabel logo2 = new JLabel("成均館");
	JLabel logo3 = new JLabel("스터디카페");
	JLabel logo4 = new JLabel("Sungkyunkwan StudyCafe");
	JLabel logo5 = new JLabel("_______________________________");
	
	ManageFrame(){
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		setSize(600,650);
		setLayout(null);
		
		Regular.setBounds(80, 400, 120, 120);
		Regular.addActionListener(this);
		Regular.setBackground(Color.CYAN);
		Regular.setFont(new Font("HY견고딕",Font.PLAIN, 12));
		add(Regular);
		
		Seat.setBounds(230, 400, 120, 120);
		Seat.addActionListener(this);
		Seat.setBackground(Color.cyan);
		Seat.setFont(new Font("HY견고딕",Font.PLAIN, 15));
		add(Seat);
		
		Locker.setBounds(380, 400, 120, 120);
		Locker.addActionListener(this);
		Locker.setBackground(Color.cyan);
		Locker.setFont(new Font("HY견고딕",Font.PLAIN, 15));
		add(Locker);
		
		home.setBackground(Color.white);
		home.setBounds(10,10,70,30);
		home.addActionListener(this);
		home.setFont(new Font("HY견고딕",Font.PLAIN, 12));
		add(home);
		
		logo1.setBounds(215,105,400,20);
		logo1.setFont(new Font("HY견고딕",Font.PLAIN, 15));
		logo1.setForeground(Color.white);
		add(logo1);
		
		logo2.setBounds(210,130,200,50);
		logo2.setFont(new Font("HY견고딕",Font.PLAIN, 50));
		logo2.setForeground(Color.white);
		add(logo2);
		
		logo3.setBounds(190,180,200,40);
		logo3.setFont(new Font("HY견고딕",Font.PLAIN, 40));
		logo3.setForeground(Color.white);
		add(logo3);
		
		logo4.setBounds(180,220,300,24);
		logo4.setFont(new Font("맑은 고딕",Font.ITALIC, 18));
		logo4.setForeground(Color.white);
		add(logo4);
		
		logo5.setBounds(175,240,500,20);
		logo5.setFont(new Font("HY견고딕",Font.PLAIN, 15));
		logo5.setForeground(Color.white);
		add(logo5);
		
		off.setBounds(237, 270, 100, 30);
		off.addActionListener(this);
		off.setBackground(Color.LIGHT_GRAY);
		off.setFont(new Font("HY견고딕",Font.PLAIN, 15));
		add(off);
	}
	
	public void actionPerformed(ActionEvent e) {
		String input = e.getActionCommand();
		if(input.equals("정기권 이용자")) {
			this.setVisible(false);
			new RegularUserFrame();
		}
		else if(input.equals("좌석 현황")) {
			this.setVisible(false);
			new SeatStat();
		}
		else if(input.equals("홈으로")) {
			this.setVisible(false);
			new FirstFrame();
		}
		else if(input.equals("사물함")) {
			this.setVisible(false);
			new Lockerstat();
		}
	}
}

class RegularUserFrame extends JFrame implements ActionListener{
	JLabel[] foruser = new JLabel[100];
	JLabel aaa;
	JLabel aaa1;
	JLabel line = new JLabel("____________________________________");
	JLabel line2 = new JLabel("____________________________________");
	JLabel logo4 = new JLabel("Sungkyunkwan StudyCafe");
	JButton back = new JButton("돌아가기");
	int y = 160;
	
	RegularUserFrame(){
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		setSize(600,650);
		setLayout(null);
		
		aaa = new JLabel("정기권 이용자");
		aaa.setFont(new Font("맑은 고딕",Font.BOLD, 30));
		aaa.setBounds(190, 20, 400, 100);
		aaa.setForeground(Color.white);
		
		aaa1 = new JLabel("번호   전화번호             시작시간                   종료시간");
		aaa1.setFont(new Font("맑은 고딕",Font.BOLD, 15));
		aaa1.setBounds(20, 115, 500, 40);
		aaa1.setForeground(Color.white);
		
		line.setBounds(0, 84,600, 30);
		line.setFont(new Font("맑은고딕",Font.BOLD, 30));
		line.setForeground(Color.white);
		add(line);
		
		line2.setBounds(0, 126,600, 30);
		line2.setFont(new Font("맑은고딕",Font.BOLD, 30));
		line2.setForeground(Color.white);
		add(line2);
		
		logo4.setBounds(390,10,200,20);
		logo4.setFont(new Font("맑은 고딕",Font.ITALIC, 15));
		logo4.setForeground(Color.white);
		add(logo4);
		
		add(aaa);
		add(aaa1);
		
		for(int i = 0; i < UserData.num; i++) {
			foruser[i] = new JLabel();
			String info = Integer.toString(i) + "      " + "010" + UserData.Data[i].number + "     " + UserData.Data[i].starttime + "    " + UserData.Data[i].finishtime;
			foruser[i].setText(info);
			foruser[i].setFont(new Font("맑은 고딕",Font.BOLD, 15));
			foruser[i].setForeground(Color.white);
			foruser[i].setBounds(30, y, 500, 20);
			add(foruser[i]);
			y += 25;
		}
		
		back.setBackground(Color.cyan);
		back.setBounds(10,10,90,30);
		back.addActionListener(this);
		back.setFont(new Font("HY견고딕",Font.PLAIN, 12));
		add(back);
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String input = e.getActionCommand();
		if(input.equals("돌아가기")) {
			this.setVisible(false);
			new ManageFrame();
		}
	}
}

class SeatStat extends JFrame implements ActionListener{
	JButton back = new JButton("돌아가기");
	JLabel line = new JLabel("____________________________________");
	JLabel line2 = new JLabel("____________________________________");
	JLabel logo4 = new JLabel("Sungkyunkwan StudyCafe");
	JLabel[] forseat = new JLabel[51];
	JLabel aaa;
	JLabel aaa1;
	int y = 160;
	
	SeatStat(){
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		setSize(600,650);
		setLayout(null);
		
		
		aaa = new JLabel("좌석 현황");
		aaa.setFont(new Font("맑은 고딕",Font.BOLD, 30));
		aaa.setBounds(200, 20, 400, 100);
		aaa.setForeground(Color.white);
		
		aaa1 = new JLabel("번호   전화번호             시작시간                   종료시간");
		aaa1.setFont(new Font("맑은 고딕",Font.BOLD, 15));
		aaa1.setBounds(20, 115, 500, 40);
		aaa1.setForeground(Color.white);
		
		line.setBounds(0, 84,600, 30);
		line.setFont(new Font("맑은고딕",Font.BOLD, 30));
		line.setForeground(Color.white);
		add(line);
		
		line2.setBounds(0, 126,600, 30);
		line2.setFont(new Font("맑은고딕",Font.BOLD, 30));
		line2.setForeground(Color.white);
		add(line2);
		
		logo4.setBounds(390,10,200,20);
		logo4.setFont(new Font("맑은 고딕",Font.ITALIC, 15));
		logo4.setForeground(Color.white);
		add(logo4);
		
		add(aaa);
		add(aaa1);
		
		for(int i = 1; i < 51; i++) {
			if(seatstatus.seats[i]) {
				
				forseat[i] = new JLabel();
				String info = Integer.toString(i) + "      " + "010" + seatstatus.seatData[i].number + "     " + seatstatus.seatData[i].starttime + "    " + seatstatus.seatData[i].finishtime;
				forseat[i].setText(info);
				forseat[i].setFont(new Font("맑은 고딕",Font.BOLD, 15));
				forseat[i].setForeground(Color.white);
				forseat[i].setBounds(30, y, 500, 20);
				add(forseat[i]);
				y += 25;
			}
		}
		back.setBackground(Color.cyan);
		back.setBounds(10,10,90,30);
		back.addActionListener(this);
		back.setFont(new Font("HY견고딕",Font.PLAIN, 12));
		add(back);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String input = e.getActionCommand();
		if(input.equals("돌아가기")) {
			this.setVisible(false);
			new ManageFrame();
		}
	}
}


class Lockerstat extends JFrame implements ActionListener{
	JButton back = new JButton("돌아가기");
	JLabel line = new JLabel("____________________________________");
	JLabel line2 = new JLabel("____________________________________");
	JLabel logo4 = new JLabel("Sungkyunkwan StudyCafe");
	JLabel[] forlocker = new JLabel[100];
	JLabel aaa;
	JLabel aaa1;
	int y = 160;
	
	Lockerstat(){
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		setSize(600,650);
		setLayout(null);
		
		aaa = new JLabel("사물함 현황");
		aaa.setFont(new Font("맑은 고딕",Font.BOLD, 30));
		aaa.setBounds(200, 20, 400, 100);
		aaa.setForeground(Color.white);
		
		aaa1 = new JLabel("번호   전화번호             시작시간                   종료시간");
		aaa1.setFont(new Font("맑은 고딕",Font.BOLD, 15));
		aaa1.setBounds(20, 115, 500, 40);
		aaa1.setForeground(Color.white);
		
		line.setBounds(0, 84,600, 30);
		line.setFont(new Font("맑은고딕",Font.BOLD, 30));
		line.setForeground(Color.white);
		add(line);
		
		line2.setBounds(0, 126,600, 30);
		line2.setFont(new Font("맑은고딕",Font.BOLD, 30));
		line2.setForeground(Color.white);
		add(line2);
		
		logo4.setBounds(390,10,200,20);
		logo4.setFont(new Font("맑은 고딕",Font.ITALIC, 15));
		logo4.setForeground(Color.white);
		add(logo4);
		
		add(aaa);
		add(aaa1);
		
		for(int i = 1; i < 36; i++) {
			if(lockerstatus.lockers[i]) {
				forlocker[i] = new JLabel(); 
				String info = Integer.toString(i) + "      " + "010" + lockerstatus.lockerData[i].number+ "     " + lockerstatus.lockerData[i].startdate + "    " + lockerstatus.lockerData[i].finishdate;
				forlocker[i].setText(info);
				forlocker[i].setFont(new Font("맑은 고딕",Font.BOLD, 15));
				forlocker[i].setForeground(Color.white);
				forlocker[i].setBounds(30, y, 500, 20);
				add(forlocker[i]);
				y += 25;
			}
		}
		back.setBackground(Color.cyan);
		back.setBounds(10,10,90,30);
		back.addActionListener(this);
		back.setFont(new Font("HY견고딕",Font.PLAIN, 12));
		add(back);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String input = e.getActionCommand();
		if(input.equals("돌아가기")) {
			this.setVisible(false);
			new ManageFrame();
		}
	}
}
