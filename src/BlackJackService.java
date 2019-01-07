import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BlackJackService {
	private Random r;  // ���� ����
	private static final int maxCardNo = 52;  // 52��°����� ���̻� �ٲ����ʴ� ����ξ���. 
	Scanner sc; // ��ĳ�� ����
	List<Integer> cardList; // �ߺ����Ÿ����� ����Ʈ
	
	
	public BlackJackService() {   // �������� �ʱ�ȭ
		r = new Random(); 
		sc = new Scanner(System.in); 
		cardList = new ArrayList<Integer>(); 
	}
	public boolean existsCard(int cardNo) {
		for(int i=0; i<cardList.size(); i++) {   //���� ī�帮��Ʈ�ȿ��� ���λ��� ī��� ������ ī�尡������ �ٽṵ̂��Ѵ�.
			if(cardList.get(i)==cardNo) { 
				return true;
			}
		}
		return false; 
	}
	public UserVO getCard(UserVO vo) { 
		if(vo.getUserid() != 1) { 
			System.out.println("��������̹Ƿ� ī�带 �̾��ֽʽÿ�(ī�带 �����÷��� �ƹ�Ű�� �Է����ֽʽÿ�.)");
			sc.nextLine();
		}
		int card = r.nextInt(maxCardNo);// 0~51���� ������ card�� ������ ����  
		while(existsCard(card)) { 
			card = r.nextInt(maxCardNo);
		}
		vo.addCard(card); // ����ī�带 �����Ѵ�. 
		cardList.add(card); // �ߺ��������ؾ��ϹǷ� ī�帮��Ʈ���� ����
		if(vo.getUserid() == 1) { 
			System.out.println("������ ī�带 �̾ҽ��ϴ�."); 
		}else { 
			vo.printCardList(); 
		}
		return vo; 
	}
	public void defineWinner(UserVO dealer, UserVO user) { 
		if(checkMaxScore(dealer)) { // CheckMaxScore = ��Ż���ھ 21�̸��̸� ����ǥ���ϰ� �ʰ��ϸ� ������ǥ���ض�. 
			System.out.println("������ 21�� �ʰ��Ͽ� ����� �̰���ϴ�.");  
			dealer.printCardList();
			user.printCardList(); 
			System.exit(0); 
		}else if(checkMaxScore(user)) { 
			System.out.println("����� 21�� �ʰ��Ͽ� �й��Ͽ����ϴ�.");  
			dealer.printCardList();
			user.printCardList();  
			System.exit(0); // 
		}
		int dealerScore = 21-dealer.getTotalScore();  
		int userScore = 21-user.getTotalScore(); 
		if(dealerScore == userScore ) { 
			System.out.println("�����ϴ�");
		}else if(dealerScore>userScore) { 
			System.out.println("����� �̰���ϴ�.");
			
		}else {	 
			System.out.println("����� �й��Ͽ����ϴ�.");
		}
		dealer.printCardList(); 
		user.printCardList(); 
		System.exit(0); 
	}
	public boolean checkMaxScore(UserVO vo)  {
		int totalScore = vo.getTotalScore();
		if(totalScore>21) {  // ��Ż���ھ 21�̸��̸� ����ǥ���ϰ� �ʰ��ϸ� ������ǥ���ض�.
			return true;
		}
		return false;
	}
}
