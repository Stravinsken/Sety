package sety;

import java.util.*;

import community_pack.*;
 
public class LoginProgram {
    private String id;
    private String password;
    private static final String ADMIN_ID = "admin";
    private static final String ADMIN_PASSWORD = "admin"; // 관리자 비밀번호 설정
    static boolean loginFlag = false;
    HashMap<String, HashSet<String>> friendTable = new HashMap<>(); // 친구 목록을 저장하는 HashMap
    HashMap<String,String> memberTable = new HashMap<String,String>(){{	//아이디와 비번을 저장하는 HashMap
    	put("test1", "1111");		//테스트용 회원
    	put("test2", "1111");
    }};								
    
    public void setId(String id) {
        this.id = id;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }
    
    //메뉴 출력 메소드
    public char display(Scanner scanner) {
        if(loginFlag) {
        	if (id.equals(ADMIN_ID) && password.equals(ADMIN_PASSWORD)) {
                System.out.println("\n[메인]\n1.세티맵 접속\n2.세티커뮤니티 접속\n3.긴급신고\n4.친구추가\n5.로그아웃\n6.회원 정보 확인");
            } else {
                System.out.println("\n[메인]\n1.세티맵 접속\n2.세티커뮤니티 접속\n3.긴급신고\n4.친구추가\n5.로그아웃");
            }
        }else {
        	System.out.println("1.로그인\n2.회원가입\n3.종료");
        }
        System.out.print(">>>");
        return scanner.nextLine().charAt(0);
    }
    
    //회원가입 메소드
    public void Join(Scanner scanner) {
        if (loginFlag) {
            System.out.println("자동로그아웃하고 새로운 회원가입을 시작합니다.");
            loginFlag = false;
        }
        while(true) {
            System.out.print("\n가입 id : ");
            String newId = scanner.nextLine();
            if(memberTable.containsKey(newId)) {
                System.out.println("이미 존재하는 아이디 입니다.\n");
                continue;
            }
            System.out.print("가입 pw : ");
            String newPwd = scanner.nextLine();
            memberTable.put(newId, newPwd);
            break;
        }
        System.out.println("저장 완료\n");
    }
    //로그인 메소드
    public void loginVaild() {
        if (loginFlag) {
            System.out.println("이미 로그인되어 있는 상태입니다.");
            return;
        }
    }    
    public void isMemberCheck(String id, String pw) {    
    	if (id.equals(ADMIN_ID) && pw.equals(ADMIN_PASSWORD)) {
            System.out.println("관리자로 로그인합니다.");
            loginFlag = true;
        } else if (memberTable.containsKey(id)) {
            if (!memberTable.get(id).equals(pw)) {
                System.out.println("비밀번호가 맞지 않습니다. 로그인 실패\n");
            } else {
                System.out.println("로그인 성공");
                loginFlag = true;
            }
        } else {
            System.out.println("존재하지 않는 아이디 입니다.\n");
        }
    }
    
    //로그아웃 메소드
    public void logout() {
        if (!loginFlag) {
            System.out.println("먼저 사용자 로그인이 필요합니다.\n");
            return;
        }
        System.out.println("로그아웃 합니다.\n");
        loginFlag = false;
    }
    
    //유저확인 메소드(관리자)
    public void adminViewMemberInfo() {
        if (loginFlag && id.equals(ADMIN_ID) && password.equals(ADMIN_PASSWORD)) {
            System.out.println("\n회원 정보 목록:");
            for (Map.Entry<String, String> entry : memberTable.entrySet()) {
                System.out.println("ID: " + entry.getKey() + ", Password: " + entry.getValue());
            }
        } else {
            System.out.println("관리자로 로그인해야 회원 정보를 확인할 수 있습니다.\n");
        }
    }

    //친구 기능
    public void Friend(Scanner scanner) {
    	
    	while(true) {
    		System.out.println("\n[SETY]\n1.친구추가\n2.친구목록\n3.뒤로가기");
        	System.out.print(">>>");
        	int choice = scanner.nextInt();
            scanner.nextLine(); // 정수 입력 뒤의 개행 문자 처리
        	if(choice == 1) {
        		addFriend(scanner);
        	}
        	else if(choice == 2){
        		getFriendList();
        	}
        	else if(choice == 3)
        		return;
        	else {
        		System.out.println("잘못 입력하셨습니다.");
        	}
    	}
    }
    
