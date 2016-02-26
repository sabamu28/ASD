package edu.mum.cs.cs525.project.Framework.Commands;


public class CommandManager {
	
	private static CommandManager instance = new CommandManager();
	
	//private Stack<ICommand> commandsList;

	//private CommandManager() {
	//	commandsList = new Stack<ICommand>();
	//}
	
	public static CommandManager getInstance() {
		
		if (instance == null)
			instance = new CommandManager();
		
		return instance;
	}
	
	public void submit(ICommand command) {
		System.out.println("CommandManager work for :"+command.getClass().getName());
		//commandsList.push(command);
		command.execute();
	}
}
