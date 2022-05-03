package com.deustocine.dao;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.junit.Before;
import org.mockito.Mock;

import com.deustocine.app.dao.CineDAO;
import com.deustocine.app.domain.Cine;

public class CineDAOTest {
	@Mock
	PersistenceManagerFactory pmf;
	@Mock
	PersistenceManager pm;
	@Mock
	Transaction ts;
	
	CineDAO cdao;
	Cine c;
	
	@Before
	public void setup() {
		cdao = new CineDAO();
		cdao.setPmf(pmf);
		c= new Cine();
		c.setPrecio(5);
	}

	

}
