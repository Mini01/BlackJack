import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BlackJackService {
	private Random r;  // 랜덤 변수
	private static final int maxCardNo = 52;  // 52라는값에서 더이상 바꾸지않는 상수로쓴다. 
	Scanner sc; // 스캐너 변수
	List<Integer> cardList; // 중복제거를위한 리스트
	
	
	public BlackJackService() {   // 변수들의 초기화
		r = new Random(); 
		sc = new Scanner(System.in); 
		cardList = new ArrayList<Integer>(); 
	}
	public boolean existsCard(int cardNo) {
		for(int i=0; i<cardList.size(); i++) {   //뽑은 카드리스트안에서 새로뽑은 카드와 동일한 카드가있으면 다시뽑게한다.
			if(cardList.get(i)==cardNo) { 
				return true;
			}
		}
		return false; 
	}
	public UserVO getCard(UserVO vo) { 
		if(vo.getUserid() != 1) { 
			System.out.println("당신차례이므로 카드를 뽑아주십시오(카드를 뽑으시려면 아무키나 입력해주십시오.)");
			sc.nextLine();
		}
		int card = r.nextInt(maxCardNo);// 0~51까지 랜덤을 card의 변수에 담음  
		while(existsCard(card)) { 
			card = r.nextInt(maxCardNo);
		}
		vo.addCard(card); // 뽑은카드를 저장한다. 
		cardList.add(card); // 중복을제거해야하므로 카드리스트에도 저장
		if(vo.getUserid() == 1) { 
			System.out.println("딜러가 카드를 뽑았습니다."); 
		}else { 
			vo.printCardList(); 
		}
		return vo; 
	}
	public void defineWinner(UserVO dealer, UserVO user) { 
		if(checkMaxScore(dealer)) { // CheckMaxScore = 토탈스코어가 21미만이면 참을표시하고 초과하면 거짓을표시해라. 
			System.out.println("딜러가 21을 초과하여 당신이 이겼습니다.");  
			dealer.printCardList();
			user.printCardList(); 
			System.exit(0); 
		}else if(checkMaxScore(user)) { 
			System.out.println("당신은 21을 초과하여 패배하였습니다.");  
			dealer.printCardList();
			user.printCardList();  
			System.exit(0); // 
		}
		int dealerScore = 21-dealer.getTotalScore();  
		int userScore = 21-user.getTotalScore(); 
		if(dealerScore == userScore ) { 
			System.out.println("비겼습니다");
		}else if(dealerScore>userScore) { 
			System.out.println("당신이 이겼습니다.");
			
		}else {	 
			System.out.println("당신은 패배하였습니다.");
		}
		dealer.printCardList(); 
		user.printCardList(); 
		System.exit(0); 
	}
	public boolean checkMaxScore(UserVO vo)  {
		int totalScore = vo.getTotalScore();
		if(totalScore>21) {  // 토탈스코어가 21미만이면 참을표시하고 초과하면 거짓을표시해라.
			return true;
		}
		return false;
	}
}
