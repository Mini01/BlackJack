import java.util.Arrays;

public class UserVO {   //VO���� 
	private int userid;
	private int[] cardList;
	private int cardCnt;
	
	
	public UserVO(int userid) {       
		this.userid = userid; 
		this.cardList = new int[10];  // ��������� 10���� �Ҵ��Ѵ�.
		this.cardCnt = 0;  
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}

	
	
	public void addCard(int card) {   
		cardList[cardCnt] = card; // ī�帮��Ʈ���� ī��Ʈ�� �Ѱ������� 
		cardCnt++;
	}
	public void printCardList() { 
		if(userid==1) {  
			System.out.println("������ ī�� ��� : "); 
		}else {
			System.out.println("����� ī�� ��� : "); 
		}
		for(int i=0; i<cardCnt; i++) { 
			System.out.println(getCardFullName(i));
		}
	}
	@Override
	public String toString() {
		return "UserVO [userid=" + userid + ", cardList=" + Arrays.toString(cardList) + "]";
	}
	public int getScore(int idx) {  
		int cardNo = cardList[idx];
		int score = 0;
		
		if(cardNo%13>9) { //����ī�带 13���γ����� ���������� 9���� ũ�� ������ 10�����ΰ���
			score = 10;
		}else {
			score = cardNo%13+1; // �ƴϸ� �װ��� +1���߰��ؼ� ǥ��
		}
		return score;
	}
	public String getCardName(int idx) { 
		int cardNo = cardList[idx];
     	String cardName = "";

			switch(cardNo%13) {     // ���� ī���� /13���ؼ� ��������
			case 0:
			cardName="A";  // 0�̳����� A��ǥ��
			break;
			case 10:
				cardName="J";  // 10�̳����� J��ǥ��
				break;
			case 11:
				cardName="Q"; // 11�������� Q��ǥ��
				break;
			case 12:
				cardName="K"; // 12�̳����� K��ǥ��
					break;
				default:
					cardName=(cardNo%13+1)+""; // �´� �ƴϸ� ���°��� +1���ؼ� ���
			}
		return cardName;
	}
	public String getCardImageName(int idx) { 
		int cardNo = cardList[idx];
		String cardName = "";
		switch(cardNo/13) {  // 13���γ����� 
			case 0:
				cardName="��"; // ���������ϸ� ��
				break;
			case 1:
				cardName="��"; // 1�γ������� ��
				break;
			case 2:
				cardName="��"; // 2�� �������� ��
				break;
			case 3:
				cardName="��"; // 3���� �������� �� 
				break;
			
		}
		return cardName;
		
	}
	public String getCardFullName(int idx) {
		return getCardImageName(idx)+getCardName(idx); // ����� ���� ���Ѵ�
	}
	public int getTotalScore() {  
		int totalScore = 0; 
		for(int i=0; i<cardCnt; i++) { 
			totalScore = getScore(i)+totalScore;  //����ī��� ��ŭ���Ѵ�
		}
		return totalScore; 
	}
}
