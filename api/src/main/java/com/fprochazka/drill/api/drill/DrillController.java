package com.fprochazka.drill.api.drill;

import com.fprochazka.drill.model.drill.Drill;
import com.fprochazka.drill.model.drill.DrillFacade;
import com.fprochazka.drill.model.drill.DrillRepository;
import com.fprochazka.drill.model.exceptions.DrillCodeNotUniqueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
public class DrillController
{

	private DrillFacade drillFacade;
	private DrillRepository drillRepository;
	private DrillResponseFactory drillResponseFactory;

	@Autowired
	public DrillController(
		DrillFacade drillFacade,
		DrillRepository drillRepository,
		DrillResponseFactory drillResponseFactory
	)
	{
		this.drillFacade = drillFacade;
		this.drillRepository = drillRepository;
		this.drillResponseFactory = drillResponseFactory;
	}

	/**
	 * Function, that gives response object of all drills in the database.
	 *
	 * @return response for all found drills
	 */
	@RequestMapping(value = "/drill", method = RequestMethod.GET)
	public @ResponseBody Collection<DrillResponse> getAllDrills()
	{
		Iterable<Drill> drills = drillRepository.findAll();
		return drillResponseFactory.createDrillsResponse(drills);
	}

	/**
	 * Function, that returns the drill in database with given ID.
	 * If the ID is not given or do not corresponds to any drill in database, function throws exception.
	 *
	 * @return drill - object of type Drill with given id, null if drill with the id does not exist
	 */
	@RequestMapping(value = "/drill/{drillId}", method = RequestMethod.GET)
	public @ResponseBody DrillResponse getDrillById(
		@PathVariable("drillId") UUID drillId
	)
	{
		Drill drill = drillRepository.getDrillById(drillId);
		if (drill == null) {
			// todo: error
		}
		return drillResponseFactory.createDrillResponse(drill);
	}

	/**
	 * Create new drill based on the create drill request
	 * and save it to the database.
	 *
	 * @param createDrillRequest
	 * @return drill response of the new drill
	 */
	@RequestMapping(value = "/drill", method = RequestMethod.POST)
	public DrillResponse createDrill(
		@RequestBody CreateDrillRequest createDrillRequest
	) throws DrillCodeNotUniqueException
	{
		Drill drill = drillFacade.createDrill("nemam", createDrillRequest.getName());

		return drillResponseFactory.createDrillResponse(drill);
	}
}