package com.fulijisuanqi04.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import com.fulijisuanqi04.swing.calcutor;

public class calculatorTest {

	
	@Test
	public void testYuehuankuan() {
		calcutor cutor = new calcutor();
		double str1 = cutor.yuehuankuan(100000, 0.05, 10);
		assertThat(str1, is(1060.0));
	}

	@Test
	public void testNianxian() {
		calcutor cutor = new calcutor();
		double str2 = cutor.nianxian(220000, 0.03, 100000);
		assertThat(str2, is(27.0));
	}

	@Test
	public void testLilv() {
		calcutor cutor = new calcutor();
		double str2 = cutor.lilv(200000, 30, 100000);
		assertThat(str2, is(0.02));
	}

	@Test
	public void testBenjin() {
		calcutor cutor = new calcutor();
		double str2 = cutor.benjin(3000000, 0.05, 20);
		assertThat(str2, is(1130668.0));
	}

	@Test
	public void testZhongzhiDoubleDoubleDouble() {
		calcutor cutor = new calcutor();
		double str2 = cutor.zhongzhi(100000, 0.03, 30);
		assertThat(str2, is(190000.0));
	}

	@Test
	public void testZhongzhiDoubleDoubleDoubleDouble() {
		calcutor cutor = new calcutor();
		double str2 = cutor.zhongzhi(100000, 0.03, 30, 0);
		assertThat(str2, is(242726.0));
	}

}
