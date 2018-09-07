package ict.sp.test.ch1;

import org.springframework.stereotype.Service;

@Service("te")
public class Tekken extends Game{

	@Override
	public void attack() {
		System.out.println("철권이 공격합니다.");
		
	}

	@Override
	public void jump() {
		System.out.println("철권이 점프합니다.");
		
	}

}
