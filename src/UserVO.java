import java.util.Arrays;

public class UserVO {   //VO설정 
	private int userid;
	private int[] cardList;
	private int cardCnt;
	
	
	public UserVO(int userid) {       
		this.userid = userid; 
		this.cardList = new int[10];  // 저장공간을 10개를 할당한다.
		this.cardCnt = 0;  
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}

	
	
	public void addCard(int card) {   
		cardList[cardCnt] = card; // 카드리스트안의 카운트를 한개씩증가 
		cardCnt++;
	}
	public void printCardList() { 
		if(userid==1) {  
			System.out.println("딜러의 카드 목록 : "); 
		}else {
			System.out.println("당신의 카드 목록 : "); 
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
		
		if(cardNo%13>9) { //뽑은카드를 13으로나눠서 떨어진값이 9보다 크면 무조건 10점으로고정
			score = 10;
		}else {
			score = cardNo%13+1; // 아니면 그값에 +1을추가해서 표시
		}
		return score;
	}
	public String getCardName(int idx) { 
		int cardNo = cardList[idx];
     	String cardName = "";

			switch(cardNo%13) {     // 뽑은 카드의 /13을해서 남은값이
			case 0:
			cardName="A";  // 0이나오면 A를표시
			break;
			case 10:
				cardName="J";  // 10이나오면 J를표시
				break;
			case 11:
				cardName="Q"; // 11가나오면 Q를표시
				break;
			case 12:
				cardName="K"; // 12이나오면 K를표시
					break;
				default:
					cardName=(cardNo%13+1)+""; // 셋다 아니면 나온값에 +1을해서 출력
			}
		return cardName;
	}
	public String getCardImageName(int idx) { 
		int cardNo = cardList[idx];
		String cardName = "";
		switch(cardNo/13) {  // 13으로나눠서 
			case 0:
				cardName="◇"; // 나누지못하면 ◇
				break;
			case 1:
				cardName="♡"; // 1로나눠지면 ♡
				break;
			case 2:
				cardName="♧"; // 2로 나눠지면 ♧
				break;
			case 3:
				cardName="♤"; // 3으로 나눠지면 ♤ 
				break;
			
		}
		return cardName;
		
	}
	public String getCardFullName(int idx) {
		return getCardImageName(idx)+getCardName(idx); // 문양과 수를 더한다
	}
	public int getTotalScore() {  
		int totalScore = 0; 
		for(int i=0; i<cardCnt; i++) { 
			totalScore = getScore(i)+totalScore;  //뽑은카드수 만큼더한다
		}
		return totalScore; 
	}
}
