package game;

public class StageLobby extends Stage{

	@Override
	public boolean update() {
		System.out.println("=====[LOBBY]=====");
		System.out.println("[1.전투] [2.종료]");
		int sel = Game.instance.scan.nextInt();
		if (sel == 1) {
			HuntManager.nextStage = "BATTLE";
		} else if (sel == 2) {
			HuntManager.nextStage = "";
		} else {
			HuntManager.nextStage = "";
		}
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
