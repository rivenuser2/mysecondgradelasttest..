package board_1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 이 클래스는 개시판을 나타냅니다
 * 
 * @author 조민준
 * @see 쉽게배우는 자바프로그레밍2판
 * @version 현재버전 0.5
 * @since 최초생성 2024-11-18 -> 버전 0.5
 * 
 */
public class board1 extends JFrame {

	JTextField mainpoint_a;// 공고글 본론
	JTextField title_a;// 공고글 제목
	JTextField comment_a;// 공고글 댓글
	JTextField mainpoint_t;// 팀원글 본론
	JTextField title_t;// 팀원글 제목
	JTextField comment_t;// 팀원글 댓글

	/**
	 * 생성자입니다 초기화를 시켜주는 기능이 있습니다 그리드 레이아웃을 사용했습니다
	 * 
	 * @since 0.5
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
	 * 개시판에서 왼쪽에 위치하는 패널입니다 공고글의 업로드를 담당합니다
	 * 
	 * @since 0.5
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
		 * 버튼을 누를시 공고글(Announce())가 켜지게 됩니다
		 * 
		 * @since 0.5
		 */
		ActionListener button1 = e -> {
			if (e.getSource() == plus) {
				Announce();
			}
		};
		plus.addActionListener(button1);

	}

	/**
	 * 공고글입니다 텍스트작성가능한 텍스트필드가 3개 제목,본론,댓글이 작성 가능합니다
	 * 
	 * @since 0.5
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
	}

	/**
	 * 전체개시판의 오른쪽을 담당하는 팀원모집 개시판입니다.
	 * 
	 * @since 0.5
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
		 * 버튼이 눌리면 팀원구함글(teammembers())가 켜지게 됩니다.
		 * 
		 * @since 0.5
		 */
		ActionListener button2 = e -> {
			if (e.getSource() == plus) {
				teammembers();
			}
		};
		plus.addActionListener(button2);

	}

	/**
	 * 공고글입니다 제목과 본론 댓글을 작성할수있는 3개의 텍스트필드가 있습니다
	 * 
	 * @since 0.5
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

	public static void main(String[] args) {
		new board1();

	}

}
