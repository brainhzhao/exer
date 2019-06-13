package priv.zh.resolvemessage;

import java.util.ArrayList;
import java.util.List;

public class ServiceExecute {
    private List<IServiceHandleCommand> commands = new ArrayList<IServiceHandleCommand>();


    public void addService(IServiceHandleCommand command){
        commands.add(command);
    }

    public void execute(){
        for(IServiceHandleCommand serviceCommand : commands){
            serviceCommand.execute();
        }
    }
}