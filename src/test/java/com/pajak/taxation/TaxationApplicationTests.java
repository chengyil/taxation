package com.pajak.taxation;

import com.pajak.taxation.controllers.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HomeController.class)
class TaxationApplicationTests {

    @Autowired
	private MockMvc mockMvc;

	public void testAssessmentForm() throws Exception {
	    mockMvc.perform(MockMvcRequestBuilders.get("/")).
				andExpect(status().isOk());
	}

}
