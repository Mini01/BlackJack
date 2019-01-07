import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		
		System.out.println("���� ������ �����մϴ�."); 
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
			System.out.print("���ϴ� ��ŭ ī�带 �� ���� �� �ֽ��ϴ�. ī�带 ���������� 1�� �ƴϸ� �ƹ�Ű�� �Է����ֽʽÿ�.");
			System.out.println();
			if(!"1".equals(sc.nextLine())) { 
				break;
			}
			cnt++;
			service.getCard(user); 
			if(maxCnt<cnt) { 
				System.out.println("���� �� �ִ� �ִ� ī����� �ʰ��Ͽ����ϴ�."); 
				break; 
			}
		}
		service.defineWinner(dealer, user); 
		sc.close(); 
	}
}
