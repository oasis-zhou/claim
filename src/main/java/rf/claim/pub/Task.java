package rf.claim.pub;

import java.util.Map;

public interface Task<T> {
	
	public void execute(T t, Map<String, Object> context);

}
