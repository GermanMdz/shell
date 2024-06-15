package commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class NotFound extends Command{

    public NotFound(String cmd) {
        this.name = cmd;
    }

    @Override
    public void execute(String[] paths) {
        try {
            File file = this.fileExist(this.name, paths);
            
            Process process = createProcessToRead(file);
            printProccesOutput(process);
            process.waitFor();

        } catch (IOException | InterruptedException e) {
            System.out.printf("Error executing %s: %s\n", this.name, e.getMessage());
        } catch (Exception e) {
            System.out.printf("%s: command not found\n", this.name);
        }
    }

    private void printProccesOutput(Process process) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    private Process createProcessToRead(File file) throws IOException {
        ProcessBuilder pb = new ProcessBuilder(file.getAbsolutePath(), this.prop);
        Process process = pb.start();
        return process;
    }

    @Override
    public boolean isBiltin() {
        return false;
    }

}
