package hu.szte.sed;

import java.io.IOException;

import org.jacoco.agent.rt.IAgent;
import org.jacoco.agent.rt.RT;

public class Controller {

	private final IAgent agent;
	private boolean started;

	private static Controller instance;

	private Controller() {
		agent = RT.getAgent();
	}

	public synchronized void start() {
		if (started) {
			throw new Error("Tests are running in parallel in the same JVM.");
		}

		started = true;

		agent.reset();
	}

	public synchronized void dump(String name) throws IOException {
		started = false;

		agent.setSessionId(name);
		agent.dump(true);
	}

	public static synchronized Controller getInstance() {
		if (instance == null) {
			instance = new Controller();
		}

		return instance;
	}

}
