import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		
		System.out.println("블랙잭 게임을 시작합니다."); 
		BlackJackService service = new BlackJackService(); 
		Scanner sc = service.sc; 
		UserVO dealer = new UserVO(1); 
		UserVO user = new UserVO(2);  
		service.getCard(dealer); 
		service.getCard(user);
		service.getCard(dealer); 
		service.getCard(user); 
		if(dealer.getTotalScore()<=16) {  
			service.getCard(dealer); 
		}
		int maxCnt = 5;
		int cnt = 0;
		while(true) { 
			System.out.print("원하는 만큼 카드를 더 뽑을 수 있습니다. 카드를 더뽑으려면 1을 아니면 아무키나 입력해주십시오.");
			System.out.println();
			if(!"1".equals(sc.nextLine())) { 
				break;
			}
			cnt++;
			service.getCard(user); 
			if(maxCnt<cnt) { 
				System.out.println("뽑을 수 있는 최대 카드수를 초과하였습니다."); 
				break; 
			}
		}
		service.defineWinner(dealer, user); 
		sc.close(); 
	}
}
