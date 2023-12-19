package community_pack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

class OXQuiz {
	// 퀴즈, 정답, 해설을 저장할 리스트들과 Scanner 인스턴스 선언
   List<String> question = new ArrayList<>();
   List<Boolean> answer = new ArrayList<>();
   List<String> commentary = new ArrayList<>();
   Scanner scanner = new Scanner(System.in);
   
   // 퀴즈 추가 메서드
   public void addQuestion(String questions,Boolean answers, String comment) {
      question.add(questions);
      answer.add(answers);
      commentary.add(comment);
   }
   
   public void addQuestionMessage() {
       try {
    	// 사용자 입력을 받아 퀴즈, 답, 해설을 추가
           System.out.print("문제를 입력하세요 : ");
           String quizMessage = scanner.nextLine();

           System.out.print("답읍 입력하세요(정답=true,오답=false) : ");
           Boolean quizAnswer = scanner.nextBoolean();

           System.out.print("해설을 입력하세요: ");
           scanner.nextLine(); // Consume the newline character
           String comment = scanner.nextLine();

           addQuestion(quizMessage, quizAnswer, comment);

           System.out.println("문제 입력 완료");
       } catch (java.util.InputMismatchException e) {
           System.out.println("잘못된 입력 형식입니다. 퀴즈 추가를 취소합니다.");
           scanner.nextLine(); // 잘못된 입력을 소비하여 무한 루프를 방지
       }
   }
   
   // 퀴즈 목록을 출력하는 메서드
   public void displayQuiz() {
      System.out.println("\n<퀴즈 목록>");
      for(int i=0; i<question.size(); i++) {
         System.out.println("문제 " + (i+1) + ": " + question.get(i));
         System.out.println("답 " + ": " + answer.get(i));
         System.out.println("해설: " + commentary.get(i));
         System.out.println();
      }
   }
   
   // 20개의 사전 퀴즈 추가
   public void preQuiz20() {
       addQuestion("가방이나 지갑을 외부에 놓고 두는 것은 안전하다. (O/X)", false, "가방이나 지갑은 외부에 두면 도난의 위험이 있습니다.");
       addQuestion("밤에 혼자 걷거나 달리는 것은 안전하다. (O/X)", false, "밤에 혼자 외출할 때는 주의가 필요합니다.");
       addQuestion("자주 변경하지 않는 간단한 비밀번호를 사용하는 것이 안전하다. (O/X)", false, "비밀번호는 자주 변경하고 복잡하게 설정하는 것이 좋습니다.");
       addQuestion("낯선 이메일 첨부 파일을 열어보는 것은 안전하다. (O/X)", false, "낯선 이메일의 첨부 파일은 보안 문제가 있을 수 있습니다.");
       addQuestion("집에 있는 대부분의 문을 열어두는 것이 좋다. (O/X)", false, "집에 있는 문을 열어두면 침입의 위험이 있습니다.");
       addQuestion("야간에 화차한 곳에서 스마트폰 사용하는 것은 안전하다. (O/X)", false, "야간에는 화차한 장소에서 스마트폰 사용을 피하는 것이 좋습니다.");
       addQuestion("거리에서 휴대폰 사용 시 주위를 잘 살피는 것이 안전하다. (O/X)", true, "거리에서 휴대폰 사용할 때는 주변을 주의 깊게 살핍니다.");
       addQuestion("금융 거래에서 동일한 비밀번호를 여러 곳에서 사용하는 것이 안전하다. (O/X)", false, "다른 금융 거래에는 각각 다른 비밀번호를 사용하는 것이 안전합니다.");
       addQuestion("어린이의 인터넷 사용은 계속해서 감시되어야 한다. (O/X)", true, "어린이의 인터넷 사용은 지속적으로 감시하는 것이 부모의 역할입니다.");
       addQuestion("주거지 주변에 충분한 조명을 설치하는 것이 좋다. (O/X)", true, "주거지 주변에 충분한 조명을 설치하면 안전에 도움이 됩니다.");
       addQuestion("무단침입을 방지하기 위해 문을 잠그는 습관을 가져야 한다. (O/X)", true, "문을 잠그는 습관은 무단침입을 방지하는데 도움이 됩니다.");
       addQuestion("익숙하지 않은 사람에게 개인 정보를 알려주는 것은 안전하다. (O/X)", false, "개인 정보는 익숙하지 않은 사람에게 노출되면 안전에 위협이 됩니다.");
       addQuestion("길을 잃었을 때 낯선 사람에게 도움을 청하는 것이 안전하다. (O/X)", false, "길을 잃었을 때는 안전한 장소에서 도움을 요청하는 것이 좋습니다.");
       addQuestion("대중교통 이용 시 소중품은 가급적 가까운 곳에 보관하는 것이 안전하다. (O/X)", true, "대중교통에서는 소중품을 안전하게 보관하는 것이 중요합니다.");
       addQuestion("운전 중 스마트폰 사용은 안전하다. (O/X)", false, "운전 중에는 스마트폰 사용을 삼가고 안전 운전에 집중해야 합니다.");
       addQuestion("특별한 이유 없이 야간에 홀로 외출하는 것은 안전하다. (O/X)", false, "야간에는 특별한 이유 없이 홀로 외출하는 것은 자제하는 것이 좋습니다.");
       addQuestion("길에서 급한 일이 있을 때 낯선 사람에게 도움을 청하는 것이 안전하다. (O/X)", false, "길에서 급한 일이 생기면 신뢰할 수 있는 곳에서 도움을 요청하는 것이 좋습니다.");
       addQuestion("가방에 현금과 신용카드를 함께 보관하는 것이 안전하다. (O/X)", false, "가방에는 현금과 신용카드를 함께 보관하지 않는 것이 안전합니다.");
       addQuestion("익숙하지 않은 환경에서 혼자 외출하는 것은 안전하다. (O/X)", false, "익숙하지 않은 환경에서는 가능하면 동행하거나 주의가 필요합니다.");
       addQuestion("소란을 피우거나 유독물질을 섭취하는 것은 안전하다. (O/X)", false, "소란을 피우거나 유독물질을 섭취하는 것은 안전에 위협이 됩니다.");
   }

