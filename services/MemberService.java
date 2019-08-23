package com.bitcamp.services;

import javax.swing.JOptionPane;

import com.bitcamp.domains.MemberBean;
/**
 * 요구사항 (기능정의)
 * <사용자기능>
 * 1. 회원가입
 * 2. 마이페이지
 * 3. 비번 수정
 * 4. 회원탈퇴
 * 5. 아이디 존재 체크
 * **********
 * <관리자기능>
 * 1. 회원목록
 * 2. 아이디검색
 * 3. 이름검색
 * 4. 전체 회원수
 * 
 **/
public class MemberService {
	private MemberBean[] members;
	private int count;
	
	public MemberService() {
		members = new MemberBean[10];
		count = 0;
	}
	/***************************************
	 *  사용자 기능 
	 * *************************************/
	
	
	/**
	 *  1. 회원가입
	 * */
	public String join(MemberBean param) {
		String msg = "회원가입 성공";
		members[count] = param;
		count++;
		return msg;
		
	}
	/**
	 *  2. 마이 페이지
	 * */
	public String getMyPage(MemberBean param) {
		return param.toString();
	}
	
	/**
	 *  3. 비번 수정(ID, 옛날비번, 신규비번 입력받아서 옛날비번을 체크 후 일치하면 신규비번으로 변경)
	 *  비번 변경후 로그인을 실행해서 새로 바뀌 비번이 로그인 성공, 옛날 비번 로그인 실패
	 * */
	public String changePassword(MemberBean param) {
		String msg = "비밀번호 변경완료";
		String id = param.getId();
		String pw = param.getPw();
		String[] pws = pw.split(",");
		String oldPw = pws[0];
		String newPw = pws[1];
		for(int i=0; i < count; i++) {
			if(id.equals(members[i].getId())
					&& oldPw.equals(members[i].getPw())) {
						members[i].setPw(newPw);
						break;
					}
		}
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
	 * 5. 아이디 체크
	 */
	public String existId(String id) {
		String msg = "가입 가능한 아이디 입니다.";
		for(int i=0; i<count; i++) {
			if(id.equals(members[i].getId())) {
				msg = "이미 존재하는 아이디 입니다.";
						break;
			}
		}
				
		return msg;
	}
		/**
		 * 5. 로그인 (파라미터로 Id, Pw만 입력받은 상태)
		 */
	public String login(MemberBean param) {
		String msg = "로그인 실패";
		String id = param.getId();
		String pw = param.getPw();
		for (int i = 0; i < count; i++) {
			if (param.getId().equals(members[i].getId()) && param.getPw().equals(members[i].getPw())) {
				msg = "로그인 성공";
				break;

			}

		}
		return msg;
	}
	//}
    	   
    
    /*****************************************************
     * 관리자 기능
     * ***************************************************/
    
    /**
	 *  1. 회원목록
	 * */
    public String list() {
    	String msg ="";
    	for(int i=0; i<count ; i++) {    		
    		msg += members[i].toString()+",\n ";
    	}
    	return msg;
    }
    	
    /**
	 *  2. 아이디검색
	 * */
	public MemberBean findById(String id) {   
		MemberBean member = new MemberBean();
		for(int i=0; i<count; i++) {
			if(id.equals(this.members[i].getId())) {
				member = this.members[i];
				
				break;
			}                               
		}                                    
		return member;
	}
	/**
	 *  3. 이름검색
	* */
		
	public MemberBean[] findByName(String name) {
		int j = 0;
		for(int i = 0; i< count; i++) {
			if(name.equals(this.members[i].getName())) {
				j++;
			}
		
		}
		MemberBean[] members = new MemberBean[j];
		j = 0;
		for(int i=0; i<count; i++) {
			if(name.equals(this.members[i].getName())) {
				members[j] = this.members[i];
				j++;
				
			if(members.length == j) {
					
					break;
				
				}
			}
			members[i] = this.members[i];			
			
			}	
			
		
		return members;
	}
	
	public String countAll() {
		return "총회원수" + count;
	}
	}


	
	
	
