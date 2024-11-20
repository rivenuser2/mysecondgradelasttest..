package board_1;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 이 클래스는 게시판을 나타냅니다. 공고글과 팀원 모집 글을 작성할 수 있는 인터페이스를 제공합니다.
 * 
 * @author 조민준
 * @see 쉽게배우는 자바프로그레밍2판
 * @version 0.5.2
 * @since 최초생성 2024-11-18 (버전 0.5)
 * @since 2024-11-19(버전 0.5.1)
 * @since 2024-11-20(버전 0.5.2)
 * 
 */
public class board1 extends JFrame {
	/**
	 * 직렬화
	 * 
	 * @since 최초생성 2024-11-20(버전0.5.2)
	 */
	private static final long serialVersionUID = 1L;

	List<String[]> announcements = new ArrayList<>(); // 공고글 저장 리스트
	/**
	 * 공고 관련 변수들 입니다
	 */
	JTextArea mainpoint_a; // 공고글 본론
	JTextField title_a; // 공고글 제목
	JTextField comment_a; // 공고글 댓글
	JPanel announcementPanel; // 공고글을 표시할 패널

	/**
	 * 팀원 관련 변수들 입니다.
	 */
	JTextArea mainpoint_t; // 팀원글 본론
	JTextField title_t; // 팀원글 제목

	/**
	 * 게시판의 생성자. 사용자 인터페이스를 초기화합니다. 그리드 레이아웃을 사용하여 각 구성 요소를 배치합니다.
	 * 
	 * @since 최초생성 2024-11-18(버전0.5)
	 */
	public board1() {
		setTitle("게시판");
		setLayout(new GridLayout(0, 2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
		showLeft();
		showRight();
	}

	/**
	 * 게시판에서 왼쪽에 위치하는 패널입니다. 공고글의 업로드를 담당합니다. 공고글을 작성하기 위한 버튼과 제목을 포함합니다.
	 * 
	 * @since 최초생성 2024-11-18(버전0.5)
	 * @since 수정 2024-11-20(버전 0.5.2)
	 */
	void showLeft() {
		announcementPanel = new JPanel(new GridLayout(10, 1)); // 공고글을 표시할 패널
		JPanel panel = new JPanel(new BorderLayout(10, 10));
		JPanel p1 = new JPanel();
		JLabel title = new JLabel("공고");
		JButton plus = new JButton("공고 글 만들기");
		p1.add(title);
		p1.add(plus);
		panel.add(p1, BorderLayout.NORTH);
		panel.add(announcementPanel, BorderLayout.CENTER); // 공고글 패널 추가
		this.add(panel, BorderLayout.WEST);

		/**
		 * 버튼을 누를 시 공고글 창이 켜지게 됩니다. 버튼 클릭 이벤트를 처리합니다.
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
	 * 공고글 창을 표시합니다. 제목, 본론, 댓글을 작성할 수 있는 텍스트 필드가 포함된 창을 생성합니다.
	 * 
	 * @since 최초생성 2024-11-18(버전0.5)
	 * @since 2024-11-19(버전 0.5.1)
	 */
	void Announce() {
		JFrame announceFrame = new JFrame("공고 창");
		announceFrame.setSize(300, 200);
		announceFrame.setLayout(new GridLayout(4, 1));
		JPanel p1 = new JPanel();
		JLabel name = new JLabel("공고");
		JButton plus = new JButton("완료");
		// 제목 패널 만들기
		JLabel titlelabel = new JLabel("제목");
		title_a = new JTextField(20);
		JPanel titlepanel = new JPanel();
		titlepanel.add(titlelabel);
		titlepanel.add(title_a);
		// 본론 패널 만들기
		JLabel mainpointlabel = new JLabel("본론");
		mainpoint_a = new JTextArea(20, 20);
		JPanel mainpointpanel = new JPanel();
		mainpointpanel.add(mainpointlabel);
		mainpointpanel.add(mainpoint_a);

		p1.add(name);
		p1.add(plus);
		announceFrame.add(p1);
		announceFrame.add(titlepanel);
		announceFrame.add(mainpointpanel);
		announceFrame.setVisible(true);

		/**
		 * 완료 버튼 클릭 시 작성된 공고글 정보를 처리합니다.
		 * 
		 * @since 0.5.2
		 * @param e 이벤트 객체
		 */
		plus.addActionListener(e -> {
			String[] announcement = { title_a.getText(), mainpoint_a.getText() };
			announcements.add(announcement);
			updateAnnouncements(); // 공고글 패널 업데이트
			announceFrame.dispose();
		});
	}

	/**
	 * 저장된 공고글을 화면에 업데이트하여 표시합니다.
	 * 
	 * @since 0.5.2
	 */
	void updateAnnouncements() {
		announcementPanel.removeAll();
		for (String[] announcement : announcements) {
			JPanel announcementItem = new JPanel(new GridLayout(1, 2));
			JLabel title = new JLabel(announcement[0]);
			JButton viewButton = new JButton("보기");
			announcementItem.add(title);
			announcementItem.add(viewButton);
			announcementPanel.add(announcementItem);

			// 공고글 보기 버튼 클릭 이벤트 처리
			viewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					viewAnnouncement(announcement);
				}
			});
		}
		announcementPanel.revalidate();
		announcementPanel.repaint();
	}

