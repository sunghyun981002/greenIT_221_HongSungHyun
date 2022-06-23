package game;

public class zombie extends Monster{
	zombie(){
		name = "좀비";
		power = Guild.instace.ran.nextInt(8)+1;
	}
	void skill() {
		System.out.println("한명에게 2배의 데미지 + 기절 ");

	}

}
