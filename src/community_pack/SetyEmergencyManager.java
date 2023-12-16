package community_pack;

import java.util.ArrayList;
import java.util.Scanner;

class EmergencyReport {
    String location;
    String situation;
    String time;

    public EmergencyReport(String location, String situation, String time) {
        this.location = location;
        this.situation = situation;
        this.time = time;
    }

    @Override
    public String toString() {   
        return "위치: " + location + "\n상황: " + situation + "\n시간: " + time;
    }
}

class EmergencyControl {
    static ArrayList<EmergencyReport> reports = new ArrayList<>();

    public void reportEmergency(Scanner scanner) {
        System.out.print("현재 위치: ");
        String location = scanner.nextLine();

        System.out.print("현재 상황: ");
        String situation = scanner.nextLine();

        System.out.print("현재 시간: ");
        String time = scanner.nextLine();

        EmergencyReport report = new EmergencyReport(location, situation, time);
        reports.add(report);

        System.out.println("긴급 신고가 접수되었습니다.");
    }

    public void showReports() {
        System.out.println("\n[긴급 신고 목록]");
        for (EmergencyReport report : reports) {
            System.out.println(report);
        }
    }
}

public class SetyEmergencyManager {
	
    public void emergencyController() {
        Scanner scanner = new Scanner(System.in);
        EmergencyControl control = new EmergencyControl();

        while (true) {
            System.out.println("\n[긴급 신고 시스템]\n1.긴급 신고\n2.신고 목록 보기\n3.뒤로가기");
            System.out.print(">>> ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            if (choice == 1) {
                control.reportEmergency(scanner);
            } else if (choice == 2) {
                control.showReports();
            } else if (choice == 3) {
                return;
            } else {
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            }
        }
    }
}