	/**
	 * 선택된 공고글을 열람할 수 있는 창을 표시합니다.
	 * 
	 * @param announcement 열람할 공고글 배열
	 * @since 0.5.2
	 */
	void viewAnnouncement(String[] announcement) {
		JFrame viewFrame = new JFrame("공고글 열람");
		viewFrame.setSize(300, 200);
		viewFrame.setLayout(new BorderLayout());
		JLabel title = new JLabel("제목: " + announcement[0]);
		JLabel mainpoint = new JLabel("본론: " + announcement[1]);
		viewFrame.add(title, BorderLayout.NORTH);
		viewFrame.add(mainpoint, BorderLayout.CENTER);
		viewFrame.setVisible(true);
	}

	/**
	 * 전체 게시판의 오른쪽을 담당하는 팀원 모집 게시판입니다. 팀원 모집 글을 작성하기 위한 버튼과 제목을 포함합니다.
	 * 
	 * @since 0.5
	 */
	void showRight() {
		JPanel panel = new JPanel(new BorderLayout(10, 10));
		JPanel p1 = new JPanel();
		JLabel title = new JLabel("팀원 구합니다");
		JButton plus = new JButton("글쓰기");
		p1.add(title);
		p1.add(plus);
		panel.add(p1, BorderLayout.NORTH);
		this.add(panel, BorderLayout.EAST);

		/**
		 * 버튼을 누르면 팀원 모집 글 창이 켜지게 됩니다. 버튼 클릭 이벤트를 처리합니다.
		 * 
		 * @since 0.5
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
	 * 팀원 모집 창을 표시합니다. 제목과 본론, 댓글을 작성할 수 있는 3개의 텍스트 필드가 포함된 창을 생성합니다.
	 * 
	 * @since 0.5
	 */
	void teammembers() {
		JFrame teammembers = new JFrame("팀원 모집 창");
		teammembers.setSize(300, 200);
		teammembers.setLayout(new GridLayout(4, 1));
		JPanel p1 = new JPanel();
		JLabel name = new JLabel("팀원 모집");
		JButton plus = new JButton("완료");
		title_t = new JTextField(10);
		mainpoint_t = new JTextArea();
		p1.add(name);
		p1.add(plus);
		teammembers.add(p1);
		teammembers.add(title_t);
		teammembers.add(mainpoint_t);
		teammembers.setVisible(true);

		/**
		 * 완료 버튼 클릭 시 작성된 팀원 모집 정보를 처리합니다.
		 * 
		 * @since 0.5
		 * @param e 이벤트 객체
		 */
		plus.addActionListener(e -> {
			// 작성된 팀원 모집 정보를 처리하는 로직을 추가할 수 있습니다.
		});
	}

	/**
	 * 프로그램의 진입점입니다. 게시판 인터페이스를 생성합니다.
	 * 
	 * @param args 실행 인자
	 * @since 2024-11-18 (버전 0.5)
	 */
	public static void main(String[] args) {
		new board1();
	}
}
