package game;

public class StageTitle extends Stage {

	@Override
	public boolean update() {
		System.out.println("==== TEXT RPG ====");
		System.out.println("[시작] 을 입력하세요");
		String start = Game.instance.scan.next();
		if (start.equals("시작")) {
			GameManager.nextStage = "LOBBY";
			return false;
		}
		return true;
	}

	@Override
	public void init() {

	}

}
