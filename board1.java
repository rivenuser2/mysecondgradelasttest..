package board_1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 이 클래스는 개시판을 나타냅니다 공고글과 팀원 모집 글을 작성할수있는 인터페이스를 제공합니다
 * 
 * @author 조민준
 * @see 쉽게배우는 자바프로그레밍2판
 * @version 현재버전 0.6
 * @since 최초생성 2024-11-18 (버전 0.5)
 * @since 2024-11-19(버전 0.5.1)
 * 
 * 
 */
public class board1 extends JFrame {

	List<String[]> announcements = new ArrayList<>();

	JTextField mainpoint_a;// 공고글 본론
	JTextField title_a;// 공고글 제목
	JTextField comment_a;// 공고글 댓글
	JTextField mainpoint_t;// 팀원글 본론
	JTextField title_t;// 팀원글 제목
	JTextField comment_t;// 팀원글 댓글
	JPanel announcementPanel; // 공고글을 표시할 패널

	/**
	 * 게시판의 생성자. 사용자 인테페이스를 초기화 합니다 그리드 레이아웃을 사용하여 각 구성요소를 배치합니다.
	 * 
	 * @since 최초생성 2024-11-18(버전0.5)
	 */
	board1() {
		setTitle("게시판");
		setLayout(new GridLayout(0, 2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
		showLeft();
		showRight();
	}

	/**
	 * 개시판에서 왼쪽에 위치하는 패널입니다 공고글의 업로드를 담당합니다 공고글을 작성하기위한 버튼과 제목을 포함합니다.
	 * 
	 * @since 최초생성 2024-11-18(버전0.5)
	 */
	void showLeft() {// 공고글이 올라오는 게시판
		JPanel panel = new JPanel(new BorderLayout(10, 10));
		JPanel p1 = new JPanel();
		JLabel title = new JLabel("공고");
		JButton plus = new JButton("공고 글 만들기");
		p1.add(title);
		p1.add(plus);
		panel.add(p1);
		this.add(panel);

		/**
		 * 버튼을 누를시 공고글창(Announce())이 켜지게 됩니다. 버튼 클릭 이벤트를 처리합니다.
		 * 
		 * @since 최초생성 2024-11-18(버전0.5)
		 * @param e 이벤트 객체
		 */
		ActionListener button1 = e -> {
			if (e.getSource() == plus) {
				Announce();
			}
		};
		plus.addActionListener(button1);

	}

	/**
	 * 공고글 창을 표시합니다. 제목,본론,댓글을 작성할수있는 텍스트필드가 있습니다.
	 * 
	 * @since 최초생성 2024-11-18(버전0.5)
	 * @since 2024-11-19(버전 0.5.1)
	 */
	void Announce() {// 공고글
		JFrame announceFrame = new JFrame("공고 창");
		announceFrame.setSize(300, 200);
		announceFrame.setLayout(new GridLayout(4, 1));
		JPanel p1 = new JPanel();
		JLabel name = new JLabel("공고");
		JButton plus = new JButton("완료");
		title_a = new JTextField(10);
		mainpoint_a = new JTextField(10);
		comment_a = new JTextField(10);
		p1.add(name);
		p1.add(plus);
		announceFrame.add(p1);
		announceFrame.add(title_a);
		announceFrame.add(mainpoint_a);
		announceFrame.add(comment_a);
		announceFrame.setVisible(true);

		/**
		 * 완료버튼을 클릭시 작성된 공고글을 공고 개시판에 띄어줍니다.
		 * 
		 * @since 2024-11-19(버전0.5.1)
		 * @param e 이벤트 객체
		 */
		ActionListener button_Announce_write = e -> {
			if (e.getSource() == plus) {
			}
		};
		plus.addActionListener(button_Announce_write);
	}

	/**
	 * 전체개시판의 오른쪽을 담당하는 팀원모집 개시판입니다.
	 * 
	 * @since 최초생성 2024-11-18(버전0.5)
	 */
	void showRight() {// 팀원구함 개시판
		JPanel panel = new JPanel(new BorderLayout(10, 10));
		JPanel p1 = new JPanel();
		JLabel title = new JLabel("팀원구합니다");
		JButton plus = new JButton("글쓰기");
		p1.add(title);
		p1.add(plus);
		panel.add(p1);
		this.add(panel);

		/**
		 * 버튼이 눌리면 팀원모집글(teammembers())이 켜지게 됩니다. 버튼클릭 이벤트를 처리합니다.
		 * 
		 * @since 최초생성 2024-11-18(버전0.5)
		 * @param e 이벤트 객체
		 */
		ActionListener button2 = e -> {
			if (e.getSource() == plus) {
				teammembers();
			}
		};
		plus.addActionListener(button2);

	}

	/**
	 * 팀원 모집 창을 표시합니다. 제목과 본론.댓글을 작성할수있는 3개의 텍스트필드가 있습니다.
	 * 
	 * @since 최초생성 2024-11-18 (버전0.5)
	 * 
	 */
	void teammembers() {// 공고글
		JFrame teammembers = new JFrame("팀원모집 창");
		teammembers.setSize(300, 200);
		teammembers.setLayout(new GridLayout(4, 1));
		JPanel p1 = new JPanel();
		JLabel name = new JLabel("팀원모집");
		JButton plus = new JButton("완료");
		title_t = new JTextField(10);
		mainpoint_t = new JTextField(10);
		comment_t = new JTextField(10);
		p1.add(name);
		p1.add(plus);
		teammembers.add(p1);
		teammembers.add(title_t);
		teammembers.add(mainpoint_t);
		teammembers.add(comment_t);
		teammembers.setVisible(true);
	}

	/**
	 * 프로그램의 진입점입니다. 게시판 인터페이스를 생성합니다.
	 * 
	 * @param args 실행 인자
	 * @since 최초생성2024-11-18(버전 0.5)
	 */

	public static void main(String[] args) {
		new board1();

	}

}
