package test.progenies.mna.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.progenies.mna.controllers.test.TestController;

public class TestTest {

	@Test
	public void testHello() {
		TestController controller = new TestController();
        ModelAndView view = controller.hello(null, new ModelAndView());		
        Assert.assertEquals("hello", view.getViewName());
	}

}
