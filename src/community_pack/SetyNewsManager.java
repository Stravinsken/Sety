package community_pack;

import java.util.*;

class News {
    private static Map<String, List<News>> newsMap = new HashMap<>();
    private String title;
    private String content;
    private String date;
    
    
    
    public News(String title, String content, String date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }
    
    // 초기 뉴스 추가를 위한 메서드
    public static void initializeNews() {
       List<News> violentCrimesNews = new ArrayList<>();
        violentCrimesNews.add(new News("도심에서 발생한 익사사건", "어제 밤 도심에서 발생한 익사사건으로, 한 시민이 알 수 없는 이유로 폭행을 당하다가 익사했습니다. 경찰은 용의자를 신속히 검거했으며, 수사 중에 있습니다.","23-01-19"));
        violentCrimesNews.add(new News("가정폭력 사건", "오늘 새벽 가정폭력 사건이 발생해 이웃에게 도움을 요청한 피해자가 발견되었습니다. 경찰은 가해자를 구속하고 피해자에 대한 보호 조치를 취하고 있습니다.","23-03-13"));
        violentCrimesNews.add(new News("음주운전으로 발생한 교통사고", "음주운전으로 인한 교통사고가 발생해 한 명이 사망하고 두 명이 중상을 입었습니다. 용의자는 법정에서 엄격한 처벌을 받을 예정입니다.","23-05-19"));

        newsMap.put("Violent Crimes", violentCrimesNews);

        // 재산 범죄 카테고리
        List<News> propertyCrimesNews = new ArrayList<>();
        propertyCrimesNews.add(new News("유명 아티스트의 아트 갤러리 강도사건", "유명 아티스트의 아트 갤러리가 강도에 희생되었습니다. 작품들이 피해를 입었으며, 경찰은 CCTV 영상을 토대로 범인을 찾기 위한 수사를 진행 중입니다.","23-11-13"));
        propertyCrimesNews.add(new News("주택 절도 사건 급증", "최근 주택 절도 사건이 급증하고 있어 경찰이 지역 주민들에게 조심을 당부하고 있습니다. 주민들은 이상한 동작이나 소리가 있을 경우 즉시 신고할 것을 권고하고 있습니다.","23-02-23"));
        propertyCrimesNews.add(new News("대형 쇼핑몰에서의 신용카드 사기 사건", "대형 쇼핑몰에서 발생한 신용카드 사기 사건으로 경찰이 수사에 착수했습니다. 피해자들은 사기꾼들에게 개인 정보를 빼앗기고 큰 금액을 잃은 상태입니다.","23-10-01"));

        newsMap.put("Property Crimes", propertyCrimesNews);

        // 사이버 범죄 카테고리
        List<News> cyberCrimesNews = new ArrayList<>();
        cyberCrimesNews.add(new News("글로벌 은행 해킹 사건", "국제적인 은행이 해킹에 휩쓸려 수십 억 달러가 유출되었습니다. 사건은 현재 국제 사이버수사팀에 의해 추적 중이며, 가해자들은 높은 수준의 전문성을 보이고 있습니다.","23-12-01"));
        cyberCrimesNews.add(new News("소셜미디어 계정 해킹 증가", "소셜미디어 계정 해킹 사건이 급증하고 있어 사용자들은 개인 정보 유출을 우려하고 있습니다. 피해자들은 보안 강화를 위해 다양한 조치를 취하고 있습니다.","23-10-31"));
        cyberCrimesNews.add(new News("기업 데이터 유출 사건으로 인한 손실 확대", "대형 기업이 고객 데이터 유출로 인해 손실이 확대되고 있습니다. 기업은 피해 복구를 위해 사이버 보안 전문가들과 협력하고 있으며, 수사 기관은 가해자의 신속한 검거를 위해 노력 중입니다.","23-10-29"));

        newsMap.put("Cyber Crimes", cyberCrimesNews);

        // 마약 범죄 카테고리
        List<News> drugCrimesNews = new ArrayList<>();
        drugCrimesNews.add(new News("마약밀수 성공 시도", "국제 마약 밀수단이 시도한 마약 밀수 작전이 경찰의 반격으로 실패로 돌아갔습니다. 대규모의 마약이 압수되었고, 용의자들은 체포되어 수사 중에 있습니다.","23-05-30"));
        drugCrimesNews.add(new News("도심에서 마약 거래 적발", "도심에서 발생한 마약 거래가 적극적인 경찰 대응에 의해 성공적으로 체포되었습니다. 거래에 참여한 용의자들은 현재 마약 관련 형사 처벌을 받고 있습니다.","23-02-11"));
        drugCrimesNews.add(new News("대규모 마약 조직 쓰러뜨리기 성공", "대규모 마약 조직을 쓰러뜨리기 위한 경찰 작전이 성공적으로 진행되었습니다. 수십명의 용의자가 체포되어 수사 중에 있으며, 작전은 국제적인 협력을 통해 이루어졌습니다.","23-12-26"));

        newsMap.put("Drug Crimes", drugCrimesNews);
    }
    
