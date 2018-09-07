package ict.sp.test.ch1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("cg")
public class ConsoleGame {
	
	@Autowired
	List<Game> gameList;
	
	public void test() {
		for(Game g : gameList) {
			g.start();
			g.attack();
			g.jump();
			g.end();
			
		}
	}
	
	private Game game;
	
	public ConsoleGame() {
		System.out.println("난 파싱 후 겟반할 때 호출");
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public void on() throws Exception {
		if(game==null) {
			throw new Exception("어휴 게임팩이 없네요~");
		}
		System.out.println("로딩 완료!");
	}
	
	public void startGame() {
		game.start();
		game.attack();
		game.jump();
		
	}
	
	public void off() {
		game.end();
	}
}




//클래스변수(static)
//멤버변수
//인스턴스변수(
//지역변수
