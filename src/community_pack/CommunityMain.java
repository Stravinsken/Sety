package community_pack;

import java.util.Scanner;

import sety.*;

public class CommunityMain extends LoginProgram{
	
	// 커뮤니티 메인 화면 제어하는 메서드
    public void communityController(boolean isAdmin){
    	SetyQuizManager quiz = new SetyQuizManager();
    	SetyNewsManager news = new SetyNewsManager();
    	SetyStatisticsManager statistics = new SetyStatisticsManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n[세티 커뮤니티]\n1.범죄 퀴즈\n2.범죄 뉴스\n3.지역별 범죄율 통계\n4.뒤로가기");
            System.out.print(">>>");
            String choice = scanner.nextLine();

            if(choice.equals("1")) {
                quiz.QuizController(isAdmin, scanner);	// 범죄 퀴즈 관리자 선택 시 실행
            }else if (choice.equals("2")) {
            	news.NewsController(isAdmin, scanner);	// 범죄 뉴스 관리자 선택 시 실행
            }else if(choice.equals("3")){
            	statistics.statisticsController();	// 지역별 범죄율 통계 선택 시 실행
            }else if(choice.equals("4")){
            	return;	// 이전 메뉴로 돌아가기
            }else {
                System.out.println("잘못된 선택입니다.");	// 잘못된 입력 처리
            }
        }
    }
}