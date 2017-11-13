import java.util.StringTokenizer;

public class AnalysisVisitor implements Visitor{
	
	private int userTotal = 0;
	private int groupTotal = 0;
	private int messagesTotal = 0;
	private int positiveTotal = 0;
	private float positivePercentage = 0;

	@Override
	public void atUser(User u) {
		userTotal++;
	}

	@Override
	public void atUserGroup(UserGroup u) {
		groupTotal++;
	}

	@Override
	public void atPost(Post p) {
		messagesTotal++;
		// Count messages that have positive words
		// Create a StringTokenizer, pass it the message
		boolean isPositive = false;
		StringTokenizer tokenizer = new StringTokenizer(p.getMessage());
		System.out.println(p.getMessage());
		while (tokenizer.hasMoreTokens()) {
			// if there is a positive word, flag positive
			if (tokenizer.nextToken().equals("good")) {
				isPositive = true;
			}
		}
		// if we marked as positive, add to positive count
		if (isPositive) {
			positiveTotal++;
		}
	}
	
	public int getUserTotal() {
		return userTotal;
	}
	
	public int getGroupTotal() {
		return groupTotal;
	}
	
	public int getMessagesTotal() {
		return messagesTotal;
	}
	
	public float getPositivePercentage() {
		if(messagesTotal == 0) {
			return 0;
		}
		positivePercentage = (float) positiveTotal/ (float) messagesTotal * 100;
		return positivePercentage;
	}

}
