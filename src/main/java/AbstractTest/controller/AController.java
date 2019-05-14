package AbstractTest.controller;

import AbstractTest.service.AService;
import AbstractTest.service.ObjectService;

public class AController extends AbstractController<EController<GController>, FController> {

	@Override
	public void a() {
		
	};
	
	
	public void c() {
		this.b();
	}

	private AService a;
	
	@Override
	public ObjectService getService() {
		return a;
	}

	
}
