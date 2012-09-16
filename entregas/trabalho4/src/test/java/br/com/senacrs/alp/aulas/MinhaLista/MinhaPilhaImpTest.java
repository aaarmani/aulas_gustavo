package br.com.senacrs.alp.aulas.MinhaLista;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class MinhaPilhaImpTest {

	@Test
	public void testPush() {
		MinhaPilhaImp<Integer> pilha = new MinhaPilhaImp<Integer>();
		Integer i;
		Integer ret;
		final Integer MAX = 5;
		
		for(i = 0; i <= MAX; i++){
			pilha.push(i);
		}
		
		for(i = MAX; i > 0; i--){
			ret = pilha.pop();
			Assert.assertEquals(i, ret);
		}
	}

	@Test
	public void testPop() {
		fail("Not yet implemented");
	}

}
