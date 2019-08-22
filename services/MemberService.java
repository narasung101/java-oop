package com.bitcamp.services;

import com.bitcamp.domains.MemberBean;
/**
 * 요구사항 (기능정의)
 * <사용자기능>
 * 1. 회원가입
 * 2. 마이페이지
 * 3. 비번 수정
 * 4. 회원탈퇴
 * **********
 * <관리자기능>
 * 5. 회원목록
 */
public class MemberService {
	private MemberBean[] members;
	private int count;
	
	public MemberService() {
		members = new MemberBean[2];
		count = 0;
	}
	
	public String join(MemberBean param) {
		String msg = "회원가입 성공";
		members[0] = param;
		count++;
		return msg;
	}
	
	public String getMyPage(MemberBean param) {
		String msg = "";
		return msg;
	}
	
	public String changePassword(MemberBean param) {
		String msg = "비밀번호 변경완료";
		return msg;
	}
	/**
	 *  4. 회원탈퇴
	 * */
    public String withDrawal(MemberBean param) {
    	String msg = "회원탈퇴 완료";
    	return msg;
    		
    }
    /**
	 *  5. 회원목록
	 * */
    public String list() {
    	String msg ="";
    	for(int i=0; i<count ; i++) {
    		msg += members[i].toString()+",\n ";
    	}
    	return msg;
    }
    	
    /**
	 *  6. 아이디검색
	 * */
	public MemberBean findById(String id) {
		MemberBean member = new MemberBean();
		for(int i=0; i<count; i++) {}
		return member;
	}
	}
	
	
	
