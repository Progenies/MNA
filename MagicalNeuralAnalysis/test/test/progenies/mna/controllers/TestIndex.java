package test.progenies.mna.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.progenies.mna.controllers.IndexController;

public class TestIndex {

	@Test
	public void testIndex() {
		IndexController controller = new IndexController();
        ModelAndView view = controller.handleRequest(new ModelAndView());		
        Assert.assertEquals("index", view.getViewName());
	}

}
