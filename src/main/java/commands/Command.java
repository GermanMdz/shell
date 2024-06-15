package commands;

import java.io.File;

public abstract class Command {

    protected String name;
    protected String prop;
    protected String type;

    public abstract void execute(String[] paths);

    public void setProp(String input) {
        this.prop = input;
    }

    public boolean isBiltin() {
        return true;
    }

    protected File fileExist(String name, String[] paths) throws Exception {
        for (String p : paths) {
            File file = new File(p, name);
            if (file.exists()) return file;
        }
        throw new Exception(name);
    }

}
