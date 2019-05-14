package AbstractTest.controller;

import AbstractTest.service.ObjectService;

public abstract class AbstractController<CController extends EController<GController>,DController extends FController> {
	
	
	public abstract void a();
	
	public abstract ObjectService getService();
	
	protected void b() {
		this.a();
	};
	
	public void testService () {
		getService().test();
	}
	

}
