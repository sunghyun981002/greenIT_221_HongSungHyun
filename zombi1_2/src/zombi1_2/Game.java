package zombi1_2;

import java.util.*;

public class Game {
	Scanner s = new Scanner(System.in);
	Random r = new Random();
	Game(){
		while(true) {
			System.out.println("[개쩌는 던전]");
			System.out.print("1.게임시작\n2.저장하기\n0종료\n메뉴선택: ");
			int sel =s.nextInt();
			
			if(sel==1)run();
			else if(sel==2) {}
			else if(sel==0) break;
			
		}
		
	}


	public void run() {
		
		Hero hero = new Hero(1, 200, 20, 2);
		Zombi zom = new Zombi(5, 100, 10);
		Boss boss = new Boss(9, 300, 20, 100);


		
		int pos = 0;
		hero.setPos(pos);
		while (true) {
			for(int i=0; i<10; i++) {
				if(i==pos) {
					System.out.print("왓");
				}
				else if(i==5 || i==9) {
					System.out.print("♨_");
				}
				else {
					System.out.print("__");
				}
				
			}
//			System.out.println("현재 위치 = " + pos);

			System.out.println();
			System.out.print("앞으로 이동하기(1),종료하기(2) ");

			int move = s.nextInt();

			if (move == 1) {
				pos = pos + 1;
				hero.setPos(pos);

				if (hero.getPos() == 5) {

					System.out.println("좀비를 만났습니다. 공격모드로 바뀝니다.");
					System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★");

					while (true) {
//
						System.out.println("_____왓____못________");
						System.out.print("공격하기(1),포션마시기(2): ");
						int d = s.nextInt();

						if (d == 1) {
							System.out.println("_____옷+-못__________");
							zom.attack(hero); 						

							hero.attack(zom); 
					
						}

						else if (d == 2) {
							System.out.println("_____옷ㅂ___못________");
							hero.recovery();
						}
						if (hero.getHp() <= 0) {
							System.out.println("Hero가 죽었습니다. 게임에서 졌습니다.” ");
							break;
						}

						if (zom.getHp() <= 0) {
							System.out.println("좀비/보스를 이겼습니다. 이동할 수 있습니다");
							break;
						}
					}
					System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★");

				}
				if (hero.getPos() == 9) {

					System.out.println("보스를 만났습니다. 공격모드로 바뀝니다. ");
					System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★");
					while (true) {
						System.out.println("_____왓____)뽓(________");
						System.out.print("공격하기(1),포션마시기(2): ");
						int d = s.nextInt();

						if (d == 1) {
							System.out.println("______옷+-)뽓(___________");
							boss.attack(hero); 					
							hero.attack(boss); 

						}
						
						if (d == 2) {
							System.out.println("_____옷ㅂ____)뽓(________");
							hero.recovery();
						}

						if (hero.getHp() <= 0) {
							System.out.println("_____oㅓ<____뽓________");
							System.out.println("Hero가 죽었습니다. 게임에서 졌습니다.” ");
							break;

						}
						if (boss.getHp() <= 0) {
							System.out.println("_____왓_____>ㅏk________");
							System.out.println("보스를 이겼습니다.");
							break;

						}

					}
					System.out.println("★★★★★★★★★★★★★★★★★★★★★★★★");

				}
				if (hero.getPos() == 10) {
					System.out.println("게임에서 승리했습니다. 종료합니다.");
					break;
				}

			} else if (move == 2) {
				break;
			}

		}
	}

}
