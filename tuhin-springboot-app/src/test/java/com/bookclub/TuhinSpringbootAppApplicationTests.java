package com.bookclub;

import com.bookclub.web.HomeController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

@SpringBootTest
class TuhinSpringbootAppApplicationTests {

	@Autowired
	private HomeController controller;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(controller);
	}

	@Test
	void testHomeController_showHome_returnsIndexViewAndPopulatesModel() {
		// Arrange
		Model model = new ExtendedModelMap();

		// Act
		String viewName = controller.showHome(model);

		// Assert
		Assertions.assertEquals("index", viewName, "Expected view name to be 'index'");
		Assertions.assertTrue(model.containsAttribute("books"), "Model should contain 'books' attribute");
		Assertions.assertNotNull(model.getAttribute("books"), "Books attribute should not be null");
	}

	@Test
	void testShowAboutUs_returnsAboutView() {
		// Arrange
		Model model = new ExtendedModelMap();

		// Act
		String viewName = controller.showAboutUs(model);

		// Assert
		Assertions.assertEquals("about", viewName, "Expected view name to be 'about'");
	}




}