    // 친구 추가 메소드
    public void addFriend(Scanner scanner) {
        if (!loginFlag) {
            System.out.println("먼저 로그인해야 친구를 추가할 수 있습니다.");
            return;
        }

        System.out.print("\n추가할 친구의 아이디를 입력하세요: ");
        String friendId = scanner.nextLine();

        // 친구 아이디가 존재하는지 확인 후 친구 목록에 추가
        if (memberTable.containsKey(friendId)) {
            if (!memberTable.get(id).equals(friendId)) { // 자기 자신은 친구로 추가할 수 없도록
                HashSet<String> friendList = friendTable.getOrDefault(id, new HashSet<>());
                if (friendList.contains(friendId)) {
                    System.out.println(friendId + "님은 이미 친구 목록에 있습니다.");
                } else {
                    friendList.add(friendId); // 사용자의 친구 목록에 친구 추가
                    friendTable.put(id, friendList); // 업데이트된 친구 목록을 다시 저장
                    System.out.println(friendId + "님이 친구 목록에 추가되었습니다.");
                }
            } else {
                System.out.println("자신을 친구로 추가할 수 없습니다.");
            }
        } else {
            System.out.println("존재하지 않는 사용자입니다.");
        }
    }
    
    //친구목록 확인
    public void getFriendList() {
        if(loginFlag) {
            HashSet<String> friends = friendTable.getOrDefault(id, new HashSet<>());
            System.out.println("\n-----친구목록------");
            for (String friend : friends) {
                System.out.println(friend);
            }
        } else {
            System.out.println("로그인이 필요합니다.");
        }
    }
    
    //로그인UI
    public void loginController() {
    	SetyMap map = new SetyMap();
    	CommunityMain community = new CommunityMain();
    	SetyEmergencyManager emergency = new SetyEmergencyManager();
    	Scanner scanner = new Scanner(System.in);
        while (true) {
            char choice = display(scanner);
            
            switch (choice) {
            case '1':
                if (loginFlag) {
                	map.WebJoin();			//로그인이 되어있는 경우 1번을 누르면 세티맵으로
                } else {
                    loginVaild();	//로그인 상태 체크	
                    if (!LoginProgram.loginFlag) {	//로그인이 되어 있지 않은 경우 1번을 누르면 로그인
                        System.out.print("\n아이디 입력 : ");
                        String myId = scanner.nextLine();
                        setId(myId);
                        System.out.print("비밀번호 입력 : ");
                        String myPw = scanner.nextLine();
                        setPassword(myPw);
                        isMemberCheck(getId(), getPassword());
                    }
                }
                break;
            case '2':
            	 if (loginFlag) {
            		 community.communityController(id.equals(ADMIN_ID));	//로그인이 되어있는 경우 2번을 누르면 세티커뮤니티로
                 } else {
                     Join(scanner);		//로그인이 안되어있는 경우 2번을 누르면 회원가입으로
                 }
                break;
            case '3':
            	if (loginFlag) {
            		emergency.emergencyController();		//로그인이 되어 있는 경우 3번을 누르면 긴급신고
                }else {
                	System.exit(0);			//로그인이 안되어있는 경우 3번을 누르면 종료
                }
                break;
            case '4':
            	if(loginFlag) {
            		Friend(scanner);		//로그인이 되어있는 경우 4번을 누르면 친구창으로
            		break;
            	}else {
            		System.out.println("잘못된 값 입력");	//로그인이 안되어 있는 경우 4번을 누르면 오류출력
                    break;
            	}
            case '5':
            	if(loginFlag) {
            		logout();		//로그인이 되어 있는 경우 5번을 누르면 로그아웃
            		break;
            	}else {
            		System.out.println("잘못된 값 입력");	//로그인이 안되어 있는 경우 5번을 누르면 오류출력
                    break;
            	}
            case '6':
                if (loginFlag && id.equals(ADMIN_ID) && password.equals(ADMIN_PASSWORD)) {
                	adminViewMemberInfo();			//어드민인 경우 가입된 회원정보를 확인 할 수 있다.
                } else {
                    System.out.println("잘못된 값 입력");		
                }
                break;
            default:
                System.out.println("잘못된 값 입력\n");	//다른 번호 입력시 에러출력
                break;
            }
        }
    }
}
	