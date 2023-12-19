# SETY
<p align="center"><img height = "200px" width="300px" src="https://github.com/Stravinsken/Sety/assets/86868275/6749e6fa-da62-46c7-bc75-6b86e20dedcb"/></p>

프로젝트 개요
범죄 증가와 경찰 대응 한계로 불안감이 높아지고, 기존 앱 및 사이트의 기능 한계로 정보 부족 문제가 심화되는 상황에서, 이를 해결하기 위해실시간 정보 공유와 다양한 컨텐츠를 제공하는 SETY 커뮤니티 플랫폼을 개발하였습니다.

## 구현 코드 설명

### :police_car:sety
#### SetyMain.java
- SetyMain: 프로그램을 시작하는 메인 클래스
#### LoginProgram.java
- LoginProgram: SETY 어플리케이션의 사용자의 로그인, 회원가입, 로그아웃을 관리하고, 추가적으로 사용자들 간의 친구를 관리하는 기능이 구현되어 있는 중요한 클래스
### :couple:Community_pack
세부 컨트롤 클래스 및 기능을 담은 패키지입니다.
#### SetyMap.java
- SetyMap: SETY Map 웹페이지로 연결시키는 클래스
#### SetyEmergencyManager.java
- EmergencyReport: 긴급 신고에 대한 정보를 담는 클래스
-	EmergencyControl: 긴급 신고를 관리하고 출력하는 클래스
-	SetyEmergencyManager:: 긴급 신고 시스템을 제어하는 클래스
#### CommunityMain.java
-	CommunityMain: 커뮤니티를 제어하고 범죄 퀴즈, 범죄 뉴스, 통계 조회 기능을 제공하는 클래스
#### SetyQuizManager.java
-	OXQuiz: 퀴즈 정보를 관리하는 클래스
-	SetyQuizManager: 퀴즈 관련 기능을 제어하는 클래스
#### SetyNewsManager.java
-	News: 뉴스 정보를 관리하는 클래스
-	SetyNewsManager: 뉴스 관련 기능을 제어하는 클래스
#### SetyStatisticsManager.java
-	SetyStatisticsManager: 지역별 범죄율 통계를 관리하는 클래스

#### ~~추가적인 메서드에 대한 설명은 각 주석에다가 자세히 달아두었음.~~

## 실행 방법
1.	Java 개발 환경이 설치되어 있어야 합니다.
2.	각 클래스를 컴파일하고 실행합니다.
3.	‘SetyMain.java’를 실행하여 프로그램을 시작합니다.
4.	Console창에 보이는 번호를 입력해가며 원하는 대로 사용하면 됩니다.

## 실행 환경 설정
1.	Java 8 이상 설치 필요
2.	외부 라이브러리 또는 특별한 환경 설정은 필요하지 않습니다.

## 사용 예시
1.	회원가입: 프로그램을 실행한 후 ‘2. 회원가입’을 선택하여 새로운 사용자로 가입을 할 수 있습니다. 
2.	로그인: ‘1. 로그인’을 선택하여 등록된 계정으로 로그인을 합니다. (테스트 용으로 만든 임시 사용자 test1, test2는 각각 비밀번호가 1111이며, 회원을 관리하고 퀴즈나 뉴스를 추가할 관리자모드로 진입을 하려면 아이디와 비밀번호를 admin으로 진입하면 됩니다.)
3.	메인: 로그인 후에는 메인 메뉴로 세티맵 접속, 세티커뮤니티 접속, 긴급신고, 친구추가, 로그아웃 기능을 선택할 수 있습니다.
4.	세티맵: 이곳에서는 지도에서 신고된 정보를 확인하거나 추가할 수 있으며, 친구 추가된 회원들의 위치가 공유되어서 위급시에 도움을 줄 수 있다.
5.	세티커뮤니티: 범죄 퀴즈, 범죄 뉴스, 지역별 범죄율 통계를 볼 수 있습니다.

## 프로젝트 개발자
- 양지우, 박찬희, 이서영, 한태경
