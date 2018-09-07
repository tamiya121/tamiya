package ict.sp.test.ch3;

import org.springframework.stereotype.Service;

@Service
public class Pasta implements Food{

	@Override
	public void sell() {
		System.out.println("파스타를 팝니다.");
		
	}

	@Override
	public void buy() {
		System.out.println("파스타 재료를 삽니다.");

		
	}

}
