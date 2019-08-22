package com.bitcamp.domains;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

public class SubjectBean {
	private int kor, eng, math;
    
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	public int getKor() {
		return kor;
	}
	
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public int getEng() {
		return eng;
	}
	
	public void setMath(int math) {
		this.math = math;
	}
	public int getMath() {
		return math;
	}
	@Override
	public String toString() {
		
		return String.format("%s국어점수 %s영어점수 %s수학점수", kor, eng, math);
	}
	
}
