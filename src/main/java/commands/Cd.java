package commands;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cd extends Command{

    public Cd() {
        this.name = "cd";
        this.type = "builtin";
    }


    @Override
    public void execute(String[] paths) {
        Path newPath = Paths.get(this.prop).toAbsolutePath();
        File dir = newPath.toFile();
        if (dir.exists() && dir.isDirectory()) {
            System.setProperty("user.dir", dir.getAbsolutePath());
        } else {
            System.out.printf("%s: %s: No such file or directory\n", this.name, this.prop);
        }
    }

}