    // 사용자가 입력한 뉴스를 추가하는 메서드
    public static void addNews(String category, String title, String content, String date) {
        News userNews = new News(title, content, date);

        // 카테고리가 존재하면 해당 카테고리에 뉴스 추가, 없으면 새로운 카테고리 생성
        if (newsMap.containsKey(category)) {
            newsMap.get(category).add(userNews);
        } else {
            List<News> newList = new ArrayList<>();
            newList.add(userNews);
            newsMap.put(category, newList);
        }

        System.out.println("사용자가 제보한 뉴스가 추가되었습니다.");
    }

    // 특정 카테고리의 뉴스를 출력하는 메서드
    public static void displayNews(String category) {
        List<News> newsList = newsMap.get(category);

        if (newsList != null) {
            System.out.println("\n<" + category + ">");
            for (News news : newsList) {
                System.out.println("제목: " + news.getTitle() + " [" + news.getDate() + "]");
                System.out.println("내용: " + news.getContent());
                System.out.println();
            }
        } else {
            System.out.println("해당 카테고리의 뉴스가 없습니다.");
        }
    }

    // 모든 뉴스를 출력하는 메서드
    public static void displayAllNews() {
        System.out.println("\n[모든 뉴스]");
        for (Map.Entry<String, List<News>> entry : newsMap.entrySet()) {
            String category = entry.getKey();
            List<News> newsList = entry.getValue();

            System.out.println("[" + category + "]");
            for (News news : newsList) {
                System.out.println("제목: " + news.getTitle() + " [" + news.getDate() + "]");
                System.out.println("내용: " + news.getContent());
                System.out.println();
            }
        }
    }

    // 카테고리 선택을 위한 메서드
    public static String categoryChoice(int category) {
        switch (category) {
            case 1:
                return "Violent Crimes";
            case 2:
                return "Property Crimes";
            case 3:
                return "Cyber Crimes";
            case 4:
                return "Drug Crimes";
            default:
                return "";
        }
    }

    // 사용자가 뉴스를 추가하는 시스템 메서드
    public static void addNewsSystem(Scanner scanner) {
       
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter content: ");
        String content = scanner.nextLine();

        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.next();

        System.out.println("1.폭력 범죄 2.재산 범죄 3.사이버 범죄 4.마약 범죄");
        System.out.print(">>>");
        int choice = scanner.nextInt();
        if(choice <1 || choice > 4) {
        	System.out.println("잘못된 입력입니다.\n");
        	return;
        }
        String category = categoryChoice(choice);

        addNews(category, title, content, date);
    }
    
}

//뉴스 관리 클래스
public class SetyNewsManager {	

	public void NewsController(boolean isAdmin, Scanner scanner) {
        
        News.initializeNews();	//초기 뉴스 추가
        boolean running = true;

        while (running) {
        	System.out.println("\n[범죄 뉴스]");
        	if(isAdmin) {
        		System.out.println("1.카테고리 선택 2.전체 뉴스 3.뒤로가기 4.뉴스 추가");
        	}else {
        		System.out.println("1.카테고리 선택 2.전체 뉴스 3.뒤로가기");
        	};
            System.out.print(">>>");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 정수 입력 뒤의 개행 문자 처리
            

            switch (choice) {
                case 1:
                	// 카테고리 선택하여 해당 카테고리의 뉴스 출력
                    System.out.println("\n1.폭력 범죄 2.재산 범죄 3.사이버 범죄 4.마약 범죄");
                    System.out.print(">>>");
                    int categoryChoice = scanner.nextInt();
                    scanner.nextLine();
                    String category = News.categoryChoice(categoryChoice);
                    News.displayNews(category);
                    break;
                case 2:
                	// 모든 뉴스 출력
                    News.displayAllNews();
                    break;
                case 3:
                	// 이전 메뉴로 돌아가기
                	running = false;
                    return;
                case 4:
                	if(isAdmin)	//어드민인 경우 뉴스 추가
                		News.addNewsSystem(scanner);
                	else
                		System.out.println("잘못된 선택입니다. 다시 선택하세요.");
                	break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택하세요.");
                    break;
            }
        }

        scanner.close(); 
    }
}