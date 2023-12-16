package community_pack;

import java.util.Scanner;

public class SetyStatisticsManager {			//범죄 통계 관리 클래스
	
	public void statisticsController() {		// 사용자가 통계를 조회하고 선택하는 메서드
		 Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("\n[지역별 범죄율 통계]\n1.전체 통계\n2.지역별 통계\n3.뒤로가기");
	            System.out.print(">>> ");
	            int choice = scanner.nextInt();

	            switch (choice) {
                case 1:
                    showOverallStatistics(scanner);
                    break;
                case 2:
                    showCityStatistics(scanner);
                    break;
                case 3:
                    System.out.println("메인 메뉴로 돌아갑니다.");
                    return; // 메인 메뉴로 돌아가기
                default:
                    System.out.println("잘못된 선택입니다.");
                    break;

	           }
	        } 
	}
	
	public void showOverallStatistics(Scanner scanner) {
		// 전체 통계 데이터 출력
		System.out.println("[전체 통계]");
        System.out.println("서울특별시: 7.9, 부산광역시: 3.4, 대구광역시: 3.5");

	}
	
	public void showCityStatistics(Scanner scanner) {
		//도시별 통계 출력
		System.out.println("[지역별 통계]");
        System.out.println("1. 서울특별시");
        System.out.println("2. 부산광역시");
        System.out.println("3. 대구광역시");
        // ... 나머지 도시 목록
        System.out.print(">>> ");
        int cityChoice = scanner.nextInt();

        switch (cityChoice) {
            case 1:
                System.out.println("[서울특별시 통계]");
                System.out.println("2020년: 3.4, 2021년: 5.7, 2022년: 7.9");
                break;
            case 2:
                System.out.println("[부산광역시 통계]");
                System.out.println("2020년: 2.9, 2021년: 3.4, 2022년: 6.5");
                break;
            case 3:
                System.out.println("[대구광역시 통계]");
                System.out.println("2020년: 4.5, 2021년: 3.1, 2022년: 4.5");
                break;
            // ... 나머지 도시에 대한 케이스
            default:
                System.out.println("잘못된 선택입니다.");
                break;
        }
	}
}