   // 퀴즈 번호를 랜덤하게 생성하는 메서드
   public List<Integer> quiznumRandom() {
      List<Integer> indexs = new ArrayList<>();
      
      for(int i=0; i<question.size(); i++) {
         indexs.add(i);
      }
      
      return indexs;
   }
   
   
   // 랜덤하게 선택된 5개의 퀴즈를 출제하는 메서드
   public void generateQuiz() {
       int count = 0;
       List<Integer> indexs = quiznumRandom();
       Collections.shuffle(indexs);
       
       System.out.println();
       for (int i = 0; i < 5; i++) {
           int index = indexs.get(i);

           System.out.print("문제 " + (i + 1) + ". " + question.get(index) + ": ");
           char useranswer = 0;

           try {
               useranswer = scanner.next().charAt(0);
           } catch (java.util.InputMismatchException e) {
               System.out.println("잘못된 입력 형식입니다. 퀴즈 게임을 종료합니다.");
               return;
           }

           if (useranswer == 'o' || useranswer == 'O' || useranswer == 'x' || useranswer == 'X') {
               boolean userBoolAnswer = (useranswer == 'o' || useranswer == 'O');

               if (userBoolAnswer == answer.get(index)) {
                   System.out.println("정답입니다!\n");
                   count++;
               } else {
                   System.out.println("오답입니다. 해설: " + commentary.get(index) + "\n");
               }
           } else {
               System.out.println("잘못된 입력입니다. 'O' 또는 'X'를 입력하세요. 퀴즈 게임을 종료합니다.");
               return;
           }
       }

       System.out.println("5문제 중에 " + count + "개 맞췄습니다!");
   }
   
   

}

//퀴즈 관리 클래스
public class SetyQuizManager {

    public void QuizController(boolean isAdmin,Scanner scanner) {
       OXQuiz quiz = new OXQuiz();

        quiz.preQuiz20(); // 20개 추가

        int choice = 0;

        while (true) {
            System.out.println("\n[범죄 퀴즈]");
            if (isAdmin) {
                System.out.println("1.퀴즈 게임  2.뒤로가기  3.전체 퀴즈 4.퀴즈 추가");
            } else {
                System.out.println("1.퀴즈 게임  2.뒤로가기");
            }
            System.out.print(">>> ");
            choice = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 처리

            switch (choice) {
                case 1:
                   quiz.generateQuiz(); // 퀴즈 게임 시작
                    break;
                case 2:
                   return;
                case 3:
                   if(isAdmin) {
                      quiz.displayQuiz();// 전체 퀴즈 출력
                   }
                   else {
                        System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                    }
                    break;
                case 4:
                   if (isAdmin) {
                        quiz.addQuestionMessage(); // 퀴즈 추가
                    } else {
                        System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                    }
                   break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        } 
    }
    
}

