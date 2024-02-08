package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.exception.InvalidArgumentException;


/**
 * Represents the command to find a task by searching for a keyword.
 */
public class FindCommand extends Command {

    private String arguments;


    /**
     * Constructor for FindCommand.
     *
     * @param arguments Arguments for command.
     */
    public FindCommand(String arguments) {
        this.arguments = arguments;
    }


    /**
     * Executed the find command and generates the response.
     *
     * @param taskList List of tasks.
     * @param ui User Interface of chatbot.
     * @param storage Storage that stores data.
     * @return The reply to the user's input.
     * @throws InvalidArgumentException If command has invalid or missing arguments.
     */
    @Override
    public String generateReply(TaskList taskList, Ui ui, Storage storage) throws InvalidArgumentException {
        try {
            TaskList filteredList = taskList.filter(this.arguments);
            return ui.findTask(filteredList);

        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidArgumentException("TODO");
        }
    }
}
