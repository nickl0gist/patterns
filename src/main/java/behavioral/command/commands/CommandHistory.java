package behavioral.command.commands;

import java.util.Stack;

/**
 * Created on 29.08.2022
 * @author Mykola Horkov
 * <br> mykola.horkov@gmail.com
 * <br> Stores Command History.
 */
public class CommandHistory {
        private Stack<Command> history = new Stack<>();

        public void push(Command c) {
            history.push(c);
        }

        public Command pop() {
            return history.pop();
        }

        public boolean isEmpty() { return history.isEmpty(); }
}
