package game;

public class StageTitle extends Stage {

	@Override
	public boolean update() {
		System.out.println("==== TEXT RPG ====");
		System.out.println("[입장]을 입력하세요");
		String start = Game.instance.scan.next();
		if (start.equals("입장")) {
			HuntManager.nextStage = "LOBBY";
			return false;
		}
		return true;
	}

	@Override
	public void init() {

	}

}
