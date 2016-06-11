package com.fprochazka.drill.model.drill;

import com.fprochazka.drill.IntegrationTestCase;
import com.fprochazka.drill.config.ApplicationConfig;
import com.fprochazka.drill.fixtures.DrillTestFixtures;
import com.fprochazka.drill.model.drill.question.Answer;
import com.fprochazka.drill.model.drill.question.QuestionFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michaela Bamburová on 11.06.2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationConfig.class)
public class QuestionFacadeTests extends IntegrationTestCase
{
	@Autowired
	private QuestionFacade questionFacade;

	@Test(expected = DrillNotFoundException.class)
	public void testCreateQuestionWithNullDrillThrowsException() throws DrillNotFoundException
	{
		List<Answer> answers = new ArrayList<>();
		Drill drill = new Drill("PB", "drill name");
		questionFacade.createQuestion("question 1", answers, drill.getId());
	}

	@Test(expected = DrillNotFoundException.class)
	public void testUpdateNullQuestionThrowsException() throws DrillNotFoundException
	{

		questionFacade.updateQuestion(null, "question 1", null);
	}

	@Test
	public void testUpdateCorrectQuestion() throws DrillNotFoundException
	{
		questionFacade.updateQuestion(DrillTestFixtures.drillMB104question1.getId(), "question 1", null);
	}
}
