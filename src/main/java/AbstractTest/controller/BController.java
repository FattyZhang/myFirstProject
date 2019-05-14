package AbstractTest.controller;

import AbstractTest.service.BService;
import AbstractTest.service.ObjectService;

public class BController extends AbstractController<EController<GController>, FController>{

	@Override
	public void a() {
		
	}

	private BService b;
	
	@Override
	public ObjectService getService() {
		return b;
	}

	

}
