package executions;

public class ExecutionError {
	public String message;

	public ExecutionError(String message) 
	{
		this.message = message;
	}
	
	public void Display() {
		System.out.println("Erreur rencontrée : " + message);
	}

}
