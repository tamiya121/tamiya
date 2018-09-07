package ict.sp.test.ch3;

import org.springframework.stereotype.Service;

@Service
public class Pizza implements Food{

	@Override
	public void sell() {
		System.out.println("피자를 팝니다.");
	}

	@Override
	public void buy() {
		System.out.println("피자 재료를 삽니다");
		
	}

}
