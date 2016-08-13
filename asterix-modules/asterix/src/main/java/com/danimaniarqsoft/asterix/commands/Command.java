package com.danimaniarqsoft.asterix.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.CommandMarker;
import com.danimaniarqsoft.asterix.core.operations.AbstractCommandOperation;
import com.danimaniarqsoft.asterix.validators.MavenLayerValidator;

public abstract class Command implements CommandMarker {
	protected AbstractCommandOperation operation;
	@Autowired
	protected MavenLayerValidator mavenValidator;
}
