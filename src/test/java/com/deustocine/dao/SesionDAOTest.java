package com.deustocine.dao;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.junit.Before;
import org.mockito.Mock;

import com.deustocine.app.dao.SesionDAO;
import com.deustocine.app.domain.Sesion;

public class SesionDAOTest {
	@Mock
	PersistenceManagerFactory pmf;
	@Mock
	PersistenceManager pm;
	@Mock
	Transaction ts;
	
	SesionDAO sdao;
	Sesion s;
	
	@Before
	public void setup() {
		sdao = new SesionDAO();
		sdao.setPmf(pmf);
		s= new Sesion();
		s.setPrecio(5);
	}

	

}
