package kh.edu.updown.model.service;

import java.util.List;
import java.util.Scanner;

import kh.edu.updown.model.vo.Member;

public class LoginService {
	
	private Scanner sc = new Scanner(System.in);

	public void startGame(Member loginMember) {
		
		// 업다운 게임 시작
		System.out.println("[Game Start...]");
		
		int count = 0;
		
		// 1 ~ 100 사이 숫자 중 랜덤하게 한 숫자를 지정하고 업/다운 게임을 진행
		int random = (int)(Math.random()*100 + 1);
		
		while(true) {

			System.out.print((count+1) + "번째 입력 : ");
			int input = sc.nextInt();
			sc.nextLine();
			
			count++;
			
			if(input > random) {
				System.out.println("-- DOWN --");
				continue;
				
			} else if(input < random) {
				System.out.println("-- UP --");
				continue;
				
			} else if(input == random) {
				System.out.println("정답!!");
				System.out.println("입력 시도 횟수 : " + count);
				
				// 맞춘 횟수가 현재 로그인한 회원의 최초 또는 최고 기록인 경우 회원의 highScore 필드 값을 변경
				if(count < loginMember.getHighScore()) {
					System.out.println("*** 최고 기록 달성 ***");
					loginMember.setHighScore(count);
				}
				
				break;
			}
			
		}
		
	}

	
	// 내 정보 조회
	// 로그인한 멤버의 정보 중 비밀번호를 제외한 나머지 정보만 화면에 출력
	public void selectMyInfo(Member loginMember) {
		
		System.out.println("[내 정보 조회]");
		
		System.out.println("아이디 : " + loginMember.getMemberId());
		System.out.println("이름 : " + loginMember.getMemberName());
		System.out.println("최고 점수 : " + loginMember.getHighScore());
	}

	// 전체 회원 조회
	// 전체 회원의 아이디, 이름, 최고점수를 출럭
	public void selectAllMember(Member[] members) {
		
		System.out.println("[전체 회원 조회]");
		
		int index = 0;
		
		if(members[0] == null) {
			System.out.println("회원 정보가 없습니다.");
			return;
		}
		
		for(Member member : members) {
			if(member != null) {
				System.out.println("[" + (index++) + "번]");
				System.out.println("아이디 : " + member.getMemberId());
				System.out.println("이름 : " + member.getMemberName());
				System.out.println("최고 점수 : " + member.getHighScore());
			}
		}
		
	}

	// 비밀번호 변경
	// 현재 비밀번호를 입력 받아 
	// 같은 경우에만 새 비밀번호를 입력 받아 비밀번호 변경
	public void updatePassword(Member loginMember) {
		
		System.out.println("[비밀번호 변경]");
		
		System.out.print("비밀번호 입력 : ");
		String inputPw = sc.nextLine();
		
		if(loginMember.getMemberPw().equals(inputPw)) {
			System.out.print("새로운 비밀번호 입력 : ");
			String newPw = sc.nextLine();
			
			loginMember.setMemberPw(newPw);
			
			System.out.println("비밀번호 변경이 완료되었습니다.");
		}
		
	}

	
	
}
