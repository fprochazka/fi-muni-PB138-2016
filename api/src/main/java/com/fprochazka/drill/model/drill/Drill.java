package com.fprochazka.drill.model.drill;

import com.fprochazka.drill.model.Identified;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "drills")
@TypeAlias("drill")
public class Drill extends Identified
{

	private final String name;

	public Drill(String name)
	{
		super();
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

}
