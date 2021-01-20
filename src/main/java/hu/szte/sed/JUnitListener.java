package hu.szte.sed;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class JUnitListener extends RunListener {

	private boolean fail = false;
	private final Controller controller = Controller.getInstance();

	@Override
	public void testStarted(Description description) throws Exception {
		controller.start();
	}

	@Override
	public void testFailure(Failure failure) throws Exception {
		fail = true;
	}

	@Override
	public void testFinished(Description description) throws Exception {
		controller.dump(getName(description) + "-" + (fail ? "FAIL" : "PASS"));

		fail = false;
	}

	private String getName(Description description) {
		final StringBuffer name = new StringBuffer();

		name.append(description.getClassName())
			.append('.')
			.append(description.getMethodName());

		return name.toString().replaceAll("[^a-zA-Z0-9_.-]+", "_");
	}

}
